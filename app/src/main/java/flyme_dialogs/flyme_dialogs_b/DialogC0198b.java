package flyme_dialogs.flyme_dialogs_b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ToggleButton;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0097h;
import com.xcglobe.xclog.C0101l;
import configs.ActivityConfigTasks;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import mymenu.DialogC0241a;
import flyme_tasks.AsyncTaskC0066g;
import flyme_dialogs.DialogC0194a;
import flyme_dialogs.flyme_dialogs_b.DialogC0198b;
import flyme_poi.C0227a;
import flyme_data.C0239g;
import types.C0366f;
import types.GpsVal;
import types.PoiPoint;

/* renamed from: f.b.b */
/* loaded from: classes.dex */
public class DialogC0198b extends Dialog {

    /* renamed from: c */
    static C0097h f970c = new C0097h();

    /* renamed from: e */
    static boolean f971e = true;

    /* renamed from: w */
    private static int f972w = 100;

    /* renamed from: A */
    private boolean f973A;

    /* renamed from: B */
    private boolean f974B;

    /* renamed from: C */
    private View.OnClickListener f975C;

    /* renamed from: a */
    int f976a;

    /* renamed from: b */
    boolean f977b;

    /* renamed from: d */
    Activity f978d;

    /* renamed from: f */
    ListView f979f;

    /* renamed from: g */
    C0199c f980g;

    /* renamed from: h */
    a f981h;

    /* renamed from: i */
    PoiPoint f982i;

    /* renamed from: j */
    GpsVal f983j;

    /* renamed from: k */
    PoiPoint f984k;

    /* renamed from: l */
    boolean f985l;

    /* renamed from: m */
    ToggleButton f986m;

    /* renamed from: n */
    ToggleButton f987n;

    /* renamed from: o */
    ToggleButton f988o;

    /* renamed from: p */
    ToggleButton f989p;

    /* renamed from: q */
    ToggleButton f990q;

    /* renamed from: r */
    EditText f991r;

    /* renamed from: s */
    boolean f992s;

    /* renamed from: t */
    private final int f993t;

    /* renamed from: u */
    private final int f994u;

    /* renamed from: v */
    private final int f995v;

    /* renamed from: x */
    private boolean f996x;

    /* renamed from: y */
    private boolean f997y;

