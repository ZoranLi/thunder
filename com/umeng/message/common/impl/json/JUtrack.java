package com.umeng.message.common.impl.json;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UTrack.ICallBack;
import com.umeng.message.common.UmLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.common.inter.IUtrack;
import com.umeng.message.entity.Alias;
import com.umeng.message.entity.Ucode;
import com.umeng.message.proguard.c;
import com.umeng.message.proguard.l;
import com.umeng.message.provider.a;
import com.umeng.message.util.HttpRequest;
import com.umeng.message.util.b;
import com.xunlei.downloadprovider.ad.home.a.f;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class JUtrack implements IUtrack {
    private static final String a = "JUtrack";
    private Context b;

    public JUtrack(Context context) {
        this.b = context.getApplicationContext();
    }

    public void sendMsgLog(JSONObject jSONObject, String str, int i, long j, boolean z) throws Exception {
        if (z) {
            try {
                j = sendRequest(jSONObject, MsgConstant.LOG_ENDPOINT);
            } catch (long j2) {
                if (j2.getMessage() != null && j2.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                    j2 = sendRequest(this.b, jSONObject, MsgConstant.LOG_ENDPOINT);
                } else {
                    throw new Exception(j2);
                }
            }
        }
        j2 = sendRequest(jSONObject, MsgConstant.LOG_ENDPOINT.replace("https", HttpConstant.HTTP));
        if (j2 != null && TextUtils.equals(j2.getString("success"), ITagManager.SUCCESS) != null) {
            l.a(this.b).a(str, i);
            if (i != 0) {
                l.a(this.b).b(str);
            }
        }
    }

    public void trackAppLaunch(JSONObject jSONObject, boolean z) throws Exception {
        if (z) {
            try {
                z = sendRequest(jSONObject, MsgConstant.LAUNCH_ENDPOINT);
            } catch (boolean z2) {
                if (z2.getMessage() != null && z2.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                    z2 = sendRequest(this.b, jSONObject, MsgConstant.LAUNCH_ENDPOINT);
                } else {
                    throw new Exception(z2);
                }
            }
        }
        z2 = sendRequest(jSONObject, MsgConstant.LAUNCH_ENDPOINT.replace("https", HttpConstant.HTTP));
        if (z2 && TextUtils.equals(z2.getString("success"), ITagManager.SUCCESS) != null) {
            l.a(this.b).a(System.currentTimeMillis());
            jSONObject = z2.getInt("launch_policy");
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("launch_policy:");
            stringBuilder.append(jSONObject);
            UmLog.d(str, stringBuilder.toString());
            int i = z2.getInt("tag_policy");
            String str2 = a;
            StringBuilder stringBuilder2 = new StringBuilder("tag_policy:");
            stringBuilder2.append(i);
            UmLog.d(str2, stringBuilder2.toString());
            if (jSONObject > null) {
                MessageSharedPrefs.getInstance(this.b).setAppLaunchLogSendPolicy(jSONObject);
            }
            if (i > 0) {
                MessageSharedPrefs.getInstance(this.b).setTagSendPolicy(i);
            }
            jSONObject = z2.optString(MsgConstant.KEY_UCODE);
            if (jSONObject != null) {
                if (!jSONObject.equals("")) {
                    z2 = new JSONArray(c.b(jSONObject, "utf-8"));
                    jSONObject = new ArrayList();
                    for (int i2 = 0; i2 < z2.length(); i2++) {
                        String optString = z2.getJSONObject(i2).optString("p");
                        int optInt = z2.getJSONObject(i2).optInt(f.a);
                        Ucode ucode = new Ucode();
                        ucode.p = optString;
                        ucode.f = (long) optInt;
                        ucode.b = false;
                        jSONObject.add(ucode);
                    }
                    new Thread(new 1(this, jSONObject)).start();
                }
            }
        }
    }

    public void trackRegister(JSONObject jSONObject, boolean z) throws Exception {
        if (z) {
            try {
                z = sendRequest(jSONObject, MsgConstant.REGISTER_ENDPOINT);
            } catch (boolean z2) {
                if (z2.getMessage() != null && z2.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                    z2 = sendRequest(this.b, jSONObject, MsgConstant.REGISTER_ENDPOINT);
                } else {
                    throw new Exception(z2);
                }
            }
        }
        z2 = sendRequest(jSONObject, MsgConstant.REGISTER_ENDPOINT.replace("https", HttpConstant.HTTP));
        if (z2 && TextUtils.equals(z2.getString("success"), ITagManager.SUCCESS) != null) {
            MessageSharedPrefs.getInstance(this.b).setHasResgister(true);
            if (TextUtils.isEmpty(MessageSharedPrefs.getInstance(this.b).getDeviceToken()) != null) {
                UmLog.e(a, "setRegisteredToUmeng: empty registration id");
            }
        }
    }

    public void trackLocation(JSONObject jSONObject, boolean z) throws Exception {
        if (z) {
            try {
                z = sendRequest(jSONObject, MsgConstant.LBS_ENDPOINT);
            } catch (boolean z2) {
                if (z2.getMessage() != null && z2.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                    z2 = sendRequest(this.b, jSONObject, MsgConstant.LBS_ENDPOINT);
                } else {
                    throw new Exception(z2);
                }
            } catch (JSONObject jSONObject2) {
                jSONObject2.printStackTrace();
                return;
            }
        }
        z2 = sendRequest(jSONObject2, MsgConstant.LBS_ENDPOINT.replace("https", HttpConstant.HTTP));
        if (z2 && TextUtils.equals(z2.getString("success"), ITagManager.SUCCESS) != null) {
            UmLog.d(a, "location track success");
        }
    }

    public void addAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z) throws Exception {
        JUtrack jUtrack = this;
        String str3 = str;
        JSONObject jSONObject2 = jSONObject;
        ICallBack iCallBack2 = iCallBack;
        String optString = jSONObject2.optString("fail", "");
        String optString2 = jSONObject2.optString("success", "");
        String str4 = a;
        StringBuilder stringBuilder = new StringBuilder("keyfail:");
        stringBuilder.append(optString);
        stringBuilder.append(",keysuccess:");
        stringBuilder.append(optString2);
        UmLog.i(str4, stringBuilder.toString());
        StringBuilder stringBuilder2;
        if (optString.equals("") && optString2.equals("")) {
            JSONObject sendRequest;
            if (z) {
                try {
                    sendRequest = sendRequest(jSONObject2, MsgConstant.ALIAS_ENDPOINT);
                } catch (Throwable e) {
                    Throwable th = e;
                    if (th.getMessage() != null && th.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(jUtrack.b)) {
                        sendRequest = sendRequest(jUtrack.b, jSONObject2, MsgConstant.ALIAS_ENDPOINT);
                    } else {
                        throw new Exception(th);
                    }
                }
            }
            sendRequest = sendRequest(jSONObject2, MsgConstant.ALIAS_ENDPOINT.replace("https", HttpConstant.HTTP));
            if (sendRequest == null || !TextUtils.equals(sendRequest.optString("success", ""), ITagManager.SUCCESS)) {
                MessageSharedPrefs instance = MessageSharedPrefs.getInstance(jUtrack.b);
                StringBuilder stringBuilder3 = new StringBuilder("网络请求失败alias:");
                stringBuilder3.append(str3);
                stringBuilder3.append(",type:");
                String str5 = str2;
                stringBuilder3.append(str5);
                stringBuilder3.append(",devicetoken:");
                stringBuilder3.append(MessageSharedPrefs.getInstance(jUtrack.b).getDeviceToken());
                instance.addAlias(str3, str5, 0, 1, stringBuilder3.toString());
                stringBuilder2 = new StringBuilder("alias:");
                stringBuilder2.append(str3);
                stringBuilder2.append("添加失败");
                iCallBack2.onMessage(false, stringBuilder2.toString());
                return;
            }
            MessageSharedPrefs.getInstance(jUtrack.b).addAlias(str3, str2, 0, 0, "");
            stringBuilder2 = new StringBuilder("alias:");
            stringBuilder2.append(str3);
            stringBuilder2.append("添加成功");
            iCallBack2.onMessage(true, stringBuilder2.toString());
            return;
        }
        str5 = str2;
        if (!optString.equals("")) {
            stringBuilder2 = new StringBuilder("alias:");
            stringBuilder2.append(str3);
            stringBuilder2.append("添加失败");
            iCallBack2.onMessage(false, stringBuilder2.toString());
            MessageSharedPrefs.getInstance(jUtrack.b).addAlias(str3, str5, 0, 1, optString);
        }
        if (!optString2.equals("")) {
            stringBuilder2 = new StringBuilder("alias:");
            stringBuilder2.append(str3);
            stringBuilder2.append("已经添加");
            iCallBack2.onMessage(true, stringBuilder2.toString());
            MessageSharedPrefs.getInstance(jUtrack.b).addAlias(str3, str5, 0, 2, optString2);
        }
    }

    public void addExclusiveAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z) throws Exception {
        JUtrack jUtrack = this;
        String str3 = str;
        JSONObject jSONObject2 = jSONObject;
        ICallBack iCallBack2 = iCallBack;
        String optString = jSONObject2.optString("fail", "");
        String optString2 = jSONObject2.optString("success", "");
        String str4 = a;
        StringBuilder stringBuilder = new StringBuilder("keyfail:");
        stringBuilder.append(optString);
        stringBuilder.append(",keysuccess:");
        stringBuilder.append(optString2);
        UmLog.i(str4, stringBuilder.toString());
        StringBuilder stringBuilder2;
        if (optString.equals("") && optString2.equals("")) {
            JSONObject sendRequest;
            if (z) {
                try {
                    sendRequest = sendRequest(jSONObject2, MsgConstant.ALIAS_EXCLUSIVE_ENDPOINT);
                } catch (Throwable e) {
                    Throwable th = e;
                    if (th.getMessage() != null && th.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(jUtrack.b)) {
                        sendRequest = sendRequest(jUtrack.b, jSONObject2, MsgConstant.ALIAS_EXCLUSIVE_ENDPOINT);
                    } else {
                        throw new Exception(th);
                    }
                }
            }
            sendRequest = sendRequest(jSONObject2, MsgConstant.ALIAS_EXCLUSIVE_ENDPOINT.replace("https", HttpConstant.HTTP));
            if (sendRequest == null || !TextUtils.equals(sendRequest.optString("success", ""), ITagManager.SUCCESS)) {
                MessageSharedPrefs instance = MessageSharedPrefs.getInstance(jUtrack.b);
                StringBuilder stringBuilder3 = new StringBuilder("网络请求失败alias:");
                stringBuilder3.append(str3);
                stringBuilder3.append(",type:");
                String str5 = str2;
                stringBuilder3.append(str5);
                stringBuilder3.append(",devicetoken:");
                stringBuilder3.append(MessageSharedPrefs.getInstance(jUtrack.b).getDeviceToken());
                instance.addAlias(str3, str5, 1, 1, stringBuilder3.toString());
                stringBuilder2 = new StringBuilder("alias:");
                stringBuilder2.append(str3);
                stringBuilder2.append("添加失败");
                iCallBack2.onMessage(false, stringBuilder2.toString());
                return;
            }
            MessageSharedPrefs.getInstance(jUtrack.b).addAlias(str3, str2, 1, 0, "");
            stringBuilder2 = new StringBuilder("alias:");
            stringBuilder2.append(str3);
            stringBuilder2.append("添加成功");
            iCallBack2.onMessage(true, stringBuilder2.toString());
            return;
        }
        str5 = str2;
        if (!optString.equals("")) {
            stringBuilder2 = new StringBuilder("alias:");
            stringBuilder2.append(str3);
            stringBuilder2.append("添加失败");
            iCallBack2.onMessage(false, stringBuilder2.toString());
            MessageSharedPrefs.getInstance(jUtrack.b).addAlias(str3, str5, 1, 1, optString);
        }
        if (!optString2.equals("")) {
            stringBuilder2 = new StringBuilder("alias:");
            stringBuilder2.append(str3);
            stringBuilder2.append("已经添加");
            iCallBack2.onMessage(true, stringBuilder2.toString());
            MessageSharedPrefs.getInstance(jUtrack.b).addAlias(str3, str5, 1, 2, optString2);
        }
    }

    public void removeAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z) throws Exception {
        if (z) {
            try {
                z = sendRequest(jSONObject, MsgConstant.DELETE_ALIAS_ENDPOINT);
            } catch (boolean z2) {
                if (z2.getMessage() != null && z2.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                    z2 = sendRequest(this.b, jSONObject, MsgConstant.DELETE_ALIAS_ENDPOINT);
                } else {
                    throw new Exception(z2);
                }
            }
        }
        z2 = sendRequest(jSONObject, MsgConstant.DELETE_ALIAS_ENDPOINT.replace("https", HttpConstant.HTTP));
        if (z2 && TextUtils.equals(z2.getString("success"), ITagManager.SUCCESS) != null) {
            MessageSharedPrefs.getInstance(this.b).removeAlias(false, str, str2);
            MessageSharedPrefs.getInstance(this.b).removeAlias(1, str, str2);
            jSONObject = new StringBuilder("alias:");
            jSONObject.append(str);
            jSONObject.append(",type:");
            jSONObject.append(str2);
            jSONObject.append("删除成功");
            iCallBack.onMessage(true, jSONObject.toString());
        }
    }

    public static JSONObject sendRequest(JSONObject jSONObject, String str) throws Exception {
        String body = HttpRequest.post((CharSequence) str).acceptJson().contentType(HttpRequest.CONTENT_TYPE_JSON).send(jSONObject.toString()).body("UTF-8");
        String str2 = a;
        StringBuilder stringBuilder = new StringBuilder("sendRequest() url=");
        stringBuilder.append(str);
        stringBuilder.append("\n request = ");
        stringBuilder.append(jSONObject);
        stringBuilder.append("\n response = ");
        stringBuilder.append(body);
        UmLog.d(str2, stringBuilder.toString());
        return new JSONObject(body);
    }

    public static JSONObject sendRequest(Context context, JSONObject jSONObject, String str) throws Exception {
        String host = new URL(str).getHost();
        context = b.a(context, host);
        String str2 = a;
        StringBuilder stringBuilder = new StringBuilder("ip:");
        stringBuilder.append(context);
        UmLog.d(str2, stringBuilder.toString());
        if (context == null) {
            return null;
        }
        URL url = new URL(str.replaceFirst(host, context));
        context = HttpRequest.post(url).acceptJson().contentType(HttpRequest.CONTENT_TYPE_JSON).header(HttpConstant.HOST, host).trustHosts().send(jSONObject.toString()).body("UTF-8");
        str = a;
        StringBuilder stringBuilder2 = new StringBuilder("dns-->sendRequest() url=");
        stringBuilder2.append(url.toString());
        stringBuilder2.append("\n request = ");
        stringBuilder2.append(jSONObject);
        stringBuilder2.append("\n response = ");
        stringBuilder2.append(context);
        UmLog.d(str, stringBuilder2.toString());
        return new JSONObject(context);
    }

    public void sendAliasFailLog(JSONObject jSONObject) {
        if (MessageSharedPrefs.getInstance(this.b).getDaRegisterSendPolicy() == 1) {
            UmLog.d(a, "da_register_policy=1, skip sending da_register info.");
            return;
        }
        try {
            String[] strArr = new String[]{"1"};
            ContentResolver contentResolver = this.b.getContentResolver();
            a.a(this.b);
            Cursor query = contentResolver.query(a.d, new String[]{"message", "time"}, "error=?", strArr, null);
            if (query != null) {
                List<Alias> arrayList = new ArrayList();
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    String string = query.getString(query.getColumnIndex("message"));
                    long j = query.getLong(query.getColumnIndex("time"));
                    Alias alias = new Alias();
                    alias.aliasMessage = string;
                    alias.aliasTime = j;
                    arrayList.add(alias);
                    query.moveToNext();
                }
                if (query != null) {
                    query.close();
                }
                for (Alias alias2 : arrayList) {
                    a(jSONObject, alias2.aliasMessage, alias2.aliasTime);
                }
            }
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
        }
    }

    public void sendRegisterLog(JSONObject jSONObject) throws Exception {
        JSONObject sendRequest;
        try {
            sendRequest = sendRequest(jSONObject, MsgConstant.ALIAS_LOG);
        } catch (Throwable e) {
            if (e.getMessage() != null && e.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                sendRequest = sendRequest(this.b, jSONObject, MsgConstant.ALIAS_LOG);
            } else {
                throw new Exception(e);
            }
        }
        if (sendRequest != null && TextUtils.equals(sendRequest.optString("success", ""), ITagManager.SUCCESS) != null) {
            jSONObject = Integer.parseInt(sendRequest.getString("da_register_policy"));
            if (jSONObject > null) {
                MessageSharedPrefs.getInstance(this.b).setDaRegisterSendPolicy(jSONObject);
            }
        }
    }

    private void a(JSONObject jSONObject, String str, long j) throws Exception {
        if (!str.equals("")) {
            jSONObject.put(MsgConstant.KEY_ALIAS_FAIL_LOG, str);
            try {
                str = sendRequest(jSONObject, MsgConstant.ALIAS_LOG);
            } catch (String str2) {
                if (str2.getMessage() != null && str2.getMessage().contains(MsgConstant.HTTPSDNS_ERROR) && UtilityImpl.isNetworkConnected(this.b)) {
                    str2 = sendRequest(this.b, jSONObject, MsgConstant.ALIAS_LOG);
                } else {
                    throw new Exception(str2);
                }
            }
            if (!(str2 == null || TextUtils.equals(str2.optString("success", ""), ITagManager.SUCCESS) == null)) {
                jSONObject = new ContentValues();
                jSONObject.put("error", "3");
                String[] strArr = new String[]{String.valueOf(j)};
                j = this.b.getContentResolver();
                a.a(this.b);
                j.update(a.d, jSONObject, "time=?", strArr);
                jSONObject = Integer.parseInt(str2.optString("da_register_policy"));
                if (jSONObject > null) {
                    MessageSharedPrefs.getInstance(this.b).setDaRegisterSendPolicy(jSONObject);
                }
            }
        }
    }
}
