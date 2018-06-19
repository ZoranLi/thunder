package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import org.json.JSONException;

/* compiled from: ShortMovieDetailDataLoader */
final class j implements Runnable {
    final /* synthetic */ JSONException a;
    final /* synthetic */ i b;

    j(i iVar, JSONException jSONException) {
        this.b = iVar;
        this.a = jSONException;
    }

    public final void run() {
        if (this.b.a.c.a != null) {
            this.b.a.c.a.a(1, this.a.getMessage());
        }
    }
}
