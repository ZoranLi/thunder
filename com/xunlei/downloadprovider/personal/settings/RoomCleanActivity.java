package com.xunlei.downloadprovider.personal.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.personal.settings.ui.ChartView;
import com.xunlei.downloadprovider.personal.settings.ui.CircleAnimateView;
import com.xunlei.downloadprovider.personal.settings.ui.RoomInfoView;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.b.e;

public class RoomCleanActivity extends BaseActivity implements com.xunlei.downloadprovider.personal.settings.ui.ChartView.a {
    int[] a = new int[2];
    MessageListener c = new t(this);
    private ChartView d;
    private RoomInfoView e;
    private TextView f;
    private View g;
    private TextView h;
    private CircleAnimateView i;
    private StaticHandler j = new StaticHandler(this.c);

    public static class a {
        public long a;
        public long b;
        public long c;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.room_clean_activity_layout);
        this.d = (ChartView) findViewById(R.id.chartView);
        this.d.setCleanAnimateListener(this);
        this.f = (TextView) findViewById(R.id.speed_detection_headerbar).findViewById(R.id.titlebar_title);
        this.e = (RoomInfoView) findViewById(R.id.room_info_view);
        this.h = (TextView) findViewById(R.id.tv_clean);
        this.g = findViewById(R.id.speed_detection_headerbar).findViewById(R.id.titlebar_left);
        this.i = (CircleAnimateView) findViewById(R.id.circle_animate_view);
        this.g.setOnClickListener(new u(this));
        this.f.setText(R.string.clean_room_title);
        this.d.b.start();
        XLThreadPool.submit(new v(this));
        bundle = getIntent().getIntExtra("clearnspace_page_show", 0);
        if (bundle != null) {
            com.xunlei.downloadprovider.cooperation.a.a.a(l.c(bundle));
        }
        bundle = getIntent().getStringExtra("clearnspace_page_from");
        if (!TextUtils.isEmpty(bundle)) {
            com.xunlei.downloadprovider.cooperation.a.a.a(bundle);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    private static com.xunlei.downloadprovider.personal.settings.RoomCleanActivity.a b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new com.xunlei.downloadprovider.personal.settings.RoomCleanActivity$a;
        r0.<init>();
        r1 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ Exception -> 0x0029 }
        r2 = com.bumptech.glide.Glide.getPhotoCacheDir(r1);	 Catch:{ Exception -> 0x0029 }
        r3 = com.xunlei.common.businessutil.DownloadConfig.getStorageAvailableSize(r1);	 Catch:{ Exception -> 0x0029 }
        r5 = com.xunlei.common.businessutil.DownloadConfig.getStorageTotalSize(r1);	 Catch:{ Exception -> 0x0029 }
        r0.b = r3;	 Catch:{ Exception -> 0x0029 }
        r0.c = r5;	 Catch:{ Exception -> 0x0029 }
        r1 = com.bumptech.glide.Glide.get(r1);	 Catch:{ Exception -> 0x0029 }
        r1.clearDiskCache();	 Catch:{ Exception -> 0x0029 }
        if (r2 == 0) goto L_0x0029;	 Catch:{ Exception -> 0x0029 }
    L_0x0022:
        r1 = r2.getAbsolutePath();	 Catch:{ Exception -> 0x0029 }
        com.xunlei.downloadprovider.h.e.d(r1);	 Catch:{ Exception -> 0x0029 }
    L_0x0029:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.settings.RoomCleanActivity.b():com.xunlei.downloadprovider.personal.settings.RoomCleanActivity$a");
    }

    public final void a(float f, int i) {
        if (this.i != null) {
            this.d.getLocationOnScreen(this.a);
            StringBuilder stringBuilder = new StringBuilder("animateProcess pix=");
            stringBuilder.append(f);
            stringBuilder.append(",[0]=");
            stringBuilder.append(this.a[0]);
            stringBuilder.append(",[1]=");
            stringBuilder.append(this.a[1]);
            this.i.setTranstion(f);
            this.i.a = (int) (((double) this.a[1]) + (((double) i) * 0.9d));
            this.i.invalidate();
        }
    }

    public static void a(Context context, int i) {
        Intent xLIntent = new XLIntent(context, RoomCleanActivity.class);
        xLIntent.setFlags(268435456);
        xLIntent.putExtra("clearnspace_page_show", i);
        context.startActivity(xLIntent);
    }

    public static void a(Context context, String str) {
        Intent xLIntent = new XLIntent(context, RoomCleanActivity.class);
        xLIntent.setFlags(268435456);
        xLIntent.putExtra("clearnspace_page_from", str);
        context.startActivity(xLIntent);
    }

    static /* synthetic */ void a(RoomCleanActivity roomCleanActivity, Message message) {
        if (roomCleanActivity.h != null) {
            roomCleanActivity.h.setVisibility(8);
        }
        if (roomCleanActivity.i != null) {
            roomCleanActivity.i.setVisibility(8);
        }
        if (message != null && roomCleanActivity.d != null) {
            a aVar = (a) message.obj;
            RoomInfoView roomInfoView = roomCleanActivity.e;
            roomInfoView.setVisibility(0);
            roomInfoView.a.setText(roomInfoView.getContext().getString(R.string.clean_room_remain, new Object[]{e.a(aVar.b, 1)}));
            if (aVar.a <= 0) {
                roomInfoView.b.setText(roomInfoView.getContext().getString(R.string.clean_room_total, new Object[]{"0KB", e.a(aVar.c, 1)}));
            } else {
                roomInfoView.b.setText(roomInfoView.getContext().getString(R.string.clean_room_total, new Object[]{e.a(aVar.a, 1), e.a(aVar.c, 1)}));
            }
            long j = aVar.c;
            roomCleanActivity.d.c = (((float) ((int) ((((double) (j - aVar.b)) / ((double) j)) * 360.0d))) / 1135869952) * 1135869952;
            roomCleanActivity = roomCleanActivity.d;
            if (roomCleanActivity.b != null) {
                roomCleanActivity.a.removeAllListeners();
                roomCleanActivity.b.cancel();
            }
        }
    }
}
