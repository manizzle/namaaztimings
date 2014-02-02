package anywheresoftware.b4a.objects;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.HttpAuthHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper;
import java.io.InputStream;
import java.util.HashMap;

@BA.ShortName("WebView")
@BA.ActivityObject
public class WebViewWrapper extends ViewWrapper<WebView>
{
  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    View localView;
    if (paramObject1 == null)
    {
      if (!paramBoolean)
        break label73;
      localView = new View((Context)paramObject2);
      InputStream localInputStream = ((Context)paramObject2).getAssets().open("webview.jpg");
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(localInputStream);
      localInputStream.close();
      localView.setBackgroundDrawable(localBitmapDrawable);
    }
    label73: WebView localWebView;
    for (paramObject1 = localView; ; paramObject1 = localWebView)
    {
      ViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
      return (View)paramObject1;
      localWebView = (WebView)ViewWrapper.buildNativeView((Context)paramObject2, WebView.class, paramHashMap, paramBoolean);
      localWebView.getSettings().setJavaScriptEnabled(((Boolean)paramHashMap.get("javaScriptEnabled")).booleanValue());
      localWebView.getSettings().setBuiltInZoomControls(((Boolean)paramHashMap.get("zoomEnabled")).booleanValue());
      localWebView.getSettings().setPluginsEnabled(true);
    }
  }

  public void Back()
  {
    ((WebView)getObject()).goBack();
  }

  public CanvasWrapper.BitmapWrapper CaptureBitmap()
  {
    Picture localPicture = ((WebView)getObject()).capturePicture();
    CanvasWrapper.BitmapWrapper localBitmapWrapper = new CanvasWrapper.BitmapWrapper();
    localBitmapWrapper.InitializeMutable(localPicture.getWidth(), localPicture.getHeight());
    CanvasWrapper localCanvasWrapper = new CanvasWrapper();
    localCanvasWrapper.Initialize2((Bitmap)localBitmapWrapper.getObject());
    localPicture.draw(localCanvasWrapper.canvas);
    return localBitmapWrapper;
  }

  public void Forward()
  {
    ((WebView)getObject()).goForward();
  }

  public void LoadHtml(String paramString)
  {
    ((WebView)getObject()).loadDataWithBaseURL("file:///", paramString, "text/html", "UTF8", null);
  }

  public void LoadUrl(String paramString)
  {
    ((WebView)getObject()).loadUrl(paramString);
  }

  public void StopLoading()
  {
    ((WebView)getObject()).stopLoading();
  }

  public boolean Zoom(boolean paramBoolean)
  {
    if (paramBoolean)
      return ((WebView)getObject()).zoomIn();
    return ((WebView)getObject()).zoomOut();
  }

  public boolean getJavaScriptEnabled()
  {
    return ((WebView)getObject()).getSettings().getJavaScriptEnabled();
  }

  public String getUrl()
  {
    return ((WebView)getObject()).getUrl();
  }

  public boolean getZoomEnabled()
  {
    return ((WebView)getObject()).getSettings().getBuiltInZoomControls();
  }

  @BA.Hide
  public void innerInitialize(final BA paramBA, final String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      setObject(new WebView(paramBA.context));
      ((WebView)getObject()).getSettings().setJavaScriptEnabled(true);
      ((WebView)getObject()).getSettings().setBuiltInZoomControls(true);
      ((WebView)getObject()).getSettings().setPluginsEnabled(true);
    }
    super.innerInitialize(paramBA, paramString, true);
    ((WebView)getObject()).setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        paramBA.raiseEvent(WebViewWrapper.this.getObject(), paramString + "_pagefinished", new Object[] { paramAnonymousString });
      }

      public void onReceivedHttpAuthRequest(WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2)
      {
        Object localObject = paramBA.raiseEvent(WebViewWrapper.this.getObject(), paramString + "_userandpasswordrequired", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        if (localObject == null)
        {
          paramAnonymousHttpAuthHandler.cancel();
          return;
        }
        String[] arrayOfString = (String[])localObject;
        paramAnonymousHttpAuthHandler.proceed(arrayOfString[0], arrayOfString[1]);
      }

      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        Boolean localBoolean = (Boolean)paramBA.raiseEvent(WebViewWrapper.this.getObject(), paramString + "_overrideurl", new Object[] { paramAnonymousString });
        if (localBoolean != null)
          return localBoolean.booleanValue();
        return false;
      }
    });
    ((WebView)getObject()).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        switch (paramAnonymousMotionEvent.getAction())
        {
        default:
        case 0:
        case 1:
        }
        while (true)
        {
          return false;
          if (!paramAnonymousView.hasFocus())
            paramAnonymousView.requestFocus();
        }
      }
    });
  }

  public void setJavaScriptEnabled(boolean paramBoolean)
  {
    ((WebView)getObject()).getSettings().setJavaScriptEnabled(paramBoolean);
  }

  public void setZoomEnabled(boolean paramBoolean)
  {
    ((WebView)getObject()).getSettings().setBuiltInZoomControls(paramBoolean);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.WebViewWrapper
 * JD-Core Version:    0.6.2
 */