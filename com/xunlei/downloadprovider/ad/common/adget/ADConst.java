package com.xunlei.downloadprovider.ad.common.adget;

import android.support.annotation.NonNull;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashSet;
import java.util.Set;

public final class ADConst {

    public enum THUNDER_AD_INFO {
        HOME_POS1(STYLES_INFO.HOME_VOD, "1269", STYLES_INFO.HOME_IMG, STYLES_INFO.HOME_VOD),
        HOME_POS_EXTRA(STYLES_INFO.HOME_VOD, "1268", STYLES_INFO.HOME_IMG, STYLES_INFO.HOME_VOD),
        HOME_RELOAD(STYLES_INFO.HOME_VOD, "1268", STYLES_INFO.HOME_IMG, STYLES_INFO.HOME_VOD),
        HOME_POS0(STYLES_INFO.HOME_VOD_0, "1240", STYLES_INFO.HOME_IMG_0.setBaiduID("5181510").setGDTID("6090824185283622"), STYLES_INFO.HOME_VOD_0.setBaiduID("5181510").setGDTID("6090824185283622")),
        FEED_AD(STYLES_INFO.FEED_IMG.setBaiduID("4382055").setGDTID("2080428378221684"), "1241", STYLES_INFO.FEED_IMG.setBaiduID("4382055").setGDTID("2080428378221684"), STYLES_INFO.FEED_VOD.setGDTID("2080428378221684")),
        SPLASH(STYLES_INFO.SPLASH_WRAP.setBaiduID("2865973").setGDTID("8020418483671194"), "1236", STYLES_INFO.SPLASH_FULL, STYLES_INFO.SPLASH_WRAP.setBaiduID("2865973").setGDTID("8020418483671194"), STYLES_INFO.SPLASH_VIDEO),
        TASK_DETAIL(STYLES_INFO.TASK_DETAIL_BANNER, "1239", STYLES_INFO.TASK_DETAIL_IMG, STYLES_INFO.TASK_DETAIL_BANNER, STYLES_INFO.TASK_DETAIL_THEME, STYLES_INFO.TASK_DETAIL_BRAND),
        TASK_DETAIL_NEW_IMAGE(STYLES_INFO.TASK_DETAIL_NEW_IMG, "1300", STYLES_INFO.TASK_DETAIL_NEW_IMG),
        TASK_DETAIL_NEW_BANNER(STYLES_INFO.TASK_DETAIL_NEW_BANNER, "1301", STYLES_INFO.TASK_DETAIL_NEW_BANNER),
        DOWNLOAD_LIST_TAB_1(STYLES_INFO.DOWNLOAD_LIST_1, "1175", STYLES_INFO.DOWNLOAD_LIST_1),
        DOWNLOAD_LIST_TAB_2(STYLES_INFO.DOWNLOAD_LIST_2, "1176", STYLES_INFO.DOWNLOAD_LIST_2),
        DOWNLOAD_LIST_TAB_3(STYLES_INFO.DOWNLOAD_LIST_3, "1177", STYLES_INFO.DOWNLOAD_LIST_3),
        DOWNLOAD_LIST_TAB_IMAGE_1(STYLES_INFO.DOWNLOAD_LIST_IMAGE_1, "1175", STYLES_INFO.DOWNLOAD_LIST_IMAGE_1),
        DOWNLOAD_LIST_TAB_IMAGE_2(STYLES_INFO.DOWNLOAD_LIST_IMAGE_2, "1176", STYLES_INFO.DOWNLOAD_LIST_IMAGE_2),
        DOWNLOAD_LIST_TAB_IMAGE_3(STYLES_INFO.DOWNLOAD_LIST_IMAGE_3, "1177", STYLES_INFO.DOWNLOAD_LIST_IMAGE_3),
        DOWNLOAD_LIST_TAB_HOME_IMAGE(STYLES_INFO.DOWNLOAD_LIST_HOME_IMAGE, "1264", STYLES_INFO.DOWNLOAD_LIST_HOME_IMAGE),
        DOWNLOAD_RECOMMEND_1_1(STYLES_INFO.DOWNLOAD_RECOMMEND_1_1, "1137", STYLES_INFO.DOWNLOAD_RECOMMEND_1_1),
        DOWNLOAD_RECOMMEND_1_2(STYLES_INFO.DOWNLOAD_RECOMMEND_1_2, "1138", STYLES_INFO.DOWNLOAD_RECOMMEND_1_2),
        DOWNLOAD_RECOMMEND_1_3(STYLES_INFO.DOWNLOAD_RECOMMEND_1_3, "1139", STYLES_INFO.DOWNLOAD_RECOMMEND_1_3),
        DOWNLOAD_RECOMMEND_2_1(STYLES_INFO.DOWNLOAD_RECOMMEND_2_1, "1140", STYLES_INFO.DOWNLOAD_RECOMMEND_2_1),
        DOWNLOAD_RECOMMEND_2_2(STYLES_INFO.DOWNLOAD_RECOMMEND_2_2, "1141", STYLES_INFO.DOWNLOAD_RECOMMEND_2_2),
        DOWNLOAD_RECOMMEND_2_3(STYLES_INFO.DOWNLOAD_RECOMMEND_2_3, "1142", STYLES_INFO.DOWNLOAD_RECOMMEND_2_3),
        DOWNLOAD_RECOMMEND_3_1(STYLES_INFO.DOWNLOAD_RECOMMEND_3_1, "1143", STYLES_INFO.DOWNLOAD_RECOMMEND_3_1),
        DOWNLOAD_RECOMMEND_3_2(STYLES_INFO.DOWNLOAD_RECOMMEND_3_2, "1144", STYLES_INFO.DOWNLOAD_RECOMMEND_3_2),
        DOWNLOAD_RECOMMEND_3_3(STYLES_INFO.DOWNLOAD_RECOMMEND_3_3, "1145", STYLES_INFO.DOWNLOAD_RECOMMEND_3_3),
        DOWNLOAD_RECOMMEND_IMAGE_1_1(STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_1_1, "1137", STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_1_1),
        DOWNLOAD_RECOMMEND_IMAGE_1_2(STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_1_2, "1138", STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_1_2),
        DOWNLOAD_RECOMMEND_IMAGE_1_3(STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_1_3, "1139", STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_1_3),
        DOWNLOAD_RECOMMEND_IMAGE_2_1(STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_1, "1140", STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_1),
        DOWNLOAD_RECOMMEND_IMAGE_2_2(STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_2, "1141", STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_2),
        DOWNLOAD_RECOMMEND_IMAGE_2_3(STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_3, "1142", STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_2_3),
        DOWNLOAD_RECOMMEND_IMAGE_3_1(STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_1, "1143", STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_1),
        DOWNLOAD_RECOMMEND_IMAGE_3_2(STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_2, "1144", STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_2),
        DOWNLOAD_RECOMMEND_IMAGE_3_3(STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_3, "1145", STYLES_INFO.DOWNLOAD_RECOMMEND_IMAGE_3_3),
        DOWNLOAD_RECOMMEND_HOME_IMAGE_1(STYLES_INFO.DOWNLOAD_RECOMMEND_HOME_1_IMAGE, "1265", STYLES_INFO.DOWNLOAD_RECOMMEND_HOME_1_IMAGE),
        DOWNLOAD_RECOMMEND_HOME_IMAGE_2(STYLES_INFO.DOWNLOAD_RECOMMEND_HOME_2_IMAGE, "1266", STYLES_INFO.DOWNLOAD_RECOMMEND_HOME_2_IMAGE),
        DOWNLOAD_RECOMMEND_HOME_IMAGE_3(STYLES_INFO.DOWNLOAD_RECOMMEND_HOME_3_IMAGE, "1267", STYLES_INFO.DOWNLOAD_RECOMMEND_HOME_3_IMAGE),
        SHORT_MOVIE_DETAIL_BRAND(STYLES_INFO.SHORT_MOVIE_DETAIL_BRAND, "", STYLES_INFO.SHORT_MOVIE_DETAIL_BRAND),
        SHORT_MOVIE_DETAIL_EFFECT(STYLES_INFO.SHORT_MOVIE_DETAIL_EFFECT, "1238", STYLES_INFO.SHORT_MOVIE_DETAIL_EFFECT),
        DOWNLOAD_CENTER_FEED(STYLES_INFO.DOWNLOAD_FEED_IMAGE, "1275", STYLES_INFO.DOWNLOAD_FEED_IMAGE);
        
