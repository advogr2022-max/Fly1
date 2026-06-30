package flyme_apphelper;

import com.xcglobe.xclog.App;
import types.C0371k;
import vmaps.C0391d;

/* renamed from: c.b */
/* loaded from: classes.dex */
public class C0073b {

    /* renamed from: a */
    public static int f341a = 0;

    /* renamed from: b */
    private static boolean f342b = false;

    public C0073b(final float f2, final float f3) {
        App.f462c.post(new Runnable() { // from class: c.-$$Lambda$b$Hv_oE4zJnVS-oRFXYrw3bKL2Eto
            @Override // java.lang.Runnable
            public final void run() {
                C0073b.this.m385a(f2, f3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m385a(final float f2, final float f3) {
        if (f342b) {
            return;
        }
        f342b = true;
        new Thread(new Runnable() { // from class: c.-$$Lambda$b$asU2JdzDflJV-c-1Wr67xQiwph4
            @Override // java.lang.Runnable
            public final void run() {
                C0073b.this.m387b(f2, f3);
            }
        }).start();
    }

    /* renamed from: a */
    private void m386a(final C0371k c0371k) {
        App.f462c.post(new Runnable() { // from class: c.-$$Lambda$b$_qkeqfR506e4OoKGw2lHX3oXLDQ
            @Override // java.lang.Runnable
            public final void run() {
                // C0073b.m388b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m387b(float f2, float f3) {
        try {
            m386a(C0371k.m1252a(400, 400, f2, f3, (int) C0391d.f2240a));
        } catch (Exception e2) {
            App.m441a("GroundCreator", e2);
            m386a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m388b(C0371k c0371k) {
        if (c0371k != null) {
            C0391d.m1415a(c0371k);
        }
        f341a++;
        f342b = false;
    }
}
