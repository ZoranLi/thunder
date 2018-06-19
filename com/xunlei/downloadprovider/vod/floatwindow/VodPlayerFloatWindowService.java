package com.xunlei.downloadprovider.vod.floatwindow;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.view.GestureDetector;
import android.view.View;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.igexin.sdk.PushConsts;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.app.AppStatusChgObserver.STATUS;
import com.xunlei.downloadprovider.app.AppStatusChgObserver.a;
import com.xunlei.downloadprovider.download.downloadvod.TaskPlayInfo;
import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;
import com.xunlei.downloadprovider.vodnew.a.e.o;
import java.util.HashMap;
import java.util.Timer;

public class VodPlayerFloatWindowService extends Service implements a {
    private static final String b = "VodPlayerFloatWindowService";
    boolean a;
    private a c;

    public final void a(STATUS status) {
        if (VERSION.SDK_INT < 23) {
            boolean z = false;
            if (!(Build.MANUFACTURER.toLowerCase().indexOf("samsung") != -1)) {
                if (!(Build.MANUFACTURER.toLowerCase().indexOf("xiaomi") != -1)) {
                    if (status == STATUS.STATUS_FOREGROUND) {
                        if (!(this.a == null || this.c == null)) {
                            status = this.c;
                            if (!(status.g == null || status.g.t())) {
                                status.b();
                            }
                        }
                    } else if (status == STATUS.STATUS_BACKGROUND && this.c != null) {
                        status = this.c;
                        if (status.g != null) {
                            z = status.g.t();
                        }
                        this.a = z;
                        status = this.c;
                        if (status.g != null && status.g.t()) {
                            status.k = true;
                            status.c();
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, TaskPlayInfo taskPlayInfo, int i, HashMap hashMap, boolean z, SubtitleManifest subtitleManifest) {
        Intent intent = new Intent();
        intent.setClass(context, VodPlayerFloatWindowService.class);
        intent.putExtra("EXTRA_KEY_TASK_PLAY_INFO", taskPlayInfo);
        intent.putExtra("EXTRA_KEY_START_POS", i);
        intent.putExtra("extra_key_is_open_paused_state", 0);
        intent.putExtra("extra_key_should_play", z);
        if (hashMap != null) {
            intent.putExtra("EXTRA_KEY_PLAYER_CONFIG", hashMap);
        }
        if (subtitleManifest != null) {
            intent.putExtra("EXTRA_KEY_PLAYER_SubtitleManifest", subtitleManifest);
        }
        context.startService(intent);
    }

    public static void a(Context context) {
        context.stopService(new Intent(context, VodPlayerFloatWindowService.class));
    }

    public void onCreate() {
        super.onCreate();
        this.c = new a(this);
        AppStatusChgObserver.b().a(this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                intent.setExtrasClassLoader(TaskPlayInfo.class.getClassLoader());
                TaskPlayInfo taskPlayInfo = (TaskPlayInfo) intent.getSerializableExtra("EXTRA_KEY_TASK_PLAY_INFO");
                i2 = intent.getIntExtra("EXTRA_KEY_START_POS", 0);
                boolean booleanExtra = intent.getBooleanExtra("extra_key_is_open_paused_state", false);
                boolean booleanExtra2 = intent.getBooleanExtra("extra_key_should_play", false);
                intent.setExtrasClassLoader(HashMap.class.getClassLoader());
                HashMap hashMap = (HashMap) intent.getSerializableExtra("EXTRA_KEY_PLAYER_CONFIG");
                intent.setExtrasClassLoader(SubtitleManifest.class.getClassLoader());
                SubtitleManifest subtitleManifest = (SubtitleManifest) intent.getSerializableExtra("EXTRA_KEY_PLAYER_SubtitleManifest");
                if (this.c != null) {
                    a aVar = this.c;
                    a.a = true;
                    aVar.l = taskPlayInfo;
                    aVar.m = i2;
                    aVar.n = hashMap;
                    aVar.o = booleanExtra2;
                    aVar.p = subtitleManifest;
                    if (aVar.f == null) {
                        aVar.f = (VodPlayerFloatWindowView) View.inflate(aVar.b, R.layout.layout_float_video, null);
                        aVar.d.addView(aVar.f, aVar.e);
                        new StringBuilder("on view add to window manager -----  ").append(System.currentTimeMillis());
                        if (aVar.p != null) {
                            aVar.f.setSubtitleColor(aVar.p.getSubtitleColor());
                        }
                        aVar.g = new o();
                        aVar.g.a(aVar.f.getSurfaceView());
                        aVar.g.a(new h(aVar));
                        aVar.g.a(new i(aVar));
                        aVar.g.a(new j(aVar));
                        aVar.g.a(new k(aVar));
                        aVar.g.a(new l(aVar));
                        aVar.g.a(new m(aVar));
                        aVar.h = new GestureDetector(aVar.b, aVar.u);
                        aVar.f.setClickListener(new b(aVar));
                        intent = aVar.b.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
                        aVar.f.setOnTouchListener(new g(aVar, intent > null ? aVar.b.getResources().getDimensionPixelSize(intent) : null));
                        if (aVar.q == null) {
                            aVar.q = new d(aVar);
                            intent = new IntentFilter();
                            intent.addAction("android.intent.action.SCREEN_ON");
                            intent.addAction("android.intent.action.SCREEN_OFF");
                            intent.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
                            aVar.b.registerReceiver(aVar.q, intent);
                        }
                    }
                    if (booleanExtra) {
                        aVar.f.a(true);
                    } else {
                        aVar.f.a();
                    }
                    aVar.d();
                    i iVar = new i(aVar.l, "float_window");
                    if (aVar.g != 0) {
                        aVar.c.requestAudioFocus(aVar.t, 3, 1);
                        aVar.g.a(iVar);
                        aVar.g.d();
                    }
                    if (aVar.i == null) {
                        aVar.i = new Timer();
                        aVar.j = new a();
                        aVar.i.scheduleAtFixedRate(aVar.j, 500, 1000);
                    }
                    c.a(aVar.b, "float_player_open_action", null);
                    startForeground(111, this.c.a());
                }
            } catch (Intent intent2) {
                intent2.printStackTrace();
            }
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onDestroy() {
        if (this.c != null) {
            a aVar = this.c;
            new StringBuilder("removeWindow, sPlayerFloatWindowIsShowing : ").append(a.a);
            if (aVar.j != null) {
                aVar.j.cancel();
                aVar.j = null;
            }
            if (aVar.i != null) {
                aVar.i.purge();
                aVar.i.cancel();
                aVar.i = null;
            }
            if (aVar.g != null) {
                Bundle bundle = new Bundle(2);
                bundle.putInt("key_float_player_close_position", aVar.g.o());
                if (aVar.s) {
                    aVar.s = aVar.g.t();
                }
                bundle.putBoolean("key_need_play_after_float", aVar.s);
                if (aVar.p != null) {
                    bundle.putSerializable("KEY_FLOAT_PLAYER_SubtitleManifest", aVar.p);
                }
                c.a(aVar.b, "float_player_close_action", bundle);
                aVar.a(aVar.g.o(), aVar.g.n());
                aVar.g.i();
            }
            aVar.a(0);
            if (aVar.f != null) {
                aVar.d.removeView(aVar.f);
            }
            if (aVar.q != null) {
                aVar.b.unregisterReceiver(aVar.q);
                aVar.q = null;
            }
            if (aVar.r != null) {
                c.a(aVar.b, aVar.r);
                aVar.r = null;
            }
            if (aVar.l != null) {
                TaskPlayInfo taskPlayInfo = aVar.l;
                if (!(taskPlayInfo == null || taskPlayInfo == null)) {
                    n.a().c(-1);
                }
            }
            a.a = false;
            this.c = null;
        }
        stopForeground(true);
        super.onDestroy();
    }
}
