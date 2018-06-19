package com.huawei.hms.update.e;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.HuaweiApiAvailability;
import java.lang.ref.WeakReference;

/* compiled from: SilentUpdateWizard */
public class o extends a implements com.huawei.hms.activity.a {
    private WeakReference<Activity> a;
    private BroadcastReceiver b;
    private Handler c = new Handler();
    private b d;
    private boolean e = false;
    private com.huawei.hms.activity.a f;
    private Handler g = new p(this);

    /* compiled from: SilentUpdateWizard */
    private class a implements Runnable {
        final /* synthetic */ o a;

        private a(o oVar) {
            this.a = oVar;
        }

        public void run() {
            this.a.b(14);
        }
    }

    public void a(Activity activity, boolean z) {
        this.a = new WeakReference(activity);
        a(activity);
    }

    private void a(android.app.Activity r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r0 = new android.content.Intent;
        r1 = "com.huawei.appmarket.intent.action.ThirdUpdateAction";
        r0.<init>(r1);
        r1 = "com.huawei.appmarket";
        r0.setPackage(r1);
        r1 = new org.json.JSONArray;
        r1.<init>();
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = "pkgName";	 Catch:{ JSONException -> 0x006d }
        r4 = "com.huawei.hwid";	 Catch:{ JSONException -> 0x006d }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x006d }
        r3 = "versioncode";	 Catch:{ JSONException -> 0x006d }
        r4 = 20502300; // 0x138d71c float:3.3949796E-38 double:1.0129482E-316;	 Catch:{ JSONException -> 0x006d }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x006d }
        r1.put(r2);
        r2 = "params";
        r1 = r1.toString();
        r0.putExtra(r2, r1);
        r1 = "isHmsOrApkUpgrade";
        r2 = 1;
        r0.putExtra(r1, r2);
        r1 = "buttonDlgY";
        r3 = com.huawei.android.hms.base.R.string.hms_install;
        r3 = r7.getString(r3);
        r0.putExtra(r1, r3);
        r1 = "buttonDlgN";
        r3 = com.huawei.android.hms.base.R.string.hms_cancel;
        r3 = r7.getString(r3);
        r0.putExtra(r1, r3);
        r1 = "upgradeDlgContent";
        r3 = com.huawei.android.hms.base.R.string.hms_update_message_new;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r5 = "%P";
        r2[r4] = r5;
        r2 = r7.getString(r3, r2);
        r0.putExtra(r1, r2);
        r1 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r7.startActivityForResult(r0, r1);	 Catch:{ ActivityNotFoundException -> 0x0065 }
        return;
    L_0x0065:
        r7 = "SilentUpdateWizard";
        r0 = "ActivityNotFoundException";
        com.huawei.hms.support.log.a.d(r7, r0);
        return;
    L_0x006d:
        r7 = move-exception;
        r0 = "SilentUpdateWizard";
        r1 = new java.lang.StringBuilder;
        r2 = "create hmsJsonObject fail";
        r1.<init>(r2);
        r7 = r7.getMessage();
        r1.append(r7);
        r7 = r1.toString();
        com.huawei.hms.support.log.a.d(r0, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.e.o.a(android.app.Activity):void");
    }

    public void a() {
        this.a = null;
        this.c.removeCallbacksAndMessages(null);
        e();
        if (this.d != null) {
            this.d.c();
            this.d = null;
        }
        if (!this.e || this.f == null) {
            com.huawei.hms.update.c.a.a(null);
        } else {
            this.f.a();
        }
    }

    public boolean a(int i, int i2, Intent intent) {
        if (this.e && this.f != null) {
            return this.f.a(i, i2, intent);
        }
        if (i != 2000) {
            return false;
        }
        if (i2 == 0) {
            d();
            a(20000);
            return true;
        } else if (i2 == 4) {
            c(13);
            return true;
        } else {
            a(i2, 0);
            a(true);
            return true;
        }
    }

    public void b() {
        if (this.e && this.f != null) {
            this.f.b();
        } else if (this.d != null) {
            Class cls = this.d.getClass();
            this.d.c();
            this.d = null;
            a(cls);
        }
    }

    private void a(boolean z) {
        Activity c = c();
        if (c != null) {
            if (this.f == null) {
                b(c);
            }
            if (this.f != null) {
                this.e = true;
                com.huawei.hms.update.c.a.a(this.f.getClass());
                this.f.a(c, z);
            }
        }
    }

