package com.xcglobe.xclog;

import android.R;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ActivityFlights extends ListActivity {

    /* renamed from: b */
    private C0092c f413b;

    /* renamed from: c */
    private List<String> f414c = new ArrayList();

    /* renamed from: a */
    int f412a = 0;

    /* renamed from: b */
    private void m404b() {
        this.f414c.clear();
        File file = new File(C0101l.m558c());
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            if (listFiles.length == 0) {
                listFiles = file.listFiles();
            }
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (!name.equals("demo-track.igc") && !name.equals("demo-task.igc")) {
                    String substring = name.substring(name.lastIndexOf(46) + 1, name.length());
                    if (substring.equals("igc") || substring.equals("IGC")) {
                        this.f414c.add(file2.getName());
                    }
                }
            }
        }
        Collections.sort(this.f414c, Collections.reverseOrder());
    }

    /* renamed from: a */
    void m405a() {
        m404b();
        this.f413b.notifyDataSetChanged();
    }

    /* renamed from: a */
    void m406a(boolean z) {
        int i2;
        File[] listFiles = new File(C0101l.m558c()).listFiles();
        if (listFiles != null) {
            while (i2 < listFiles.length) {
                String name = listFiles[i2].getName();
                if (z) {
                    if (name.equals(C0101l.f581f)) {
                    }
                    C0101l.m559c(name);
                } else {
                    i2 = C0099j.m530g(name, "uploaded") == 0 ? i2 + 1 : 0;
                    C0101l.m559c(name);
                }
            }
        }
        m405a();
    }

    /* renamed from: b */
    void m407b(final boolean z) {
        new AlertDialog.Builder(this).setIcon(R.drawable.ic_dialog_alert).setTitle(com.xcglobe.flyme.R.string.delete).setMessage(z ? com.xcglobe.flyme.R.string.sure_delete_all_tracks : com.xcglobe.flyme.R.string.sure_delete_uploaded_tracks).setPositiveButton(com.xcglobe.flyme.R.string.yes, new DialogInterface.OnClickListener() { // from class: com.xcglobe.xclog.ActivityFlights.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                ActivityFlights.this.m406a(z);
            }
        }).setNegativeButton(com.xcglobe.flyme.R.string.no, (DialogInterface.OnClickListener) null).show();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C0101l.m544a(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(com.xcglobe.flyme.R.style.AppThemeBlack);
        super.onCreate(bundle);
        setContentView(com.xcglobe.flyme.R.layout.activity_flights);
        this.f413b = new C0092c(this, com.xcglobe.flyme.R.layout.file_row, this.f414c);
        setListAdapter(this.f413b);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, App.m435a(com.xcglobe.flyme.R.string.delete_uploaded));
        menu.add(1, 2, 2, App.m435a(com.xcglobe.flyme.R.string.delete_all));
        return true;
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView listView, View view, int i2, long j2) {
        super.onListItemClick(listView, view, i2, j2);
        C0101l.m546a(getListAdapter().getItem(i2).toString(), this);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                m407b(false);
                return true;
            case 2:
                m407b(true);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (App.m451f()) {
            finish();
        } else {
            m405a();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }
}
