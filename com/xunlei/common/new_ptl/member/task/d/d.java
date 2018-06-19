package com.xunlei.common.new_ptl.member.task.d;

import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.encrypt.AES;
import com.xunlei.common.encrypt.Base64;
import com.xunlei.common.encrypt.HextoChar;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.b;
import com.xunlei.common.new_ptl.member.a.m;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;
import com.xunlei.common.new_ptl.member.task.i.e;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.base.XLStatCommandID;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserPingTask */
public final class d extends a {
    private static int a = 0;
    private static int b = 200000;
    private boolean c = null;
    private JSONArray d = null;

    public d(p pVar) {
        super(pVar);
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "userPingTask") {
                int i = bundle.getInt("errorCode");
                if (bundle.getInt("channel") == 1) {
                    return xLOnUserListener.onUserRecvChannelMessage(i, this.d);
                }
                if (i == 0) {
                    return xLOnUserListener.onUserResumed(0);
                }
                if (i != 4) {
                    if (i != 5) {
                        return xLOnUserListener.onUserSuspended(0);
                    }
                }
                xLOnUserListener = xLOnUserListener.onUserLogout(i, XLErrorCode.getErrorDesc(i), "", e(), f(), g());
                if (this.c == null) {
                    d().a(false, 0);
                    e().b();
                    this.c = true;
                }
                return xLOnUserListener;
            }
        }
        return false;
    }

    private void g(int i) {
        int i2 = a;
        if (i == 0) {
            a = 1;
            XLLog.v("UserPingTask", "user login state resume!");
        } else {
            if (i != 4) {
                if (i != 5) {
                    XLLog.v("UserPingTask", "user login state suspended!");
                    a = 2;
                }
            }
            a = 0;
        }
        if (i2 != a) {
            Bundle bundle = new Bundle();
            bundle.putString("action", "userPingTask");
            bundle.putInt("errorCode", i);
            bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
            d().a((a) this, bundle);
        }
    }

    private void n() {
        Bundle bundle = new Bundle();
        bundle.putString("action", "userPingTask");
        bundle.putInt("errorCode", 0);
        bundle.putInt("channel", 1);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(0));
        d().a((a) this, bundle);
    }

    private static boolean h(int i) {
        if (i == 0) {
            a = 1;
            XLLog.v("UserPingTask", "user login state resume!");
            return true;
        }
        if (i != 4) {
            if (i != 5) {
                XLLog.v("UserPingTask", "user login state suspended!");
                a = 2;
                return true;
            }
        }
        a = 0;
        return true;
    }

    public final void a() {
        this.c = false;
        this.d = null;
        a = 1;
    }

    public final void a(String str) {
        if (com.alipay.sdk.data.a.f.equalsIgnoreCase(str)) {
            g(5);
        }
        if ("kickout".equalsIgnoreCase(str) != null) {
            g(4);
        }
    }

    public final boolean h() {
        if (d().r()) {
            a(a.a.b);
            JSONObject k = k();
            try {
                k.put("sessionID", e().getStringValue(USERINFOKEY.SessionID));
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "ping");
                int i = b;
                b = i + 1;
                jSONObject.put("sequence", i);
                jSONObject.put("needAck", 0);
                jSONObject.put("createTime", System.currentTimeMillis());
                jSONObject.put("overdueTime", 0);
                jSONObject.put("data", "{}");
                jSONArray.put(jSONObject);
                k.put("messages", jSONArray);
                m w = d().w();
                final byte[] parseHexStr2Byte = HextoChar.parseHexStr2Byte(w.b());
                String encode = Base64.encode(AES.encrypt(k.toString().getBytes(), parseHexStr2Byte, "PKCS5Padding", "CBC"));
                StringBuffer stringBuffer = new StringBuffer("http://channel-account-ssl.xunlei.com/channel/put?userid=");
                stringBuffer.append(e().getLongValue(USERINFOKEY.UserID));
                stringBuffer.append("&version=");
                stringBuffer.append(w.a());
                String jSONObject2 = k.toString();
                StringBuilder stringBuilder = new StringBuilder("user ping task content = ");
                stringBuilder.append(jSONObject2);
                XLLog.v("UserPingTask", stringBuilder.toString());
                d().k().a(encode.getBytes(), null, 8, new b(this) {
                    private /* synthetic */ d b;

                    public final void a(int i, Header[] headerArr, String str) {
                        i = new String(str);
                        if (TextUtils.isEmpty(i) == null) {
                            i = AES.decrypt(Base64.decode(i.replace("\n", "").replace("\r", "")), parseHexStr2Byte, "PKCS5Padding", "CBC");
                            if (i != 0) {
                                headerArr = new String(i);
                                XLLog.v("UserPingTask", headerArr);
                                try {
                                    i = new JSONObject(headerArr);
                                    headerArr = i.getInt("errorCode");
                                    this.b.d().a(i.optLong("timestamp"));
                                    if (headerArr == 200) {
                                        i = i.optJSONArray("messages");
                                        if (i != 0) {
                                            this.b.d = new JSONArray();
                                            for (int i2 = 0; i2 < i.length(); i2++) {
                                                JSONObject jSONObject = i.getJSONObject(i2);
                                                String string = jSONObject.getString("type");
                                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                                if ("kickout".equalsIgnoreCase(string)) {
                                                    if (optJSONObject != null) {
                                                        if (this.b.e().getStringValue(USERINFOKEY.SessionID).equalsIgnoreCase(optJSONObject.optString("sessionID"))) {
                                                            this.b.g(4);
                                                            XLLog.v("UserPingTask", "user kick out.");
                                                        }
                                                    }
                                                } else if (!"session_timeout".equalsIgnoreCase(string)) {
                                                    if ("update_info".equalsIgnoreCase(string) && optJSONObject != null && optJSONObject.optLong("userid") == this.b.e().getLongValue(USERINFOKEY.UserID)) {
                                                        a eVar = new e(this.b.d());
                                                        eVar.a(false);
                                                        eVar.h();
                                                    }
                                                    if ("tips".equalsIgnoreCase(string)) {
                                                        this.b.d.put(jSONObject);
                                                    }
                                                    if (d.a == 2) {
                                                        this.b.g(0);
                                                    } else {
                                                        d.a = 1;
                                                    }
                                                } else if (optJSONObject != null) {
                                                    if (this.b.e().getStringValue(USERINFOKEY.SessionID).equalsIgnoreCase(optJSONObject.optString("sessionID"))) {
                                                        this.b.g(5);
                                                        XLLog.v("UserPingTask", "session id time out.");
                                                    }
                                                }
                                            }
                                            if (this.b.d.length() > 0) {
                                                d.b(this.b);
                                            }
                                        } else if (d.a == 2) {
                                            this.b.g(0);
                                        } else {
                                            d.a = 1;
                                        }
                                    } else {
                                        str = new StringBuilder("keep alive error = ");
                                        str.append(headerArr);
                                        XLLog.e("UserPingTask", str.toString());
                                        this.b.g(XLErrorCode.PROTOCOL_ERROR);
                                        i = new XLStatPack();
                                        i.mCommandID = XLStatCommandID.XLCID_CHANNEL_PING;
                                        i.mErrorCode = headerArr;
                                        this.b.d().u().report(i);
                                    }
                                } catch (int i3) {
                                    str = new StringBuilder("keep alive error = ");
                                    str.append(i3.getMessage());
                                    XLLog.e("UserPingTask", str.toString());
                                    this.b.g(16781314);
                                } catch (Throwable th) {
                                    this.b.a((int) a.a.c);
                                }
                                this.b.a((int) a.a.c);
                            }
                        }
                    }

                    public final void a(Throwable th) {
                        StringBuilder stringBuilder = new StringBuilder("keep alive error = ");
                        stringBuilder.append(th.getMessage());
                        XLLog.e("UserPingTask", stringBuilder.toString());
                        this.b.g(XLErrorCode.HTTP_ERROR);
                        this.b.d().a(0);
                    }
                }, g());
                return true;
            } catch (JSONException e) {
                StringBuilder stringBuilder2 = new StringBuilder("pack param error = ");
                stringBuilder2.append(e.getMessage());
                XLLog.e("UserPingTask", stringBuilder2.toString());
                g(XLErrorCode.PACKAGE_ERROR);
                return false;
            }
        }
        g(XLErrorCode.USER_NO_LOGIN);
        return false;
    }

    static /* synthetic */ void b(d dVar) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "userPingTask");
        bundle.putInt("errorCode", 0);
        bundle.putInt("channel", 1);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(0));
        dVar.d().a((a) dVar, bundle);
    }
}
