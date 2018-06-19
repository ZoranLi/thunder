package com.hianalytics.android.v1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alipay.sdk.util.h;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.hianalytics.android.b.a.a;
import com.hianalytics.android.b.a.c;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.ad.common.adget.b.b;
import com.xunlei.downloadprovider.pushmessage.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements Runnable {
    private Context a;
    private int b;
    private long c;

    public d(Context context, int i, long j) {
        this.a = context;
        this.b = i;
        this.c = j;
    }

    private void a(SharedPreferences sharedPreferences) {
        Editor edit = sharedPreferences.edit();
        edit.putLong("last_millis", this.c);
        edit.commit();
    }

    private static void a(SharedPreferences sharedPreferences, long j) {
        Editor edit = sharedPreferences.edit();
        String valueOf = String.valueOf(j);
        edit.remove("session_id");
        edit.remove("refer_id");
        edit.putString("session_id", valueOf);
        edit.putString("refer_id", "");
        edit.putLong("end_millis", j);
        edit.commit();
    }

    private void b(SharedPreferences sharedPreferences) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        Context context = this.a;
        StringBuffer stringBuffer = new StringBuffer("");
        SharedPreferences a = c.a(context, "sessioncontext");
        String string = a.getString("session_id", "");
        if ("".equals(string)) {
            long currentTimeMillis = System.currentTimeMillis();
            String valueOf = String.valueOf(currentTimeMillis);
            Editor edit = a.edit();
            edit.putString("session_id", valueOf);
            edit.putLong("end_millis", currentTimeMillis);
            edit.commit();
            string = valueOf;
        }
        String string2 = a.getString("refer_id", "");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            a.h();
            obj = null;
        } else {
            stringBuffer.append(a.c(context)[0]);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(telephonyManager.getNetworkOperatorName().replace(',', '&'));
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(string);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(string2);
            obj = stringBuffer.toString();
        }
        if (obj != null) {
            try {
                String[] split;
                JSONArray jSONArray;
                boolean z;
                if (sharedPreferences.getString(ISecurityGuardPlugin.METADATA_ACTIVITIES, "").trim().length() > 0) {
                    split = sharedPreferences.getString(ISecurityGuardPlugin.METADATA_ACTIVITIES, "").split(h.b);
                    jSONArray = new JSONArray();
                    for (Object put : split) {
                        jSONArray.put(put);
                    }
                    jSONObject.put(b.a, jSONArray);
                    z = false;
                } else {
                    z = true;
                }
                if (sharedPreferences.getString("events", "").trim().length() > 0) {
                    split = sharedPreferences.getString("events", "").split(h.b);
                    jSONArray = new JSONArray();
                    for (Object put2 : split) {
                        jSONArray.put(put2);
                    }
                    jSONObject.put(e.a, jSONArray);
                    z = false;
                }
                jSONObject.put(IXAdRequestInfo.HEIGHT, obj);
                jSONObject.put("type", "termination");
                Handler f = a.f();
                if (f != null) {
                    f.post(new c(this.a, jSONObject, z));
                }
                a.h();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Editor edit2 = sharedPreferences.edit();
        edit2.putString(ISecurityGuardPlugin.METADATA_ACTIVITIES, "");
        edit2.remove("events");
        edit2.commit();
    }

    private boolean c(SharedPreferences sharedPreferences) {
        return this.c - sharedPreferences.getLong("last_millis", -1) > a.a().longValue() * 1000;
    }

    public final void run() {
        try {
            SharedPreferences a;
            long j;
            long j2;
            long j3;
            Editor edit;
            Object string;
            String name;
            StringBuilder stringBuilder;
            String stringBuilder2;
            Context context = this.a;
            long j4 = this.c;
            SharedPreferences a2 = c.a(context, "sessioncontext");
            if (!"".equals(a2.getString("session_id", ""))) {
                if (j4 - a2.getLong("end_millis", 0) <= a.c().longValue() * 1000) {
                    Editor edit2 = a2.edit();
                    edit2.putLong("end_millis", j4);
                    edit2.commit();
                    if (this.b == 0) {
                        context = this.a;
                        if (this.a == context) {
                            a.h();
                        }
                        this.a = context;
                        a = c.a(context, XiaomiOAuthConstants.EXTRA_STATE_2);
                        if (a != null) {
                            j = a.getLong("last_millis", -1);
                            if (j != -1) {
                                a.h();
                            } else {
                                j2 = this.c - j;
                                j3 = a.getLong(SocializeProtocolConstants.DURATION, 0);
                                edit = a.edit();
                                string = a.getString(ISecurityGuardPlugin.METADATA_ACTIVITIES, "");
                                name = context.getClass().getName();
                                if (!"".equals(string)) {
                                    stringBuilder = new StringBuilder(String.valueOf(string));
                                    stringBuilder.append(h.b);
                                    string = stringBuilder.toString();
                                }
                                stringBuilder = new StringBuilder(String.valueOf(string));
                                stringBuilder.append(name);
                                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                stringBuilder.append(new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US).format(new Date(j)));
                                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                stringBuilder.append(j2 / 1000);
                                stringBuilder2 = stringBuilder.toString();
                                edit.remove(ISecurityGuardPlugin.METADATA_ACTIVITIES);
                                edit.putString(ISecurityGuardPlugin.METADATA_ACTIVITIES, stringBuilder2);
                                edit.putLong(SocializeProtocolConstants.DURATION, j3 + j2);
                                edit.commit();
                            }
                            if (c(a)) {
                                b(a);
                                a(a);
                                return;
                            } else if (a.d(context)) {
                                b(a);
                                a(a);
                            }
                        }
                        return;
                    } else if (this.b != 1) {
                        context = this.a;
                        this.a = context;
                        a2 = c.a(context, XiaomiOAuthConstants.EXTRA_STATE_2);
                        if (a2 != null && c(a2)) {
                            b(a2);
                            a(a2);
                        }
                    } else {
                        if (this.b == 2) {
                            a2 = c.a(this.a, XiaomiOAuthConstants.EXTRA_STATE_2);
                            if (a2 != null) {
                                b(a2);
                            }
                        }
                    }
                }
            }
            a(a2, j4);
            if (this.b == 0) {
                context = this.a;
                if (this.a == context) {
                    this.a = context;
                    a = c.a(context, XiaomiOAuthConstants.EXTRA_STATE_2);
                    if (a != null) {
                        j = a.getLong("last_millis", -1);
                        if (j != -1) {
                            j2 = this.c - j;
                            j3 = a.getLong(SocializeProtocolConstants.DURATION, 0);
                            edit = a.edit();
                            string = a.getString(ISecurityGuardPlugin.METADATA_ACTIVITIES, "");
                            name = context.getClass().getName();
                            if ("".equals(string)) {
                                stringBuilder = new StringBuilder(String.valueOf(string));
                                stringBuilder.append(h.b);
                                string = stringBuilder.toString();
                            }
                            stringBuilder = new StringBuilder(String.valueOf(string));
                            stringBuilder.append(name);
                            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            stringBuilder.append(new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US).format(new Date(j)));
                            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            stringBuilder.append(j2 / 1000);
                            stringBuilder2 = stringBuilder.toString();
                            edit.remove(ISecurityGuardPlugin.METADATA_ACTIVITIES);
                            edit.putString(ISecurityGuardPlugin.METADATA_ACTIVITIES, stringBuilder2);
                            edit.putLong(SocializeProtocolConstants.DURATION, j3 + j2);
                            edit.commit();
                        } else {
                            a.h();
                        }
                        if (c(a)) {
                            b(a);
                            a(a);
                            return;
                        } else if (a.d(context)) {
                            b(a);
                            a(a);
                        }
                    }
                    return;
                }
                a.h();
            } else if (this.b != 1) {
                if (this.b == 2) {
                    a2 = c.a(this.a, XiaomiOAuthConstants.EXTRA_STATE_2);
                    if (a2 != null) {
                        b(a2);
                    }
                }
            } else {
                context = this.a;
                this.a = context;
                a2 = c.a(context, XiaomiOAuthConstants.EXTRA_STATE_2);
                b(a2);
                a(a2);
            }
        } catch (Exception e) {
            e.getMessage();
            a.h();
            e.printStackTrace();
        }
    }
}
