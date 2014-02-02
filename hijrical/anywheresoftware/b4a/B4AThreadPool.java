package anywheresoftware.b4a;

import android.os.Handler;
import java.util.Collection;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class B4AThreadPool
{
  private static final int THREADS_SPARE = 5;
  private final WeakHashMap<Object, ConcurrentHashMap<Integer, Future<?>>> futures = new WeakHashMap();
  private ThreadPoolExecutor pool = new ThreadPoolExecutor(0, 50, 60L, TimeUnit.SECONDS, new SynchronousQueue())
  {
    protected void afterExecute(Runnable paramAnonymousRunnable, Throwable paramAnonymousThrowable)
    {
      for (int i = 0; ; i++)
      {
        if (i >= 1)
          return;
        B4AThreadPool.QueuedTask localQueuedTask = (B4AThreadPool.QueuedTask)B4AThreadPool.this.queueOfTasks.poll();
        if (localQueuedTask != null)
          BA.handler.post(localQueuedTask);
      }
    }
  };
  private final ConcurrentLinkedQueue<QueuedTask> queueOfTasks = new ConcurrentLinkedQueue();

  public B4AThreadPool()
  {
    this.pool.setThreadFactory(new MyThreadFactory(null));
  }

  private void submitToPool(Runnable paramRunnable, Object paramObject, int paramInt)
  {
    while (true)
    {
      Iterator localIterator;
      try
      {
        localFuture = this.pool.submit(paramRunnable);
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        synchronized (this.futures)
        {
          Future localFuture;
          ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.futures.get(paramObject);
          if (localConcurrentHashMap == null)
          {
            localConcurrentHashMap = new ConcurrentHashMap();
            this.futures.put(paramObject, localConcurrentHashMap);
          }
          localIterator = localConcurrentHashMap.values().iterator();
          if (!localIterator.hasNext())
          {
            localConcurrentHashMap.put(Integer.valueOf(paramInt), localFuture);
            return;
            localRejectedExecutionException = localRejectedExecutionException;
            try
            {
              Thread.sleep(100L);
              submitToPool(paramRunnable, paramObject, paramInt);
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
              continue;
            }
          }
        }
      }
      if (((Future)localIterator.next()).isDone())
        localIterator.remove();
    }
  }

  public boolean isRunning(Object paramObject, int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.futures.get(paramObject);
    if (localConcurrentHashMap == null)
      return false;
    Future localFuture = (Future)localConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localFuture == null)
      return false;
    return !localFuture.isDone();
  }

  public void markTaskAsFinished(Object paramObject, int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.futures.get(paramObject);
    if (localConcurrentHashMap == null)
      return;
    localConcurrentHashMap.remove(Integer.valueOf(paramInt));
  }

  public void submit(Runnable paramRunnable, Object paramObject, int paramInt)
  {
    if (this.pool.getActiveCount() > this.pool.getMaximumPoolSize() - 5)
    {
      this.queueOfTasks.add(new QueuedTask(paramRunnable, paramObject, paramInt));
      return;
    }
    submitToPool(paramRunnable, paramObject, paramInt);
  }

  private static class MyThreadFactory
    implements ThreadFactory
  {
    private final ThreadFactory defaultFactory = Executors.defaultThreadFactory();

    public Thread newThread(Runnable paramRunnable)
    {
      Thread localThread = this.defaultFactory.newThread(paramRunnable);
      localThread.setDaemon(true);
      return localThread;
    }
  }

  class QueuedTask
    implements Runnable
  {
    final Object container;
    final Runnable task;
    final int taskId;

    public QueuedTask(Runnable paramObject, Object paramInt, int arg4)
    {
      this.task = paramObject;
      this.container = paramInt;
      int i;
      this.taskId = i;
    }

    public void run()
    {
      if (B4AThreadPool.this.pool.getActiveCount() > B4AThreadPool.this.pool.getMaximumPoolSize() - 5)
      {
        BA.handler.postDelayed(this, 50L);
        return;
      }
      B4AThreadPool.this.submitToPool(this.task, this.container, this.taskId);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.B4AThreadPool
 * JD-Core Version:    0.6.2
 */