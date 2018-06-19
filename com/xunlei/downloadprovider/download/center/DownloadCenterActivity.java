package com.xunlei.downloadprovider.download.center;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.message.proguard.l;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.downloadlist.c;
import com.xunlei.downloadprovider.ad.downloadlist.c.e;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.c.a;
import com.xunlei.downloadprovider.download.create.ThunderTaskActivity;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.download.taskdetails.DownloadCenterDetailFragment;
import com.xunlei.downloadprovider.download.taskdetails.DownloadCenterDetailFragment$b;
import com.xunlei.downloadprovider.download.tasklist.list.banner.c.f;
import com.xunlei.downloadprovider.download.tasklist.list.download.TaskDownloadCardViewHolder;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.service.DownloadService;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;
import com.xunlei.downloadprovider.web.website.g.b;
import com.xunlei.xllib.android.XLIntent;

public class DownloadCenterActivity extends ThunderTaskActivity implements DownloadCenterDetailFragment$b {
    DownloadCenterActivityFragment a;
    DownloadCenterDetailFragment c;
    boolean d;
    private boolean g = false;
    private boolean h = false;
    private b i = new b(this, (byte) 0);
    private a j = new a(this, (byte) 0);
    private Bitmap k = null;
    private BroadcastReceiver l = new a(this);

    protected final boolean q_() {
        return false;
    }

    public static void a(Context context, long j, String str, Bundle bundle) {
        b.a().b();
        Intent xLIntent = new XLIntent(context, DownloadCenterActivity.class);
        boolean z = context instanceof Activity;
        if (z) {
            xLIntent.setFlags(67108864);
        } else {
            xLIntent.setFlags(268435456);
        }
        if (bundle != null) {
            xLIntent.putExtras(bundle);
        }
        if (DLCenterEntry.personal_my_collection.toString().equals(str) != null) {
            xLIntent.putExtra("extra_key_jump_to_collection", true);
        }
        xLIntent.putExtra(l.m, j);
        xLIntent.putExtra("from", str);
        context.startActivity(xLIntent);
        if ("alarmDialog".equals(str) != null) {
            if (z) {
                ((Activity) context).overridePendingTransition(2131034183, R.anim.translate_alpha_out);
            }
        } else if (z) {
            ((Activity) context).overridePendingTransition(2131034189, R.anim.translate_between_interface_left_out);
        }
    }

    protected final int e() {
        return getResources().getColor(R.color.common_blue);
    }

    public void onBackPressed() {
        if (this.a != null && this.a.c) {
            this.a.a();
        } else if (this.c == null || !this.c.isVisible()) {
            try {
                super.onBackPressed();
            } catch (Exception e) {
                e.printStackTrace();
                finish();
            }
        } else {
            this.c.c();
        }
    }

