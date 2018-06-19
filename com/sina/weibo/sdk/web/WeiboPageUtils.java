package com.sina.weibo.sdk.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.web.param.DefaultWebViewRequestParam;
import java.util.HashMap;
import java.util.Map.Entry;

public class WeiboPageUtils {
    private static final String USER_INFO_H5 = "http://m.weibo.cn/u/";
    private static final String USER_INFO_SCHEME = "sinaweibo://userinfo?";
    private static final String WEIBO_ARTICLE_H5 = "http://media.weibo.cn/article?";
    private static final String WEIBO_ARTICLE_SCHEME = "sinaweibo://article?";
    private static final String WEIBO_COMMENT_H5 = "http://m.weibo.cn/comment?";
    private static final String WEIBO_COMMENT_SCHEME = "sinaweibo://comment?";
    private static final String WEIBO_DETAIL_H5 = "http://m.weibo.cn/";
    private static final String WEIBO_DETAIL_SCHEME = "sinaweibo://detail?";
    private static final String WEIBO_GOTO_HOME_H5 = "http://m.weibo.cn/index/router?";
    private static final String WEIBO_GOTO_HOME_SCHEME = "sinaweibo://gotohome?";
    private static final String WEIBO_GOTO_MYPROFILE_H5 = "http://m.weibo.cn/index/router?";
    private static final String WEIBO_GOTO_MYPROFILE_SCHEME = "sinaweibo://myprofile?";
    private static final String WEIBO_SEARCH_URL_CHEME = "sinaweibo://searchall?";
    private static final String WEIBO_SEARCH_URL_H5 = "https://m.weibo.cn/p/100103type=1&";
    private static final String WEIBO_SEND_CONTENT_H5 = "http://m.weibo.cn/mblog?";
    private static final String WEIBO_SEND_CONTENT_SCHEME = "sinaweibo://sendweibo?";
    private static WeiboPageUtils weiboSdkUtils;
    private AuthInfo authInfo;
    private Context context;
    private WbAppInfo mWeiboInfo = null;

    private WeiboPageUtils(Context context, AuthInfo authInfo) {
        this.mWeiboInfo = WeiboAppManager.getInstance(context).getWbAppInfo();
        this.authInfo = authInfo;
        this.context = context;
    }

    public static WeiboPageUtils getInstance(Context context, AuthInfo authInfo) {
        if (weiboSdkUtils == null) {
            weiboSdkUtils = new WeiboPageUtils(context, authInfo);
        }
        return weiboSdkUtils;
    }

    public void startUserMainPage(String str) {
        startUserMainPage(str, false);
    }

