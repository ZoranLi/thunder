package com.xunlei.downloadprovider.member.payment.activity;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import org.json.JSONObject;

final class LimitCondition {
    public String a;
    public String b;
    public String c;

    private enum Condition {
        growValue("growValue"),
        jsTryNum("jsTryNum"),
        remainDay("remainDay"),
        vipType("vipType");
        
        private String value;

        private Condition(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        public static boolean isLegalCondition(String str) {
            return getCondition(str) != null ? true : null;
        }

        public static Condition getCondition(String str) {
            for (Condition condition : values()) {
                if (TextUtils.equals(condition.getValue(), str)) {
                    return condition;
                }
            }
            return null;
        }
    }

    private enum LimitType {
        less_than("1"),
        not_more_than("2"),
        equal("3"),
        not_less_than("4"),
        more_than("5"),
        no_equal(Constants.VIA_SHARE_TYPE_INFO);
        
        private String value;

        private LimitType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        public static boolean isLegalLimitType(String str) {
            return getLimitType(str) != null ? true : null;
        }

        public static LimitType getLimitType(String str) {
            for (LimitType limitType : values()) {
                if (TextUtils.equals(limitType.getValue(), str)) {
                    return limitType;
                }
            }
            return null;
        }
    }

    private enum VipType {
        no_vip(1),
        normal_vip(2),
        baijin_vip(3),
        super_vip(4),
        normal_year_vip(5),
        baijin_year_vip(6),
        super_year_vip(7),
        normal_expire_vip(8),
        baijin_expire_vip(9),
        super_expire_vip(10),
        kuainiao_vip(11);
        
        private int value;

        private VipType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public static VipType getVipType(int i) {
            for (VipType vipType : values()) {
                if (vipType.getValue() == i) {
                    return vipType;
                }
            }
            return 0;
        }
    }

