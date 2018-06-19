package com.xunlei.downloadprovider.ad.recommend;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.a.h;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class RecommendADConst {

    public enum RecommendSSPAdMapping {
        ALL_FIRST(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_1_1, 0, 0),
        ALL_SECOND(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_1_2, 0, 1),
        ALL_THIRD(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_1_3, 0, 2),
        RUNNING_FIRST(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_2_1, 1, 0),
        RUNNING_SECOND(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_2_2, 1, 1),
        RUNNING_THIRD(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_2_3, 1, 2),
        DONE_FIRST(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_3_1, 2, 0),
        DONE_SECOND(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_3_2, 2, 1),
        DONE_THIRD(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_3_3, 2, 2),
        ALL_IMAGE_FIRST(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_1_1, 0, 0, 2),
        ALL_IMAGE_SECOND(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_1_2, 0, 1, 2),
        ALL_IMAGE_THIRD(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_1_3, 0, 2, 2),
        RUNNING_IMAGE_FIRST(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_1, 1, 0, 2),
        RUNNING_IMAGE_SECOND(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_2, 1, 1, 2),
        RUNNING_IMAGE_THIRD(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_3, 1, 2, 2),
        DONE_IMAGE_FIRST(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_1, 2, 0, 2),
        DONE_IMAGE_SECOND(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_2, 2, 1, 2),
        DONE_IMAGE_THIRD(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_3, 2, 2, 2),
        HOME_IMAGE_FIRST(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_HOME_IMAGE_1, 0, 0, 3),
        HOME_IMAGE_SECOND(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_HOME_IMAGE_2, 0, 1, 3),
        HOME_IMAGE_THIRD(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_HOME_IMAGE_3, 0, 2, 3),
        FIX_RUNNING_HOME_IMAGE_FIRST(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_1, 1, 0, 3),
        FIX_RUNNING_HOME_IMAGE_SECOND(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_2, 1, 1, 3),
        FIX_RUNNING_HOME_IMAGE_THIRD(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_3, 1, 2, 3),
        FIX_DONE_HOME_IMAGE_FIRST(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_1, 2, 0, 3),
        FIX_DONE_HOME_IMAGE_SECOND(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_2, 2, 1, 3),
        FIX_DONE_HOME_IMAGE_THIRD(THUNDER_AD_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_3, 2, 2, 3);
        
        public int adStyle;
        public int pageIndex;
        public int position;
        public THUNDER_AD_INFO thunderAdInfo;

        private RecommendSSPAdMapping(THUNDER_AD_INFO thunder_ad_info, int i, int i2) {
            this(r8, r9, thunder_ad_info, i, i2, 1);
        }

        private RecommendSSPAdMapping(THUNDER_AD_INFO thunder_ad_info, int i, int i2, int i3) {
            this.thunderAdInfo = thunder_ad_info;
            this.pageIndex = i;
            this.position = i2;
            this.adStyle = i3;
        }

        @Nullable
        public static RecommendSSPAdMapping fromPositionId(String str) {
            int a = RecommendADConst.a();
            RecommendSSPAdMapping recommendSSPAdMapping = null;
            for (RecommendSSPAdMapping recommendSSPAdMapping2 : values()) {
                if (recommendSSPAdMapping2.thunderAdInfo.getPositionId().equals(str) && a == recommendSSPAdMapping2.adStyle) {
                    recommendSSPAdMapping = recommendSSPAdMapping2;
                }
            }
            new StringBuilder("fromPositionId. mapping: ").append(recommendSSPAdMapping == null ? "null" : recommendSSPAdMapping.name());
            return recommendSSPAdMapping;
        }

        @NonNull
        public static List<String> getPositionIds(int i) {
            List<String> arrayList = new ArrayList(3);
            int a = RecommendADConst.a();
            for (RecommendSSPAdMapping recommendSSPAdMapping : values()) {
                if (recommendSSPAdMapping.pageIndex == i && recommendSSPAdMapping.adStyle == a) {
                    arrayList.add(recommendSSPAdMapping.thunderAdInfo.getPositionId());
                }
            }
            new StringBuilder("getPositionIds: ").append(Arrays.toString(arrayList.toArray()));
            return arrayList;
        }

        @NonNull
        public static List<THUNDER_AD_INFO> getThunderAdInfos(int i) {
            List<THUNDER_AD_INFO> arrayList = new ArrayList(3);
            int a = RecommendADConst.a();
            for (RecommendSSPAdMapping recommendSSPAdMapping : values()) {
                if (recommendSSPAdMapping.pageIndex == i && recommendSSPAdMapping.adStyle == a) {
                    arrayList.add(recommendSSPAdMapping.thunderAdInfo);
                }
            }
            new StringBuilder("getPositionIds: ").append(Arrays.toString(arrayList.toArray()));
            return arrayList;
        }

        public static int getPositionCount(int i) {
            int a = RecommendADConst.a();
            RecommendSSPAdMapping[] values = values();
            int i2 = 0;
            int length = values.length;
            int i3 = 0;
            while (i2 < length) {
                RecommendSSPAdMapping recommendSSPAdMapping = values[i2];
                if (recommendSSPAdMapping.pageIndex == i && recommendSSPAdMapping.adStyle == a) {
                    i3++;
                }
                i2++;
            }
            return i3;
        }
    }

    public static int a() {
        int b = h.b();
        if (b != 1 && b != 3) {
            return 1;
        }
        if (h.a()) {
            return 3;
        }
        return 2;
    }

    public static int a(l lVar) {
        int i = 0;
        if (TextUtils.isEmpty(lVar.y())) {
            return 0;
        }
        lVar = lVar.y().toLowerCase();
        int hashCode = lVar.hashCode();
        int i2 = 2;
        if (hashCode != -1427573947) {
            if (hashCode != 96437) {
                if (hashCode != 114192) {
                    if (hashCode == 93498907) {
                        if (lVar.equals("baidu") != null) {
                            i = 3;
                            switch (i) {
                                case 0:
                                    i2 = 5;
                                    break;
                                case 1:
                                    i2 = 4;
                                    break;
                                case 2:
                                    i2 = 3;
                                    break;
                                case 3:
                                    break;
                                default:
                                    i2 = 6;
                                    break;
                            }
                            return i2;
                        }
                    }
                } else if (lVar.equals("ssp") != null) {
                    i = 1;
                    switch (i) {
                        case 0:
                            i2 = 5;
                            break;
                        case 1:
                            i2 = 4;
                            break;
                        case 2:
                            i2 = 3;
                            break;
                        case 3:
                            break;
                        default:
                            i2 = 6;
                            break;
                    }
                    return i2;
                }
            } else if (lVar.equals("adx") != null) {
                switch (i) {
                    case 0:
                        i2 = 5;
                        break;
                    case 1:
                        i2 = 4;
                        break;
                    case 2:
                        i2 = 3;
                        break;
                    case 3:
                        break;
                    default:
                        i2 = 6;
                        break;
                }
                return i2;
            }
        } else if (lVar.equals(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT) != null) {
            i = 2;
            switch (i) {
                case 0:
                    i2 = 5;
                    break;
                case 1:
                    i2 = 4;
                    break;
                case 2:
                    i2 = 3;
                    break;
                case 3:
                    break;
                default:
                    i2 = 6;
                    break;
            }
            return i2;
        }
        i = -1;
        switch (i) {
            case 0:
                i2 = 5;
                break;
            case 1:
                i2 = 4;
                break;
            case 2:
                i2 = 3;
                break;
            case 3:
                break;
            default:
                i2 = 6;
                break;
        }
        return i2;
    }
}
