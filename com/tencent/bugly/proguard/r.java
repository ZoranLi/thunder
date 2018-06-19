package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.global.a;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener;
import com.tencent.bugly.beta.ui.g;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;

/* compiled from: BUGLY */
public class r {

    /* compiled from: BUGLY */
    final class AnonymousClass1 implements TinkerListener {
        final /* synthetic */ e a;

        AnonymousClass1(e eVar) {
            this.a = eVar;
        }

        public final void onDownloadSuccess(String str) {
            if (this.a.V != null) {
                this.a.V.onDownloadSuccess(str);
            }
        }

        public final void onDownloadFailure(String str) {
            if (this.a.V != null) {
                this.a.V.onDownloadFailure(str);
            }
        }

        public final void onPatchStart() {
            this.a.ab = true;
            a.a("IS_PATCHING", true);
        }

        public final void onApplySuccess(String str) {
            this.a.ab = false;
            this.a.N = true;
            a.a("IS_PATCHING", false);
            a.a("PatchResult", true);
            StringBuilder stringBuilder = new StringBuilder("Tinker patch success, result: ");
            stringBuilder.append(str);
            an.a(stringBuilder.toString(), new Object[0]);
            if (this.a.W) {
                g.a(new com.tencent.bugly.beta.ui.e(), true);
            }
            if (this.a.V != null) {
                this.a.V.onApplySuccess(str);
            }
        }

        public final void onApplyFailure(String str) {
            this.a.N = false;
            a.a("PatchResult", false);
            a.a("IS_PATCHING", false);
            StringBuilder stringBuilder = new StringBuilder("Tinker patch failure, result: ");
            stringBuilder.append(str);
            an.a(stringBuilder.toString(), new Object[0]);
            if (this.a.V != null) {
                this.a.V.onApplyFailure(str);
            }
        }

        public final void onPatchRollback() {
            an.a("patch rollback callback.", new Object[0]);
            if (this.a.V != null) {
                this.a.V.onPatchRollback();
            }
            if (TinkerManager.getInstance().getPatchDirectory(this.a.s) != null && !TinkerManager.getInstance().getPatchDirectory(this.a.s).exists()) {
                a.a("IS_PATCH_ROLL_BACK", false);
            }
        }
    }

