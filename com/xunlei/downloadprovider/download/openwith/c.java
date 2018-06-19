package com.xunlei.downloadprovider.download.openwith;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.message.MsgConstant;
import com.xunlei.common.androidutil.ApkHelper;
import java.util.Hashtable;

/* compiled from: LocalAppManager */
public final class c {
    private static c b;
    private Hashtable<String, String> a;
    private final String c;

    private c() {
        this.a = null;
        this.c = "ThunderDownload/";
        this.a = new Hashtable();
        this.a.put(ShareConstants.PATCH_SUFFIX, ApkHelper.MIME_TYPE_APK);
        this.a.put(".bmp", "image/bmp");
        this.a.put(".gif", "image/gif");
        this.a.put(".jpeg", "image/jpeg");
        this.a.put(".jpg", "image/jpeg");
        this.a.put(".png", "image/png");
        this.a.put(".icon", "image/icon");
        this.a.put(".jpe", "image/jpe");
        this.a.put(".amr", "audio/amr");
        this.a.put(".mp2", "audio/x-mpeg");
        this.a.put(".mp3", "audio/x-mpeg");
        this.a.put(".wav", "audio/x-wav");
        this.a.put(".wma", "audio/x-ms-wma");
        this.a.put(".wmv", "video/x-ms-wmv");
        this.a.put(".m3u", "audio/x-mpegurl");
        this.a.put(".m4a", "audio/mp4a-latm");
        this.a.put(".m4b", "audio/mp4a-latm");
        this.a.put(".m4p", "audio/mp4a-latm");
        this.a.put(".ogg", "audio/ogg");
        this.a.put(".midi", "audio/midi");
        this.a.put(".cda", "audio/*");
        this.a.put(".mp3pro", "audio/*");
        this.a.put(".sacd", "audio/*");
        this.a.put(".vqf", "audio/*");
        this.a.put(".ra", "audio/*");
        this.a.put(".rmx", "audio/*");
        this.a.put(".voc", "audio/*");
        this.a.put(".au", "audio/*");
        this.a.put(".aif", "audio/*");
        this.a.put(".snd", "audio/*");
        this.a.put(".aac", "audio/aac");
        this.a.put(".flac", "audio/flac");
        this.a.put(".xmf", "audio/midi");
        this.a.put(".3gp", "video/3gpp");
        this.a.put(".xv", "video/*");
        this.a.put(".asf", "video/x-ms-asf");
        this.a.put(".avi", "video/x-msvideo");
        this.a.put(".m4u", "video/vnd.mpegurl");
        this.a.put(".m4v", "video/x-m4v");
        this.a.put(".mov", "video/quicktime");
        this.a.put(".mp4", "video/mp4");
        this.a.put(".mpc", "application/vnd.mpohun.certificate");
        this.a.put(".mpe", "video/mpeg");
        this.a.put(".mpeg", "video/mpeg");
        this.a.put(".mpg", "video/mpeg");
        this.a.put(".mpg4", "video/mp4");
        this.a.put(".mpga", "audio/mpeg");
        this.a.put(".msg", "application/vnd.ms-outlook");
        this.a.put(".flv", "video/x-flv");
        this.a.put(".rm", "video/x-pn-realaudio");
        this.a.put(".asx", "video/*");
        this.a.put(".dat", "video/*");
        this.a.put(".mkv", "video/*");
        this.a.put(".f4v", "video/*");
        this.a.put(".vob", "video/*");
        this.a.put(".ts", "video/*");
        this.a.put(".rmvb", "video/x-pn-realaudio");
        this.a.put(".prop", "text/plain");
        this.a.put(".rc", "text/plain");
        this.a.put(MsgConstant.CACHE_LOG_FILE_EXT, "text/plain");
        this.a.put(".xhtm", "text/plain");
        this.a.put(".epub", "text/plain");
        this.a.put(".umd", "text/plain");
        this.a.put(".xml", "text/plain");
        this.a.put(com.xunlei.download.proguard.c.n, "text/plain");
        this.a.put(".sh", "text/plain");
        this.a.put(".java", "text/plain");
        this.a.put(".xtm", "text/html");
        this.a.put(".xthm", "text/html");
        this.a.put(".chm", "text/plain");
        this.a.put(".cbz", "text/plain");
        this.a.put(".h", "text/plain");
        this.a.put(".htm", "text/html");
        this.a.put(com.xunlei.download.proguard.c.m, "text/html");
        this.a.put(".conf", "text/plain");
        this.a.put(".cpp", "text/plain");
        this.a.put(".c", "text/plain");
        this.a.put(".rar", "application/x-rar-compressed");
        this.a.put(".tar", "application/x-tar");
        this.a.put(".zip", "application/zip");
        this.a.put(".cab", "application/zip");
        this.a.put(".lzma", "application/zip");
        this.a.put(".arj", "application/zip");
        this.a.put(".iso", "application/zip");
        this.a.put(".xar", "application/zip");
        this.a.put(".gzip", "application/zip");
        this.a.put(".bzip2", "application/zip");
        this.a.put(".gtar", "application/x-gtar");
        this.a.put(".gz", "application/x-gzip");
        this.a.put(ShareConstants.JAR_SUFFIX, "application/java-archive");
        this.a.put(".class", "application/octet-stream");
        this.a.put(".doc", "application/msword");
        this.a.put(".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        this.a.put(".pdf", "application/pdf");
        this.a.put(".pps", "application/vnd.ms-powerpoint");
        this.a.put(".ppt", "application/vnd.ms-powerpoint");
        this.a.put(".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        this.a.put(".rtf", "application/rtf");
        this.a.put(".tgz", "application/x-compressed");
        this.a.put(".wps", "application/vnd.ms-works");
        this.a.put(".xls", "application/vnd.ms-excel");
        this.a.put(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        this.a.put(".z", "application/x-compress");
        this.a.put(".torrent", "application/x-bittorrent");
        this.a.put(".js", "application/x-javascript");
        this.a.put("", "*/*");
    }

    public static c a() {
        if (b == null) {
            b = new c();
        }
        return b;
    }

    public final android.content.Intent a(android.content.Context r11, java.lang.String r12, android.content.pm.ResolveInfo r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = 46;
        r0 = r12.lastIndexOf(r0);
        r1 = 0;
        r2 = -1;
        if (r2 != r0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r12.substring(r0);
        r2 = java.util.Locale.getDefault();
        r0 = r0.toLowerCase(r2);
        r2 = new android.content.Intent;
        r3 = "android.intent.action.VIEW";
        r2.<init>(r3);
        r3 = "http://";
        r3 = r12.startsWith(r3);
        if (r3 != 0) goto L_0x0034;
    L_0x0026:
        r3 = new java.lang.StringBuilder;
        r4 = "file://";
        r3.<init>(r4);
        r3.append(r12);
        r12 = r3.toString();
    L_0x0034:
        r3 = 7;
        r3 = r12.substring(r3);
        r4 = "ThunderDownload/";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r4 = r12.lastIndexOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5 = 47;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5 = r12.lastIndexOf(r5);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r7 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        if (r4 <= 0) goto L_0x00a5;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
    L_0x0049:
        if (r5 <= 0) goto L_0x00a5;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
    L_0x004b:
        r8 = r4 + 16;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        if (r5 <= r8) goto L_0x00a5;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
    L_0x004f:
        r9 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r9.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r4 = r12.substring(r6, r4);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r9.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r4 = "ThunderDownload/";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r9.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r4 = r9.toString();	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r6 = r12.substring(r8, r5);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r8 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r6 = java.net.URLEncoder.encode(r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r8 = "+";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r9 = "%20";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r6 = r6.replace(r8, r9);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5 = r5 + r7;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r8 = r12.length();	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r12 = r12.substring(r5, r8);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r12 = java.net.URLEncoder.encode(r12, r5);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5 = "+";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r8 = "%20";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r12 = r12.replace(r5, r8);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r4 = "/";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5.append(r12);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r12 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        goto L_0x00cf;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
    L_0x00a5:
        r5 = r5 + r7;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r4 = r12.substring(r6, r5);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r6 = r12.length();	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r12 = r12.substring(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r12 = java.net.URLEncoder.encode(r12, r5);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5 = "+";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r6 = "%20";	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r12 = r12.replace(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r5.append(r12);	 Catch:{ UnsupportedEncodingException -> 0x0111 }
        r12 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0111 }
    L_0x00cf:
        r4 = r10.a;
        r0 = r4.get(r0);
        r0 = (java.lang.String) r0;
        if (r0 != 0) goto L_0x00da;
    L_0x00d9:
        return r1;
    L_0x00da:
        r4 = android.os.Build.VERSION.SDK_INT;
        r5 = 24;
        if (r4 < r5) goto L_0x00f5;
    L_0x00e0:
        r2.setFlags(r7);
        r12 = new java.io.File;
        r12.<init>(r3);
        r3 = r12.exists();
        if (r3 == 0) goto L_0x00f9;
    L_0x00ee:
        r1 = "com.xunlei.downloadprovider.XLFileProvider";
        r1 = android.support.v4.content.FileProvider.getUriForFile(r11, r1, r12);
        goto L_0x00f9;
    L_0x00f5:
        r1 = android.net.Uri.parse(r12);
    L_0x00f9:
        if (r1 == 0) goto L_0x00fe;
    L_0x00fb:
        r2.setDataAndType(r1, r0);
    L_0x00fe:
        if (r13 == 0) goto L_0x0110;
    L_0x0100:
        r11 = new android.content.ComponentName;
        r12 = r13.activityInfo;
        r12 = r12.packageName;
        r13 = r13.activityInfo;
        r13 = r13.name;
        r11.<init>(r12, r13);
        r2.setComponent(r11);
    L_0x0110:
        return r2;
    L_0x0111:
        r11 = new java.lang.RuntimeException;
        r12 = "文件名编码错误";
        r11.<init>(r12);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.openwith.c.a(android.content.Context, java.lang.String, android.content.pm.ResolveInfo):android.content.Intent");
    }

    public final java.util.List<android.content.pm.ResolveInfo> a(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 0;
        if (r8 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.File;
        r1.<init>(r8);
        r2 = r1.exists();
        if (r2 == 0) goto L_0x00e9;
    L_0x000f:
        r1 = r1.isFile();
        if (r1 != 0) goto L_0x0017;
    L_0x0015:
        goto L_0x00e9;
    L_0x0017:
        r1 = 46;
        r1 = r8.lastIndexOf(r1);
        r2 = -1;
        if (r2 != r1) goto L_0x0021;
    L_0x0020:
        return r0;
    L_0x0021:
        r1 = r8.substring(r1);
        r2 = java.util.Locale.getDefault();
        r1 = r1.toLowerCase(r2);
        r2 = new android.content.Intent;
        r3 = "android.intent.action.VIEW";
        r2.<init>(r3);
        r3 = "http://";
        r3 = r8.startsWith(r3);
        if (r3 != 0) goto L_0x004a;
    L_0x003c:
        r3 = new java.lang.StringBuilder;
        r4 = "file://";
        r3.<init>(r4);
        r3.append(r8);
        r8 = r3.toString();
    L_0x004a:
        r3 = 47;
        r3 = r8.lastIndexOf(r3);	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r3 = r3 + 1;	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r4 = 0;	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r5 = r8.substring(r4, r3);	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r6 = r8.length();	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r8 = r8.substring(r3, r6);	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r3 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r8 = java.net.URLEncoder.encode(r8, r3);	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r3 = "+";	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r6 = "%20";	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r8 = r8.replace(r3, r6);	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r3.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r3.append(r8);	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r8 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x00e1 }
        r3 = r7.a;
        r1 = r3.get(r1);
        r1 = (java.lang.String) r1;
        if (r1 != 0) goto L_0x0087;
    L_0x0086:
        return r0;
    L_0x0087:
        r3 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r3 = r3.getApplicationContext();
        r5 = r3.getPackageManager();
        r4 = r5.resolveActivity(r2, r4);
        if (r4 == 0) goto L_0x00e0;
    L_0x0099:
        r8 = android.net.Uri.parse(r8);
        r2.setDataAndType(r8, r1);
        r8 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r2.setFlags(r8);
        r8 = r3.getPackageManager();
        r1 = 64;
        r8 = r8.queryIntentActivities(r2, r1);
        r1 = new java.util.ArrayList;
        r1.<init>();
        r8 = r8.iterator();
    L_0x00b8:
        r2 = r8.hasNext();
        if (r2 == 0) goto L_0x00d8;
    L_0x00be:
        r2 = r8.next();
        r2 = (android.content.pm.ResolveInfo) r2;
        r3 = r2.activityInfo;
        if (r3 == 0) goto L_0x00d4;
    L_0x00c8:
        r3 = r2.activityInfo;
        r3 = r3.exported;
        if (r3 == 0) goto L_0x00b8;
    L_0x00ce:
        r3 = r2.activityInfo;
        r3 = r3.enabled;
        if (r3 == 0) goto L_0x00b8;
    L_0x00d4:
        r1.add(r2);
        goto L_0x00b8;
    L_0x00d8:
        r8 = r1.size();
        if (r8 != 0) goto L_0x00df;
    L_0x00de:
        return r0;
    L_0x00df:
        return r1;
    L_0x00e0:
        return r0;
    L_0x00e1:
        r8 = new java.lang.RuntimeException;
        r0 = "文件名编码错误";
        r8.<init>(r0);
        throw r8;
    L_0x00e9:
        r8 = new java.lang.IllegalArgumentException;
        r0 = "找不到文件";
        r8.<init>(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.openwith.c.a(java.lang.String):java.util.List<android.content.pm.ResolveInfo>");
    }
}
