package anywheresoftware.b4a.keywords;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.DynamicBuilder;
import anywheresoftware.b4a.objects.ActivityWrapper;
import anywheresoftware.b4a.objects.CustomViewWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@BA.Hide
public class LayoutBuilder
{
  private static double autoscale;
  private static HashMap<String, WeakReference<MapAndCachedStrings>> cachedLayouts = new HashMap();
  private static List<CustomViewWrapper> customViewWrappers;
  private static double screenSize = 0.0D;
  private static BA tempBA;
  private static HashMap<String, Object> viewsToSendInShellMode;

  public static double getScreenSize()
  {
    if (screenSize == 0.0D)
      screenSize = Math.sqrt(Math.pow(tempBA.vg.getWidth(), 2.0D) + Math.pow(tempBA.vg.getHeight(), 2.0D)) / 160.0D / Common.Density;
    return screenSize;
  }

  // ERROR //
  public static LayoutValuesAndMap loadLayout(String paramString, BA paramBA, boolean paramBoolean1, ViewGroup paramViewGroup, HashMap<String, ViewWrapper<?>> paramHashMap, boolean paramBoolean2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: putstatic 34	anywheresoftware/b4a/keywords/LayoutBuilder:tempBA	Lanywheresoftware/b4a/BA;
    //   4: iload 5
    //   6: ifne +15 -> 21
    //   9: getstatic 79	anywheresoftware/b4a/BA:cul	Ljava/util/Locale;
    //   12: astore 10
    //   14: aload_0
    //   15: aload 10
    //   17: invokevirtual 85	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: ldc 87
    //   24: invokevirtual 91	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   27: ifne +23 -> 50
    //   30: new 93	java/lang/StringBuilder
    //   33: dup
    //   34: aload_0
    //   35: invokestatic 97	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   38: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: ldc 87
    //   43: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_0
    //   50: getstatic 27	anywheresoftware/b4a/keywords/LayoutBuilder:cachedLayouts	Ljava/util/HashMap;
    //   53: aload_0
    //   54: invokevirtual 112	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 114	java/lang/ref/WeakReference
    //   60: astore 11
    //   62: aload 11
    //   64: ifnull +684 -> 748
    //   67: aload 11
    //   69: invokevirtual 117	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   72: checkcast 119	anywheresoftware/b4a/keywords/LayoutBuilder$MapAndCachedStrings
    //   75: astore 12
    //   77: new 121	java/io/DataInputStream
    //   80: dup
    //   81: invokestatic 126	anywheresoftware/b4a/objects/streams/File:getDirAssets	()Ljava/lang/String;
    //   84: aload_0
    //   85: invokestatic 130	anywheresoftware/b4a/objects/streams/File:OpenInput	(Ljava/lang/String;Ljava/lang/String;)Lanywheresoftware/b4a/objects/streams/File$InputStreamWrapper;
    //   88: invokevirtual 135	anywheresoftware/b4a/objects/streams/File$InputStreamWrapper:getObject	()Ljava/lang/Object;
    //   91: checkcast 137	java/io/InputStream
    //   94: invokespecial 140	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   97: astore 13
    //   99: aload 13
    //   101: invokestatic 146	anywheresoftware/b4a/ConnectorUtils:readInt	(Ljava/io/DataInputStream;)I
    //   104: istore 14
    //   106: aload 13
    //   108: invokestatic 146	anywheresoftware/b4a/ConnectorUtils:readInt	(Ljava/io/DataInputStream;)I
    //   111: istore 15
    //   113: iload 15
    //   115: ifgt +318 -> 433
    //   118: aconst_null
    //   119: checkcast 148	[Ljava/lang/String;
    //   122: astore 16
    //   124: iload 14
    //   126: iconst_3
    //   127: if_icmplt +627 -> 754
    //   130: aload 12
    //   132: ifnull +344 -> 476
    //   135: aload 12
    //   137: getfield 151	anywheresoftware/b4a/keywords/LayoutBuilder$MapAndCachedStrings:cachedStrings	[Ljava/lang/String;
    //   140: astore 45
    //   142: aload 13
    //   144: invokestatic 146	anywheresoftware/b4a/ConnectorUtils:readInt	(Ljava/io/DataInputStream;)I
    //   147: pop
    //   148: iconst_0
    //   149: istore 47
    //   151: iload 47
    //   153: aload 45
    //   155: arraylength
    //   156: if_icmplt +303 -> 459
    //   159: aload 45
    //   161: astore 17
    //   163: aload 13
    //   165: invokestatic 146	anywheresoftware/b4a/ConnectorUtils:readInt	(Ljava/io/DataInputStream;)I
    //   168: istore 18
    //   170: aconst_null
    //   171: astore 19
    //   173: aload_1
    //   174: invokestatic 155	anywheresoftware/b4a/keywords/Common:GetDeviceLayoutValues	(Lanywheresoftware/b4a/BA;)Lanywheresoftware/b4a/keywords/LayoutValues;
    //   177: astore 20
    //   179: ldc 156
    //   181: fstore 21
    //   183: iconst_0
    //   184: istore 22
    //   186: iconst_0
    //   187: istore 23
    //   189: iload 22
    //   191: iload 18
    //   193: if_icmplt +323 -> 516
    //   196: aload 19
    //   198: getfield 161	anywheresoftware/b4a/keywords/LayoutValues:Scale	F
    //   201: invokestatic 165	anywheresoftware/b4a/BALayout:setUserScale	(F)V
    //   204: aload 4
    //   206: ifnonnull +118 -> 324
    //   209: new 167	anywheresoftware/b4a/keywords/LayoutBuilder$LayoutHashMap
    //   212: dup
    //   213: invokespecial 168	anywheresoftware/b4a/keywords/LayoutBuilder$LayoutHashMap:<init>	()V
    //   216: astore 24
    //   218: aload 12
    //   220: ifnull +360 -> 580
    //   223: aload 12
    //   225: getfield 171	anywheresoftware/b4a/keywords/LayoutBuilder$MapAndCachedStrings:map	Ljava/util/HashMap;
    //   228: astore 25
    //   230: aload_1
    //   231: getfield 175	anywheresoftware/b4a/BA:eventsTarget	Ljava/lang/Object;
    //   234: ifnonnull +410 -> 644
    //   237: aload_1
    //   238: getfield 179	anywheresoftware/b4a/BA:activity	Landroid/app/Activity;
    //   241: astore 30
    //   243: new 93	java/lang/StringBuilder
    //   246: dup
    //   247: ldc 181
    //   249: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   252: astore 31
    //   254: aload 25
    //   256: aload_1
    //   257: aload 30
    //   259: aload_3
    //   260: iload_2
    //   261: aload 31
    //   263: iload 23
    //   265: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: iconst_1
    //   272: aload 24
    //   274: iload 5
    //   276: invokestatic 188	anywheresoftware/b4a/keywords/LayoutBuilder:loadLayoutHelper	(Ljava/util/HashMap;Lanywheresoftware/b4a/BA;Ljava/lang/Object;Landroid/view/ViewGroup;ZLjava/lang/String;ZLjava/util/HashMap;Z)V
    //   279: getstatic 192	anywheresoftware/b4a/BA:shellMode	Z
    //   282: ifeq +38 -> 320
    //   285: getstatic 194	anywheresoftware/b4a/keywords/LayoutBuilder:viewsToSendInShellMode	Ljava/util/HashMap;
    //   288: ifnull +32 -> 320
    //   291: iconst_1
    //   292: anewarray 4	java/lang/Object
    //   295: astore 40
    //   297: aload 40
    //   299: iconst_0
    //   300: getstatic 194	anywheresoftware/b4a/keywords/LayoutBuilder:viewsToSendInShellMode	Ljava/util/HashMap;
    //   303: aastore
    //   304: aload_1
    //   305: aconst_null
    //   306: iconst_1
    //   307: ldc 196
    //   309: iconst_1
    //   310: aload 40
    //   312: invokevirtual 200	anywheresoftware/b4a/BA:raiseEvent2	(Ljava/lang/Object;ZLjava/lang/String;Z[Ljava/lang/Object;)Ljava/lang/Object;
    //   315: pop
    //   316: aconst_null
    //   317: putstatic 194	anywheresoftware/b4a/keywords/LayoutBuilder:viewsToSendInShellMode	Ljava/util/HashMap;
    //   320: aload 24
    //   322: astore 4
    //   324: aload 13
    //   326: invokevirtual 203	java/io/DataInputStream:close	()V
    //   329: iload_2
    //   330: ifne +10 -> 340
    //   333: aload_3
    //   334: invokevirtual 209	android/view/ViewGroup:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   337: ifnonnull +320 -> 657
    //   340: aload_1
    //   341: getfield 40	anywheresoftware/b4a/BA:vg	Lanywheresoftware/b4a/BALayout;
    //   344: invokevirtual 46	anywheresoftware/b4a/BALayout:getWidth	()I
    //   347: istore 32
    //   349: aload_1
    //   350: getfield 40	anywheresoftware/b4a/BA:vg	Lanywheresoftware/b4a/BALayout;
    //   353: invokevirtual 57	anywheresoftware/b4a/BALayout:getHeight	()I
    //   356: istore 33
    //   358: getstatic 69	anywheresoftware/b4a/keywords/Common:Density	F
    //   361: fstore 34
    //   363: aload_0
    //   364: aload 19
    //   366: aload 4
    //   368: iload 32
    //   370: iload 33
    //   372: fload 34
    //   374: iload 5
    //   376: invokestatic 213	anywheresoftware/b4a/keywords/LayoutBuilder:runScripts	(Ljava/lang/String;Lanywheresoftware/b4a/keywords/LayoutValues;Ljava/util/HashMap;IIFZ)V
    //   379: fconst_1
    //   380: invokestatic 165	anywheresoftware/b4a/BALayout:setUserScale	(F)V
    //   383: getstatic 215	anywheresoftware/b4a/keywords/LayoutBuilder:customViewWrappers	Ljava/util/List;
    //   386: ifnull +23 -> 409
    //   389: getstatic 215	anywheresoftware/b4a/keywords/LayoutBuilder:customViewWrappers	Ljava/util/List;
    //   392: invokeinterface 221 1 0
    //   397: astore 36
    //   399: aload 36
    //   401: invokeinterface 227 1 0
    //   406: ifne +293 -> 699
    //   409: new 229	anywheresoftware/b4a/keywords/LayoutBuilder$LayoutValuesAndMap
    //   412: dup
    //   413: aload 19
    //   415: aload 4
    //   417: invokespecial 232	anywheresoftware/b4a/keywords/LayoutBuilder$LayoutValuesAndMap:<init>	(Lanywheresoftware/b4a/keywords/LayoutValues;Ljava/util/HashMap;)V
    //   420: astore 35
    //   422: aconst_null
    //   423: putstatic 34	anywheresoftware/b4a/keywords/LayoutBuilder:tempBA	Lanywheresoftware/b4a/BA;
    //   426: aconst_null
    //   427: putstatic 215	anywheresoftware/b4a/keywords/LayoutBuilder:customViewWrappers	Ljava/util/List;
    //   430: aload 35
    //   432: areturn
    //   433: iload 15
    //   435: i2l
    //   436: lstore 50
    //   438: iload 15
    //   440: i2l
    //   441: lstore 52
    //   443: lload 50
    //   445: aload 13
    //   447: lload 52
    //   449: invokevirtual 236	java/io/DataInputStream:skip	(J)J
    //   452: lsub
    //   453: l2i
    //   454: istore 15
    //   456: goto -343 -> 113
    //   459: aload 13
    //   461: aload 13
    //   463: invokestatic 146	anywheresoftware/b4a/ConnectorUtils:readInt	(Ljava/io/DataInputStream;)I
    //   466: invokevirtual 240	java/io/DataInputStream:skipBytes	(I)I
    //   469: pop
    //   470: iinc 47 1
    //   473: goto -322 -> 151
    //   476: aload 13
    //   478: invokestatic 146	anywheresoftware/b4a/ConnectorUtils:readInt	(Ljava/io/DataInputStream;)I
    //   481: anewarray 81	java/lang/String
    //   484: astore 16
    //   486: iconst_0
    //   487: istore 49
    //   489: iload 49
    //   491: aload 16
    //   493: arraylength
    //   494: if_icmplt +6 -> 500
    //   497: goto +257 -> 754
    //   500: aload 16
    //   502: iload 49
    //   504: aload 13
    //   506: invokestatic 244	anywheresoftware/b4a/ConnectorUtils:readString	(Ljava/io/DataInputStream;)Ljava/lang/String;
    //   509: aastore
    //   510: iinc 49 1
    //   513: goto -24 -> 489
    //   516: aload 13
    //   518: invokestatic 248	anywheresoftware/b4a/keywords/LayoutValues:readFromStream	(Ljava/io/DataInputStream;)Lanywheresoftware/b4a/keywords/LayoutValues;
    //   521: astore 42
    //   523: aload 19
    //   525: ifnonnull +23 -> 548
    //   528: aload 42
    //   530: astore 19
    //   532: aload 42
    //   534: aload 20
    //   536: invokevirtual 252	anywheresoftware/b4a/keywords/LayoutValues:calcDistance	(Lanywheresoftware/b4a/keywords/LayoutValues;)F
    //   539: fstore 21
    //   541: iload 22
    //   543: istore 44
    //   545: goto +216 -> 761
    //   548: aload 42
    //   550: aload 20
    //   552: invokevirtual 252	anywheresoftware/b4a/keywords/LayoutValues:calcDistance	(Lanywheresoftware/b4a/keywords/LayoutValues;)F
    //   555: fstore 43
    //   557: fload 43
    //   559: fload 21
    //   561: fcmpg
    //   562: ifge +179 -> 741
    //   565: aload 42
    //   567: astore 19
    //   569: fload 43
    //   571: fstore 21
    //   573: iload 22
    //   575: istore 44
    //   577: goto +184 -> 761
    //   580: aload 13
    //   582: aload 17
    //   584: invokestatic 256	anywheresoftware/b4a/ConnectorUtils:readMap	(Ljava/io/DataInputStream;[Ljava/lang/String;)Ljava/util/HashMap;
    //   587: astore 25
    //   589: getstatic 27	anywheresoftware/b4a/keywords/LayoutBuilder:cachedLayouts	Ljava/util/HashMap;
    //   592: astore 26
    //   594: new 114	java/lang/ref/WeakReference
    //   597: dup
    //   598: new 119	anywheresoftware/b4a/keywords/LayoutBuilder$MapAndCachedStrings
    //   601: dup
    //   602: aload 25
    //   604: aload 17
    //   606: invokespecial 259	anywheresoftware/b4a/keywords/LayoutBuilder$MapAndCachedStrings:<init>	(Ljava/util/HashMap;[Ljava/lang/String;)V
    //   609: invokespecial 262	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   612: astore 27
    //   614: aload 26
    //   616: aload_0
    //   617: aload 27
    //   619: invokevirtual 266	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   622: pop
    //   623: goto -393 -> 230
    //   626: astore 9
    //   628: aload 9
    //   630: athrow
    //   631: astore 8
    //   633: aconst_null
    //   634: putstatic 34	anywheresoftware/b4a/keywords/LayoutBuilder:tempBA	Lanywheresoftware/b4a/BA;
    //   637: aconst_null
    //   638: putstatic 215	anywheresoftware/b4a/keywords/LayoutBuilder:customViewWrappers	Ljava/util/List;
    //   641: aload 8
    //   643: athrow
    //   644: aload_1
    //   645: getfield 175	anywheresoftware/b4a/BA:eventsTarget	Ljava/lang/Object;
    //   648: astore 29
    //   650: aload 29
    //   652: astore 30
    //   654: goto -411 -> 243
    //   657: aload_3
    //   658: invokevirtual 209	android/view/ViewGroup:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   661: getfield 272	android/view/ViewGroup$LayoutParams:width	I
    //   664: istore 37
    //   666: aload_3
    //   667: invokevirtual 209	android/view/ViewGroup:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   670: getfield 275	android/view/ViewGroup$LayoutParams:height	I
    //   673: istore 38
    //   675: getstatic 69	anywheresoftware/b4a/keywords/Common:Density	F
    //   678: fstore 39
    //   680: aload_0
    //   681: aload 19
    //   683: aload 4
    //   685: iload 37
    //   687: iload 38
    //   689: fload 39
    //   691: iload 5
    //   693: invokestatic 213	anywheresoftware/b4a/keywords/LayoutBuilder:runScripts	(Ljava/lang/String;Lanywheresoftware/b4a/keywords/LayoutValues;Ljava/util/HashMap;IIFZ)V
    //   696: goto -317 -> 379
    //   699: aload 36
    //   701: invokeinterface 278 1 0
    //   706: checkcast 280	anywheresoftware/b4a/objects/CustomViewWrapper
    //   709: invokevirtual 283	anywheresoftware/b4a/objects/CustomViewWrapper:AfterDesignerScript	()V
    //   712: goto -313 -> 399
    //   715: astore 6
    //   717: new 285	java/lang/RuntimeException
    //   720: dup
    //   721: aload 6
    //   723: invokespecial 288	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   726: astore 7
    //   728: aload 7
    //   730: athrow
    //   731: astore 8
    //   733: goto -100 -> 633
    //   736: astore 6
    //   738: goto -21 -> 717
    //   741: iload 23
    //   743: istore 44
    //   745: goto +16 -> 761
    //   748: aconst_null
    //   749: astore 12
    //   751: goto -674 -> 77
    //   754: aload 16
    //   756: astore 17
    //   758: goto -595 -> 163
    //   761: iinc 22 1
    //   764: iload 44
    //   766: istore 23
    //   768: goto -579 -> 189
    //   771: astore 9
    //   773: goto -145 -> 628
    //
    // Exception table:
    //   from	to	target	type
    //   223	230	626	java/io/IOException
    //   230	243	626	java/io/IOException
    //   243	320	626	java/io/IOException
    //   580	623	626	java/io/IOException
    //   644	650	626	java/io/IOException
    //   0	4	631	finally
    //   9	21	631	finally
    //   21	50	631	finally
    //   50	62	631	finally
    //   67	77	631	finally
    //   77	113	631	finally
    //   118	124	631	finally
    //   135	148	631	finally
    //   151	159	631	finally
    //   163	170	631	finally
    //   173	179	631	finally
    //   196	204	631	finally
    //   209	218	631	finally
    //   324	329	631	finally
    //   333	340	631	finally
    //   340	379	631	finally
    //   379	399	631	finally
    //   399	409	631	finally
    //   409	422	631	finally
    //   443	456	631	finally
    //   459	470	631	finally
    //   476	486	631	finally
    //   489	497	631	finally
    //   500	510	631	finally
    //   516	523	631	finally
    //   532	541	631	finally
    //   548	557	631	finally
    //   628	631	631	finally
    //   657	696	631	finally
    //   699	712	631	finally
    //   717	731	631	finally
    //   0	4	715	java/lang/Exception
    //   9	21	715	java/lang/Exception
    //   21	50	715	java/lang/Exception
    //   50	62	715	java/lang/Exception
    //   67	77	715	java/lang/Exception
    //   77	113	715	java/lang/Exception
    //   118	124	715	java/lang/Exception
    //   135	148	715	java/lang/Exception
    //   151	159	715	java/lang/Exception
    //   163	170	715	java/lang/Exception
    //   173	179	715	java/lang/Exception
    //   196	204	715	java/lang/Exception
    //   209	218	715	java/lang/Exception
    //   324	329	715	java/lang/Exception
    //   333	340	715	java/lang/Exception
    //   340	379	715	java/lang/Exception
    //   379	399	715	java/lang/Exception
    //   399	409	715	java/lang/Exception
    //   409	422	715	java/lang/Exception
    //   443	456	715	java/lang/Exception
    //   459	470	715	java/lang/Exception
    //   476	486	715	java/lang/Exception
    //   489	497	715	java/lang/Exception
    //   500	510	715	java/lang/Exception
    //   516	523	715	java/lang/Exception
    //   532	541	715	java/lang/Exception
    //   548	557	715	java/lang/Exception
    //   657	696	715	java/lang/Exception
    //   699	712	715	java/lang/Exception
    //   223	230	731	finally
    //   230	243	731	finally
    //   243	320	731	finally
    //   580	623	731	finally
    //   644	650	731	finally
    //   223	230	736	java/lang/Exception
    //   230	243	736	java/lang/Exception
    //   243	320	736	java/lang/Exception
    //   580	623	736	java/lang/Exception
    //   644	650	736	java/lang/Exception
    //   0	4	771	java/io/IOException
    //   9	21	771	java/io/IOException
    //   21	50	771	java/io/IOException
    //   50	62	771	java/io/IOException
    //   67	77	771	java/io/IOException
    //   77	113	771	java/io/IOException
    //   118	124	771	java/io/IOException
    //   135	148	771	java/io/IOException
    //   151	159	771	java/io/IOException
    //   163	170	771	java/io/IOException
    //   173	179	771	java/io/IOException
    //   196	204	771	java/io/IOException
    //   209	218	771	java/io/IOException
    //   324	329	771	java/io/IOException
    //   333	340	771	java/io/IOException
    //   340	379	771	java/io/IOException
    //   379	399	771	java/io/IOException
    //   399	409	771	java/io/IOException
    //   409	422	771	java/io/IOException
    //   443	456	771	java/io/IOException
    //   459	470	771	java/io/IOException
    //   476	486	771	java/io/IOException
    //   489	497	771	java/io/IOException
    //   500	510	771	java/io/IOException
    //   516	523	771	java/io/IOException
    //   532	541	771	java/io/IOException
    //   548	557	771	java/io/IOException
    //   657	696	771	java/io/IOException
    //   699	712	771	java/io/IOException
  }

