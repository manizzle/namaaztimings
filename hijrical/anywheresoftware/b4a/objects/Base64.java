package anywheresoftware.b4a.objects;

import anywheresoftware.b4a.BA.Hide;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

@BA.Hide
public class Base64
{
  public static final int DECODE = 0;
  public static final int DONT_GUNZIP = 4;
  public static final int DO_BREAK_LINES = 8;
  public static final int ENCODE = 1;
  private static final byte EQUALS_SIGN = 61;
  private static final byte EQUALS_SIGN_ENC = -1;
  public static final int GZIP = 2;
  private static final int MAX_LINE_LENGTH = 76;
  private static final byte NEW_LINE = 10;
  public static final int NO_OPTIONS = 0;
  public static final int ORDERED = 32;
  private static final String PREFERRED_ENCODING = "US-ASCII";
  public static final int URL_SAFE = 16;
  private static final byte WHITE_SPACE_ENC = -5;
  private static final byte[] _ORDERED_ALPHABET;
  private static final byte[] _ORDERED_DECODABET;
  private static final byte[] _STANDARD_ALPHABET;
  private static final byte[] _STANDARD_DECODABET;
  private static final byte[] _URL_SAFE_ALPHABET;
  private static final byte[] _URL_SAFE_DECODABET;

  static
  {
    if (!Base64.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      _STANDARD_ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      byte[] arrayOfByte1 = new byte[256];
      arrayOfByte1[0] = -9;
      arrayOfByte1[1] = -9;
      arrayOfByte1[2] = -9;
      arrayOfByte1[3] = -9;
      arrayOfByte1[4] = -9;
      arrayOfByte1[5] = -9;
      arrayOfByte1[6] = -9;
      arrayOfByte1[7] = -9;
      arrayOfByte1[8] = -9;
      arrayOfByte1[9] = -5;
      arrayOfByte1[10] = -5;
      arrayOfByte1[11] = -9;
      arrayOfByte1[12] = -9;
      arrayOfByte1[13] = -5;
      arrayOfByte1[14] = -9;
      arrayOfByte1[15] = -9;
      arrayOfByte1[16] = -9;
      arrayOfByte1[17] = -9;
      arrayOfByte1[18] = -9;
      arrayOfByte1[19] = -9;
      arrayOfByte1[20] = -9;
      arrayOfByte1[21] = -9;
      arrayOfByte1[22] = -9;
      arrayOfByte1[23] = -9;
      arrayOfByte1[24] = -9;
      arrayOfByte1[25] = -9;
      arrayOfByte1[26] = -9;
      arrayOfByte1[27] = -9;
      arrayOfByte1[28] = -9;
      arrayOfByte1[29] = -9;
      arrayOfByte1[30] = -9;
      arrayOfByte1[31] = -9;
      arrayOfByte1[32] = -5;
      arrayOfByte1[33] = -9;
      arrayOfByte1[34] = -9;
      arrayOfByte1[35] = -9;
      arrayOfByte1[36] = -9;
      arrayOfByte1[37] = -9;
      arrayOfByte1[38] = -9;
      arrayOfByte1[39] = -9;
      arrayOfByte1[40] = -9;
      arrayOfByte1[41] = -9;
      arrayOfByte1[42] = -9;
      arrayOfByte1[43] = 62;
      arrayOfByte1[44] = -9;
      arrayOfByte1[45] = -9;
      arrayOfByte1[46] = -9;
      arrayOfByte1[47] = 63;
      arrayOfByte1[48] = 52;
      arrayOfByte1[49] = 53;
      arrayOfByte1[50] = 54;
      arrayOfByte1[51] = 55;
      arrayOfByte1[52] = 56;
      arrayOfByte1[53] = 57;
      arrayOfByte1[54] = 58;
      arrayOfByte1[55] = 59;
      arrayOfByte1[56] = 60;
      arrayOfByte1[57] = 61;
      arrayOfByte1[58] = -9;
      arrayOfByte1[59] = -9;
      arrayOfByte1[60] = -9;
      arrayOfByte1[61] = -1;
      arrayOfByte1[62] = -9;
      arrayOfByte1[63] = -9;
      arrayOfByte1[64] = -9;
      arrayOfByte1[66] = 1;
      arrayOfByte1[67] = 2;
      arrayOfByte1[68] = 3;
      arrayOfByte1[69] = 4;
      arrayOfByte1[70] = 5;
      arrayOfByte1[71] = 6;
      arrayOfByte1[72] = 7;
      arrayOfByte1[73] = 8;
      arrayOfByte1[74] = 9;
      arrayOfByte1[75] = 10;
      arrayOfByte1[76] = 11;
      arrayOfByte1[77] = 12;
      arrayOfByte1[78] = 13;
      arrayOfByte1[79] = 14;
      arrayOfByte1[80] = 15;
      arrayOfByte1[81] = 16;
      arrayOfByte1[82] = 17;
      arrayOfByte1[83] = 18;
      arrayOfByte1[84] = 19;
      arrayOfByte1[85] = 20;
      arrayOfByte1[86] = 21;
      arrayOfByte1[87] = 22;
      arrayOfByte1[88] = 23;
      arrayOfByte1[89] = 24;
      arrayOfByte1[90] = 25;
      arrayOfByte1[91] = -9;
      arrayOfByte1[92] = -9;
      arrayOfByte1[93] = -9;
      arrayOfByte1[94] = -9;
      arrayOfByte1[95] = -9;
      arrayOfByte1[96] = -9;
      arrayOfByte1[97] = 26;
      arrayOfByte1[98] = 27;
      arrayOfByte1[99] = 28;
      arrayOfByte1[100] = 29;
      arrayOfByte1[101] = 30;
      arrayOfByte1[102] = 31;
      arrayOfByte1[103] = 32;
      arrayOfByte1[104] = 33;
      arrayOfByte1[105] = 34;
      arrayOfByte1[106] = 35;
      arrayOfByte1[107] = 36;
      arrayOfByte1[108] = 37;
      arrayOfByte1[109] = 38;
      arrayOfByte1[110] = 39;
      arrayOfByte1[111] = 40;
      arrayOfByte1[112] = 41;
      arrayOfByte1[113] = 42;
      arrayOfByte1[114] = 43;
      arrayOfByte1[115] = 44;
      arrayOfByte1[116] = 45;
      arrayOfByte1[117] = 46;
      arrayOfByte1[118] = 47;
      arrayOfByte1[119] = 48;
      arrayOfByte1[120] = 49;
      arrayOfByte1[121] = 50;
      arrayOfByte1[122] = 51;
      arrayOfByte1[123] = -9;
      arrayOfByte1[124] = -9;
      arrayOfByte1[125] = -9;
      arrayOfByte1[126] = -9;
      arrayOfByte1[127] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[''] = -9;
      arrayOfByte1[' '] = -9;
      arrayOfByte1['¡'] = -9;
      arrayOfByte1['¢'] = -9;
      arrayOfByte1['£'] = -9;
      arrayOfByte1['¤'] = -9;
      arrayOfByte1['¥'] = -9;
      arrayOfByte1['¦'] = -9;
      arrayOfByte1['§'] = -9;
      arrayOfByte1['¨'] = -9;
      arrayOfByte1['©'] = -9;
      arrayOfByte1['ª'] = -9;
      arrayOfByte1['«'] = -9;
      arrayOfByte1['¬'] = -9;
      arrayOfByte1['­'] = -9;
      arrayOfByte1['®'] = -9;
      arrayOfByte1['¯'] = -9;
      arrayOfByte1['°'] = -9;
      arrayOfByte1['±'] = -9;
      arrayOfByte1['²'] = -9;
      arrayOfByte1['³'] = -9;
      arrayOfByte1['´'] = -9;
      arrayOfByte1['µ'] = -9;
      arrayOfByte1['¶'] = -9;
      arrayOfByte1['·'] = -9;
      arrayOfByte1['¸'] = -9;
      arrayOfByte1['¹'] = -9;
      arrayOfByte1['º'] = -9;
      arrayOfByte1['»'] = -9;
      arrayOfByte1['¼'] = -9;
      arrayOfByte1['½'] = -9;
      arrayOfByte1['¾'] = -9;
      arrayOfByte1['¿'] = -9;
      arrayOfByte1['À'] = -9;
      arrayOfByte1['Á'] = -9;
      arrayOfByte1['Â'] = -9;
      arrayOfByte1['Ã'] = -9;
      arrayOfByte1['Ä'] = -9;
      arrayOfByte1['Å'] = -9;
      arrayOfByte1['Æ'] = -9;
      arrayOfByte1['Ç'] = -9;
      arrayOfByte1['È'] = -9;
      arrayOfByte1['É'] = -9;
      arrayOfByte1['Ê'] = -9;
      arrayOfByte1['Ë'] = -9;
      arrayOfByte1['Ì'] = -9;
      arrayOfByte1['Í'] = -9;
      arrayOfByte1['Î'] = -9;
      arrayOfByte1['Ï'] = -9;
      arrayOfByte1['Ð'] = -9;
      arrayOfByte1['Ñ'] = -9;
      arrayOfByte1['Ò'] = -9;
      arrayOfByte1['Ó'] = -9;
      arrayOfByte1['Ô'] = -9;
      arrayOfByte1['Õ'] = -9;
      arrayOfByte1['Ö'] = -9;
      arrayOfByte1['×'] = -9;
      arrayOfByte1['Ø'] = -9;
      arrayOfByte1['Ù'] = -9;
      arrayOfByte1['Ú'] = -9;
      arrayOfByte1['Û'] = -9;
      arrayOfByte1['Ü'] = -9;
      arrayOfByte1['Ý'] = -9;
      arrayOfByte1['Þ'] = -9;
      arrayOfByte1['ß'] = -9;
      arrayOfByte1['à'] = -9;
      arrayOfByte1['á'] = -9;
      arrayOfByte1['â'] = -9;
      arrayOfByte1['ã'] = -9;
      arrayOfByte1['ä'] = -9;
      arrayOfByte1['å'] = -9;
      arrayOfByte1['æ'] = -9;
      arrayOfByte1['ç'] = -9;
      arrayOfByte1['è'] = -9;
      arrayOfByte1['é'] = -9;
      arrayOfByte1['ê'] = -9;
      arrayOfByte1['ë'] = -9;
      arrayOfByte1['ì'] = -9;
      arrayOfByte1['í'] = -9;
      arrayOfByte1['î'] = -9;
      arrayOfByte1['ï'] = -9;
      arrayOfByte1['ð'] = -9;
      arrayOfByte1['ñ'] = -9;
      arrayOfByte1['ò'] = -9;
      arrayOfByte1['ó'] = -9;
      arrayOfByte1['ô'] = -9;
      arrayOfByte1['õ'] = -9;
      arrayOfByte1['ö'] = -9;
      arrayOfByte1['÷'] = -9;
      arrayOfByte1['ø'] = -9;
      arrayOfByte1['ù'] = -9;
      arrayOfByte1['ú'] = -9;
      arrayOfByte1['û'] = -9;
      arrayOfByte1['ü'] = -9;
      arrayOfByte1['ý'] = -9;
      arrayOfByte1['þ'] = -9;
      arrayOfByte1['ÿ'] = -9;
      _STANDARD_DECODABET = arrayOfByte1;
      _URL_SAFE_ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      byte[] arrayOfByte2 = new byte[256];
      arrayOfByte2[0] = -9;
      arrayOfByte2[1] = -9;
      arrayOfByte2[2] = -9;
      arrayOfByte2[3] = -9;
      arrayOfByte2[4] = -9;
      arrayOfByte2[5] = -9;
      arrayOfByte2[6] = -9;
      arrayOfByte2[7] = -9;
      arrayOfByte2[8] = -9;
      arrayOfByte2[9] = -5;
      arrayOfByte2[10] = -5;
      arrayOfByte2[11] = -9;
      arrayOfByte2[12] = -9;
      arrayOfByte2[13] = -5;
      arrayOfByte2[14] = -9;
      arrayOfByte2[15] = -9;
      arrayOfByte2[16] = -9;
      arrayOfByte2[17] = -9;
      arrayOfByte2[18] = -9;
      arrayOfByte2[19] = -9;
      arrayOfByte2[20] = -9;
      arrayOfByte2[21] = -9;
      arrayOfByte2[22] = -9;
      arrayOfByte2[23] = -9;
      arrayOfByte2[24] = -9;
      arrayOfByte2[25] = -9;
      arrayOfByte2[26] = -9;
      arrayOfByte2[27] = -9;
      arrayOfByte2[28] = -9;
      arrayOfByte2[29] = -9;
      arrayOfByte2[30] = -9;
      arrayOfByte2[31] = -9;
      arrayOfByte2[32] = -5;
      arrayOfByte2[33] = -9;
      arrayOfByte2[34] = -9;
      arrayOfByte2[35] = -9;
      arrayOfByte2[36] = -9;
      arrayOfByte2[37] = -9;
      arrayOfByte2[38] = -9;
      arrayOfByte2[39] = -9;
      arrayOfByte2[40] = -9;
      arrayOfByte2[41] = -9;
      arrayOfByte2[42] = -9;
      arrayOfByte2[43] = -9;
      arrayOfByte2[44] = -9;
      arrayOfByte2[45] = 62;
      arrayOfByte2[46] = -9;
      arrayOfByte2[47] = -9;
      arrayOfByte2[48] = 52;
      arrayOfByte2[49] = 53;
      arrayOfByte2[50] = 54;
      arrayOfByte2[51] = 55;
      arrayOfByte2[52] = 56;
      arrayOfByte2[53] = 57;
      arrayOfByte2[54] = 58;
      arrayOfByte2[55] = 59;
      arrayOfByte2[56] = 60;
      arrayOfByte2[57] = 61;
      arrayOfByte2[58] = -9;
      arrayOfByte2[59] = -9;
      arrayOfByte2[60] = -9;
      arrayOfByte2[61] = -1;
      arrayOfByte2[62] = -9;
      arrayOfByte2[63] = -9;
      arrayOfByte2[64] = -9;
      arrayOfByte2[66] = 1;
      arrayOfByte2[67] = 2;
      arrayOfByte2[68] = 3;
      arrayOfByte2[69] = 4;
      arrayOfByte2[70] = 5;
      arrayOfByte2[71] = 6;
      arrayOfByte2[72] = 7;
      arrayOfByte2[73] = 8;
      arrayOfByte2[74] = 9;
      arrayOfByte2[75] = 10;
      arrayOfByte2[76] = 11;
      arrayOfByte2[77] = 12;
      arrayOfByte2[78] = 13;
      arrayOfByte2[79] = 14;
      arrayOfByte2[80] = 15;
      arrayOfByte2[81] = 16;
      arrayOfByte2[82] = 17;
      arrayOfByte2[83] = 18;
      arrayOfByte2[84] = 19;
      arrayOfByte2[85] = 20;
      arrayOfByte2[86] = 21;
      arrayOfByte2[87] = 22;
      arrayOfByte2[88] = 23;
      arrayOfByte2[89] = 24;
      arrayOfByte2[90] = 25;
      arrayOfByte2[91] = -9;
      arrayOfByte2[92] = -9;
      arrayOfByte2[93] = -9;
      arrayOfByte2[94] = -9;
      arrayOfByte2[95] = 63;
      arrayOfByte2[96] = -9;
      arrayOfByte2[97] = 26;
      arrayOfByte2[98] = 27;
      arrayOfByte2[99] = 28;
      arrayOfByte2[100] = 29;
      arrayOfByte2[101] = 30;
      arrayOfByte2[102] = 31;
      arrayOfByte2[103] = 32;
      arrayOfByte2[104] = 33;
      arrayOfByte2[105] = 34;
      arrayOfByte2[106] = 35;
      arrayOfByte2[107] = 36;
      arrayOfByte2[108] = 37;
      arrayOfByte2[109] = 38;
      arrayOfByte2[110] = 39;
      arrayOfByte2[111] = 40;
      arrayOfByte2[112] = 41;
      arrayOfByte2[113] = 42;
      arrayOfByte2[114] = 43;
      arrayOfByte2[115] = 44;
      arrayOfByte2[116] = 45;
      arrayOfByte2[117] = 46;
      arrayOfByte2[118] = 47;
      arrayOfByte2[119] = 48;
      arrayOfByte2[120] = 49;
      arrayOfByte2[121] = 50;
      arrayOfByte2[122] = 51;
      arrayOfByte2[123] = -9;
      arrayOfByte2[124] = -9;
      arrayOfByte2[125] = -9;
      arrayOfByte2[126] = -9;
      arrayOfByte2[127] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[''] = -9;
      arrayOfByte2[' '] = -9;
      arrayOfByte2['¡'] = -9;
      arrayOfByte2['¢'] = -9;
      arrayOfByte2['£'] = -9;
      arrayOfByte2['¤'] = -9;
      arrayOfByte2['¥'] = -9;
      arrayOfByte2['¦'] = -9;
      arrayOfByte2['§'] = -9;
      arrayOfByte2['¨'] = -9;
      arrayOfByte2['©'] = -9;
      arrayOfByte2['ª'] = -9;
      arrayOfByte2['«'] = -9;
      arrayOfByte2['¬'] = -9;
      arrayOfByte2['­'] = -9;
      arrayOfByte2['®'] = -9;
      arrayOfByte2['¯'] = -9;
      arrayOfByte2['°'] = -9;
      arrayOfByte2['±'] = -9;
      arrayOfByte2['²'] = -9;
      arrayOfByte2['³'] = -9;
      arrayOfByte2['´'] = -9;
      arrayOfByte2['µ'] = -9;
      arrayOfByte2['¶'] = -9;
      arrayOfByte2['·'] = -9;
      arrayOfByte2['¸'] = -9;
      arrayOfByte2['¹'] = -9;
      arrayOfByte2['º'] = -9;
      arrayOfByte2['»'] = -9;
      arrayOfByte2['¼'] = -9;
      arrayOfByte2['½'] = -9;
      arrayOfByte2['¾'] = -9;
      arrayOfByte2['¿'] = -9;
      arrayOfByte2['À'] = -9;
      arrayOfByte2['Á'] = -9;
      arrayOfByte2['Â'] = -9;
      arrayOfByte2['Ã'] = -9;
      arrayOfByte2['Ä'] = -9;
      arrayOfByte2['Å'] = -9;
      arrayOfByte2['Æ'] = -9;
      arrayOfByte2['Ç'] = -9;
      arrayOfByte2['È'] = -9;
      arrayOfByte2['É'] = -9;
      arrayOfByte2['Ê'] = -9;
      arrayOfByte2['Ë'] = -9;
      arrayOfByte2['Ì'] = -9;
      arrayOfByte2['Í'] = -9;
      arrayOfByte2['Î'] = -9;
      arrayOfByte2['Ï'] = -9;
      arrayOfByte2['Ð'] = -9;
      arrayOfByte2['Ñ'] = -9;
      arrayOfByte2['Ò'] = -9;
      arrayOfByte2['Ó'] = -9;
      arrayOfByte2['Ô'] = -9;
      arrayOfByte2['Õ'] = -9;
      arrayOfByte2['Ö'] = -9;
      arrayOfByte2['×'] = -9;
      arrayOfByte2['Ø'] = -9;
      arrayOfByte2['Ù'] = -9;
      arrayOfByte2['Ú'] = -9;
      arrayOfByte2['Û'] = -9;
      arrayOfByte2['Ü'] = -9;
      arrayOfByte2['Ý'] = -9;
      arrayOfByte2['Þ'] = -9;
      arrayOfByte2['ß'] = -9;
      arrayOfByte2['à'] = -9;
      arrayOfByte2['á'] = -9;
      arrayOfByte2['â'] = -9;
      arrayOfByte2['ã'] = -9;
      arrayOfByte2['ä'] = -9;
      arrayOfByte2['å'] = -9;
      arrayOfByte2['æ'] = -9;
      arrayOfByte2['ç'] = -9;
      arrayOfByte2['è'] = -9;
      arrayOfByte2['é'] = -9;
      arrayOfByte2['ê'] = -9;
      arrayOfByte2['ë'] = -9;
      arrayOfByte2['ì'] = -9;
      arrayOfByte2['í'] = -9;
      arrayOfByte2['î'] = -9;
      arrayOfByte2['ï'] = -9;
      arrayOfByte2['ð'] = -9;
      arrayOfByte2['ñ'] = -9;
      arrayOfByte2['ò'] = -9;
      arrayOfByte2['ó'] = -9;
      arrayOfByte2['ô'] = -9;
      arrayOfByte2['õ'] = -9;
      arrayOfByte2['ö'] = -9;
      arrayOfByte2['÷'] = -9;
      arrayOfByte2['ø'] = -9;
      arrayOfByte2['ù'] = -9;
      arrayOfByte2['ú'] = -9;
      arrayOfByte2['û'] = -9;
      arrayOfByte2['ü'] = -9;
      arrayOfByte2['ý'] = -9;
      arrayOfByte2['þ'] = -9;
      arrayOfByte2['ÿ'] = -9;
      _URL_SAFE_DECODABET = arrayOfByte2;
      _ORDERED_ALPHABET = new byte[] { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
      byte[] arrayOfByte3 = new byte[257];
      arrayOfByte3[0] = -9;
      arrayOfByte3[1] = -9;
      arrayOfByte3[2] = -9;
      arrayOfByte3[3] = -9;
      arrayOfByte3[4] = -9;
      arrayOfByte3[5] = -9;
      arrayOfByte3[6] = -9;
      arrayOfByte3[7] = -9;
      arrayOfByte3[8] = -9;
      arrayOfByte3[9] = -5;
      arrayOfByte3[10] = -5;
      arrayOfByte3[11] = -9;
      arrayOfByte3[12] = -9;
      arrayOfByte3[13] = -5;
      arrayOfByte3[14] = -9;
      arrayOfByte3[15] = -9;
      arrayOfByte3[16] = -9;
      arrayOfByte3[17] = -9;
      arrayOfByte3[18] = -9;
      arrayOfByte3[19] = -9;
      arrayOfByte3[20] = -9;
      arrayOfByte3[21] = -9;
      arrayOfByte3[22] = -9;
      arrayOfByte3[23] = -9;
      arrayOfByte3[24] = -9;
      arrayOfByte3[25] = -9;
      arrayOfByte3[26] = -9;
      arrayOfByte3[27] = -9;
      arrayOfByte3[28] = -9;
      arrayOfByte3[29] = -9;
      arrayOfByte3[30] = -9;
      arrayOfByte3[31] = -9;
      arrayOfByte3[32] = -5;
      arrayOfByte3[33] = -9;
      arrayOfByte3[34] = -9;
      arrayOfByte3[35] = -9;
      arrayOfByte3[36] = -9;
      arrayOfByte3[37] = -9;
      arrayOfByte3[38] = -9;
      arrayOfByte3[39] = -9;
      arrayOfByte3[40] = -9;
      arrayOfByte3[41] = -9;
      arrayOfByte3[42] = -9;
      arrayOfByte3[43] = -9;
      arrayOfByte3[44] = -9;
      arrayOfByte3[46] = -9;
      arrayOfByte3[47] = -9;
      arrayOfByte3[48] = 1;
      arrayOfByte3[49] = 2;
      arrayOfByte3[50] = 3;
      arrayOfByte3[51] = 4;
      arrayOfByte3[52] = 5;
      arrayOfByte3[53] = 6;
      arrayOfByte3[54] = 7;
      arrayOfByte3[55] = 8;
      arrayOfByte3[56] = 9;
      arrayOfByte3[57] = 10;
      arrayOfByte3[58] = -9;
      arrayOfByte3[59] = -9;
      arrayOfByte3[60] = -9;
      arrayOfByte3[61] = -1;
      arrayOfByte3[62] = -9;
      arrayOfByte3[63] = -9;
      arrayOfByte3[64] = -9;
      arrayOfByte3[65] = 11;
      arrayOfByte3[66] = 12;
      arrayOfByte3[67] = 13;
      arrayOfByte3[68] = 14;
      arrayOfByte3[69] = 15;
      arrayOfByte3[70] = 16;
      arrayOfByte3[71] = 17;
      arrayOfByte3[72] = 18;
      arrayOfByte3[73] = 19;
      arrayOfByte3[74] = 20;
      arrayOfByte3[75] = 21;
      arrayOfByte3[76] = 22;
      arrayOfByte3[77] = 23;
      arrayOfByte3[78] = 24;
      arrayOfByte3[79] = 25;
      arrayOfByte3[80] = 26;
      arrayOfByte3[81] = 27;
      arrayOfByte3[82] = 28;
      arrayOfByte3[83] = 29;
      arrayOfByte3[84] = 30;
      arrayOfByte3[85] = 31;
      arrayOfByte3[86] = 32;
      arrayOfByte3[87] = 33;
      arrayOfByte3[88] = 34;
      arrayOfByte3[89] = 35;
      arrayOfByte3[90] = 36;
      arrayOfByte3[91] = -9;
      arrayOfByte3[92] = -9;
      arrayOfByte3[93] = -9;
      arrayOfByte3[94] = -9;
      arrayOfByte3[95] = 37;
      arrayOfByte3[96] = -9;
      arrayOfByte3[97] = 38;
      arrayOfByte3[98] = 39;
      arrayOfByte3[99] = 40;
      arrayOfByte3[100] = 41;
      arrayOfByte3[101] = 42;
      arrayOfByte3[102] = 43;
      arrayOfByte3[103] = 44;
      arrayOfByte3[104] = 45;
      arrayOfByte3[105] = 46;
      arrayOfByte3[106] = 47;
      arrayOfByte3[107] = 48;
      arrayOfByte3[108] = 49;
      arrayOfByte3[109] = 50;
      arrayOfByte3[110] = 51;
      arrayOfByte3[111] = 52;
      arrayOfByte3[112] = 53;
      arrayOfByte3[113] = 54;
      arrayOfByte3[114] = 55;
      arrayOfByte3[115] = 56;
      arrayOfByte3[116] = 57;
      arrayOfByte3[117] = 58;
      arrayOfByte3[118] = 59;
      arrayOfByte3[119] = 60;
      arrayOfByte3[120] = 61;
      arrayOfByte3[121] = 62;
      arrayOfByte3[122] = 63;
      arrayOfByte3[123] = -9;
      arrayOfByte3[124] = -9;
      arrayOfByte3[125] = -9;
      arrayOfByte3[126] = -9;
      arrayOfByte3[127] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[''] = -9;
      arrayOfByte3[' '] = -9;
      arrayOfByte3['¡'] = -9;
      arrayOfByte3['¢'] = -9;
      arrayOfByte3['£'] = -9;
      arrayOfByte3['¤'] = -9;
      arrayOfByte3['¥'] = -9;
      arrayOfByte3['¦'] = -9;
      arrayOfByte3['§'] = -9;
      arrayOfByte3['¨'] = -9;
      arrayOfByte3['©'] = -9;
      arrayOfByte3['ª'] = -9;
      arrayOfByte3['«'] = -9;
      arrayOfByte3['¬'] = -9;
      arrayOfByte3['­'] = -9;
      arrayOfByte3['®'] = -9;
      arrayOfByte3['¯'] = -9;
      arrayOfByte3['°'] = -9;
      arrayOfByte3['±'] = -9;
      arrayOfByte3['²'] = -9;
      arrayOfByte3['³'] = -9;
      arrayOfByte3['´'] = -9;
      arrayOfByte3['µ'] = -9;
      arrayOfByte3['¶'] = -9;
      arrayOfByte3['·'] = -9;
      arrayOfByte3['¸'] = -9;
      arrayOfByte3['¹'] = -9;
      arrayOfByte3['º'] = -9;
      arrayOfByte3['»'] = -9;
      arrayOfByte3['¼'] = -9;
      arrayOfByte3['½'] = -9;
      arrayOfByte3['¾'] = -9;
      arrayOfByte3['¿'] = -9;
      arrayOfByte3['À'] = -9;
      arrayOfByte3['Á'] = -9;
      arrayOfByte3['Â'] = -9;
      arrayOfByte3['Ã'] = -9;
      arrayOfByte3['Ä'] = -9;
      arrayOfByte3['Å'] = -9;
      arrayOfByte3['Æ'] = -9;
      arrayOfByte3['Ç'] = -9;
      arrayOfByte3['È'] = -9;
      arrayOfByte3['É'] = -9;
      arrayOfByte3['Ê'] = -9;
      arrayOfByte3['Ë'] = -9;
      arrayOfByte3['Ì'] = -9;
      arrayOfByte3['Í'] = -9;
      arrayOfByte3['Î'] = -9;
      arrayOfByte3['Ï'] = -9;
      arrayOfByte3['Ð'] = -9;
      arrayOfByte3['Ñ'] = -9;
      arrayOfByte3['Ò'] = -9;
      arrayOfByte3['Ó'] = -9;
      arrayOfByte3['Ô'] = -9;
      arrayOfByte3['Õ'] = -9;
      arrayOfByte3['Ö'] = -9;
      arrayOfByte3['×'] = -9;
      arrayOfByte3['Ø'] = -9;
      arrayOfByte3['Ù'] = -9;
      arrayOfByte3['Ú'] = -9;
      arrayOfByte3['Û'] = -9;
      arrayOfByte3['Ü'] = -9;
      arrayOfByte3['Ý'] = -9;
      arrayOfByte3['Þ'] = -9;
      arrayOfByte3['ß'] = -9;
      arrayOfByte3['à'] = -9;
      arrayOfByte3['á'] = -9;
      arrayOfByte3['â'] = -9;
      arrayOfByte3['ã'] = -9;
      arrayOfByte3['ä'] = -9;
      arrayOfByte3['å'] = -9;
      arrayOfByte3['æ'] = -9;
      arrayOfByte3['ç'] = -9;
      arrayOfByte3['è'] = -9;
      arrayOfByte3['é'] = -9;
      arrayOfByte3['ê'] = -9;
      arrayOfByte3['ë'] = -9;
      arrayOfByte3['ì'] = -9;
      arrayOfByte3['í'] = -9;
      arrayOfByte3['î'] = -9;
      arrayOfByte3['ï'] = -9;
      arrayOfByte3['ð'] = -9;
      arrayOfByte3['ñ'] = -9;
      arrayOfByte3['ò'] = -9;
      arrayOfByte3['ó'] = -9;
      arrayOfByte3['ô'] = -9;
      arrayOfByte3['õ'] = -9;
      arrayOfByte3['ö'] = -9;
      arrayOfByte3['÷'] = -9;
      arrayOfByte3['ø'] = -9;
      arrayOfByte3['ù'] = -9;
      arrayOfByte3['ú'] = -9;
      arrayOfByte3['û'] = -9;
      arrayOfByte3['ü'] = -9;
      arrayOfByte3['ý'] = -9;
      arrayOfByte3['þ'] = -9;
      arrayOfByte3['ÿ'] = -9;
      arrayOfByte3[256] = -9;
      _ORDERED_DECODABET = arrayOfByte3;
      return;
    }
  }

  public static byte[] decode(String paramString)
    throws IOException
  {
    return decode(paramString, 0);
  }

  // ERROR //
  public static byte[] decode(String paramString, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 167	java/lang/NullPointerException
    //   7: dup
    //   8: ldc 169
    //   10: invokespecial 172	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_0
    //   15: ldc 34
    //   17: invokevirtual 177	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   20: astore 38
    //   22: aload 38
    //   24: astore_3
    //   25: aload_3
    //   26: iconst_0
    //   27: aload_3
    //   28: arraylength
    //   29: iload_1
    //   30: invokestatic 180	anywheresoftware/b4a/objects/Base64:decode	([BIII)[B
    //   33: astore 4
    //   35: iload_1
    //   36: iconst_4
    //   37: iand
    //   38: ifeq +142 -> 180
    //   41: iconst_1
    //   42: istore 5
    //   44: aload 4
    //   46: ifnull +411 -> 457
    //   49: aload 4
    //   51: arraylength
    //   52: iconst_4
    //   53: if_icmplt +404 -> 457
    //   56: iload 5
    //   58: ifne +399 -> 457
    //   61: ldc 181
    //   63: sipush 255
    //   66: aload 4
    //   68: iconst_0
    //   69: baload
    //   70: iand
    //   71: ldc 182
    //   73: aload 4
    //   75: iconst_1
    //   76: baload
    //   77: bipush 8
    //   79: ishl
    //   80: iand
    //   81: ior
    //   82: if_icmpne +375 -> 457
    //   85: aconst_null
    //   86: astore 6
    //   88: aconst_null
    //   89: astore 7
    //   91: sipush 2048
    //   94: newarray byte
    //   96: astore 8
    //   98: new 184	java/io/ByteArrayOutputStream
    //   101: dup
    //   102: invokespecial 185	java/io/ByteArrayOutputStream:<init>	()V
    //   105: astore 9
    //   107: new 187	java/io/ByteArrayInputStream
    //   110: dup
    //   111: aload 4
    //   113: invokespecial 190	java/io/ByteArrayInputStream:<init>	([B)V
    //   116: astore 10
    //   118: new 192	java/util/zip/GZIPInputStream
    //   121: dup
    //   122: aload 10
    //   124: invokespecial 195	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   127: astore 11
    //   129: iconst_0
    //   130: istore 12
    //   132: aload 11
    //   134: aload 8
    //   136: invokevirtual 199	java/util/zip/GZIPInputStream:read	([B)I
    //   139: istore 12
    //   141: iload 12
    //   143: ifge +43 -> 186
    //   146: aload 9
    //   148: invokevirtual 203	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   151: astore 29
    //   153: aload 9
    //   155: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   158: aload 11
    //   160: invokevirtual 207	java/util/zip/GZIPInputStream:close	()V
    //   163: aload 10
    //   165: invokevirtual 208	java/io/ByteArrayInputStream:close	()V
    //   168: aload 29
    //   170: areturn
    //   171: astore_2
    //   172: aload_0
    //   173: invokevirtual 210	java/lang/String:getBytes	()[B
    //   176: astore_3
    //   177: goto -152 -> 25
    //   180: iconst_0
    //   181: istore 5
    //   183: goto -139 -> 44
    //   186: aload 9
    //   188: aload 8
    //   190: iconst_0
    //   191: iload 12
    //   193: invokevirtual 214	java/io/ByteArrayOutputStream:write	([BII)V
    //   196: goto -64 -> 132
    //   199: astore 20
    //   201: iload 12
    //   203: istore 21
    //   205: aload 10
    //   207: astore 6
    //   209: aload 9
    //   211: astore 7
    //   213: aload 20
    //   215: astore 22
    //   217: aload 11
    //   219: astore 23
    //   221: aload 22
    //   223: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   226: aload 7
    //   228: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   231: aload 23
    //   233: invokevirtual 207	java/util/zip/GZIPInputStream:close	()V
    //   236: aload 6
    //   238: invokevirtual 208	java/io/ByteArrayInputStream:close	()V
    //   241: aload 4
    //   243: areturn
    //   244: astore 28
    //   246: aload 4
    //   248: areturn
    //   249: astore 37
    //   251: aload 37
    //   253: astore 14
    //   255: aconst_null
    //   256: astore 16
    //   258: aload 7
    //   260: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   263: aload 16
    //   265: invokevirtual 207	java/util/zip/GZIPInputStream:close	()V
    //   268: aload 6
    //   270: invokevirtual 208	java/io/ByteArrayInputStream:close	()V
    //   273: aload 14
    //   275: athrow
    //   276: astore 26
    //   278: goto -47 -> 231
    //   281: astore 27
    //   283: goto -47 -> 236
    //   286: astore 17
    //   288: goto -25 -> 263
    //   291: astore 18
    //   293: goto -25 -> 268
    //   296: astore 19
    //   298: goto -25 -> 273
    //   301: astore 30
    //   303: goto -145 -> 158
    //   306: astore 31
    //   308: goto -145 -> 163
    //   311: astore 32
    //   313: aload 29
    //   315: areturn
    //   316: astore 36
    //   318: aload 36
    //   320: astore 14
    //   322: aload 9
    //   324: astore 7
    //   326: aconst_null
    //   327: astore 16
    //   329: aconst_null
    //   330: astore 6
    //   332: goto -74 -> 258
    //   335: astore 34
    //   337: aload 34
    //   339: astore 14
    //   341: aload 10
    //   343: astore 6
    //   345: aload 9
    //   347: astore 7
    //   349: aconst_null
    //   350: astore 16
    //   352: goto -94 -> 258
    //   355: astore 13
    //   357: aload 13
    //   359: astore 14
    //   361: iload 12
    //   363: pop
    //   364: aload 10
    //   366: astore 6
    //   368: aload 9
    //   370: astore 7
    //   372: aload 11
    //   374: astore 16
    //   376: goto -118 -> 258
    //   379: astore 24
    //   381: aload 24
    //   383: astore 14
    //   385: aload 23
    //   387: astore 16
    //   389: iload 21
    //   391: pop
    //   392: goto -134 -> 258
    //   395: astore 22
    //   397: aconst_null
    //   398: astore 23
    //   400: iconst_0
    //   401: istore 21
    //   403: aconst_null
    //   404: astore 6
    //   406: aconst_null
    //   407: astore 7
    //   409: goto -188 -> 221
    //   412: astore 35
    //   414: aload 35
    //   416: astore 22
    //   418: aload 9
    //   420: astore 7
    //   422: aconst_null
    //   423: astore 23
    //   425: iconst_0
    //   426: istore 21
    //   428: aconst_null
    //   429: astore 6
    //   431: goto -210 -> 221
    //   434: astore 33
    //   436: aload 33
    //   438: astore 22
    //   440: aload 10
    //   442: astore 6
    //   444: aload 9
    //   446: astore 7
    //   448: aconst_null
    //   449: astore 23
    //   451: iconst_0
    //   452: istore 21
    //   454: goto -233 -> 221
    //   457: aload 4
    //   459: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   14	22	171	java/io/UnsupportedEncodingException
    //   132	141	199	java/io/IOException
    //   146	153	199	java/io/IOException
    //   186	196	199	java/io/IOException
    //   236	241	244	java/lang/Exception
    //   98	107	249	finally
    //   226	231	276	java/lang/Exception
    //   231	236	281	java/lang/Exception
    //   258	263	286	java/lang/Exception
    //   263	268	291	java/lang/Exception
    //   268	273	296	java/lang/Exception
    //   153	158	301	java/lang/Exception
    //   158	163	306	java/lang/Exception
    //   163	168	311	java/lang/Exception
    //   107	118	316	finally
    //   118	129	335	finally
    //   132	141	355	finally
    //   146	153	355	finally
    //   186	196	355	finally
    //   221	226	379	finally
    //   98	107	395	java/io/IOException
    //   107	118	412	java/io/IOException
    //   118	129	434	java/io/IOException
  }

  public static byte[] decode(byte[] paramArrayOfByte)
    throws IOException
  {
    ((byte[])null);
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
  }

  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("Cannot decode null source array.");
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length))
    {
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = Integer.valueOf(paramArrayOfByte.length);
      arrayOfObject1[1] = Integer.valueOf(paramInt1);
      arrayOfObject1[2] = Integer.valueOf(paramInt2);
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", arrayOfObject1));
    }
    if (paramInt2 == 0)
      return new byte[0];
    if (paramInt2 < 4)
      throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + paramInt2);
    byte[] arrayOfByte1 = getDecodabet(paramInt3);
    byte[] arrayOfByte2 = new byte[paramInt2 * 3 / 4];
    byte[] arrayOfByte3 = new byte[4];
    int i = 0;
    int j = paramInt1;
    int k = 0;
    int m = 0;
    if (j >= paramInt1 + paramInt2);
    int n;
    int i1;
    int i2;
    for (int i3 = i; ; i3 = i2)
    {
      byte[] arrayOfByte4 = new byte[i3];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte4, 0, i3);
      return arrayOfByte4;
      n = arrayOfByte1[(0xFF & paramArrayOfByte[j])];
      if (n < -5)
        break;
      if (n < -1)
        break label325;
      i1 = k + 1;
      arrayOfByte3[k] = paramArrayOfByte[j];
      if (i1 <= 3)
        break label311;
      i2 = i + decode4to3(arrayOfByte3, 0, arrayOfByte2, i, paramInt3);
      i1 = 0;
      if (paramArrayOfByte[j] != 61)
        break label307;
    }
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Integer.valueOf(0xFF & paramArrayOfByte[j]);
    arrayOfObject2[1] = Integer.valueOf(j);
    throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", arrayOfObject2));
    label307: i = i2;
    while (true)
    {
      label311: j++;
      k = i1;
      m = n;
      break;
      label325: i1 = k;
    }
  }

  private static int decode4to3(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1 == null)
      throw new NullPointerException("Source array was null.");
    if (paramArrayOfByte2 == null)
      throw new NullPointerException("Destination array was null.");
    if ((paramInt1 < 0) || (paramInt1 + 3 >= paramArrayOfByte1.length))
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(paramArrayOfByte1.length);
      arrayOfObject1[1] = Integer.valueOf(paramInt1);
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", arrayOfObject1));
    }
    if ((paramInt2 < 0) || (paramInt2 + 2 >= paramArrayOfByte2.length))
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(paramArrayOfByte2.length);
      arrayOfObject2[1] = Integer.valueOf(paramInt2);
      throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", arrayOfObject2));
    }
    byte[] arrayOfByte = getDecodabet(paramInt3);
    if (paramArrayOfByte1[(paramInt1 + 2)] == 61)
    {
      paramArrayOfByte2[paramInt2] = ((byte)(((0xFF & arrayOfByte[paramArrayOfByte1[paramInt1]]) << 18 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]]) << 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[(paramInt1 + 3)] == 61)
    {
      int j = (0xFF & arrayOfByte[paramArrayOfByte1[paramInt1]]) << 18 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]]) << 12 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]]) << 6;
      paramArrayOfByte2[paramInt2] = ((byte)(j >>> 16));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(j >>> 8));
      return 2;
    }
    int i = (0xFF & arrayOfByte[paramArrayOfByte1[paramInt1]]) << 18 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]]) << 12 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]]) << 6 | 0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 3)]];
    paramArrayOfByte2[paramInt2] = ((byte)(i >> 16));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(i >> 8));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)i);
    return 3;
  }

  // ERROR //
  public static void decodeFileToFile(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 271	anywheresoftware/b4a/objects/Base64:decodeFromFile	(Ljava/lang/String;)[B
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: new 273	java/io/BufferedOutputStream
    //   10: dup
    //   11: new 275	java/io/FileOutputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 276	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 279	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 4
    //   24: aload 4
    //   26: aload_2
    //   27: invokevirtual 283	java/io/OutputStream:write	([B)V
    //   30: aload 4
    //   32: invokevirtual 284	java/io/OutputStream:close	()V
    //   35: return
    //   36: astore 10
    //   38: aload 10
    //   40: astore 6
    //   42: aload 6
    //   44: athrow
    //   45: astore 7
    //   47: aload_3
    //   48: invokevirtual 284	java/io/OutputStream:close	()V
    //   51: aload 7
    //   53: athrow
    //   54: astore 8
    //   56: goto -5 -> 51
    //   59: astore 9
    //   61: return
    //   62: astore 7
    //   64: aload 4
    //   66: astore_3
    //   67: goto -20 -> 47
    //   70: astore 5
    //   72: aload 5
    //   74: astore 6
    //   76: aload 4
    //   78: astore_3
    //   79: goto -37 -> 42
    //
    // Exception table:
    //   from	to	target	type
    //   7	24	36	java/io/IOException
    //   7	24	45	finally
    //   42	45	45	finally
    //   47	51	54	java/lang/Exception
    //   30	35	59	java/lang/Exception
    //   24	30	62	finally
    //   24	30	70	java/io/IOException
  }

  // ERROR //
  public static byte[] decodeFromFile(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: checkcast 219	[B
    //   4: pop
    //   5: aconst_null
    //   6: astore_2
    //   7: new 286	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 287	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_3
    //   16: aconst_null
    //   17: checkcast 219	[B
    //   20: pop
    //   21: iconst_0
    //   22: istore 9
    //   24: aload_3
    //   25: invokevirtual 291	java/io/File:length	()J
    //   28: ldc2_w 292
    //   31: lcmp
    //   32: istore 10
    //   34: aconst_null
    //   35: astore_2
    //   36: iload 10
    //   38: ifle +55 -> 93
    //   41: new 158	java/io/IOException
    //   44: dup
    //   45: new 238	java/lang/StringBuilder
    //   48: dup
    //   49: ldc_w 295
    //   52: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   55: aload_3
    //   56: invokevirtual 291	java/io/File:length	()J
    //   59: invokevirtual 298	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc_w 300
    //   65: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 258	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: astore 6
    //   77: aload 6
    //   79: astore 7
    //   81: aload 7
    //   83: athrow
    //   84: astore 4
    //   86: aload_2
    //   87: invokevirtual 306	anywheresoftware/b4a/objects/Base64$InputStream:close	()V
    //   90: aload 4
    //   92: athrow
    //   93: aload_3
    //   94: invokevirtual 291	java/io/File:length	()J
    //   97: l2i
    //   98: newarray byte
    //   100: astore 11
    //   102: new 305	anywheresoftware/b4a/objects/Base64$InputStream
    //   105: dup
    //   106: new 308	java/io/BufferedInputStream
    //   109: dup
    //   110: new 310	java/io/FileInputStream
    //   113: dup
    //   114: aload_3
    //   115: invokespecial 313	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   118: invokespecial 314	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   121: iconst_0
    //   122: invokespecial 317	anywheresoftware/b4a/objects/Base64$InputStream:<init>	(Ljava/io/InputStream;I)V
    //   125: astore 12
    //   127: aload 12
    //   129: aload 11
    //   131: iload 9
    //   133: sipush 4096
    //   136: invokevirtual 320	anywheresoftware/b4a/objects/Base64$InputStream:read	([BII)I
    //   139: istore 14
    //   141: iload 14
    //   143: ifge +28 -> 171
    //   146: iload 9
    //   148: newarray byte
    //   150: astore 15
    //   152: aload 11
    //   154: iconst_0
    //   155: aload 15
    //   157: iconst_0
    //   158: iload 9
    //   160: invokestatic 255	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   163: aload 12
    //   165: invokevirtual 306	anywheresoftware/b4a/objects/Base64$InputStream:close	()V
    //   168: aload 15
    //   170: areturn
    //   171: iload 9
    //   173: iload 14
    //   175: iadd
    //   176: istore 9
    //   178: goto -51 -> 127
    //   181: astore 5
    //   183: goto -93 -> 90
    //   186: astore 16
    //   188: aload 15
    //   190: areturn
    //   191: astore 4
    //   193: aload 12
    //   195: astore_2
    //   196: goto -110 -> 86
    //   199: astore 13
    //   201: aload 13
    //   203: astore 7
    //   205: aload 12
    //   207: astore_2
    //   208: goto -127 -> 81
    //
    // Exception table:
    //   from	to	target	type
    //   7	21	75	java/io/IOException
    //   24	34	75	java/io/IOException
    //   41	75	75	java/io/IOException
    //   93	127	75	java/io/IOException
    //   7	21	84	finally
    //   24	34	84	finally
    //   41	75	84	finally
    //   81	84	84	finally
    //   93	127	84	finally
    //   86	90	181	java/lang/Exception
    //   163	168	186	java/lang/Exception
    //   127	141	191	finally
    //   146	163	191	finally
    //   127	141	199	java/io/IOException
    //   146	163	199	java/io/IOException
  }

  // ERROR //
  public static void decodeToFile(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 323	anywheresoftware/b4a/objects/Base64$OutputStream
    //   5: dup
    //   6: new 275	java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 276	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   14: iconst_0
    //   15: invokespecial 326	anywheresoftware/b4a/objects/Base64$OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_0
    //   21: ldc 34
    //   23: invokevirtual 177	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   26: invokevirtual 327	anywheresoftware/b4a/objects/Base64$OutputStream:write	([B)V
    //   29: aload_3
    //   30: invokevirtual 328	anywheresoftware/b4a/objects/Base64$OutputStream:close	()V
    //   33: return
    //   34: astore 9
    //   36: aload 9
    //   38: astore 5
    //   40: aload 5
    //   42: athrow
    //   43: astore 6
    //   45: aload_2
    //   46: invokevirtual 328	anywheresoftware/b4a/objects/Base64$OutputStream:close	()V
    //   49: aload 6
    //   51: athrow
    //   52: astore 7
    //   54: goto -5 -> 49
    //   57: astore 8
    //   59: return
    //   60: astore 6
    //   62: aload_3
    //   63: astore_2
    //   64: goto -19 -> 45
    //   67: astore 4
    //   69: aload 4
    //   71: astore 5
    //   73: aload_3
    //   74: astore_2
    //   75: goto -35 -> 40
    //
    // Exception table:
    //   from	to	target	type
    //   2	19	34	java/io/IOException
    //   2	19	43	finally
    //   40	43	43	finally
    //   45	49	52	java/lang/Exception
    //   29	33	57	java/lang/Exception
    //   19	29	60	finally
    //   19	29	67	java/io/IOException
  }

  public static Object decodeToObject(String paramString)
    throws IOException, ClassNotFoundException
  {
    return decodeToObject(paramString, 0, null);
  }

  // ERROR //
  public static Object decodeToObject(String paramString, int paramInt, final ClassLoader paramClassLoader)
    throws IOException, ClassNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokestatic 161	anywheresoftware/b4a/objects/Base64:decode	(Ljava/lang/String;I)[B
    //   5: astore_3
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: new 187	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_3
    //   17: invokespecial 190	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: astore 6
    //   22: aload_2
    //   23: ifnonnull +34 -> 57
    //   26: new 337	java/io/ObjectInputStream
    //   29: dup
    //   30: aload 6
    //   32: invokespecial 338	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 342	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   42: astore 15
    //   44: aload 6
    //   46: invokevirtual 208	java/io/ByteArrayInputStream:close	()V
    //   49: aload 5
    //   51: invokevirtual 343	java/io/ObjectInputStream:close	()V
    //   54: aload 15
    //   56: areturn
    //   57: new 345	anywheresoftware/b4a/objects/Base64$1
    //   60: dup
    //   61: aload 6
    //   63: aload_2
    //   64: invokespecial 348	anywheresoftware/b4a/objects/Base64$1:<init>	(Ljava/io/InputStream;Ljava/lang/ClassLoader;)V
    //   67: astore 7
    //   69: aload 7
    //   71: astore 5
    //   73: goto -36 -> 37
    //   76: astore 19
    //   78: aload 19
    //   80: astore 9
    //   82: aload 9
    //   84: athrow
    //   85: astore 10
    //   87: aload 4
    //   89: invokevirtual 208	java/io/ByteArrayInputStream:close	()V
    //   92: aload 5
    //   94: invokevirtual 343	java/io/ObjectInputStream:close	()V
    //   97: aload 10
    //   99: athrow
    //   100: astore 18
    //   102: aload 18
    //   104: astore 14
    //   106: aload 14
    //   108: athrow
    //   109: astore 11
    //   111: goto -19 -> 92
    //   114: astore 12
    //   116: goto -19 -> 97
    //   119: astore 16
    //   121: goto -72 -> 49
    //   124: astore 17
    //   126: aload 15
    //   128: areturn
    //   129: astore 10
    //   131: aload 6
    //   133: astore 4
    //   135: goto -48 -> 87
    //   138: astore 13
    //   140: aload 13
    //   142: astore 14
    //   144: aload 6
    //   146: astore 4
    //   148: goto -42 -> 106
    //   151: astore 8
    //   153: aload 8
    //   155: astore 9
    //   157: aload 6
    //   159: astore 4
    //   161: goto -79 -> 82
    //
    // Exception table:
    //   from	to	target	type
    //   12	22	76	java/io/IOException
    //   12	22	85	finally
    //   82	85	85	finally
    //   106	109	85	finally
    //   12	22	100	java/lang/ClassNotFoundException
    //   87	92	109	java/lang/Exception
    //   92	97	114	java/lang/Exception
    //   44	49	119	java/lang/Exception
    //   49	54	124	java/lang/Exception
    //   26	37	129	finally
    //   37	44	129	finally
    //   57	69	129	finally
    //   26	37	138	java/lang/ClassNotFoundException
    //   37	44	138	java/lang/ClassNotFoundException
    //   57	69	138	java/lang/ClassNotFoundException
    //   26	37	151	java/io/IOException
    //   37	44	151	java/io/IOException
    //   57	69	151	java/io/IOException
  }

  public static void encode(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    byte[] arrayOfByte1 = new byte[3];
    byte[] arrayOfByte2 = new byte[4];
    while (true)
    {
      if (!paramByteBuffer1.hasRemaining())
        return;
      int i = Math.min(3, paramByteBuffer1.remaining());
      paramByteBuffer1.get(arrayOfByte1, 0, i);
      encode3to4(arrayOfByte2, arrayOfByte1, i, 0);
      paramByteBuffer2.put(arrayOfByte2);
    }
  }

  public static void encode(ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer)
  {
    byte[] arrayOfByte1 = new byte[3];
    byte[] arrayOfByte2 = new byte[4];
    while (true)
    {
      if (!paramByteBuffer.hasRemaining())
        return;
      int i = Math.min(3, paramByteBuffer.remaining());
      paramByteBuffer.get(arrayOfByte1, 0, i);
      encode3to4(arrayOfByte2, arrayOfByte1, i, 0);
      for (int j = 0; j < 4; j++)
        paramCharBuffer.put((char)(0xFF & arrayOfByte2[j]));
    }
  }

  private static byte[] encode3to4(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = getAlphabet(paramInt4);
    int i;
    label22: int j;
    label40: int k;
    if (paramInt2 > 0)
    {
      i = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      if (paramInt2 <= 1)
        break label108;
      j = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;
      k = i | j;
      if (paramInt2 <= 2)
        break label114;
    }
    int n;
    label108: label114: for (int m = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24; ; m = 0)
    {
      n = k | m;
      switch (paramInt2)
      {
      default:
        return paramArrayOfByte2;
        i = 0;
        break label22;
        j = 0;
        break label40;
      case 3:
      case 2:
      case 1:
      }
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(n >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & n >>> 12)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(0x3F & n >>> 6)];
    paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(n & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(n >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & n >>> 12)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(0x3F & n >>> 6)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(n >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & n >>> 12)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }

  private static byte[] encode3to4(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    encode3to4(paramArrayOfByte2, 0, paramInt1, paramArrayOfByte1, 0, paramInt2);
    return paramArrayOfByte1;
  }

  public static String encodeBytes(byte[] paramArrayOfByte)
  {
    String str1;
    try
    {
      String str2 = encodeBytes(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      str1 = str2;
      if ((!$assertionsDisabled) && (str1 == null))
        throw new AssertionError();
    }
    catch (IOException localIOException)
    {
      boolean bool;
      do
      {
        bool = $assertionsDisabled;
        str1 = null;
      }
      while (bool);
      throw new AssertionError(localIOException.getMessage());
    }
    return str1;
  }

  public static String encodeBytes(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    return encodeBytes(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }

  public static String encodeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    String str1;
    try
    {
      String str2 = encodeBytes(paramArrayOfByte, paramInt1, paramInt2, 0);
      str1 = str2;
      if ((!$assertionsDisabled) && (str1 == null))
        throw new AssertionError();
    }
    catch (IOException localIOException)
    {
      boolean bool;
      do
      {
        bool = $assertionsDisabled;
        str1 = null;
      }
      while (bool);
      throw new AssertionError(localIOException.getMessage());
    }
    return str1;
  }

  public static String encodeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    byte[] arrayOfByte = encodeBytesToBytes(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    try
    {
      String str = new String(arrayOfByte, "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return new String(arrayOfByte);
  }

  public static byte[] encodeBytesToBytes(byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])null;
    try
    {
      byte[] arrayOfByte = encodeBytesToBytes(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      localObject = arrayOfByte;
      return localObject;
    }
    catch (IOException localIOException)
    {
      while ($assertionsDisabled);
      throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + localIOException.getMessage());
    }
  }

  // ERROR //
  public static byte[] encodeBytesToBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +14 -> 15
    //   4: new 167	java/lang/NullPointerException
    //   7: dup
    //   8: ldc_w 409
    //   11: invokespecial 172	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: iload_1
    //   16: ifge +28 -> 44
    //   19: new 229	java/lang/IllegalArgumentException
    //   22: dup
    //   23: new 238	java/lang/StringBuilder
    //   26: dup
    //   27: ldc_w 411
    //   30: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: iload_1
    //   34: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 236	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    //   44: iload_2
    //   45: ifge +28 -> 73
    //   48: new 229	java/lang/IllegalArgumentException
    //   51: dup
    //   52: new 238	java/lang/StringBuilder
    //   55: dup
    //   56: ldc_w 413
    //   59: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: iload_2
    //   63: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 236	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   72: athrow
    //   73: iload_1
    //   74: iload_2
    //   75: iadd
    //   76: aload_0
    //   77: arraylength
    //   78: if_icmple +50 -> 128
    //   81: iconst_3
    //   82: anewarray 4	java/lang/Object
    //   85: astore 41
    //   87: aload 41
    //   89: iconst_0
    //   90: iload_1
    //   91: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   94: aastore
    //   95: aload 41
    //   97: iconst_1
    //   98: iload_2
    //   99: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: aload 41
    //   105: iconst_2
    //   106: aload_0
    //   107: arraylength
    //   108: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: new 229	java/lang/IllegalArgumentException
    //   115: dup
    //   116: ldc_w 415
    //   119: aload 41
    //   121: invokestatic 235	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokespecial 236	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   127: athrow
    //   128: iload_3
    //   129: iconst_2
    //   130: iand
    //   131: ifeq +109 -> 240
    //   134: new 184	java/io/ByteArrayOutputStream
    //   137: dup
    //   138: invokespecial 185	java/io/ByteArrayOutputStream:<init>	()V
    //   141: astore 19
    //   143: new 323	anywheresoftware/b4a/objects/Base64$OutputStream
    //   146: dup
    //   147: aload 19
    //   149: iload_3
    //   150: iconst_1
    //   151: ior
    //   152: invokespecial 326	anywheresoftware/b4a/objects/Base64$OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   155: astore 20
    //   157: new 417	java/util/zip/GZIPOutputStream
    //   160: dup
    //   161: aload 20
    //   163: invokespecial 418	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   166: astore 21
    //   168: aload 21
    //   170: aload_0
    //   171: iload_1
    //   172: iload_2
    //   173: invokevirtual 419	java/util/zip/GZIPOutputStream:write	([BII)V
    //   176: aload 21
    //   178: invokevirtual 420	java/util/zip/GZIPOutputStream:close	()V
    //   181: aload 21
    //   183: invokevirtual 420	java/util/zip/GZIPOutputStream:close	()V
    //   186: aload 20
    //   188: invokevirtual 328	anywheresoftware/b4a/objects/Base64$OutputStream:close	()V
    //   191: aload 19
    //   193: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   196: aload 19
    //   198: invokevirtual 203	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   201: areturn
    //   202: astore 40
    //   204: aload 40
    //   206: astore 23
    //   208: aconst_null
    //   209: astore 24
    //   211: aconst_null
    //   212: astore 25
    //   214: aconst_null
    //   215: astore 26
    //   217: aload 23
    //   219: athrow
    //   220: astore 27
    //   222: aload 24
    //   224: invokevirtual 420	java/util/zip/GZIPOutputStream:close	()V
    //   227: aload 26
    //   229: invokevirtual 328	anywheresoftware/b4a/objects/Base64$OutputStream:close	()V
    //   232: aload 25
    //   234: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   237: aload 27
    //   239: athrow
    //   240: iload_3
    //   241: bipush 8
    //   243: iand
    //   244: ifeq +128 -> 372
    //   247: iconst_1
    //   248: istore 4
    //   250: iconst_4
    //   251: iload_2
    //   252: iconst_3
    //   253: idiv
    //   254: imul
    //   255: istore 5
    //   257: iload_2
    //   258: iconst_3
    //   259: irem
    //   260: ifle +118 -> 378
    //   263: iconst_4
    //   264: istore 6
    //   266: iload 5
    //   268: iload 6
    //   270: iadd
    //   271: istore 7
    //   273: iload 4
    //   275: ifeq +13 -> 288
    //   278: iload 7
    //   280: iload 7
    //   282: bipush 76
    //   284: idiv
    //   285: iadd
    //   286: istore 7
    //   288: iload 7
    //   290: newarray byte
    //   292: astore 8
    //   294: iconst_0
    //   295: istore 9
    //   297: iload_2
    //   298: iconst_2
    //   299: isub
    //   300: istore 10
    //   302: iconst_0
    //   303: istore 11
    //   305: iconst_0
    //   306: istore 12
    //   308: iload 12
    //   310: iload 10
    //   312: if_icmplt +72 -> 384
    //   315: iload 12
    //   317: iload_2
    //   318: if_icmpge +24 -> 342
    //   321: aload_0
    //   322: iload 12
    //   324: iload_1
    //   325: iadd
    //   326: iload_2
    //   327: iload 12
    //   329: isub
    //   330: aload 8
    //   332: iload 9
    //   334: iload_3
    //   335: invokestatic 145	anywheresoftware/b4a/objects/Base64:encode3to4	([BII[BII)[B
    //   338: pop
    //   339: iinc 9 4
    //   342: iload 9
    //   344: aload 8
    //   346: arraylength
    //   347: iconst_1
    //   348: isub
    //   349: if_icmpgt +103 -> 452
    //   352: iload 9
    //   354: newarray byte
    //   356: astore 17
    //   358: aload 8
    //   360: iconst_0
    //   361: aload 17
    //   363: iconst_0
    //   364: iload 9
    //   366: invokestatic 255	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   369: aload 17
    //   371: areturn
    //   372: iconst_0
    //   373: istore 4
    //   375: goto -125 -> 250
    //   378: iconst_0
    //   379: istore 6
    //   381: goto -115 -> 266
    //   384: aload_0
    //   385: iload 12
    //   387: iload_1
    //   388: iadd
    //   389: iconst_3
    //   390: aload 8
    //   392: iload 9
    //   394: iload_3
    //   395: invokestatic 145	anywheresoftware/b4a/objects/Base64:encode3to4	([BII[BII)[B
    //   398: pop
    //   399: iload 11
    //   401: iconst_4
    //   402: iadd
    //   403: istore 14
    //   405: iload 4
    //   407: ifeq +216 -> 623
    //   410: iload 14
    //   412: bipush 76
    //   414: if_icmplt +209 -> 623
    //   417: aload 8
    //   419: iload 9
    //   421: iconst_4
    //   422: iadd
    //   423: bipush 10
    //   425: bastore
    //   426: iinc 9 1
    //   429: iconst_0
    //   430: istore 15
    //   432: iload 12
    //   434: iconst_3
    //   435: iadd
    //   436: istore 16
    //   438: iinc 9 4
    //   441: iload 15
    //   443: istore 11
    //   445: iload 16
    //   447: istore 12
    //   449: goto -141 -> 308
    //   452: aload 8
    //   454: areturn
    //   455: astore 28
    //   457: goto -230 -> 227
    //   460: astore 29
    //   462: goto -230 -> 232
    //   465: astore 30
    //   467: goto -230 -> 237
    //   470: astore 32
    //   472: goto -286 -> 186
    //   475: astore 33
    //   477: goto -286 -> 191
    //   480: astore 34
    //   482: goto -286 -> 196
    //   485: astore 39
    //   487: aload 39
    //   489: astore 27
    //   491: aconst_null
    //   492: astore 26
    //   494: aconst_null
    //   495: astore 25
    //   497: aconst_null
    //   498: astore 24
    //   500: goto -278 -> 222
    //   503: astore 38
    //   505: aload 38
    //   507: astore 27
    //   509: aload 19
    //   511: astore 25
    //   513: aconst_null
    //   514: astore 26
    //   516: aconst_null
    //   517: astore 24
    //   519: goto -297 -> 222
    //   522: astore 36
    //   524: aload 36
    //   526: astore 27
    //   528: aload 19
    //   530: astore 25
    //   532: aload 20
    //   534: astore 26
    //   536: aconst_null
    //   537: astore 24
    //   539: goto -317 -> 222
    //   542: astore 31
    //   544: aload 21
    //   546: astore 24
    //   548: aload 19
    //   550: astore 25
    //   552: aload 31
    //   554: astore 27
    //   556: aload 20
    //   558: astore 26
    //   560: goto -338 -> 222
    //   563: astore 37
    //   565: aload 37
    //   567: astore 23
    //   569: aload 19
    //   571: astore 25
    //   573: aconst_null
    //   574: astore 26
    //   576: aconst_null
    //   577: astore 24
    //   579: goto -362 -> 217
    //   582: astore 35
    //   584: aload 35
    //   586: astore 23
    //   588: aload 19
    //   590: astore 25
    //   592: aload 20
    //   594: astore 26
    //   596: aconst_null
    //   597: astore 24
    //   599: goto -382 -> 217
    //   602: astore 22
    //   604: aload 22
    //   606: astore 23
    //   608: aload 21
    //   610: astore 24
    //   612: aload 19
    //   614: astore 25
    //   616: aload 20
    //   618: astore 26
    //   620: goto -403 -> 217
    //   623: iload 14
    //   625: istore 15
    //   627: goto -195 -> 432
    //
    // Exception table:
    //   from	to	target	type
    //   134	143	202	java/io/IOException
    //   217	220	220	finally
    //   222	227	455	java/lang/Exception
    //   227	232	460	java/lang/Exception
    //   232	237	465	java/lang/Exception
    //   181	186	470	java/lang/Exception
    //   186	191	475	java/lang/Exception
    //   191	196	480	java/lang/Exception
    //   134	143	485	finally
    //   143	157	503	finally
    //   157	168	522	finally
    //   168	181	542	finally
    //   143	157	563	java/io/IOException
    //   157	168	582	java/io/IOException
    //   168	181	602	java/io/IOException
  }

  // ERROR //
  public static void encodeFileToFile(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 425	anywheresoftware/b4a/objects/Base64:encodeFromFile	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: new 273	java/io/BufferedOutputStream
    //   10: dup
    //   11: new 275	java/io/FileOutputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 276	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 279	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 4
    //   24: aload 4
    //   26: aload_2
    //   27: ldc 34
    //   29: invokevirtual 177	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   32: invokevirtual 283	java/io/OutputStream:write	([B)V
    //   35: aload 4
    //   37: invokevirtual 284	java/io/OutputStream:close	()V
    //   40: return
    //   41: astore 10
    //   43: aload 10
    //   45: astore 6
    //   47: aload 6
    //   49: athrow
    //   50: astore 7
    //   52: aload_3
    //   53: invokevirtual 284	java/io/OutputStream:close	()V
    //   56: aload 7
    //   58: athrow
    //   59: astore 8
    //   61: goto -5 -> 56
    //   64: astore 9
    //   66: return
    //   67: astore 7
    //   69: aload 4
    //   71: astore_3
    //   72: goto -20 -> 52
    //   75: astore 5
    //   77: aload 5
    //   79: astore 6
    //   81: aload 4
    //   83: astore_3
    //   84: goto -37 -> 47
    //
    // Exception table:
    //   from	to	target	type
    //   7	24	41	java/io/IOException
    //   7	24	50	finally
    //   47	50	50	finally
    //   52	56	59	java/lang/Exception
    //   35	40	64	java/lang/Exception
    //   24	35	67	finally
    //   24	35	75	java/io/IOException
  }

  // ERROR //
  public static String encodeFromFile(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 286	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 287	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: dconst_1
    //   12: ldc2_w 426
    //   15: aload_2
    //   16: invokevirtual 291	java/io/File:length	()J
    //   19: l2d
    //   20: dmul
    //   21: dadd
    //   22: d2i
    //   23: bipush 40
    //   25: invokestatic 430	java/lang/Math:max	(II)I
    //   28: newarray byte
    //   30: astore 7
    //   32: iconst_0
    //   33: istore 8
    //   35: new 305	anywheresoftware/b4a/objects/Base64$InputStream
    //   38: dup
    //   39: new 308	java/io/BufferedInputStream
    //   42: dup
    //   43: new 310	java/io/FileInputStream
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 313	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 314	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: iconst_1
    //   55: invokespecial 317	anywheresoftware/b4a/objects/Base64$InputStream:<init>	(Ljava/io/InputStream;I)V
    //   58: astore 9
    //   60: aload 9
    //   62: aload 7
    //   64: iload 8
    //   66: sipush 4096
    //   69: invokevirtual 320	anywheresoftware/b4a/objects/Base64$InputStream:read	([BII)I
    //   72: istore 11
    //   74: iload 11
    //   76: ifge +27 -> 103
    //   79: new 174	java/lang/String
    //   82: dup
    //   83: aload 7
    //   85: iconst_0
    //   86: iload 8
    //   88: ldc 34
    //   90: invokespecial 433	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   93: astore 12
    //   95: aload 9
    //   97: invokevirtual 306	anywheresoftware/b4a/objects/Base64$InputStream:close	()V
    //   100: aload 12
    //   102: areturn
    //   103: iload 8
    //   105: iload 11
    //   107: iadd
    //   108: istore 8
    //   110: goto -50 -> 60
    //   113: astore 5
    //   115: aload 5
    //   117: astore 6
    //   119: aload 6
    //   121: athrow
    //   122: astore_3
    //   123: aload_1
    //   124: invokevirtual 306	anywheresoftware/b4a/objects/Base64$InputStream:close	()V
    //   127: aload_3
    //   128: athrow
    //   129: astore 4
    //   131: goto -4 -> 127
    //   134: astore 13
    //   136: aload 12
    //   138: areturn
    //   139: astore_3
    //   140: aload 9
    //   142: astore_1
    //   143: goto -20 -> 123
    //   146: astore 10
    //   148: aload 10
    //   150: astore 6
    //   152: aload 9
    //   154: astore_1
    //   155: goto -36 -> 119
    //
    // Exception table:
    //   from	to	target	type
    //   2	32	113	java/io/IOException
    //   35	60	113	java/io/IOException
    //   2	32	122	finally
    //   35	60	122	finally
    //   119	122	122	finally
    //   123	127	129	java/lang/Exception
    //   95	100	134	java/lang/Exception
    //   60	74	139	finally
    //   79	95	139	finally
    //   60	74	146	java/io/IOException
    //   79	95	146	java/io/IOException
  }

  public static String encodeObject(Serializable paramSerializable)
    throws IOException
  {
    return encodeObject(paramSerializable, 0);
  }

  // ERROR //
  public static String encodeObject(Serializable paramSerializable, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +14 -> 15
    //   4: new 167	java/lang/NullPointerException
    //   7: dup
    //   8: ldc_w 440
    //   11: invokespecial 172	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aconst_null
    //   16: astore_2
    //   17: aconst_null
    //   18: astore_3
    //   19: aconst_null
    //   20: astore 4
    //   22: aconst_null
    //   23: astore 5
    //   25: new 184	java/io/ByteArrayOutputStream
    //   28: dup
    //   29: invokespecial 185	java/io/ByteArrayOutputStream:<init>	()V
    //   32: astore 6
    //   34: new 323	anywheresoftware/b4a/objects/Base64$OutputStream
    //   37: dup
    //   38: aload 6
    //   40: iload_1
    //   41: iconst_1
    //   42: ior
    //   43: invokespecial 326	anywheresoftware/b4a/objects/Base64$OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   46: astore 7
    //   48: iload_1
    //   49: iconst_2
    //   50: iand
    //   51: ifeq +78 -> 129
    //   54: new 417	java/util/zip/GZIPOutputStream
    //   57: dup
    //   58: aload 7
    //   60: invokespecial 418	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   63: astore 22
    //   65: new 442	java/io/ObjectOutputStream
    //   68: dup
    //   69: aload 22
    //   71: invokespecial 443	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   74: astore 23
    //   76: aload 23
    //   78: astore 5
    //   80: aload 22
    //   82: astore 4
    //   84: aload 5
    //   86: aload_0
    //   87: invokevirtual 446	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   90: aload 5
    //   92: invokevirtual 447	java/io/ObjectOutputStream:close	()V
    //   95: aload 4
    //   97: invokevirtual 420	java/util/zip/GZIPOutputStream:close	()V
    //   100: aload 7
    //   102: invokevirtual 284	java/io/OutputStream:close	()V
    //   105: aload 6
    //   107: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   110: new 174	java/lang/String
    //   113: dup
    //   114: aload 6
    //   116: invokevirtual 203	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   119: ldc 34
    //   121: invokespecial 404	java/lang/String:<init>	([BLjava/lang/String;)V
    //   124: astore 20
    //   126: aload 20
    //   128: areturn
    //   129: new 442	java/io/ObjectOutputStream
    //   132: dup
    //   133: aload 7
    //   135: invokespecial 443	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   138: astore 8
    //   140: aload 8
    //   142: astore 5
    //   144: aconst_null
    //   145: astore 4
    //   147: goto -63 -> 84
    //   150: astore 26
    //   152: aload 26
    //   154: astore 10
    //   156: aload 10
    //   158: athrow
    //   159: astore 11
    //   161: aload 5
    //   163: invokevirtual 447	java/io/ObjectOutputStream:close	()V
    //   166: aload 4
    //   168: invokevirtual 420	java/util/zip/GZIPOutputStream:close	()V
    //   171: aload_3
    //   172: invokevirtual 284	java/io/OutputStream:close	()V
    //   175: aload_2
    //   176: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   179: aload 11
    //   181: athrow
    //   182: astore 21
    //   184: new 174	java/lang/String
    //   187: dup
    //   188: aload 6
    //   190: invokevirtual 203	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   193: invokespecial 405	java/lang/String:<init>	([B)V
    //   196: areturn
    //   197: astore 12
    //   199: goto -33 -> 166
    //   202: astore 13
    //   204: goto -33 -> 171
    //   207: astore 14
    //   209: goto -34 -> 175
    //   212: astore 15
    //   214: goto -35 -> 179
    //   217: astore 16
    //   219: goto -124 -> 95
    //   222: astore 17
    //   224: goto -124 -> 100
    //   227: astore 18
    //   229: goto -124 -> 105
    //   232: astore 19
    //   234: goto -124 -> 110
    //   237: astore 11
    //   239: aload 6
    //   241: astore_2
    //   242: aconst_null
    //   243: astore_3
    //   244: aconst_null
    //   245: astore 4
    //   247: aconst_null
    //   248: astore 5
    //   250: goto -89 -> 161
    //   253: astore 11
    //   255: aload 7
    //   257: astore_3
    //   258: aload 6
    //   260: astore_2
    //   261: goto -100 -> 161
    //   264: astore 11
    //   266: aload 22
    //   268: astore 4
    //   270: aload 7
    //   272: astore_3
    //   273: aload 6
    //   275: astore_2
    //   276: aconst_null
    //   277: astore 5
    //   279: goto -118 -> 161
    //   282: astore 25
    //   284: aload 25
    //   286: astore 10
    //   288: aload 6
    //   290: astore_2
    //   291: aconst_null
    //   292: astore_3
    //   293: aconst_null
    //   294: astore 4
    //   296: aconst_null
    //   297: astore 5
    //   299: goto -143 -> 156
    //   302: astore 9
    //   304: aload 9
    //   306: astore 10
    //   308: aload 7
    //   310: astore_3
    //   311: aload 6
    //   313: astore_2
    //   314: goto -158 -> 156
    //   317: astore 24
    //   319: aload 24
    //   321: astore 10
    //   323: aload 22
    //   325: astore 4
    //   327: aload 7
    //   329: astore_3
    //   330: aload 6
    //   332: astore_2
    //   333: aconst_null
    //   334: astore 5
    //   336: goto -180 -> 156
    //
    // Exception table:
    //   from	to	target	type
    //   25	34	150	java/io/IOException
    //   25	34	159	finally
    //   156	159	159	finally
    //   110	126	182	java/io/UnsupportedEncodingException
    //   161	166	197	java/lang/Exception
    //   166	171	202	java/lang/Exception
    //   171	175	207	java/lang/Exception
    //   175	179	212	java/lang/Exception
    //   90	95	217	java/lang/Exception
    //   95	100	222	java/lang/Exception
    //   100	105	227	java/lang/Exception
    //   105	110	232	java/lang/Exception
    //   34	48	237	finally
    //   54	65	253	finally
    //   84	90	253	finally
    //   129	140	253	finally
    //   65	76	264	finally
    //   34	48	282	java/io/IOException
    //   54	65	302	java/io/IOException
    //   84	90	302	java/io/IOException
    //   129	140	302	java/io/IOException
    //   65	76	317	java/io/IOException
  }

  // ERROR //
  public static void encodeToFile(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +14 -> 15
    //   4: new 167	java/lang/NullPointerException
    //   7: dup
    //   8: ldc_w 450
    //   11: invokespecial 172	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aconst_null
    //   16: astore_2
    //   17: new 323	anywheresoftware/b4a/objects/Base64$OutputStream
    //   20: dup
    //   21: new 275	java/io/FileOutputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 276	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   29: iconst_1
    //   30: invokespecial 326	anywheresoftware/b4a/objects/Base64$OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   33: astore_3
    //   34: aload_3
    //   35: aload_0
    //   36: invokevirtual 327	anywheresoftware/b4a/objects/Base64$OutputStream:write	([B)V
    //   39: aload_3
    //   40: invokevirtual 328	anywheresoftware/b4a/objects/Base64$OutputStream:close	()V
    //   43: return
    //   44: astore 9
    //   46: aload 9
    //   48: astore 5
    //   50: aload 5
    //   52: athrow
    //   53: astore 6
    //   55: aload_2
    //   56: invokevirtual 328	anywheresoftware/b4a/objects/Base64$OutputStream:close	()V
    //   59: aload 6
    //   61: athrow
    //   62: astore 7
    //   64: goto -5 -> 59
    //   67: astore 8
    //   69: return
    //   70: astore 6
    //   72: aload_3
    //   73: astore_2
    //   74: goto -19 -> 55
    //   77: astore 4
    //   79: aload 4
    //   81: astore 5
    //   83: aload_3
    //   84: astore_2
    //   85: goto -35 -> 50
    //
    // Exception table:
    //   from	to	target	type
    //   17	34	44	java/io/IOException
    //   17	34	53	finally
    //   50	53	53	finally
    //   55	59	62	java/lang/Exception
    //   39	43	67	java/lang/Exception
    //   34	39	70	finally
    //   34	39	77	java/io/IOException
  }

  private static final byte[] getAlphabet(int paramInt)
  {
    if ((paramInt & 0x10) == 16)
      return _URL_SAFE_ALPHABET;
    if ((paramInt & 0x20) == 32)
      return _ORDERED_ALPHABET;
    return _STANDARD_ALPHABET;
  }

  private static final byte[] getDecodabet(int paramInt)
  {
    if ((paramInt & 0x10) == 16)
      return _URL_SAFE_DECODABET;
    if ((paramInt & 0x20) == 32)
      return _ORDERED_DECODABET;
    return _STANDARD_DECODABET;
  }

  @BA.Hide
  public static class InputStream extends FilterInputStream
  {
    private boolean breakLines;
    private byte[] buffer;
    private int bufferLength;
    private byte[] decodabet;
    private boolean encode;
    private int lineLength;
    private int numSigBytes;
    private int options;
    private int position;

    public InputStream(InputStream paramInputStream)
    {
      this(paramInputStream, 0);
    }

    public InputStream(InputStream paramInputStream, int paramInt)
    {
      super();
      this.options = paramInt;
      boolean bool1;
      boolean bool2;
      if ((paramInt & 0x8) > 0)
      {
        bool1 = true;
        this.breakLines = bool1;
        if ((paramInt & 0x1) <= 0)
          break label89;
        bool2 = true;
        label33: this.encode = bool2;
        if (!this.encode)
          break label95;
      }
      label89: label95: for (int i = 4; ; i = 3)
      {
        this.bufferLength = i;
        this.buffer = new byte[this.bufferLength];
        this.position = -1;
        this.lineLength = 0;
        this.decodabet = Base64.getDecodabet(paramInt);
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label33;
      }
    }

    public int read()
      throws IOException
    {
      byte[] arrayOfByte3;
      int n;
      if (this.position < 0)
      {
        if (this.encode)
        {
          arrayOfByte3 = new byte[3];
          n = 0;
        }
      }
      else
      {
        for (int i1 = 0; ; i1++)
        {
          if (i1 >= 3);
          int i2;
          do
          {
            if (n <= 0)
              break;
            Base64.encode3to4(arrayOfByte3, 0, n, this.buffer, 0, this.options);
            this.position = 0;
            this.numSigBytes = 4;
            if (this.position < 0)
              break label313;
            if (this.position < this.numSigBytes)
              break label229;
            return -1;
            i2 = this.in.read();
          }
          while (i2 < 0);
          arrayOfByte3[i1] = ((byte)i2);
          n++;
        }
        return -1;
      }
      byte[] arrayOfByte2 = new byte[4];
      for (int k = 0; ; k++)
      {
        if (k >= 4);
        int m;
        do
        {
          if (k != 4)
            break label212;
          this.numSigBytes = Base64.decode4to3(arrayOfByte2, 0, this.buffer, 0, this.options);
          this.position = 0;
          break;
          do
            m = this.in.read();
          while ((m >= 0) && (this.decodabet[(m & 0x7F)] <= -5));
        }
        while (m < 0);
        arrayOfByte2[k] = ((byte)m);
      }
      label212: if (k == 0)
        return -1;
      throw new IOException("Improperly padded Base64 input.");
      label229: if ((this.encode) && (this.breakLines) && (this.lineLength >= 76))
      {
        this.lineLength = 0;
        return 10;
      }
      this.lineLength = (1 + this.lineLength);
      byte[] arrayOfByte1 = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      int j = arrayOfByte1[i];
      if (this.position >= this.bufferLength)
        this.position = -1;
      return j & 0xFF;
      label313: throw new IOException("Error in Base64 code reading stream.");
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = 0;
      if (i >= paramInt2);
      do
      {
        return i;
        int j = read();
        if (j >= 0)
        {
          paramArrayOfByte[(paramInt1 + i)] = ((byte)j);
          i++;
          break;
        }
      }
      while (i != 0);
      return -1;
    }
  }

  @BA.Hide
  public static class OutputStream extends FilterOutputStream
  {
    private byte[] b4;
    private boolean breakLines;
    private byte[] buffer;
    private int bufferLength;
    private byte[] decodabet;
    private boolean encode;
    private int lineLength;
    private int options;
    private int position;
    private boolean suspendEncoding;

    public OutputStream(OutputStream paramOutputStream)
    {
      this(paramOutputStream, 1);
    }

    public OutputStream(OutputStream paramOutputStream, int paramInt)
    {
      super();
      boolean bool1;
      boolean bool2;
      if ((paramInt & 0x8) != 0)
      {
        bool1 = true;
        this.breakLines = bool1;
        if ((paramInt & 0x1) == 0)
          break label101;
        bool2 = true;
        label28: this.encode = bool2;
        if (!this.encode)
          break label107;
      }
      label101: label107: for (int i = 3; ; i = 4)
      {
        this.bufferLength = i;
        this.buffer = new byte[this.bufferLength];
        this.position = 0;
        this.lineLength = 0;
        this.suspendEncoding = false;
        this.b4 = new byte[4];
        this.options = paramInt;
        this.decodabet = Base64.getDecodabet(paramInt);
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label28;
      }
    }

    public void close()
      throws IOException
    {
      flushBase64();
      super.close();
      this.buffer = null;
      this.out = null;
    }

    public void flushBase64()
      throws IOException
    {
      if (this.position > 0)
      {
        if (this.encode)
        {
          this.out.write(Base64.encode3to4(this.b4, this.buffer, this.position, this.options));
          this.position = 0;
        }
      }
      else
        return;
      throw new IOException("Base64 input not properly padded.");
    }

    public void resumeEncoding()
    {
      this.suspendEncoding = false;
    }

    public void suspendEncoding()
      throws IOException
    {
      flushBase64();
      this.suspendEncoding = true;
    }

    public void write(int paramInt)
      throws IOException
    {
      if (this.suspendEncoding)
        this.out.write(paramInt);
      do
      {
        do
        {
          do
          {
            return;
            if (!this.encode)
              break;
            byte[] arrayOfByte2 = this.buffer;
            int k = this.position;
            this.position = (k + 1);
            arrayOfByte2[k] = ((byte)paramInt);
          }
          while (this.position < this.bufferLength);
          this.out.write(Base64.encode3to4(this.b4, this.buffer, this.bufferLength, this.options));
          this.lineLength = (4 + this.lineLength);
          if ((this.breakLines) && (this.lineLength >= 76))
          {
            this.out.write(10);
            this.lineLength = 0;
          }
          this.position = 0;
          return;
          if (this.decodabet[(paramInt & 0x7F)] <= -5)
            break;
          byte[] arrayOfByte1 = this.buffer;
          int i = this.position;
          this.position = (i + 1);
          arrayOfByte1[i] = ((byte)paramInt);
        }
        while (this.position < this.bufferLength);
        int j = Base64.decode4to3(this.buffer, 0, this.b4, 0, this.options);
        this.out.write(this.b4, 0, j);
        this.position = 0;
        return;
      }
      while (this.decodabet[(paramInt & 0x7F)] == -5);
      throw new IOException("Invalid character in Base64 data.");
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.suspendEncoding)
        this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      while (true)
      {
        return;
        for (int i = 0; i < paramInt2; i++)
          write(paramArrayOfByte[(paramInt1 + i)]);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.Base64
 * JD-Core Version:    0.6.2
 */