package com.igexin.push.core.a;

import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.g;
import com.igexin.push.d.c.a;
import com.igexin.push.d.c.c;
import com.igexin.push.f.b.b;

public class e extends a {
    private void a(String str, a aVar) {
        if (str != null) {
            str = str.substring(3, str.length());
            if (str.contains("@")) {
                String[] split = str.split("\\@");
                String str2 = split[0];
                if (split[1].contains("|")) {
                    split = split[1].split("\\|");
                    String str3 = split[0];
                    str = split[1];
                    if (str2 != null && str3 != null && str != null) {
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setAppid(g.a);
                        pushTaskBean.setMessageId(str2);
                        pushTaskBean.setTaskId(str3);
                        pushTaskBean.setId(str2);
                        pushTaskBean.setAppKey(g.b);
                        pushTaskBean.setCurrentActionid(1);
                        f.a().a(pushTaskBean);
                        f.a().a(str, aVar, pushTaskBean);
                    }
                }
            }
        }
    }

    public boolean a(com.igexin.b.a.d.e eVar) {
        return super.a(eVar);
    }

    public boolean a(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.c != null) {
                String str = (String) aVar.c;
                StringBuilder stringBuilder = new StringBuilder("cdnpushmessage|");
                stringBuilder.append(str);
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                if (str.startsWith("RCV")) {
                    String substring = str.substring(3, str.length());
                    if (g.al.containsKey(substring)) {
                        c cVar = (c) g.al.get(substring);
                        g.al.remove(substring);
                        if (cVar != null) {
                            b e = cVar.e();
                            if (e != null) {
                                e.u();
                            }
                        }
                    }
                } else if (str.contains("CDN")) {
                    a(str, aVar);
                }
            }
        }
        return true;
    }
}
