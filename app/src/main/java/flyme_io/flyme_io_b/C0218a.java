package flyme_io.flyme_io_b;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


/* renamed from: i.b.a */
/* loaded from: classes.dex */
public class C0218a {

    /* renamed from: a */
    static final /* synthetic */ boolean f1207a = !C0218a.class.desiredAssertionStatus();

    /* renamed from: b */
    private static final byte[] f1208b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: c */
    private static final byte[] f1209c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private C0218a() {
    }

    /* renamed from: a */
    private static int m932a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i2 < 0 || (i5 = i2 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
        }
        if (i3 < 0 || (i6 = i3 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
        }
        byte[] m939b = m939b(i4);
        int i7 = i2 + 2;
        if (bArr[i7] == 61) {
            bArr2[i3] = (byte) ((((m939b[bArr[i2 + 1]] & 255) << 12) | ((m939b[bArr[i2]] & 255) << 18)) >>> 16);
            return 1;
        }
        if (bArr[i5] == 61) {
            int i8 = ((m939b[bArr[i7]] & 255) << 6) | ((m939b[bArr[i2 + 1]] & 255) << 12) | ((m939b[bArr[i2]] & 255) << 18);
            bArr2[i3] = (byte) (i8 >>> 16);
            bArr2[i3 + 1] = (byte) (i8 >>> 8);
            return 2;
        }
        int i9 = (m939b[bArr[i5]] & 255) | ((m939b[bArr[i2 + 1]] & 255) << 12) | ((m939b[bArr[i2]] & 255) << 18) | ((m939b[bArr[i7]] & 255) << 6);
        bArr2[i3] = (byte) (i9 >> 16);
        bArr2[i3 + 1] = (byte) (i9 >> 8);
        bArr2[i6] = (byte) i9;
        return 3;
    }

    /* renamed from: a */
    public static String m933a(byte[] bArr) {
        String str;
        try {
            str = m934a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (!f1207a) {
                throw new AssertionError(e2.getMessage());
            }
            str = null;
        }
        if (f1207a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static String m934a(byte[] bArr, int i2, int i3, int i4) {
        byte[] m940b = m940b(bArr, i2, i3, i4);
        try {
            return new String(m940b, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(m940b);
        }
    }

    /* renamed from: a */
    private static final byte[] m935a(int i2) {
        return f1208b;
    }

    /* renamed from: a */
    public static byte[] m936a(String str) {
        return m937a(str, 0);
    }

    /* renamed from: a */
    public static byte[] m937a(String str, int i2) {
        byte[] bytes;
        if (str == null) {
            throw new NullPointerException("Input string was null.");
        }
        try {
            bytes = str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        return m941c(bytes, 0, bytes.length, i2);
    }

    /* renamed from: a */
    private static byte[] m938a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] m935a = m935a(i5);
        int i6 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
        switch (i3) {
            case 1:
                bArr2[i4] = m935a[i6 >>> 18];
                bArr2[i4 + 1] = m935a[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = 61;
                bArr2[i4 + 3] = 61;
                return bArr2;
            case 2:
                bArr2[i4] = m935a[i6 >>> 18];
                bArr2[i4 + 1] = m935a[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = m935a[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = 61;
                return bArr2;
            case 3:
                bArr2[i4] = m935a[i6 >>> 18];
                bArr2[i4 + 1] = m935a[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = m935a[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = m935a[i6 & 63];
                return bArr2;
            default:
                return bArr2;
        }
    }

    /* renamed from: b */
    private static final byte[] m939b(int i2) {
        return f1209c;
    }

    /* renamed from: b */
    public static byte[] m940b(byte[] bArr, int i2, int i3, int i4) {
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i3);
        }
        if (i2 + i3 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
        }
        boolean z = (i4 & 8) != 0;
        int i5 = ((i3 / 3) * 4) + (i3 % 3 > 0 ? 4 : 0);
        if (z) {
            i5 += i5 / 76;
        }
        byte[] bArr2 = new byte[i5];
        int i6 = i3 - 2;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < i6) {
            int i10 = i7;
            m938a(bArr, i7 + i2, 3, bArr2, i8, i4);
            int i11 = i9 + 4;
            if (!z || i11 < 76) {
                i9 = i11;
            } else {
                bArr2[i8 + 4] = 10;
                i8++;
                i9 = 0;
            }
            i7 = i10 + 3;
            i8 += 4;
        }
        int i12 = i7;
        if (i12 < i3) {
            m938a(bArr, i12 + i2, i3 - i12, bArr2, i8, i4);
            i8 += 4;
        }
        int i13 = i8;
        if (i13 > bArr2.length - 1) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i13];
        System.arraycopy(bArr2, 0, bArr3, 0, i13);
        return bArr3;
    }

    /* renamed from: c */
    public static byte[] m941c(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (i3 == 0) {
            return new byte[0];
        }
        if (i3 < 4) {
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
        byte[] m939b = m939b(i4);
        byte[] bArr2 = new byte[(i3 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i6 = 0;
        int i7 = 0;
        while (i2 < i5) {
            byte b2 = m939b[bArr[i2] & 255];
            if (b2 < -5) {
                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)));
            }
            if (b2 >= -1) {
                int i8 = i6 + 1;
                bArr3[i6] = bArr[i2];
                if (i8 > 3) {
                    i7 += m932a(bArr3, 0, bArr2, i7, i4);
                    if (bArr[i2] == 61) {
                        break;
                    }
                    i6 = 0;
                } else {
                    i6 = i8;
                }
            }
            i2++;
        }
        byte[] bArr4 = new byte[i7];
        System.arraycopy(bArr2, 0, bArr4, 0, i7);
        return bArr4;
    }
}
