package flm.b4a.scrollview2d;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import anywheresoftware.b4a.BA.Hide;
import java.util.ArrayList;
import java.util.List;

@BA.Hide
public class TwoDScrollView extends FrameLayout
{
  protected boolean DisallowInterceptTouchEvent = true;
  private long a;
  private final Rect b = new Rect();
  private Scroller c = new Scroller(getContext());
  private int d;
  private int e;
  private int f;
  private int g;
  private boolean h = true;
  private View i = null;
  private boolean j = false;
  private VelocityTracker k;
  private boolean l;
  private boolean m = true;
  private int n;
  private int o;
  private int p;
  private int q = -1;

  public TwoDScrollView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TwoDScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842880);
  }

  public TwoDScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.n = localViewConfiguration.getScaledTouchSlop();
    this.o = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.p = localViewConfiguration.getScaledMaximumFlingVelocity();
    setHorizontalFadingEdgeEnabled(true);
    setVerticalFadingEdgeEnabled(true);
    setHorizontalScrollBarEnabled(true);
    setVerticalScrollBarEnabled(true);
  }

  private View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    ArrayList localArrayList = getFocusables(2);
    Rect localRect = new Rect();
    int i1 = localArrayList.size();
    Object localObject1 = null;
    int i2 = 0;
    int i3 = 0;
    if (i2 >= i1)
      return localObject1;
    View localView = (View)localArrayList.get(i2);
    localView.getDrawingRect(this.b);
    offsetDescendantRectToMyCoords(localView, this.b);
    int i5;
    Object localObject2;
    int i4;
    label214: int i6;
    label253: int i7;
    if ((paramInt2 < this.b.bottom) && (this.b.top < paramInt3) && (paramInt5 < this.b.right) && (this.b.left < paramInt6))
    {
      if ((paramInt2 < this.b.top) && (this.b.bottom < paramInt3) && (paramInt5 < this.b.left) && (this.b.right < paramInt6));
      for (i5 = 1; ; i5 = 0)
      {
        if (localObject1 != null)
          break label214;
        localRect.set(this.b);
        localObject2 = localView;
        i4 = i5;
        i2++;
        localObject1 = localObject2;
        i3 = i4;
        break;
      }
      i6 = 1;
      if (paramInt1 != 0)
      {
        if (paramInt1 <= 0)
          break label419;
        if (Math.abs(paramInt2 - this.b.top) <= Math.abs(paramInt2 - localRect.top))
          i6 = 1;
      }
      else
      {
        i7 = 1;
        if (paramInt4 != 0)
        {
          if (paramInt4 <= 0)
            break label462;
          if (Math.abs(paramInt5 - this.b.left) > Math.abs(paramInt5 - localRect.left))
            break label456;
          i7 = 1;
        }
        label296: if ((paramInt1 == 0) || (paramInt4 == 0))
          break label628;
        if (Math.abs(paramInt4) <= Math.abs(paramInt1))
          break label501;
        if (((paramInt4 <= 0) || (this.b.left == localRect.left)) && ((paramInt4 >= 0) || (this.b.right == localRect.right)))
          break label628;
        i6 = i7;
      }
    }
    while (true)
    {
      label361: if ((i7 != 0) && (i6 != 0));
      for (int i9 = 1; ; i9 = 0)
      {
        if (i3 == 0)
          break label564;
        if ((i5 == 0) || (i9 == 0))
          break label617;
        localRect.set(this.b);
        int i11 = i3;
        localObject2 = localView;
        i4 = i11;
        break;
        i6 = 0;
        break label253;
        label419: if (Math.abs(paramInt3 - this.b.bottom) <= Math.abs(paramInt3 - localRect.bottom))
        {
          i6 = 1;
          break label253;
        }
        i6 = 0;
        break label253;
        label456: i7 = 0;
        break label296;
        label462: if (Math.abs(paramInt6 - this.b.right) <= Math.abs(paramInt6 - localRect.right))
        {
          i7 = 1;
          break label296;
        }
        i7 = 0;
        break label296;
        label501: if ((Math.abs(paramInt4) >= Math.abs(paramInt1)) || (((paramInt1 <= 0) || (this.b.top == localRect.top)) && ((paramInt1 >= 0) || (this.b.bottom == localRect.bottom))))
          break label628;
        i7 = i6;
        break label361;
      }
      label564: if (i5 != 0)
      {
        localRect.set(this.b);
        localObject2 = localView;
        i4 = 1;
        break;
      }
      if (i9 != 0)
      {
        localRect.set(this.b);
        int i10 = i3;
        localObject2 = localView;
        i4 = i10;
        break;
      }
      label617: i4 = i3;
      localObject2 = localObject1;
      break;
      label628: int i8 = i7;
      i7 = i6;
      i6 = i8;
    }
  }

  private View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    int i1 = getVerticalFadingEdgeLength() / 2;
    int i2 = paramInt2 + i1;
    int i3 = paramInt2 + getHeight() - i1;
    int i4 = getHorizontalFadingEdgeLength() / 2;
    int i5 = paramInt4 + i4;
    int i6 = paramInt4 + getWidth() - i4;
    if (paramView != null)
    {
      paramView.getDrawingRect(this.b);
      offsetDescendantRectToMyCoords(paramView, this.b);
      if ((this.b.top < i3) && (this.b.bottom > i2) && (this.b.left < i6) && (this.b.right > i5))
        return paramView;
    }
    return a(paramInt1, i2, i3, paramInt3, i5, i6);
  }

  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (this.m)
        smoothScrollBy(paramInt1, paramInt2);
    }
    else
      return;
    scrollBy(paramInt1, paramInt2);
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = 0xFF & paramMotionEvent.getAction() >> 8;
    if (paramMotionEvent.getPointerId(i1) == this.q)
      if (i1 != 0)
        break label74;
    label74: for (int i2 = 1; ; i2 = 0)
    {
      this.d = ((int)paramMotionEvent.getX(i2));
      this.e = ((int)paramMotionEvent.getY(i2));
      this.q = paramMotionEvent.getPointerId(i2);
      if (this.k != null)
        this.k.clear();
      return;
    }
  }

  private void a(View paramView)
  {
    paramView.getDrawingRect(this.b);
    offsetDescendantRectToMyCoords(paramView, this.b);
    int i1 = computeScrollDeltaToGetChildRectOnScreenH(this.b);
    int i2 = computeScrollDeltaToGetChildRectOnScreenV(this.b);
    if ((i1 != 0) || (i2 != 0))
      scrollBy(i1, i2);
  }

  private boolean a()
  {
    View localView = getChildAt(0);
    if (localView != null)
    {
      int i1 = localView.getHeight();
      return getHeight() < i1 + getPaddingTop() + getPaddingBottom();
    }
    return false;
  }

  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = getHeight();
    int i2 = getScrollY();
    int i3 = i2 + i1;
    int i4;
    if (paramInt1 == 33)
    {
      i4 = 1;
      if (i4 == 0)
        break label93;
    }
    boolean bool;
    label93: for (Object localObject = a(1, paramInt2, paramInt3, 0, 0, 0); ; localObject = a(-1, paramInt2, paramInt3, 0, 0, 0))
    {
      if (localObject == null)
        localObject = this;
      if ((paramInt2 < i2) || (paramInt3 > i3))
        break label108;
      bool = false;
      if (localObject != findFocus())
        ((View)localObject).requestFocus(paramInt1);
      return bool;
      i4 = 0;
      break;
    }
    label108: if (i4 != 0);
    for (int i5 = paramInt2 - i2; ; i5 = paramInt3 - i3)
    {
      a(0, i5);
      bool = true;
      break;
    }
  }

  private boolean a(View paramView, int paramInt)
  {
    paramView.getDrawingRect(this.b);
    offsetDescendantRectToMyCoords(paramView, this.b);
    return (paramInt + this.b.bottom >= getScrollY()) && (this.b.top - paramInt <= getScrollY() + getHeight());
  }

  private static boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2)
      return true;
    ViewParent localViewParent = paramView1.getParent();
    return ((localViewParent instanceof ViewGroup)) && (a((View)localViewParent, paramView2));
  }

  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 >= paramInt3) || (paramInt1 < 0))
      return 0;
    if (paramInt2 + paramInt1 > paramInt3)
      return paramInt3 - paramInt2;
    return paramInt1;
  }

  private boolean b()
  {
    View localView = getChildAt(0);
    if (localView != null)
    {
      int i1 = localView.getWidth();
      return getWidth() < i1 + getPaddingLeft() + getPaddingRight();
    }
    return false;
  }

  private boolean b(View paramView, int paramInt)
  {
    paramView.getDrawingRect(this.b);
    offsetDescendantRectToMyCoords(paramView, this.b);
    return (paramInt + this.b.right >= getScrollX()) && (this.b.left - paramInt <= getScrollX() + getWidth());
  }

  private boolean c()
  {
    if (isFocused())
    {
      View localView1 = findFocus();
      if (localView1 == this)
        localView1 = null;
      View localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, 130);
      return (localView2 != null) && (localView2 != this) && (localView2.requestFocus(130));
    }
    return false;
  }

  private boolean d()
  {
    if (isFocused())
    {
      View localView1 = findFocus();
      if (localView1 == this)
        localView1 = null;
      View localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, 66);
      return (localView2 != null) && (localView2 != this) && (localView2.requestFocus(66));
    }
    return false;
  }

  private void e()
  {
    if (this.k == null)
      this.k = VelocityTracker.obtain();
  }

  private void f()
  {
    if (this.k != null)
    {
      this.k.recycle();
      this.k = null;
    }
  }

  private void g()
  {
    this.j = false;
    f();
  }

  public void FindNewFocusedView(int paramInt1, int paramInt2)
  {
    if (this.c.isFinished());
    for (Object localObject = a(paramInt2, getScrollY(), paramInt1, getScrollX(), findFocus()); ; localObject = a(paramInt2, this.c.getFinalY(), paramInt1, this.c.getFinalX(), findFocus()))
    {
      if (localObject == null)
        localObject = this;
      if (localObject != findFocus())
        ((View)localObject).requestFocus();
      return;
    }
  }

  protected boolean ScrollingIsFinished()
  {
    return this.c.isFinished();
  }

  public void addView(View paramView)
  {
    if (getChildCount() > 0)
      throw new IllegalStateException("ScrollView2D can host only one direct child");
    super.addView(paramView);
  }

  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 0)
      throw new IllegalStateException("ScrollView2D can host only one direct child");
    super.addView(paramView, paramInt);
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0)
      throw new IllegalStateException("ScrollView2D can host only one direct child");
    super.addView(paramView, paramInt, paramLayoutParams);
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0)
      throw new IllegalStateException("ScrollView2D can host only one direct child");
    super.addView(paramView, paramLayoutParams);
  }

  public boolean arrowScrollH(int paramInt)
  {
    View localView1 = findFocus();
    if (localView1 == this)
      localView1 = null;
    View localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int i1 = getMaxScrollAmountH();
    int i3;
    label101: int i2;
    if ((localView2 != null) && (b(localView2, i1)))
    {
      localView2.getDrawingRect(this.b);
      offsetDescendantRectToMyCoords(localView2, this.b);
      a(computeScrollDeltaToGetChildRectOnScreenH(this.b), 0);
      localView2.requestFocus(paramInt);
      if ((localView1 != null) && (localView1.isFocused()))
      {
        if (!b(localView1, 0))
          break label243;
        i3 = 0;
        if (i3 != 0)
        {
          int i4 = getDescendantFocusability();
          setDescendantFocusability(131072);
          requestFocus();
          setDescendantFocusability(i4);
        }
      }
      return true;
    }
    else if ((paramInt == 17) && (getScrollX() < i1))
    {
      i2 = getScrollX();
    }
    while (true)
      if (i2 == 0)
      {
        return false;
        if ((paramInt == 66) && (getChildCount() > 0))
        {
          int i5 = getChildAt(0).getRight();
          int i6 = getScrollX() + getWidth() - getPaddingRight();
          if (i5 - i6 < i1)
            i2 = i5 - i6;
        }
      }
      else
      {
        if (paramInt == 66);
        while (true)
        {
          a(i2, 0);
          break;
          i2 = -i2;
        }
        label243: i3 = 1;
        break label101;
        i2 = i1;
      }
  }

  public boolean arrowScrollV(int paramInt)
  {
    View localView1 = findFocus();
    if (localView1 == this)
      localView1 = null;
    View localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int i1 = getMaxScrollAmountV();
    int i3;
    label101: int i2;
    if ((localView2 != null) && (a(localView2, i1)))
    {
      localView2.getDrawingRect(this.b);
      offsetDescendantRectToMyCoords(localView2, this.b);
      a(0, computeScrollDeltaToGetChildRectOnScreenV(this.b));
      localView2.requestFocus(paramInt);
      if ((localView1 != null) && (localView1.isFocused()))
      {
        if (!a(localView1, 0))
          break label245;
        i3 = 0;
        if (i3 != 0)
        {
          int i4 = getDescendantFocusability();
          setDescendantFocusability(131072);
          requestFocus();
          setDescendantFocusability(i4);
        }
      }
      return true;
    }
    else if ((paramInt == 33) && (getScrollY() < i1))
    {
      i2 = getScrollY();
    }
    while (true)
      if (i2 == 0)
      {
        return false;
        if ((paramInt == 130) && (getChildCount() > 0))
        {
          int i5 = getChildAt(0).getBottom();
          int i6 = getScrollY() + getHeight() - getPaddingBottom();
          if (i5 - i6 < i1)
            i2 = i5 - i6;
        }
      }
      else
      {
        if (paramInt == 130);
        while (true)
        {
          a(0, i2);
          break;
          i2 = -i2;
        }
        label245: i3 = 1;
        break label101;
        i2 = i1;
      }
  }

  protected int computeHorizontalScrollOffset()
  {
    return Math.max(0, super.computeHorizontalScrollOffset());
  }

  protected int computeHorizontalScrollRange()
  {
    int i1 = getChildCount();
    int i2 = getWidth() - getPaddingLeft() - getPaddingRight();
    int i3;
    if (i1 == 0)
      i3 = i2;
    int i4;
    int i5;
    do
    {
      return i3;
      i3 = getChildAt(0).getRight();
      i4 = getScrollX();
      i5 = Math.max(0, i3 - i2);
      if (i4 < 0)
        return i3 - i4;
    }
    while (i4 <= i5);
    return i3 + (i4 - i5);
  }

  public void computeScroll()
  {
    if (this.c.computeScrollOffset())
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.c.getCurrX();
      int i4 = this.c.getCurrY();
      if (getChildCount() > 0)
      {
        View localView = getChildAt(0);
        int i5 = b(i3, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth());
        int i6 = b(i4, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight());
        if ((i5 != i1) || (i6 != i2))
          super.scrollTo(i5, i6);
      }
      if (!awakenScrollBars())
        postInvalidate();
    }
  }

  protected int computeScrollDeltaToGetChildRectOnScreenH(Rect paramRect)
  {
    if (getChildCount() == 0)
      return 0;
    int i1 = getWidth();
    int i2 = getScrollX();
    int i3 = i2 + i1;
    int i4 = getHorizontalFadingEdgeLength();
    if (paramRect.left > 0)
      i2 += i4;
    if (paramRect.right < getChildAt(0).getWidth())
      i3 -= i4;
    if ((paramRect.right > i3) && (paramRect.left > i2))
    {
      if (paramRect.width() > i1);
      for (int i6 = 0 + (paramRect.left - i2); ; i6 = 0 + (paramRect.right - i3))
        return Math.min(i6, getChildAt(0).getRight() - i3);
    }
    if ((paramRect.left < i2) && (paramRect.right < i3))
    {
      if (paramRect.width() > i1);
      for (int i5 = 0 - (i3 - paramRect.right); ; i5 = 0 - (i2 - paramRect.left))
        return Math.max(i5, -getScrollX());
    }
    return 0;
  }

  protected int computeScrollDeltaToGetChildRectOnScreenV(Rect paramRect)
  {
    if (getChildCount() == 0)
      return 0;
    int i1 = getHeight();
    int i2 = getScrollY();
    int i3 = i2 + i1;
    int i4 = getVerticalFadingEdgeLength();
    if (paramRect.top > 0)
      i2 += i4;
    if (paramRect.bottom < getChildAt(0).getHeight())
      i3 -= i4;
    if ((paramRect.bottom > i3) && (paramRect.top > i2))
    {
      if (paramRect.height() > i1);
      for (int i6 = 0 + (paramRect.top - i2); ; i6 = 0 + (paramRect.bottom - i3))
        return Math.min(i6, getChildAt(0).getBottom() - i3);
    }
    if ((paramRect.top < i2) && (paramRect.bottom < i3))
    {
      if (paramRect.height() > i1);
      for (int i5 = 0 - (i3 - paramRect.bottom); ; i5 = 0 - (i2 - paramRect.top))
        return Math.max(i5, -getScrollY());
    }
    return 0;
  }

  protected int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }

  protected int computeVerticalScrollRange()
  {
    int i1 = getChildCount();
    int i2 = getHeight() - getPaddingBottom() - getPaddingTop();
    int i3;
    if (i1 == 0)
      i3 = i2;
    int i4;
    int i5;
    do
    {
      return i3;
      i3 = getChildAt(0).getBottom();
      i4 = getScrollY();
      i5 = Math.max(0, i3 - i2);
      if (i4 < 0)
        return i3 - i4;
    }
    while (i4 <= i5);
    return i3 + (i4 - i5);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }

  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    this.b.setEmpty();
    if (paramKeyEvent.getAction() == 0);
    switch (paramKeyEvent.getKeyCode())
    {
    default:
      return false;
    case 19:
      if (!a())
        return c();
      if (!paramKeyEvent.isAltPressed())
        return arrowScrollV(33);
      return fullScroll(33);
    case 20:
      if (!a())
        return c();
      if (!paramKeyEvent.isAltPressed())
        return arrowScrollV(130);
      return fullScroll(130);
    case 21:
      if (!b())
        return d();
      if (!paramKeyEvent.isAltPressed())
        return arrowScrollH(17);
      return fullScroll(17);
    case 22:
      if (!b())
        return d();
      if (!paramKeyEvent.isAltPressed())
        return arrowScrollH(66);
      return fullScroll(66);
    case 62:
    }
    if (!a())
      return c();
    if (paramKeyEvent.isShiftPressed());
    for (int i1 = 33; ; i1 = 130)
    {
      pageScroll(i1);
      return false;
    }
  }

  public void fling(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      int i1 = getWidth() - getPaddingRight() - getPaddingLeft();
      int i2 = getChildAt(0).getWidth();
      int i3 = getHeight() - getPaddingBottom() - getPaddingTop();
      int i4 = getChildAt(0).getHeight();
      int i5 = getScrollX();
      int i6 = getScrollY();
      this.c.fling(i5, i6, paramInt1, paramInt2, 0, Math.max(0, i2 - i1), 0, Math.max(0, i4 - i3));
      FindNewFocusedView(this.c.getFinalX() - i5, this.c.getFinalY() - i6);
      postInvalidate();
    }
  }

  public boolean fullScroll(int paramInt)
  {
    int i1;
    if (paramInt == 130)
    {
      i1 = 1;
      if (paramInt != 66)
        break label195;
    }
    label195: for (int i2 = 1; ; i2 = 0)
    {
      int i3 = getHeight();
      int i4 = getWidth();
      this.b.top = 0;
      this.b.bottom = i3;
      this.b.left = 0;
      this.b.right = i4;
      if ((i1 != 0) && (getChildCount() > 0))
      {
        View localView2 = getChildAt(0);
        this.b.bottom = localView2.getBottom();
        this.b.top = (this.b.bottom - i3);
      }
      if ((i2 != 0) && (getChildCount() > 0))
      {
        View localView1 = getChildAt(0);
        this.b.right = localView1.getRight();
        this.b.left = (this.b.right - i4);
      }
      if ((paramInt != 130) && (paramInt != 33))
        break label200;
      return a(paramInt, this.b.top, this.b.bottom);
      i1 = 0;
      break;
    }
    label200: int i5 = this.b.left;
    int i6 = this.b.right;
    int i7 = getWidth();
    int i8 = getScrollX();
    int i9 = i8 + i7;
    int i10;
    if (paramInt == 17)
    {
      i10 = 1;
      if (i10 == 0)
        break label315;
    }
    boolean bool;
    label315: for (Object localObject = a(0, 0, 0, 1, i5, i6); ; localObject = a(0, 0, 0, -1, i5, i6))
    {
      if (localObject == null)
        localObject = this;
      if ((i5 < i8) || (i6 > i9))
        break label332;
      bool = false;
      if (localObject != findFocus())
        ((View)localObject).requestFocus(paramInt);
      return bool;
      i10 = 0;
      break;
    }
    label332: if (i10 != 0);
    for (int i11 = i5 - i8; ; i11 = i6 - i9)
    {
      a(i11, 0);
      bool = true;
      break;
    }
  }

  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0)
      return 0.0F;
    int i1 = getVerticalFadingEdgeLength();
    int i2 = getHeight() - getPaddingBottom();
    int i3 = getChildAt(0).getBottom() - getScrollY() - i2;
    if (i3 < i1)
      return i3 / i1;
    return 1.0F;
  }

  protected float getLeftFadingEdgeStrength()
  {
    if (getChildCount() == 0)
      return 0.0F;
    int i1 = getHorizontalFadingEdgeLength();
    if (getScrollX() < i1)
      return getScrollX() / i1;
    return 1.0F;
  }

  public int getMaxScrollAmountH()
  {
    return (int)(0.5F * getWidth());
  }

  public int getMaxScrollAmountV()
  {
    return (int)(0.5F * getHeight());
  }

  protected float getRightFadingEdgeStrength()
  {
    if (getChildCount() == 0)
      return 0.0F;
    int i1 = getHorizontalFadingEdgeLength();
    int i2 = getWidth() - getPaddingRight();
    int i3 = getChildAt(0).getRight() - getScrollX() - i2;
    if (i3 < i1)
      return i3 / i1;
    return 1.0F;
  }

  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0)
      return 0.0F;
    int i1 = getVerticalFadingEdgeLength();
    if (getScrollY() < i1)
      return getScrollY() / i1;
    return 1.0F;
  }

  public boolean isFillViewport()
  {
    return this.l;
  }

  public boolean isSmoothScrollingEnabled()
  {
    return this.m;
  }

  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localLayoutParams.height));
  }

  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, paramInt2 + (getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin), localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, paramInt4 + (getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin), localMarginLayoutParams.height));
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 2) && (this.j))
      return true;
    switch (i1 & 0xFF)
    {
    case 4:
    case 5:
    default:
    case 2:
    case 0:
    case 1:
    case 3:
    case 6:
    }
    while (true)
    {
      return this.j;
      int i7 = this.q;
      if (i7 != -1)
      {
        int i8 = paramMotionEvent.findPointerIndex(i7);
        int i9 = (int)paramMotionEvent.getX(i8);
        int i10 = (int)paramMotionEvent.getY(i8);
        int i11 = Math.abs(i9 - this.d);
        int i12 = Math.abs(i10 - this.e);
        if ((i11 > this.n) || (i12 > this.n))
        {
          this.j = true;
          this.d = i9;
          this.e = i10;
          e();
          this.k.addMovement(paramMotionEvent);
          ViewParent localViewParent = getParent();
          if (localViewParent != null)
          {
            localViewParent.requestDisallowInterceptTouchEvent(this.DisallowInterceptTouchEvent);
            continue;
            int i2 = (int)paramMotionEvent.getX();
            int i3 = (int)paramMotionEvent.getY();
            int i4;
            if (getChildCount() > 0)
            {
              int i5 = getScrollX();
              int i6 = getScrollY();
              View localView = getChildAt(0);
              if ((i3 < localView.getTop() - i6) || (i3 >= localView.getBottom() - i6) || (i2 < localView.getLeft() - i5) || (i2 >= localView.getRight() - i5))
                i4 = 0;
            }
            while (true)
            {
              if (i4 != 0)
                break label328;
              this.j = false;
              f();
              break;
              i4 = 1;
              continue;
              i4 = 0;
            }
            label328: this.d = i2;
            this.e = i3;
            this.f = getScrollX();
            this.g = getScrollY();
            this.q = paramMotionEvent.getPointerId(0);
            if (this.k == null)
            {
              this.k = VelocityTracker.obtain();
              label378: this.k.addMovement(paramMotionEvent);
              if (!this.c.isFinished())
                break label418;
            }
            label418: for (boolean bool = false; ; bool = true)
            {
              this.j = bool;
              break;
              this.k.clear();
              break label378;
            }
            this.j = false;
            this.q = -1;
            f();
            continue;
            a(paramMotionEvent);
          }
        }
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = false;
    if ((this.i != null) && (a(this.i, this)))
      a(this.i);
    this.i = null;
    scrollTo(getScrollX(), getScrollY());
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.l);
    int i2;
    View localView;
    FrameLayout.LayoutParams localLayoutParams;
    int i4;
    do
    {
      int i1;
      do
      {
        return;
        i1 = View.MeasureSpec.getMode(paramInt2);
        i2 = View.MeasureSpec.getMode(paramInt1);
      }
      while (((i1 == 0) && (i2 == 0)) || (getChildCount() <= 0));
      localView = getChildAt(0);
      localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i3 = getMeasuredHeight();
      i4 = getMeasuredWidth();
      if ((localView.getMeasuredHeight() < i3) && (i1 != 0))
        localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(i3 - getPaddingTop() - getPaddingBottom(), 1073741824));
    }
    while ((localView.getMeasuredWidth() >= i4) || (i2 == 0));
    int i5 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    localView.measure(View.MeasureSpec.makeMeasureSpec(i4 - getPaddingLeft() - getPaddingRight(), 1073741824), i5);
  }

  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    return false;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (localView == this))
      return;
    localView.getDrawingRect(this.b);
    offsetDescendantRectToMyCoords(localView, this.b);
    a(computeScrollDeltaToGetChildRectOnScreenH(this.b), computeScrollDeltaToGetChildRectOnScreenV(this.b));
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    e();
    this.k.addMovement(paramMotionEvent);
    int i4;
    int i5;
    int i6;
    int i7;
    label320: int i8;
    int i9;
    switch (0xFF & paramMotionEvent.getAction())
    {
    case 4:
    case 5:
    default:
      return true;
    case 0:
      if (getChildCount() == 0)
        return false;
      if (this.c.isFinished());
      for (boolean bool = false; ; bool = true)
      {
        this.j = bool;
        if (bool)
        {
          ViewParent localViewParent2 = getParent();
          if (localViewParent2 != null)
            localViewParent2.requestDisallowInterceptTouchEvent(this.DisallowInterceptTouchEvent);
        }
        if (!this.c.isFinished())
          this.c.abortAnimation();
        this.d = ((int)paramMotionEvent.getX());
        this.e = ((int)paramMotionEvent.getY());
        this.f = getScrollX();
        this.g = getScrollY();
        this.q = paramMotionEvent.getPointerId(0);
        break;
      }
    case 2:
      int i3 = paramMotionEvent.findPointerIndex(this.q);
      i4 = (int)paramMotionEvent.getX(i3);
      i5 = (int)paramMotionEvent.getY(i3);
      i6 = this.d - i4;
      i7 = this.e - i5;
      if ((!this.j) && ((Math.abs(i6) > this.n) || (Math.abs(i7) > this.n)))
      {
        ViewParent localViewParent1 = getParent();
        if (localViewParent1 != null)
          localViewParent1.requestDisallowInterceptTouchEvent(this.DisallowInterceptTouchEvent);
        this.j = true;
        if (Math.abs(i6) > this.n)
        {
          if (i6 > 0)
            i6 -= this.n;
        }
        else
        {
          if (Math.abs(i7) <= this.n)
            break label563;
          if (i7 <= 0)
            break label396;
          int i11 = i7 - this.n;
          i8 = i6;
          i9 = i11;
        }
      }
      break;
    case 1:
    case 3:
    case 6:
    }
    while (this.j)
    {
      this.d = i4;
      this.e = i5;
      scrollBy(i8, i9);
      break;
      i6 += this.n;
      break label320;
      label396: int i10 = i7 + this.n;
      i8 = i6;
      i9 = i10;
      continue;
      if (!this.j)
        break;
      VelocityTracker localVelocityTracker = this.k;
      localVelocityTracker.computeCurrentVelocity(1000, this.p);
      int i1 = (int)localVelocityTracker.getXVelocity();
      int i2 = (int)localVelocityTracker.getYVelocity();
      if (getChildCount() > 0)
      {
        if ((Math.abs(i1) <= this.o) && (Math.abs(i2) <= this.o))
          break label504;
        fling(-i1, -i2);
      }
      while (true)
      {
        this.q = -1;
        g();
        break;
        label504: FindNewFocusedView(getScrollX() - this.f, getScrollY() - this.g);
      }
      if ((!this.j) || (getChildCount() <= 0))
        break;
      this.q = -1;
      g();
      break;
      a(paramMotionEvent);
      break;
      label563: i8 = i6;
      i9 = i7;
    }
  }

  public boolean pageScroll(int paramInt)
  {
    int i1;
    int i2;
    if (paramInt == 130)
    {
      i1 = 1;
      i2 = getHeight();
      if (i1 == 0)
        break label124;
      this.b.top = (i2 + getScrollY());
      int i3 = getChildCount();
      if (i3 > 0)
      {
        View localView = getChildAt(i3 - 1);
        if (i2 + this.b.top > localView.getBottom())
          this.b.top = (localView.getBottom() - i2);
      }
    }
    while (true)
    {
      this.b.bottom = (i2 + this.b.top);
      return a(paramInt, this.b.top, this.b.bottom);
      i1 = 0;
      break;
      label124: this.b.top = (getScrollY() - i2);
      if (this.b.top < 0)
        this.b.top = 0;
    }
  }

  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.h)
      a(paramView2);
    while (true)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      this.i = paramView2;
    }
  }

  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i1 = computeScrollDeltaToGetChildRectOnScreenH(paramRect);
    int i2 = computeScrollDeltaToGetChildRectOnScreenV(paramRect);
    if ((i1 == 0) && (i2 == 0));
    for (boolean bool = false; ; bool = true)
    {
      if (bool)
      {
        if (!paramBoolean)
          break;
        scrollBy(i1, i2);
      }
      return bool;
    }
    smoothScrollBy(i1, i2);
    return bool;
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean)
      f();
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }

  public void requestLayout()
  {
    this.h = true;
    super.requestLayout();
  }

  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      int i1 = b(paramInt1, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth());
      int i2 = b(paramInt2, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight());
      if ((i1 != getScrollX()) || (i2 != getScrollY()))
        super.scrollTo(i1, i2);
    }
  }

  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != this.l)
    {
      this.l = paramBoolean;
      requestLayout();
    }
  }

  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0)
      return;
    if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250L)
    {
      int i1 = getWidth() - getPaddingRight() - getPaddingLeft();
      int i2 = Math.max(0, getChildAt(0).getWidth() - i1);
      int i3 = getScrollX();
      int i4 = Math.max(0, Math.min(i3 + paramInt1, i2)) - i3;
      int i5 = getHeight() - getPaddingBottom() - getPaddingTop();
      int i6 = Math.max(0, getChildAt(0).getHeight() - i5);
      int i7 = getScrollY();
      int i8 = Math.max(0, Math.min(i7 + paramInt2, i6)) - i7;
      this.c.startScroll(i3, i7, i4, i8);
      postInvalidate();
    }
    while (true)
    {
      this.a = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!this.c.isFinished())
        this.c.abortAnimation();
      scrollBy(paramInt1, paramInt2);
    }
  }

  public final void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     flm.b4a.scrollview2d.TwoDScrollView
 * JD-Core Version:    0.6.2
 */