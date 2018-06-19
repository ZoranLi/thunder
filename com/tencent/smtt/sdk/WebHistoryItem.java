package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem {
    private IX5WebHistoryItem a = null;
    private android.webkit.WebHistoryItem b = null;

    private WebHistoryItem() {
    }

    static WebHistoryItem a(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.b = webHistoryItem;
        return webHistoryItem2;
    }

    static WebHistoryItem a(IX5WebHistoryItem iX5WebHistoryItem) {
        if (iX5WebHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.a = iX5WebHistoryItem;
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        return this.a != null ? this.a.getFavicon() : this.b.getFavicon();
    }

    public String getOriginalUrl() {
        return this.a != null ? this.a.getOriginalUrl() : this.b.getOriginalUrl();
    }

    public String getTitle() {
        return this.a != null ? this.a.getTitle() : this.b.getTitle();
    }

    public String getUrl() {
        return this.a != null ? this.a.getUrl() : this.b.getUrl();
    }
}
