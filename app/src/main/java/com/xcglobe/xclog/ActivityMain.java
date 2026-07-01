package com.xcglobe.xclog;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import configs.ActivityConfig;
import configs.ActivityConfigDataSources;
import display.vmap.ViewVmp;
import java.util.ArrayList;
import java.util.Iterator;
import flyme_tasks.AsyncTaskC0063d;
import flyme_tasks.AsyncTaskC0066g;
import flyme_tasks.AsyncTaskC0069j;
import flyme_apphelper.C0072a;
import flyme_dialogs.DialogC0200c;
import flyme_data.C0236d;
import flyme_data.C0238f;
import flyme_data.C0239g;
import vmaps.core.C0390i;

/* loaded from: classes.dex */
public class ActivityMain extends ActivityC0090a {

    /* renamed from: b */
    public static boolean f431b = false;

    /* renamed from: c */
    private static boolean f432c = false;

    /* renamed from: d */
    private static ActivityMain f433d = null;

    /* renamed from: e */
    private static boolean f434e = false;

    /* renamed from: f */
    private static boolean f435f = true;

    /* renamed from: a */
    public ViewVmp f436a;

    /* renamed from: a */
    public static Activity m412a() {
        return f433d;
    }

    /* renamed from: a */
    public static void m413a(int i2) {
        m415a(i2, (Bundle) null);
    }

    /* renamed from: a */
    public static void m414a(final int i2, long j2) {
        C0101l.f548aF.postDelayed(new Runnable() { // from class: com.xcglobe.xclog.ActivityMain.3
            @Override // java.lang.Runnable
            public void run() {
                ActivityMain.m413a(i2);
            }
        }, j2);
    }

    /* renamed from: a */
    public static void m415a(int i2, Bundle bundle) {
        if (f433d != null) {
            Intent intent = new Intent("com.xcglobe.action.main");
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.putExtra("event", i2);
            f433d.sendBroadcast(intent);
        }
    }

    /* renamed from: b */
    private void m416b() {
        int i2 = C0101l.f575ay / 12;
        if (i2 < C0101l.f578c * 2) {
            i2 = C0101l.f578c * 2;
        }
        if (!C0101l.f539X) {
            i2 = 0;
        }
        int i3 = C0101l.f578c * 16;
        if (C0101l.f578c * 15 > C0101l.f574ax / 2) {
            int i4 = C0101l.f574ax / 2;
        }
        if (i3 > C0101l.f573aw / 2) {
            i3 = C0101l.f573aw / 2;
        }
        int i5 = C0101l.f579d * 24;
        int m424b = (C0101l.f578c * 14) + m424b(52);
        if (C0101l.f574ax < C0101l.f573aw) {
            int i6 = C0101l.f574ax - i2;
            if (i6 < C0101l.f573aw / 2) {
                i6 = C0101l.f573aw / 2;
            }
            if (C0101l.f573aw - i6 >= i3 && C0101l.f573aw - i6 <= m424b) {
                return;
            }
            int i7 = C0101l.f573aw;
        }
    }

    /* renamed from: c */
    private void m417c() {
        Toast.makeText(App.m443b(), "Installing FlyMe files...", 1).show();
        C0101l.m548a("igc", false);
        C0101l.m548a("tasks", false);
        C0101l.m548a("mpt", true);
        C0101l.m548a("vmp", true);
        f431b = true;
    }

