package com.xunlei.downloadprovider.ad.downloadlist.b;

import com.xunlei.downloadprovider.ad.common.adget.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ListADDataHolder */
public final class a {
    public static a j;
    public Set<String> a = new HashSet();
    public Set<String> b = new HashSet();
    public Set<String> c = new HashSet();
    public List<l> d = new ArrayList();
    public List<l> e = new ArrayList();
    public List<l> f = new ArrayList();
    public List<l> g = new ArrayList();
    public List<l> h = new ArrayList();
    public List<l> i = new ArrayList();
    public boolean[] k = new boolean[3];
    public boolean[] l = new boolean[3];
    public int[] m = new int[3];
    private Map<String, l> n = new HashMap();
    private Map<String, l> o = new HashMap();
    private Map<String, l> p = new HashMap();

    private a() {
    }

    public static a a() {
        if (j == null) {
            j = new a();
        }
        return j;
    }

    public final Map<String, l> a(int i) {
        switch (i) {
            case 0:
                return this.n;
            case 1:
                return this.o;
            case 2:
                return this.p;
            default:
                return 0;
        }
    }
}
