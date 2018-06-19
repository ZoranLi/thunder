package com.umeng.socialize;

import android.app.Activity;
import android.view.View;
import anet.channel.util.HttpConstant;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.shareboard.ShareBoard;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShareAction {
    private Activity activity;
    private ShareBoardlistener boardlistener = null;
    private List<ShareContent> contentlist = new ArrayList();
    private ShareBoardlistener defaultmulshareboardlistener = new ShareBoardlistener() {
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            snsPlatform = ShareAction.this.displaylist.indexOf(share_media);
            int size = ShareAction.this.contentlist.size();
            if (size != 0) {
                ShareContent shareContent;
                if (snsPlatform < size) {
                    shareContent = (ShareContent) ShareAction.this.contentlist.get(snsPlatform);
                } else {
                    shareContent = (ShareContent) ShareAction.this.contentlist.get(size - 1);
                }
                ShareAction.this.mShareContent = shareContent;
            }
            size = ShareAction.this.listenerlist.size();
            if (size != 0) {
                if (snsPlatform < size) {
                    ShareAction.this.mListener = (UMShareListener) ShareAction.this.listenerlist.get(snsPlatform);
                } else {
                    ShareAction.this.mListener = (UMShareListener) ShareAction.this.listenerlist.get(size - 1);
                }
            }
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };
    private ShareBoardlistener defaultshareboardlistener = new ShareBoardlistener() {
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };
    private List<SHARE_MEDIA> displaylist = null;
    private int gravity = 80;
    private List<UMShareListener> listenerlist = new ArrayList();
    private UMShareListener mListener = null;
    private SHARE_MEDIA mPlatform = null;
    private ShareBoard mShareBoard;
    private ShareContent mShareContent = new ShareContent();
    private List<SnsPlatform> platformlist = new ArrayList();
    private View showatView = null;

    public ShareAction(Activity activity) {
        if (activity != null) {
            this.activity = (Activity) new WeakReference(activity).get();
        }
    }

    public ShareContent getShareContent() {
        return this.mShareContent;
    }

    public boolean getUrlValid() {
        return this.mShareContent == null || this.mShareContent.mMedia == null || !(this.mShareContent.mMedia instanceof UMWeb) || this.mShareContent.mMedia.toUrl().startsWith(HttpConstant.HTTP);
    }

    public SHARE_MEDIA getPlatform() {
        return this.mPlatform;
    }

    public ShareAction setPlatform(SHARE_MEDIA share_media) {
        this.mPlatform = share_media;
        return this;
    }

    public ShareAction setCallback(UMShareListener uMShareListener) {
        this.mListener = uMShareListener;
        return this;
    }

    public ShareAction setShareboardclickCallback(ShareBoardlistener shareBoardlistener) {
        this.boardlistener = shareBoardlistener;
        return this;
    }

    public ShareAction setShareContent(ShareContent shareContent) {
        this.mShareContent = shareContent;
        return this;
    }

    public ShareAction setDisplayList(SHARE_MEDIA... share_mediaArr) {
        this.displaylist = Arrays.asList(share_mediaArr);
        this.platformlist.clear();
        for (SHARE_MEDIA toSnsPlatform : this.displaylist) {
            this.platformlist.add(toSnsPlatform.toSnsPlatform());
        }
        return this;
    }

    @Deprecated
    public ShareAction setListenerList(UMShareListener... uMShareListenerArr) {
        this.listenerlist = Arrays.asList(uMShareListenerArr);
        return this;
    }

    @Deprecated
    public ShareAction setContentList(ShareContent... shareContentArr) {
        if (shareContentArr != null) {
            if (Arrays.asList(shareContentArr).size() != 0) {
                this.contentlist = Arrays.asList(shareContentArr);
                return this;
            }
        }
        shareContentArr = new ShareContent();
        shareContentArr.mText = "empty";
        this.contentlist.add(shareContentArr);
        return this;
    }

    public ShareAction addButton(String str, String str2, String str3, String str4) {
        this.platformlist.add(SHARE_MEDIA.createSnsPlatform(str, str2, str3, str4, 0));
        return this;
    }

    public ShareAction withText(String str) {
        this.mShareContent.mText = str;
        return this;
    }

    public ShareAction withSubject(String str) {
        this.mShareContent.subject = str;
        return this;
    }

    public ShareAction withFile(File file) {
        this.mShareContent.file = file;
        return this;
    }

    public ShareAction withApp(File file) {
        this.mShareContent.app = file;
        return this;
    }

    public ShareAction withMedia(UMImage uMImage) {
        this.mShareContent.mMedia = uMImage;
        return this;
    }

    public ShareAction withMedia(UMMin uMMin) {
        this.mShareContent.mMedia = uMMin;
        return this;
    }

    public ShareAction withMedia(UMEmoji uMEmoji) {
        this.mShareContent.mMedia = uMEmoji;
        return this;
    }

    public ShareAction withMedia(UMWeb uMWeb) {
        this.mShareContent.mMedia = uMWeb;
        return this;
    }

    public ShareAction withFollow(String str) {
        this.mShareContent.mFollow = str;
        return this;
    }

    public ShareAction withExtra(UMImage uMImage) {
        this.mShareContent.mExtra = uMImage;
        return this;
    }

    public ShareAction withMedia(UMusic uMusic) {
        this.mShareContent.mMedia = uMusic;
        return this;
    }

    public ShareAction withMedia(UMVideo uMVideo) {
        this.mShareContent.mMedia = uMVideo;
        return this;
    }

    public ShareAction withShareBoardDirection(View view, int i) {
        this.gravity = i;
        this.showatView = view;
        return this;
    }

    public void share() {
        UMShareAPI.get(this.activity).doShare(this.activity, this, this.mListener);
    }

    public void open(com.umeng.socialize.shareboard.ShareBoardConfig r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.platformlist;
        r0 = r0.size();
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x006c;
    L_0x000a:
        r0 = new java.util.HashMap;
        r0.<init>();
        r3 = "listener";
        r4 = r5.mListener;
        r0.put(r3, r4);
        r3 = "content";
        r4 = r5.mShareContent;
        r0.put(r3, r4);
        r0 = new com.umeng.socialize.shareboard.ShareBoard;	 Catch:{ Exception -> 0x0065 }
        r3 = r5.activity;	 Catch:{ Exception -> 0x0065 }
        r4 = r5.platformlist;	 Catch:{ Exception -> 0x0065 }
        r0.<init>(r3, r4, r6);	 Catch:{ Exception -> 0x0065 }
        r5.mShareBoard = r0;	 Catch:{ Exception -> 0x0065 }
        r6 = r5.boardlistener;	 Catch:{ Exception -> 0x0065 }
        if (r6 != 0) goto L_0x0034;	 Catch:{ Exception -> 0x0065 }
    L_0x002c:
        r6 = r5.mShareBoard;	 Catch:{ Exception -> 0x0065 }
        r0 = r5.defaultmulshareboardlistener;	 Catch:{ Exception -> 0x0065 }
        r6.setShareBoardlistener(r0);	 Catch:{ Exception -> 0x0065 }
        goto L_0x003b;	 Catch:{ Exception -> 0x0065 }
    L_0x0034:
        r6 = r5.mShareBoard;	 Catch:{ Exception -> 0x0065 }
        r0 = r5.boardlistener;	 Catch:{ Exception -> 0x0065 }
        r6.setShareBoardlistener(r0);	 Catch:{ Exception -> 0x0065 }
    L_0x003b:
        r6 = r5.mShareBoard;	 Catch:{ Exception -> 0x0065 }
        r6.setFocusable(r1);	 Catch:{ Exception -> 0x0065 }
        r6 = r5.mShareBoard;	 Catch:{ Exception -> 0x0065 }
        r0 = new android.graphics.drawable.BitmapDrawable;	 Catch:{ Exception -> 0x0065 }
        r0.<init>();	 Catch:{ Exception -> 0x0065 }
        r6.setBackgroundDrawable(r0);	 Catch:{ Exception -> 0x0065 }
        r6 = r5.showatView;	 Catch:{ Exception -> 0x0065 }
        if (r6 != 0) goto L_0x005a;	 Catch:{ Exception -> 0x0065 }
    L_0x004e:
        r6 = r5.activity;	 Catch:{ Exception -> 0x0065 }
        r6 = r6.getWindow();	 Catch:{ Exception -> 0x0065 }
        r6 = r6.getDecorView();	 Catch:{ Exception -> 0x0065 }
        r5.showatView = r6;	 Catch:{ Exception -> 0x0065 }
    L_0x005a:
        r6 = r5.mShareBoard;	 Catch:{ Exception -> 0x0065 }
        r0 = r5.showatView;	 Catch:{ Exception -> 0x0065 }
        r1 = r5.gravity;	 Catch:{ Exception -> 0x0065 }
        r6.showAtLocation(r0, r1, r2, r2);	 Catch:{ Exception -> 0x0065 }
        goto L_0x00f1;
    L_0x0065:
        r6 = "";
        com.umeng.socialize.utils.Log.e(r6);
        goto L_0x00f1;
    L_0x006c:
        r0 = r5.platformlist;
        r3 = com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN;
        r3 = r3.toSnsPlatform();
        r0.add(r3);
        r0 = r5.platformlist;
        r3 = com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN_CIRCLE;
        r3 = r3.toSnsPlatform();
        r0.add(r3);
        r0 = r5.platformlist;
        r3 = com.umeng.socialize.bean.SHARE_MEDIA.SINA;
        r3 = r3.toSnsPlatform();
        r0.add(r3);
        r0 = r5.platformlist;
        r3 = com.umeng.socialize.bean.SHARE_MEDIA.QQ;
        r3 = r3.toSnsPlatform();
        r0.add(r3);
        r0 = new java.util.HashMap;
        r0.<init>();
        r3 = "listener";
        r4 = r5.mListener;
        r0.put(r3, r4);
        r3 = "content";
        r4 = r5.mShareContent;
        r0.put(r3, r4);
        r0 = new com.umeng.socialize.shareboard.ShareBoard;
        r3 = r5.activity;
        r4 = r5.platformlist;
        r0.<init>(r3, r4, r6);
        r5.mShareBoard = r0;
        r6 = r5.boardlistener;
        if (r6 != 0) goto L_0x00c2;
    L_0x00ba:
        r6 = r5.mShareBoard;
        r0 = r5.defaultshareboardlistener;
        r6.setShareBoardlistener(r0);
        goto L_0x00c9;
    L_0x00c2:
        r6 = r5.mShareBoard;
        r0 = r5.boardlistener;
        r6.setShareBoardlistener(r0);
    L_0x00c9:
        r6 = r5.mShareBoard;
        r6.setFocusable(r1);
        r6 = r5.mShareBoard;
        r0 = new android.graphics.drawable.BitmapDrawable;
        r0.<init>();
        r6.setBackgroundDrawable(r0);
        r6 = r5.showatView;
        if (r6 != 0) goto L_0x00e8;
    L_0x00dc:
        r6 = r5.activity;
        r6 = r6.getWindow();
        r6 = r6.getDecorView();
        r5.showatView = r6;
    L_0x00e8:
        r6 = r5.mShareBoard;
        r0 = r5.showatView;
        r1 = 80;
        r6.showAtLocation(r0, r1, r2, r2);
    L_0x00f1:
        r6 = r5.activity;
        com.umeng.socialize.net.analytics.SocialAnalytics.shareBoardStats(r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.ShareAction.open(com.umeng.socialize.shareboard.ShareBoardConfig):void");
    }

    public void open() {
        open(null);
    }

    public void close() {
        if (this.mShareBoard != null) {
            this.mShareBoard.dismiss();
            this.mShareBoard = null;
        }
    }

    public static android.graphics.Rect locateView(android.view.View r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 2;
        r0 = new int[r0];
        r1 = 0;
        if (r3 != 0) goto L_0x0007;
    L_0x0006:
        return r1;
    L_0x0007:
        r3.getLocationOnScreen(r0);	 Catch:{ NullPointerException -> 0x002c }
        r1 = new android.graphics.Rect;
        r1.<init>();
        r2 = 0;
        r2 = r0[r2];
        r1.left = r2;
        r2 = 1;
        r0 = r0[r2];
        r1.top = r0;
        r0 = r1.left;
        r2 = r3.getWidth();
        r0 = r0 + r2;
        r1.right = r0;
        r0 = r1.top;
        r3 = r3.getHeight();
        r0 = r0 + r3;
        r1.bottom = r0;
        return r1;
    L_0x002c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.ShareAction.locateView(android.view.View):android.graphics.Rect");
    }
}
