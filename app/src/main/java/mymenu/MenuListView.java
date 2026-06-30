package mymenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

/* loaded from: classes.dex */
public class MenuListView extends ListView {

    /* renamed from: a */
    int f1484a;

    /* renamed from: b */
    int f1485b;

    /* renamed from: c */
    C0242b f1486c;

    /* renamed from: d */
    public int f1487d;

    /* renamed from: e */
    boolean f1488e;

    /* renamed from: f */
    private int f1489f;

    public MenuListView(Context context) {
        super(context);
        this.f1487d = -1;
        this.f1489f = -1;
        this.f1488e = false;
    }

    public MenuListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1487d = -1;
        this.f1489f = -1;
        this.f1488e = false;
    }

    public MenuListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1487d = -1;
        this.f1489f = -1;
        this.f1488e = false;
    }

    /* renamed from: a */
    private void m1094a(int i2) {
        this.f1488e = false;
        int i3 = this.f1485b / 2;
        View view = this.f1486c.getView(i2, null, this);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        setSelectionFromTop(i2, i3 - (view.getMeasuredHeight() / 2));
    }

    /* renamed from: a */
    public void m1095a() {
        if (this.f1487d != -1) {
            int length = this.f1486c.f1503c.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.f1486c.f1503c[i2].f1505a == this.f1487d) {
                    setItemChecked(i2, true);
                    setSelection(i2);
                    this.f1489f = i2;
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void m1096a(C0242b c0242b) {
        this.f1486c = c0242b;
        setDrawingCacheEnabled(false);
        setScrollingCacheEnabled(false);
        setAdapter((ListAdapter) c0242b);
        setFocusable(true);
        setItemsCanFocus(false);
        setClickable(true);
        setChoiceMode(1);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f1484a = i2;
        this.f1485b = i3;
        if (this.f1487d == -1 || this.f1489f == -1) {
            return;
        }
        m1094a(this.f1489f);
    }
}
