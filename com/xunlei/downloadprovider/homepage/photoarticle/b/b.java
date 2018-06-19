package com.xunlei.downloadprovider.homepage.photoarticle.b;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.aq;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;

/* compiled from: ArticleWebViewHolder */
public final class b extends aq {
    public WebView a;
    public String b;
    public a c;
    private WebViewClient d = new c(this);

    /* compiled from: ArticleWebViewHolder */
    public interface a {
        void a();

        void a(int i);
    }

    public b(View view) {
        super(view);
        this.a = (WebView) view.findViewById(R.id.article_webview);
        this.a.setWebViewClient(this.d);
        view = this.a.getSettings();
        view.setCacheMode(-1);
        view.setDomStorageEnabled(true);
        view.setBuiltInZoomControls(false);
        view.setJavaScriptEnabled(true);
    }

    public final void a(aw awVar) {
        String str = (String) awVar.b;
        if (!(TextUtils.isEmpty(str) || str.equals(this.b))) {
            this.a.loadUrl(str);
            this.b = str;
        }
    }
}
