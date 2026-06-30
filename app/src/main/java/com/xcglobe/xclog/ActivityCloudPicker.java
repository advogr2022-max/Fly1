package com.xcglobe.xclog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xcglobe.flyme.R;
import java.io.File;
import flyme_tasks.AsyncTaskC0064e;
import flyme_poi.C0227a;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class ActivityCloudPicker extends ActivityC0090a {
    // private static int r3 = 0;

    /* renamed from: a */
    int f364a;

    /* renamed from: b */
    private WebView f365b;

    /* renamed from: com.xcglobe.xclog.ActivityCloudPicker$a */
    /* loaded from: classes.dex */
    private class C0076a extends WebViewClient {

        /* renamed from: b */
        private boolean f367b;

        private C0076a() {
            this.f367b = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (this.f367b) {
                this.f367b = false;
                webView.loadUrl("http://xcglobe.com/tools/cloudapi/picker/domains/" + ActivityCloudPicker.this.f364a);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2;
            if (str.indexOf("#pick") == -1) {
                webView.loadUrl(str);
                return false;
            }
            if (ActivityCloudPicker.this.f364a == 2) {
                str2 = "waypoints/";
            } else {
                if (ActivityCloudPicker.this.f364a != 9) {
                    if (ActivityCloudPicker.this.f364a == 1) {
                        str2 = "Openair/";
                    }
                    return false;
                }
                str2 = "tasks/";
                str = str.replace("?", "?a=flyme-task&");
            }
            new AsyncTaskC0064e().m330a(C0101l.m537a(str2), str);
            return false;
        }
    }

    @Override // com.xcglobe.xclog.ActivityC0090a
    /* renamed from: a */
    protected void mo399a(int i2, Intent intent) {
        if (i2 != 26) {
            return;
        }
        if (this.f364a == 9) {
            String string = intent.getExtras().getString("file");
            if (!string.endsWith(".cup")) {
                File file = new File(string);
                File file2 = new File(string + ".cup");
                if (file2.isFile()) {
                    file2.delete();
                }
                file.renameTo(file2);
                string = file2.getAbsolutePath();
            }
            // C0227a.m988a(...);
        }
        this.f475R.finish();
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.wactivity_common);
        this.f476S = true;
        this.f364a = getIntent().getIntExtra("type", 0);
        this.f365b = (WebView) findViewById(R.id.webViewCommon);
        this.f365b.getSettings().setJavaScriptEnabled(true);
        this.f365b.setWebViewClient(new C0076a());
        this.f365b.loadData("<html><body>Connecting to cloud...</body></html>", "text/html; charset=UTF-8", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