  private static void loadLayoutHelper(HashMap<String, Object> paramHashMap, BA paramBA, Object paramObject, ViewGroup paramViewGroup, boolean paramBoolean1, String paramString, boolean paramBoolean2, HashMap<String, ViewWrapper<?>> paramHashMap1, boolean paramBoolean3)
    throws Exception
  {
    HashMap localHashMap1 = (HashMap)paramHashMap.get(paramString);
    View localView;
    String str1;
    Object localObject2;
    label324: Object localObject1;
    if ((paramBoolean1) || (!paramBoolean2))
    {
      if (paramBoolean1);
      ViewWrapper localViewWrapper;
      String str3;
      for (ViewGroup localViewGroup = paramViewGroup; ; localViewGroup = null)
      {
        paramHashMap.put("left", localHashMap1.get("left"));
        paramHashMap.put("top", localHashMap1.get("top"));
        paramHashMap.put("width", localHashMap1.get("width"));
        paramHashMap.put("height", localHashMap1.get("height"));
        Context localContext = paramViewGroup.getContext();
        localView = (View)DynamicBuilder.build(localViewGroup, paramHashMap, false, localContext);
        if (paramBoolean1)
          break label603;
        str1 = ((String)paramHashMap.get("name")).toLowerCase(BA.cul);
        String str2 = (String)paramHashMap.get("type");
        if (str2.startsWith("."))
        {
          StringBuilder localStringBuilder1 = new StringBuilder("anywheresoftware.b4a.objects");
          str2 = str2;
        }
        localViewWrapper = (ViewWrapper)Class.forName(str2).newInstance();
        paramHashMap1.put(str1, localViewWrapper);
        localObject2 = localViewWrapper;
        if (!(localViewWrapper instanceof CustomViewWrapper))
          break label324;
        if (customViewWrappers == null)
          customViewWrappers = new ArrayList();
        customViewWrappers.add((CustomViewWrapper)localViewWrapper);
        str3 = (String)paramHashMap.get("customType");
        if ((str3 != null) && (str3.length() != 0))
          break;
        throw new RuntimeException("CustomView CustomType property was not set.");
      }
      Object localObject3 = Class.forName(str3).newInstance();
      CustomViewWrapper localCustomViewWrapper = (CustomViewWrapper)localViewWrapper;
      localCustomViewWrapper.customObject = localObject3;
      localCustomViewWrapper.props = paramHashMap;
      localObject2 = localObject3;
      if (!paramBoolean3)
      {
        if (BA.shellMode)
        {
          if (viewsToSendInShellMode == null)
            viewsToSendInShellMode = new HashMap();
          viewsToSendInShellMode.put(str1, localObject2);
        }
      }
      else
      {
        localViewWrapper.setObject(localView);
        if (!paramBoolean3)
          localViewWrapper.innerInitialize(paramBA, ((String)paramHashMap.get("eventName")).toLowerCase(BA.cul), true);
        paramViewGroup.addView(localView, localView.getLayoutParams());
        localObject1 = localView;
      }
    }
    while (true)
    {
      label412: HashMap localHashMap2 = (HashMap)paramHashMap.get(":kids");
      if (localHashMap2 != null);
      for (int i = 0; ; i++)
      {
        while (true)
        {
          int j = localHashMap2.size();
          if (i < j)
            break label566;
          return;
          try
          {
            while (true)
            {
              Field localField = paramObject.getClass().getField("_" + str1);
              if (localField == null)
                break;
              try
              {
                localField.set(paramObject, localObject2);
              }
              catch (IllegalArgumentException localIllegalArgumentException)
              {
                StringBuilder localStringBuilder2 = new StringBuilder("Field ");
                RuntimeException localRuntimeException = new RuntimeException(str1 + " was declared with the wrong type.");
                throw localRuntimeException;
              }
            }
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
          }
        }
        break;
        paramViewGroup.setBackgroundDrawable((Drawable)DynamicBuilder.build(paramViewGroup, (HashMap)paramHashMap.get("drawable"), false, null));
        localObject1 = paramViewGroup;
        break label412;
        label566: loadLayoutHelper((HashMap)localHashMap2.get(String.valueOf(i)), paramBA, paramObject, (ViewGroup)localObject1, false, paramString, false, paramHashMap1, paramBoolean3);
      }
      label603: localObject1 = localView;
    }
  }

