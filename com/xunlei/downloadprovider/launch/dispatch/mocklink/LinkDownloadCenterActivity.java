package com.xunlei.downloadprovider.launch.dispatch.mocklink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.umeng.message.proguard.l;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.notification.c;

public class LinkDownloadCenterActivity extends Activity {
    public static void a(Context context, long j, String str) {
        StringBuilder stringBuilder = new StringBuilder("startActivityFromNotification: taskId = ");
        stringBuilder.append(j);
        stringBuilder.append(", from = ");
        stringBuilder.append(str);
        j = b(context, j, str);
        j.setFlags(268435456);
        context.startActivity(j);
    }

    public static Intent b(Context context, long j, String str) {
        Intent intent = new Intent(context, LinkDownloadCenterActivity.class);
        intent.setFlags(67108864);
        a(intent, j, str);
        return intent;
    }

    public static Intent a(Context context, long j, TaskInfo taskInfo) {
        Intent intent = new Intent(context, LinkDownloadCenterActivity.class);
        a(intent, j, "from_bxbb_noti");
        intent.putExtra("extra_key_vodplay_taskinfo", taskInfo);
        intent.putExtra("extra_key_vodplay_from", "download_push_bxbb");
        intent.setFlags(268435456);
        return intent;
    }

    public static Intent b(Context context, long j, TaskInfo taskInfo) {
        Intent intent = new Intent(context, LinkDownloadCenterActivity.class);
        a(intent, j, "from_bxbb_global_noti");
        intent.putExtra("extra_key_vodplay_taskinfo", taskInfo);
        intent.putExtra("extra_key_vodplay_from", "download_push_bxbb");
        intent.setFlags(268435456);
        return intent;
    }

    private static void a(Intent intent, long j, String str) {
        intent.putExtra(l.m, j);
        intent.putExtra("from", str);
        intent.putExtra("extra_key_should_open_detailpage", false);
    }

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
        finish();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
        finish();
    }

    private void a(Intent intent) {
        Bundle bundle;
        if (intent.getExtras() != null) {
            bundle = new Bundle(intent.getExtras());
        } else {
            bundle = new Bundle(9);
        }
        String stringExtra = intent.getStringExtra("from");
        long longExtra = intent.getLongExtra(l.m, -1);
        intent = intent.getBooleanExtra("extra_key_should_open_detailpage", false);
        StringBuilder stringBuilder = new StringBuilder("handleIntent: taskId = ");
        stringBuilder.append(longExtra);
        stringBuilder.append(", from = ");
        stringBuilder.append(stringExtra);
        stringBuilder.append(", openDetailPage = ");
        stringBuilder.append(intent);
        if ("from_running_noti".equals(stringExtra)) {
            a.a("download_in", "in_video");
        } else if ("task_free_trial_notify".equals(stringExtra)) {
            a.c();
        } else if ("from_done_noti".equals(stringExtra)) {
            c.a(getApplication());
            c.a();
        } else if ("from_failed_noti".equals(stringExtra)) {
            a.a("download_fail", "");
            c.a(getApplication());
            c.b();
        } else if ("from_bxbb_noti".equals(stringExtra)) {
            a.a("download_in_bxbb", "in_bxbb");
        }
        if (intent != null) {
            com.xunlei.downloadprovider.download.a.b(this, longExtra, stringExtra, bundle);
        } else {
            com.xunlei.downloadprovider.download.a.a(this, longExtra, stringExtra, bundle);
        }
    }
}
