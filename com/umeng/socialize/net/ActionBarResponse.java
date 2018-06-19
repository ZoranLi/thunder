package com.umeng.socialize.net;

import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.Log;
import org.json.JSONObject;

public class ActionBarResponse extends SocializeReseponse {
    public int mCommentCount;
    public String mEntityKey;
    public int mFavorite;
    public int mFirstTime;
    public int mLikeCount;
    public int mPv;
    public int mShareCount;
    public String mSid;
    public String mUid;
    public String mUk;

    public ActionBarResponse(Integer num, JSONObject jSONObject) {
        super(jSONObject);
    }

    public void parseJsonObject() {
        JSONObject jSONObject = this.mJsonData;
        if (jSONObject == null) {
            Log.e("SocializeReseponse", "data json is null....");
            return;
        }
        try {
            if (jSONObject.has("cm")) {
                this.mCommentCount = jSONObject.getInt("cm");
            }
            if (jSONObject.has(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_KEY)) {
                this.mEntityKey = jSONObject.getString(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_KEY);
            }
            if (jSONObject.has(SocializeProtocolConstants.PROTOCOL_KEY_FRIST_TIME)) {
                this.mFirstTime = jSONObject.getInt(SocializeProtocolConstants.PROTOCOL_KEY_FRIST_TIME);
            }
            if (jSONObject.has(SocializeProtocolConstants.PROTOCOL_KEY_FR)) {
                this.mFavorite = jSONObject.optInt(SocializeProtocolConstants.PROTOCOL_KEY_FR, 0);
            }
            if (jSONObject.has(SocializeProtocolConstants.PROTOCOL_KEY_LIKE_COUNT)) {
                this.mLikeCount = jSONObject.getInt(SocializeProtocolConstants.PROTOCOL_KEY_LIKE_COUNT);
            }
            if (jSONObject.has(SocializeProtocolConstants.PROTOCOL_KEY_PV)) {
                this.mPv = jSONObject.getInt(SocializeProtocolConstants.PROTOCOL_KEY_PV);
            }
            if (jSONObject.has("sid")) {
                this.mSid = jSONObject.getString("sid");
            }
            if (jSONObject.has("uid")) {
                this.mUid = jSONObject.getString("uid");
            }
            if (jSONObject.has("sn")) {
                this.mShareCount = jSONObject.getInt("sn");
            }
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("Parse json error[ ");
            stringBuilder.append(jSONObject.toString());
            stringBuilder.append(" ]");
            Log.e("SocializeReseponse", stringBuilder.toString(), e);
        }
    }
}