    LimitCondition() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(java.util.List<com.xunlei.downloadprovider.member.payment.activity.LimitCondition> r10) {
        /*
        r0 = 1;
        if (r10 == 0) goto L_0x0232;
    L_0x0003:
        r1 = r10.isEmpty();
        if (r1 == 0) goto L_0x000b;
    L_0x0009:
        goto L_0x0232;
    L_0x000b:
        r10 = r10.iterator();
    L_0x000f:
        r1 = r10.hasNext();
        if (r1 == 0) goto L_0x0231;
    L_0x0015:
        r1 = r10.next();
        r1 = (com.xunlei.downloadprovider.member.payment.activity.LimitCondition) r1;
        r2 = r1.a;
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.Condition.getCondition(r2);
        r3 = 0;
        if (r2 == 0) goto L_0x022d;
    L_0x0024:
        r4 = r1.b;
        r4 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.getLimitType(r4);
        r5 = com.xunlei.downloadprovider.member.payment.a.j.a();
        r5 = r5.c();
        r6 = com.xunlei.downloadprovider.member.payment.a.j.a();
        r6 = r6.d();
        com.xunlei.downloadprovider.member.payment.a.j.a();
        r7 = com.xunlei.downloadprovider.member.login.b.l.b();
        r8 = com.xunlei.downloadprovider.member.payment.activity.o.a;
        r2 = r2.ordinal();
        r2 = r8[r2];
        switch(r2) {
            case 1: goto L_0x01ce;
            case 2: goto L_0x01c9;
            case 3: goto L_0x017b;
            case 4: goto L_0x004e;
            default: goto L_0x004c;
        };
    L_0x004c:
        goto L_0x022d;
    L_0x004e:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.equal;
        r8 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        r9 = 2;
        if (r2 != r4) goto L_0x00de;
    L_0x0055:
        r1 = r1.c;
        r1 = a(r1);
        r1 = r1.intValue();
        r1 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.VipType.getVipType(r1);
        if (r1 == 0) goto L_0x022d;
    L_0x0065:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.VipType.no_vip;
        if (r1 == r2) goto L_0x006b;
    L_0x0069:
        if (r7 == 0) goto L_0x022d;
    L_0x006b:
        r2 = com.xunlei.downloadprovider.member.payment.a.j.a();
        r2 = r2.e();
        r4 = com.xunlei.downloadprovider.member.payment.activity.o.b;
        r1 = r1.ordinal();
        r1 = r4[r1];
        switch(r1) {
            case 1: goto L_0x00da;
            case 2: goto L_0x00d4;
            case 3: goto L_0x00ce;
            case 4: goto L_0x00c6;
            case 5: goto L_0x00bc;
            case 6: goto L_0x00b2;
            case 7: goto L_0x00a6;
            case 8: goto L_0x009c;
            case 9: goto L_0x0092;
            case 10: goto L_0x0086;
            case 11: goto L_0x0080;
            default: goto L_0x007e;
        };
    L_0x007e:
        goto L_0x022d;
    L_0x0080:
        if (r5 == 0) goto L_0x022d;
    L_0x0082:
        if (r6 != r8) goto L_0x022d;
    L_0x0084:
        goto L_0x01b4;
    L_0x0086:
        if (r5 == 0) goto L_0x022d;
    L_0x0088:
        r1 = com.xunlei.downloadprovider.member.payment.i.b(r6);
        if (r1 == 0) goto L_0x022d;
    L_0x008e:
        if (r2 == 0) goto L_0x022d;
    L_0x0090:
        goto L_0x01b4;
    L_0x0092:
        if (r5 != 0) goto L_0x022d;
    L_0x0094:
        r1 = com.xunlei.downloadprovider.member.payment.i.b(r6);
        if (r1 == 0) goto L_0x022d;
    L_0x009a:
        goto L_0x01e6;
    L_0x009c:
        if (r5 == 0) goto L_0x022d;
    L_0x009e:
        r1 = com.xunlei.downloadprovider.member.payment.i.b(r6);
        if (r1 == 0) goto L_0x022d;
    L_0x00a4:
        goto L_0x01b4;
    L_0x00a6:
        if (r5 == 0) goto L_0x022d;
    L_0x00a8:
        r1 = com.xunlei.downloadprovider.member.payment.i.a(r6);
        if (r1 == 0) goto L_0x022d;
    L_0x00ae:
        if (r2 == 0) goto L_0x022d;
    L_0x00b0:
        goto L_0x01e6;
    L_0x00b2:
        if (r5 != 0) goto L_0x022d;
    L_0x00b4:
        r1 = com.xunlei.downloadprovider.member.payment.i.a(r6);
        if (r1 == 0) goto L_0x022d;
    L_0x00ba:
        goto L_0x01e6;
    L_0x00bc:
        if (r5 == 0) goto L_0x022d;
    L_0x00be:
        r1 = com.xunlei.downloadprovider.member.payment.i.a(r6);
        if (r1 == 0) goto L_0x022d;
    L_0x00c4:
        goto L_0x01b4;
    L_0x00c6:
        if (r5 == 0) goto L_0x022d;
    L_0x00c8:
        if (r6 != r9) goto L_0x022d;
    L_0x00ca:
        if (r2 == 0) goto L_0x022d;
    L_0x00cc:
        goto L_0x01b4;
    L_0x00ce:
        if (r5 != 0) goto L_0x022d;
    L_0x00d0:
        if (r6 != r9) goto L_0x022d;
    L_0x00d2:
        goto L_0x01e6;
    L_0x00d4:
        if (r5 == 0) goto L_0x022d;
    L_0x00d6:
        if (r6 != r9) goto L_0x022d;
    L_0x00d8:
        goto L_0x01b4;
    L_0x00da:
        if (r5 != 0) goto L_0x022d;
    L_0x00dc:
        goto L_0x01e6;
    L_0x00de:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.no_equal;
        if (r2 != r4) goto L_0x022d;
    L_0x00e2:
        r1 = r1.c;
        r1 = a(r1);
        r1 = r1.intValue();
        r1 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.VipType.getVipType(r1);
        r2 = com.xunlei.downloadprovider.member.payment.a.j.a();
        r2 = r2.e();
        if (r1 == 0) goto L_0x022d;
    L_0x00fa:
        r4 = com.xunlei.downloadprovider.member.payment.activity.o.b;
        r1 = r1.ordinal();
        r1 = r4[r1];
        switch(r1) {
            case 1: goto L_0x0175;
            case 2: goto L_0x016d;
            case 3: goto L_0x0165;
            case 4: goto L_0x015b;
            case 5: goto L_0x014f;
            case 6: goto L_0x0143;
            case 7: goto L_0x0135;
            case 8: goto L_0x0129;
            case 9: goto L_0x011d;
            case 10: goto L_0x010f;
            case 11: goto L_0x0107;
            default: goto L_0x0105;
        };
    L_0x0105:
        goto L_0x022d;
    L_0x0107:
        if (r7 == 0) goto L_0x01e6;
    L_0x0109:
        if (r5 == 0) goto L_0x01e6;
    L_0x010b:
        if (r6 == r8) goto L_0x022d;
    L_0x010d:
        goto L_0x01e6;
    L_0x010f:
        if (r7 == 0) goto L_0x01e6;
    L_0x0111:
        if (r5 == 0) goto L_0x01e6;
    L_0x0113:
        r1 = com.xunlei.downloadprovider.member.payment.i.b(r6);
        if (r1 == 0) goto L_0x01e6;
    L_0x0119:
        if (r2 != 0) goto L_0x022d;
    L_0x011b:
        goto L_0x01e6;
    L_0x011d:
        if (r7 == 0) goto L_0x01e6;
    L_0x011f:
        if (r5 != 0) goto L_0x01e6;
    L_0x0121:
        r1 = com.xunlei.downloadprovider.member.payment.i.b(r6);
        if (r1 != 0) goto L_0x022d;
    L_0x0127:
        goto L_0x01e6;
    L_0x0129:
        if (r7 == 0) goto L_0x01e6;
    L_0x012b:
        if (r5 == 0) goto L_0x01e6;
    L_0x012d:
        r1 = com.xunlei.downloadprovider.member.payment.i.b(r6);
        if (r1 != 0) goto L_0x022d;
    L_0x0133:
        goto L_0x01e6;
    L_0x0135:
        if (r7 == 0) goto L_0x01e6;
    L_0x0137:
        if (r5 == 0) goto L_0x01e6;
    L_0x0139:
        r1 = com.xunlei.downloadprovider.member.payment.i.a(r6);
        if (r1 == 0) goto L_0x01e6;
    L_0x013f:
        if (r2 != 0) goto L_0x022d;
    L_0x0141:
        goto L_0x01e6;
    L_0x0143:
        if (r7 == 0) goto L_0x01e6;
    L_0x0145:
        if (r5 != 0) goto L_0x01e6;
    L_0x0147:
        r1 = com.xunlei.downloadprovider.member.payment.i.a(r6);
        if (r1 != 0) goto L_0x022d;
    L_0x014d:
        goto L_0x01e6;
    L_0x014f:
        if (r7 == 0) goto L_0x01e6;
    L_0x0151:
        if (r5 == 0) goto L_0x01e6;
    L_0x0153:
        r1 = com.xunlei.downloadprovider.member.payment.i.a(r6);
        if (r1 != 0) goto L_0x022d;
    L_0x0159:
        goto L_0x01e6;
    L_0x015b:
        if (r7 == 0) goto L_0x01e6;
    L_0x015d:
        if (r5 == 0) goto L_0x01e6;
    L_0x015f:
        if (r6 != r9) goto L_0x01e6;
    L_0x0161:
        if (r2 != 0) goto L_0x022d;
    L_0x0163:
        goto L_0x01e6;
    L_0x0165:
        if (r7 == 0) goto L_0x01e6;
    L_0x0167:
        if (r5 != 0) goto L_0x01e6;
    L_0x0169:
        if (r6 == r9) goto L_0x022d;
    L_0x016b:
        goto L_0x01e6;
    L_0x016d:
        if (r7 == 0) goto L_0x01e6;
    L_0x016f:
        if (r5 == 0) goto L_0x01e6;
    L_0x0171:
        if (r6 == r9) goto L_0x022d;
    L_0x0173:
        goto L_0x01e6;
    L_0x0175:
        if (r7 == 0) goto L_0x022d;
    L_0x0177:
        if (r5 == 0) goto L_0x022d;
    L_0x0179:
        goto L_0x01e6;
    L_0x017b:
        r2 = com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r2 = r2.o();
        r5 = com.xunlei.downloadprovider.personal.a.f.a.a(r2);
        r1 = r1.c;
        r1 = a(r1);
        r1 = r1.intValue();
        r7 = 0;
        r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r2 < 0) goto L_0x022d;
    L_0x0197:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.not_less_than;
        if (r2 != r4) goto L_0x01a1;
    L_0x019b:
        r1 = (long) r1;
        r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r4 < 0) goto L_0x022d;
    L_0x01a0:
        goto L_0x01e6;
    L_0x01a1:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.equal;
        if (r2 != r4) goto L_0x01ab;
    L_0x01a5:
        r1 = (long) r1;
        r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r4 != 0) goto L_0x022d;
    L_0x01aa:
        goto L_0x01e6;
    L_0x01ab:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.not_more_than;
        if (r2 != r4) goto L_0x01b5;
    L_0x01af:
        r1 = (long) r1;
        r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r4 > 0) goto L_0x022d;
    L_0x01b4:
        goto L_0x01e6;
    L_0x01b5:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.less_than;
        if (r2 != r4) goto L_0x01bf;
    L_0x01b9:
        r1 = (long) r1;
        r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r4 >= 0) goto L_0x022d;
    L_0x01be:
        goto L_0x01e6;
    L_0x01bf:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.more_than;
        if (r2 != r4) goto L_0x022d;
    L_0x01c3:
        r1 = (long) r1;
        r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r4 <= 0) goto L_0x022d;
    L_0x01c8:
        goto L_0x01b4;
    L_0x01c9:
        if (r5 == 0) goto L_0x022d;
    L_0x01cb:
        if (r7 != 0) goto L_0x01e6;
    L_0x01cd:
        goto L_0x022d;
    L_0x01ce:
        r1 = r1.c;
        r1 = a(r1);
        r1 = r1.intValue();
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.not_less_than;
        if (r2 != r4) goto L_0x01e8;
    L_0x01dc:
        r2 = com.xunlei.downloadprovider.member.payment.a.j.a();
        r2 = r2.g();
        if (r2 < r1) goto L_0x022d;
    L_0x01e6:
        r1 = r0;
        goto L_0x022e;
    L_0x01e8:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.equal;
        if (r2 != r4) goto L_0x0200;
    L_0x01ec:
        if (r1 != 0) goto L_0x01f5;
    L_0x01ee:
        if (r7 == 0) goto L_0x022d;
    L_0x01f0:
        if (r5 != 0) goto L_0x022d;
    L_0x01f2:
        if (r6 != 0) goto L_0x022d;
    L_0x01f4:
        goto L_0x01b4;
    L_0x01f5:
        r2 = com.xunlei.downloadprovider.member.payment.a.j.a();
        r2 = r2.g();
        if (r2 != r1) goto L_0x022d;
    L_0x01ff:
        goto L_0x01e6;
    L_0x0200:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.not_more_than;
        if (r2 != r4) goto L_0x020f;
    L_0x0204:
        r2 = com.xunlei.downloadprovider.member.payment.a.j.a();
        r2 = r2.g();
        if (r2 > r1) goto L_0x022d;
    L_0x020e:
        goto L_0x01e6;
    L_0x020f:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.less_than;
        if (r2 != r4) goto L_0x021e;
    L_0x0213:
        r2 = com.xunlei.downloadprovider.member.payment.a.j.a();
        r2 = r2.g();
        if (r2 >= r1) goto L_0x022d;
    L_0x021d:
        goto L_0x01e6;
    L_0x021e:
        r2 = com.xunlei.downloadprovider.member.payment.activity.LimitCondition.LimitType.more_than;
        if (r2 != r4) goto L_0x022d;
    L_0x0222:
        r2 = com.xunlei.downloadprovider.member.payment.a.j.a();
        r2 = r2.g();
        if (r2 <= r1) goto L_0x022d;
    L_0x022c:
        goto L_0x01e6;
    L_0x022d:
        r1 = r3;
    L_0x022e:
        if (r1 != 0) goto L_0x000f;
    L_0x0230:
        return r3;
    L_0x0231:
        return r0;
    L_0x0232:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.activity.LimitCondition.a(java.util.List):boolean");
    }

    static LimitCondition a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("condition");
        String optString2 = jSONObject.optString("limit_type");
        if (!Condition.isLegalCondition(optString) || !LimitType.isLegalLimitType(optString2)) {
            return null;
        }
        LimitCondition limitCondition = new LimitCondition();
        limitCondition.a = optString;
        limitCondition.b = optString2;
        limitCondition.c = jSONObject.optString(RequestHeaders.COLUMN_VALUE);
        return limitCondition;
    }

    private static java.lang.Integer a(java.lang.String r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0005 }
        goto L_0x0006;
    L_0x0005:
        r0 = -1;
    L_0x0006:
        r0 = java.lang.Integer.valueOf(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.activity.LimitCondition.a(java.lang.String):java.lang.Integer");
    }
}
