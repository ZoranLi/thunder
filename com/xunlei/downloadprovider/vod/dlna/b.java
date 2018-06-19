package com.xunlei.downloadprovider.vod.dlna;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.downloadprovider.vod.dlna.OnDLNADialogListener.MediaPlayerPlayCMD;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DLNAListDialog */
public class b implements OnClickListener {
    private static final String j = "b";
    private b A;
    private TextView B;
    private TextView C;
    private TextView D;
    private BroadcastReceiver E = null;
    private BroadcastReceiver F = null;
    private BroadcastReceiver G = null;
    private BroadcastReceiver H = null;
    private BroadcastReceiver I = null;
    private BroadcastReceiver J = null;
    private BroadcastReceiver K = null;
    private BroadcastReceiver L = null;
    private BroadcastReceiver M = null;
    private BroadcastReceiver N = null;
    public View a;
    public boolean b = false;
    public Activity c;
    public int d;
    public List<s> e;
    public MediaPlayerPlayCMD f;
    public String g;
    public String h;
    public Dialog i;
    private int k;
    private View l;
    private Button m;
    private r n;
    private boolean o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private OnDLNADialogListener t;
    private ListView u;
    private Handler v = new a(this, Looper.getMainLooper());
    private TextView w;
    private ProgressBar x;
    private ProgressBar y;
    private RelativeLayout z;

    /* compiled from: DLNAListDialog */
    class a extends Handler {
        final /* synthetic */ b a;

        public a(b bVar, Looper looper) {
            this.a = bVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            int i2 = 0;
            if (i != 1) {
                switch (i) {
                    case 3:
                        this.a.v.obtainMessage(4, 2000, 0).sendToTarget();
                        this.a.d();
                        return;
                    case 4:
                        switch (message.arg1) {
                            case 2000:
                                this.a.w.setVisibility(0);
                                this.a.z.setVisibility(8);
                                this.a.u.setVisibility(8);
                                return;
                            case PushResult.OFFLINE_DOWNLOAD_DONE /*2001*/:
                                this.a.w.setVisibility(8);
                                this.a.z.setVisibility(0);
                                this.a.u.setVisibility(8);
                                return;
                            case PushResult.UNFINISH_DOWNLOAD_NOTICE /*2002*/:
                                this.a.w.setVisibility(8);
                                this.a.z.setVisibility(8);
                                this.a.u.setVisibility(0);
                                return;
                            default:
                                return;
                        }
                    case 5:
                        switch (message.arg1) {
                            case 3000:
                                this.a.x.setVisibility(0);
                                this.a.r.setVisibility(8);
                                this.a.q.setVisibility(8);
                                this.a.D.setText(R.string.tv_show_dlna_connecting_state);
                                return;
                            case 3001:
                                this.a.x.setVisibility(8);
                                this.a.r.setVisibility(0);
                                this.a.q.setVisibility(8);
                                this.a.D.setText(R.string.tv_show_dlna_connected_success_state);
                                if (a.a().b() != null) {
                                    try {
                                        a.a().b().f();
                                    } catch (Message message2) {
                                        message2.printStackTrace();
                                    }
                                }
                                b.x(this.a);
                                return;
                            case 3002:
                                this.a.x.setVisibility(8);
                                this.a.r.setVisibility(8);
                                this.a.q.setVisibility(0);
                                this.a.D.setText(R.string.tv_show_dlna_connected_fail_state);
                                if (message2.arg2 == 0 || message2.arg2 == 1 || message2.arg2 == 2) {
                                    this.a.e();
                                    return;
                                }
                            default:
                                return;
                        }
                    default:
                        break;
                }
            } else if (this.a.b == null && this.a.d > null) {
                if (a.a().b() != null) {
                    try {
                        message2 = a.a().b().e();
                    } catch (Message message22) {
                        message22.printStackTrace();
                    }
                    if (message22 > null) {
                        i2 = message22 / 1000;
                    }
                    message22 = this.a.d / 1000;
                    this.a.k = this.a.k + 1;
                    if (this.a.k != 1) {
                        if (i2 != message22) {
                            if (a.a().b() != null) {
                                try {
                                    a.a().b().a(message22 * 1000);
                                } catch (Message message222) {
                                    message222.printStackTrace();
                                }
                            }
                            sendEmptyMessageDelayed(1, 1000);
                        }
                    } else if ((i2 > message222 + 3 || i2 < message222 - 3) && this.a.k <= 3) {
                        if (a.a().b() != null) {
                            try {
                                a.a().b().a(message222 * 1000);
                            } catch (Message message2222) {
                                message2222.printStackTrace();
                            }
                        }
                        sendEmptyMessageDelayed(1, 1000);
                    }
                }
                message2222 = null;
                if (message2222 > null) {
                    i2 = message2222 / 1000;
                }
                message2222 = this.a.d / 1000;
                this.a.k = this.a.k + 1;
                if (this.a.k != 1) {
                    if (a.a().b() != null) {
                        a.a().b().a(message2222 * 1000);
                    }
                    sendEmptyMessageDelayed(1, 1000);
                } else if (i2 != message2222) {
                    if (a.a().b() != null) {
                        a.a().b().a(message2222 * 1000);
                    }
                    sendEmptyMessageDelayed(1, 1000);
                }
            }
        }
    }

