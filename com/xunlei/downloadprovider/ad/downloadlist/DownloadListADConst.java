package com.xunlei.downloadprovider.ad.downloadlist;

import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.ad.a.h;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;

public final class DownloadListADConst {

    public enum DownloadListSSPAdMapping {
        ALL_ICON(THUNDER_AD_INFO.DOWNLOAD_LIST_TAB_1, 0),
        RUNNING_ICON(THUNDER_AD_INFO.DOWNLOAD_LIST_TAB_2, 1),
        DONE_ICON(THUNDER_AD_INFO.DOWNLOAD_LIST_TAB_3, 2),
        ALL_IMAGE(THUNDER_AD_INFO.DOWNLOAD_LIST_TAB_IMAGE_1, 0, 2),
        RUNNING_IMAGE(THUNDER_AD_INFO.DOWNLOAD_LIST_TAB_IMAGE_2, 1, 2),
        DONE_IMAGE(THUNDER_AD_INFO.DOWNLOAD_LIST_TAB_IMAGE_3, 2, 2),
        HOME_IMAGE(THUNDER_AD_INFO.DOWNLOAD_LIST_TAB_HOME_IMAGE, 0, 3),
        FIX_RUNNING_HOME_IMAGE(THUNDER_AD_INFO.DOWNLOAD_LIST_TAB_IMAGE_2, 1, 3),
        FIX_DONE_HOME_IMAGE(THUNDER_AD_INFO.DOWNLOAD_LIST_TAB_IMAGE_3, 2, 3);
        
        public int adStyle;
        public int pageIndex;
        public THUNDER_AD_INFO thunderAdInfo;

        private DownloadListSSPAdMapping(THUNDER_AD_INFO thunder_ad_info, int i) {
            this(r7, r8, thunder_ad_info, i, 1);
        }

        private DownloadListSSPAdMapping(THUNDER_AD_INFO thunder_ad_info, int i, int i2) {
            this.thunderAdInfo = thunder_ad_info;
            this.pageIndex = i;
            this.adStyle = i2;
        }

        @Nullable
        public static THUNDER_AD_INFO getThunderAdInfo(int i) {
            i = fromPageIndex(i);
            return i != 0 ? i.thunderAdInfo : 0;
        }

        @Nullable
        public static DownloadListSSPAdMapping fromPageIndex(int i) {
            int b = h.b();
            int i2 = 3;
            if (b != 1 && b != 3) {
                i2 = 1;
            } else if (!h.a()) {
                i2 = 2;
            }
            for (DownloadListSSPAdMapping downloadListSSPAdMapping : values()) {
                if (downloadListSSPAdMapping.pageIndex == i && downloadListSSPAdMapping.adStyle == r1) {
                    return downloadListSSPAdMapping;
                }
            }
            return 0;
        }
    }
}