    public void startUserMainPage(java.lang.String r3, boolean r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        if (r4 != 0) goto L_0x0026;
    L_0x0002:
        r4 = r2.mWeiboInfo;
        if (r4 == 0) goto L_0x0026;
    L_0x0006:
        r4 = r2.mWeiboInfo;
        r4 = r4.isLegal();
        if (r4 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0026;
    L_0x000f:
        r4 = "sinaweibo://userinfo?";
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "uid";
        r0.put(r1, r3);
        r3 = r2.createScheme(r4, r0);
        r4 = r2.context;	 Catch:{ Exception -> 0x0025 }
        r4.startActivity(r3);	 Catch:{ Exception -> 0x0025 }
        return;
    L_0x0025:
        return;
    L_0x0026:
        r4 = new java.lang.StringBuilder;
        r0 = "http://m.weibo.cn/u/";
        r4.<init>(r0);
        r4.append(r3);
        r3 = "?";
        r4.append(r3);
        r3 = r4.toString();
        r4 = 0;
        r3 = r2.schemeAddProperty(r3, r4);
        r2.gotoWebActivity(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.WeiboPageUtils.startUserMainPage(java.lang.String, boolean):void");
    }

    public void startWeiboDetailPage(String str, String str2) {
        startWeiboDetailPage(str, str2, false);
    }

    public void startWeiboDetailPage(java.lang.String r2, java.lang.String r3, boolean r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        if (r4 != 0) goto L_0x0026;
    L_0x0002:
        r4 = r1.mWeiboInfo;
        if (r4 == 0) goto L_0x0026;
    L_0x0006:
        r4 = r1.mWeiboInfo;
        r4 = r4.isLegal();
        if (r4 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0026;
    L_0x000f:
        r3 = "sinaweibo://detail?";
        r4 = new java.util.HashMap;
        r4.<init>();
        r0 = "mblogid";
        r4.put(r0, r2);
        r2 = r1.createScheme(r3, r4);
        r3 = r1.context;	 Catch:{ Exception -> 0x0025 }
        r3.startActivity(r2);	 Catch:{ Exception -> 0x0025 }
        return;
    L_0x0025:
        return;
    L_0x0026:
        r4 = new java.lang.StringBuilder;
        r0 = "http://m.weibo.cn/";
        r4.<init>(r0);
        r4.append(r3);
        r3 = "/";
        r4.append(r3);
        r4.append(r2);
        r2 = "?";
        r4.append(r2);
        r2 = r4.toString();
        r3 = 0;
        r2 = r1.schemeAddProperty(r2, r3);
        r1.gotoWebActivity(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.WeiboPageUtils.startWeiboDetailPage(java.lang.String, java.lang.String, boolean):void");
    }

    public void startWeiboTopPage(String str) {
        startWeiboTopPage(str, false);
    }

    public void startWeiboTopPage(java.lang.String r5, boolean r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        if (r6 != 0) goto L_0x0034;
    L_0x0002:
        r6 = r4.mWeiboInfo;
        if (r6 == 0) goto L_0x0034;
    L_0x0006:
        r6 = r4.mWeiboInfo;
        r6 = r6.isLegal();
        if (r6 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0034;
    L_0x000f:
        r6 = "sinaweibo://article?";
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "object_id";
        r2 = new java.lang.StringBuilder;
        r3 = "1022:";
        r2.<init>(r3);
        r2.append(r5);
        r5 = r2.toString();
        r0.put(r1, r5);
        r5 = r4.createScheme(r6, r0);
        r6 = r4.context;	 Catch:{ Exception -> 0x0033 }
        r6.startActivity(r5);	 Catch:{ Exception -> 0x0033 }
        return;
    L_0x0033:
        return;
    L_0x0034:
        r6 = "http://media.weibo.cn/article?";
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "id";
        r0.put(r1, r5);
        r5 = r4.schemeAddProperty(r6, r0);
        r4.gotoWebActivity(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.WeiboPageUtils.startWeiboTopPage(java.lang.String, boolean):void");
    }

    public void shareToWeibo(String str) {
        shareToWeibo(str, false);
    }

    public void shareToWeibo(java.lang.String r3, boolean r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        if (r4 != 0) goto L_0x0026;
    L_0x0002:
        r4 = r2.mWeiboInfo;
        if (r4 == 0) goto L_0x0026;
    L_0x0006:
        r4 = r2.mWeiboInfo;
        r4 = r4.isLegal();
        if (r4 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0026;
    L_0x000f:
        r4 = "sinaweibo://sendweibo?";
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "content";
        r0.put(r1, r3);
        r3 = r2.createScheme(r4, r0);
        r4 = r2.context;	 Catch:{ Exception -> 0x0025 }
        r4.startActivity(r3);	 Catch:{ Exception -> 0x0025 }
        return;
    L_0x0025:
        return;
    L_0x0026:
        r4 = "http://m.weibo.cn/mblog?";
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "content";
        r0.put(r1, r3);
        r3 = 0;
        r3 = r2.schemeAddProperty(r4, r3);
        r2.gotoWebActivity(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.WeiboPageUtils.shareToWeibo(java.lang.String, boolean):void");
    }

    public void commentWeibo(String str) {
        commentWeibo(str, false);
    }

    public void commentWeibo(java.lang.String r3, boolean r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        if (r4 != 0) goto L_0x0026;
    L_0x0002:
        r4 = r2.mWeiboInfo;
        if (r4 == 0) goto L_0x0026;
    L_0x0006:
        r4 = r2.mWeiboInfo;
        r4 = r4.isLegal();
        if (r4 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0026;
    L_0x000f:
        r4 = "sinaweibo://comment?";
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "srcid";
        r0.put(r1, r3);
        r3 = r2.createScheme(r4, r0);
        r4 = r2.context;	 Catch:{ Exception -> 0x0025 }
        r4.startActivity(r3);	 Catch:{ Exception -> 0x0025 }
        return;
    L_0x0025:
        return;
    L_0x0026:
        r4 = "http://m.weibo.cn/comment?";
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "id";
        r0.put(r1, r3);
        r3 = r2.schemeAddProperty(r4, r0);
        r2.gotoWebActivity(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.WeiboPageUtils.commentWeibo(java.lang.String, boolean):void");
    }

    public void openWeiboSearchPage(String str) {
        openWeiboSearchPage(str, false);
    }

    public void openWeiboSearchPage(java.lang.String r3, boolean r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        if (r4 != 0) goto L_0x0026;
    L_0x0002:
        r4 = r2.mWeiboInfo;
        if (r4 == 0) goto L_0x0026;
    L_0x0006:
        r4 = r2.mWeiboInfo;
        r4 = r4.isLegal();
        if (r4 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0026;
    L_0x000f:
        r4 = "sinaweibo://searchall?";
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "q";
        r0.put(r1, r3);
        r3 = r2.createScheme(r4, r0);
        r4 = r2.context;	 Catch:{ Exception -> 0x0025 }
        r4.startActivity(r3);	 Catch:{ Exception -> 0x0025 }
        return;
    L_0x0025:
        return;
    L_0x0026:
        r4 = "https://m.weibo.cn/p/100103type=1&";
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "q";
        r0.put(r1, r3);
        r3 = r2.schemeAddProperty(r4, r0);
        r2.gotoWebActivity(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.WeiboPageUtils.openWeiboSearchPage(java.lang.String, boolean):void");
    }

    public void gotoMyHomePage() {
        gotoMyHomePage(false);
    }

    public void gotoMyHomePage(boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        if (r5 != 0) goto L_0x001d;
    L_0x0003:
        r5 = r4.mWeiboInfo;
        if (r5 == 0) goto L_0x001d;
    L_0x0007:
        r5 = r4.mWeiboInfo;
        r5 = r5.isLegal();
        if (r5 != 0) goto L_0x0010;
    L_0x000f:
        goto L_0x001d;
    L_0x0010:
        r5 = "sinaweibo://gotohome?";
        r5 = r4.createScheme(r5, r0);
        r0 = r4.context;	 Catch:{ Exception -> 0x001c }
        r0.startActivity(r5);	 Catch:{ Exception -> 0x001c }
        return;
    L_0x001c:
        return;
    L_0x001d:
        r5 = "http://m.weibo.cn/index/router?";
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = "cookie";
        r3 = "0_all";
        r1.put(r2, r3);
        r5 = r4.schemeAddProperty(r5, r0);
        r4.gotoWebActivity(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.WeiboPageUtils.gotoMyHomePage(boolean):void");
    }

    public void gotoMyProfile() {
        gotoMyProfile(false);
    }

    public void gotoMyProfile(boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        if (r5 != 0) goto L_0x001d;
    L_0x0003:
        r5 = r4.mWeiboInfo;
        if (r5 == 0) goto L_0x001d;
    L_0x0007:
        r5 = r4.mWeiboInfo;
        r5 = r5.isLegal();
        if (r5 != 0) goto L_0x0010;
    L_0x000f:
        goto L_0x001d;
    L_0x0010:
        r5 = "sinaweibo://myprofile?";
        r5 = r4.createScheme(r5, r0);
        r0 = r4.context;	 Catch:{ Exception -> 0x001c }
        r0.startActivity(r5);	 Catch:{ Exception -> 0x001c }
        return;
    L_0x001c:
        return;
    L_0x001d:
        r5 = "http://m.weibo.cn/index/router?";
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = "cookie";
        r3 = "3";
        r1.put(r2, r3);
        r5 = r4.schemeAddProperty(r5, r0);
        r4.gotoWebActivity(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.WeiboPageUtils.gotoMyProfile(boolean):void");
    }

    public void startOtherPage(String str) {
        startOtherPage(str, null);
    }

    public void startOtherPage(String str, HashMap<String, String> hashMap) {
        if (!TextUtils.isEmpty(str)) {
            gotoWebActivity(schemeAddProperty(str, hashMap));
        }
    }

    private Intent createScheme(String str, HashMap<String, String> hashMap) {
        return new Intent("android.intent.action.VIEW", Uri.parse(schemeAddProperty(str, hashMap)));
    }

    private String schemeAddProperty(String str, HashMap<String, String> hashMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("luicode=10000360&&lfid=OP_");
        stringBuilder.append(this.authInfo.getAppKey());
        str = stringBuilder.toString();
        if (hashMap != null) {
            hashMap = hashMap.entrySet().iterator();
            while (hashMap.hasNext()) {
                Entry entry = (Entry) hashMap.next();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("&");
                stringBuilder2.append(entry.getKey().toString());
                stringBuilder2.append("=");
                stringBuilder2.append(entry.getValue().toString());
                str = stringBuilder2.toString();
            }
        }
        return str;
    }

    private void gotoWebActivity(String str) {
        Intent intent = new Intent();
        intent.setClass(this.context, WeiboSdkWebActivity.class);
        DefaultWebViewRequestParam defaultWebViewRequestParam = new DefaultWebViewRequestParam(this.authInfo, WebRequestType.DEFAULT, null, null, str, this.context);
        str = new Bundle();
        defaultWebViewRequestParam.fillBundle(str);
        intent.putExtras(str);
        this.context.startActivity(intent);
    }
}