    public void finish() {
        if (this.g) {
            RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
            if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
                MainTabActivity.b(this, "thunder", null);
            }
        }
        super.finish();
        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
    }

    public final void a() {
        this.a.b.a.setVisibility(0);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.common_blue));
        }
    }

    protected void onCreate(Bundle bundle) {
        IntentFilter intentFilter;
        super.onCreate(bundle);
        bundle = getIntent().getStringExtra("from");
        if (getIntent().hasExtra("back_to_home_page")) {
            this.g = getIntent().getBooleanExtra("back_to_home_page", false);
        } else if (!(bundle == null || bundle.equals(DispatchConstants.OTHER) || bundle.equals("alarmDialog") || this.g)) {
            this.g = true;
        }
        if ("sniff".equals(bundle) != null) {
            c.a().b = true;
        }
        a.a();
        a.f();
        e.a();
        e.c = null;
        setContentView(R.layout.activity_download_center);
        a((Intent) getIntent());
        b(getIntent());
        this.a = (DownloadCenterActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        long longExtra = getIntent().getLongExtra(l.m, -1);
        String stringExtra = getIntent().getStringExtra("gcid");
        boolean booleanExtra = getIntent().getBooleanExtra("extra_key_should_open_detailpage", false);
        this.d = getIntent().getBooleanExtra("extra_key_jump_to_collection", false);
        if (this.a == null) {
            this.a = new DownloadCenterActivityFragment();
            Bundle arguments = this.a.getArguments();
            if (arguments == null) {
                arguments = new Bundle(5);
                this.a.setArguments(arguments);
            }
            arguments.putLong(l.m, longExtra);
            arguments.putString("gcid", stringExtra);
            arguments.putString("from", getIntent().getStringExtra("from"));
            arguments.putBoolean("extra_key_should_open_detailpage", booleanExtra);
            arguments.putBoolean("extra_key_jump_to_collection", this.d);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.fragment_container, this.a);
        beginTransaction.commitAllowingStateLoss();
        if (!this.h) {
            this.h = true;
            intentFilter = new IntentFilter();
            intentFilter.addAction("com.xunLei.downloadCenter.MoreOperate");
            registerReceiver(this.j, intentFilter);
        }
        intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_EXIT_PLAYER");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.i, intentFilter);
        if (booleanExtra) {
            n.a();
            bundle = h.e().c(n.f(stringExtra));
            if (bundle != null) {
                com.xunlei.downloadprovider.download.control.a.a(this, bundle, "");
            }
        }
        c(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
        b(intent);
        boolean booleanExtra = intent.getBooleanExtra("extra_key_should_open_detailpage", false);
        DownloadCenterActivityFragment downloadCenterActivityFragment = (DownloadCenterActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        long longExtra = intent.getLongExtra(l.m, -1);
        Bundle arguments = downloadCenterActivityFragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle(9);
            downloadCenterActivityFragment.setArguments(arguments);
        }
        arguments.putLong(l.m, longExtra);
        arguments.putBoolean("extra_key_should_open_detailpage", false);
        if ("alarmDialog".equals(intent.getStringExtra("from")) && this.c != null && this.c.isAdded()) {
            this.c.a(true);
        }
        if (booleanExtra) {
            TaskInfo c = h.e().c(longExtra);
            if (c != null) {
                com.xunlei.downloadprovider.download.control.a.a(this, c, "");
            }
        }
        c(intent);
    }

    public void onResume() {
        super.onResume();
        if (DownloadService.a() == null) {
            DownloadService.a(null);
        } else {
            n.a();
            n.p();
        }
        LoginHelper.a();
        if (com.xunlei.downloadprovider.member.login.b.l.c()) {
            n.a().a(LoginHelper.a());
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.j);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.i);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.l);
        TaskDownloadCardViewHolder.hasReportDl_Try_Show = false;
        f.a().d();
        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a();
        com.xunlei.downloadprovider.download.tasklist.list.feed.a.b();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    private void b(android.content.Intent r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = "from";
        r4 = r4.getStringExtra(r0);
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x002d }
        if (r0 != 0) goto L_0x001c;	 Catch:{ Exception -> 0x002d }
    L_0x000c:
        r0 = "_noti";	 Catch:{ Exception -> 0x002d }
        r0 = r4.endsWith(r0);	 Catch:{ Exception -> 0x002d }
        if (r0 == 0) goto L_0x001c;	 Catch:{ Exception -> 0x002d }
    L_0x0014:
        r0 = com.xunlei.downloadprovider.download.report.DLCenterEntry.download_push;	 Catch:{ Exception -> 0x002d }
        r0 = r0.toString();	 Catch:{ Exception -> 0x002d }
    L_0x001a:
        r4 = r0;	 Catch:{ Exception -> 0x002d }
        goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x001c:
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x002d }
        if (r0 != 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0022:
        r0 = com.xunlei.downloadprovider.download.report.DLCenterEntry.enumValueOf(r4);	 Catch:{ Exception -> 0x002d }
        if (r0 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0028:
        r0 = r0.toString();	 Catch:{ Exception -> 0x002d }
        goto L_0x001a;
    L_0x002d:
        r0 = "";
        r1 = "";
        r2 = r3.f;
        if (r2 == 0) goto L_0x0041;
    L_0x0035:
        r0 = "app_id";
        r1 = r2.getString(r0);
        r0 = "partner_id";
        r0 = r2.getString(r0);
    L_0x0041:
        com.xunlei.downloadprovider.download.report.a.a(r4, r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.center.DownloadCenterActivity.b(android.content.Intent):void");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.xunlei.downloadprovider.f.a.a();
        com.xunlei.downloadprovider.f.a.a(this, i, i2, intent);
    }

    private void c(Intent intent) {
        TaskInfo taskInfo = (TaskInfo) intent.getSerializableExtra("extra_key_vodplay_taskinfo");
        intent.getStringExtra("extra_key_vodplay_from");
        if (taskInfo != null) {
            m.a(taskInfo.getTaskId(), -1, false);
            VodPlayerActivityNew.a(this, taskInfo, null, "download_list");
        }
    }
}