    private void b(Activity activity) {
        activity = activity.getIntent();
        if (activity != null) {
            activity = activity.getStringExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_EX_NAME);
            if (activity != null) {
                try {
                    this.f = (com.huawei.hms.activity.a) Class.forName(activity).asSubclass(com.huawei.hms.activity.a.class).newInstance();
                } catch (Activity activity2) {
                    StringBuilder stringBuilder = new StringBuilder("getBridgeActivityDelegate error");
                    stringBuilder.append(activity2.getMessage());
                    com.huawei.hms.support.log.a.d("SilentUpdateWizard", stringBuilder.toString());
                }
            }
        }
    }

    private void d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.appmarket.service.downloadservice.Receiver");
        intentFilter.addAction("com.huawei.appmarket.service.downloadservice.progress.Receiver");
        intentFilter.addAction("com.huawei.appmarket.service.installerservice.Receiver");
        this.b = new com.huawei.hms.update.d.a(this.g);
        Activity c = c();
        if (c != null) {
            c.registerReceiver(this.b, intentFilter);
        }
    }

    private void e() {
        Activity c = c();
        if (c != null && this.b != null) {
            c.unregisterReceiver(this.b);
            this.b = null;
        }
    }

    void a(b bVar) {
        com.huawei.hms.support.log.a.a("SilentUpdateWizard", "on SilentUpdate cancelled");
    }

    void b(b bVar) {
        com.huawei.hms.support.log.a.a("SilentUpdateWizard", "on SilentUpdate dowork");
    }

    Activity c() {
        if (this.a == null) {
            return null;
        }
        return (Activity) this.a.get();
    }

    private void a(int i) {
        this.c.removeCallbacksAndMessages(null);
        this.c.postDelayed(new a(), (long) i);
    }

    private void b(int i) {
        this.c.removeCallbacksAndMessages(null);
        e();
        if (this.d != null) {
            this.d.c();
            this.d = null;
        }
        a(i, 0);
        a(false);
    }

    private void a(Bundle bundle) {
        Object string = bundle.containsKey("UpgradePkgName") ? bundle.getString("UpgradePkgName") : null;
        if (string != null) {
            if (HuaweiApiAvailability.SERVICES_PACKAGE.equals(string)) {
                if (bundle.containsKey("downloadtask.status")) {
                    int i = bundle.getInt("downloadtask.status");
                    if (!(i == 3 || i == 5 || i == 6)) {
                        if (i != 8) {
                            if (i == 4) {
                                a(60000);
                                return;
                            }
                            a(20000);
                        }
                    }
                    b(i);
                }
            }
        }
    }

    private void b(Bundle bundle) {
        Object string = bundle.containsKey("UpgradePkgName") ? bundle.getString("UpgradePkgName") : null;
        if (string != null) {
            if (HuaweiApiAvailability.SERVICES_PACKAGE.equals(string)) {
                if (bundle.containsKey("UpgradeDownloadProgress") && bundle.containsKey("UpgradeAppName")) {
                    bundle = bundle.getInt("UpgradeDownloadProgress");
                    a(20000);
                    if (bundle >= 99) {
                        bundle = 99;
                    }
                    if (this.d == null) {
                        a(l.class);
                    }
                    if (this.d != null) {
                        ((l) this.d).a(bundle);
                    }
                }
            }
        }
    }

    private void c(Bundle bundle) {
        if (bundle.containsKey("packagename") && bundle.containsKey("status")) {
            String string = bundle.getString("packagename");
            int i = bundle.getInt("status");
            if (string != null) {
                if (HuaweiApiAvailability.SERVICES_PACKAGE.equals(string)) {
                    if (i == 2) {
                        this.c.removeCallbacksAndMessages(null);
                        if (this.d != null) {
                            ((l) this.d).a(100);
                        }
                        c((int) null);
                        return;
                    }
                    if (i != -1) {
                        if (i != -2) {
                            a(60000);
                        }
                    }
                    b(i);
                }
            }
        }
    }

    private void a(Class<? extends b> cls) {
        try {
            b bVar = (b) cls.newInstance();
            bVar.a((a) this);
            this.d = bVar;
        } catch (Class<? extends b> cls2) {
            StringBuilder stringBuilder = new StringBuilder("In showDialog, Failed to show the dialog.");
            stringBuilder.append(cls2.getMessage());
            com.huawei.hms.support.log.a.d("SilentUpdateWizard", stringBuilder.toString());
        }
    }

    private void c(int i) {
        Activity c = c();
        if (c != null) {
            if (!c.isFinishing()) {
                a(i, 0);
                Intent intent = new Intent();
                intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, getClass().getName());
                intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
                c.setResult(-1, intent);
                c.finish();
            }
        }
    }

    public void a(int i, KeyEvent keyEvent) {
        if (this.e && this.f != null) {
            this.f.a(i, keyEvent);
        }
    }
}
