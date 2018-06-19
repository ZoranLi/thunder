package com.xunlei.downloadprovider.publiser.common.guide.interesttag;

import android.net.Uri;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.publiser.common.guide.interesttag.a.b;
import java.util.List;

/* compiled from: InterestTagReporter */
public final class d {
    public static void a(String str, List<b> list) {
        str = StatEvent.build("android_personal_info").addString(HubbleEventBuilder.KEY_ATTRIBUTE1, str);
        String str2 = "tag_list";
        StringBuilder stringBuilder = new StringBuilder();
        for (b bVar : list) {
            stringBuilder.append(bVar.a);
            stringBuilder.append("|");
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        ThunderReport.reportEvent(str.addString(str2, Uri.encode(stringBuilder.toString())));
    }
}
