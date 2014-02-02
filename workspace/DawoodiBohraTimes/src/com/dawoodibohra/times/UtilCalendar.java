package com.dawoodibohra.times;

import android.text.format.Time;

public class UtilCalendar
{
  public static int getDayOfHijriYear(int[] paramArrayOfInt)
  {
    return paramArrayOfInt[0] + 59 * (paramArrayOfInt[1] / 2) + 30 * (paramArrayOfInt[1] % 2);
  }

  public static Time getGregDate(int[] paramArrayOfInt)
  {
    Time localTime = new Time();
    localTime.set(1, 0, 2005);
    int[] arrayOfInt = getMisriDate(localTime);
    for (int i = 0; ; i++)
    {
      if ((arrayOfInt == paramArrayOfInt) || (i >= 5))
        return localTime;
      long l1 = 30617280000L * (paramArrayOfInt[2] - arrayOfInt[2]);
      long l2 = 2551440000L * (paramArrayOfInt[1] - arrayOfInt[1]);
      localTime.set(86400000L * (paramArrayOfInt[0] - arrayOfInt[0]) + (l2 + (l1 + localTime.toMillis(false))));
      arrayOfInt = getMisriDate(localTime);
    }
  }

  public static String getGregDay(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
      return "Sunday";
    case 1:
      return "Monday";
    case 2:
      return "Tuesday";
    case 3:
      return "Wednesday";
    case 4:
      return "Thursday";
    case 5:
      return "Friday";
    case 6:
    }
    return "Saturday";
  }

  public static String getGregMonth(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
      return "January";
    case 1:
      return "February";
    case 2:
      return "March";
    case 3:
      return "April";
    case 4:
      return "May";
    case 5:
      return "June";
    case 6:
      return "July";
    case 7:
      return "August";
    case 8:
      return "September";
    case 9:
      return "October";
    case 10:
      return "November";
    case 11:
    }
    return "December";
  }

  public static String getMiqaat(int[] paramArrayOfInt)
  {
    Time localTime = getGregDate(paramArrayOfInt);
    int i = getDayOfHijriYear(paramArrayOfInt);
    new String();
    String str = "";
    switch (i)
    {
    default:
      label272: if ((paramArrayOfInt[0] == 13) && (((localTime.weekDay == 3) && (paramArrayOfInt[1] != 11)) || (paramArrayOfInt[1] == 6)))
        str = str + "\n• Rozu: Ayyam-ul-Beez";
      if ((paramArrayOfInt[0] == 14) && (((localTime.weekDay == 4) && (paramArrayOfInt[1] != 11)) || (paramArrayOfInt[1] == 6)))
        str = str + "\n• Rozu: Ayyam-ul-Beez";
      if ((paramArrayOfInt[0] == 15) && (((localTime.weekDay == 5) && (paramArrayOfInt[1] != 11)) || (paramArrayOfInt[1] == 6)))
        str = str + "\n• Rozu & Namaaz: Ayyam-ul-Beez, Salaat-uz-Zawaal & Das Surat";
      if ((paramArrayOfInt[1] == 8) && (paramArrayOfInt[0] > 23))
      {
        if ((paramArrayOfInt[0] != 24) || (localTime.weekDay != 5))
          break;
        str = str + "\n• Tasbeeh: Nabi na Naam after Isha";
        label488: if (localTime.weekDay == 5)
          str = str + "\n• Tasbeeh: Nabi na Naam at Zawaal";
      }
      switch (i)
      {
      default:
      case 7:
      case 10:
      case 16:
      case 17:
      case 31:
      case 33:
      case 34:
      case 52:
      case 57:
      case 61:
      case 69:
      case 82:
      case 84:
      case 105:
      case 111:
      case 116:
      case 163:
      case 166:
      case 171:
      case 175:
      case 176:
      case 177:
      case 181:
      case 184:
      case 195:
      case 196:
      case 201:
      case 203:
      case 208:
      case 222:
      case 223:
      case 234:
      case 245:
      case 255:
      case 272:
      case 274:
      case 275:
      case 276:
      case 304:
      case 307:
      case 308:
      case 310:
      case 314:
      case 316:
      case 320:
      case 326:
      case 341:
      case 352:
      }
      break;
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 50:
    case 58:
    case 71:
    case 93:
    case 128:
    case 178:
    case 190:
    case 204:
    case 222:
    case 229:
    case 253:
    case 255:
    case 257:
    case 259:
    case 267:
    case 334:
    case 335:
    case 336:
    case 337:
    case 338:
    case 343:
    }
    while (true)
      switch (i)
      {
      default:
        return str;
        str = str + "\n• Ashara Mubaraka: First Waaz";
        break label272;
        str = str + "\n• Ashara Mubaraka: Second Waaz";
        break label272;
        str = str + "\n• Ashara Mubaraka: Third Waaz";
        break label272;
        str = str + "\n• Ashara Mubaraka: Fourth Waaz";
        break label272;
        str = str + "\n• Ashara Mubaraka: Fifth Waaz";
        break label272;
        str = str + "\n• Ashara Mubaraka: Sixth Waaz";
        break label272;
        str = str + "\n• Ashara Mubaraka: Seventh Waaz";
        break label272;
        str = str + "\n• Ashara Mubaraka: Eigth Waaz (Tasu)";
        break label272;
        str = str + "\n• Ashara Mubaraka: Ninth Waaz (Ashura)";
        break label272;
        str = str + "\n• Chehlum: Imam Husain AS";
        break label272;
        str = str + "\n• Shahadat: Imam Hasan AS";
        break label272;
        str = str + "\n• Milad: Rasulullah SAW";
        break label272;
        str = str + "\n• Milad: Imam-uz-Zaman SA";
        break label272;
        str = str + "\n• Shahadat: Moulatena Fatema-tuz-Zahra SA";
        break label272;
        str = str + "\n• Namaaz: Washeq Raat (pehli raat)";
        break label272;
        str = str + "\n• Milad: Moulana Ali ibne Abi Talib SA";
        break label272;
        str = new StringBuilder(String.valueOf(str)).append("\n• Namaaz: Washeq Raat (27mi raat), Laylatul Meraj").toString() + "\n• Rozu: Yawm-ul-Mabas (Moti-us-Sawalat)";
        break label272;
        str = str + "\n• Namaaz: Washeq Raat (15mi raat), Laylatul Nisf";
        break label272;
        str = str + "\n• Urus: Moulatena Hurratul Maleka Arwa binte Ahmed AQ (Yemen Sanaa)";
        break label272;
        str = str + "\n• Namaaz: Washeq Raat (17mi raat), Layali Fazila";
        break label272;
        str = new StringBuilder(String.valueOf(str)).append("\n• Namaaz: Washeq Raat (19mi raat), Layali Fazila").toString() + "\n• Shahadat: Moulana Ali ibne Abi Talib SA";
        break label272;
        str = str + "\n• Namaaz: Washeq Raat (21mi raat), Layali Fazila";
        break label272;
        str = str + "\n• Namaaz: Washeq Raat (23mi raat), Laylatul Qadr";
        break label272;
        str = str + "\n• Eid & Takbeera: Eid-ul-Fitr";
        break label272;
        str = new StringBuilder(String.valueOf(str)).append("\n• Namaaz & Rozu: Yawm-e-Arafah").toString() + "\n• Takbeera: Eid-ul-Adha";
        break label272;
        str = str + "\n• Eid & Takbeera: Eid-ul-Adha";
        break label272;
        str = str + "\n• Takbeera: Eid-ul-Adha";
        break label272;
        str = str + "\n• Takbeera: Eid-ul-Adha";
        break label272;
        str = str + "\n• Takbeera: Eid-ul-Adha";
        break label272;
        str = str + "\n• Eid & Rozu: Ghadeer-e-Khum";
        break label272;
        if ((paramArrayOfInt[0] == 25) && ((localTime.weekDay == 5) || (localTime.weekDay == 6)))
        {
          str = str + "\n• Tasbeeh: Nabi na Naam after Isha";
          break label488;
        }
        if ((paramArrayOfInt[0] == 26) && ((localTime.weekDay == 5) || (localTime.weekDay == 6) || (localTime.weekDay == 0)))
        {
          str = str + "\n• Tasbeeh: Nabi na Naam after Isha";
          break label488;
        }
        if ((paramArrayOfInt[0] == 27) && ((localTime.weekDay == 5) || (localTime.weekDay == 6) || (localTime.weekDay == 0) || (localTime.weekDay == 1)))
        {
          str = str + "\n• Tasbeeh: Nabi na Naam after Isha";
          break label488;
        }
        if ((paramArrayOfInt[0] == 28) && ((localTime.weekDay == 5) || (localTime.weekDay == 6) || (localTime.weekDay == 0) || (localTime.weekDay == 1) || (localTime.weekDay == 2)))
        {
          str = str + "\n• Tasbeeh: Nabi na Naam after Isha";
          break label488;
        }
        if ((paramArrayOfInt[0] == 29) && ((localTime.weekDay == 5) || (localTime.weekDay == 6) || (localTime.weekDay == 0) || (localTime.weekDay == 1) || (localTime.weekDay == 2) || (localTime.weekDay == 3)))
        {
          str = str + "\n• Tasbeeh: Nabi na Naam after Isha";
          break label488;
        }
        if (paramArrayOfInt[0] != 30)
          break label488;
        str = str + "\n• Tasbeeh: Nabi na Naam after Isha";
        break label488;
        str = str + "\n• Urus: Syedna Ismail Badruddin RA [38th Dai] (India Jamnagar)";
        continue;
        str = str + "\n• Urus: Syedna Zoeb Bin Moosa RA [1st Dai] (Yemen Hoos)";
        continue;
        str = str + "\n• Urus: Syedna Hatim Bin Syedna Ibrahim RA [3rd Dai] (Yemen Hutaib Mubarak)";
        continue;
        str = str + "\n• Urus: Syedna Ibrahim Wajihuddin RA [39th Dai] (India Ujjain)";
        continue;
        str = str + "\n• Urus: Syedna Ali Bin Moulaya Hasan RA [10th Dai] (Yemen Sanaa)";
        continue;
        str = str + "\n• Urus: Syedna Ali Shamsuddin RA [18th Dai] (Yemen Shareqa)";
        continue;
        str = str + "\n• Urus: Syedna Abduttayyeb Zakiuddin RA [41st Dai] (India Burhanpur)";
        continue;
        str = str + "\n• Urus: Syedna Husain Bin Syedna Ali RA [8th Dai] (Yemen Sanaa)";
        continue;
        str = str + "\n• Urus: Syedna Mohammed Ezzuddin RA [23rd Dai] (Yemen Zabeed)";
        continue;
        str = str + "\n• Urus: Syedna Abduttayyeb Zakiuddin RA [29th Dai] (India Ahmedabad)";
        continue;
        str = str + "\n• Urus: Syedna Abdullah Badruddin RA [50th Dai] (India Surat)";
        continue;
        str = str + "\n• Urus Syedna Ali bin Hanzala RA [6th Dai] (Yemen Hamadan)";
        continue;
        str = str + "\n• Urus: Syedna Ali Shamsuddin RA [30th Dai] (Yemen Hisne Afedat)";
        continue;
        str = str + "\n• Urus: Syedna Jalaal Shamsuddin ibne Hasan RA [25th Dai] (India Ahmedabad)";
        continue;
        str = str + "\n• Urus: Syedna Moosa Kalimuddin ibne Syedna Zakiuddin RA [36th Dai] (India Jamnagar)";
        continue;
        str = str + "\n• Urus: Syedna Dawood ibne Ajab Shah Burhanuddin RA [26th Dai] (India Ahmedabad)";
        continue;
        str = str + "\n• Urus: Syedna Dawood ibne Qutub Shah Burhanuddin RA [27th Dai] (India Ahmedabad)";
        continue;
        str = str + "\n• Urus: Syedna Yusuf Najmuddin RA [42nd Dai] (India Surat)";
        continue;
        str = str + "\n• Urus: Syedna Ismail Badruddin bin Moulaya Raj RA [34th Dai] (India Jamnagar)";
        continue;
        str = str + "\n• Urus: Syedna Qutbuddin Shaheed RA [32nd Dai] (India Ahmedabad)";
        continue;
        str = str + "\n• Urus: Syedna Ahmed bin Al Mubarak RA [7th Dai] (Yemen Hamdaan)";
        continue;
        str = str + "\n• Urus: Syedna Mohammed Badruddin RA [46th Dai] (India Surat)";
        continue;
        str = str + "\n• Urus: Syedna Noor Mohammed Nooruddin RA [37th Dai] (India Kutch-Mandvi)";
        continue;
        str = str + "\n• Urus: Syedna Shaikh Adam Safiuddin RA [28th Dai] (India Ahmedabad)";
        continue;
        str = str + "\n• Urus: Syedna Ali Shamsuddin RA [13th Dai] (Yemen Zamarmar)";
        continue;
        str = str + "\n• Urus: Syedna Taher Saifuddin RA [51st Dai] (India Mumbai)";
        continue;
        str = str + "\n• Urus: Syedna Abdul Muttalib Najmuddin bin Syedna Mohammed bin Hatim RA [14th Dai] (Yemen Zamarmar)";
        continue;
        str = str + "\n• Urus: Syedna Abdul Qadir Najmuddin RA [47th Dai] (India Ujjain)";
        continue;
        str = str + "\n• Urus: Syedna Hebatullah Al Moayyed ibne Syedna Ibrahim Vajihuddin RA [40th Dai] (India Ujjain)";
        continue;
        str = str + "\n• Urus: Syedna Hassan Badruddin ibne Syedna Idris Imaduddin RA [20th Dai] (Yemen Masaar)";
        continue;
        str = str + "\n• Urus: Syedna Ibrahim bin Syedna Hussain Al Hamidi RA [2nd Dai] (Yemen Hamdaan)";
        continue;
        str = str + "\n• Urus: Syedna Ali bin Mohammed bin Al Waleed RA [5th Dai] (Yemen Haraaz)";
        continue;
        str = str + "\n• Urus: Syedna Abdullah Fakhruddin ibne Ali RA [16th Dai] (Yemen Zamarmar)";
        continue;
        str = str + "\n• Urus: Syedna Mohammed Ezzuddin ibne Syedi Jeevanji Saheb RA [44th Dai] (India Surat)";
        continue;
        str = str + "\n• Urus: Syedna Hasan Badruddin RA [17th Dai] (Yemen Zamarmar)";
        continue;
        str = str + "\n• Urus: Syedna Abbas Bin Syedna Mohammed RA [15th Dai] (Yemen Hisne Afedat)";
        continue;
        str = str + "\n• Urus: Syedna Qasimkhan Zainuddin RA [31st Dai] (India Ahmedabad)";
        continue;
        str = new StringBuilder(String.valueOf(str)).append("\n• Urus: Syedna Ibrahim Bin Syedna Husain RA [11th Dai] (Yemen Hisne Afedat)").toString() + "\n• Urus: Syedna Husain Husamuddin RA [21st Dai] (Yemen Masaar)";
        continue;
        str = str + "\n• Urus: Syedna Feerkhan Shujauddin RA [33rd Dai] (India Ahmedabad)";
        continue;
        str = new StringBuilder(String.valueOf(str)).append("\n• Urus: Syedna Abduttayyeb Zakiuddin RA [35th Dai] (India Jamnagar)").toString() + "\n• Urus: Syedna Abdeali Saifuddin RA [43rd Dai] (India Surat)";
        continue;
        str = str + "\n• Urus: Syedna Ali Bin Syedna Husain RA [9th Dai] (Yemen Sanaa)";
        continue;
        str = str + "\n• Urus: Syedna Tayyeb Zainuddin RA [45th Dai] (India Surat)";
        continue;
        str = str + "\n• Urus: Syedna Idris Imaduddin RA [19th Dai] (Yemen Shibaam)";
        continue;
        str = str + "\n• Urus: Syedna Ali Shamsuddin RA [22nd Dai] (Yemen Masaar)";
        continue;
        str = str + "\n• Urus: Syedna Ali Bin Syedna Hatim RA [4th Dai] (Yemen Sanaa)";
        continue;
        str = str + "\n• Urus: Syedna Mohammed bin Syedi Hatim RA [12th Dai] (Yemen Hisne Afedat)";
        continue;
        str = str + "\n• Urus: Syedna Yusuf Najmuddin RA [24th Dai] (Yemen Taibah)";
        continue;
        str = new StringBuilder(String.valueOf(str)).append("\n• Urus: Syedna Abdul Hussain Husamuddin RA [48th Dai] (India Ahmedabad)").toString() + "\n• Urus: Syedna Mohammed Burhanuddin RA [49th Dai] (India Surat)";
      case 1:
      case 2:
      case 10:
      case 14:
      case 17:
      case 18:
      case 23:
      case 27:
      case 28:
      case 29:
      case 36:
      case 38:
      case 39:
      case 42:
      case 43:
      case 44:
      case 45:
      case 47:
      case 60:
      case 63:
      case 66:
      case 71:
      case 73:
      case 81:
      case 82:
      case 86:
      case 97:
      case 99:
      case 103:
      case 109:
      case 111:
      case 118:
      case 119:
      case 121:
      case 126:
      case 129:
      case 133:
      case 134:
      case 139:
      case 141:
      case 156:
      case 162:
      case 166:
      case 174:
      case 175:
      case 176:
      case 179:
      case 181:
      case 182:
      case 185:
      case 188:
      case 189:
      case 191:
      case 194:
      case 195:
      case 201:
      case 204:
      case 206:
      case 226:
      case 229:
      case 232:
      case 236:
      case 237:
      case 238:
      case 239:
      case 244:
      case 252:
      case 259:
      case 270:
      case 271:
      case 273:
      case 279:
      case 290:
      case 291:
      case 292:
      case 293:
      case 295:
      case 299:
      case 303:
      case 306:
      case 310:
      case 315:
      case 317:
      case 322:
      case 331:
      case 338:
      case 341:
      case 352:
      }
    return str + "\n• Urus: Moulaya Abdullah AQ (India Khambat)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Syedi Khanji Feer Saheb AQ [Mukasir] (India Udaipur)").toString() + "\n• Urus: Moulaya Raj Bin Maulaya Hasan AQ (India Ahmedabad)";
    return str + "\n• Urus: Moulaya Ahmed AQ (India Khambat)";
    return str + "\n• Urus: Moulaya Luqmanji Bin Mulla Ali Bhai AQ (India Wankaner)";
    return str + "\n• Urus: Moulaya Masood Bin Moulaya Sulaiman AQ (India Dhangadhra)";
    return str + "\n• Urus: Syedi Ghani Feer Bin Dawoodji Shaheed AQ (India Kalavad)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Syedi Hasanfeer Shaheed AQ (India Denmaal)").toString() + "\n• Urus: Maisaab (India Daandi Gaam)";
    return str + "\n• Urus: Syedi Fakhruddin Shaheed AQ (India Taherabad)";
    return str + "\n• Urus: Syedi Moosanji Bin Taj Saheb AQ (India Baroda)";
    return str + "\n• Urus: Moulaya Hasan Bin Moulaya Adam AQ (India Ahmedabad)";
    return str + "\n• Urus: Syedi Abdeali Imaduddin Bin Shaikh Jeeva Bhai AQ (India Surat)";
    return str + "\n• Urus: Syedna Al Khattaab Bin Hasan Al Hamdani AQ";
    return str + "\n• Urus: Syedi Tayyeb BS Zainuddin AQ (India Surat)";
    return str + "\n• Urus: Syedi Ahmed Hameeduddin AQ Bin Syedna Abdullah RA";
    return str + "\n• Urus: Moulaya Adam Bin Sulaiman AQ (India Ahmedabad)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Kaka Akela Kaki Akela AQ (India Khambat)").toString() + "\n• Urus: Moulaya Nooh Saheb AQ (India Selaavi)";
    return str + "\n• Urus: Syedi Hamza Bhai Bin Syedi Qasim Khan AQ (India Surat)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Moulaya Shaikh Saheb Bin Sulaimanji AQ (Khwaja Mohammed Bin Ishaq Shaheed) (India Ahmedabad)").toString() + "\n• Urus: Syedi Shaikh Ibrahim AQ & Shaikh Abdullah Saheb Shaheed AQ (India Chechat)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Syedi Shaikh Adam Safiyuddin AQ (India Jamnagar)").toString() + "\n• Urus: Syedi Jamaluddin bin Shaikh Adam (India Jamnagar)";
    return str + "\n• Urus: Syedi Habibullah bin Mulla Adamji Bin Syedi Bawa Mulla Khan Saheb AQ (India Ujjain)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Syedi Abdeali Mohyuddin AQ (India Surat)").toString() + "\n• Urus: Syedi Shaikh Dawoodbhai Mulla Mehmoodji AQ (India Udaipur)";
    return str + "\n• Urus: Amatullah Aai Saheba AQ Aqeelato Dai al-Asr Syedna Mohammed Burhanuddin TUS (UK London)";
    return str + "\n• Urus: Syedi Miyaji Mulla Taj Saheb AQ (India Umreth)";
    return str + "\n• Urus: Moulaya Dawood Bin Moulaya Raj Saheb AQ (India Morbi)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Moulaya Raj Saheb AQ (India Morbi)").toString() + "\n• Urus: Syedi Qazi Khan Bin Ameenshah AQ [Mazoon] (India Halwad)";
    return str + "\n• Urus Mohammad bin Hasan Saheb (India Dhinoj)";
    return str + "\n• Urus: Mulla Raj ibne Mulla Adam (India Jamnagar)";
    return str + "\n• Urus: Syedi Abdul Rasul Shaheed AQ (India Banswara)";
    return str + "\n• Urus: Syedi Ismailji Shaheed (India Godhra)";
    return str + "\n• Milad: Dai al-Asr Syedna Mohammed Burhanuddin TUS";
    return str + "\n• Urus: Syedi Habibullah ibne Shaikh Sultan Ali (India Bharuch)";
    return str + "\n• Milad: Mazoon ud-Dawat Syedi Khuzaima Bhaisaheb Qutbuddin TUS";
    return str + "\n• Urus: Syedna Ahmed bin Syedna Ali Al Mukarram Sulaihi AQ (Yemen Sanaa)";
    return str + "\n• Urus: Syedi Qazikhan ibne Ali (India Sidhpur)";
    return str + "\n• Urus: Mulla Vahed Bhaisaheb Mulla Ibrahim (India Surat)";
    return str + "\n• Urus: Moulaya Nooruddin AQ (India Dongaam)";
    return str + "\n• Urus: Moulaya Dawood bin Kazi Ahmed Saheb (India Ahmedabad)";
    return str + "\n• Urus: Syedna Mohammed bin Idris Saheb AQ (Yemen)";
    return str + "\n• Urus: Sheth Chandabhai ibne Kareembhai (India Mumbai)";
    return str + "\n• Urus: Mulla Jaaferji Jivaji Saheb (India Amreli)";
    return str + "\n• Urus: Syedi Luqmaanji Moulaya Habibullah (India Surat)";
    return str + "\n• Urus: Ganje Shohada (India Ahmedabad)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Moulaya Adam ibne Dawood (India Jamnagar)").toString() + "\n• Urus: Moulaya Burhanuddin ibne Khoj (India Pisavada)";
    return str + "\n• Milad: Mukasir ud-Dawat Syedi Hussain Bhaisaheb Husamuddin TUS";
    return str + "\n• Urus: Syedna Lamak Bin Malik (Yemen)";
    return str + "\n• Urus: Syedna Yahya bin Lamak AQ (Yemen)";
    return str + "\n• Urus: Moulaya Raj bin Dawood (India Ahmedabad)";
    return str + "\n• Urus: Syedji Hasanji Badshah (India Ujjain)";
    return str + "\n• Urus: Syeda Fadela Fatema Aaisaheba (India Kutch-Mandvi)";
    return str + "\n• Urus: Syedi Saifuddin Saheb (India Jamnagar)";
    return str + "\n• Urus: Moulaya Raj ibne Dawood (India Ahmedabad)";
    return str + "\n• Urus: Syedi Najamkhan bin Syedna Feerkhan (India Aurangabad)";
    return str + "\n• Urus: Moulaya Yaqub Saheb (India Patan)";
    return str + "\n• Ayyam-ul-Barakatul Khuldiya";
    return str + "\n• Ayyam-ul-Barakatul Khuldiya";
    return str + "\n• Urus: Syedi Qamruddin Bhaisaheb bin Syedna Hebatullah Al Moayyed AQ (India Ujjain)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Aminji Shahid [Urus done on the 24th] (India Paddhari)").toString() + "\n• Urus: Syedi Miasaheb Alibhai bin Peeriji (India Radhanpur)";
    return str + "\n• Urus: Syedi Luqmanji bin Syedi Dawoodji (India Udaipur)";
    return str + "\n• Urus: Syedi Saleh Bhaisaheb Safiyuddin AQ [Mukasir] (India Mumbai)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Syedi Shaikh Feer bin Dawood Shaheed (India Peenpur-Saurashtra)").toString() + "\n• Urus: Syedi Shaikh Valibhai ibne Syedi Habibullah [Urus on 2nd of Ramadan, recited on 22nd Shaban] (India Parda-Malwa)";
    return str + "\n• Urus: Syedi Shams Khan ibne Syedi Yusufji (India Surat)";
    return str + "\n• Urus: Syedi Jeevanji bin Shaikh Dawood Bhaisaheb (India Burhanpur)";
    return str + "\n• Urus: Shaikh Dawood Bhaisaheb (India Dhinoj)";
    return str + "\n• Urus: Shaikh Valibhai bin Shaikh Habibullah (India Parda-Malwa)";
    return str + "\n• Urus: Syedi Tayeb Bhaisaheb Zainuddin bin Syedna Abdul Qadir Najmuddin (India Surat)";
    return str + "\n• Urus: Syedi Fazl Qutbuddin ibne Syedna Abdullah Badruddin AQ [Mazoon] (India Surat)";
    return str + "\n• Urus: Syedi Hebatullah Jamaluddin [Mazoon] (India Jamnagar)";
    return str + "\n• Milad: Mansoos ud-Dai-al-Asr Syedi Aali Qadr Mufaddal Bhaisaheb Saifuddin TUS";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Shehzadi Sakina Baisaheba binte Syedna Taher Saifuddin RA (India Mumbai)").toString() + "\n• Urus: Syedi Yusufji & Syedi Tayyebji Shaheed AQ (India Ahmedabad)";
    return str + "\n• Urus: Syedi Abdul Qadir Hakmuddin RA [Mazoon] - 1st Urus (India Burhanpur)";
    return str + "\n• Urus: Syedna Mohammed Bin Taher RA [Mazoon] (Yemen)";
    return str + "\n• Urus: Syedi Ameenji Bin Jalal (India Ahmedabad)";
    return str + "\n• Urus: Shaikh Qutubuddin Bhai Bin Sulaimanji (India Pune)";
    return str + "\n• Urus: Syedi Abde Moosa bin Syedna Ismail Badruddin RA (India Jamnagar)";
    return str + "\n• Urus: Syedi Qasim Khan Bin Syed Hamza Bhai RA [Mazoon] (India Surat)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Syedi Abdul Qadir Hakmuddin RA [Mazoon] - 2nd Urus (India Burhanpur)").toString() + "\n• Urus: Miyasaheb Abdul Ali Waliyullah AQ (India Jaora)";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Mulla Saleh Bhai bin Najam Khan (India Ahmedabad)").toString() + "\n• Urus: Syedi Bawa Mulla Khan AQ (India Rampura)";
    return str + "\n• Urus: Amatullah Aai Saheba AQ Aqeelato Syedna Mohammed Burhanuddin RA [49th Dai]";
    return str + "\n• Urus: Syedi Shaikh Adam Safiyuddin Bin Syedna Noor Mohammed Nooruddin RA";
    return new StringBuilder(String.valueOf(str)).append("\n• Urus: Syedi Hasan Bin Nooh Bharuchi AQ (Yemen Masaar)").toString() + "\n• Urus: Syedna Ali Bin Mohammed As Sulayhi (Yemen)";
    return str + "\n• Urus: Rani Bai Saheba AQ binte Syedna Ismail Badruddin RA";
    return str + "\n• Urus: Syedi Mulla Wali Bhai Shaheed bin Syedi Jivanji AQ";
    return str + "\n• Urus: Syedi Shaikh Sadiqali Saheb AQ (India Surat)";
    return new StringBuilder(String.valueOf(str)).append("\n• Milad: Syedna Taher Saifuddin RA [51st Dai]").toString() + "\n• Urus: Syedi Yusuf Khan bin Syedi Shams Khan AQ";
    return str + "\n• Urus: Syedi Khoj bin Malak (India Kaparwanj)";
    return str + "\n• Urus: Moulaya Feroz bin Ismailji AQ (India Ahmedabad)";
    return str + "\n• Urus: Syedi Ishaq Bhaisaheb Jamaluddin AQ [Mukasir]";
    return str + "\n• Urus: Ganj Shohoda AQ (India Ahmednagar)";
  }

  public static int[] getMisriDate(Time paramTime)
  {
    double d1 = paramTime.year;
    double d2 = paramTime.month;
    double d3 = paramTime.monthDay;
    double d4 = d2 + 1.0D;
    double d28;
    double d5;
    if (d4 < 3.0D)
    {
      double d27 = d1 - 1.0D;
      d28 = d4 + 12.0D;
      d5 = d27;
    }
    for (double d6 = d28; ; d6 = d4)
    {
      double d7 = Math.floor(d1 / 100.0D);
      double d8 = 2.0D - d7 + Math.floor(d7 / 4.0D);
      if (d5 < 1583.0D)
        d8 = 0.0D;
      if (d5 == 1582.0D)
      {
        if (d6 > 10.0D)
          d8 = -10.0D;
        if (d6 == 10.0D)
        {
          d8 = 0.0D;
          if (d3 > 4.0D)
            d8 = -10.0D;
        }
      }
      double d9 = d8 + (d3 + (Math.floor(365.25D * (d5 + 4716.0D)) + Math.floor(30.600100000000001D * (d6 + 1.0D)))) - 1524.0D;
      double d10 = 0.0D;
      if (d9 > 2299160.0D)
      {
        double d26 = Math.floor((d9 - 1867216.25D) / 36524.25D);
        d10 = 1.0D + d26 - Math.floor(d26 / 4.0D);
      }
      double d11 = 1524.0D + (d9 + d10);
      double d12 = Math.floor((d11 - 122.09999999999999D) / 365.25D);
      double d13 = Math.floor(365.25D * d12);
      double d14 = Math.floor((d11 - d13) / 30.600100000000001D);
      (d11 - d13 - Math.floor(30.600100000000001D * d14));
      (d14 - 1.0D);
      double d15;
      if (d14 > 13.0D)
      {
        d15 = 1.0D + d12;
        (d14 - 13.0D);
      }
      while (true)
      {
        (d15 - 4716.0D);
        double d16 = d9 - 1948084.0D;
        double d17 = Math.floor(d16 / 10631.0D);
        double d18 = d16 - 10631.0D * d17;
        double d19 = Math.floor((d18 - 0.0001666666666666667D) / 354.36666666666667D);
        double d20 = d19 + d17 * 30.0D;
        double d21 = d18 - Math.floor(0.0001666666666666667D + d19 * 354.36666666666667D);
        double d22 = Math.floor((28.5001D + d21) / 29.5D);
        if (d22 == 13.0D);
        for (double d23 = 12.0D; ; d23 = d22)
        {
          double d24 = d21 - Math.floor(29.5001D * d23 - 29.0D);
          double d25 = d23 - 1.0D;
          int[] arrayOfInt = new int[3];
          arrayOfInt[0] = ((int)d24);
          arrayOfInt[1] = ((int)d25);
          arrayOfInt[2] = ((int)d20);
          return arrayOfInt;
        }
        d15 = d12;
      }
      d5 = d1;
    }
  }

  public static String getMisriDay(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
      return "Yawm al-Ahad";
    case 1:
      return "Yawm al-Ithnain";
    case 2:
      return "Yawm al-Thalatha";
    case 3:
      return "Yawm al-Arba'a";
    case 4:
      return "Yawm al-Khamis";
    case 5:
      return "Yawm al-Jum'a";
    case 6:
    }
    return "Yawm al-Sabt";
  }

  public static String getMisriMonth(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
      return "Muharram al-Haraam";
    case 1:
      return "Safar al-Muzaffar";
    case 2:
      return "Rabi al-Awwal";
    case 3:
      return "Rabi al-Aakhar";
    case 4:
      return "Jumada al-Ula";
    case 5:
      return "Jumada al-Ukhra";
    case 6:
      return "Rajab al-Asab";
    case 7:
      return "Shaban al-Karim";
    case 8:
      return "Ramadan al-Moazzam";
    case 9:
      return "Shawwal al-Mukarram";
    case 10:
      return "Zilqad al-Haraam";
    case 11:
    }
    return "Zilhaj al-Haraam";
  }

  public static int getMonthSize(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[1] % 2 == 0);
    for (int i = 30; ; i = 29)
    {
      if ((paramArrayOfInt[1] == 11) && (isLeap(paramArrayOfInt)))
        i = 30;
      return i;
    }
  }

  public static int getYearSize(int[] paramArrayOfInt)
  {
    if (isLeap(paramArrayOfInt))
      return 355;
    return 354;
  }

  public static boolean isLeap(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[2] % 30;
    return (i == 2) || (i == 5) || (i == 8) || (i == 10) || (i == 13) || (i == 16) || (i == 19) || (i == 21) || (i == 24) || (i == 27) || (i == 29);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.UtilCalendar
 * JD-Core Version:    0.6.2
 */