package com.xunlei.downloadprovider.personal.message.data.vo;

import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

public class MessageInfo extends CommentInfo {
    public static final String CID = "cid";
    public static final String CONSUMER = "consumer";
    public static final String GCID = "gcid";
    public static final String HAVE_READ = "have_read";
    public static final String INITIATOR = "initiator";
    public static final String INITIATOR_NAME = "initiator_name";
    public static final String INITIATOR_PORTRAIT = "initiator_portrait";
    public static final String INSERT_TIME = "insert_time";
    public static final String ISFOLLOW = "isfollow";
    public static final String MSGID = "msgid";
    public static final String ORIGINAL = "original";
    public static final String REPLY = "reply";
    public static final String RESOURCE_ID = "resource_id";
    public static final String SITE = "site";
    private static final String TAG = "msgCenter.MessageInfo";
    public static final String TYPE = "type";
    public static final int TYPE_DOWNLOAD_RESOURCE_LIKE = 7;
    public static final int TYPE_DOWNLOAD_RESOURCE_REPLY = 6;
    public static final int TYPE_HISTORY_ATTENTION = 3;
    public static final int TYPE_HISTORY_LIKE = 2;
    public static final int TYPE_HISTORY_REPLY = 1;
    public static final int TYPE_HISTORY_VIDEO_LIKE = 4;
    public static final int TYPE_HISTORY_VIDEO_REPLY = 5;
    public static final int TYPE_LOAD_MORE = -1;
    public static final int TYPE_WEBSITE_COMMENT = 19;
    public static final int TYPE_WEBSITE_COMMENT_LIKE = 22;
    public static final int TYPE_WEBSITE_COMMENT_REPLY = 21;
    public static final int TYPE_WEBSITE_LIKE = 20;
    public static final String USER = "user";
    public static final String VIDEO_COVER_URL = "video_cover_url";
    public static final String VIDEO_STATUS = "video_status";
    public static final int VIDEO_STATUS_DELETE = 2;
    public static final int VIDEO_STATUS_NOT_FIND = -2;
    public static final int VIDEO_STATUS_OUT_LINE = 0;
    private boolean hasRead;
    private int isFollow;
    private String mPoster;
    private WebsiteInfo mWebsiteInfo = null;
    private long msgid;
    private TargetCommentInfo targetCommentInfo;
    private int type;
    private int videoStatus = 1;
    private VideoUserInfo videoUserInfo = null;