        protected STYLES_INFO mDefStyle;
        public final String mPositionId;
        public Set<STYLES_INFO> mStyles;

        public enum STYLES_INFO {
            private static final /* synthetic */ STYLES_INFO[] $VALUES = null;
            public static final STYLES_INFO DOWNLOAD_FEED_IMAGE = null;
            public static final STYLES_INFO DOWNLOAD_LIST_1 = null;
            public static final STYLES_INFO DOWNLOAD_LIST_2 = null;
            public static final STYLES_INFO DOWNLOAD_LIST_3 = null;
            public static final STYLES_INFO DOWNLOAD_LIST_HOME_IMAGE = null;
            public static final STYLES_INFO DOWNLOAD_LIST_IMAGE_1 = null;
            public static final STYLES_INFO DOWNLOAD_LIST_IMAGE_2 = null;
            public static final STYLES_INFO DOWNLOAD_LIST_IMAGE_3 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_1_1 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_1_2 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_1_3 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_2_1 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_2_2 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_2_3 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_3_1 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_3_2 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_3_3 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_HOME_1_IMAGE = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_HOME_2_IMAGE = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_HOME_3_IMAGE = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_IMAGE_1_1 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_IMAGE_1_2 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_IMAGE_1_3 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_IMAGE_2_1 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_IMAGE_2_2 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_IMAGE_2_3 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_IMAGE_3_1 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_IMAGE_3_2 = null;
            public static final STYLES_INFO DOWNLOAD_RECOMMEND_IMAGE_3_3 = null;
            public static final STYLES_INFO FEED_IMG = null;
            public static final STYLES_INFO FEED_VOD = null;
            public static final STYLES_INFO HOME_IMG = null;
            public static final STYLES_INFO HOME_IMG_0 = null;
            public static final STYLES_INFO HOME_VOD = null;
            public static final STYLES_INFO HOME_VOD_0 = null;
            public static final STYLES_INFO SHORT_MOVIE_DETAIL_BRAND = null;
            public static final STYLES_INFO SHORT_MOVIE_DETAIL_EFFECT = null;
            public static final STYLES_INFO SPLASH_FULL = null;
            public static final STYLES_INFO SPLASH_VIDEO = null;
            public static final STYLES_INFO SPLASH_WRAP = null;
            public static final STYLES_INFO TASK_DETAIL_BANNER = null;
            public static final STYLES_INFO TASK_DETAIL_BRAND = null;
            public static final STYLES_INFO TASK_DETAIL_IMG = null;
            public static final STYLES_INFO TASK_DETAIL_NEW_BANNER = null;
            public static final STYLES_INFO TASK_DETAIL_NEW_IMG = null;
            public static final STYLES_INFO TASK_DETAIL_THEME = null;
            public String mBaiduID;
            public int mCacheSize;
            public String mGDTID;
            public int mLoadStrate;
            public int mRequiredSize;
            public final String mStyleId;