  // ERROR //
  private static void runScripts(String paramString, LayoutValues paramLayoutValues, HashMap<String, ViewWrapper<?>> paramHashMap, int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
    throws IllegalArgumentException, java.lang.IllegalAccessException
  {
    // Byte code:
    //   0: new 93	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 414	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc_w 416
    //   14: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: iconst_0
    //   19: istore 9
    //   21: iload 9
    //   23: aload_0
    //   24: invokevirtual 344	java/lang/String:length	()I
    //   27: iconst_4
    //   28: isub
    //   29: if_icmplt +231 -> 260
    //   32: new 93	java/lang/StringBuilder
    //   35: dup
    //   36: getstatic 420	anywheresoftware/b4a/BA:packageName	Ljava/lang/String;
    //   39: invokestatic 97	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   42: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: ldc_w 422
    //   48: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload 7
    //   53: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 327	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   65: astore 17
    //   67: aconst_null
    //   68: invokestatic 426	anywheresoftware/b4a/keywords/LayoutBuilder:variantToMethod	(Lanywheresoftware/b4a/keywords/LayoutValues;)Ljava/lang/String;
    //   71: astore 24
    //   73: iconst_4
    //   74: anewarray 323	java/lang/Class
    //   77: astore 25
    //   79: aload 25
    //   81: iconst_0
    //   82: ldc 22
    //   84: aastore
    //   85: aload 25
    //   87: iconst_1
    //   88: getstatic 432	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   91: aastore
    //   92: aload 25
    //   94: iconst_2
    //   95: getstatic 432	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   98: aastore
    //   99: aload 25
    //   101: iconst_3
    //   102: getstatic 435	java/lang/Float:TYPE	Ljava/lang/Class;
    //   105: aastore
    //   106: aload 17
    //   108: aload 24
    //   110: aload 25
    //   112: invokevirtual 439	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   115: astore 26
    //   117: iconst_4
    //   118: anewarray 4	java/lang/Object
    //   121: astore 27
    //   123: aload 27
    //   125: iconst_0
    //   126: aload_2
    //   127: aastore
    //   128: aload 27
    //   130: iconst_1
    //   131: iload_3
    //   132: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: aload 27
    //   138: iconst_2
    //   139: iload 4
    //   141: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: aload 27
    //   147: iconst_3
    //   148: fload 5
    //   150: invokestatic 445	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   153: aastore
    //   154: aload 26
    //   156: aconst_null
    //   157: aload 27
    //   159: invokevirtual 451	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   162: pop
    //   163: aload_1
    //   164: invokestatic 426	anywheresoftware/b4a/keywords/LayoutBuilder:variantToMethod	(Lanywheresoftware/b4a/keywords/LayoutValues;)Ljava/lang/String;
    //   167: astore 19
    //   169: iconst_4
    //   170: anewarray 323	java/lang/Class
    //   173: astore 20
    //   175: aload 20
    //   177: iconst_0
    //   178: ldc 22
    //   180: aastore
    //   181: aload 20
    //   183: iconst_1
    //   184: getstatic 432	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   187: aastore
    //   188: aload 20
    //   190: iconst_2
    //   191: getstatic 432	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   194: aastore
    //   195: aload 20
    //   197: iconst_3
    //   198: getstatic 435	java/lang/Float:TYPE	Ljava/lang/Class;
    //   201: aastore
    //   202: aload 17
    //   204: aload 19
    //   206: aload 20
    //   208: invokevirtual 439	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   211: astore 21
    //   213: iconst_4
    //   214: anewarray 4	java/lang/Object
    //   217: astore 22
    //   219: aload 22
    //   221: iconst_0
    //   222: aload_2
    //   223: aastore
    //   224: aload 22
    //   226: iconst_1
    //   227: iload_3
    //   228: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: aload 22
    //   234: iconst_2
    //   235: iload 4
    //   237: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: aastore
    //   241: aload 22
    //   243: iconst_3
    //   244: fload 5
    //   246: invokestatic 445	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   249: aastore
    //   250: aload 21
    //   252: aconst_null
    //   253: aload 22
    //   255: invokevirtual 451	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   258: pop
    //   259: return
    //   260: aload_0
    //   261: iload 9
    //   263: invokevirtual 455	java/lang/String:charAt	(I)C
    //   266: istore 10
    //   268: iload 10
    //   270: invokestatic 461	java/lang/Character:isLetterOrDigit	(C)Z
    //   273: ifeq +17 -> 290
    //   276: aload 7
    //   278: iload 10
    //   280: invokevirtual 464	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: iinc 9 1
    //   287: goto -266 -> 21
    //   290: aload 7
    //   292: ldc_w 378
    //   295: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: goto -15 -> 284
    //   302: astore 16
    //   304: aload 16
    //   306: invokevirtual 467	java/lang/SecurityException:printStackTrace	()V
    //   309: return
    //   310: astore 15
    //   312: new 285	java/lang/RuntimeException
    //   315: dup
    //   316: aload 15
    //   318: invokevirtual 471	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   321: invokespecial 288	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   324: athrow
    //   325: astore 14
    //   327: return
    //   328: astore 13
    //   330: return
    //   331: astore 18
    //   333: goto -170 -> 163
    //
    // Exception table:
    //   from	to	target	type
    //   32	67	302	java/lang/SecurityException
    //   67	163	302	java/lang/SecurityException
    //   163	259	302	java/lang/SecurityException
    //   32	67	310	java/lang/reflect/InvocationTargetException
    //   67	163	310	java/lang/reflect/InvocationTargetException
    //   163	259	310	java/lang/reflect/InvocationTargetException
    //   32	67	325	java/lang/NoSuchMethodException
    //   163	259	325	java/lang/NoSuchMethodException
    //   32	67	328	java/lang/ClassNotFoundException
    //   67	163	328	java/lang/ClassNotFoundException
    //   163	259	328	java/lang/ClassNotFoundException
    //   67	163	331	java/lang/NoSuchMethodException
  }

  public static void scaleAll(HashMap<String, ViewWrapper<?>> paramHashMap)
  {
    Iterator localIterator = paramHashMap.values().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ViewWrapper localViewWrapper = (ViewWrapper)localIterator.next();
      if ((localViewWrapper.IsInitialized()) && (!(localViewWrapper instanceof ActivityWrapper)))
        scaleView(localViewWrapper);
    }
  }

