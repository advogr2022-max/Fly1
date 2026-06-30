package configs;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.xcglobe.xclog.App;

/* renamed from: configs.a */
/* loaded from: classes.dex */
public class C0166a extends PreferenceActivity {

    /* renamed from: a */
    private BroadcastReceiver f709a;

    /* renamed from: l */
    protected App f710l;

    /* renamed from: m */
    protected C0166a f711m;

    /* renamed from: n */
    protected boolean f712n = false;

    /* renamed from: configs.a$a */
    /* loaded from: classes.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.xcglobe.action.main".equals(intent.getAction())) {
                C0166a.this.f711m.mo577a(intent.getIntExtra("event", 0), intent);
            }
        }
    }

    /* renamed from: a */
    private void m630a() {
        Activity m434a = App.m434a();
        if (m434a == null || !m434a.equals(this)) {
            return;
        }
        this.f710l.m454a((Activity) null);
    }

    /* renamed from: a */
    protected void mo577a(int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f710l = (App) getApplicationContext();
        this.f711m = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    public void onDestroy() {
        App app = this.f710l;
        App.m453h();
        m630a();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        m630a();
        if (this.f709a != null) {
            unregisterReceiver(this.f709a);
            this.f709a = null;
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f710l.m454a(this);
        if (this.f712n) {
            this.f709a = new a();
            registerReceiver(this.f709a, new IntentFilter("com.xcglobe.action.main"));
        }
    }
}
