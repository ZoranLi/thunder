package com.umeng.message;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.message.common.UmLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.common.b;
import com.umeng.message.common.impl.json.JUtrack;
import com.umeng.message.common.inter.IUtrack;
import com.umeng.message.entity.UMessage;
import com.umeng.message.entity.Ucode;
import com.umeng.message.proguard.h;
import com.umeng.message.proguard.l;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UTrack {
    private static final String a = "com.umeng.message.UTrack";
    private static UTrack d = null;
    private static IUtrack e = null;
    private static boolean j = false;
    private static boolean k = false;
    private static boolean l = false;
    private static boolean m = false;
    private JSONObject b;
    private JSONObject c;
    private ScheduledThreadPoolExecutor f;
    private Context g;
    private boolean h;
    private final String i = "appkey";

    public interface ICallBack {
        void onMessage(boolean z, String str);
    }

    public void setClearPrevMessage(boolean z) {
        this.h = z;
    }

    private UTrack(Context context) {
        this.g = context.getApplicationContext();
        this.f = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4);
        d();
    }

    public static synchronized UTrack getInstance(Context context) {
        synchronized (UTrack.class) {
            if (d == null) {
                d = new UTrack(context);
                e = new JUtrack(context);
            }
            context = d;
        }
        return context;
    }

    public void trackMsgArrival(UMessage uMessage) {
        if (uMessage != null) {
            if (uMessage.msg_id != null) {
                a(uMessage.msg_id, 0, uMessage.random_min * 60000);
            }
        }
    }

    public void trackMsgClick(UMessage uMessage) {
        if (!(uMessage == null || uMessage.msg_id == null)) {
            a(uMessage.msg_id, 1, uMessage.random_min * 60000);
        }
        if (!(uMessage == null || uMessage.message_id == null)) {
            a(uMessage.message_id, uMessage.task_id, "8");
        }
        if (this.h != null) {
            ((UmengMessageHandler) PushAgent.getInstance(this.g).getMessageHandler()).setPrevMessage(null);
        }
    }

    public void trackMiPushMsgClick(UMessage uMessage) {
        if (!(uMessage == null || uMessage.msg_id == null)) {
            a(uMessage.msg_id, 21, uMessage.random_min * 60000);
        }
        if (this.h != null) {
            ((UmengMessageHandler) PushAgent.getInstance(this.g).getMessageHandler()).setPrevMessage(null);
        }
    }

    public void trackMsgDismissed(UMessage uMessage) {
        if (!(uMessage == null || uMessage.msg_id == null)) {
            a(uMessage.msg_id, 2, uMessage.random_min * 60000);
        }
        if (!(uMessage == null || uMessage.message_id == null)) {
            a(uMessage.message_id, uMessage.task_id, "9");
        }
        if (this.h != null) {
            ((UmengMessageHandler) PushAgent.getInstance(this.g).getMessageHandler()).setPrevMessage(null);
        }
    }

    public void trackMsgPulled(UMessage uMessage, int i) {
        if (uMessage != null && uMessage.msg_id != null) {
            a(uMessage.msg_id, i, uMessage.random_min * 60000);
        }
    }

    private void a(String str, int i, long j) {
        if (!e()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UmLog.e(a, "trackMsgLog: empty msgId");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            l.a(this.g).a(str, i, currentTimeMillis);
        } catch (Exception e) {
            e.printStackTrace();
            String str2 = a;
            StringBuilder stringBuilder = new StringBuilder("trackMsgLog: ");
            stringBuilder.append(e.toString());
            UmLog.d(str2, stringBuilder.toString());
        }
        Runnable 1 = new 1(this, str, i, currentTimeMillis);
        long j2 = 0;
        if (!(j <= 0 || i == 1 || i == 21)) {
            j2 = Math.abs(new Random().nextLong() % j);
        }
        UmLog.d(a, String.format("trackMsgLog(msgId=%s, actionType=%d, random=%d, delay=%d)", new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}));
        this.f.schedule(1, j2, TimeUnit.MILLISECONDS);
    }

    private void a(String str, String str2, String str3) {
        if (!e()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UmLog.e(a, "trackMsgLogForAgoo: empty msgId");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            l.a(this.g).a(str, str2, str3, currentTimeMillis);
        } catch (Exception e) {
            e.printStackTrace();
            String str4 = a;
            StringBuilder stringBuilder = new StringBuilder("trackMsgLog: ");
            stringBuilder.append(e.toString());
            UmLog.d(str4, stringBuilder.toString());
        }
        this.f.submit(new 5(this, str, str2, str3, currentTimeMillis));
    }

    private synchronized void b(String str, int i, long j) {
        Exception e;
        JSONObject jSONObject;
        try {
            JSONObject h = h();
            try {
                h.put("msg_id", str);
                h.put(MsgConstant.KEY_ACTION_TYPE, i);
                h.put(MsgConstant.KEY_TS, j);
                e.sendMsgLog(h, str, i, j, true);
            } catch (Exception e2) {
                e = e2;
                jSONObject = h;
                e.printStackTrace();
                if (e.getMessage() != null) {
                    UmLog.d(a, e.toString());
                    if (e.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                        try {
                            e.sendMsgLog(jSONObject, str, i, j, false);
                        } catch (String str2) {
                            str2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e3) {
            jSONObject = null;
            e = e3;
            e.printStackTrace();
            if (e.getMessage() != null) {
                UmLog.d(a, e.toString());
                if (e.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                    e.sendMsgLog(jSONObject, str2, i, j, false);
                }
            }
        }
    }

    public synchronized void sendMsgLogForAgoo(String str, String str2, String str3, long j) {
        j = a;
        StringBuilder stringBuilder = new StringBuilder("sendMsgLogForAgoo-->msgId:");
        stringBuilder.append(str);
        stringBuilder.append(",taskId:");
        stringBuilder.append(str2);
        UmLog.d(j, stringBuilder.toString());
        if (str3.equalsIgnoreCase("8") != null) {
            TaobaoRegister.clickMessage(this.g, str, str2);
        } else {
            TaobaoRegister.dismissMessage(this.g, str, str2);
        }
        l.a(this.g).b(str, str3);
        if (str3.equals("7") == null) {
            l.a(this.g).d(str);
        }
    }

    public void sendCachedMsgLog(long j) {
        if (e()) {
            if (!j) {
                if (!k) {
                    UmLog.d(a, "sendCachedMsgLog start, set cacheLogSending flag");
                    j = true;
                    k = true;
                    Runnable 6 = new 6(this);
                    UmLog.d(a, String.format("sendCachedMsgLog(delay=%d)", new Object[]{Long.valueOf(j)}));
                    this.f.schedule(6, j, TimeUnit.MILLISECONDS);
                    this.f.submit(new 7(this));
                    return;
                }
            }
            UmLog.d(a, "sendCachedMsgLog already in queue, abort this request.");
        }
    }

    public void trackAppLaunch(long j) {
        if (!e()) {
            return;
        }
        if (MessageSharedPrefs.getInstance(this.g).getAppLaunchLogSendPolicy() == 1) {
            UmLog.d(a, "launch_policy=1, skip sending app launch info.");
            return;
        }
        if (!MessageSharedPrefs.getInstance(this.g).hasAppLaunchLogSentToday()) {
            a(j);
        }
    }

    private void a(long j) {
        if (l) {
            UmLog.d(a, "trackAppLaunch already in queue, abort this request.");
            return;
        }
        UmLog.d(a, "trackAppLaunch start, set appLaunchSending flag");
        l = true;
        Runnable 8 = new 8(this);
        UmLog.d(a, String.format("trackAppLaunch(delay=%d)", new Object[]{Long.valueOf(j)}));
        this.f.schedule(8, j, TimeUnit.MILLISECONDS);
    }

    private JSONArray c() {
        List g;
        int i;
        JSONArray jSONArray;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        String ucode = MessageSharedPrefs.getInstance(this.g).getUcode();
        if (!(ucode == null || ucode.equals(""))) {
            try {
                g = h.g(ucode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (g == null) {
                return null;
            }
            for (i = 0; i < g.size(); i++) {
                stringBuilder.append("{");
                stringBuilder.append("\"p\":");
                stringBuilder.append("\"");
                stringBuilder.append(((Ucode) g.get(i)).p);
                stringBuilder.append("\"");
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder.append("\"t\":");
                stringBuilder.append(((Ucode) g.get(i)).b);
                stringBuilder.append(com.alipay.sdk.util.h.d);
                if (i != g.size() - 1) {
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            stringBuilder.append("]");
            try {
                jSONArray = new JSONArray(stringBuilder.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                jSONArray = null;
            }
            return jSONArray;
        }
        g = null;
        if (g == null) {
            return null;
        }
        for (i = 0; i < g.size(); i++) {
            stringBuilder.append("{");
            stringBuilder.append("\"p\":");
            stringBuilder.append("\"");
            stringBuilder.append(((Ucode) g.get(i)).p);
            stringBuilder.append("\"");
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append("\"t\":");
            stringBuilder.append(((Ucode) g.get(i)).b);
            stringBuilder.append(com.alipay.sdk.util.h.d);
            if (i != g.size() - 1) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        stringBuilder.append("]");
        jSONArray = new JSONArray(stringBuilder.toString());
        return jSONArray;
    }

    public void trackRegister() {
        if (!e() || MessageSharedPrefs.getInstance(this.g).getHasRegister()) {
            return;
        }
        if (m) {
            UmLog.d(a, "sendRegisterLog already in queue, abort this request.");
            return;
        }
        UmLog.d(a, "trackRegisterLog start, set registerSending flag");
        m = true;
        Runnable 9 = new 9(this);
        UmLog.d(a, String.format("trackRegister(delay=%d)", new Object[]{Integer.valueOf(0)}));
        this.f.schedule(9, 0, TimeUnit.MILLISECONDS);
    }

    public void trackLocation(byte[] bArr) {
        if (e()) {
            this.f.schedule(new 10(this, bArr), 0, TimeUnit.MILLISECONDS);
        }
    }

    private void d() {
        b bVar;
        if (this.b == null) {
            bVar = new b();
            bVar.b(this.g, new String[0]);
            bVar.a(this.g, new String[]{PushAgent.getInstance(this.g).getMessageAppkey(), PushAgent.getInstance(this.g).getMessageChannel()});
            this.b = new JSONObject();
            try {
                bVar.b(this.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.c == null) {
            bVar = new b();
            bVar.c(this.g, new String[0]);
            bVar.a(this.g, new String[]{PushAgent.getInstance(this.g).getMessageAppkey(), PushAgent.getInstance(this.g).getMessageChannel()});
            this.c = new JSONObject();
            try {
                bVar.c(this.c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public JSONObject getHeader() {
        return this.b;
    }

    public void sendAliasFailLog() {
        new Thread(new 11(this)).start();
    }

    public void sendRegisterLog(String str) {
        new Thread(new 12(this, str)).start();
    }

    public boolean addAlias(String str, String str2, ICallBack iCallBack) {
        new Thread(new 2(this, str2, str, iCallBack)).start();
        return null;
    }

    public void addExclusiveAlias(String str, String str2, ICallBack iCallBack) {
        new Thread(new 3(this, str2, str, iCallBack)).start();
    }

    public void removeAlias(String str, String str2, ICallBack iCallBack) {
        new Thread(new 4(this, str2, str, iCallBack)).start();
    }

    private boolean e() {
        if (TextUtils.isEmpty(UmengMessageDeviceConfig.getUtdid(this.g))) {
            UmLog.e(a, "UTDID is empty");
            return false;
        } else if (!TextUtils.isEmpty(MessageSharedPrefs.getInstance(this.g).getDeviceToken())) {
            return true;
        } else {
            UmLog.e(a, "RegistrationId is empty");
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    private String f() {
        BufferedReader bufferedReader;
        IOException e;
        FileNotFoundException e2;
        IOException e3;
        Throwable th;
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
            stringBuilder.append("/data/");
            stringBuilder.append(this.g.getPackageName());
            stringBuilder.append("/");
            String stringBuilder2 = stringBuilder.toString();
            String str = a;
            StringBuilder stringBuilder3 = new StringBuilder("path=");
            stringBuilder3.append(stringBuilder2);
            UmLog.d(str, stringBuilder3.toString());
            File file = new File(stringBuilder2, "umeng-message.config");
            if (!file.exists()) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                do {
                    try {
                        str = bufferedReader.readLine();
                        if (str == null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e = e4;
                                e.printStackTrace();
                                return null;
                            }
                            return null;
                        }
                    } catch (FileNotFoundException e5) {
                        e2 = e5;
                    } catch (IOException e6) {
                        e3 = e6;
                    }
                } while (!str.startsWith("sign="));
                str = str.substring(5);
                try {
                    bufferedReader.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                return str;
            } catch (FileNotFoundException e8) {
                e2 = e8;
                bufferedReader = null;
                e2.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e9) {
                        e7 = e9;
                        e7.printStackTrace();
                        return null;
                    }
                }
                return null;
            } catch (IOException e10) {
                e3 = e10;
                bufferedReader = null;
                try {
                    e3.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e11) {
                            e7 = e11;
                            e7.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e72) {
                            e72.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    private JSONObject g() throws JSONException {
        String deviceToken = MessageSharedPrefs.getInstance(this.g).getDeviceToken();
        String utdid = UmengMessageDeviceConfig.getUtdid(this.g);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.b);
        jSONObject.put("utdid", utdid);
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, deviceToken);
        return jSONObject;
    }

    private JSONObject h() throws JSONException {
        String deviceToken = MessageSharedPrefs.getInstance(this.g).getDeviceToken();
        String utdid = UmengMessageDeviceConfig.getUtdid(this.g);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.c);
        jSONObject.put("utdid", utdid);
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, deviceToken);
        return jSONObject;
    }

    private JSONObject i() throws JSONException {
        String deviceToken = MessageSharedPrefs.getInstance(this.g).getDeviceToken();
        String utdid = UmengMessageDeviceConfig.getUtdid(this.g);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appkey", PushAgent.getInstance(this.g).getMessageAppkey());
        jSONObject.put("utdid", utdid);
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, deviceToken);
        return jSONObject;
    }

    public void updateHeader() {
        b bVar = new b();
        bVar.b(this.g, new String[0]);
        bVar.a(this.g, new String[]{PushAgent.getInstance(this.g).getMessageAppkey(), PushAgent.getInstance(this.g).getMessageChannel()});
        this.b = new JSONObject();
        try {
            bVar.b(this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bVar = new b();
        bVar.c(this.g, new String[0]);
        bVar.a(this.g, new String[]{PushAgent.getInstance(this.g).getMessageAppkey(), PushAgent.getInstance(this.g).getMessageChannel()});
        this.c = new JSONObject();
        try {
            bVar.c(this.c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