  public static void scaleView(ViewWrapper<?> paramViewWrapper)
  {
    paramViewWrapper.setLeft((int)(paramViewWrapper.getLeft() * autoscale));
    paramViewWrapper.setTop((int)(paramViewWrapper.getTop() * autoscale));
    paramViewWrapper.setWidth((int)(paramViewWrapper.getWidth() * autoscale));
    paramViewWrapper.setHeight((int)(paramViewWrapper.getHeight() * autoscale));
    if ((paramViewWrapper instanceof DesignerTextSizeMethod))
    {
      DesignerTextSizeMethod localDesignerTextSizeMethod = (DesignerTextSizeMethod)paramViewWrapper;
      localDesignerTextSizeMethod.setTextSize((float)(localDesignerTextSizeMethod.getTextSize() * autoscale));
    }
  }

  public static void setScaleRate(double paramDouble)
  {
    autoscale = 1.0D + paramDouble * ((tempBA.vg.getWidth() + tempBA.vg.getHeight()) / (750.0F * Common.Density) - 1.0F);
    screenSize = 0.0D;
  }

  private static String variantToMethod(LayoutValues paramLayoutValues)
  {
    if (paramLayoutValues == null);
    for (String str = "general"; ; str = String.valueOf(paramLayoutValues.Width) + "x" + String.valueOf(paramLayoutValues.Height) + "_" + BA.NumberToString(paramLayoutValues.Scale).replace(".", "_"))
      return "LS_" + str;
  }

