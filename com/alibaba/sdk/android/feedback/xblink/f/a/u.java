package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.View.OnClickListener;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.util.j;
import com.alibaba.sdk.android.feedback.util.n;
import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;
import com.alibaba.sdk.android.feedback.xblink.f.m;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.xunlei.download.Downloads.Impl;
import java.io.File;

public class u extends a {
    private long d = 0;
    private b e = null;
    private String f = null;
    private com.alibaba.sdk.android.feedback.xblink.view.a g;
    private String[] h = new String[]{"拍摄一张照片", "从相册选取"};
    private OnClickListener i = new x(this);

    private void a(int i, Intent intent) {
        if (i == 0) {
            if (FeedbackAPI.customWebviewFragment != null) {
                FeedbackAPI.customWebviewFragment.startActivityForResult(intent, CONFIGID.RECORD_WIDTH);
            } else if (this.a instanceof Activity) {
                ((Activity) this.a).startActivityForResult(intent, CONFIGID.RECORD_WIDTH);
            }
        } else if (i == 1) {
            if (FeedbackAPI.customWebviewFragment != null) {
                FeedbackAPI.customWebviewFragment.startActivityForResult(intent, CONFIGID.RECORD_HEIGHT);
            } else if (this.a instanceof Activity) {
                ((Activity) this.a).startActivityForResult(intent, CONFIGID.RECORD_HEIGHT);
            }
        }
    }

