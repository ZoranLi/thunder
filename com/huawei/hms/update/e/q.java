package com.huawei.hms.update.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import com.alibaba.wireless.security.SecExceptionCode;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.a;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.c.e;
import com.huawei.hms.c.g;
import com.huawei.hms.update.a.a.b;
import com.huawei.hms.update.a.a.c;
import com.huawei.hms.update.a.a.d;
import com.huawei.hms.update.a.f;
import com.huawei.hms.update.a.i;
import com.huawei.hms.update.provider.UpdateProvider;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: UpdateWizard */
public class q extends a implements a, b {
    private WeakReference<Activity> a;
    private com.huawei.hms.update.a.a.a b;
    private b c;
    private c d;
    private int e = -1;

    public void a(Activity activity, boolean z) {
        this.a = new WeakReference(activity);
        if (z) {
            a(i.class);
        } else {
            e();
        }
    }

    public void a() {
        g();
        j();
        com.huawei.hms.update.c.a.a(null);
        this.a = null;
    }

    public int d() {
        if (this.e == 1) {
            return PushResult.OFFLINE_DOWNLOAD_DONE;
        }
        if (this.e == 2) {
            return PushResult.UNFINISH_DOWNLOAD_NOTICE;
        }
        if (this.e == 3) {
            return PushResult.UNPLAY_NOTICE;
        }
        return PushResult.OFFLINE_DOWNLOAD_DONE;
    }

