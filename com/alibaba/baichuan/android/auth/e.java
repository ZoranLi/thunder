package com.alibaba.baichuan.android.auth;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.AlibcContext.Environment;
import com.alibaba.baichuan.android.trade.utils.b;
import com.alibaba.baichuan.android.trade.utils.g.a;
import com.alibaba.baichuan.android.trade.utils.http.HttpHelper;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class e extends AsyncTask {
    final /* synthetic */ String a;
    final /* synthetic */ g b;
    final /* synthetic */ boolean c = false;
    final /* synthetic */ boolean d = false;

    e(String str, g gVar) {
        this.a = str;
        this.b = gVar;
    }

    private String a() {
        String str;
        Object[] objArr;
        Exception e;
        if (AlibcContext.g == Environment.TEST) {
            str = "http://100.69.205.47/authHint.htm?apiList=[\"%s\"]";
            objArr = new Object[]{this.a.replace("$", "_")};
        } else if (AlibcContext.g == Environment.PRE) {
            str = "http://pre.nbsdk-baichuan.taobao.com/authHint.htm?apiList=[\"%s\"]";
            objArr = new Object[]{this.a.replace("$", "_")};
        } else {
            str = "https://nbsdk-baichuan.alicdn.com/authHint.htm?apiList=[\"%s\"]";
            objArr = new Object[]{this.a.replace("$", "_")};
        }
        str = String.format(str, objArr);
        String str2 = "";
        String a;
        try {
            a.b();
            a = HttpHelper.a(str);
            try {
                StringBuilder stringBuilder = new StringBuilder("getHint : url  ");
                stringBuilder.append(str);
                stringBuilder.append(" ");
                stringBuilder.append(a);
                a.b();
                return a;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return a;
            }
        } catch (Exception e3) {
            e = e3;
            a = str2;
            e.printStackTrace();
            return a;
        }
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        try {
            if (TextUtils.isEmpty(str)) {
                this.b.a(a.HINTLIST_NULL.b, a.HINTLIST_NULL.c);
                return;
            }
            obj = com.alibaba.fastjson.a.parseObject(str);
            Set set = null;
            if (b.a(obj.get("success"))) {
                obj = b.d(obj.get("authHintMap"));
                if (obj != null && obj.size() > 0) {
                    set = new HashSet(obj.size());
                    for (String str2 : obj.keySet()) {
                        Map e = b.e(obj.get(str2));
                        if (e != null) {
                            d.a((String) e.get("hintId"), (String) e.get("hintName"));
                            set.add(e.get("hintId"));
                        }
                    }
                    d.a(this.a, set);
                }
            }
            if (set != null) {
                if (set.size() > null) {
                    if (this.c != null) {
                        c.a(set, this.b, this.d);
                        return;
                    } else {
                        this.b.a();
                        return;
                    }
                }
            }
            this.b.a(a.HINTLIST_NULL.b, a.HINTLIST_NULL.c);
        } catch (Object obj2) {
            this.b.a(a.HINTLIST_NULL.b, a.HINTLIST_NULL.c);
            obj2.printStackTrace();
        }
    }
}
