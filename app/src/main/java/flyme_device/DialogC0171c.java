package flyme_device;

import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import java.util.HashSet;
import java.util.Set;

/* renamed from: d.c */
/* loaded from: classes.dex */
public class DialogC0171c extends Dialog {
    // private static int r1 = 0;

    /* renamed from: a */
    App f747a;

    /* renamed from: b */
    Activity f748b;

    /* renamed from: c */
    Dialog f749c;

    /* renamed from: d */
    final BroadcastReceiver f750d;

    /* renamed from: e */
    private ListView f751e;

    /* renamed from: f */
    private ArrayAdapter<String> f752f;

    /* renamed from: g */
    private BluetoothAdapter f753g;

    /* renamed from: h */
    private C0169a f754h;

    /* renamed from: i */
    private Set<String> f755i;

    /* renamed from: j */
    private Set<String> f756j;

    /* renamed from: k */
    private InterfaceC0182n f757k;

    /* renamed from: l */
    private Button f758l;

    /* renamed from: m */
    private TextView f759m;

    /* renamed from: n */
    private Handler f760n;

    /* renamed from: o */
    private AdapterView.OnItemClickListener f761o;

    public DialogC0171c(Context context) {
        super(context);
        this.f754h = null;
        this.f755i = new HashSet();
        this.f756j = new HashSet();
        this.f760n = new Handler();
        this.f750d = new BroadcastReceiver() { // from class: d.c.5
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                BluetoothDevice bluetoothDevice;
                if (!"android.bluetooth.device.action.FOUND".equals(intent.getAction()) || (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) == null) {
                    return;
                }
                DialogC0171c.this.m661a(bluetoothDevice);
            }
        };
        this.f761o = new AdapterView.OnItemClickListener() { // from class: d.c.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                DialogC0171c.this.m656c();
                // C0172d.m665a(...);
                App app = DialogC0171c.this.f747a;
                App.m445b(DialogC0171c.this.f749c);
            }
        };
    }

    /* renamed from: a */
    private void m651a() {
        setContentView(R.layout.dialog_bt_scan);
        setTitle(R.string.bt_devices);
        this.f751e = (ListView) findViewById(R.id.bt_devices_list);
        this.f752f = new ArrayAdapter<>(this.f748b, R.layout.row_dialog_bt);
        this.f751e.setAdapter((ListAdapter) this.f752f);
        this.f751e.setOnItemClickListener(this.f761o);
        this.f758l = (Button) findViewById(R.id.button_rescan);
        this.f759m = (TextView) findViewById(R.id.txt_scanning);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(getWindow().getAttributes());
        App app = this.f747a;
        App.m436a(this);
        getWindow().setAttributes(layoutParams);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: d.c.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                DialogC0171c.this.f760n.removeCallbacksAndMessages(null);
                DialogC0171c.this.m656c();
                DialogC0171c.this.f748b.unregisterReceiver(DialogC0171c.this.f750d);
            }
        });
        ((Button) findViewById(R.id.button_cancel)).setOnClickListener(new View.OnClickListener() { // from class: d.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C0172d.m663a();
                DialogC0171c.this.f757k.mo678a();
                App app2 = DialogC0171c.this.f747a;
                App.m445b(DialogC0171c.this);
            }
        });
        this.f758l.setOnClickListener(new View.OnClickListener() { // from class: d.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC0171c.this.m653b();
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            this.f748b.registerReceiver(this.f750d, new IntentFilter("android.bluetooth.device.action.FOUND"), Context.RECEIVER_EXPORTED);
        } else {
            this.f748b.registerReceiver(this.f750d, new IntentFilter("android.bluetooth.device.action.FOUND"));
        }
        m653b();
    }

    /* renamed from: a */
    public static void m652a(Activity activity, InterfaceC0182n interfaceC0182n) {
        DialogC0171c dialogC0171c = new DialogC0171c(activity);
        dialogC0171c.f749c = dialogC0171c;
        dialogC0171c.f747a = (App) activity.getApplication();
        dialogC0171c.f757k = interfaceC0182n;
        dialogC0171c.f753g = BluetoothAdapter.getDefaultAdapter();
        if (dialogC0171c.f753g != null) {
            dialogC0171c.f748b = activity;
            dialogC0171c.m651a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m653b() {
        long j2;
        this.f760n.removeCallbacksAndMessages(null);
        m656c();
        this.f758l.setVisibility(8);
        this.f759m.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f754h = new C0169a(this);
            this.f754h.m636a(5000L, true);
            j2 = 5000;
        } else {
            this.f753g.startDiscovery();
            j2 = 100;
        }
        this.f760n.postDelayed(new Runnable() { // from class: d.c.4
            @Override // java.lang.Runnable
            public void run() {
                C0172d.m666a("Discovering: " + DialogC0171c.this.f753g.isDiscovering());
                if (DialogC0171c.this.f753g.isDiscovering()) {
                    DialogC0171c.this.f760n.postDelayed(this, 1000L);
                } else {
                    DialogC0171c.this.f758l.setVisibility(0);
                    DialogC0171c.this.f759m.setVisibility(8);
                }
            }
        }, j2 + 5000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m656c() {
        if (this.f753g.isDiscovering()) {
            this.f753g.cancelDiscovery();
        }
        if (this.f754h != null) {
            this.f754h.m635a(false);
        }
    }

    /* renamed from: a */
    public void m661a(BluetoothDevice bluetoothDevice) {
        C0172d.m666a("DISCOVERED: " + bluetoothDevice.getAddress());
        if (this.f756j.contains(bluetoothDevice.getAddress())) {
            return;
        }
        this.f756j.add(bluetoothDevice.getAddress());
        this.f752f.add(bluetoothDevice.getName() + "\n" + bluetoothDevice.getAddress());
        this.f752f.notifyDataSetChanged();
    }

    /* renamed from: b */
    public void m662b(BluetoothDevice bluetoothDevice) {
        this.f755i.add(bluetoothDevice.getAddress());
        if (this.f756j.contains(bluetoothDevice.getAddress())) {
            return;
        }
        this.f756j.add(bluetoothDevice.getAddress());
        this.f752f.add(bluetoothDevice.getName() + "\n" + bluetoothDevice.getAddress());
        this.f752f.notifyDataSetChanged();
    }
}
