package com.xunlei.common.new_ptl.member.a;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.encrypt.AES;
import com.xunlei.common.encrypt.HextoChar;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: XLUserInfoImpl */
public final class o implements XLUserInfo, Serializable {
    private static final long a = 6388415557093841477L;
    private static final String b = "xl-acc-user";
    private Map<USERINFOKEY, Object> c = new HashMap();
    private Map<Integer, Map<USERINFOKEY, Object>> d = new HashMap();

    public final void a(JSONObject jSONObject) {
        a(jSONObject, true);
    }

    public final void a(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            if (jSONObject.has("userID")) {
                a(USERINFOKEY.UserID, Long.valueOf(jSONObject.optLong("userID")), 2);
            }
            if (jSONObject.has("sessionID")) {
                a(USERINFOKEY.SessionID, jSONObject.optString("sessionID"), 2);
            }
            if (z && jSONObject.has("timestamp")) {
                p.a().a(jSONObject.optLong("timestamp"));
            }
            if (jSONObject.has("userName")) {
                a(USERINFOKEY.UserName, jSONObject.optString("userName"), 2);
            }
            if (jSONObject.has("userNewNo")) {
                a(USERINFOKEY.UserNewNo, Long.valueOf(jSONObject.optLong("userNewNo")), 2);
            }
            if (jSONObject.has("nickName")) {
                a(USERINFOKEY.NickName, jSONObject.optString("nickName"), 2);
            }
            if (jSONObject.has("account")) {
                a(USERINFOKEY.Account, Long.valueOf(jSONObject.optLong("account")), 2);
            }
            if (jSONObject.has("imgURL")) {
                a(USERINFOKEY.ImgURL, jSONObject.optString("imgURL"), 2);
            }
            if (jSONObject.has("isSubAccount")) {
                a(USERINFOKEY.IsSubAccount, Integer.valueOf(jSONObject.optInt("isSubAccount")), 2);
            }
            if (jSONObject.has("isSpecialNum")) {
                a(USERINFOKEY.IsSpecialNum, Integer.valueOf(jSONObject.optInt("isSpecialNum")), 2);
            }
            if (jSONObject.has("role")) {
                a(USERINFOKEY.Role, Integer.valueOf(jSONObject.optInt("role")), 2);
            }
            if (jSONObject.has("rank")) {
                a(USERINFOKEY.Rank, Integer.valueOf(jSONObject.optInt("rank")), 2);
            }
            if (jSONObject.has("order")) {
                a(USERINFOKEY.Order, Long.valueOf(jSONObject.optLong("order")), 2);
            }
            if (jSONObject.has("todayScore")) {
                a(USERINFOKEY.TodayScore, Integer.valueOf(jSONObject.optInt("todayScore")), 2);
            }
            if (jSONObject.has("allowScore")) {
                a(USERINFOKEY.AllowScore, Integer.valueOf(jSONObject.optInt("allowScore")), 2);
            }
            if (jSONObject.has("sex")) {
                a(USERINFOKEY.Sex, jSONObject.optString("sex"), 2);
            }
            if (jSONObject.has("mobile")) {
                a(USERINFOKEY.PhoneNumber, jSONObject.optString("mobile"), 2);
            }
            if (jSONObject.has("country")) {
                a(USERINFOKEY.Country, jSONObject.optString("country"), 2);
            }
            if (jSONObject.has("province")) {
                a(USERINFOKEY.Province, jSONObject.optString("province"), 2);
            }
            if (jSONObject.has("city")) {
                a(USERINFOKEY.City, jSONObject.optString("city"), 2);
            }
            if (jSONObject.has("personalSign")) {
                a(USERINFOKEY.PersonalSign, jSONObject.optString("personalSign"), 2);
            }
            if (jSONObject.has("birthday")) {
                a(USERINFOKEY.Birthday, jSONObject.optString("birthday"), 2);
            }
            jSONObject = jSONObject.optJSONArray("vipList");
            if (jSONObject != null) {
                z = jSONObject.length();
                for (boolean z2 = false; z2 < z; z2++) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(z2);
                    if (optJSONObject != null) {
                        int optInt;
                        int optInt2;
                        USERINFOKEY userinfokey;
                        Object valueOf;
                        if (optJSONObject.has("vasid")) {
                            optInt = optJSONObject.optInt("vasid");
                            a(USERINFOKEY.VasId, Integer.valueOf(optInt), optInt);
                        } else {
                            optInt = 2;
                        }
                        if (optJSONObject.has("isRemind")) {
                            a(USERINFOKEY.IsRemind, Integer.valueOf(optJSONObject.optInt("isRemind")), optInt);
                        }
                        if (optJSONObject.has("isAutoDeduct")) {
                            a(USERINFOKEY.IsAutoDeduct, Integer.valueOf(optJSONObject.optInt("isAutoDeduct")), optInt);
                        }
                        if (optJSONObject.has("vipDayGrow")) {
                            a(USERINFOKEY.VipDayGrow, Integer.valueOf(optJSONObject.optInt("vipDayGrow")), optInt);
                        }
                        if (optJSONObject.has("vipGrow")) {
                            a(USERINFOKEY.VipGrow, Long.valueOf(optJSONObject.optLong("vipGrow")), optInt);
                        }
                        if (optJSONObject.has("isYear")) {
                            a(USERINFOKEY.IsYear, Integer.valueOf(optJSONObject.optInt("isYear")), optInt);
                        }
                        if (optJSONObject.has("register")) {
                            a(USERINFOKEY.Rigster, optJSONObject.optString("register"), optInt);
                        }
                        if (optJSONObject.has("vipLevel")) {
                            a(USERINFOKEY.vip_level, optJSONObject.optString("vipLevel"), optInt);
                        }
                        if (optJSONObject.has("vasType")) {
                            a(USERINFOKEY.VasType, Integer.valueOf(optJSONObject.optInt("vasType")), optInt);
                        }
                        if (optJSONObject.has("expireDate")) {
                            a(USERINFOKEY.ExpireDate, optJSONObject.optString("expireDate"), optInt);
                        }
                        if (optJSONObject.has("payName")) {
                            a(USERINFOKEY.PayName, optJSONObject.optString("payName"), optInt);
                        }
                        int optInt3;
                        if (optJSONObject.has("payId")) {
                            optInt3 = optJSONObject.optInt("payId");
                            a(USERINFOKEY.PayId, Integer.valueOf(optInt3), optInt);
                        } else {
                            optInt3 = 0;
                        }
                        if (optJSONObject.has("isVip")) {
                            optInt2 = optJSONObject.optInt("isVip");
                            a(USERINFOKEY.IsVip, Integer.valueOf(optInt2), optInt);
                        } else {
                            optInt2 = 0;
                        }
                        if (optInt2 != 1 || r5 <= 1000) {
                            userinfokey = USERINFOKEY.isExpVip;
                            valueOf = Integer.valueOf(0);
                        } else {
                            userinfokey = USERINFOKEY.isExpVip;
                            valueOf = Integer.valueOf(1);
                        }
                        a(userinfokey, valueOf, optInt);
                    }
                }
            }
        }
    }

    public final synchronized void a() {
        for (Entry entry : this.c.entrySet()) {
            Object obj;
            USERINFOKEY userinfokey = (USERINFOKEY) entry.getKey();
            if (!(userinfokey == USERINFOKEY.SessionID || userinfokey == USERINFOKEY.UserID || userinfokey == USERINFOKEY.UserName)) {
                if (userinfokey != USERINFOKEY.UserNewNo) {
                    obj = null;
                    if (obj == null) {
                        this.c.put(entry.getKey(), null);
                    }
                }
            }
            obj = 1;
            if (obj == null) {
                this.c.put(entry.getKey(), null);
            }
        }
        this.d.clear();
    }

    public final int getIntValue(USERINFOKEY userinfokey) {
        return getIntValue(userinfokey, 2);
    }

    public final int getIntValue(USERINFOKEY userinfokey, int i) {
        if (e(userinfokey)) {
            userinfokey = this.c.get(userinfokey);
        } else {
            Map map = (Map) this.d.get(Integer.valueOf(i));
            userinfokey = map != null ? map.get(userinfokey) : null;
        }
        if (userinfokey == null) {
            return null;
        }
        return Integer.parseInt(userinfokey.toString());
    }

    public final String getStringValue(USERINFOKEY userinfokey) {
        return getStringValue(userinfokey, 2);
    }

    public final String getStringValue(USERINFOKEY userinfokey, int i) {
        if (e(userinfokey)) {
            userinfokey = this.c.get(userinfokey);
        } else {
            Map map = (Map) this.d.get(Integer.valueOf(i));
            userinfokey = map != null ? map.get(userinfokey) : null;
        }
        if (userinfokey == null) {
            return "";
        }
        return userinfokey.toString();
    }

    public final long getLongValue(USERINFOKEY userinfokey) {
        return getLongValue(userinfokey, 2);
    }

    public final long getLongValue(USERINFOKEY userinfokey, int i) {
        if (e(userinfokey)) {
            userinfokey = this.c.get(userinfokey);
        } else {
            Map map = (Map) this.d.get(Integer.valueOf(i));
            userinfokey = map != null ? map.get(userinfokey) : null;
        }
        if (userinfokey == null) {
            return null;
        }
        return Long.parseLong(userinfokey.toString());
    }

    public final String getJumpKey(int i) {
        if (!d()) {
            return "";
        }
        m w = p.a().w();
        if (w == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getStringValue(USERINFOKEY.SessionID));
        stringBuffer.append(" ");
        stringBuffer.append(p.a().x());
        stringBuffer.append(" ");
        stringBuffer.append(p.a().d());
        stringBuffer.append(" ");
        stringBuffer.append(i);
        StringBuilder stringBuilder = new StringBuilder("gen jumpkey raw:");
        stringBuilder.append(stringBuffer.toString());
        XLLog.v("XLUserInfoImpl", stringBuilder.toString());
        i = HextoChar.parseByte2HexStr(AES.encrypt(stringBuffer.toString().getBytes(), HextoChar.parseHexStr2Byte(w.b()), "PKCS5Padding", "CBC"));
        stringBuffer = new StringBuffer();
        stringBuffer.append("jk");
        stringBuffer.append(w.a());
        stringBuffer.append(".");
        stringBuffer.append(getLongValue(USERINFOKEY.UserID));
        stringBuffer.append(".");
        stringBuffer.append(i);
        return stringBuffer.toString();
    }

    public final String getAvatarUrl(int i) {
        Object stringValue = getStringValue(USERINFOKEY.ImgURL);
        if (!TextUtils.isEmpty(stringValue)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("x");
            stringBuilder.append(i);
            i = stringBuilder.toString();
            try {
                return String.format(stringValue, new Object[]{i});
            } catch (int i2) {
                StringBuilder stringBuilder2 = new StringBuilder("format avatar url error msg = ");
                stringBuilder2.append(i2.getMessage());
                XLLog.v("XLUserInfo", stringBuilder2.toString());
            }
        }
        return stringValue;
    }

    public final void clearUserData() {
        this.c.clear();
        for (Entry value : this.d.entrySet()) {
            Map map = (Map) value.getValue();
            if (map != null) {
                map.clear();
            }
        }
        this.d.clear();
        c(p.a().h());
    }

    public final void b() {
        this.c.put(USERINFOKEY.SessionID, "");
    }

    public final void dump() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--------------------dump user info start----------------------\n");
        for (Entry entry : this.c.entrySet()) {
            stringBuffer.append("key = ");
            stringBuffer.append(entry.getKey());
            stringBuffer.append("\n");
            Object value = entry.getValue();
            String str = "null";
            if (value != null) {
                str = value.toString();
            }
            stringBuffer.append("value = ");
            stringBuffer.append(str);
            stringBuffer.append("\n");
        }
        stringBuffer.append("--------------------dump user info end----------------------\n");
        XLLog.v("XLUserInfo", stringBuffer.toString());
    }

    public final void a(android.content.Context r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        c(r7);
        r0 = com.xunlei.common.new_ptl.member.a.d.a(r7);
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r1 = r0.a;
        r3 = 0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        r1 = 1;
        r2 = 0;
        if (r5 == 0) goto L_0x001e;
    L_0x0014:
        r0 = r0.b;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x001e;
    L_0x001c:
        r0 = r1;
        goto L_0x001f;
    L_0x001e:
        r0 = r2;
    L_0x001f:
        if (r0 != 0) goto L_0x0022;
    L_0x0021:
        return;
    L_0x0022:
        r0 = "xl-acc-user";
        r7 = r7.getSharedPreferences(r0, r2);
        r7 = r7.edit();
        r0 = "version";
        r3 = 100;
        r7.putInt(r0, r3);
        r0 = r6.c;
        r0 = r0.entrySet();
        r0 = r0.iterator();
    L_0x003d:
        r3 = r0.hasNext();
        if (r3 == 0) goto L_0x0070;
    L_0x0043:
        r3 = r0.next();
        r3 = (java.util.Map.Entry) r3;
        r4 = r3.getKey();
        r4 = (com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY) r4;
        r5 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.SessionID;
        if (r4 != r5) goto L_0x0055;
    L_0x0053:
        r4 = r1;
        goto L_0x0056;
    L_0x0055:
        r4 = r2;
    L_0x0056:
        if (r4 != 0) goto L_0x003d;
    L_0x0058:
        r4 = r3.getValue();
        if (r4 == 0) goto L_0x003d;
    L_0x005e:
        r4 = r4.toString();
        r3 = r3.getKey();
        r3 = (com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY) r3;
        r3 = r3.toString();
        r7.putString(r3, r4);
        goto L_0x003d;
    L_0x0070:
        r0 = new java.util.HashSet;
        r0.<init>();
        r1 = r6.d;
        r1 = r1.entrySet();
        r1 = r1.iterator();
    L_0x007f:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x00cc;
    L_0x0085:
        r2 = r1.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = new org.json.JSONObject;
        r3.<init>();
        r2 = r2.getValue();
        r2 = (java.util.Map) r2;
        r2 = r2.entrySet();
        r2 = r2.iterator();
    L_0x009e:
        r4 = r2.hasNext();
        if (r4 == 0) goto L_0x00bc;
    L_0x00a4:
        r4 = r2.next();
        r4 = (java.util.Map.Entry) r4;
        r5 = r4.getValue();
        r4 = r4.getKey();	 Catch:{ JSONException -> 0x009e }
        r4 = (com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY) r4;	 Catch:{ JSONException -> 0x009e }
        r4 = r4.name();	 Catch:{ JSONException -> 0x009e }
        r3.put(r4, r5);	 Catch:{ JSONException -> 0x009e }
        goto L_0x009e;
    L_0x00bc:
        r2 = r3.toString();
        r2 = r2.getBytes();
        r2 = com.xunlei.common.encrypt.Base64.encode(r2);
        r0.add(r2);
        goto L_0x007f;
    L_0x00cc:
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x00db;
    L_0x00d2:
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.VipList;
        r1 = r1.name();
        r7.putStringSet(r1, r0);
    L_0x00db:
        r7.apply();
        r7 = "XLUserInfo";
        r0 = "----------------end to save user info ----------------";
        com.xunlei.common.base.XLLog.v(r7, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.a.o.a(android.content.Context):void");
    }

    public final void b(android.content.Context r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = "xl-acc-user";
        r1 = 0;
        r0 = r12.getSharedPreferences(r0, r1);
        r0 = r0.getAll();
        r2 = "version";
        r2 = r0.get(r2);
        r2 = (java.lang.Integer) r2;
        r3 = 100;
        if (r0 == 0) goto L_0x00c0;
    L_0x0017:
        r4 = r0.entrySet();
        r4 = r4.iterator();
    L_0x001f:
        r5 = r4.hasNext();
        if (r5 == 0) goto L_0x00c0;
    L_0x0025:
        r5 = r4.next();
        r5 = (java.util.Map.Entry) r5;
        r6 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.class;	 Catch:{ Exception -> 0x001f }
        r7 = r5.getKey();	 Catch:{ Exception -> 0x001f }
        r7 = (java.lang.String) r7;	 Catch:{ Exception -> 0x001f }
        r6 = java.lang.Enum.valueOf(r6, r7);	 Catch:{ Exception -> 0x001f }
        r6 = (com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY) r6;	 Catch:{ Exception -> 0x001f }
        r7 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.VipList;
        if (r6 != r7) goto L_0x008d;
    L_0x003d:
        r5 = r5.getValue();
        r5 = (java.util.Set) r5;
        if (r5 == 0) goto L_0x001f;
    L_0x0045:
        r5 = r5.iterator();
    L_0x0049:
        r6 = r5.hasNext();
        if (r6 == 0) goto L_0x001f;
    L_0x004f:
        r6 = new java.lang.String;
        r7 = r5.next();
        r7 = (java.lang.String) r7;
        r7 = com.xunlei.common.encrypt.Base64.decode(r7);
        r6.<init>(r7);
        r7 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0049 }
        r7.<init>(r6);	 Catch:{ JSONException -> 0x0049 }
        r6 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.VasId;	 Catch:{ JSONException -> 0x0049 }
        r6 = r6.name();	 Catch:{ JSONException -> 0x0049 }
        r6 = r7.optInt(r6);	 Catch:{ JSONException -> 0x0049 }
        r8 = r7.keys();	 Catch:{ JSONException -> 0x0049 }
    L_0x0071:
        r9 = r8.hasNext();	 Catch:{ JSONException -> 0x0049 }
        if (r9 == 0) goto L_0x0049;	 Catch:{ JSONException -> 0x0049 }
    L_0x0077:
        r9 = r8.next();	 Catch:{ JSONException -> 0x0049 }
        r9 = (java.lang.String) r9;	 Catch:{ JSONException -> 0x0049 }
        r10 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.class;	 Catch:{ JSONException -> 0x0049 }
        r10 = java.lang.Enum.valueOf(r10, r9);	 Catch:{ JSONException -> 0x0049 }
        r10 = (com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY) r10;	 Catch:{ JSONException -> 0x0049 }
        r9 = r7.getString(r9);	 Catch:{ JSONException -> 0x0049 }
        r11.a(r10, r9, r6);	 Catch:{ JSONException -> 0x0049 }
        goto L_0x0071;
    L_0x008d:
        r5 = r5.getValue();
        r5 = (java.lang.String) r5;
        r7 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.PayName;
        if (r6 == r7) goto L_0x00a6;
    L_0x0097:
        r7 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.Province;
        if (r6 == r7) goto L_0x00a6;
    L_0x009b:
        r7 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.City;
        if (r6 == r7) goto L_0x00a6;
    L_0x009f:
        r7 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.NickName;
        if (r6 != r7) goto L_0x00a4;
    L_0x00a3:
        goto L_0x00a6;
    L_0x00a4:
        r7 = r1;
        goto L_0x00a7;
    L_0x00a6:
        r7 = 1;
    L_0x00a7:
        if (r7 == 0) goto L_0x00b1;
    L_0x00a9:
        if (r2 == 0) goto L_0x001f;
    L_0x00ab:
        r7 = r2.intValue();
        if (r7 < r3) goto L_0x001f;
    L_0x00b1:
        if (r5 == 0) goto L_0x001f;
    L_0x00b3:
        r7 = e(r6);
        if (r7 == 0) goto L_0x001f;
    L_0x00b9:
        r7 = r11.c;
        r7.put(r6, r5);
        goto L_0x001f;
    L_0x00c0:
        if (r2 == 0) goto L_0x00c8;
    L_0x00c2:
        r1 = r2.intValue();
        if (r1 >= r3) goto L_0x0246;
    L_0x00c8:
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.VasId;
        r2 = 2;
        r3 = java.lang.Integer.valueOf(r2);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.IsVip;
        r3 = "IsVip";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.vip_level;
        r3 = "vip_level";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.ExpireDate;
        r3 = "ExpireDate";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.PayName;
        r3 = "PayName";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.VipGrow;
        r3 = "VipGrow";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.VipDayGrow;
        r3 = "VipDayGrow";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.IsAutoDeduct;
        r3 = "IsAutoDeduct";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.IsRemind;
        r3 = "IsRemind";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.PayId;
        r3 = "PayId";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.IsYear;
        r3 = "IsYear";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.Rigster;
        r3 = "Rigster";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.VasType;
        r3 = "VasType";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.isExpVip;
        r3 = "isExpVip";
        r3 = r0.get(r3);
        r11.a(r1, r3, r2);
        r1 = "VasId";
        r1 = r0.get(r1);
        r1 = (java.lang.String) r1;
        if (r1 == 0) goto L_0x0243;
    L_0x016b:
        r1 = java.lang.Integer.valueOf(r1);
        if (r1 == 0) goto L_0x0243;
    L_0x0171:
        r2 = r1.intValue();
        if (r2 <= 0) goto L_0x0243;
    L_0x0177:
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.VasId;
        r3 = r1.intValue();
        r11.a(r2, r1, r3);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.IsVip;
        r3 = "other_IsVip";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.vip_level;
        r3 = "other_VipLevel";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.ExpireDate;
        r3 = "other_ExpireDate";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.PayName;
        r3 = "other_PayName";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.VipGrow;
        r3 = "other_VipGrow";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.VipDayGrow;
        r3 = "other_VipDayGrow";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.IsAutoDeduct;
        r3 = "other_IsAutoDeduct";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.IsRemind;
        r3 = "other_IsRemind";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.PayId;
        r3 = "other_PayId";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.IsYear;
        r3 = "other_IsYear";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.Rigster;
        r3 = "other_Register";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.VasType;
        r3 = "other_VasType";
        r3 = r0.get(r3);
        r4 = r1.intValue();
        r11.a(r2, r3, r4);
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.isExpVip;
        r3 = "other_IsExpVip";
        r0 = r0.get(r3);
        r1 = r1.intValue();
        r11.a(r2, r0, r1);
    L_0x0243:
        r11.a(r12);
    L_0x0246:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.a.o.b(android.content.Context):void");
    }

    private static void c(Context context) {
        context = context.getSharedPreferences(b, 0).edit();
        context.clear();
        context.apply();
    }

    private final void a(USERINFOKEY userinfokey, Object obj) {
        a(userinfokey, obj, 2);
    }

    private static boolean a(USERINFOKEY userinfokey) {
        if (!(userinfokey == USERINFOKEY.PayName || userinfokey == USERINFOKEY.Province || userinfokey == USERINFOKEY.City)) {
            if (userinfokey != USERINFOKEY.NickName) {
                return null;
            }
        }
        return true;
    }

    private static boolean b(USERINFOKEY userinfokey) {
        if (!(userinfokey == USERINFOKEY.NickName || userinfokey == USERINFOKEY.PayName || userinfokey == USERINFOKEY.Province || userinfokey == USERINFOKEY.City || userinfokey == USERINFOKEY.Country)) {
            if (userinfokey != USERINFOKEY.PersonalSign) {
                return null;
            }
        }
        return true;
    }

    private static boolean c(USERINFOKEY userinfokey) {
        return userinfokey == USERINFOKEY.SessionID ? true : null;
    }

    private static boolean d(USERINFOKEY userinfokey) {
        if (!(userinfokey == USERINFOKEY.SessionID || userinfokey == USERINFOKEY.UserID || userinfokey == USERINFOKEY.UserName)) {
            if (userinfokey != USERINFOKEY.UserNewNo) {
                return null;
            }
        }
        return true;
    }

    private final void b(USERINFOKEY userinfokey, Object obj) {
        if (obj != null && e(userinfokey)) {
            this.c.put(userinfokey, obj);
        }
    }

    private static boolean e(USERINFOKEY userinfokey) {
        if (!(userinfokey == USERINFOKEY.UserID || userinfokey == USERINFOKEY.SessionID || userinfokey == USERINFOKEY.UserName || userinfokey == USERINFOKEY.UserNewNo || userinfokey == USERINFOKEY.NickName || userinfokey == USERINFOKEY.Account || userinfokey == USERINFOKEY.ImgURL || userinfokey == USERINFOKEY.IsSubAccount || userinfokey == USERINFOKEY.IsSpecialNum || userinfokey == USERINFOKEY.Role || userinfokey == USERINFOKEY.Rank || userinfokey == USERINFOKEY.Order || userinfokey == USERINFOKEY.TodayScore || userinfokey == USERINFOKEY.AllowScore || userinfokey == USERINFOKEY.Sex || userinfokey == USERINFOKEY.PhoneNumber || userinfokey == USERINFOKEY.Country || userinfokey == USERINFOKEY.Province || userinfokey == USERINFOKEY.City || userinfokey == USERINFOKEY.PersonalSign)) {
            if (userinfokey != USERINFOKEY.Birthday) {
                return null;
            }
        }
        return true;
    }

    private static boolean a(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches() == null ? null : true;
    }

    public final boolean c() {
        return getLongValue(USERINFOKEY.UserID) != 0;
    }

    public final boolean d() {
        return (TextUtils.isEmpty(getStringValue(USERINFOKEY.SessionID)) || getLongValue(USERINFOKEY.UserID) == 0) ? false : true;
    }

    public final o e() {
        o oVar = new o();
        oVar.c.putAll(this.c);
        for (Entry entry : this.d.entrySet()) {
            Map map = (Map) entry.getValue();
            if (map != null) {
                Map hashMap = new HashMap();
                hashMap.putAll(map);
                oVar.d.put(entry.getKey(), hashMap);
            }
        }
        return oVar;
    }

    private final void a(USERINFOKEY userinfokey, Object obj, int i) {
        if (obj != null) {
            Object obj2;
            Map map;
            if (!(userinfokey == USERINFOKEY.NickName || userinfokey == USERINFOKEY.PayName || userinfokey == USERINFOKEY.Province || userinfokey == USERINFOKEY.City || userinfokey == USERINFOKEY.Country)) {
                if (userinfokey != USERINFOKEY.PersonalSign) {
                    obj2 = null;
                    if (obj2 != null) {
                        obj = XLUtilTools.transformUTF8String((String) obj);
                    }
                    if (e(userinfokey)) {
                        map = (Map) this.d.get(Integer.valueOf(i));
                        if (map == null) {
                            map = new HashMap();
                            this.d.put(Integer.valueOf(i), map);
                        }
                        map.put(userinfokey, obj);
                        return;
                    }
                    this.c.put(userinfokey, obj);
                }
            }
            obj2 = 1;
            if (obj2 != null) {
                obj = XLUtilTools.transformUTF8String((String) obj);
            }
            if (e(userinfokey)) {
                map = (Map) this.d.get(Integer.valueOf(i));
                if (map == null) {
                    map = new HashMap();
                    this.d.put(Integer.valueOf(i), map);
                }
                map.put(userinfokey, obj);
                return;
            }
            this.c.put(userinfokey, obj);
        }
    }
}
