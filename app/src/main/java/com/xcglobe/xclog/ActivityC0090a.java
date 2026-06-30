package com.xcglobe.xclog;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/* renamed from: com.xcglobe.xclog.a */
/* loaded from: classes.dex */
public class ActivityC0090a extends Activity {

    /* renamed from: Q */
    protected App f474Q;

    /* renamed from: R */
    protected ActivityC0090a f475R;

    /* renamed from: S */
    protected boolean f476S = false;

    /* renamed from: a */
    private BroadcastReceiver f477a;

    /* renamed from: com.xcglobe.xclog.a$a */
    /* loaded from: classes.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.xcglobe.action.main".equals(intent.getAction())) {
                ActivityC0090a.this.f475R.mo399a(intent.getIntExtra("event", 0), intent);
            }
        }
    }

    /* renamed from: a */
    private void m459a() {
        Activity m434a = App.m434a();
        if (m434a == null || !m434a.equals(this)) {
            return;
        }
        this.f474Q.m454a((Activity) null);
    }

    /* renamed from: a */
    protected void mo399a(int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f474Q = (App) getApplicationContext();
        this.f475R = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        App app = this.f474Q;
        App.m453h();
        m459a();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        m459a();
        if (this.f477a != null) {
            unregisterReceiver(this.f477a);
            this.f477a = null;
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f474Q.m454a(this);
        if (this.f476S) {
            this.f477a = new a();
            registerReceiver(this.f477a, new IntentFilter("com.xcglobe.action.main"));
        }
    }
}