            public static STYLES_INFO valueOf(String str) {
                return (STYLES_INFO) Enum.valueOf(STYLES_INFO.class, str);
            }

            public static STYLES_INFO[] values() {
                return (STYLES_INFO[]) $VALUES.clone();
            }

            static {
                HOME_IMG = new STYLES_INFO("HOME_IMG", 0, "1", 5, "5180219", "4000116448931057", 1, 3);
                HOME_VOD = new STYLES_INFO("HOME_VOD", 1, "2", 4);
                HOME_IMG_0 = new STYLES_INFO("HOME_IMG_0", 2, "1", 5);
                HOME_VOD_0 = new STYLES_INFO("HOME_VOD_0", 3, "2", 5);
                FEED_IMG = new STYLES_INFO("FEED_IMG", 4, "1", 5, 1, 3);
                FEED_VOD = new STYLES_INFO("FEED_VOD", 5, "2", 4, 1, 3);
                SPLASH_FULL = new STYLES_INFO("SPLASH_FULL", 6, "1", 3);
                SPLASH_WRAP = new STYLES_INFO("SPLASH_WRAP", 7, "2", 3);
                SPLASH_VIDEO = new STYLES_INFO("SPLASH_VIDEO", 8, "4", 0);
                TASK_DETAIL_IMG = new STYLES_INFO("TASK_DETAIL_IMG", 9, "1", 3, "3128307", "5000014347729495", 1, 3);
                TASK_DETAIL_BANNER = new STYLES_INFO("TASK_DETAIL_BANNER", 10, "2", 3, "3958204", "2050027186816092", 1, 3);
                TASK_DETAIL_THEME = new STYLES_INFO("TASK_DETAIL_THEME", 11, "3", 0);
                TASK_DETAIL_BRAND = new STYLES_INFO("TASK_DETAIL_BRAND", 12, "4", 0);
                TASK_DETAIL_NEW_IMG = new STYLES_INFO("TASK_DETAIL_NEW_IMG", 13, "1", 3, "5582702", "1090632244505066", 1, 3);
                TASK_DETAIL_NEW_BANNER = new STYLES_INFO("TASK_DETAIL_NEW_BANNER", 14, "1", 3, "5817278", "5080134324470200", 1, 3);
                DOWNLOAD_RECOMMEND_1_1 = new STYLES_INFO("DOWNLOAD_RECOMMEND_1_1", 15, "1", 3, "3546306", "4020211971019515");
                DOWNLOAD_RECOMMEND_1_2 = new STYLES_INFO("DOWNLOAD_RECOMMEND_1_2", 16, "1", 3, "3546319", "7080627102201823");
                DOWNLOAD_RECOMMEND_1_3 = new STYLES_INFO("DOWNLOAD_RECOMMEND_1_3", 17, "1", 3, "3546343", "4080729112006814");
                DOWNLOAD_RECOMMEND_2_1 = new STYLES_INFO("DOWNLOAD_RECOMMEND_2_1", 18, "1", 3, "3546352", "8060123122901845");
                DOWNLOAD_RECOMMEND_2_2 = new STYLES_INFO("DOWNLOAD_RECOMMEND_2_2", 19, "1", 3, "3546414", "1090128162103857");
                DOWNLOAD_RECOMMEND_2_3 = new STYLES_INFO("DOWNLOAD_RECOMMEND_2_3", 20, "1", 3, "3546420", "6050526122305828");
                DOWNLOAD_RECOMMEND_3_1 = new STYLES_INFO("DOWNLOAD_RECOMMEND_3_1", 21, "1", 3, "3546424", "1020725162306849");
                DOWNLOAD_RECOMMEND_3_2 = new STYLES_INFO("DOWNLOAD_RECOMMEND_3_2", 22, "1", 3, "3546430", "4050025142001973");
                DOWNLOAD_RECOMMEND_3_3 = new STYLES_INFO("DOWNLOAD_RECOMMEND_3_3", 23, "1", 3, "3546439", "5080629152106944");
                DOWNLOAD_RECOMMEND_IMAGE_1_1 = new STYLES_INFO("DOWNLOAD_RECOMMEND_IMAGE_1_1", 24, "1", 3, "3546306", "4020211971019515");
                DOWNLOAD_RECOMMEND_IMAGE_1_2 = new STYLES_INFO("DOWNLOAD_RECOMMEND_IMAGE_1_2", 25, "1", 3, "3546319", "7080627102201823");
                DOWNLOAD_RECOMMEND_IMAGE_1_3 = new STYLES_INFO("DOWNLOAD_RECOMMEND_IMAGE_1_3", 26, "1", 3, "3546343", "4080729112006814");
                DOWNLOAD_RECOMMEND_IMAGE_2_1 = new STYLES_INFO("DOWNLOAD_RECOMMEND_IMAGE_2_1", 27, "1", 3, "3546352", "8060123122901845");
                DOWNLOAD_RECOMMEND_IMAGE_2_2 = new STYLES_INFO("DOWNLOAD_RECOMMEND_IMAGE_2_2", 28, "1", 3, "3546414", "1090128162103857");
                DOWNLOAD_RECOMMEND_IMAGE_2_3 = new STYLES_INFO("DOWNLOAD_RECOMMEND_IMAGE_2_3", 29, "1", 3, "3546420", "6050526122305828");
                DOWNLOAD_RECOMMEND_IMAGE_3_1 = new STYLES_INFO("DOWNLOAD_RECOMMEND_IMAGE_3_1", 30, "1", 3, "3546424", "1020725162306849");
                DOWNLOAD_RECOMMEND_IMAGE_3_2 = new STYLES_INFO("DOWNLOAD_RECOMMEND_IMAGE_3_2", 31, "1", 3, "3546430", "4050025142001973");
                DOWNLOAD_RECOMMEND_IMAGE_3_3 = new STYLES_INFO("DOWNLOAD_RECOMMEND_IMAGE_3_3", 32, "1", 3, "3546439", "5080629152106944");
                DOWNLOAD_RECOMMEND_HOME_1_IMAGE = new STYLES_INFO("DOWNLOAD_RECOMMEND_HOME_1_IMAGE", 33, "1", 3, "4736487", "4070728304526927");
                DOWNLOAD_RECOMMEND_HOME_2_IMAGE = new STYLES_INFO("DOWNLOAD_RECOMMEND_HOME_2_IMAGE", 34, "1", 3, "4736488", "2040420374780925");
                DOWNLOAD_RECOMMEND_HOME_3_IMAGE = new STYLES_INFO("DOWNLOAD_RECOMMEND_HOME_3_IMAGE", 35, "1", 3, "4736489", "5090220354120909");
                DOWNLOAD_LIST_1 = new STYLES_INFO("DOWNLOAD_LIST_1", 36, "1", 3, "2749821", "5020511018089707");
                DOWNLOAD_LIST_2 = new STYLES_INFO("DOWNLOAD_LIST_2", 37, "1", 3, "2749822", "1050912110223719");
                DOWNLOAD_LIST_3 = new STYLES_INFO("DOWNLOAD_LIST_3", 38, "1", 3, "2749824", "7030911110927870");
                DOWNLOAD_LIST_IMAGE_1 = new STYLES_INFO("DOWNLOAD_LIST_IMAGE_1", 39, "1", 3, "2749821", "5020511018089707");
                DOWNLOAD_LIST_IMAGE_2 = new STYLES_INFO("DOWNLOAD_LIST_IMAGE_2", 40, "1", 3, "2749822", "1050912110223719");
                DOWNLOAD_LIST_IMAGE_3 = new STYLES_INFO("DOWNLOAD_LIST_IMAGE_3", 41, "1", 3, "2749824", "7030911110927870");
                DOWNLOAD_FEED_IMAGE = new STYLES_INFO("DOWNLOAD_FEED_IMAGE", 42, "1", 4, "2000523681252451", 1, 3);
                DOWNLOAD_LIST_HOME_IMAGE = new STYLES_INFO("DOWNLOAD_LIST_HOME_IMAGE", 43, "1", 3, "4736490", "1040725304539020");
                SHORT_MOVIE_DETAIL_BRAND = new STYLES_INFO("SHORT_MOVIE_DETAIL_BRAND", 44, "1", 0);
                SHORT_MOVIE_DETAIL_EFFECT = new STYLES_INFO("SHORT_MOVIE_DETAIL_EFFECT", 45, "1", 3, "4354760", "1020722192428208", 1, 3);
                $VALUES = new STYLES_INFO[]{HOME_IMG, HOME_VOD, HOME_IMG_0, HOME_VOD_0, FEED_IMG, FEED_VOD, SPLASH_FULL, SPLASH_WRAP, SPLASH_VIDEO, TASK_DETAIL_IMG, TASK_DETAIL_BANNER, TASK_DETAIL_THEME, TASK_DETAIL_BRAND, TASK_DETAIL_NEW_IMG, TASK_DETAIL_NEW_BANNER, DOWNLOAD_RECOMMEND_1_1, DOWNLOAD_RECOMMEND_1_2, DOWNLOAD_RECOMMEND_1_3, DOWNLOAD_RECOMMEND_2_1, DOWNLOAD_RECOMMEND_2_2, DOWNLOAD_RECOMMEND_2_3, DOWNLOAD_RECOMMEND_3_1, DOWNLOAD_RECOMMEND_3_2, DOWNLOAD_RECOMMEND_3_3, DOWNLOAD_RECOMMEND_IMAGE_1_1, DOWNLOAD_RECOMMEND_IMAGE_1_2, DOWNLOAD_RECOMMEND_IMAGE_1_3, DOWNLOAD_RECOMMEND_IMAGE_2_1, DOWNLOAD_RECOMMEND_IMAGE_2_2, DOWNLOAD_RECOMMEND_IMAGE_2_3, DOWNLOAD_RECOMMEND_IMAGE_3_1, DOWNLOAD_RECOMMEND_IMAGE_3_2, DOWNLOAD_RECOMMEND_IMAGE_3_3, DOWNLOAD_RECOMMEND_HOME_1_IMAGE, DOWNLOAD_RECOMMEND_HOME_2_IMAGE, DOWNLOAD_RECOMMEND_HOME_3_IMAGE, DOWNLOAD_LIST_1, DOWNLOAD_LIST_2, DOWNLOAD_LIST_3, DOWNLOAD_LIST_IMAGE_1, DOWNLOAD_LIST_IMAGE_2, DOWNLOAD_LIST_IMAGE_3, DOWNLOAD_FEED_IMAGE, DOWNLOAD_LIST_HOME_IMAGE, SHORT_MOVIE_DETAIL_BRAND, SHORT_MOVIE_DETAIL_EFFECT};
            }