  @BA.Hide
  public static abstract interface DesignerTextSizeMethod
  {
    public abstract float getTextSize();

    public abstract void setTextSize(float paramFloat);
  }

  @BA.Hide
  public static class LayoutHashMap<K, V> extends HashMap<K, V>
  {
    public V get(Object paramObject)
    {
      Object localObject = super.get(paramObject);
      if (localObject == null)
        throw new RuntimeException("Cannot find view: " + paramObject.toString() + "\nAll views in script should be declared.");
      return localObject;
    }
  }

  public static class LayoutValuesAndMap
  {
    public final LayoutValues layoutValues;
    public final HashMap<String, ViewWrapper<?>> map;

    public LayoutValuesAndMap(LayoutValues paramLayoutValues, HashMap<String, ViewWrapper<?>> paramHashMap)
    {
      this.layoutValues = paramLayoutValues;
      this.map = paramHashMap;
    }
  }

  private static class MapAndCachedStrings
  {
    public final String[] cachedStrings;
    public final HashMap<String, Object> map;

    public MapAndCachedStrings(HashMap<String, Object> paramHashMap, String[] paramArrayOfString)
    {
      this.map = paramHashMap;
      this.cachedStrings = paramArrayOfString;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.keywords.LayoutBuilder
 * JD-Core Version:    0.6.2
 */