    public static synchronized void a(Context context) {
        Context context2 = context;
        synchronized (r.class) {
            int i;
            try {
                e eVar = e.E;
                String absolutePath = context2.getDir("dex", 0).getAbsolutePath();
                String absolutePath2 = context2.getDir("tmpPatch", 32768).getAbsolutePath();
                eVar.G = new File(absolutePath, TinkerManager.PATCH_NAME);
                if (TextUtils.isEmpty(a.b("PatchFile", ""))) {
                    a.a("PatchFile", eVar.G.getAbsolutePath());
                }
                eVar.H = new File(absolutePath2, "tmpPatch.apk");
                if (eVar.G != null && TextUtils.isEmpty(a.b("PatchFile", ""))) {
                    a.a("PatchFile", eVar.G.getAbsolutePath());
                }
                eVar.I = context2.getDir("tmpPatch", 0);
                if (eVar.I != null && TextUtils.isEmpty(a.b("PatchTmpDir", ""))) {
                    a.a("PatchTmpDir", eVar.G.getAbsolutePath());
                }
                BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) a.a("st.bch", BetaGrayStrategy.CREATOR);
                File file;
                String a;
                StringBuilder stringBuilder;
                File[] listFiles;
                int length;
                int i2;
                int i3;
                File file2;
                String replace;
                StringBuilder stringBuilder2;
                String absolutePath3;
                String b;
                StringBuilder stringBuilder3;
                if (betaGrayStrategy == null || betaGrayStrategy.a == null || betaGrayStrategy.a.p != 3) {
                    if (!(TinkerManager.getInstance().getPatchDirectory(eVar.s) == null || TinkerManager.getInstance().getPatchDirectory(eVar.s).exists())) {
                        a.a("IS_PATCH_ROLL_BACK", false);
                    }
                    if (a.b("IS_PATCH_ROLL_BACK", false)) {
                        TinkerManager.getInstance().onPatchRollback(false);
                    }
                    file = e.E.H;
                    if (file != null && file.exists() && file.delete()) {
                        an.a("[patch] delete tmpPatch.apk success", new Object[0]);
                    }
                    file = e.E.G;
                    if (file != null && file.exists()) {
                        a = ap.a(file, "SHA");
                        if (a != null) {
                            e.E.L = a;
                        }
                    }
                    if (TinkerManager.isTinkerManagerInstalled()) {
                        if (TextUtils.isEmpty(eVar.J)) {
                            eVar.J = TinkerManager.getTinkerId();
                        }
                        stringBuilder = new StringBuilder("TINKER_ID:");
                        stringBuilder.append(eVar.J);
                        an.a(stringBuilder.toString(), new Object[0]);
                        eVar.K = TinkerManager.getNewTinkerId();
                        stringBuilder = new StringBuilder("NEW_TINKER_ID:");
                        stringBuilder.append(eVar.K);
                        an.a(stringBuilder.toString(), new Object[0]);
                        TinkerManager.getInstance().setTinkerListener(new AnonymousClass1(eVar));
                    }
                    if (TextUtils.isEmpty(a.b("BaseArchName", ""))) {
                        a = eVar.s.getApplicationInfo().nativeLibraryDir;
                        if (a != null) {
                            listFiles = new File(a).listFiles();
                            if (listFiles != null && listFiles.length > 0) {
                                length = listFiles.length;
                                i2 = 0;
                                i3 = i2;
                                while (i2 < length) {
                                    file2 = listFiles[i2];
                                    if (file2.getName().endsWith(".so")) {
                                        replace = file2.getName().replace(".so", "");
                                        if (replace.startsWith(ShareConstants.SO_PATH)) {
                                            replace = replace.substring(replace.indexOf(ShareConstants.SO_PATH) + 3);
                                        }
                                        stringBuilder2 = new StringBuilder("libName:");
                                        stringBuilder2.append(replace);
                                        an.a(stringBuilder2.toString(), new Object[0]);
                                        absolutePath3 = file2.getAbsolutePath();
                                        stringBuilder2 = new StringBuilder("soFilePath:");
                                        stringBuilder2.append(absolutePath3);
                                        an.a(stringBuilder2.toString(), new Object[0]);
                                        for (String equals : eVar.Z) {
                                            if (replace.equals(equals)) {
                                                i3 = 1;
                                                break;
                                            }
                                        }
                                        if (i3 == 0) {
                                            b = a.b(absolutePath3);
                                            stringBuilder3 = new StringBuilder("archName:");
                                            stringBuilder3.append(b);
                                            an.a(stringBuilder3.toString(), new Object[0]);
                                            if (b != null && b.equals("armeabi-v5te")) {
                                                b = "armeabi";
                                            }
                                            a.a(replace, b);
                                            if (TextUtils.isEmpty(a.b("BaseArchName", ""))) {
                                                a.a("BaseArchName", b);
                                            }
                                            i3 = 0;
                                        }
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                } else {
                    if (betaGrayStrategy.a.l != null) {
                        eVar.M = (String) betaGrayStrategy.a.l.get("H2");
                        if (!TextUtils.isEmpty(eVar.M)) {
                            ap.b("G15", eVar.M);
                        }
                    }
                    eVar.N = a.b("PatchResult", false);
                    eVar.O = Integer.valueOf(a.b("PATCH_MAX_TIMES", "0")).intValue();
                    if (eVar.N) {
                        an.a("[patch] inject success", new Object[0]);
                        if (!a.b("UPLOAD_PATCH_RESULT", false)) {
                            a.a("UPLOAD_PATCH_RESULT", true);
                            p pVar = p.a;
                            w wVar = r7;
                            w wVar2 = new w("active", System.currentTimeMillis(), (byte) 0, 0, null, betaGrayStrategy.a.m, betaGrayStrategy.a.p, null);
                            if (pVar.a(wVar)) {
                                an.a("save patch success event success!", new Object[0]);
                            } else {
                                an.e("save patch success event failed!", new Object[0]);
                            }
                        }
                    } else {
                        an.a("[patch] inject failure", new Object[0]);
                        if (!a.b("UPLOAD_PATCH_RESULT", false)) {
                            a.a("UPLOAD_PATCH_RESULT", true);
                            p pVar2 = p.a;
                            replace = "active";
                            long currentTimeMillis = System.currentTimeMillis();
                            absolutePath3 = betaGrayStrategy.a.m;
                            i = betaGrayStrategy.a.p;
                            if (i != 0) {
                                an.a("save patch failed event success!", new Object[0]);
                            } else {
                                an.e("save patch failed event failed!", new Object[0]);
                            }
                            if (e.E.G != null && e.E.G.exists() && e.E.G.delete()) {
                                an.a("[patch] delete patch.apk success", new Object[0]);
                            }
                        }
                    }
                    file = e.E.H;
                    an.a("[patch] delete tmpPatch.apk success", new Object[0]);
                    file = e.E.G;
                    a = ap.a(file, "SHA");
                    if (a != null) {
                        e.E.L = a;
                    }
                    if (TinkerManager.isTinkerManagerInstalled()) {
                        if (TextUtils.isEmpty(eVar.J)) {
                            eVar.J = TinkerManager.getTinkerId();
                        }
                        stringBuilder = new StringBuilder("TINKER_ID:");
                        stringBuilder.append(eVar.J);
                        an.a(stringBuilder.toString(), new Object[0]);
                        eVar.K = TinkerManager.getNewTinkerId();
                        stringBuilder = new StringBuilder("NEW_TINKER_ID:");
                        stringBuilder.append(eVar.K);
                        an.a(stringBuilder.toString(), new Object[0]);
                        TinkerManager.getInstance().setTinkerListener(new AnonymousClass1(eVar));
                    }
                    if (TextUtils.isEmpty(a.b("BaseArchName", ""))) {
                        a = eVar.s.getApplicationInfo().nativeLibraryDir;
                        if (a != null) {
                            listFiles = new File(a).listFiles();
                            length = listFiles.length;
                            i2 = 0;
                            i3 = i2;
                            while (i2 < length) {
                                file2 = listFiles[i2];
                                if (file2.getName().endsWith(".so")) {
                                    replace = file2.getName().replace(".so", "");
                                    if (replace.startsWith(ShareConstants.SO_PATH)) {
                                        replace = replace.substring(replace.indexOf(ShareConstants.SO_PATH) + 3);
                                    }
                                    stringBuilder2 = new StringBuilder("libName:");
                                    stringBuilder2.append(replace);
                                    an.a(stringBuilder2.toString(), new Object[0]);
                                    absolutePath3 = file2.getAbsolutePath();
                                    stringBuilder2 = new StringBuilder("soFilePath:");
                                    stringBuilder2.append(absolutePath3);
                                    an.a(stringBuilder2.toString(), new Object[0]);
                                    while (r10.hasNext()) {
                                        if (replace.equals(equals)) {
                                            i3 = 1;
                                            break;
                                        }
                                    }
                                    if (i3 == 0) {
                                        b = a.b(absolutePath3);
                                        stringBuilder3 = new StringBuilder("archName:");
                                        stringBuilder3.append(b);
                                        an.a(stringBuilder3.toString(), new Object[0]);
                                        b = "armeabi";
                                        a.a(replace, b);
                                        if (TextUtils.isEmpty(a.b("BaseArchName", ""))) {
                                            a.a("BaseArchName", b);
                                        }
                                        i3 = 0;
                                    }
                                }
                                i2++;
                            }
                        }
                    }
                }
            } finally {
                i = r0;
            }
        }
    }
}
