package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;
import com.alibaba.sdk.android.feedback.xblink.f.m;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = "";
        if (FeedbackAPI.mFeedbackCustomInfoMap.containsKey("appSecret")) {
            return a(str.getBytes(), ((String) FeedbackAPI.mFeedbackCustomInfoMap.get("appSecret")).getBytes());
        }
        try {
            Map hashMap = new HashMap(1);
            hashMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str.toString());
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.appKey = (String) FeedbackAPI.mFeedbackCustomInfoMap.get("appkey");
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 3;
            SecurityGuardManager instance = SecurityGuardManager.getInstance(FeedbackAPI.mContext);
            if (instance != null) {
                return instance.getSecureSignatureComp().signRequest(securityGuardParamContext, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    public static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (bArr != null && i < bArr.length) {
            String toHexString = Integer.toHexString(bArr[i] & 255);
            if (toHexString.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
            i++;
        }
        return stringBuilder.toString().toLowerCase();
    }

    public static String a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "HmacSHA1");
        try {
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            return a(instance.doFinal(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(b bVar, String str) {
        m mVar = new m();
        try {
            mVar.a("data", a(new JSONObject(str).getString("data")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bVar.a(mVar);
    }

    public boolean a(String str, String str2, b bVar) {
        if (!"sign".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
