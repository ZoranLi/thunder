package com.xunlei.common.new_ptl.member.task.c;

import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.o;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.xluagc.MsgBase;
import com.xunlei.xluagc.UserMsgData;
import com.xunlei.xluagc.observer.MessageObserver;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: XLMessageChannelObserver */
public class c implements MessageObserver {
    private static final String a = "c";
    private p b;

    public void onNewMsgNotify(int i, String str) {
    }

    c(p pVar) {
        this.b = pVar;
    }

    public void onReceivedMessage(final List<UserMsgData> list, String str) {
        this.b.n().post(new Runnable(this) {
            private /* synthetic */ c b;

            public final void run() {
                String a = c.a;
                StringBuilder stringBuilder = new StringBuilder("onRecceivedMessage size = ");
                stringBuilder.append(list.size());
                XLLog.v(a, stringBuilder.toString());
                JSONArray jSONArray = new JSONArray();
                for (UserMsgData userMsgData : list) {
                    XLLog.v(c.a, userMsgData.toString());
                    if ("10000".equals(userMsgData.getServiceType())) {
                        byte[] data = userMsgData.getData();
                        if (data != null) {
                            try {
                                String a2 = c.a;
                                StringBuilder stringBuilder2 = new StringBuilder("vip json body:");
                                stringBuilder2.append(new String(data));
                                XLLog.v(a2, stringBuilder2.toString());
                                JSONObject jSONObject = new JSONObject(c.a(data));
                                String string = jSONObject.getString("type");
                                if ("vipinfo".equalsIgnoreCase(string) || "userinfo".equalsIgnoreCase(string)) {
                                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                                    if (a.a.equalsIgnoreCase(jSONObject2.optString("req_cmd"))) {
                                        XLLog.v(c.a, "recieve notify message, abandon it");
                                    } else {
                                        this.b.a(jSONObject2);
                                        jSONArray.put(jSONObject);
                                    }
                                }
                                if ("sessioninfo".equalsIgnoreCase(string)) {
                                    this.b.b(jSONObject.getJSONObject("data"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    this.b.b.a(0, jSONArray);
                }
            }
        });
    }

    public void onLongConnectStateNotify(int i) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("onLongConnectStateNotify  = ");
        stringBuilder.append(i);
        XLLog.v(str, stringBuilder.toString());
    }

    public void onLongConnectEventNotify(int i) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("onLongConnectEventNotify  = ");
        stringBuilder.append(i);
        XLLog.v(str, stringBuilder.toString());
    }

    public void onUserMsgSend(int i, MsgBase msgBase, int i2) {
        msgBase = a;
        StringBuilder stringBuilder = new StringBuilder("onUserMsgSend  = ");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(i2);
        XLLog.v(msgBase, stringBuilder.toString());
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = str.replace("-", "");
        return str.length() >= 8 ? str.substring(0, 8) : "";
    }

    private static String a(byte[] bArr) {
        String str = "";
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            String str2 = a;
            StringBuilder stringBuilder = new StringBuilder("transformSingleCharString error = ");
            stringBuilder.append(bArr2.getMessage());
            XLLog.v(str2, stringBuilder.toString());
            return str;
        }
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                o oVar = (o) this.b.i();
                long j = jSONObject.getLong("userID");
                if (j == oVar.getLongValue(USERINFOKEY.UserID) && j != 0) {
                    oVar.a(jSONObject, false);
                }
            } catch (JSONObject jSONObject2) {
                jSONObject2.printStackTrace();
            }
        }
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                o oVar = (o) this.b.i();
                if (oVar.d()) {
                    long j = jSONObject.getLong("userID");
                    if (j == oVar.getLongValue(USERINFOKEY.UserID) && j != 0) {
                        int i = jSONObject.getInt("appid");
                        if (i == this.b.d() && i != 0) {
                            CharSequence string = jSONObject.getString("deviceID");
                            if (p.t().equalsIgnoreCase(string) && !TextUtils.isEmpty(string)) {
                                string = jSONObject.getString("sessionID");
                                if (oVar.getStringValue(USERINFOKEY.SessionID).equalsIgnoreCase(string) && !TextUtils.isEmpty(string)) {
                                    this.b.d(jSONObject.getString("status"));
                                }
                            }
                        }
                    }
                    return;
                }
                XLLog.v(a, "user is not online,should not update session status");
            } catch (JSONObject jSONObject2) {
                jSONObject2.printStackTrace();
            }
        }
    }
}
