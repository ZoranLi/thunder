package com.xunlei.downloadprovider.member.payment.voucher;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Voucher implements Comparable<Voucher> {
    public float a;
    public String b;
    String c;
    public List<a> d;

    enum Condition {
        not_less_than("1"),
        not_more_than("2"),
        equal("3"),
        no_equal("4"),
        unknown("unknown");
        
        private String value;

        private Condition(String str) {
            this.value = str;
        }

        private static Condition getCondition(String str) {
            if (TextUtils.isEmpty(str)) {
                return unknown;
            }
            for (Condition condition : values()) {
                if (TextUtils.equals(condition.value, str)) {
                    return condition;
                }
            }
            return unknown;
        }
    }

    enum LimitType {
        amount("money"),
        month("month"),
        pay_biz("paybiz"),
        upgrade_day("updays"),
        unknown("unknown");
        
        private String value;

        private LimitType(String str) {
            this.value = str;
        }

        private static LimitType getLimitType(String str) {
            if (TextUtils.isEmpty(str)) {
                return unknown;
            }
            for (LimitType limitType : values()) {
                if (TextUtils.equals(limitType.value, str)) {
                    return limitType;
                }
            }
            return unknown;
        }
    }

    private enum State {
        available(0),
        expire(2),
        locked(3),
        used(4),
        invalid(5),
        unknown(-1);
        
        private int value;

        private State(int i) {
            this.value = i;
        }
    }

    static final class a {
        public LimitType a;
        public Condition b;
        public String c;
        String d;

        private a() {
        }

        static a a(JSONObject jSONObject) {
            if (jSONObject != null) {
                if (jSONObject.length() > 0) {
                    try {
                        a aVar = new a();
                        aVar.c = jSONObject.getString(RequestHeaders.COLUMN_VALUE);
                        aVar.d = jSONObject.optString("limit_tips");
                        aVar.a = LimitType.access$200(jSONObject.getString("limittype"));
                        aVar.b = Condition.access$300(jSONObject.getString("condition"));
                        return aVar;
                    } catch (Exception e) {
                        StringBuilder stringBuilder = new StringBuilder("[Limit:parseData]====");
                        stringBuilder.append(jSONObject.toString());
                        stringBuilder.append(" ，exception====");
                        stringBuilder.append(e.toString());
                        return null;
                    }
                }
            }
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
        float f = this.a - ((Voucher) obj).a;
        if (f > 0.0f) {
            return 1;
        }
        return f < 0.0f ? -1 : null;
    }

    private Voucher() {
    }

    static Voucher a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.length() != 0) {
                try {
                    String string = jSONObject.getString("fcard");
                    CharSequence optString = jSONObject.optString("flocktimes");
                    int i = 0;
                    if (!TextUtils.isEmpty(optString) && !TextUtils.equals("0", optString)) {
                        String.format("voucher(%s) is locked", new Object[]{string});
                        return null;
                    } else if (State.access$600(jSONObject.getInt("codeState")) != State.available) {
                        String.format("voucher(%s) is un available", new Object[]{string});
                        return null;
                    } else {
                        Voucher voucher = new Voucher();
                        voucher.a = c(jSONObject.getString("fprize")) / 100.0f;
                        voucher.b = string;
                        voucher.c = jSONObject.optString("fexpire");
                        JSONArray optJSONArray = jSONObject.optJSONArray("limit");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            int length = optJSONArray.length();
                            while (i < length) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                                if (jSONObject2 != null) {
                                    a a = a.a(jSONObject2);
                                    if (a != null) {
                                        if (voucher.d == null) {
                                            voucher.d = new ArrayList();
                                        }
                                        voucher.d.add(a);
                                    }
                                }
                                i++;
                            }
                        }
                        return voucher;
                    }
                } catch (Exception e) {
                    StringBuilder stringBuilder = new StringBuilder("[Voucher:parseData]====");
                    stringBuilder.append(jSONObject.toString());
                    stringBuilder.append(" ，exception====");
                    stringBuilder.append(e.toString());
                    return null;
                }
            }
        }
        return null;
    }

    private static float c(java.lang.String r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Float.parseFloat(r0);	 Catch:{ Exception -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.voucher.Voucher.c(java.lang.String):float");
    }

    private static int d(java.lang.String r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.voucher.Voucher.d(java.lang.String):int");
    }
}
