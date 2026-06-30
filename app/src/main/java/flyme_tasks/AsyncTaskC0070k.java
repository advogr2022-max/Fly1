package flyme_tasks;

import android.os.AsyncTask;
import com.xcglobe.xclog.ActivityUpload;
import com.xcglobe.xclog.C0095f;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: b.k */
/* loaded from: classes.dex */
public class AsyncTaskC0070k extends AsyncTask<AsyncTaskC0070k.a, Integer, String> {

    /* renamed from: a */
    private String f315a = "";

    /* renamed from: b */
    private String f316b = "";

    /* renamed from: c */
    private String f317c = "";

    /* renamed from: d */
    private a f318d;

    /* renamed from: b.k$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        ActivityUpload f319a;

        /* renamed from: c */
        String f321c;

        /* renamed from: d */
        String f322d = C0099j.m515a("user.server_id");

        /* renamed from: b */
        String f320b = C0095f.m486o() + "claim/post-flight";

        public a(ActivityUpload activityUpload, String str, String str2, boolean z) {
            this.f319a = activityUpload;
            this.f321c = AsyncTaskC0070k.m367a(this.f322d, str, str2, z);
        }
    }

    /* renamed from: a */
    private String m366a(String str, String str2) {
        int indexOf = str2.indexOf("[" + str + "]");
        int indexOf2 = str2.indexOf("[/" + str + "]");
        return (indexOf == -1 || indexOf2 <= indexOf) ? "" : str2.substring(indexOf + str.length() + 2, indexOf2);
    }

    /* renamed from: a */
    static String m367a(String str, String str2, String str3, boolean z) {
        String m567f = C0101l.m567f(C0101l.m558c() + "/" + str2);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(C0095f.m465a(str, true));
            sb.append("&gtype=");
            sb.append(C0099j.m521b("user.gtype") + 1);
            sb.append("&agent=");
            sb.append(URLEncoder.encode("XCglobe logger " + C0095f.m480i(), "UTF-8"));
            sb.append("&glider=");
            sb.append(URLEncoder.encode(C0099j.m515a("user.glider"), "UTF-8"));
            sb.append("&note=");
            sb.append(URLEncoder.encode(str3, "UTF-8"));
            sb.append("&igc=");
            sb.append(URLEncoder.encode(m567f, "UTF-8"));
            sb.append("&privateflight=");
            sb.append(z ? "1" : "0");
            String sb2 = sb.toString();
            if (str.startsWith("leo_")) {
                sb2 = sb2 + "&olc=" + (str + C0099j.m515a("user.leo_server_id"));
            }
            return sb2 + "&errlog=" + URLEncoder.encode(C0101l.m567f(C0101l.m537a("error.log")), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* renamed from: b */
    private String m368b(String str) {
        if (str == null) {
            return "Error uploading IGC file";
        }
        if (!this.f318d.f322d.equals("xcglobe") && !this.f318d.f322d.equals("test")) {
            return this.f318d.f322d.equals("leo_") ? str.contains("There is already a flight") ? "Error: IGC file already exists on server" : str.contains("not a valid .igc file") ? "Error: invalid IGC file" : str.contains("Invalid user data") ? "Error: wrong username or password" : str.contains("flight cannot be entered") ? str.contains("Glider class") ? "Error: please select glider type" : (str.contains("Press here to view it") || !str.contains("problem")) ? "Error: IGC file already exists on server" : "Error: Leonardo server unknown error" : str.contains("Your flight has been submitted") ? "" : str.contains("There is already a flight with the same date") ? "Error: IGC file already exists on server" : str.contains("You have not entered brand or glider") ? "Error: please enter glider model" : str.contains("You are not logged in") ? "Error: wrong username or password" : str.contains("This is not a valid .igc file") ? "Error: invalid IGC file" : str.contains("invalid password") ? "Error: wrong username or password" : "Error uploading IGC file" : "Error uploading IGC file";
        }
        this.f315a = m366a("title", str);
        this.f316b = m366a("note", str);
        this.f317c = m366a("url", str);
        return str.startsWith("OK") ? "" : str.startsWith("ERROR 1") ? "Error: wrong username or password" : str.startsWith("ERROR 2") ? "Error: please enter glider model" : str.startsWith("ERROR 3") ? "Error: please select glider type" : str.startsWith("ERROR 4") ? "Error: IGC file missing" : str.startsWith("ERROR 5") ? "Error: IGC file already exists on server" : str.startsWith("ERROR 6") ? "Error: invalid IGC file" : "Error uploading IGC file";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(a... aVarArr) {
        this.f318d = aVarArr[0];
        return m368b(C0101l.m540a(this.f318d.f320b, this.f318d.f321c.getBytes()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (str.length() == 0) {
            try {
                File file = new File(C0101l.m537a("error.log"));
                if (file.isFile()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
        try {
            this.f318d.f319a.m431a(str, this.f315a, this.f316b, this.f317c);
        } catch (Exception unused2) {
        }
    }
}