            public final STYLES_INFO setBaiduID(String str) {
                this.mBaiduID = str;
                return this;
            }

            public final STYLES_INFO setGDTID(String str) {
                this.mGDTID = str;
                return this;
            }

            private STYLES_INFO(String str, int i, String str2, int i2) {
                this(str, i, str2, i2, "", "");
            }

            private STYLES_INFO(String str, int i, String str2, int i2, int i3, int i4) {
                this(str, i, str2, i2, "", "", i3, i4);
            }

            private STYLES_INFO(String str, int i, String str2, int i2, String str3, String str4) {
                this(str, i, str2, i2, str3, str4, 1, 0);
            }

            private STYLES_INFO(String str, int i, String str2, int i2, String str3, String str4, int i3, int i4) {
                this.mRequiredSize = 1;
                this.mLoadStrate = i2;
                this.mStyleId = str2;
                this.mBaiduID = str3;
                this.mGDTID = str4;
                this.mRequiredSize = i3;
                this.mCacheSize = i4;
            }

            private STYLES_INFO(String str, int i, String str2, int i2, String str3, int i3, int i4) {
                this(str, i, str2, i2, ADConst.b(i2) ? str3 : "", ADConst.d(i2) ? str3 : "", i3, i4);
                if (ADConst.b(i2) && ADConst.d(i2)) {
                    throw new IllegalArgumentException("构建广告STYLES_INFO错误，此构造方法只支持拉取一种第三方广告源");
                }
            }
        }