    /* renamed from: c */
    private void m418c(int i2) {
        f434e = true;
        AsyncTaskC0063d.m321c();
        AlertDialog create = new AlertDialog.Builder(this).setIcon(R.drawable.ic_dialog_alert).setTitle(com.xcglobe.flyme.R.string.data_sources).setMessage(i2).setPositiveButton(com.xcglobe.flyme.R.string.yes, new DialogInterface.OnClickListener() { // from class: com.xcglobe.xclog.ActivityMain.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                App app = ActivityMain.this.f474Q;
                App.m445b((Dialog) dialogInterface);
                Intent intent = new Intent(App.m443b(), (Class<?>) ActivityConfigDataSources.class);
                intent.putExtra("unmarkall", true);
                ActivityMain.this.startActivity(intent);
            }
        }).setNegativeButton(com.xcglobe.flyme.R.string.no, (DialogInterface.OnClickListener) null).create();
        App app = this.f474Q;
        App.m436a(create);
    }

    /* renamed from: d */
    private void m419d() {
        String m435a;
        if (f432c || !C0095f.m483l()) {
            return;
        }
        long m526d = C0099j.m526d("install_last_splash_time");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - m526d < 86400) {
            return;
        }
        f432c = true;
        C0099j.m527d("install_last_splash_time", "" + currentTimeMillis);
        int m476e = C0095f.m476e();
        if (m476e > 0) {
            m435a = App.m435a(com.xcglobe.flyme.R.string.licence_trial_days) + " " + m476e + " " + App.m435a(com.xcglobe.flyme.R.string.days) + ".";
        } else {
            m435a = App.m435a(com.xcglobe.flyme.R.string.licence_expired);
        }
        AlertDialog create = new AlertDialog.Builder(this).setTitle(C0095f.m466a(false)).setMessage(m435a).setPositiveButton(com.xcglobe.flyme.R.string.buy_licence, new DialogInterface.OnClickListener() { // from class: com.xcglobe.xclog.ActivityMain.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                App app = ActivityMain.this.f474Q;
                App.m445b((Dialog) dialogInterface);
                ActivityMain.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((C0095f.m486o() + "flyme/buy?") + C0095f.m465a(null, false))));
            }
        }).setNegativeButton(com.xcglobe.flyme.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.xcglobe.xclog.ActivityMain.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                App app = ActivityMain.this.f474Q;
                App.m445b((Dialog) dialogInterface);
            }
        }).create();
        App app = this.f474Q;
        App.m436a(create);
    }

    /* renamed from: e */
    private void m420e() {
        if (AsyncTaskC0066g.f302b || !C0101l.f568ar.m506a(C0239g.m1073d())) {
            if (AsyncTaskC0066g.f302b || !C0101l.f568ar.m504a(10.0f, C0239g.m1073d(), true, false)) {
                AsyncTaskC0066g.m348a(C0239g.m1073d());
            }
        }
    }

    /* renamed from: f */
    private void m421f() {
        m420e();
        if (this.f436a != null) {
            this.f436a.invalidate();
        }
    }

    /* renamed from: g */
    private boolean m422g() {
        if (C0095f.m488q()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - C0099j.m526d("ask_upgrade_time") < 86400000 || f433d == null) {
            return false;
        }
        AsyncTaskC0069j.m359a((Activity) f433d);
        C0099j.m527d("ask_upgrade_time", String.valueOf(currentTimeMillis));
        return true;
    }

    /* renamed from: h */
    private boolean m423h() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (FlyMeService.class.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.xcglobe.xclog.ActivityC0090a
    /* renamed from: a */
    protected void mo399a(int i2, Intent intent) {
        if (App.m451f()) {
            return;
        }
        switch (i2) {
            case 1:
            case 2:
            case 7:
                break;
            case 3:
            case 10:
            case 16:
            case 19:
                ViewVmp.setFlag(2);
                break;
            case 4:
            case 8:
            case 9:
            case 12:
            case 15:
            case 18:
            case 20:
            case 21:
            case 22:
            case 25:
            default:
                return;
            case 5:
                ViewVmp.setFlag(2);
                m421f();
                Bundle extras = intent.getExtras();
                String string = extras != null ? extras.getString("igc") : null;
                C0239g.m1065a(60000L);
                if (string == null) {
                    string = C0239g.m1077h();
                }
                C0101l.m546a(string, this.f475R);
                return;
            case 6:
                ViewVmp.setFlag(2);
                this.f436a.invalidate();
                return;
            case 11:
                m421f();
                this.f436a.invalidate();
                if (!((!f435f || C0095f.m485n()) ? false : m422g()) && !f434e) {
                    if (C0390i.f2205r && !C0238f.m1059d()) {
                        m418c(com.xcglobe.flyme.R.string.ask_update_maps);
                    }
                    if (f435f && !C0095f.m487p()) {
                        m418c(com.xcglobe.flyme.R.string.ask_install_maps);
                    }
                }
                f435f = false;
                return;
            case 13:
                getWindow().setFlags(128, 128);
                return;
            case 14:
                getWindow().clearFlags(128);
                return;
            case 17:
                this.f436a.startThermalAssistant();
                break;
            case 23:
                DialogC0200c.m856a(this.f475R, this.f436a);
                return;
            case 24:
                ViewVmp.setFlag(1);
                return;
        }
        m421f();
    }

    /* renamed from: b */
    int m424b(int i2) {
        return (int) (i2 * C0101l.f567aq);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        DialogC0200c.m856a(this, this.f436a);
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onCreate(Bundle bundle) {
        f433d = this;
        App.m440a((String) null);
        super.onCreate(bundle);
        App.m438a(this);
        this.f476S = true;
        if (!m423h()) {
            C0101l.m541a();
            C0101l.f523H = ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == PackageManager.PERMISSION_GRANTED;
            C0236d.f1344f = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == PackageManager.PERMISSION_GRANTED;
            if (!C0101l.f523H || !C0236d.f1344f) {
                ArrayList arrayList = new ArrayList();
                if (!C0101l.f523H) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
                }
                if (!C0236d.f1344f) {
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                    arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS")
                            != PackageManager.PERMISSION_GRANTED) {
                        arrayList.add("android.permission.POST_NOTIFICATIONS");
                    }
                }
                ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[0]), 123);
            } else if (!C0095f.m480i().equals(C0099j.m515a("last_run_version"))) {
                C0101l.m541a();
                m417c();
                App.m448d();
            }
            C0094e.m462a();
            App.m444b(this);
            f435f = true;
            f432c = false;
            f434e = false;
        }
        App.m446c();
        setContentView(com.xcglobe.flyme.R.layout.activity_main2);
        this.f436a = (ViewVmp) findViewById(com.xcglobe.flyme.R.id.viewvmp);
        m416b();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.xcglobe.flyme.R.menu.activity_act_flight, menu);
        return true;
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f433d = null;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent;
        int itemId = menuItem.getItemId();
        if (itemId == 10) {
            intent = new Intent(this, (Class<?>) ActivityFlights.class);
        } else if (itemId == 20) {
            intent = new Intent(this, (Class<?>) ActivityPocket.class);
        } else {
            if (itemId != 30) {
                if (itemId != 88) {
                    switch (itemId) {
                        case 50:
                            break;
                        case 51:
                            C0239g.m1063a(46.1f, 15.16f, (short) 300, System.currentTimeMillis(), -1);
                            break;
                        case 52:
                            finish();
                            break;
                        case 53:
                            C0101l.m551b(100000, 100000);
                            break;
                        default:
                            switch (itemId) {
                                case 90:
                                    C0072a.m380b();
                                    break;
                                case 91:
                                    C0072a.m377a("demo.igc");
                                    break;
                            }
                    }
                } else {
                    C0101l.m554b(this);
                }
                return super.onOptionsItemSelected(menuItem);
            }
            intent = new Intent(this, (Class<?>) ActivityConfig.class);
        }
        startActivity(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f436a.pause();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (f433d == null) {
            return false;
        }
        DialogC0200c.m856a(f433d, this.f436a);
        return false;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 123) {
            return;
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (strArr[i3].equals("android.permission.ACCESS_FINE_LOCATION") && iArr[0] == 0) {
                C0236d.f1344f = true;
                C0236d.m1047d();
            }
            if (strArr[i3].equals("android.permission.WRITE_EXTERNAL_STORAGE") && iArr[0] == 0) {
                C0101l.f523H = true;
                C0101l.m541a();
                m417c();
                App.m448d();
            }
        }
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f436a.resume();
        C0239g.m1072c();
        if (C0101l.f556af != 0) {
            setRequestedOrientation(C0101l.f556af == 1 ? 1 : 0);
        }
        if (C0098i.f509a == 0) {
            getWindow().setFlags(128, 128);
        } else {
            getWindow().clearFlags(128);
        }
        if (C0101l.f555ae) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().clearFlags(1024);
        }
        if (f431b) {
            f431b = false;
        }
        C0101l.f566ap++;
        ViewVmp.setFlag(2);
        m421f();
        m413a(11);
        C0101l.m549a(false);
        m419d();
        if (App.m451f()) {
            finish();
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.getBoolean("quit", false)) {
            return;
        }
        App.m442a(false);
        finish();
    }
}
