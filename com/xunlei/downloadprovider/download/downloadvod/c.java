package com.xunlei.downloadprovider.download.downloadvod;

/* compiled from: DownloadVodImpl */
final class c implements Runnable {
    final /* synthetic */ a$b a;

    c(a$b com_xunlei_downloadprovider_download_downloadvod_a_b) {
        this.a = com_xunlei_downloadprovider_download_downloadvod_a_b;
    }

    public final void run() {
        a$a com_xunlei_downloadprovider_download_downloadvod_a_a = this.a;
        com_xunlei_downloadprovider_download_downloadvod_a_a.l.a(com_xunlei_downloadprovider_download_downloadvod_a_a.b, false);
        if (!(com_xunlei_downloadprovider_download_downloadvod_a_a.k == null || com_xunlei_downloadprovider_download_downloadvod_a_a.a)) {
            StringBuilder stringBuilder = new StringBuilder("on response url = ");
            stringBuilder.append(com_xunlei_downloadprovider_download_downloadvod_a_a.c);
            stringBuilder.append(" ");
            stringBuilder.append(com_xunlei_downloadprovider_download_downloadvod_a_a.j);
            com_xunlei_downloadprovider_download_downloadvod_a_a.k.a(com_xunlei_downloadprovider_download_downloadvod_a_a.i, com_xunlei_downloadprovider_download_downloadvod_a_a.j);
        }
        com_xunlei_downloadprovider_download_downloadvod_a_a.k = null;
    }
}
