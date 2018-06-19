package com.xunlei.downloadprovider.pushmessage.bean;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.downloadprovider.pushmessage.exception.PushParseException;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public class PushOriginalInfo implements Serializable {
    private static final String TAG = "push.PushOriginalInfo";
    private String customMsgBody;
    private JSONObject customMsgJO;
    private String deviceToken;
    private int displayType;
    private String originMsgBody;
    private int serverType;

    public PushOriginalInfo(int i, String str, String str2, String str3, boolean z) throws PushParseException {
        this.serverType = i;
        this.originMsgBody = str;
        this.customMsgBody = str2;
        this.deviceToken = str3;
        try {
            if (TextUtils.isEmpty(str2) != 0) {
                throw new PushParseException("customMsgBody is empty");
            }
            if (z) {
                this.customMsgJO = new JSONArray(str2).getJSONObject(null);
            } else {
                this.customMsgJO = new JSONObject(str2);
            }
            this.displayType = this.customMsgJO.optInt(PushResult.DISPLAY_TYPE);
        } catch (int i2) {
            i2.printStackTrace();
            throw new PushParseException("customMsgBody error");
        }
    }

    public int getServerType() {
        return this.serverType;
    }

    public String getCustomMsgBody() {
        return this.customMsgBody;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public int getDisplayType() {
        return this.displayType;
    }

    @NonNull
    public JSONObject getCustomMsgJO() {
        return this.customMsgJO;
    }

    public String getOriginMsgBody() {
        return this.originMsgBody;
    }
}
