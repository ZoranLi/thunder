package com.xunlei.downloadprovider.bho;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.sdk.cons.c;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.a;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.create.DownData;
import com.xunlei.downloadprovider.download.create.ThunderTaskActivity;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.launch.dispatch.q;
import com.xunlei.downloadprovider.service.DownloadService;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ThunderTaskBHOActivity extends ThunderTaskActivity {
    private Bundle a;
    private MessageListener c = new d(this);
    private StaticHandler d = new StaticHandler(this.c);

    private void a() {
        finish();
        Bundle bundle = this.a;
        if (b.d()) {
            Bundle bundle2 = new Bundle(9);
            ThunderTaskActivity.a(bundle2, bundle);
            a.a(this, -1, "BHO_SDK", bundle2, null);
            return;
        }
        Bundle bundle3 = new Bundle(9);
        ThunderTaskActivity.a(bundle3, bundle);
        bundle3.putBoolean("back_to_home_page", true);
        a.c(this, -1, "BHO_SDK", bundle3);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (q.a == null) {
            bundle = getIntent();
            bundle.setClass(this, LaunchActivity.class);
            bundle.putExtra("dispatch_from_key", SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_PARAM);
            startActivity(bundle);
            finish();
            return;
        }
        setContentView(R.layout.activity_outer_download_interaction);
        findViewById(R.id.confirm_download_dlg).setVisibility(4);
        b(getIntent());
    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
        b(intent);
    }

    private void b(Intent intent) {
        this.a = c(intent);
        if (DownloadService.a() == null) {
            DownloadService.a(new e(this));
        } else {
            a();
        }
        intent = "";
        String str = "";
        if (this.a != null) {
            str = this.a.getString(Constants.APP_ID);
            intent = this.a.getString("partner_id");
        }
        StatEvent build = HubbleEventBuilder.build("android_launch", "launch_sdk");
        build.addString("platform", DispatchConstants.ANDROID);
        build.addString("appid", str);
        build.addString("sdkid", intent);
        build.addString("imei", AndroidConfig.getIMEI(BrothersApplication.getApplicationInstance()));
        build.addString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC());
        ThunderReport.reportEvent(build);
    }

    private static Bundle c(Intent intent) {
        Bundle bundle = new Bundle(9);
        bundle.putString(Constants.APP_ID, intent.getStringExtra(Constants.APP_ID));
        bundle.putString("partner_id", intent.getStringExtra("partner_id"));
        bundle.putString("sdk_key", intent.getStringExtra("sdk_key"));
        ArrayList arrayList = new ArrayList(1);
        Object stringExtra = intent.getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra)) {
            intent = intent.getStringExtra("urls");
            if (!TextUtils.isEmpty(intent)) {
                try {
                    JSONObject jSONObject = new JSONObject(intent);
                    intent = jSONObject.optString(Impl.COLUMN_REFERER);
                    JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                Object optString = optJSONObject.optString("url");
                                String optString2 = optJSONObject.optString(c.e);
                                String optString3 = jSONObject.optString(Impl.COLUMN_REFERER);
                                if (!TextUtils.isEmpty(optString)) {
                                    DownData downData = new DownData();
                                    downData.b = optString;
                                    if (optString3 == null) {
                                        optString3 = intent;
                                    }
                                    downData.a(optString3);
                                    downData.a = optString2;
                                    arrayList.add(downData);
                                }
                            }
                        }
                    }
                } catch (Intent intent2) {
                    intent2.printStackTrace();
                }
            }
        } else {
            DownData downData2 = new DownData();
            downData2.b = stringExtra;
            downData2.a(intent2.getStringExtra(Impl.COLUMN_REFERER));
            downData2.a = intent2.getStringExtra(c.e);
            arrayList.add(downData2);
        }
        bundle.putParcelableArrayList("tasks", arrayList);
        return bundle;
    }
}
