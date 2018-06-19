package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.constant.WBConstants;

public class WbShareTransActivity extends Activity {
    private CopyResourceTask copyResourceTask;
    boolean flag = false;
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WbShareTransActivity.this.sendCallback(1);
        }
    };
    private View progressBar;
    private int progressColor = -1;
    private int progressId = -1;
    private FrameLayout rootLayout;
    private String startActivityName;

    private class CopyResourceTask extends AsyncTask<WeiboMultiMessage, Object, TransResourceResult> {
        private CopyResourceTask() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected com.sina.weibo.sdk.share.WbShareTransActivity.TransResourceResult doInBackground(com.sina.weibo.sdk.api.WeiboMultiMessage... r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r0 = 0;
            r8 = r8[r0];
            r1 = new com.sina.weibo.sdk.share.WbShareTransActivity$TransResourceResult;
            r2 = com.sina.weibo.sdk.share.WbShareTransActivity.this;
            r3 = 0;
            r1.<init>();
            r2 = com.sina.weibo.sdk.share.WbShareTransActivity.this;	 Catch:{ Exception -> 0x00a6 }
            r2 = com.sina.weibo.sdk.WbSdk.isWbInstall(r2);	 Catch:{ Exception -> 0x00a6 }
            r4 = 1;	 Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x00a1;	 Catch:{ Exception -> 0x00a6 }
        L_0x0014:
            r2 = com.sina.weibo.sdk.share.WbShareTransActivity.this;	 Catch:{ Exception -> 0x00a6 }
            r2 = com.sina.weibo.sdk.WeiboAppManager.queryWbInfoInternal(r2);	 Catch:{ Exception -> 0x00a6 }
            r2 = r2.getSupportVersion();	 Catch:{ Exception -> 0x00a6 }
            r5 = 10772; // 0x2a14 float:1.5095E-41 double:5.322E-320;	 Catch:{ Exception -> 0x00a6 }
            if (r2 < r5) goto L_0x003d;	 Catch:{ Exception -> 0x00a6 }
        L_0x0022:
            r2 = r8.imageObject;	 Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x002c;	 Catch:{ Exception -> 0x00a6 }
        L_0x0026:
            r2 = r8.multiImageObject;	 Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x002c;	 Catch:{ Exception -> 0x00a6 }
        L_0x002a:
            r8.imageObject = r3;	 Catch:{ Exception -> 0x00a6 }
        L_0x002c:
            r2 = r8.videoSourceObject;	 Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x0041;	 Catch:{ Exception -> 0x00a6 }
        L_0x0030:
            r2 = r8.multiImageObject;	 Catch:{ Exception -> 0x00a6 }
            if (r2 != 0) goto L_0x0038;	 Catch:{ Exception -> 0x00a6 }
        L_0x0034:
            r2 = r8.imageObject;	 Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x0041;	 Catch:{ Exception -> 0x00a6 }
        L_0x0038:
            r8.multiImageObject = r3;	 Catch:{ Exception -> 0x00a6 }
            r8.imageObject = r3;	 Catch:{ Exception -> 0x00a6 }
            goto L_0x0041;	 Catch:{ Exception -> 0x00a6 }
        L_0x003d:
            r8.multiImageObject = r3;	 Catch:{ Exception -> 0x00a6 }
            r8.videoSourceObject = r3;	 Catch:{ Exception -> 0x00a6 }
        L_0x0041:
            r2 = r8.multiImageObject;	 Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x007e;	 Catch:{ Exception -> 0x00a6 }
        L_0x0045:
            r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00a6 }
            r2.<init>();	 Catch:{ Exception -> 0x00a6 }
            r3 = r8.multiImageObject;	 Catch:{ Exception -> 0x00a6 }
            r3 = r3.getImageList();	 Catch:{ Exception -> 0x00a6 }
            r3 = r3.iterator();	 Catch:{ Exception -> 0x00a6 }
        L_0x0054:
            r5 = r3.hasNext();	 Catch:{ Exception -> 0x00a6 }
            if (r5 == 0) goto L_0x0079;	 Catch:{ Exception -> 0x00a6 }
        L_0x005a:
            r5 = r3.next();	 Catch:{ Exception -> 0x00a6 }
            r5 = (android.net.Uri) r5;	 Catch:{ Exception -> 0x00a6 }
            r6 = com.sina.weibo.sdk.share.WbShareTransActivity.this;	 Catch:{ Exception -> 0x00a6 }
            r5 = com.sina.weibo.sdk.utils.ImageUtils.copyFileToWeiboTem(r6, r5, r4);	 Catch:{ Exception -> 0x00a6 }
            r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x00a6 }
            if (r6 != 0) goto L_0x0054;	 Catch:{ Exception -> 0x00a6 }
        L_0x006c:
            r6 = new java.io.File;	 Catch:{ Exception -> 0x00a6 }
            r6.<init>(r5);	 Catch:{ Exception -> 0x00a6 }
            r5 = android.net.Uri.fromFile(r6);	 Catch:{ Exception -> 0x00a6 }
            r2.add(r5);	 Catch:{ Exception -> 0x00a6 }
            goto L_0x0054;	 Catch:{ Exception -> 0x00a6 }
        L_0x0079:
            r3 = r8.multiImageObject;	 Catch:{ Exception -> 0x00a6 }
            r3.setImageList(r2);	 Catch:{ Exception -> 0x00a6 }
        L_0x007e:
            r2 = r8.videoSourceObject;	 Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x00a1;	 Catch:{ Exception -> 0x00a6 }
        L_0x0082:
            r2 = com.sina.weibo.sdk.share.WbShareTransActivity.this;	 Catch:{ Exception -> 0x00a6 }
            r3 = r8.videoSourceObject;	 Catch:{ Exception -> 0x00a6 }
            r3 = r3.videoPath;	 Catch:{ Exception -> 0x00a6 }
            r2 = com.sina.weibo.sdk.utils.ImageUtils.copyFileToWeiboTem(r2, r3, r0);	 Catch:{ Exception -> 0x00a6 }
            r3 = r8.videoSourceObject;	 Catch:{ Exception -> 0x00a6 }
            r5 = new java.io.File;	 Catch:{ Exception -> 0x00a6 }
            r5.<init>(r2);	 Catch:{ Exception -> 0x00a6 }
            r5 = android.net.Uri.fromFile(r5);	 Catch:{ Exception -> 0x00a6 }
            r3.videoPath = r5;	 Catch:{ Exception -> 0x00a6 }
            r3 = r8.videoSourceObject;	 Catch:{ Exception -> 0x00a6 }
            r5 = com.sina.weibo.sdk.utils.ImageUtils.getVideoDuring(r2);	 Catch:{ Exception -> 0x00a6 }
            r3.during = r5;	 Catch:{ Exception -> 0x00a6 }
        L_0x00a1:
            r1.message = r8;	 Catch:{ Exception -> 0x00a6 }
            r1.transDone = r4;	 Catch:{ Exception -> 0x00a6 }
            goto L_0x00a8;
        L_0x00a6:
            r1.transDone = r0;
        L_0x00a8:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.share.WbShareTransActivity.CopyResourceTask.doInBackground(com.sina.weibo.sdk.api.WeiboMultiMessage[]):com.sina.weibo.sdk.share.WbShareTransActivity$TransResourceResult");
        }

        protected void onPostExecute(TransResourceResult transResourceResult) {
            super.onPostExecute(transResourceResult);
            WbShareTransActivity.this.rootLayout.setVisibility(4);
            if (transResourceResult.transDone) {
                WbShareTransActivity.this.gotoWeiboComposer(transResourceResult.message);
            } else {
                WbShareTransActivity.this.sendCallback(2);
            }
        }
    }

    private class TransResourceResult {
        WeiboMultiMessage message;
        boolean transDone;

        private TransResourceResult() {
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.startActivityName = getIntent().getStringExtra(WBConstants.SHARE_START_ACTIVITY);
        if (bundle != null) {
            this.startActivityName = bundle.getString(WBConstants.SHARE_START_ACTIVITY);
            this.flag = bundle.getBoolean(WBConstants.SHARE_START_RESULT_FLAG, false);
            return;
        }
        checkSource();
    }

    private void checkSource() {
        Bundle extras = getIntent().getExtras();
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.toObject(extras);
        transPicAndVideoResource(weiboMultiMessage);
    }

    private void initView() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.getIntent();
        r1 = "progressColor";
        r2 = -1;
        r0 = r0.getIntExtra(r1, r2);
        r3.progressColor = r0;
        r0 = r3.getIntent();
        r1 = "progressId";
        r0 = r0.getIntExtra(r1, r2);
        r3.progressId = r0;
        r0 = new android.widget.FrameLayout;
        r0.<init>(r3);
        r3.rootLayout = r0;
        r0 = r3.progressId;
        if (r0 == r2) goto L_0x003e;
    L_0x0024:
        r0 = "layout_inflater";
        r0 = r3.getSystemService(r0);
        r0 = (android.view.LayoutInflater) r0;
        r1 = r3.progressId;	 Catch:{ Exception -> 0x0036 }
        r2 = 0;	 Catch:{ Exception -> 0x0036 }
        r0 = r0.inflate(r1, r2);	 Catch:{ Exception -> 0x0036 }
        r3.progressBar = r0;	 Catch:{ Exception -> 0x0036 }
        goto L_0x0052;
    L_0x0036:
        r0 = new com.sina.weibo.sdk.web.view.WbSdkProgressBar;
        r0.<init>(r3);
        r3.progressBar = r0;
        goto L_0x0052;
    L_0x003e:
        r0 = new com.sina.weibo.sdk.web.view.WbSdkProgressBar;
        r0.<init>(r3);
        r3.progressBar = r0;
        r0 = r3.progressColor;
        if (r0 == r2) goto L_0x0052;
    L_0x0049:
        r0 = r3.progressBar;
        r0 = (com.sina.weibo.sdk.web.view.WbSdkProgressBar) r0;
        r1 = r3.progressColor;
        r0.setProgressColor(r1);
    L_0x0052:
        r0 = new android.widget.FrameLayout$LayoutParams;
        r1 = -2;
        r0.<init>(r1, r1);
        r1 = 17;
        r0.gravity = r1;
        r1 = r3.rootLayout;
        r2 = r3.progressBar;
        r1.addView(r2, r0);
        r0 = r3.rootLayout;
        r1 = 855638016; // 0x33000000 float:2.9802322E-8 double:4.22741349E-315;
        r0.setBackgroundColor(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.share.WbShareTransActivity.initView():void");
    }

    private void gotoWeiboComposer(com.sina.weibo.sdk.api.WeiboMultiMessage r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.getIntent();
        r1 = 1;
        r4.flag = r1;
        r1 = "startFlag";
        r2 = -1;
        r0.putExtra(r1, r2);
        r1 = new android.content.Intent;
        r2 = "com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY";
        r1.<init>(r2);
        r2 = "startPackage";
        r2 = r0.getStringExtra(r2);
        r1.setPackage(r2);
        r2 = "startAction";
        r2 = r0.getStringExtra(r2);
        r1.setAction(r2);
        r2 = r0.getExtras();
        r5.toBundle(r2);
        r1.putExtras(r2);
        r5 = r4.getPackageName();
        r2 = "_weibo_sdkVersion";
        r3 = "0041005000";
        r1.putExtra(r2, r3);
        r2 = "_weibo_appPackage";
        r1.putExtra(r2, r5);
        r2 = "_weibo_appKey";
        r3 = com.sina.weibo.sdk.WbSdk.getAuthInfo();
        r3 = r3.getAppKey();
        r1.putExtra(r2, r3);
        r2 = "_weibo_flag";
        r3 = 538116905; // 0x20130329 float:1.245243E-19 double:2.65865076E-315;
        r1.putExtra(r2, r3);
        r2 = "_weibo_sign";
        r5 = com.sina.weibo.sdk.utils.Utility.getSign(r4, r5);
        r5 = com.sina.weibo.sdk.utils.MD5.hexdigest(r5);
        r1.putExtra(r2, r5);
        r5 = 2;
        r2 = "gotoActivity";	 Catch:{ Exception -> 0x008c }
        r2 = r0.getStringExtra(r2);	 Catch:{ Exception -> 0x008c }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x008c }
        if (r2 != 0) goto L_0x007c;	 Catch:{ Exception -> 0x008c }
    L_0x006f:
        r2 = "gotoActivity";	 Catch:{ Exception -> 0x008c }
        r0 = r0.getStringExtra(r2);	 Catch:{ Exception -> 0x008c }
        r1.setClassName(r4, r0);	 Catch:{ Exception -> 0x008c }
        r4.startActivity(r1);	 Catch:{ Exception -> 0x008c }
        return;	 Catch:{ Exception -> 0x008c }
    L_0x007c:
        r0 = com.sina.weibo.sdk.WbSdk.isWbInstall(r4);	 Catch:{ Exception -> 0x008c }
        if (r0 == 0) goto L_0x0088;	 Catch:{ Exception -> 0x008c }
    L_0x0082:
        r0 = 765; // 0x2fd float:1.072E-42 double:3.78E-321;	 Catch:{ Exception -> 0x008c }
        r4.startActivityForResult(r1, r0);	 Catch:{ Exception -> 0x008c }
        return;	 Catch:{ Exception -> 0x008c }
    L_0x0088:
        r4.sendCallback(r5);	 Catch:{ Exception -> 0x008c }
        return;
    L_0x008c:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x00af }
        r0.<init>();	 Catch:{ Exception -> 0x00af }
        r1 = new android.os.Bundle;	 Catch:{ Exception -> 0x00af }
        r1.<init>();	 Catch:{ Exception -> 0x00af }
        r2 = "_weibo_resp_errcode";	 Catch:{ Exception -> 0x00af }
        r1.putInt(r2, r5);	 Catch:{ Exception -> 0x00af }
        r0.putExtras(r1);	 Catch:{ Exception -> 0x00af }
        r5 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;	 Catch:{ Exception -> 0x00af }
        r0.setFlags(r5);	 Catch:{ Exception -> 0x00af }
        r5 = r4.startActivityName;	 Catch:{ Exception -> 0x00af }
        r0.setClassName(r4, r5);	 Catch:{ Exception -> 0x00af }
        r4.startActivity(r0);	 Catch:{ Exception -> 0x00af }
        r4.finish();	 Catch:{ Exception -> 0x00af }
        return;
    L_0x00af:
        r4.finish();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.share.WbShareTransActivity.gotoWeiboComposer(com.sina.weibo.sdk.api.WeiboMultiMessage):void");
    }

    private void transPicAndVideoResource(WeiboMultiMessage weiboMultiMessage) {
        setContentView(this.rootLayout);
        if (weiboMultiMessage.multiImageObject == null) {
            if (weiboMultiMessage.videoSourceObject == null) {
                gotoWeiboComposer(weiboMultiMessage);
                return;
            }
        }
        setContentView(this.rootLayout);
        if (this.copyResourceTask != null) {
            this.copyResourceTask.cancel(true);
        }
        this.copyResourceTask = new CopyResourceTask();
        this.copyResourceTask.execute(new WeiboMultiMessage[]{weiboMultiMessage});
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.handler != 0) {
            this.handler.sendEmptyMessageDelayed(0, 100);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 ? true : super.onKeyDown(i, keyEvent);
    }

    protected void onNewIntent(android.content.Intent r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        super.onNewIntent(r3);
        r0 = "startFlag";
        r1 = -1;
        r0 = r3.getIntExtra(r0, r1);
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.handler;
        r1 = 0;
        r0.removeMessages(r1);
        r0 = 0;
        r2.handler = r0;
        r3 = r3.getExtras();	 Catch:{ Exception -> 0x002f }
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x002f }
        r0.<init>();	 Catch:{ Exception -> 0x002f }
        r0.putExtras(r3);	 Catch:{ Exception -> 0x002f }
        r3 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;	 Catch:{ Exception -> 0x002f }
        r0.setFlags(r3);	 Catch:{ Exception -> 0x002f }
        r3 = r2.startActivityName;	 Catch:{ Exception -> 0x002f }
        r0.setClassName(r2, r3);	 Catch:{ Exception -> 0x002f }
        r2.startActivity(r0);	 Catch:{ Exception -> 0x002f }
    L_0x002f:
        r2.finish();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.share.WbShareTransActivity.onNewIntent(android.content.Intent):void");
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.remove(WBConstants.SHARE_START_FLAG);
        bundle.putBoolean(WBConstants.SHARE_START_RESULT_FLAG, true);
        bundle.putString(WBConstants.SHARE_START_ACTIVITY, this.startActivityName);
    }

    private void sendCallback(int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.rootLayout;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = r3.rootLayout;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x000b:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x002a }
        r0.<init>();	 Catch:{ Exception -> 0x002a }
        r1 = new android.os.Bundle;	 Catch:{ Exception -> 0x002a }
        r1.<init>();	 Catch:{ Exception -> 0x002a }
        r2 = "_weibo_resp_errcode";	 Catch:{ Exception -> 0x002a }
        r1.putInt(r2, r4);	 Catch:{ Exception -> 0x002a }
        r0.putExtras(r1);	 Catch:{ Exception -> 0x002a }
        r4 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;	 Catch:{ Exception -> 0x002a }
        r0.setFlags(r4);	 Catch:{ Exception -> 0x002a }
        r4 = r3.startActivityName;	 Catch:{ Exception -> 0x002a }
        r0.setClassName(r3, r4);	 Catch:{ Exception -> 0x002a }
        r3.startActivity(r0);	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        r3.finish();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.share.WbShareTransActivity.sendCallback(int):void");
    }
}