    public boolean a(int i, int i2, Intent intent) {
        Activity c = c();
        if (c != 0) {
            if (!c.isFinishing()) {
                if (this.e == 1 && i == PushResult.OFFLINE_DOWNLOAD_DONE) {
                    if (a(c) != 0) {
                        a(0);
                    } else {
                        a(8);
                    }
                    return true;
                } else if (this.e == 2 && i == PushResult.UNFINISH_DOWNLOAD_NOTICE) {
                    if (a(c) != 0) {
                        a(0);
                    } else {
                        a(8, this.e);
                        b(c);
                    }
                    return true;
                } else if (this.e != 3 || i != PushResult.UNPLAY_NOTICE) {
                    return false;
                } else {
                    if (a(c) != 0) {
                        a(0);
                    } else {
                        a(8);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(Activity activity) {
        return new e(activity).b(HuaweiApiAvailability.SERVICES_PACKAGE) >= 20502300 ? true : null;
    }

    public void b() {
        if (this.c != null) {
            Class cls = this.c.getClass();
            this.c.c();
            this.c = null;
            a(cls);
        }
    }

    public void a(int i, c cVar) {
        if (com.huawei.hms.support.log.a.a()) {
            StringBuilder stringBuilder = new StringBuilder("Enter onCheckUpdate, status: ");
            stringBuilder.append(d.a(i));
            com.huawei.hms.support.log.a.a("UpdateWizard", stringBuilder.toString());
        }
        if (i == 1000) {
            this.d = cVar;
            a(h.class);
            i();
        } else if (i != SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_PARAM) {
            switch (i) {
                case 1201:
                case 1202:
                case 1203:
                    a(m.b.class);
                    break;
                default:
                    break;
            }
        }
    }

    public void a(int i, int i2, int i3, File file) {
        if (com.huawei.hms.support.log.a.a()) {
            StringBuilder stringBuilder = new StringBuilder("Enter onDownloadPackage, status: ");
            stringBuilder.append(d.a(i));
            stringBuilder.append(", reveived: ");
            stringBuilder.append(i2);
            stringBuilder.append(", total: ");
            stringBuilder.append(i3);
            com.huawei.hms.support.log.a.a("UpdateWizard", stringBuilder.toString());
        }
        if (i != 2000) {
            switch (i) {
                case 2100:
                    if (!(this.c == 0 || (this.c instanceof h) == 0)) {
                        ((h) this.c).a(i2, i3);
                        return;
                    }
                case 2101:
                    return;
                default:
                    switch (i) {
                        case 2201:
                            if (!(this.d == 0 || this.b == 0)) {
                                this.d.c(this.b.a());
                            }
                            a(m.c.class);
                            return;
                        case 2202:
                            a(e.b.class);
                            break;
                        case 2203:
                        case 2204:
                            a(m.d.class);
                            return;
                        default:
                            break;
                    }
            }
            return;
        }
        g();
        if (file == null) {
            a(8);
        } else {
            a(file);
        }
    }

    private void a(File file) {
        Context c = c();
        if (c != null) {
            if (!c.isFinishing()) {
                if (new e(c).a(file.toString(), HuaweiApiAvailability.SERVICES_PACKAGE, HuaweiApiAvailability.SERVICES_SIGNATURE)) {
                    file = a(c, file);
                    if (file == null) {
                        com.huawei.hms.support.log.a.d("UpdateWizard", "In startInstaller, Failed to creates a Uri from a file.");
                        a(8);
                        return;
                    }
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(file, ApkHelper.MIME_TYPE_APK);
                    intent.setFlags(3);
                    try {
                        c.startActivityForResult(intent, d());
                        return;
                    } catch (File file2) {
                        StringBuilder stringBuilder = new StringBuilder("In startInstaller, Failed to start package installer.");
                        stringBuilder.append(file2.getMessage());
                        com.huawei.hms.support.log.a.d("UpdateWizard", stringBuilder.toString());
                        a(8);
                        return;
                    }
                }
                com.huawei.hms.support.log.a.d("UpdateWizard", "In startInstaller, Failed to verify package archive.");
                a(8);
            }
        }
    }

    private static Uri a(Context context, File file) {
        e eVar = new e(context);
        String packageName = context.getPackageName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageName);
        stringBuilder.append(UpdateProvider.AUTHORITIES_SUFFIX);
        String stringBuilder2 = stringBuilder.toString();
        Object obj = 1;
        if (VERSION.SDK_INT > 23) {
            if (context.getApplicationInfo().targetSdkVersion <= 23) {
                if (eVar.a(packageName, stringBuilder2)) {
                }
            }
            if (obj == null) {
                return UpdateProvider.getUriForFile(context, stringBuilder2, file);
            }
            return Uri.fromFile(file);
        }
        obj = null;
        if (obj == null) {
            return Uri.fromFile(file);
        }
        return UpdateProvider.getUriForFile(context, stringBuilder2, file);
    }

    Activity c() {
        if (this.a == null) {
            return null;
        }
        return (Activity) this.a.get();
    }

    void a(b bVar) {
        com.huawei.hms.support.log.a.b("UpdateWizard", "Enter onCancel.");
        if (bVar instanceof i) {
            if (g.a() != null) {
                this.e = 1;
            } else {
                this.e = 2;
            }
            a(13);
        } else if (bVar instanceof d) {
            j();
            a(13);
        } else if (bVar instanceof h) {
            j();
            a(e.c.class);
        } else if (bVar instanceof e.c) {
            a(h.class);
            i();
        } else {
            if ((bVar instanceof e.b) != null) {
                a(13);
            }
        }
    }

    void b(b bVar) {
        com.huawei.hms.support.log.a.b("UpdateWizard", "Enter onDoWork.");
        if (bVar instanceof i) {
            bVar.c();
            e();
        } else if (bVar instanceof e.c) {
            bVar.c();
            a(13);
        } else if (bVar instanceof e.b) {
            a(h.class);
            i();
        } else if (bVar instanceof m.b) {
            a(8);
        } else if (bVar instanceof m.c) {
            a(8);
        } else {
            if ((bVar instanceof m.d) != null) {
                a(8);
            }
        }
    }

    private void e() {
        if (g.a()) {
            this.e = 1;
            a(d.class);
            h();
            return;
        }
        f();
    }

    private void f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 2;
        r4.e = r0;
        r0 = r4.c();
        if (r0 == 0) goto L_0x0032;
    L_0x0009:
        r1 = r0.isFinishing();
        if (r1 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0032;
    L_0x0010:
        r1 = "market://details?id=com.huawei.hwid";	 Catch:{ ActivityNotFoundException -> 0x002a }
        r1 = android.net.Uri.parse(r1);	 Catch:{ ActivityNotFoundException -> 0x002a }
        r2 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x002a }
        r3 = "android.intent.action.VIEW";	 Catch:{ ActivityNotFoundException -> 0x002a }
        r2.<init>(r3, r1);	 Catch:{ ActivityNotFoundException -> 0x002a }
        r1 = "com.android.vending";	 Catch:{ ActivityNotFoundException -> 0x002a }
        r2.setPackage(r1);	 Catch:{ ActivityNotFoundException -> 0x002a }
        r1 = r4.d();	 Catch:{ ActivityNotFoundException -> 0x002a }
        r0.startActivityForResult(r2, r1);	 Catch:{ ActivityNotFoundException -> 0x002a }
        return;
    L_0x002a:
        r0 = "UpdateWizard";
        r1 = "can not open google play";
        com.huawei.hms.support.log.a.d(r0, r1);
        return;
    L_0x0032:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.e.q.f():void");
    }

    private void b(android.app.Activity r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 3;
        r3.e = r0;
        r0 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r1 = "android.intent.action.VIEW";	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r2 = "https://play.google.com/store/apps/details?id=com.huawei.hwid";	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r2 = android.net.Uri.parse(r2);	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r0.<init>(r1, r2);	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r1 = r3.d();	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r4.startActivityForResult(r0, r1);	 Catch:{ ActivityNotFoundException -> 0x0018 }
        return;
    L_0x0018:
        r4 = "UpdateWizard";
        r0 = "can not find web to hold update hms apk";
        com.huawei.hms.support.log.a.d(r4, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.e.q.b(android.app.Activity):void");
    }

    private void a(Class<? extends b> cls) {
        g();
        try {
            b bVar = (b) cls.newInstance();
            bVar.a((a) this);
            this.c = bVar;
        } catch (Class<? extends b> cls2) {
            StringBuilder stringBuilder = new StringBuilder("In showDialog, Failed to show the dialog.");
            stringBuilder.append(cls2.getMessage());
            com.huawei.hms.support.log.a.d("UpdateWizard", stringBuilder.toString());
        }
    }

    private void g() {
        if (this.c != null) {
            try {
                this.c.c();
                this.c = null;
            } catch (IllegalStateException e) {
                StringBuilder stringBuilder = new StringBuilder("In dismissDialog, Failed to dismiss the dialog.");
                stringBuilder.append(e.getMessage());
                com.huawei.hms.support.log.a.d("UpdateWizard", stringBuilder.toString());
            }
        }
    }

    private void h() {
        this.d = null;
        Context c = c();
        if (c != null) {
            if (!c.isFinishing()) {
                j();
                this.b = new i(new com.huawei.hms.update.a.e(c));
                this.b.a(this);
            }
        }
    }

    private void i() {
        Context c = c();
        if (c != null) {
            if (!c.isFinishing()) {
                j();
                this.b = new i(new f(c));
                this.b.a(this, this.d);
            }
        }
    }

    private void j() {
        if (this.b != null) {
            this.b.b();
            this.b = null;
        }
    }

    private void a(int i) {
        Activity c = c();
        if (c != null) {
            if (!c.isFinishing()) {
                a(i, this.e);
                Intent intent = new Intent();
                intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, getClass().getName());
                intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
                c.setResult(-1, intent);
                c.finish();
            }
        }
    }

    public void a(int i, KeyEvent keyEvent) {
        if (4 == i) {
            com.huawei.hms.support.log.a.b("UpdateWizard", "In onKeyUp, Call finish.");
            i = c();
            if (i != 0 && i.isFinishing() == null) {
                i.setResult(null, null);
                i.finish();
            }
        }
    }
}
