package com.alibaba.baichuan.android.trade.c.a.a.a;

import android.net.Uri;
import com.alibaba.baichuan.android.trade.utils.f;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c extends com.alibaba.baichuan.android.trade.c.a.a.c {
    private boolean a = false;
    private final int b = 10240;
    private final Set c = new HashSet();
    private String[] d = new String[]{Constants.KEY_TTID};

    private String a(int i) {
        if (this.j == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = null;
        for (Entry entry : this.j.entrySet()) {
            if (1 != i || !this.c.contains(entry.getKey())) {
                List list = (List) entry.getValue();
                int size = list.size();
                Object obj2 = obj;
                for (int i2 = 0; i2 < size; i2++) {
                    String str;
                    if (obj2 != null) {
                        stringBuilder.append("&");
                    } else {
                        obj2 = 1;
                    }
                    if (e((String) entry.getKey())) {
                        stringBuilder.append(Uri.encode((String) entry.getKey()));
                        stringBuilder.append("=");
                        str = (String) list.get(i2);
                    } else {
                        stringBuilder.append(Uri.encode((String) entry.getKey()));
                        stringBuilder.append("=");
                        str = Uri.encode((String) list.get(i2));
                    }
                    stringBuilder.append(str);
                }
                obj = obj2;
            }
        }
        return stringBuilder.toString();
    }

    private boolean e(String str) {
        for (String equals : this.d) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final String a(String str, String str2) {
        List list = (List) this.j.get(str);
        if (list == null) {
            list = new ArrayList(2);
            this.j.put(str, list);
        }
        Object obj = null;
        if (list.size() > 0) {
            obj = (String) list.set(0, str2);
        } else {
            list.add(str2);
        }
        if (!f.a(obj, (Object) str2)) {
            this.a = true;
        }
        return obj;
    }

    public final String[] a(String str) {
        List list = (List) this.j.remove(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        this.a = true;
        return (String[]) list.toArray(new String[0]);
    }

    public final void b(String str, String str2) {
        if (((List) this.j.get(str)) == null) {
            List arrayList = new ArrayList(2);
            this.j.put(str, arrayList);
            arrayList.add(str2);
        }
        this.a = true;
    }

    public c(int i, String str, Map map) {
        super(i, str, map);
        this.c.add("ybhpss");
    }

    public final void a() {
        if (this.a) {
            int i = 0;
            while (true) {
                int i2;
                String str = this.e;
                int indexOf = str.indexOf("?");
                StringBuilder stringBuilder = new StringBuilder();
                if (indexOf == -1) {
                    indexOf = str.indexOf("#");
                    if (indexOf != -1) {
                        stringBuilder.append(str.subSequence(0, indexOf));
                        str = a(i);
                        if (str != null) {
                            stringBuilder.append("?");
                            stringBuilder.append(str);
                        }
                        if (this.k != null) {
                            stringBuilder.append("#");
                            stringBuilder.append(this.k);
                        }
                        super.d(stringBuilder.toString());
                        if (this.e.length() <= 10240) {
                            break;
                        }
                        i2 = i + 1;
                        if (i == 1) {
                            break;
                        }
                        i = i2;
                    }
                } else {
                    str = str.substring(0, indexOf);
                }
                stringBuilder.append(str);
                str = a(i);
                if (str != null) {
                    stringBuilder.append("?");
                    stringBuilder.append(str);
                }
                if (this.k != null) {
                    stringBuilder.append("#");
                    stringBuilder.append(this.k);
                }
                super.d(stringBuilder.toString());
                if (this.e.length() <= 10240) {
                    i2 = i + 1;
                    if (i == 1) {
                        break;
                    }
                    i = i2;
                } else {
                    break;
                }
            }
            this.a = false;
        }
    }
}
