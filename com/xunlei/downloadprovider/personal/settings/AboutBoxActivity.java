package com.xunlei.downloadprovider.personal.settings;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;

public class AboutBoxActivity extends BaseActivity {
    private static final String a = "AboutBoxActivity";
    private View c;
    private TextView d;
    private TextView e;
    private View f;
    private View g;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bt_sett_about_box_activity);
        this.c = findViewById(R.id.titlebar_left);
        this.d = (TextView) findViewById(R.id.titlebar_title);
        this.e = (TextView) findViewById(R.id.bt_sett_about_version);
        this.d.setText("关于");
        new TitleBar((Activity) this).mRight.setVisibility(4);
        StringBuilder stringBuilder = new StringBuilder("V");
        stringBuilder.append("5.60.2.5510");
        this.e.setText(stringBuilder.toString());
        this.e.setOnClickListener(new a(this));
        this.c.setOnClickListener(new b(this));
        this.f = findViewById(R.id.bt_sett_about_button_phone);
        this.f.setOnClickListener(new c(this));
        bundle = new ForegroundColorSpan(-33475);
        TextView textView = (TextView) findViewById(R.id.bt_sett_about_weixin_step1);
        Object obj = "1、打开微信点击右上角“添加朋友”";
        CharSequence spannableString = new SpannableString(obj);
        spannableString.setSpan(bundle, 11, obj.length(), 33);
        textView.setText(spannableString);
        textView = (TextView) findViewById(R.id.bt_sett_about_weixin_step2);
        spannableString = new SpannableString("2、输入“shoujixunlei”或“手机迅雷”搜索");
        spannableString.setSpan(bundle, 4, 18, 33);
        spannableString.setSpan(new ForegroundColorSpan(-33475), 19, 25, 33);
        textView.setText(spannableString);
        TextView textView2 = (TextView) findViewById(R.id.bt_sett_about_weixin_step3);
        CharSequence spannableString2 = new SpannableString("3、点击“关注”即可进入调戏蕾妹模式");
        spannableString2.setSpan(bundle, 4, 8, 33);
        textView2.setText(spannableString2);
        this.g = findViewById(R.id.bt_sett_about_button_weibo);
        this.g.setOnClickListener(new f(this));
    }

    public void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    static /* synthetic */ void a(com.xunlei.downloadprovider.personal.settings.AboutBoxActivity r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.aplayer.aplayerandroid.APlayerAndroid.getVersion();
        r1 = "信息";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "下载库 : 1.0.0.9";
        r2.append(r3);
        r3 = "\n播放器 : ";
        r2.append(r3);
        r2.append(r0);
        r0 = "\r\nimei : ";	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = com.xunlei.common.androidutil.AndroidConfig.getIMEI();	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = "\r\nmac : ";	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = com.xunlei.common.androidutil.AndroidConfig.getMAC();	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = "\r\nchannel : ";	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = com.xunlei.common.androidutil.AndroidConfig.getPartnerId();	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = "\r\nuid : ";	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ Exception -> 0x00a8 }
        r0 = r0.g;	 Catch:{ Exception -> 0x00a8 }
        r3 = r0.c();	 Catch:{ Exception -> 0x00a8 }
        r2.append(r3);	 Catch:{ Exception -> 0x00a8 }
        r0 = "\r\nversionCode : 11100";	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = " (release)";	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = "\r\nGuid : ";	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = com.xunlei.common.androidutil.AndroidConfig.getHubbleDeviceGUID();	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = "\r\nDeviceId : ";	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = com.xunlei.downloadprovider.member.login.LoginHelper.q();	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = "\r\nPushType : ";	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = com.xunlei.downloadprovider.pushmessage.e.c();	 Catch:{ Exception -> 0x00a8 }
        r0 = r0.a();	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = "\r\nPushToken : ";	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = com.xunlei.downloadprovider.pushmessage.e.c();	 Catch:{ Exception -> 0x00a8 }
        r0 = r0.d();	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
        r0 = com.xunlei.xllib.android.a.a(r5);	 Catch:{ Exception -> 0x00a8 }
        if (r0 == 0) goto L_0x00a8;	 Catch:{ Exception -> 0x00a8 }
    L_0x0096:
        r3 = "TINKER_ID";	 Catch:{ Exception -> 0x00a8 }
        r4 = "null";	 Catch:{ Exception -> 0x00a8 }
        r0 = r0.getString(r3, r4);	 Catch:{ Exception -> 0x00a8 }
        if (r0 == 0) goto L_0x00a8;	 Catch:{ Exception -> 0x00a8 }
    L_0x00a0:
        r3 = "\r\ntinkerId : ";	 Catch:{ Exception -> 0x00a8 }
        r2.append(r3);	 Catch:{ Exception -> 0x00a8 }
        r2.append(r0);	 Catch:{ Exception -> 0x00a8 }
    L_0x00a8:
        r0 = new android.app.AlertDialog$Builder;
        r0.<init>(r5);
        r0.setTitle(r1);
        r1 = r2.toString();
        r0.setMessage(r1);
        r1 = "确定";
        r3 = new com.xunlei.downloadprovider.personal.settings.g;
        r3.<init>(r5, r2);
        r0.setPositiveButton(r1, r3);
        r1 = "复制";
        r3 = new com.xunlei.downloadprovider.personal.settings.h;
        r3.<init>(r5, r2);
        r0.setNegativeButton(r1, r3);
        r5 = r0.create();	 Catch:{ Exception -> 0x00d3 }
        r5.show();	 Catch:{ Exception -> 0x00d3 }
        return;
    L_0x00d3:
        r5 = move-exception;
        r5.printStackTrace();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.settings.AboutBoxActivity.a(com.xunlei.downloadprovider.personal.settings.AboutBoxActivity):void");
    }
}