    private void a(java.lang.String r3, java.lang.String r4) {
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
        r2 = this;
        r4 = com.alibaba.sdk.android.feedback.xblink.i.d.a(r3);
        r0 = r2.a;
        r0 = r0.getResources();
        r0 = r0.getDisplayMetrics();
        r0 = r0.heightPixels;
        r3 = com.alibaba.sdk.android.feedback.xblink.i.d.a(r3, r0);
        if (r3 == 0) goto L_0x006d;
    L_0x0016:
        r3 = com.alibaba.sdk.android.feedback.xblink.i.d.a(r3, r4);
        r4 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Exception -> 0x005a }
        r4 = com.alibaba.sdk.android.feedback.xblink.i.d.a(r3, r4);	 Catch:{ Exception -> 0x005a }
        if (r4 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x005a }
    L_0x0022:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005a }
        r1 = "photo size:";	 Catch:{ Exception -> 0x005a }
        r0.<init>(r1);	 Catch:{ Exception -> 0x005a }
        r1 = r4.length;	 Catch:{ Exception -> 0x005a }
        r0.append(r1);	 Catch:{ Exception -> 0x005a }
    L_0x002d:
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x005a }
        r1 = 0;	 Catch:{ Exception -> 0x005a }
        r4 = android.util.Base64.encode(r4, r1);	 Catch:{ Exception -> 0x005a }
        r0.<init>(r4);	 Catch:{ Exception -> 0x005a }
        r4 = "[\r|\n]";	 Catch:{ Exception -> 0x005a }
        r1 = "";	 Catch:{ Exception -> 0x005a }
        r4 = r0.replaceAll(r4, r1);	 Catch:{ Exception -> 0x005a }
        r0 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ Exception -> 0x005a }
        r0.<init>();	 Catch:{ Exception -> 0x005a }
        r1 = "imageData";	 Catch:{ Exception -> 0x005a }
        r0.a(r1, r4);	 Catch:{ Exception -> 0x005a }
        r4 = r2.e;	 Catch:{ Exception -> 0x005a }
        if (r4 == 0) goto L_0x0052;	 Catch:{ Exception -> 0x005a }
    L_0x004d:
        r4 = r2.e;	 Catch:{ Exception -> 0x005a }
        r4.a(r0);	 Catch:{ Exception -> 0x005a }
    L_0x0052:
        if (r3 == 0) goto L_0x0057;
    L_0x0054:
        r3.recycle();
    L_0x0057:
        return;
    L_0x0058:
        r4 = move-exception;
        goto L_0x0067;
    L_0x005a:
        r4 = "WXPhoto";	 Catch:{ all -> 0x0058 }
        r0 = "write photo io error.";	 Catch:{ all -> 0x0058 }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r4, r0);	 Catch:{ all -> 0x0058 }
        if (r3 == 0) goto L_0x006d;
    L_0x0063:
        r3.recycle();
        goto L_0x006d;
    L_0x0067:
        if (r3 == 0) goto L_0x006c;
    L_0x0069:
        r3.recycle();
    L_0x006c:
        throw r4;
    L_0x006d:
        r3 = r2.e;
        if (r3 == 0) goto L_0x0078;
    L_0x0071:
        r3 = r2.e;
        r4 = "unknown error";
        r3.b(r4);
    L_0x0078:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.u.a(java.lang.String, java.lang.String):void");
    }

    private boolean d() {
        if (this.a == null) {
            return false;
        }
        return this.a.getPackageManager().checkPermission("android.permission.CAMERA", this.a.getPackageName()) == 0;
    }

    public void a(int i, int i2, Intent intent) {
        if (g.a()) {
            StringBuilder stringBuilder = new StringBuilder("takePhoto callback, requestCode: ");
            stringBuilder.append(i);
            stringBuilder.append(";resultCode: ");
            stringBuilder.append(i2);
            g.a("WXPhoto", stringBuilder.toString());
        }
        String str = null;
        StringBuilder stringBuilder2;
        switch (i) {
            case CONFIGID.RECORD_WIDTH /*4001*/:
                if (i2 == -1) {
                    a(this.f, this.f);
                    n.a("CameraSuccess", null);
                    return;
                }
                n.a("CameraFailed", "Error retrieving the camera data when taking picture");
                stringBuilder2 = new StringBuilder("call takePhoto fail. resultCode: ");
                stringBuilder2.append(i2);
                g.e("WXPhoto", stringBuilder2.toString());
                this.e.b(new m());
                return;
            case CONFIGID.RECORD_HEIGHT /*4002*/:
                if (i2 != -1 || intent == null) {
                    stringBuilder2 = new StringBuilder("Error retrieving the album data, result code: ");
                    stringBuilder2.append(i2);
                    n.a("AlbumFailed", stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder("call pick photo fail. resultCode: ");
                    stringBuilder2.append(i2);
                    g.e("WXPhoto", stringBuilder2.toString());
                    this.e.b(new m());
                    return;
                }
                Uri data = intent.getData();
                if (data != null) {
                    if ("file".equalsIgnoreCase(data.getScheme())) {
                        str = data.getPath();
                    } else {
                        String[] strArr = new String[]{Impl._DATA};
                        Cursor query = this.a.getContentResolver().query(data, strArr, null, null, null);
                        if (query == null || !query.moveToFirst()) {
                            n.a("AlbumFailed", "Error retrieving the album data due to empty curser");
                            stringBuilder2 = new StringBuilder("pick photo fail, Cursor is empty, imageUri: ");
                            stringBuilder2.append(data.toString());
                            g.e("WXPhoto", stringBuilder2.toString());
                        } else {
                            String string = query.getString(query.getColumnIndex(strArr[0]));
                            query.close();
                            n.a("AlbumSuccess", null);
                            str = string;
                        }
                    }
                }
                StringBuilder stringBuilder3;
                if (com.alibaba.sdk.android.feedback.xblink.d.a.a(str)) {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(j.a);
                    stringBuilder4.append(File.separator);
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(System.currentTimeMillis());
                    stringBuilder4.append(com.alibaba.sdk.android.feedback.xblink.i.b.a(stringBuilder3.toString()));
                    this.f = stringBuilder4.toString();
                    a(str, this.f);
                    return;
                }
                n.a("AlbumFailed", "Error retrieving the album data due to picture not exist");
                stringBuilder3 = new StringBuilder("pick photo fail, picture not exist, picturePath: ");
                stringBuilder3.append(str);
                g.e("WXPhoto", stringBuilder3.toString());
                return;
            default:
                return;
        }
    }

    public synchronized void a(com.alibaba.sdk.android.feedback.xblink.f.b r7, java.lang.String r8) {
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
        monitor-enter(r6);
        r0 = r6.c;	 Catch:{ all -> 0x013a }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r6);
        return;
    L_0x0007:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x013a }
        r2 = r6.d;	 Catch:{ all -> 0x013a }
        r4 = r0 - r2;	 Catch:{ all -> 0x013a }
        r6.d = r0;	 Catch:{ all -> 0x013a }
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x0019;
    L_0x0017:
        monitor-exit(r6);
        return;
    L_0x0019:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0118 }
        r0.<init>(r8);	 Catch:{ JSONException -> 0x0118 }
        r1 = "mode";	 Catch:{ JSONException -> 0x0118 }
        r0 = r0.optString(r1);	 Catch:{ JSONException -> 0x0118 }
        r6.e = r7;	 Catch:{ all -> 0x013a }
        r7 = "album";	 Catch:{ all -> 0x013a }
        r7 = r7.equals(r0);	 Catch:{ all -> 0x013a }
        if (r7 == 0) goto L_0x0044;	 Catch:{ all -> 0x013a }
    L_0x002e:
        r7 = "WXPhoto";	 Catch:{ all -> 0x013a }
        r8 = "start to pick photo from system album.";	 Catch:{ all -> 0x013a }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r7, r8);	 Catch:{ all -> 0x013a }
        r7 = new android.content.Intent;	 Catch:{ all -> 0x013a }
        r8 = "android.intent.action.PICK";	 Catch:{ all -> 0x013a }
        r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;	 Catch:{ all -> 0x013a }
        r7.<init>(r8, r0);	 Catch:{ all -> 0x013a }
        r8 = 1;	 Catch:{ all -> 0x013a }
        r6.a(r8, r7);	 Catch:{ all -> 0x013a }
        monitor-exit(r6);
        return;
    L_0x0044:
        r7 = "camera";	 Catch:{ all -> 0x013a }
        r7 = r7.equals(r0);	 Catch:{ all -> 0x013a }
        if (r7 == 0) goto L_0x00b7;	 Catch:{ all -> 0x013a }
    L_0x004c:
        r7 = "WXPhoto";	 Catch:{ all -> 0x013a }
        r8 = "start to open system camera.";	 Catch:{ all -> 0x013a }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r7, r8);	 Catch:{ all -> 0x013a }
        r7 = new android.content.Intent;	 Catch:{ all -> 0x013a }
        r8 = "android.media.action.IMAGE_CAPTURE";	 Catch:{ all -> 0x013a }
        r7.<init>(r8);	 Catch:{ all -> 0x013a }
        r8 = new java.io.File;	 Catch:{ all -> 0x013a }
        r0 = com.alibaba.sdk.android.feedback.util.j.a;	 Catch:{ all -> 0x013a }
        r8.<init>(r0);	 Catch:{ all -> 0x013a }
        r0 = r8.exists();	 Catch:{ all -> 0x013a }
        if (r0 != 0) goto L_0x006b;	 Catch:{ all -> 0x013a }
    L_0x0067:
        r8.mkdirs();	 Catch:{ all -> 0x013a }
        goto L_0x0075;	 Catch:{ all -> 0x013a }
    L_0x006b:
        r0 = r8.isDirectory();	 Catch:{ all -> 0x013a }
        if (r0 != 0) goto L_0x0075;	 Catch:{ all -> 0x013a }
    L_0x0071:
        r8.delete();	 Catch:{ all -> 0x013a }
        goto L_0x0067;	 Catch:{ all -> 0x013a }
    L_0x0075:
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x013a }
        r8.<init>();	 Catch:{ all -> 0x013a }
        r0 = com.alibaba.sdk.android.feedback.util.j.a;	 Catch:{ all -> 0x013a }
        r8.append(r0);	 Catch:{ all -> 0x013a }
        r0 = java.io.File.separator;	 Catch:{ all -> 0x013a }
        r8.append(r0);	 Catch:{ all -> 0x013a }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x013a }
        r0.<init>();	 Catch:{ all -> 0x013a }
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x013a }
        r0.append(r1);	 Catch:{ all -> 0x013a }
        r0 = r0.toString();	 Catch:{ all -> 0x013a }
        r0 = com.alibaba.sdk.android.feedback.xblink.i.b.a(r0);	 Catch:{ all -> 0x013a }
        r8.append(r0);	 Catch:{ all -> 0x013a }
        r8 = r8.toString();	 Catch:{ all -> 0x013a }
        r6.f = r8;	 Catch:{ all -> 0x013a }
        r8 = new java.io.File;	 Catch:{ all -> 0x013a }
        r0 = r6.f;	 Catch:{ all -> 0x013a }
        r8.<init>(r0);	 Catch:{ all -> 0x013a }
        r8 = android.net.Uri.fromFile(r8);	 Catch:{ all -> 0x013a }
        r0 = "output";	 Catch:{ all -> 0x013a }
        r7.putExtra(r0, r8);	 Catch:{ all -> 0x013a }
        r8 = 0;	 Catch:{ all -> 0x013a }
        r6.a(r8, r7);	 Catch:{ all -> 0x013a }
        monitor-exit(r6);
        return;
    L_0x00b7:
        r7 = "both";	 Catch:{ all -> 0x013a }
        r7 = r7.equals(r0);	 Catch:{ all -> 0x013a }
        if (r7 == 0) goto L_0x0116;	 Catch:{ all -> 0x013a }
    L_0x00bf:
        r7 = android.os.Build.BRAND;	 Catch:{ all -> 0x013a }
        r8 = android.os.Build.MODEL;	 Catch:{ all -> 0x013a }
        if (r7 == 0) goto L_0x00f2;	 Catch:{ all -> 0x013a }
    L_0x00c5:
        if (r8 == 0) goto L_0x00f2;	 Catch:{ all -> 0x013a }
    L_0x00c7:
        r0 = "meizu";	 Catch:{ all -> 0x013a }
        r7 = r7.equalsIgnoreCase(r0);	 Catch:{ all -> 0x013a }
        if (r7 == 0) goto L_0x00f2;	 Catch:{ all -> 0x013a }
    L_0x00cf:
        r7 = "m040";	 Catch:{ all -> 0x013a }
        r7 = r8.equalsIgnoreCase(r7);	 Catch:{ all -> 0x013a }
        if (r7 == 0) goto L_0x00f2;	 Catch:{ all -> 0x013a }
    L_0x00d7:
        r7 = new android.app.AlertDialog$Builder;	 Catch:{ all -> 0x013a }
        r8 = r6.a;	 Catch:{ all -> 0x013a }
        r7.<init>(r8);	 Catch:{ all -> 0x013a }
        r8 = r6.h;	 Catch:{ all -> 0x013a }
        r0 = new com.alibaba.sdk.android.feedback.xblink.f.a.v;	 Catch:{ all -> 0x013a }
        r0.<init>(r6);	 Catch:{ all -> 0x013a }
        r7 = r7.setItems(r8, r0);	 Catch:{ all -> 0x013a }
        r7 = r7.create();	 Catch:{ all -> 0x013a }
        r7.show();	 Catch:{ all -> 0x013a }
        monitor-exit(r6);
        return;
    L_0x00f2:
        r7 = new com.alibaba.sdk.android.feedback.xblink.view.a;	 Catch:{ Throwable -> 0x0112 }
        r8 = r6.a;	 Catch:{ Throwable -> 0x0112 }
        r0 = r6.b;	 Catch:{ Throwable -> 0x0112 }
        r1 = r6.h;	 Catch:{ Throwable -> 0x0112 }
        r2 = r6.i;	 Catch:{ Throwable -> 0x0112 }
        r7.<init>(r8, r0, r1, r2);	 Catch:{ Throwable -> 0x0112 }
        r6.g = r7;	 Catch:{ Throwable -> 0x0112 }
        r7 = r6.g;	 Catch:{ Throwable -> 0x0112 }
        r8 = new com.alibaba.sdk.android.feedback.xblink.f.a.w;	 Catch:{ Throwable -> 0x0112 }
        r8.<init>(r6);	 Catch:{ Throwable -> 0x0112 }
        r7.a(r8);	 Catch:{ Throwable -> 0x0112 }
        r7 = r6.g;	 Catch:{ Throwable -> 0x0112 }
        r7.a();	 Catch:{ Throwable -> 0x0112 }
        monitor-exit(r6);
        return;
    L_0x0112:
        r7 = move-exception;
        r7.printStackTrace();	 Catch:{ all -> 0x013a }
    L_0x0116:
        monitor-exit(r6);
        return;
    L_0x0118:
        r0 = "WXPhoto";	 Catch:{ all -> 0x013a }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x013a }
        r2 = "takePhoto fail, params: ";	 Catch:{ all -> 0x013a }
        r1.<init>(r2);	 Catch:{ all -> 0x013a }
        r1.append(r8);	 Catch:{ all -> 0x013a }
        r8 = r1.toString();	 Catch:{ all -> 0x013a }
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r8);	 Catch:{ all -> 0x013a }
        r8 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ all -> 0x013a }
        r8.<init>();	 Catch:{ all -> 0x013a }
        r0 = "HY_PARAM_ERR";	 Catch:{ all -> 0x013a }
        r8.a(r0);	 Catch:{ all -> 0x013a }
        r7.b(r8);	 Catch:{ all -> 0x013a }
        monitor-exit(r6);
        return;
    L_0x013a:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.u.a(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    public boolean a(String str, String str2, b bVar) {
        if (!"take".equals(str) || !d()) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
