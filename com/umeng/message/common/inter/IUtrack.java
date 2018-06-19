package com.umeng.message.common.inter;

import com.umeng.message.UTrack.ICallBack;
import org.json.JSONObject;

public interface IUtrack {
    void addAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z) throws Exception;

    void addExclusiveAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z) throws Exception;

    void removeAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z) throws Exception;

    void sendAliasFailLog(JSONObject jSONObject);

    void sendMsgLog(JSONObject jSONObject, String str, int i, long j, boolean z) throws Exception;

    void sendRegisterLog(JSONObject jSONObject) throws Exception;

    void trackAppLaunch(JSONObject jSONObject, boolean z) throws Exception;

    void trackLocation(JSONObject jSONObject, boolean z) throws Exception;

    void trackRegister(JSONObject jSONObject, boolean z) throws Exception;
}
