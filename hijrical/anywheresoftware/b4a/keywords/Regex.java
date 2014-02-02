package anywheresoftware.b4a.keywords;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex
{
  public static final int CASE_INSENSITIVE = 2;
  public static final int MULTILINE = 8;
  private static LinkedHashMap<PatternAndOptions, Pattern> cachedPatterns;

  public static boolean IsMatch(String paramString1, String paramString2)
  {
    return IsMatch2(paramString1, 0, paramString2);
  }

  public static boolean IsMatch2(String paramString1, int paramInt, String paramString2)
  {
    return getPattern(paramString1, paramInt).matcher(paramString2).matches();
  }

  public static MatcherWrapper Matcher(String paramString1, String paramString2)
  {
    return Matcher2(paramString1, 0, paramString2);
  }

  public static MatcherWrapper Matcher2(String paramString1, int paramInt, String paramString2)
  {
    MatcherWrapper localMatcherWrapper = new MatcherWrapper();
    localMatcherWrapper.setObject(getPattern(paramString1, paramInt).matcher(paramString2));
    return localMatcherWrapper;
  }

  public static String[] Split(String paramString1, String paramString2)
  {
    return Split2(paramString1, 0, paramString2);
  }

  public static String[] Split2(String paramString1, int paramInt, String paramString2)
  {
    return getPattern(paramString1, paramInt).split(paramString2);
  }

  private static Pattern getPattern(String paramString, int paramInt)
  {
    if (cachedPatterns == null)
      cachedPatterns = new LinkedHashMap();
    PatternAndOptions localPatternAndOptions = new PatternAndOptions(paramString, paramInt);
    Pattern localPattern = (Pattern)cachedPatterns.get(localPatternAndOptions);
    Iterator localIterator;
    if (localPattern == null)
    {
      localPattern = Pattern.compile(paramString, paramInt);
      cachedPatterns.put(localPatternAndOptions, localPattern);
      if (cachedPatterns.size() > 50)
        localIterator = cachedPatterns.entrySet().iterator();
    }
    for (int i = 0; ; i++)
    {
      if (i >= 25)
        return localPattern;
      localIterator.next();
      localIterator.remove();
    }
  }

  @BA.ShortName("Matcher")
  public static class MatcherWrapper extends AbsObjectWrapper<Matcher>
  {
    public boolean Find()
    {
      return ((Matcher)getObject()).find();
    }

    public int GetEnd(int paramInt)
    {
      return ((Matcher)getObject()).end(paramInt);
    }

    public int GetStart(int paramInt)
    {
      return ((Matcher)getObject()).start(paramInt);
    }

    public String Group(int paramInt)
    {
      return ((Matcher)getObject()).group(paramInt);
    }

    public int getGroupCount()
    {
      return ((Matcher)getObject()).groupCount();
    }

    public String getMatch()
    {
      return ((Matcher)getObject()).group();
    }
  }

  private static class PatternAndOptions
  {
    public final int options;
    public final String pattern;

    public PatternAndOptions(String paramString, int paramInt)
    {
      this.pattern = paramString;
      this.options = paramInt;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject)
        return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      PatternAndOptions localPatternAndOptions = (PatternAndOptions)paramObject;
      if (this.options != localPatternAndOptions.options)
        return false;
      if (this.pattern == null)
      {
        if (localPatternAndOptions.pattern != null)
          return false;
      }
      else if (!this.pattern.equals(localPatternAndOptions.pattern))
        return false;
      return true;
    }

    public int hashCode()
    {
      (1 * 31);
      int i = 31 * (31 + this.options);
      if (this.pattern == null);
      for (int j = 0; ; j = this.pattern.hashCode())
        return i + j;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.keywords.Regex
 * JD-Core Version:    0.6.2
 */