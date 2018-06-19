package com.tencent.smtt.sdk;

import android.os.Bundle;
import com.alipay.sdk.cons.c;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.smtt.sdk.a.d;
import com.umeng.socialize.common.SocializeConstants;

class av implements ReaderCallback {
    final /* synthetic */ TbsReaderView a;

    av(TbsReaderView tbsReaderView) {
        this.a = tbsReaderView;
    }

    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        Object bundle;
        int intValue = num.intValue();
        Bundle bundle2 = null;
        Object obj3 = null;
        String resString;
        TbsReaderView tbsReaderView;
        String str;
        String str2;
        TbsReaderView tbsReaderView2;
        if (intValue != ReaderCallback.READER_SEARCH_IN_DOCUMENT) {
            if (intValue != ReaderCallback.READER_PLUGIN_SO_VERSION) {
                switch (intValue) {
                    case ReaderCallback.READER_PDF_LIST /*5008*/:
                        if (!d.c(this.a.a)) {
                            num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                            resString = TbsReaderView.getResString(this.a.a, ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE);
                            bundle = new Bundle();
                            bundle.putString("tip", resString);
                            bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD);
                            bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_PDF_ID);
                            tbsReaderView = this.a;
                            str = TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DIALOG;
                            break;
                        }
                        str2 = "";
                        if (obj != null) {
                            bundle2 = (Bundle) obj;
                            str2 = bundle2.getString("docpath");
                        }
                        QbSdk.startQBForDoc(this.a.a, str2, 4, 0, "pdf", bundle2);
                        tbsReaderView2 = this.a;
                        str = TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_BROWSER;
                        break;
                    case ReaderCallback.READER_PPT_PLAY_MODEL /*5009*/:
                        if (!d.c(this.a.a)) {
                            num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                            resString = TbsReaderView.getResString(this.a.a, ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE);
                            bundle = new Bundle();
                            bundle.putString("tip", resString);
                            bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD);
                            bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_PPT_ID);
                            tbsReaderView = this.a;
                            str = TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DIALOG;
                            break;
                        }
                        str2 = "";
                        if (obj != null) {
                            bundle2 = (Bundle) obj;
                            str2 = bundle2.getString("docpath");
                        }
                        QbSdk.startQBForDoc(this.a.a, str2, 4, 0, "", bundle2);
                        tbsReaderView2 = this.a;
                        str = TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_BROWSER;
                        break;
                    case ReaderCallback.READER_TXT_READING_MODEL /*5010*/:
                        if (!d.c(this.a.a)) {
                            num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                            resString = TbsReaderView.getResString(this.a.a, ReaderCallback.READER_PLUGIN_RES_TXT_GUIDE);
                            bundle = new Bundle();
                            bundle.putString("tip", resString);
                            bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD);
                            bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_TXT_ID);
                            tbsReaderView = this.a;
                            str = TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DIALOG;
                            break;
                        }
                        str2 = "";
                        if (obj != null) {
                            bundle2 = (Bundle) obj;
                            str2 = bundle2.getString("docpath");
                        }
                        QbSdk.startQBForDoc(this.a.a, str2, 4, 0, SocializeConstants.KEY_TEXT, bundle2);
                        break;
                }
            } else if (obj != null) {
                Bundle bundle3 = (Bundle) obj;
                TbsReaderView.gReaderPackName = bundle3.getString(c.e);
                TbsReaderView.gReaderPackVersion = bundle3.getString("version");
            }
            obj3 = 1;
        } else if (d.c(this.a.a)) {
            str2 = "";
            if (obj != null) {
                bundle2 = (Bundle) obj;
                str2 = bundle2.getString("docpath");
            }
            QbSdk.startQBForDoc(this.a.a, str2, 4, 0, "doc", bundle2);
            tbsReaderView2 = this.a;
            str = TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_BROWSER;
            tbsReaderView2.userStatistics(str);
            obj3 = 1;
        } else {
            num = Integer.valueOf(ReaderCallback.INSTALL_QB);
            resString = TbsReaderView.getResString(this.a.a, ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
            bundle = new Bundle();
            bundle.putString("tip", resString);
            bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD);
            bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_DOC_ID);
            tbsReaderView = this.a;
            str = TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DIALOG;
            tbsReaderView.userStatistics(str);
            if (this.a.d != null && r4 == null) {
                this.a.d.onCallBackAction(num, bundle, obj2);
                return;
            }
        }
        bundle = obj;
        if (this.a.d != null) {
        }
    }
}
