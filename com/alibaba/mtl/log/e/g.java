package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: KeyArraySorter */
public final class g {
    private static g a = new g();
    private b b = new b();
    private a c = new a();

    /* compiled from: KeyArraySorter */
    private class a implements Comparator<String> {
        final /* synthetic */ g a;

        private a(g gVar) {
            this.a = gVar;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? null : str.compareTo(str2);
        }
    }

    /* compiled from: KeyArraySorter */
    private class b implements Comparator<String> {
        final /* synthetic */ g a;

        private b(g gVar) {
            this.a = gVar;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? null : -1 * str.compareTo(str2);
        }
    }

    private g() {
    }

    public static g a() {
        return a;
    }

    public final String[] a(String[] strArr) {
        Comparator comparator = this.c;
        if (comparator == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
