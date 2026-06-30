package com.xcglobe.xclog;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.xcglobe.flyme.R;
import configs.ActivityConfig;
import display.vmap.ViewVmp;
import flyme_tasks.AsyncTaskC0066g;
import flyme_data.C0239g;

/* loaded from: classes.dex */
public class ActivityMap extends ActivityC0090a {

    /* renamed from: a */
    String f441a = null;

    /* renamed from: b */
    ViewVmp f442b;

    /* renamed from: c */
    boolean f443c;

    @Override // com.xcglobe.xclog.ActivityC0090a
    /* renamed from: a */
    protected void mo399a(int i2, Intent intent) {
        if (i2 != 16) {
            switch (i2) {
                case 10:
                case 11:
                    break;
                default:
                    return;
            }
        }
        ViewVmp.setFlag(2);
    }

    public void clickMap(View view) {
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_map);
        this.f476S = true;
        this.f442b = (ViewVmp) findViewById(R.id.viewmap);
        ViewVmp.setFlag(8);
        Bundle extras = getIntent().getExtras();
        this.f441a = extras.getString("igc");
        this.f443c = extras.getBoolean("task", false);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(1, 30, 1, App.m435a(R.string.menu_settings));
        menu.add(1, 20, 2, App.m435a(R.string.home));
        menu.add(1, 10, 3, R.string.saved_flights);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent;
        int itemId = menuItem.getItemId();
        if (itemId == 10) {
            intent = new Intent(this, (Class<?>) ActivityFlights.class);
        } else if (itemId == 20) {
            intent = new Intent(this, (Class<?>) ActivityMain.class);
        } else {
            if (itemId != 30) {
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
        this.f442b.pause();
        ActivityMain.f431b = true;
        C0239g.m1068b();
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f441a != null) {
            C0239g.m1071b(this.f441a);
        } else if (this.f443c) {
            C0239g.m1079j();
        }
        this.f442b.resume();
        AsyncTaskC0066g.m348a(C0239g.m1073d());
    }
}