    public static boolean isValidMessageType(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                break;
            default:
                switch (i) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        break;
                    default:
                        return false;
                }
        }
        return true;
    }

    public static boolean isWebSiteType(int i) {
        if (!(i == 19 || i == 20 || i == 21)) {
            if (i != 22) {
                return false;
            }
        }
        return true;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public TargetCommentInfo getTargetCommentInfo() {
        return this.targetCommentInfo;
    }

    public void setTargetCommentInfo(TargetCommentInfo targetCommentInfo) {
        this.targetCommentInfo = targetCommentInfo;
    }

    public static com.xunlei.downloadprovider.personal.message.data.vo.a parseFromJsonObject(org.json.JSONObject r28) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = r28;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3 = new com.xunlei.downloadprovider.personal.message.data.vo.a;
        r3.<init>();
        r3.c = r2;
        r4 = 1;
        r3.a = r4;
        r5 = "0";
        r3.b = r5;
        if (r1 == 0) goto L_0x0198;
    L_0x0017:
        r5 = "result";
        r5 = r1.has(r5);
        if (r5 == 0) goto L_0x0198;
    L_0x001f:
        r5 = "result";
        r5 = r1.optString(r5);
        if (r5 == 0) goto L_0x0198;
    L_0x0027:
        r6 = "ok";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0198;
    L_0x002f:
        r5 = "messages";
        r5 = r1.has(r5);
        if (r5 == 0) goto L_0x0186;
    L_0x0037:
        r5 = "messages";
        r5 = r1.optJSONArray(r5);
        if (r5 == 0) goto L_0x0186;
    L_0x003f:
        r7 = r5.length();
        if (r7 <= 0) goto L_0x0186;
    L_0x0045:
        r7 = 0;
    L_0x0046:
        r8 = r5.length();
        if (r7 >= r8) goto L_0x0186;
    L_0x004c:
        r8 = r5.optJSONObject(r7);
        r9 = "type";
        r9 = r8.optInt(r9);
        r10 = isValidMessageType(r9);
        if (r10 == 0) goto L_0x0173;
    L_0x005c:
        r10 = "gcid";
        r10 = r8.optString(r10);
        r11 = "resource_id";
        r11 = r8.optString(r11);
        r12 = isWebSiteType(r9);
        if (r12 == 0) goto L_0x006f;
    L_0x006e:
        r10 = r11;
    L_0x006f:
        r12 = "consumer";
        r8.optString(r12);
        r12 = "insert_time";
        r12 = r8.optLong(r12);
        r14 = "have_read";
        r14 = r8.optBoolean(r14);
        r15 = "original";
        r15 = r8.optString(r15);
        r6 = "reply";
        r6 = r8.optString(r6);
        r4 = "msgid";
        r17 = r5;
        r4 = r8.optLong(r4);
        r18 = r3;
        r3 = "cid";
        r19 = r2;
        r1 = r8.optLong(r3);
        r3 = "isfollow";
        r3 = r8.optInt(r3);
        r20 = r7;
        r7 = "video_cover_url";
        r7 = r8.optString(r7);
        r21 = r15;
        r15 = "video_status";
        r22 = r3;
        r3 = 1;
        r15 = r8.optInt(r15, r3);
        r16 = 0;
        r3 = "user";	 Catch:{ JSONException -> 0x00c4 }
        r3 = r8.optJSONObject(r3);	 Catch:{ JSONException -> 0x00c4 }
        r3 = com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo.parseFrom(r3);	 Catch:{ JSONException -> 0x00c4 }
        goto L_0x00cb;
    L_0x00c4:
        r0 = move-exception;
        r3 = r0;
        r3.printStackTrace();
        r3 = r16;
    L_0x00cb:
        if (r3 == 0) goto L_0x0170;
    L_0x00cd:
        r23 = r12;
        r12 = "initiator";
        r12 = r8.optLong(r12);
        r25 = r6;
        r6 = r3.getNickname();
        r26 = r6;
        r6 = r3.getPortraitUrl();
        r27 = r8;
        r8 = new com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
        r8.<init>();
        r8.setVideoUserInfo(r3);
        r8.setType(r9);
        r8.setMsgid(r4);
        r8.setUserId(r12);
        r8.setGcid(r10);
        r8.setId(r1);
        r8.setSourceId(r11);
        r8.setUserAvatar(r6);
        r8.setmPoster(r7);
        r8.setHasRead(r14);
        r8.setVideoStatus(r15);
        r1 = isWebSiteType(r9);
        if (r1 == 0) goto L_0x011e;
    L_0x010f:
        r1 = "site";	 Catch:{ JSONException -> 0x0170 }
        r2 = r27;	 Catch:{ JSONException -> 0x0170 }
        r1 = r2.optJSONObject(r1);	 Catch:{ JSONException -> 0x0170 }
        r1 = com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo.a(r1);	 Catch:{ JSONException -> 0x0170 }
        r8.setWebsiteInfo(r1);	 Catch:{ JSONException -> 0x0170 }
    L_0x011e:
        r1 = r26;
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 == 0) goto L_0x0129;
    L_0x0126:
        r6 = "迅雷用户";
        r1 = r6;
    L_0x0129:
        r8.setUserName(r1);
        r1 = r25;
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x013d;
    L_0x0134:
        r2 = "\\n|\\r";
        r3 = " ";
        r6 = r1.replaceAll(r2, r3);
        r1 = r6;
    L_0x013d:
        r8.setContent(r1);
        r1 = r23;
        r8.setTime(r1);
        r1 = r22;
        r8.setIsFollow(r1);
        r1 = new com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
        r1.<init>();
        r2 = r21;
        r3 = android.text.TextUtils.isEmpty(r2);
        if (r3 != 0) goto L_0x0160;
    L_0x0157:
        r3 = "\\n|\\r";
        r4 = " ";
        r15 = r2.replaceAll(r3, r4);
        goto L_0x0161;
    L_0x0160:
        r15 = r2;
    L_0x0161:
        r1.setContent(r15);
        r1.setId(r12);
        r8.setTargetCommentInfo(r1);
        r1 = r19;
        r1.add(r8);
        goto L_0x017a;
    L_0x0170:
        r1 = r19;
        goto L_0x017a;
    L_0x0173:
        r1 = r2;
        r18 = r3;
        r17 = r5;
        r20 = r7;
    L_0x017a:
        r7 = r20 + 1;
        r2 = r1;
        r5 = r17;
        r3 = r18;
        r1 = r28;
        r4 = 1;
        goto L_0x0046;
    L_0x0186:
        r18 = r3;
        r1 = "cursor";
        r2 = r28;
        r1 = r2.optString(r1);
        r2 = r18;
        r2.b = r1;
        r1 = 0;
        r2.a = r1;
        goto L_0x0199;
    L_0x0198:
        r2 = r3;
    L_0x0199:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo.parseFromJsonObject(org.json.JSONObject):com.xunlei.downloadprovider.personal.message.data.vo.a");
    }

    public long getMsgid() {
        return this.msgid;
    }

    public void setMsgid(long j) {
        this.msgid = j;
    }

    public int getIsFollow() {
        return this.isFollow;
    }

    public void setIsFollow(int i) {
        this.isFollow = i;
    }

    public String getmPoster() {
        return this.mPoster;
    }

    public void setmPoster(String str) {
        this.mPoster = str;
    }

    public boolean isHasRead() {
        return this.hasRead;
    }

    public void setHasRead(boolean z) {
        this.hasRead = z;
    }

    public int getVideoStatus() {
        return this.videoStatus;
    }

    public void setVideoStatus(int i) {
        this.videoStatus = i;
    }

    public VideoUserInfo getVideoUserInfo() {
        return this.videoUserInfo;
    }

    public void setVideoUserInfo(VideoUserInfo videoUserInfo) {
        this.videoUserInfo = videoUserInfo;
    }

    public WebsiteInfo getWebsiteInfo() {
        return this.mWebsiteInfo;
    }

    public void setWebsiteInfo(WebsiteInfo websiteInfo) {
        this.mWebsiteInfo = websiteInfo;
    }

    public String getVideoErrorTextMes() {
        if (this.videoStatus == 0) {
            return "该视频已下线";
        }
        if (this.videoStatus == -2) {
            return "未找到该视频";
        }
        return this.videoStatus == 2 ? "该视频已删除" : null;
    }

    public boolean isSiteStatusError() {
        return isWebSiteType(getType()) && getWebsiteInfo().n != 1;
    }

    public String getSiteErrorTextMsg() {
        String str = "";
        if (!isWebSiteType(getType())) {
            return str;
        }
        int i = getWebsiteInfo().n;
        if (i != 0) {
            return i != 2 ? str : "该站点审核不通过";
        } else {
            return "该站点待审核";
        }
    }
}