    /* renamed from: z */
    private boolean f998z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f.b.b$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends DialogC0241a {
        AnonymousClass2(Context context, String str) {
            super(context, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m853a(PoiPoint poiPoint) {
            AsyncTaskC0066g.m344a(DialogC0198b.this.f984k.f1979l, DialogC0198b.this.f984k.f1976i, DialogC0198b.this.f984k.f1977j);
            DialogC0198b.this.m851a(poiPoint);
            DialogC0198b.this.f983j.f1972a = poiPoint.f1976i;
            DialogC0198b.this.f983j.f1973b = poiPoint.f1977j;
            DialogC0198b.this.m850a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m854b(PoiPoint poiPoint) {
            DialogC0198b.this.m851a(poiPoint);
            DialogC0198b.this.f983j.f1972a = poiPoint.f1976i;
            DialogC0198b.this.f983j.f1973b = poiPoint.f1977j;
            DialogC0198b.this.m850a();
        }

        @Override // mymenu.DialogC0241a
        /* renamed from: a */
        public boolean mo588a(int i2) {
            Activity activity;
            PoiPoint poiPoint;
            DialogC0194a.a aVar;
            switch (i2) {
                case 1:
                    DialogC0198b.f971e = true;
                    DialogC0198b.f970c.m502a();
                    ((C0199c) DialogC0198b.this.f979f.getAdapter()).notifyDataSetChanged();
                    DialogC0198b.this.f979f.setSelectionAfterHeaderView();
                    break;
                case 2:
                    DialogC0198b.f971e = false;
                    DialogC0198b.f970c.m507b();
                    ((C0199c) DialogC0198b.this.f979f.getAdapter()).notifyDataSetChanged();
                    DialogC0198b.this.f979f.setSelectionAfterHeaderView();
                    break;
                case 3:
                    DialogC0198b.this.m849g();
                    break;
                case 4:
                    activity = DialogC0198b.this.f978d;
                    poiPoint = null;
                    aVar = new DialogC0194a.a() { // from class: f.b.-$$Lambda$b$2$kCflUuliZX2ifCo2Q9iIkhaOHUU
                        @Override // flyme_dialogs.DialogC0194a.a
                        public final void call(PoiPoint poiPoint2) {
                            DialogC0198b.AnonymousClass2.this.m854b(poiPoint2);
                        }
                    };
                    DialogC0194a.m828a(activity, poiPoint, aVar);
                    break;
                default:
                    switch (i2) {
                        case 98:
                            activity = DialogC0198b.this.f978d;
                            poiPoint = DialogC0198b.this.f984k;
                            aVar = new DialogC0194a.a() { // from class: f.b.-$$Lambda$b$2$G5zfm2f59aw0YQrz9PbhQO5rGbs
                                @Override // flyme_dialogs.DialogC0194a.a
                                public final void call(PoiPoint poiPoint2) {
                                    DialogC0198b.AnonymousClass2.this.m853a(poiPoint2);
                                }
                            };
                            DialogC0194a.m828a(activity, poiPoint, aVar);
                            break;
                        case 99:
                            AsyncTaskC0066g.m344a(DialogC0198b.this.f984k.f1979l, DialogC0198b.this.f984k.f1976i, DialogC0198b.this.f984k.f1977j);
                            DialogC0198b.this.f985l = false;
                            DialogC0198b.this.m850a();
                            break;
                    }
            }
            return true;
        }
    }

    /* renamed from: f.b.b$a */
    /* loaded from: classes.dex */
    public interface a {
        void call(PoiPoint poiPoint);
    }

    private DialogC0198b(Context context) {
        super(context);
        this.f993t = 0;
        this.f994u = 1;
        this.f995v = 2;
        this.f983j = new GpsVal();
        this.f984k = new PoiPoint();
        this.f985l = false;
        this.f996x = false;
        this.f992s = false;
        this.f975C = new View.OnClickListener() { // from class: f.b.b.3

            /* renamed from: a */
            DialogC0198b f1001a;

            {
                this.f1001a = DialogC0198b.this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i2;
                C0101l.f570at = DialogC0198b.this.f987n.isChecked();
                C0101l.f569as = DialogC0198b.this.f986m.isChecked();
                C0101l.f571au = DialogC0198b.this.f988o.isChecked();
                C0101l.f572av = DialogC0198b.this.f989p.isChecked();
                if (DialogC0198b.this.m852b()) {
                    DialogC0198b.f970c.m505a(999999.0f, DialogC0198b.this.f983j, false, true, true);
                } else {
                    DialogC0198b.f970c.m505a(DialogC0198b.f972w, DialogC0198b.this.f983j, false, true, false);
                }
                if (DialogC0198b.f971e) {
                    DialogC0198b.f970c.m502a();
                } else {
                    DialogC0198b.f970c.m507b();
                }
                DialogC0198b.this.f980g = new C0199c(DialogC0198b.this.f978d, R.layout.dialog_goal_row, DialogC0198b.f970c.f499d, DialogC0198b.f970c.f500e, this.f1001a);
                DialogC0198b.this.f979f.setAdapter((ListAdapter) DialogC0198b.this.f980g);
                ((C0199c) DialogC0198b.this.f979f.getAdapter()).notifyDataSetChanged();
                DialogC0198b.this.f979f.setSelectionAfterHeaderView();
                DialogC0198b.this.f992s = true;
                if (view == DialogC0198b.this.f987n) {
                    i2 = R.string.poi_show_geo;
                } else if (view == DialogC0198b.this.f986m) {
                    i2 = R.string.poi_show_site;
                } else if (view == DialogC0198b.this.f988o) {
                    i2 = R.string.poi_show_livetrack;
                } else if (view != DialogC0198b.this.f989p) {
                    return;
                } else {
                    i2 = R.string.poi_show_waypoints;
                }
                C0101l.m553b(i2, false);
            }
        };
        this.f978d = (Activity) context;
    }

    /* renamed from: a */
    public static void m833a(Activity activity, GpsVal gpsVal, PoiPoint poiPoint, boolean z, a aVar) {
        m843c(activity, gpsVal, poiPoint, z, aVar).m846d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m834a(DialogInterface dialogInterface) {
        if (this.f992s) {
            AsyncTaskC0066g.f302b = true;
        }
        if (this.f996x) {
            C0101l.f570at = this.f998z;
            C0101l.f571au = this.f973A;
            C0101l.f569as = this.f997y;
            C0101l.f572av = this.f974B;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m835a(View view) {
        this.f991r.setText("");
        this.f991r.setVisibility(this.f990q.isChecked() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m837a(DialogC0198b dialogC0198b, AdapterView adapterView, View view, int i2, long j2) {
        dialogC0198b.f981h.call((PoiPoint) adapterView.getAdapter().getItem(i2));
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m838a(AdapterView adapterView, View view, int i2, long j2) {
        PoiPoint poiPoint = (PoiPoint) adapterView.getAdapter().getItem(i2);
        if (poiPoint.f1980m == 'w') {
            this.f984k.m1171a(poiPoint);
            this.f985l = true;
            openOptionsMenu();
        }
        return true;
    }

    /* renamed from: b */
    public static void m839b(Activity activity, GpsVal gpsVal, PoiPoint poiPoint, boolean z, a aVar) {
        DialogC0198b m843c = m843c(activity, gpsVal, poiPoint, z, aVar);
        m843c.f997y = C0101l.f569as;
        m843c.f998z = C0101l.f570at;
        m843c.f973A = C0101l.f571au;
        m843c.f974B = C0101l.f572av;
        m843c.f996x = true;
        C0101l.f569as = false;
        C0101l.f571au = false;
        C0101l.f570at = false;
        C0101l.f572av = true;
        m843c.m846d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m840b(View view) {
        openOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m841b(PoiPoint poiPoint) {
        AsyncTaskC0066g.m344a(this.f984k.f1979l, this.f984k.f1976i, this.f984k.f1977j);
        m851a(poiPoint);
        this.f983j.f1972a = poiPoint.f1976i;
        this.f983j.f1973b = poiPoint.f1977j;
        m850a();
    }

    /* renamed from: c */
    private static DialogC0198b m843c(Activity activity, GpsVal gpsVal, PoiPoint poiPoint, boolean z, a aVar) {
        DialogC0198b dialogC0198b = new DialogC0198b(activity);
        dialogC0198b.f981h = aVar;
        dialogC0198b.f977b = z;
        if (poiPoint != null) {
            dialogC0198b.f982i = new PoiPoint();
            dialogC0198b.f982i.m1171a(poiPoint);
        }
        dialogC0198b.f983j.m1169a(gpsVal);
        return dialogC0198b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m844c(View view) {
        if (this.f976a == 1) {
            this.f978d.startActivity(new Intent(this.f978d, (Class<?>) ActivityConfigTasks.class));
        } else {
            m849g();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m845c(PoiPoint poiPoint) {
        m851a(poiPoint);
        this.f983j.f1972a = poiPoint.f1976i;
        this.f983j.f1973b = poiPoint.f1977j;
        m850a();
    }

    /* renamed from: d */
    private void m846d() {
        requestWindowFeature(3);
        setContentView(R.layout.dialog_goal);
        setTitle(App.m435a(R.string.select_goal));
        findViewById(R.id.dlg_goal_layout).setBackgroundColor(C0101l.f592q);
        AsyncTaskC0066g.m341a(f970c, this.f983j, true);
        this.f979f = (ListView) findViewById(R.id.dlg_goal_goal);
        if (m852b()) {
            f970c.m505a(999999.0f, this.f983j, false, true, true);
        } else {
            f970c.m505a(f972w, this.f983j, false, true, false);
        }
        if (f971e) {
            f970c.m502a();
        } else {
            f970c.m507b();
        }
        this.f980g = new C0199c(this.f978d, R.layout.dialog_goal_row, f970c.f499d, f970c.f500e, this);
        this.f979f.setAdapter((ListAdapter) this.f980g);
        this.f979f.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: f.b.-$$Lambda$b$pVOWCq2LSQWXqPJq0qF8GHUAes4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                DialogC0198b.this.m837a(DialogC0198b.this, adapterView, view, i2, j2);
            }
        });
        this.f979f.setLongClickable(true);
        this.f979f.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: f.b.-$$Lambda$b$g0SHu32sQcyb2-SF8UAnM3B1hKQ
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i2, long j2) {
                boolean m838a;
                m838a = DialogC0198b.this.m838a(adapterView, view, i2, j2);
                return m838a;
            }
        });
        if (!this.f977b) {
            this.f976a = 0;
        } else if (!C0227a.m991f() || C0366f.f2009g) {
            this.f976a = 1;
        } else {
            this.f976a = 2;
        }
        Button button = (Button) findViewById(R.id.dlg_goal_btn_cancel);
        if (this.f976a == 0) {
            button.setVisibility(8);
        } else {
            button.setText(m848f());
            button.setOnClickListener(new View.OnClickListener() { // from class: f.b.-$$Lambda$b$eJ1S-kSHZgMXqzOuXwRJKQl-aho
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogC0198b.this.m844c(view);
                }
            });
        }
        ((Button) findViewById(R.id.dlg_goal_btn_opt)).setOnClickListener(new View.OnClickListener() { // from class: f.b.-$$Lambda$b$b_QKNDeneaiJQAxlG1dKcKMh_8o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC0198b.this.m840b(view);
            }
        });
        this.f987n = (ToggleButton) findViewById(R.id.dlg_goal_btn_poi_geo);
        this.f986m = (ToggleButton) findViewById(R.id.dlg_goal_btn_poi_site);
        this.f988o = (ToggleButton) findViewById(R.id.dlg_goal_btn_poi_livetrack);
        this.f989p = (ToggleButton) findViewById(R.id.dlg_goal_btn_poi_waypoints);
        this.f990q = (ToggleButton) findViewById(R.id.dlg_goal_btn_enable_search);
        this.f987n.setChecked(C0101l.f570at);
        this.f986m.setChecked(C0101l.f569as);
        this.f988o.setChecked(C0101l.f571au);
        this.f989p.setChecked(C0101l.f572av);
        this.f990q.setChecked(false);
        this.f987n.setOnClickListener(this.f975C);
        this.f986m.setOnClickListener(this.f975C);
        this.f988o.setOnClickListener(this.f975C);
        this.f989p.setOnClickListener(this.f975C);
        this.f990q.setOnClickListener(new View.OnClickListener() { // from class: f.b.-$$Lambda$b$Dkp-tDbX9bgTutw8O4Pb2QTqG4Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC0198b.this.m835a(view);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: f.b.-$$Lambda$b$Gf3pOkEltuWNfn1gUuQWEyS3NYg
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogC0198b.this.m834a(dialogInterface);
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(getWindow().getAttributes());
        layoutParams.width = -1;
        show();
        setFeatureDrawableResource(3, R.drawable.goal_white);
        getWindow().setAttributes(layoutParams);
        m847e();
    }

    /* renamed from: e */
    private void m847e() {
        this.f991r = (EditText) findViewById(R.id.inputSearch);
        this.f991r.setVisibility(8);
        this.f991r.addTextChangedListener(new TextWatcher() { // from class: f.b.b.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                DialogC0198b.this.f980g.getFilter().filter(charSequence);
            }
        });
    }

    /* renamed from: f */
    private String m848f() {
        switch (this.f976a) {
            case 1:
                return App.m435a(R.string.tasks);
            case 2:
                return C0227a.f1276a.f1278b;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m849g() {
        this.f981h.call(null);
        Intent intent = new Intent("com.xcglobe.action.main");
        intent.putExtra("event", 7);
        App.m443b().sendBroadcast(intent);
        dismiss();
    }

    /* renamed from: a */
    public void m850a() {
        AsyncTaskC0066g.m341a(f970c, this.f983j, true);
        if (m852b()) {
            f970c.m505a(999999.0f, this.f983j, false, true, true);
        } else {
            f970c.m505a(f972w, this.f983j, false, true, false);
        }
        if (f971e) {
            f970c.m502a();
        } else {
            f970c.m507b();
        }
        this.f980g = new C0199c(this.f978d, R.layout.dialog_goal_row, f970c.f499d, f970c.f500e, this);
        this.f979f.setAdapter((ListAdapter) this.f980g);
        ((C0199c) this.f979f.getAdapter()).notifyDataSetChanged();
        this.f979f.setSelectionAfterHeaderView();
        AsyncTaskC0066g.m348a(C0239g.m1073d());
    }

    /* renamed from: a */
    public void m851a(PoiPoint poiPoint) {
        String m537a = C0101l.m537a("poi/waypoints.cup");
        if (m537a == null) {
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(m537a), true));
            bufferedWriter.append((CharSequence) ("\n\"" + poiPoint.f1979l + "\",,," + C0101l.m533a(poiPoint.f1976i, true) + "," + C0101l.m533a(poiPoint.f1977j, false) + "," + ((int) poiPoint.f1978k) + "m,,,"));
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException unused) {
        }
    }

    /* renamed from: b */
    boolean m852b() {
        return (!C0101l.f572av || C0101l.f570at || C0101l.f571au || C0101l.f569as) ? false : true;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        Activity activity;
        PoiPoint poiPoint;
        DialogC0194a.a aVar;
        int itemId = menuItem.getItemId();
        switch (itemId) {
            case 1:
                f971e = true;
                f970c.m502a();
                ((C0199c) this.f979f.getAdapter()).notifyDataSetChanged();
                this.f979f.setSelectionAfterHeaderView();
                break;
            case 2:
                f971e = false;
                f970c.m507b();
                ((C0199c) this.f979f.getAdapter()).notifyDataSetChanged();
                this.f979f.setSelectionAfterHeaderView();
                break;
            case 3:
                m849g();
                break;
            case 4:
                activity = this.f978d;
                poiPoint = null;
                aVar = new DialogC0194a.a() { // from class: f.b.-$$Lambda$b$DhvL_jLmhCo-t5rVoyT34ygKwm8
                    @Override // flyme_dialogs.DialogC0194a.a
                    public final void call(PoiPoint poiPoint2) {
                        DialogC0198b.this.m845c(poiPoint2);
                    }
                };
                DialogC0194a.m828a(activity, poiPoint, aVar);
                break;
            default:
                switch (itemId) {
                    case 98:
                        activity = this.f978d;
                        poiPoint = this.f984k;
                        aVar = new DialogC0194a.a() { // from class: f.b.-$$Lambda$b$4w-H6PaNEpS9n04xW3SxBSXfIwk
                            @Override // flyme_dialogs.DialogC0194a.a
                            public final void call(PoiPoint poiPoint2) {
                                DialogC0198b.this.m841b(poiPoint2);
                            }
                        };
                        DialogC0194a.m828a(activity, poiPoint, aVar);
                        break;
                    case 99:
                        AsyncTaskC0066g.m344a(this.f984k.f1979l, this.f984k.f1976i, this.f984k.f1977j);
                        this.f985l = false;
                        m850a();
                        break;
                }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Dialog
    public boolean onPrepareOptionsMenu(Menu menu) {
        int i2;
        int i3;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f978d, this.f985l ? this.f984k.f1979l : null);
        if (!this.f985l) {
            anonymousClass2.m1100a(1, App.m435a(R.string.sort_by_dist));
            anonymousClass2.m1100a(2, App.m435a(R.string.sort_by_alpha));
            anonymousClass2.m1100a(4, App.m435a(R.string.add_task_point));
            if (!C0366f.f2009g && C0366f.f2003a != null) {
                i2 = 3;
                i3 = R.string.cancel_point;
            }
            this.f985l = false;
            anonymousClass2.m1098a();
            return false;
        }
        anonymousClass2.m1100a(98, App.m435a(R.string.edit));
        i2 = 99;
        i3 = R.string.delete;
        anonymousClass2.m1100a(i2, App.m435a(i3));
        this.f985l = false;
        anonymousClass2.m1098a();
        return false;
    }
}