        public final String getPositionId() {
            return this.mPositionId;
        }

        public final STYLES_INFO getStyleInfo(String str) {
            for (STYLES_INFO styles_info : this.mStyles) {
                if (styles_info.mStyleId.equals(str)) {
                    break;
                }
            }
            STYLES_INFO styles_info2 = null;
            return styles_info2 == null ? this.mDefStyle : styles_info2;
        }

        public final STYLES_INFO getDefStyle() {
            return this.mDefStyle;
        }

        public final boolean containStyleInfo(String str) {
            for (STYLES_INFO styles_info : this.mStyles) {
                if (styles_info.mStyleId.equals(str)) {
                    break;
                }
            }
            STYLES_INFO styles_info2 = null;
            return styles_info2 == null ? null : true;
        }

        public static THUNDER_AD_INFO getThunderADInfo(STYLES_INFO styles_info) {
            for (THUNDER_AD_INFO thunder_ad_info : values()) {
                for (STYLES_INFO styles_info2 : thunder_ad_info.mStyles) {
                    if (styles_info2 == styles_info) {
                        return thunder_ad_info;
                    }
                }
            }
            return null;
        }

        public static String getPositionId(STYLES_INFO styles_info) {
            styles_info = getThunderADInfo(styles_info);
            return styles_info != null ? styles_info.getPositionId() : null;
        }

        private THUNDER_AD_INFO(STYLES_INFO styles_info, String str, STYLES_INFO... styles_infoArr) {
            this.mStyles = new HashSet();
            this.mDefStyle = styles_info;
            this.mPositionId = str;
            for (STYLES_INFO styles_info2 : styles_infoArr) {
                this.mStyles.add(styles_info2);
            }
        }
    }

    public static boolean a(int i) {
        return (i & 2) != 0;
    }

    public static boolean b(int i) {
        return (i & 1) != 0;
    }

    public static boolean c(int i) {
        return (i & 4) != 0;
    }

    public static boolean d(int i) {
        return (i & 6) != 0;
    }

    @NonNull
    public static String a(byte b) {
        if (d(b)) {
            return SocializeProtocolConstants.PROTOCOL_KEY_TENCENT;
        }
        return b(b) != (byte) 0 ? "baidu" : "";
    }
}
