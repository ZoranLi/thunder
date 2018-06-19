package com.xunlei.downloadprovider.publiser.common.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.publiser.common.a.a;
import com.xunlei.downloadprovider.publiser.visitors.model.Gender;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

public class PublisherUserInfoTagView extends LinearLayout {
    private ImageView a;
    private TextView b;
    private TextView c;

    public PublisherUserInfoTagView(Context context) {
        super(context);
        a();
    }

    public PublisherUserInfoTagView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PublisherUserInfoTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        setGravity(16);
        LayoutInflater.from(getContext()).inflate(R.layout.user_info_tag_view_for_publisher_page, this, true);
        this.a = (ImageView) findViewById(R.id.iv_location);
        this.b = (TextView) findViewById(R.id.tv_user_info_tag);
        this.c = (TextView) findViewById(R.id.tv_vip);
        if (!isInEditMode()) {
            setVisibility(8);
        }
    }

    public void setUserInfo(VideoUserInfo videoUserInfo) {
        a(videoUserInfo.getProvince(), videoUserInfo.getCity(), videoUserInfo.getGender(), videoUserInfo.getBirthday());
        videoUserInfo = videoUserInfo.getVipInfo();
        if (videoUserInfo.a) {
            TextView textView = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(videoUserInfo.b);
            textView.setText(stringBuilder.toString());
            videoUserInfo = videoUserInfo.b();
            if (videoUserInfo == 1) {
                this.c.setBackgroundResource(R.drawable.ic_super_vip_level);
            } else if (videoUserInfo == 2) {
                this.c.setBackgroundResource(R.drawable.ic_kuainiao_vip_level);
            } else {
                this.c.setBackgroundResource(R.drawable.ic_normal_vip_level);
            }
            this.c.setVisibility(0);
            return;
        }
        this.c.setVisibility(8);
    }

    public final void a(String str, String str2, Gender gender, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!a.c(str)) {
            str = str2;
        }
        if (TextUtils.isEmpty(str) != null) {
            str = "";
        } else {
            str = a.a(str).replace("市", "");
        }
        if (TextUtils.isEmpty(str) != null) {
            this.a.setVisibility(8);
        } else {
            this.a.setVisibility(0);
            stringBuilder.append(str);
            stringBuilder.append("  ");
        }
        if (gender == Gender.MALE) {
            stringBuilder.append("男  ");
        } else if (gender == Gender.FEMALE) {
            stringBuilder.append("女  ");
        }
        str = a(str3);
        if (TextUtils.isEmpty(str) == null) {
            stringBuilder.append(str);
        }
        if (stringBuilder.length() > null) {
            setVisibility(0);
            this.b.setText(stringBuilder.toString());
            return;
        }
        setVisibility(8);
    }

    private static java.lang.String a(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r3 = "";
        return r3;
    L_0x0009:
        r0 = new java.text.SimpleDateFormat;	 Catch:{ ParseException -> 0x0054 }
        r1 = "yyyyMMdd";	 Catch:{ ParseException -> 0x0054 }
        r0.<init>(r1);	 Catch:{ ParseException -> 0x0054 }
        r0 = r0.parse(r3);	 Catch:{ ParseException -> 0x0054 }
        if (r0 != 0) goto L_0x0018;
    L_0x0016:
        r3 = 0;
        return r3;
    L_0x0018:
        r0 = 4;
        r1 = 6;
        r0 = r3.substring(r0, r1);
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r0.intValue();
        r2 = 8;
        r1 = r3.substring(r1, r2);
        r1 = java.lang.Integer.valueOf(r1);
        r1 = r1.intValue();
        if (r1 != 0) goto L_0x0037;
    L_0x0036:
        r1 = 1;
    L_0x0037:
        r0 = com.xunlei.downloadprovider.personal.user.account.m.a(r0, r1);
        r3 = com.xunlei.downloadprovider.personal.user.account.m.c(r3);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r3);
        r3 = "岁  ";
        r1.append(r3);
        r1.append(r0);
        r3 = r1.toString();
        return r3;
    L_0x0054:
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.publiser.common.view.PublisherUserInfoTagView.a(java.lang.String):java.lang.String");
    }
}
