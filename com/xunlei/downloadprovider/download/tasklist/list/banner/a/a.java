package com.xunlei.downloadprovider.download.tasklist.list.banner.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CountTimer */
public final class a {
    private static a e = new a();
    public SparseArray<ArrayList<WeakReference<a>>> a = new SparseArray();
    public SparseArray<Runnable> b = new SparseArray();
    public Handler c = new Handler(Looper.getMainLooper(), new b(this));
    public Map<String, Integer> d = new HashMap();

    /* compiled from: CountTimer */
    public interface a {
        void a(String str);

        void b(String str);
    }

    public static a a() {
        return e;
    }

    public final int[] a(String str) {
        Integer num = (Integer) this.d.get(b(str));
        if (num == null) {
            return null;
        }
        int intValue = (num.intValue() / 60) % 100;
        str = num.intValue() % 60;
        int i = intValue / 10;
        intValue %= 10;
        int i2 = str / 10;
        str %= 10;
        return new int[]{i, intValue, i2, str};
    }

    public static String b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("#");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static boolean a(String str, String str2) {
        return TextUtils.equals(str, b(str2));
    }

    static /* synthetic */ void a(a aVar, int i, String str) {
        ArrayList arrayList = (ArrayList) aVar.a.get(i);
        if (arrayList != null) {
            i = 0;
            int size = arrayList.size();
            while (i < size) {
                if (!(arrayList.get(i) == null || ((WeakReference) arrayList.get(i)).get() == null)) {
                    ((a) ((WeakReference) arrayList.get(i)).get()).a(str);
                }
                i++;
            }
        }
    }

    static /* synthetic */ void b(a aVar, int i, String str) {
        ArrayList arrayList = (ArrayList) aVar.a.get(i);
        if (arrayList != null) {
            i = 0;
            int size = arrayList.size();
            while (i < size) {
                if (!(arrayList.get(i) == null || ((WeakReference) arrayList.get(i)).get() == null)) {
                    ((a) ((WeakReference) arrayList.get(i)).get()).b(str);
                }
                i++;
            }
        }
    }
}
