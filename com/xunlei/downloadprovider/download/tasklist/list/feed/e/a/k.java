package com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.umeng.message.util.HttpRequest;
import java.util.Map;

/* compiled from: TouTiaoRequest */
public abstract class k<T> extends Request<T> {
    protected b<T> a;
    protected Map<String, String> b;

    public String getBodyContentType() {
        return HttpRequest.CONTENT_TYPE_FORM;
    }

    public k(String str, Map<String, String> map, b<T> bVar, a aVar) {
        this(str, bVar, aVar);
        this.b = map;
    }

    private k(String str, b<T> bVar, a aVar) {
        super(1, str, aVar);
        this.a = null;
        this.b = null;
        this.a = bVar;
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return this.b;
    }

    protected void deliverResponse(T t) {
        if (this.a != null) {
            this.a.onResponse(t);
        }
    }
}
