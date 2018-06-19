package com.xunlei.downloadprovider.pushmessage.ginsight;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.getui.gis.sdk.GInsightManager;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import org.android.agoo.common.AgooConstants;

public class GInsightEventReceiver extends BroadcastReceiver {
    public static final String a = "GInsightEventReceiver";

    public void onReceive(Context context, Intent intent) {
        if (intent.getStringExtra("action").equalsIgnoreCase(GInsightManager.ACTION_GIUID_GENERATED) != null) {
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_launch", "ginsight_id_get_result").addString(AgooConstants.MESSAGE_ID, intent.getStringExtra("giuid")));
        }
    }
}
