package com.umeng.message.common.impl.json;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UmLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.common.inter.ITagManager.Result;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class JTagManager implements ITagManager {
    private static final String a = "JTagManager";
    private Context b;

    public JTagManager(Context context) {
        this.b = context;
    }

    public Result add(JSONObject jSONObject, boolean z, String... strArr) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MsgConstant.TAG_ENDPOINT);
        stringBuilder.append("/add");
        String stringBuilder2 = stringBuilder.toString();
        if (z) {
            try {
                z = JUtrack.sendRequest(jSONObject, stringBuilder2);
            } catch (boolean z2) {
                if (z2.getMessage() != null && z2.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                    UmLog.i(a, "add tag UnknownHostException");
                    z2 = JUtrack.sendRequest(this.b, jSONObject, stringBuilder2);
                } else {
                    throw new Exception(z2);
                }
            }
        }
        z2 = JUtrack.sendRequest(jSONObject, stringBuilder2.replace("https", HttpConstant.HTTP));
        jSONObject = new Result(z2);
        if (TextUtils.equals(jSONObject.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs.getInstance(this.b).addTags(strArr);
            MessageSharedPrefs.getInstance(this.b).setTagRemain(jSONObject.remain);
        }
        return jSONObject;
    }

    public Result update(JSONObject jSONObject, boolean z, String... strArr) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MsgConstant.TAG_ENDPOINT);
        stringBuilder.append("/update");
        String stringBuilder2 = stringBuilder.toString();
        if (z) {
            try {
                z = JUtrack.sendRequest(jSONObject, stringBuilder2);
            } catch (boolean z2) {
                if (z2.getMessage() != null && z2.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                    z2 = JUtrack.sendRequest(this.b, jSONObject, stringBuilder2);
                } else {
                    throw new Exception(z2);
                }
            }
        }
        z2 = JUtrack.sendRequest(jSONObject, stringBuilder2.replace("https", HttpConstant.HTTP));
        jSONObject = new Result(z2);
        if (TextUtils.equals(jSONObject.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs.getInstance(this.b).resetTags();
            MessageSharedPrefs.getInstance(this.b).addTags(strArr);
            MessageSharedPrefs.getInstance(this.b).setTagRemain(jSONObject.remain);
        }
        return jSONObject;
    }

    public Result delete(JSONObject jSONObject, boolean z, String... strArr) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MsgConstant.TAG_ENDPOINT);
        stringBuilder.append("/delete");
        String stringBuilder2 = stringBuilder.toString();
        if (z) {
            try {
                z = JUtrack.sendRequest(jSONObject, stringBuilder2);
            } catch (boolean z2) {
                if (z2.getMessage() != null && z2.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                    z2 = JUtrack.sendRequest(this.b, jSONObject, stringBuilder2);
                } else {
                    throw new Exception(z2);
                }
            }
        }
        z2 = JUtrack.sendRequest(jSONObject, stringBuilder2.replace("https", HttpConstant.HTTP));
        jSONObject = new Result(z2);
        if (TextUtils.equals(jSONObject.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs.getInstance(this.b).removeTags(strArr);
            MessageSharedPrefs.getInstance(this.b).setTagRemain(jSONObject.remain);
        }
        return jSONObject;
    }

    public Result reset(JSONObject jSONObject, boolean z) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MsgConstant.TAG_ENDPOINT);
        stringBuilder.append("/reset");
        String stringBuilder2 = stringBuilder.toString();
        if (z) {
            try {
                z = JUtrack.sendRequest(jSONObject, stringBuilder2);
            } catch (boolean z2) {
                if (z2.getMessage() != null && z2.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                    z2 = JUtrack.sendRequest(this.b, jSONObject, stringBuilder2);
                } else {
                    throw new Exception(z2);
                }
            }
        }
        z2 = JUtrack.sendRequest(jSONObject, stringBuilder2.replace("https", HttpConstant.HTTP));
        jSONObject = new Result(z2);
        if (TextUtils.equals(jSONObject.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs.getInstance(this.b).resetTags();
        }
        return jSONObject;
    }

    public List<String> list(JSONObject jSONObject, boolean z) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MsgConstant.TAG_ENDPOINT);
        stringBuilder.append("/get");
        String stringBuilder2 = stringBuilder.toString();
        if (z) {
            try {
                z = JUtrack.sendRequest(jSONObject, stringBuilder2);
            } catch (boolean z2) {
                if (z2.getMessage() != null && z2.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                    z2 = JUtrack.sendRequest(this.b, jSONObject, stringBuilder2);
                } else {
                    throw new Exception(z2);
                }
            }
        }
        z2 = JUtrack.sendRequest(jSONObject, stringBuilder2.replace("https", HttpConstant.HTTP));
        if (TextUtils.equals(new Result(z2).status, ITagManager.SUCCESS) == null || z2.getString("tags") == null) {
            return null;
        }
        UmLog.d(a, z2.getString("tags"));
        return Arrays.asList(z2.getString("tags").split(Constants.ACCEPT_TIME_SEPARATOR_SP));
    }
}
