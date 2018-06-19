package com.xunlei.downloadprovider.pushmessage.bean;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.pushmessage.c.a;
import com.xunlei.downloadprovider.pushmessage.d;
import java.io.Serializable;
import org.json.JSONObject;

public class BasePushMessageInfo implements Serializable {
    public static final long RECEIVER_USER_ID_DEFAULT = -1;
    protected static final String TAG = "push.BasePushMessageInfo";
    private String bigPic = "";
    private String customMsgBody;
    private String desc = "";
    private String deviceToken;
    private int displayType = -1;
    private String messageId = "";
    private String newBigPic = "";
    private int notificationId = 0;
    private String originMsgBody;
    private long receiverUserId = -1;
    private String resTypeReport = "";
    private int serverType = -1;
    private String serverTypeReport = "";
    private int shortVideoType = -1;
    private String target = "";
    private String title = "";

    public static BasePushMessageInfo parse(PushOriginalInfo pushOriginalInfo) {
        BasePushMessageInfo basePushMessageInfo = new BasePushMessageInfo();
        parseBaseInfo(basePushMessageInfo, pushOriginalInfo);
        return basePushMessageInfo;
    }

    protected static void parseBaseInfo(BasePushMessageInfo basePushMessageInfo, PushOriginalInfo pushOriginalInfo) {
        JSONObject customMsgJO = pushOriginalInfo.getCustomMsgJO();
        basePushMessageInfo.setMessageId(customMsgJO.optString(PushResult.MSG_ID));
        basePushMessageInfo.setNotificationId(customMsgJO.optInt(PushResult.NOTIFICATION_ID));
        basePushMessageInfo.setReceiverUserId(customMsgJO.optLong("receiver", -1));
        basePushMessageInfo.setDisplayType(customMsgJO.optInt(PushResult.DISPLAY_TYPE));
        basePushMessageInfo.setServerType(pushOriginalInfo.getServerType());
        basePushMessageInfo.setResTypeReport(customMsgJO.optString(PushResult.RES_TYPE));
        basePushMessageInfo.setTarget(customMsgJO.optString("target"));
        basePushMessageInfo.setDeviceToken(pushOriginalInfo.getDeviceToken());
        basePushMessageInfo.setOriginMsgBody(pushOriginalInfo.getOriginMsgBody());
        basePushMessageInfo.setCustomMsgBody(pushOriginalInfo.getCustomMsgBody());
        basePushMessageInfo.setTitle(customMsgJO.optString("title"));
        basePushMessageInfo.setDesc(customMsgJO.optString("desc"));
        basePushMessageInfo.setBigPic(customMsgJO.optString(PushResult.BIG_PIC));
        basePushMessageInfo.setNewBigPic(customMsgJO.optString(PushResult.BIG_PIC_NEW));
        basePushMessageInfo.setShortVideoType(customMsgJO.optInt(PushResult.IS_SHORT_VIDEO));
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    public void setNotificationId(int i) {
        this.notificationId = i;
    }

    public int getDisplayType() {
        return this.displayType;
    }

    public void setDisplayType(int i) {
        this.displayType = i;
    }

    public int getServerType() {
        return this.serverType;
    }

    public String getServerTypeReport() {
        return this.serverTypeReport;
    }

    public void setServerType(int i) {
        this.serverType = i;
        this.serverTypeReport = a.a(i);
    }

    public String getResTypeReport() {
        return this.resTypeReport;
    }

    public void setResTypeReport(String str) {
        this.resTypeReport = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String str) {
        this.target = str;
    }

    public String getBigPic() {
        return this.bigPic;
    }

    public void setBigPic(String str) {
        this.bigPic = str;
    }

    public String getNewBigPic() {
        return this.newBigPic;
    }

    public void setNewBigPic(String str) {
        this.newBigPic = str;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public void setDeviceToken(String str) {
        this.deviceToken = str;
    }

    public String getValidBigPic() {
        return TextUtils.isEmpty(getBigPic()) ? getNewBigPic() : getBigPic();
    }

    public String getOriginMsgBody() {
        return this.originMsgBody;
    }

    public void setOriginMsgBody(String str) {
        this.originMsgBody = str;
    }

    public int getShortVideoType() {
        return this.shortVideoType;
    }

    public void setShortVideoType(int i) {
        this.shortVideoType = i;
    }

    public String getCustomMsgBody() {
        return this.customMsgBody;
    }

    public void setCustomMsgBody(String str) {
        this.customMsgBody = str;
    }

    public boolean IsReportHubblePop() {
        return d.b().contains(String.valueOf(getDisplayType()));
    }

    public long getReceiverUserId() {
        return this.receiverUserId;
    }

    public void setReceiverUserId(long j) {
        this.receiverUserId = j;
    }

    public boolean isRelatedToLogin() {
        return getReceiverUserId() != -1;
    }

    public boolean isCorrectReceiver() {
        LoginHelper.a();
        return l.c() && LoginHelper.a().g.c() == getReceiverUserId();
    }
}
