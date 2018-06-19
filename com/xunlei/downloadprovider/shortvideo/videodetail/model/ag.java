package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import org.json.JSONException;

/* compiled from: ShortMovieDetailDataLoader */
final class ag implements Runnable {
    final /* synthetic */ JSONException a;
    final /* synthetic */ ae b;

    ag(ae aeVar, JSONException jSONException) {
        this.b = aeVar;
        this.a = jSONException;
    }

    public final void run() {
        if (this.b.a.d.a != null) {
            this.b.a.d.a.a(2, this.a.getMessage());
        }
    }
}
