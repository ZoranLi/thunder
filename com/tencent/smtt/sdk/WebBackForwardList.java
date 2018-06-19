package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList {
    private IX5WebBackForwardList a = null;
    private android.webkit.WebBackForwardList b = null;

    static WebBackForwardList a(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.b = webBackForwardList;
        return webBackForwardList2;
    }

    static WebBackForwardList a(IX5WebBackForwardList iX5WebBackForwardList) {
        if (iX5WebBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.a = iX5WebBackForwardList;
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        return this.a != null ? this.a.getCurrentIndex() : this.b.getCurrentIndex();
    }

    public WebHistoryItem getCurrentItem() {
        return this.a != null ? WebHistoryItem.a(this.a.getCurrentItem()) : WebHistoryItem.a(this.b.getCurrentItem());
    }

    public WebHistoryItem getItemAtIndex(int i) {
        return this.a != null ? WebHistoryItem.a(this.a.getItemAtIndex(i)) : WebHistoryItem.a(this.b.getItemAtIndex(i));
    }

    public int getSize() {
        return this.a != null ? this.a.getSize() : this.b.getSize();
    }
}
