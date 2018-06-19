package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBConstants.Msg;
import com.sina.weibo.sdk.constant.WBConstants.Response;
import com.sina.weibo.sdk.utils.ImageUtils;
import com.sina.weibo.sdk.utils.LogUtil;

public class WbShareToStoryActivity extends Activity {
    private String callbackActivity;
    private View progressBar;
    private int progressColor = -1;
    private int progressId = -1;
    private FrameLayout rootLayout;
    private SaveFileTask saveFileTask;

    private class SaveFileTask extends AsyncTask<StoryMessage, Object, StoryObject> {
        private SaveFileTask() {
        }

        protected StoryObject doInBackground(StoryMessage... storyMessageArr) {
            int i = 0;
            storyMessageArr = storyMessageArr[0];
            if (storyMessageArr.getVideoUri() == null) {
                i = 1;
            }
            storyMessageArr = ImageUtils.copyFileToWeiboTem(WbShareToStoryActivity.this, i == 1 ? storyMessageArr.getImageUri() : storyMessageArr.getVideoUri(), i);
            if (TextUtils.isEmpty(storyMessageArr)) {
                return null;
            }
            StoryObject storyObject = new StoryObject();
            storyObject.sourcePath = storyMessageArr;
            storyObject.sourceType = i;
            storyObject.appId = WbSdk.getAuthInfo().getAppKey();
            storyObject.appPackage = WbShareToStoryActivity.this.getPackageName();
            return storyObject;
        }

        protected void onPostExecute(com.sina.weibo.sdk.api.StoryObject r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            super.onPostExecute(r4);
            if (r4 == 0) goto L_0x001d;
        L_0x0005:
            r0 = new android.content.Intent;	 Catch:{ Exception -> 0x001d }
            r1 = "android.intent.action.VIEW";	 Catch:{ Exception -> 0x001d }
            r2 = "sinaweibo://story/publish?forceedit=1&finish=true";	 Catch:{ Exception -> 0x001d }
            r2 = android.net.Uri.parse(r2);	 Catch:{ Exception -> 0x001d }
            r0.<init>(r1, r2);	 Catch:{ Exception -> 0x001d }
            r1 = "storyData";	 Catch:{ Exception -> 0x001d }
            r0.putExtra(r1, r4);	 Catch:{ Exception -> 0x001d }
            r4 = com.sina.weibo.sdk.share.WbShareToStoryActivity.this;	 Catch:{ Exception -> 0x001d }
            r4.startActivity(r0);	 Catch:{ Exception -> 0x001d }
            return;
        L_0x001d:
            r4 = com.sina.weibo.sdk.share.WbShareToStoryActivity.this;
            r0 = 2;
            r4.setCallbackActivity(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.share.WbShareToStoryActivity.SaveFileTask.onPostExecute(com.sina.weibo.sdk.api.StoryObject):void");
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.callbackActivity = bundle.getString(WBConstants.SHARE_START_ACTIVITY);
        } else {
            this.callbackActivity = getIntent().getStringExtra(WBConstants.SHARE_START_ACTIVITY);
        }
        StoryMessage storyMessage = (StoryMessage) getIntent().getParcelableExtra(Msg.STORY);
        if (storyMessage == null) {
            setCallbackActivity(2);
        } else if (checkInfo(storyMessage)) {
            initView();
            gotoSave(storyMessage);
        } else {
            setCallbackActivity(2);
        }
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
        r0 = r3.rootLayout;
        r3.setContentView(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.share.WbShareToStoryActivity.initView():void");
    }

    private boolean checkInfo(StoryMessage storyMessage) {
        return (storyMessage.checkSource() == null || WbSdk.supportMultiImage(this) == null) ? null : true;
    }

    private void gotoSave(StoryMessage storyMessage) {
        if (this.saveFileTask != null) {
            this.saveFileTask.cancel(true);
        }
        this.saveFileTask = new SaveFileTask();
        this.saveFileTask.execute(new StoryMessage[]{storyMessage});
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getIntExtra("backType", 0) == null) {
            setCallbackActivity(1);
        } else {
            setCallbackActivity(0);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(WBConstants.SHARE_START_ACTIVITY, this.callbackActivity);
    }

    private void setCallbackActivity(int i) {
        if (this.rootLayout != null) {
            this.rootLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            intent.putExtra(Response.ERRCODE, i);
            intent.setFlags(131072);
            intent.setClassName(this, this.callbackActivity);
            startActivity(intent);
        } catch (int i2) {
            LogUtil.v("weibo sdk", i2.toString());
        }
        finish();
    }
}
