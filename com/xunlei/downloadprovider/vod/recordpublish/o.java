package com.xunlei.downloadprovider.vod.recordpublish;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.downloadprovider.vod.recordpublish.VodPlayerTopicSelectActivity.a;
import java.util.List;

/* compiled from: VodPlayerTopicSelectActivity */
final class o implements LoaderCallbacks<List<String>> {
    final /* synthetic */ VodPlayerTopicSelectActivity a;

    o(VodPlayerTopicSelectActivity vodPlayerTopicSelectActivity) {
        this.a = vodPlayerTopicSelectActivity;
    }

    public final /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        List list = (List) obj;
        if (TextUtils.isEmpty(this.a.d.getText().toString()) == null) {
            VodPlayerTopicSelectActivity.a(this.a, list);
        } else {
            this.a.f.removeAllViews();
        }
    }

    public final Loader onCreateLoader(int i, Bundle bundle) {
        this.a.e = new a(this.a, bundle.getString("topic"));
        return this.a.e;
    }

    public final void onLoaderReset(Loader loader) {
        this.a.f.removeAllViews();
    }
}
