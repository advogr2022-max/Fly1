package flyme_device;

import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/* renamed from: d.o */
/* loaded from: classes.dex */
public class C0183o {
    private static Throwable th;
    private static int r2 = 0;
    private static Throwable e;

    /* renamed from: a */
    static a f921a = null;

    /* renamed from: b */
    static Thread f922b = null;

    /* renamed from: c */
    static boolean f923c = false;

    /* renamed from: d */
    static boolean f924d;

    /* renamed from: e */
    static int f925e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d.o$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a */
        C0179k f926a;

        a(C0179k c0179k) {
            this.f926a = c0179k;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
        
            r2 = e;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Socket socket;
            String readLine;
            try {
                ServerSocket serverSocket = new ServerSocket(C0183o.f925e);
                while (!App.m451f() && C0183o.f924d) {
                    try {
                        socket = serverSocket.accept();
                        try {
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                while (C0183o.f924d && (readLine = bufferedReader.readLine()) != null && !readLine.isEmpty()) {
                                    C0183o.f923c = true;
                                    this.f926a.m776b(readLine);
                                }
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (socket != null) {
                                    try {
                                        socket.close();
                                    } catch (IOException e3) {
                                        e = e3;
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (socket != null) {
                                try {
                                    socket.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        socket = null;
                    } catch (Throwable th2) {
                        th = th2;
                        socket = null;
                    }
                }
            } catch (Exception e6) {
                this.f926a.f881d = 0;
                e6.printStackTrace();
            }
            C0172d.m666a("Terminating looper");
            this.f926a = null;
            C0183o.f921a = null;
        }
    }

    /* renamed from: a */
    public static void m810a() {
        f924d = false;
        try {
            if (f922b != null) {
                f922b.interrupt();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m811a(C0179k c0179k, int i2) {
        m810a();
        f924d = C0099j.m521b("external_devmodel") == 6;
        if (f921a == null && f924d) {
            f925e = i2;
            f921a = new a(c0179k);
            f922b = new Thread(f921a);
            f922b.start();
        }
    }
}