    /* compiled from: DLNAListDialog */
    class b implements Runnable {
        boolean a = false;
        final /* synthetic */ b b;
        private int c = 0;

        b(b bVar) {
            this.b = bVar;
        }

        public final void run() {
            if (!(this.a || this.b.b)) {
                int i = this.c;
                this.c = i + 1;
                if (i <= 15) {
                    if (this.b.e.size() <= 0) {
                        this.b.v.postDelayed(this, 1000);
                    } else {
                        this.b.d();
                    }
                } else if (this.b.e.size() == 0) {
                    this.b.v.sendEmptyMessage(3);
                }
            }
        }
    }

    public b(Activity activity, OnDLNADialogListener onDLNADialogListener) {
        this.c = activity;
        this.e = new ArrayList();
        this.t = onDLNADialogListener;
        activity = LayoutInflater.from(this.c);
        this.a = activity.inflate(R.layout.dlna_search_result_list_view, null);
        this.p = (ImageView) this.a.findViewById(R.id.dlna_dialog_close_btn);
        this.s = (ImageView) this.a.findViewById(R.id.dlna_dialog_refresh_btn);
        this.u = (ListView) this.a.findViewById(R.id.lv_target_device_list);
        this.w = (TextView) this.a.findViewById(R.id.tv_no_target_device_text);
        this.z = (RelativeLayout) this.a.findViewById(R.id.rl_searching_target_device);
        ProgressBar progressBar = (ProgressBar) this.a.findViewById(R.id.pb_dlna_search_view_circle);
        this.y = progressBar;
        progressBar.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.vod_notify_show));
        this.l = activity.inflate(R.layout.dlna_search_result_deliver, null);
        this.r = (ImageView) this.l.findViewById(R.id.iv_dlna_connected_success);
        this.q = (ImageView) this.l.findViewById(R.id.iv_dlna_connected_fail);
        ProgressBar progressBar2 = (ProgressBar) this.l.findViewById(R.id.pb_dlna_connect_view_circle);
        this.x = progressBar2;
        progressBar2.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.vod_notify_show));
        this.D = (TextView) this.l.findViewById(R.id.tv_show_dlna_connect_state);
        this.B = (TextView) this.l.findViewById(R.id.tv_dlna_device_name);
        TextView textView = (TextView) this.l.findViewById(R.id.tv_dlna_resource_name);
        this.C = textView;
        textView.setMaxLines(1);
        this.m = (Button) this.l.findViewById(R.id.btn_back_to_phone_play);
        this.n = new r(this.c);
        this.u.setAdapter(this.n);
        this.i = new Dialog(this.c, 16974132);
        this.i.setOwnerActivity(this.c);
        this.i.setContentView(this.a);
        this.i.setCanceledOnTouchOutside(false);
        this.i.setOnKeyListener(new f(this));
        activity = this.i.getWindow().getAttributes();
        activity.alpha = 0.7f;
        activity.gravity = 17;
        activity.width = DipPixelUtil.dip2px(250.0f);
        activity.height = DipPixelUtil.dip2px(147.0f);
        this.i.getWindow().setAttributes(activity);
        this.i.getWindow().setBackgroundDrawableResource(17170445);
        this.u.setOnItemClickListener(new g(this));
        this.p.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.m.setOnClickListener(this);
    }

    private static s b(List<s> list, int i) {
        for (s sVar : list) {
            if (sVar.a == i) {
                break;
            }
        }
        s sVar2 = null;
        if (sVar2 != null) {
            list.remove(sVar2);
        }
        return sVar2;
    }

    public final void a() {
        if (this.e != null) {
            this.e.clear();
        }
        r rVar = this.n;
        if (!(rVar.a == null || rVar.a.isEmpty())) {
            rVar.a.clear();
            rVar.notifyDataSetChanged();
        }
        this.v.obtainMessage(4, PushResult.OFFLINE_DOWNLOAD_DONE, 0).sendToTarget();
        if (this.e.size() > 0) {
            this.v.postDelayed(new h(this), 1000);
            return;
        }
        if (this.A != null) {
            this.A.a = true;
        }
        this.A = new b(this);
        this.v.postDelayed(this.A, 1000);
    }

    public final synchronized void b() {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.c);
        IntentFilter intentFilter = new IntentFilter("Action_DLNA_RegistryListener_RemoteDeviceAdded");
        if (this.E == null) {
            this.E = new c(this);
            instance.registerReceiver(this.E, intentFilter);
        }
        if (this.F == null) {
            this.F = new j(this);
            instance.registerReceiver(this.F, new IntentFilter("Action_DLNA_RegistryListener_RemoteDeviceDiscoveryFailed"));
        }
        if (this.G == null) {
            this.G = new k(this);
            instance.registerReceiver(this.G, new IntentFilter("Action_DLNA_RegistryListener_RemoteDeviceDiscoveryStarted"));
        }
        if (this.H == null) {
            this.H = new l(this);
            instance.registerReceiver(this.H, new IntentFilter("Action_DLNA_RegistryListener_RemoteDeviceRemoved"));
        }
        if (a.a().b() != null) {
            try {
                a.a().b().a();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final synchronized void c() {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.c);
        if (this.E != null) {
            instance.unregisterReceiver(this.E);
            this.E = null;
        }
        if (this.F != null) {
            instance.unregisterReceiver(this.F);
            this.F = null;
        }
        if (this.G != null) {
            instance.unregisterReceiver(this.G);
            this.G = null;
        }
        if (this.H != null) {
            instance.unregisterReceiver(this.H);
            this.H = null;
        }
        if (this.I != null) {
            instance.unregisterReceiver(this.I);
            this.I = null;
        }
        if (this.J != null) {
            instance.unregisterReceiver(this.J);
            this.J = null;
        }
        if (this.K != null) {
            instance.unregisterReceiver(this.K);
            this.K = null;
        }
        if (this.L != null) {
            instance.unregisterReceiver(this.L);
            this.L = null;
        }
        if (this.M != null) {
            instance.unregisterReceiver(this.M);
            this.M = null;
        }
        if (this.N != null) {
            instance.unregisterReceiver(this.N);
            this.N = null;
        }
        if (a.a().b() != null) {
            try {
                a.a().b().b();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void d() {
        if (this.A != null) {
            this.A.a = true;
            this.A = null;
        }
    }

    public final void e() {
        this.v.removeMessages(1);
        this.k = 0;
        this.v.sendEmptyMessage(2);
    }

    public final void f() {
        d();
        if (this.i != null && this.i.isShowing() && !this.c.isFinishing()) {
            this.d = 0;
            this.i.dismiss();
            if (this.t != null) {
                this.t.a();
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.dlna_dialog_close_btn) {
            f();
        } else if (view.getId() == R.id.dlna_dialog_refresh_btn) {
            a();
            if (a.a().b() != null) {
                try {
                    a.a().b().c();
                } catch (View view2) {
                    view2.printStackTrace();
                }
            }
        } else {
            if (view2.getId() == R.id.btn_back_to_phone_play) {
                f();
            }
        }
    }

    static /* synthetic */ void a(b bVar, s sVar) {
        int i;
        for (s sVar2 : bVar.e) {
            if (sVar2.a == sVar.a) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            bVar.e.add(sVar);
            bVar.v.post(new m(bVar));
            bVar.n.a(bVar.e);
            if (bVar.n.getCount() > null) {
                bVar.v.obtainMessage(4, PushResult.UNFINISH_DOWNLOAD_NOTICE, 0).sendToTarget();
                return;
            }
        }
        bVar.n.a(bVar.e);
    }

    static /* synthetic */ void a(b bVar, int i) {
        if (b(bVar.e, i) != 0) {
            bVar.v.post(new i(bVar));
            bVar.n.a(bVar.e);
        }
    }

    static /* synthetic */ void a(b bVar, int i, String str) {
        if (a.a().b() != null) {
            try {
                a.a().b().a(i, str);
            } catch (int i2) {
                i2.printStackTrace();
            }
            i2 = LocalBroadcastManager.getInstance(bVar.c);
            if (bVar.I == null) {
                bVar.I = new n(bVar);
                i2.registerReceiver(bVar.I, new IntentFilter("Action_DLNA_PlayerCallback_OnCompletion"));
            }
            if (bVar.J == null) {
                bVar.J = new o(bVar);
                i2.registerReceiver(bVar.J, new IntentFilter("Action_DLNA_PlayerCallback_OnError"));
            }
            if (bVar.K == null) {
                bVar.K = new p(bVar);
                i2.registerReceiver(bVar.K, new IntentFilter("Action_DLNA_PlayerCallback_OnInfo"));
            }
            if (bVar.L == null) {
                bVar.L = new q(bVar);
                i2.registerReceiver(bVar.L, new IntentFilter("Action_DLNA_PlayerCallback_OnPrepared"));
            }
            if (bVar.M == null) {
                bVar.M = new d(bVar);
                i2.registerReceiver(bVar.M, new IntentFilter("Action_DLNA_PlayerCallback_OnPreparing"));
            }
            if (bVar.N == null) {
                bVar.N = new e(bVar);
                i2.registerReceiver(bVar.N, new IntentFilter("Action_DLNA_PlayerCallback_OnSeekResult"));
            }
        }
    }

    static /* synthetic */ void x(b bVar) {
        bVar.v.removeMessages(2);
        bVar.k = 0;
        bVar.v.sendEmptyMessageDelayed(1, 1000);
    }
}
