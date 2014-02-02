package anywheresoftware.b4a.objects;

import android.app.Application;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import java.io.FileInputStream;
import java.io.IOException;

@BA.ShortName("MediaPlayer")
public class MediaPlayerWrapper
{
  protected String eventName;
  protected MediaPlayer mp;

  public void Initialize()
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this.mp = new MediaPlayer();
  }

  public void Initialize2(final BA paramBA, String paramString)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    Initialize();
    this.eventName = paramString.toLowerCase(BA.cul);
    this.mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        paramBA.raiseEvent(MediaPlayerWrapper.this, MediaPlayerWrapper.this.eventName + "_complete", new Object[0]);
      }
    });
  }

  public boolean IsPlaying()
  {
    return this.mp.isPlaying();
  }

  public void Load(String paramString1, String paramString2)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this.mp.reset();
    AssetFileDescriptor localAssetFileDescriptor2;
    if (paramString1.equals(anywheresoftware.b4a.objects.streams.File.getDirAssets()))
    {
      localAssetFileDescriptor2 = BA.applicationContext.getAssets().openFd(paramString2.toLowerCase(BA.cul));
      if (localAssetFileDescriptor2.getDeclaredLength() < 0L)
        this.mp.setDataSource(localAssetFileDescriptor2.getFileDescriptor());
    }
    while (true)
    {
      this.mp.prepare();
      return;
      this.mp.setDataSource(localAssetFileDescriptor2.getFileDescriptor(), localAssetFileDescriptor2.getStartOffset(), localAssetFileDescriptor2.getDeclaredLength());
      continue;
      if ((paramString1.equals(anywheresoftware.b4a.objects.streams.File.getDirInternal())) || (paramString1.equals(anywheresoftware.b4a.objects.streams.File.getDirInternalCache())))
      {
        FileInputStream localFileInputStream = new FileInputStream(new java.io.File(paramString1, paramString2));
        this.mp.setDataSource(localFileInputStream.getFD());
      }
      else if (paramString1.equals("ContentDir"))
      {
        AssetFileDescriptor localAssetFileDescriptor1 = BA.applicationContext.getContentResolver().openAssetFileDescriptor(Uri.parse(paramString2), "r");
        if (localAssetFileDescriptor1.getDeclaredLength() < 0L)
          this.mp.setDataSource(localAssetFileDescriptor1.getFileDescriptor());
        else
          this.mp.setDataSource(localAssetFileDescriptor1.getFileDescriptor(), localAssetFileDescriptor1.getStartOffset(), localAssetFileDescriptor1.getDeclaredLength());
      }
      else
      {
        this.mp.setDataSource(new java.io.File(paramString1, paramString2).toString());
      }
    }
  }

  public void Pause()
  {
    this.mp.pause();
  }

  public void Play()
  {
    this.mp.start();
  }

  public void Release()
  {
    this.mp.release();
  }

  public void SetVolume(float paramFloat1, float paramFloat2)
  {
    this.mp.setVolume(paramFloat1, paramFloat2);
  }

  public void Stop()
  {
    this.mp.reset();
  }

  public int getDuration()
  {
    return this.mp.getDuration();
  }

  public boolean getLooping()
  {
    return this.mp.isLooping();
  }

  public int getPosition()
  {
    return this.mp.getCurrentPosition();
  }

  public void setLooping(boolean paramBoolean)
  {
    this.mp.setLooping(paramBoolean);
  }

  public void setPosition(int paramInt)
  {
    this.mp.seekTo(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.MediaPlayerWrapper
 * JD-Core Version:    0.6.2
 */