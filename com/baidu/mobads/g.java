package com.baidu.mobads;

import java.util.HashMap;

public class g {
    private static g a;
    private static HashMap<String, String> b = new HashMap();

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    public int a(int i) {
        int i2 = 1;
        if (i <= 0) {
            return 1;
        }
        try {
            if (b.containsKey(String.valueOf(i))) {
                int parseInt = Integer.parseInt((String) b.get(String.valueOf(i))) + 1;
                if (parseInt > 0) {
                    i2 = parseInt;
                }
                b.put(String.valueOf(i), String.valueOf(i2));
            } else {
                b.put(String.valueOf(i), "1");
            }
        } catch (int i3) {
            i3.printStackTrace();
        }
        return i2;
    }
}
