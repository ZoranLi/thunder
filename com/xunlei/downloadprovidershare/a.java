package com.xunlei.downloadprovidershare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.b.c;
import com.xunlei.downloadprovidershare.b.d;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: InternalShareHelper */
public class a {
    private static a b;
    public LinkedList<SoftReference<b>> a = new LinkedList();

    /* compiled from: InternalShareHelper */
    public interface a {
        void a(boolean z, f fVar);
    }

    /* compiled from: InternalShareHelper */
    private class b {
        public Activity a;
        public ShareOperationType b;
        public f c;
        k d;
        com.xunlei.downloadprovidershare.b.d.b e = new d(this);
        public a f = new g(this);
        public final /* synthetic */ a g;
        private XLWaitingDialog h;
        private n i;

        public b(a aVar, Activity activity, f fVar, k kVar) {
            this.g = aVar;
            this.d = kVar;
            this.c = fVar;
            this.a = activity;
        }

        public final void a(Context context) {
            if (this.h == null) {
                this.h = new XLWaitingDialog(context);
            }
            this.h.show();
        }

        public final boolean a() {
            if (!(this.a == null || this.c == null)) {
                if (this.b != null) {
                    return false;
                }
            }
            return true;
        }

        public final n b() {
            if (this.i == null) {
                this.i = new n();
            }
            return this.i;
        }

        final void c() {
            StringBuilder stringBuilder = new StringBuilder("reset--shareInfo=");
            stringBuilder.append(this.c);
            stringBuilder.append("|size=");
            stringBuilder.append(this.g.a.size());
            if (this.i != null) {
                n.a(this.a);
            }
            this.a = null;
            this.c = null;
            this.b = null;
            this.d = null;
            this.h = null;
            a.a(this.g, this);
        }

        private static String a(f fVar) {
            StringBuilder stringBuilder = new StringBuilder("【");
            stringBuilder.append(fVar.a());
            stringBuilder.append("】");
            stringBuilder.append(fVar.f);
            return stringBuilder.toString();
        }

        static /* synthetic */ void a(b bVar) {
            if (bVar.h != null) {
                bVar.h.dismiss();
            }
        }

        static /* synthetic */ void a(b bVar, Runnable runnable) {
            if (bVar.a != null) {
                bVar.a.runOnUiThread(runnable);
            }
        }

        static /* synthetic */ void a(b bVar, ShareOperationType shareOperationType, f fVar) {
            if (shareOperationType.isPlatformShare()) {
                bVar.b().a(bVar.a, shareOperationType, fVar, bVar.f);
            } else if (shareOperationType == ShareOperationType.SYSTEM_SHARE) {
                shareOperationType = bVar.a;
                fVar = a(fVar);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", fVar);
                intent.setType("text/*");
                shareOperationType.startActivity(Intent.createChooser(intent, "分享到"));
                bVar.c();
            } else if (shareOperationType == ShareOperationType.COPY_URL) {
                ClipboardUtil.copyToClipboardWithToast(bVar.a, a(fVar));
                bVar.c();
            } else {
                if (shareOperationType == ShareOperationType.XL_ID) {
                    shareOperationType = bVar.a;
                    CharSequence charSequence = fVar.k;
                    XLAlertDialog xLAlertDialog = new XLAlertDialog(shareOperationType);
                    xLAlertDialog.setTitle((CharSequence) "迅雷ID");
                    xLAlertDialog.setMessage(charSequence);
                    xLAlertDialog.setConfirmButtonText((CharSequence) "复制");
                    xLAlertDialog.setOnClickConfirmButtonListener(new h(bVar, xLAlertDialog, shareOperationType, charSequence));
                    xLAlertDialog.setCancelButtonText((CharSequence) "关闭");
                    xLAlertDialog.setOnClickCancelButtonListener(new i(bVar, xLAlertDialog));
                    xLAlertDialog.show();
                    bVar.c();
                }
            }
        }
    }

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public final d a(Activity activity, int i, f fVar, k kVar, c cVar, c cVar2) {
        StringBuilder stringBuilder = new StringBuilder("start share--activity=");
        stringBuilder.append(activity);
        stringBuilder.append("|shareInfo=");
        stringBuilder.append(fVar);
        stringBuilder.append("|size=");
        stringBuilder.append(this.a.size());
        b bVar = new b(this, activity, fVar, kVar);
        this.a.addFirst(new SoftReference(bVar));
        if (i < 0) {
            i = 1;
        }
        kVar = new d(activity, i, cVar, cVar2);
        kVar.b = bVar.e;
        kVar.show();
        fVar.a(kVar);
        return kVar;
    }

    static /* synthetic */ void a(a aVar, b bVar) {
        Iterator it = aVar.a.iterator();
        while (it.hasNext()) {
            SoftReference softReference = (SoftReference) it.next();
            if (((b) softReference.get()) == bVar) {
                aVar.a.remove(softReference);
                return;
            }
        }
    }
}
