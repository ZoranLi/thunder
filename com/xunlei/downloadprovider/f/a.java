package com.xunlei.downloadprovider.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.umeng.socialize.UMShareAPI;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.b.c;
import com.xunlei.downloadprovidershare.b.d;
import com.xunlei.downloadprovidershare.k;
import com.xunlei.downloadprovidershare.n;
import com.xunlei.xllib.android.b;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ShareHelper */
public class a {
    private static a a;

    public static String a(int i) {
        String str = "";
        switch (i) {
            case 0:
                return "success";
            case 1:
                return "fail";
            case 2:
                return "cancel";
            default:
                return str;
        }
    }

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public static d a(Activity activity, f fVar, k kVar, c cVar) {
        if (b.a(activity)) {
            c cVar2;
            if (cVar != null) {
                if (cVar.a.isEmpty()) {
                }
                cVar2 = cVar;
                return com.xunlei.downloadprovidershare.a.a().a(activity, 1, fVar, kVar, com.xunlei.downloadprovidershare.b.a.a(), cVar2);
            }
            cVar = com.xunlei.downloadprovidershare.b.a.b();
            cVar2 = cVar;
            return com.xunlei.downloadprovidershare.a.a().a(activity, 1, fVar, kVar, com.xunlei.downloadprovidershare.b.a.a(), cVar2);
        }
        XLToast.showToast(activity, "无网络连接");
        return null;
    }

    public static boolean b(Activity activity, f fVar, k kVar, c cVar) {
        return a(activity, fVar, kVar, cVar) != null ? true : null;
    }

    public static boolean a(Activity activity, f fVar, k kVar) {
        return b(activity, fVar, kVar, com.xunlei.downloadprovidershare.b.a.b());
    }

    public static void a(Activity activity, int i, int i2, Intent intent) {
        ArrayList arrayList = new ArrayList(com.xunlei.downloadprovidershare.a.a().a);
        new StringBuilder("  result:  ").append(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) ((SoftReference) it.next()).get();
            new StringBuilder(" for loop result:  ").append(bVar);
            if (bVar != null && bVar.a == activity) {
                boolean a = bVar.a();
                StringBuilder stringBuilder = new StringBuilder("Internal Helper:  onActivityResult : ");
                stringBuilder.append(a);
                stringBuilder.append(" activity: ");
                stringBuilder.append(bVar.a);
                stringBuilder.append("  mShareInfo: ");
                stringBuilder.append(bVar.c);
                stringBuilder.append("  operationType: ");
                stringBuilder.append(bVar.b);
                if (!a) {
                    StringBuilder stringBuilder2 = new StringBuilder("onActivityResult--requestCode=");
                    stringBuilder2.append(i);
                    stringBuilder2.append("|resultCode=");
                    stringBuilder2.append(i2);
                    stringBuilder2.append("|data=");
                    stringBuilder2.append(intent);
                    stringBuilder2.append("|size=");
                    stringBuilder2.append(bVar.g.a.size());
                    n b = bVar.b();
                    Context context = bVar.a;
                    if (bVar.b == ShareOperationType.QQ && i == 10103 && i2 == 0 && intent == null && b.a != null) {
                        b.a.a(0);
                    } else {
                        new StringBuilder(" shareProxy  onSareResult -------  ").append(b.a);
                        UMShareAPI.get(context).onActivityResult(i, i2, intent);
                    }
                }
            }
        }
    }

    public static void a(Activity activity, ShareOperationType shareOperationType, f fVar, k kVar) {
        if (b.a(activity)) {
            com.xunlei.downloadprovidershare.a a = com.xunlei.downloadprovidershare.a.a();
            if (shareOperationType.isPlatformShare()) {
                b bVar = new b(a, activity, fVar, kVar);
                a.a.addFirst(new SoftReference(bVar));
                bVar.b = shareOperationType;
                if (!shareOperationType.isShouldProcessShareUrl()) {
                    bVar.b().a(activity, shareOperationType, fVar, bVar.f);
                } else if (fVar.a(activity, shareOperationType, new com.xunlei.downloadprovidershare.b(bVar, activity, shareOperationType)) != null) {
                    bVar.a((Context) activity);
                }
                if (kVar != null) {
                    kVar.onShareTargetClicked(shareOperationType, bVar.c);
                }
                return;
            }
            fVar = new StringBuilder("direct share operationType ");
            fVar.append(shareOperationType);
            fVar.append(" should be isPlatformShare()");
            throw new IllegalStateException(fVar.toString());
        }
        XLToast.showToast(activity, "无网络连接");
    }
}
