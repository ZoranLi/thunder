package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.SocialConstants;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.umeng.socialize.PlatformConfig.Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.editorpage.IEditor;
import com.umeng.socialize.net.RestAPI;
import com.umeng.socialize.net.SharePostRequest;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.Log;
import java.util.Map;
import java.util.Stack;

public abstract class UMAPIShareHandler extends UMSSOHandler implements IEditor {
    private Stack<StatHolder> mStatStack = new Stack();

    private static class StatHolder {
        public ShareContent Content;
        private UMShareListener Listener;

        private StatHolder() {
        }
    }

    public abstract void authorizeCallBack(int i, int i2, Intent intent);

    public abstract void deleteAuth();

    public abstract SHARE_MEDIA getPlatform();

    public abstract String getUID();

    public void onCreate(Context context, Platform platform) {
        super.onCreate(context, platform);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == getRequestCode()) {
            StatHolder statHolder;
            if (i2 == 1000) {
                if (this.mStatStack.isEmpty() == 0) {
                    statHolder = (StatHolder) this.mStatStack.pop();
                    if (statHolder != null) {
                        statHolder.Listener.onCancel(getPlatform());
                    }
                }
            } else if (intent == null || !intent.hasExtra(SocializeConstants.KEY_TEXT)) {
                authorizeCallBack(i, i2, intent);
            } else if (this.mStatStack.empty() == 0) {
                statHolder = (StatHolder) this.mStatStack.pop();
                intent = intent.getExtras();
                if (i2 == -1) {
                    QueuedWork.runInBack(new Runnable() {
                        public void run() {
                            UMAPIShareHandler.this.sendShareRequest(UMAPIShareHandler.this.getResult(statHolder.Content, intent), statHolder.Listener);
                            Log.d(SocialConstants.PARAM_ACT, "sent share request");
                        }
                    }, 1);
                    return;
                }
                if (statHolder.Listener != 0) {
                    statHolder.Listener.onCancel(getPlatform());
                }
            }
        }
    }

    public boolean share(final ShareContent shareContent, final UMShareListener uMShareListener) {
        if (isAuthorize()) {
            doShare(shareContent, uMShareListener);
        } else {
            authorize(new UMAuthListener() {
                public void onStart(SHARE_MEDIA share_media) {
                    uMShareListener.onStart(share_media);
                }

                public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                    QueuedWork.runInBack(new Runnable() {
                        public void run() {
                            UMAPIShareHandler.this.doShare(shareContent, uMShareListener);
                        }
                    }, 1);
                }

                public void onError(SHARE_MEDIA share_media, int i, Throwable th) {
                    uMShareListener.onError(share_media, th);
                }

                public void onCancel(SHARE_MEDIA share_media, int i) {
                    uMShareListener.onCancel(share_media);
                }
            });
        }
        return null;
    }

    protected void doShare(ShareContent shareContent, UMShareListener uMShareListener) {
        if (getShareConfig().isOpenShareEditActivity()) {
            StatHolder statHolder = new StatHolder();
            statHolder.Content = shareContent;
            statHolder.Listener = uMShareListener;
            this.mStatStack.push(statHolder);
            if (!(this.mWeakAct.get() == null || ((Activity) this.mWeakAct.get()).isFinishing())) {
                try {
                    Intent intent = new Intent((Context) this.mWeakAct.get(), Class.forName("com.umeng.socialize.editorpage.ShareActivity"));
                    intent.putExtras(getEditable(shareContent));
                    ((Activity) this.mWeakAct.get()).startActivityForResult(intent, getRequestCode());
                    return;
                } catch (ClassNotFoundException e) {
                    sendShareRequest(shareContent, uMShareListener);
                    Log.e("没有加入界面jar");
                    e.printStackTrace();
                }
            }
            return;
        }
        sendShareRequest(shareContent, uMShareListener);
    }

    public void sendShareRequest(ShareContent shareContent, final UMShareListener uMShareListener) {
        final SHARE_MEDIA platform = getPlatform();
        SharePostRequest sharePostRequest = new SharePostRequest(getContext(), platform.toString().toLowerCase(), getUID(), shareContent);
        sharePostRequest.setReqType(0);
        final SocializeReseponse doShare = RestAPI.doShare(sharePostRequest);
        if (doShare == null) {
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    UMShareListener uMShareListener = uMShareListener;
                    SHARE_MEDIA share_media = platform;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(UmengErrorCode.ShareFailed.getMessage());
                    stringBuilder.append("response is null");
                    uMShareListener.onError(share_media, new Throwable(stringBuilder.toString()));
                }
            });
        } else if (doShare.isOk()) {
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    uMShareListener.onResult(platform);
                }
            });
        } else {
            final SocializeReseponse socializeReseponse = doShare;
            final ShareContent shareContent2 = shareContent;
            final UMShareListener uMShareListener2 = uMShareListener;
            QueuedWork.runInMain(new Runnable() {
                public void run() {
                    if (socializeReseponse.mStCode == ReaderCallback.READER_PLUGIN_SO_INTO_START) {
                        UMAPIShareHandler.this.deleteAuth();
                        UMAPIShareHandler.this.share(shareContent2, uMShareListener2);
                        return;
                    }
                    UMShareListener uMShareListener = uMShareListener2;
                    SHARE_MEDIA share_media = platform;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(UmengErrorCode.ShareFailed.getMessage());
                    stringBuilder.append(doShare.mMsg);
                    uMShareListener.onError(share_media, new Throwable(stringBuilder.toString()));
                }
            });
        }
    }
}
