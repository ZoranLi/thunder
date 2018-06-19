package com.xunlei.downloadprovider.publiser.campaign;

import android.support.annotation.ColorInt;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.shortvideo.entity.AudioInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TopicUtil */
public final class p {
    public static final int a = BrothersApplication.getApplicationInstance().getResources().getColor(R.color.title_topic);

    /* compiled from: TopicUtil */
    private static class a {
        int a;
        int b;
        String c;

        private a() {
        }
    }

    public static String a() {
        return null;
    }

    public static void a(TextView textView, String str, AudioInfo audioInfo, String str2) {
        a(textView, str, audioInfo, str2, a);
    }

    public static void a(TextView textView, String str, AudioInfo audioInfo, String str2, @ColorInt int i) {
        List<a> arrayList = new ArrayList();
        if (str != null) {
            if (str.length() != 0) {
                a aVar = null;
                int i2 = 0;
                int i3 = i2;
                while (i2 < str.length()) {
                    if (str.charAt(i2) == '#') {
                        if (i3 == 0) {
                            a aVar2 = new a();
                            aVar2.a = i2;
                            aVar = aVar2;
                            i3 = 1;
                        } else if (i2 > aVar.a + 1) {
                            aVar.b = i2;
                            aVar.c = str.substring(aVar.a + 1, aVar.b);
                            arrayList.add(aVar);
                            i3 = (byte) 0;
                        } else {
                            aVar.a = i2;
                        }
                    }
                    i2++;
                }
                i2 = str.length();
                if (!(audioInfo == null || TextUtils.isEmpty(audioInfo.b))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append('♪');
                    stringBuilder.append(audioInfo.b);
                    stringBuilder.append('♪');
                    str = stringBuilder.toString();
                }
                CharSequence spannableString = new SpannableString(str);
                for (a aVar3 : arrayList) {
                    spannableString.setSpan(new q(textView, aVar3.c, str2, i), aVar3.a, aVar3.b + 1, 33);
                }
                if (i2 < spannableString.length()) {
                    spannableString.setSpan(new r(audioInfo, textView, str2, i), i2, spannableString.length(), 33);
                }
                textView.setText(spannableString);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(java.lang.String r2, java.lang.String r3) {
        /*
        r0 = "";
        r1 = r3.hashCode();
        switch(r1) {
            case -1540660761: goto L_0x0046;
            case -427179481: goto L_0x003c;
            case 75165: goto L_0x0032;
            case 2223327: goto L_0x0028;
            case 73725445: goto L_0x001e;
            case 80008463: goto L_0x0014;
            case 2072392632: goto L_0x000a;
            default: goto L_0x0009;
        };
    L_0x0009:
        goto L_0x0050;
    L_0x000a:
        r1 = "SHORT_VIDEO_DETAIL";
        r3 = r3.equals(r1);
        if (r3 == 0) goto L_0x0050;
    L_0x0012:
        r3 = 2;
        goto L_0x0051;
    L_0x0014:
        r1 = "TOPIC";
        r3 = r3.equals(r1);
        if (r3 == 0) goto L_0x0050;
    L_0x001c:
        r3 = 4;
        goto L_0x0051;
    L_0x001e:
        r1 = "MUSIC";
        r3 = r3.equals(r1);
        if (r3 == 0) goto L_0x0050;
    L_0x0026:
        r3 = 5;
        goto L_0x0051;
    L_0x0028:
        r1 = "HOME";
        r3 = r3.equals(r1);
        if (r3 == 0) goto L_0x0050;
    L_0x0030:
        r3 = 1;
        goto L_0x0051;
    L_0x0032:
        r1 = "LBS";
        r3 = r3.equals(r1);
        if (r3 == 0) goto L_0x0050;
    L_0x003a:
        r3 = 6;
        goto L_0x0051;
    L_0x003c:
        r1 = "PERSONAL_SPACE";
        r3 = r3.equals(r1);
        if (r3 == 0) goto L_0x0050;
    L_0x0044:
        r3 = 3;
        goto L_0x0051;
    L_0x0046:
        r1 = "FOLLOW_TAB";
        r3 = r3.equals(r1);
        if (r3 == 0) goto L_0x0050;
    L_0x004e:
        r3 = 0;
        goto L_0x0051;
    L_0x0050:
        r3 = -1;
    L_0x0051:
        switch(r3) {
            case 0: goto L_0x0067;
            case 1: goto L_0x0064;
            case 2: goto L_0x0061;
            case 3: goto L_0x005e;
            case 4: goto L_0x005b;
            case 5: goto L_0x0058;
            case 6: goto L_0x0055;
            default: goto L_0x0054;
        };
    L_0x0054:
        goto L_0x0069;
    L_0x0055:
        r0 = "LBS_collect";
        goto L_0x0069;
    L_0x0058:
        r0 = "music_collect";
        goto L_0x0069;
    L_0x005b:
        r0 = "videocollect";
        goto L_0x0069;
    L_0x005e:
        r0 = "personcenter";
        goto L_0x0069;
    L_0x0061:
        r0 = "detail";
        goto L_0x0069;
    L_0x0064:
        r0 = "home";
        goto L_0x0069;
    L_0x0067:
        r0 = "follow";
    L_0x0069:
        r3 = "youliao_tag_click";
        r1 = "android_youliao";
        r3 = com.xunlei.common.report.HubbleEventBuilder.build(r1, r3);
        r1 = "page";
        r3.add(r1, r0);
        r0 = "tag";
        r2 = android.net.Uri.encode(r2);
        r3.add(r0, r2);
        r2 = com.xunlei.downloadprovider.personal.settings.ui.ScaleTextView.a;
        r2 = new java.lang.StringBuilder;
        r0 = "[STAT_EVENT]";
        r2.<init>(r0);
        r2.append(r3);
        com.xunlei.common.report.ThunderReport.reportEvent(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.publiser.campaign.p.a(java.lang.String, java.lang.String):void");
    }
}
