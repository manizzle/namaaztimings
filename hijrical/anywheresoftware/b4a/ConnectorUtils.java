package anywheresoftware.b4a;

import android.graphics.Color;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;

public class ConnectorUtils
{
  public static final byte BOOL = 5;
  public static final byte CACHED_STRING = 9;
  public static final byte COLOR = 6;
  public static final byte ENDOFMAP = 4;
  public static final byte FLOAT = 7;
  public static final byte INT = 1;
  public static final byte MAP = 3;
  public static final byte SCALED_INT = 8;
  public static final byte STRING = 2;
  private static Charset charset = Charset.forName("UTF8");
  private static ThreadLocal<ByteBuffer> myBb = new ThreadLocal()
  {
    protected ByteBuffer initialValue()
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(51200);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      return localByteBuffer;
    }
  };

  public static void mark()
  {
    ((ByteBuffer)myBb.get()).mark();
  }

  private static String readCacheString(DataInputStream paramDataInputStream, String[] paramArrayOfString)
    throws IOException
  {
    if (paramArrayOfString == null)
      return readString(paramDataInputStream);
    return paramArrayOfString[readInt(paramDataInputStream)];
  }

  public static int readInt(DataInputStream paramDataInputStream)
    throws IOException
  {
    return Integer.reverseBytes(paramDataInputStream.readInt());
  }

  public static HashMap<String, Object> readMap(DataInputStream paramDataInputStream, String[] paramArrayOfString)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    String str = readCacheString(paramDataInputStream, paramArrayOfString);
    int i = paramDataInputStream.readByte();
    Object localObject;
    if (i == 1)
      localObject = Integer.valueOf(readInt(paramDataInputStream));
    while (true)
    {
      localHashMap.put(str, localObject);
      break;
      if (i == 9)
      {
        localObject = readCacheString(paramDataInputStream, paramArrayOfString);
      }
      else if (i == 2)
      {
        localObject = readString(paramDataInputStream);
      }
      else if (i == 7)
      {
        localObject = Float.valueOf(Float.intBitsToFloat(readInt(paramDataInputStream)));
      }
      else if (i == 3)
      {
        localObject = readMap(paramDataInputStream, paramArrayOfString);
      }
      else
      {
        if (i == 5)
        {
          if (paramDataInputStream.readByte() == 1);
          for (boolean bool = true; ; bool = false)
          {
            localObject = Boolean.valueOf(bool);
            break;
          }
        }
        if (i != 6)
          break label183;
        localObject = Integer.valueOf(Color.argb(paramDataInputStream.readUnsignedByte(), paramDataInputStream.readUnsignedByte(), paramDataInputStream.readUnsignedByte(), paramDataInputStream.readUnsignedByte()));
      }
    }
    label183: if (i == 4)
      return localHashMap;
    throw new RuntimeException("unknown type");
  }

  public static String readString(DataInputStream paramDataInputStream)
    throws IOException
  {
    int i = readInt(paramDataInputStream);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramDataInputStream.readFully(localByteBuffer.array());
    localByteBuffer.limit(i);
    return charset.decode(localByteBuffer).toString();
  }

  public static void resetToMark()
  {
    ((ByteBuffer)myBb.get()).reset();
  }

  public static void sendMessage(ConnectorConsumer paramConnectorConsumer)
  {
    if (paramConnectorConsumer == null)
      return;
    ByteBuffer localByteBuffer = (ByteBuffer)myBb.get();
    localByteBuffer.flip();
    byte[] arrayOfByte;
    int i;
    int j;
    if (paramConnectorConsumer.shouldAddPrefix())
    {
      arrayOfByte = new byte[4 + localByteBuffer.limit()];
      i = arrayOfByte.length - 4;
      localByteBuffer.get(arrayOfByte, 4, i);
      j = 0;
      if (j <= 3);
    }
    while (true)
    {
      paramConnectorConsumer.putTask(arrayOfByte);
      return;
      arrayOfByte[j] = ((byte)(i & 0xFF));
      i >>= 8;
      j++;
      break;
      arrayOfByte = new byte[localByteBuffer.limit()];
      localByteBuffer.get(arrayOfByte);
    }
  }

  public static ByteBuffer startMessage(byte paramByte)
  {
    ByteBuffer localByteBuffer = (ByteBuffer)myBb.get();
    localByteBuffer.clear();
    localByteBuffer.put(paramByte);
    return localByteBuffer;
  }

  public static void writeFloat(float paramFloat)
  {
    ((ByteBuffer)myBb.get()).putFloat(paramFloat);
  }

  public static void writeInt(int paramInt)
  {
    ((ByteBuffer)myBb.get()).putInt(paramInt);
  }

  public static boolean writeString(String paramString)
  {
    if (paramString == null)
      paramString = "";
    if (paramString.length() > 700)
      paramString = paramString.substring(0, 699) + "......";
    ByteBuffer localByteBuffer1 = (ByteBuffer)myBb.get();
    int i = localByteBuffer1.position();
    ByteBuffer localByteBuffer2 = charset.encode(paramString);
    if (localByteBuffer1.remaining() - localByteBuffer2.remaining() < 1000)
      return false;
    localByteBuffer1.putInt(0);
    localByteBuffer1.put(localByteBuffer2);
    localByteBuffer1.putInt(i, localByteBuffer1.position() - i - 4);
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.ConnectorUtils
 * JD-Core Version:    0.6.2
 */