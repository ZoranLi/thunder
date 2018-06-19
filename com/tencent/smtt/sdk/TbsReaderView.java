package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.Apn;

public class TbsReaderView extends FrameLayout {
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final String TAG = "TbsReaderView";
    static boolean f = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";
    Context a = null;
    k b = null;
    Object c = null;
    ReaderCallback d = null;
    ReaderCallback e = null;

    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_OPEN_QQ_FILE_LIST = 5031;
        public static final int READER_PDF_LIST = 5008;
        public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
        public static final int READER_PLUGIN_CANLOAD = 5013;
        public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
        public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
        public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
        public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
        public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
        public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
        public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
        public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
        public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
        public static final int READER_PLUGIN_SO_ERR = 5025;
        public static final int READER_PLUGIN_SO_INTO_START = 5027;
        public static final int READER_PLUGIN_SO_PROGRESS = 5028;
        public static final int READER_PLUGIN_SO_VERSION = 5030;
        public static final int READER_PLUGIN_STATUS = 5012;
        public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
        public static final int READER_PPT_PLAY_MODEL = 5009;
        public static final int READER_SEARCH_IN_DOCUMENT = 5026;
        public static final int READER_TOAST = 5005;
        public static final int READER_TXT_READING_MODEL = 5010;
        public static final int SEARCH_SELECT_TEXT = 5004;
        public static final int SHOW_BAR = 5002;
        public static final int SHOW_DIALOG = 5006;

        void onCallBackAction(Integer num, Object obj, Object obj2);
    }

    public TbsReaderView(Context context, ReaderCallback readerCallback) {
        super(context.getApplicationContext());
        if (context instanceof Activity) {
            this.d = readerCallback;
            this.a = context;
            this.e = new av(this);
            return;
        }
        throw new RuntimeException("error: unexpect context(none Activity)");
    }

    static boolean a(Context context) {
        if (!f) {
            l.a(true).a(context.getApplicationContext(), true, false);
            f = l.a(false).b();
        }
        return f;
    }

    public static Drawable getResDrawable(Context context, int i) {
        return a(context) ? k.a(i) : null;
    }

    public static String getResString(Context context, int i) {
        return a(context) ? k.b(i) : "";
    }

    public static boolean isSupportExt(Context context, String str) {
        return a(context) && k.a(context) && k.a(str);
    }

    boolean a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.b;	 Catch:{ NullPointerException -> 0x0029 }
        if (r1 != 0) goto L_0x000e;	 Catch:{ NullPointerException -> 0x0029 }
    L_0x0005:
        r1 = new com.tencent.smtt.sdk.k;	 Catch:{ NullPointerException -> 0x0029 }
        r2 = r4.e;	 Catch:{ NullPointerException -> 0x0029 }
        r1.<init>(r2);	 Catch:{ NullPointerException -> 0x0029 }
        r4.b = r1;	 Catch:{ NullPointerException -> 0x0029 }
    L_0x000e:
        r1 = r4.c;	 Catch:{ NullPointerException -> 0x0029 }
        if (r1 != 0) goto L_0x001a;	 Catch:{ NullPointerException -> 0x0029 }
    L_0x0012:
        r1 = r4.b;	 Catch:{ NullPointerException -> 0x0029 }
        r1 = r1.a();	 Catch:{ NullPointerException -> 0x0029 }
        r4.c = r1;	 Catch:{ NullPointerException -> 0x0029 }
    L_0x001a:
        r1 = r4.c;	 Catch:{ NullPointerException -> 0x0029 }
        if (r1 == 0) goto L_0x0029;	 Catch:{ NullPointerException -> 0x0029 }
    L_0x001e:
        r1 = r4.b;	 Catch:{ NullPointerException -> 0x0029 }
        r2 = r4.c;	 Catch:{ NullPointerException -> 0x0029 }
        r3 = r4.a;	 Catch:{ NullPointerException -> 0x0029 }
        r1 = r1.a(r2, r3);	 Catch:{ NullPointerException -> 0x0029 }
        r0 = r1;
    L_0x0029:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsReaderView.a():boolean");
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        if (this.b != null && this.c != null) {
            this.b.a(this.c, num, obj, obj2);
        }
    }

    public boolean downloadPlugin(String str) {
        return this.c == null ? false : this.b.a(this.c, this.a, str, true);
    }

    public void onSizeChanged(int i, int i2) {
        if (this.b != null && this.c != null) {
            this.b.a(this.c, i, i2);
        }
    }

    public void onStop() {
        if (this.b != null) {
            this.b.a(this.c);
            this.c = null;
        }
        this.a = null;
        f = false;
    }

    public void openFile(Bundle bundle) {
        if (this.c != null && bundle != null) {
            bundle.putBoolean("browser6.0", d.c(this.a) | (d.b(this.a) ^ 1));
            bundle.putBoolean("browser6.1", d.a(this.a, 6101625, 610000) | (d.b(this.a) ^ 1));
            this.b.a(this.c, this.a, bundle, (FrameLayout) this);
        }
    }

    public boolean preOpen(String str, boolean z) {
        boolean z2 = false;
        if (!isSupportExt(this.a, str)) {
            return false;
        }
        boolean a = a(this.a);
        if (a) {
            a = a();
            if (z && a) {
                if (Apn.getApnType(this.a) == 3) {
                    z2 = true;
                }
                a = this.b.a(this.c, this.a, str, z2);
            }
        }
        return a;
    }

    public void userStatistics(String str) {
        if (this.b != null) {
            this.b.a(this.c, str);
        }
    }
}
