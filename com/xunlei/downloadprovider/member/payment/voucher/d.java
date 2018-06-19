package com.xunlei.downloadprovider.member.payment.voucher;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: ThunderVoucherProcessor */
public final class d extends e implements c {
    private HashMap<String, List<Voucher>> a = new HashMap(4);
    private HashMap<String, List<a>> b = new HashMap(4);
    private HashSet<String> c = new HashSet(8);
    private final byte[] d = new byte[0];

    public final void a(String str, a aVar) {
        if (aVar != null) {
            if (!TextUtils.isEmpty(str)) {
                if (!this.b.containsKey(str)) {
                    this.b.put(str, new ArrayList(4));
                }
                if (((List) this.b.get(str)).contains(aVar)) {
                    String.format("addCallback fail-->(%s, %s) had already added!", new Object[]{str, aVar.toString()});
                    return;
                }
                ((List) this.b.get(str)).add(aVar);
            }
        }
    }

    public final void b(String str, a aVar) {
        if (aVar != null) {
            if (!TextUtils.isEmpty(str)) {
                if (this.b.containsKey(str)) {
                    ((List) this.b.get(str)).remove(aVar);
                    return;
                }
                String.format("removeCallback fail-->(%s, %s) had not add!", new Object[]{str, aVar.toString()});
            }
        }
    }

    public final void a(VoucherBizNo voucherBizNo) {
        if (voucherBizNo != null) {
            String value = voucherBizNo.getValue();
            Builder buildUpon = Uri.parse("http://dynamic.vip.xunlei.com/cashv2/userCashList?").buildUpon();
            buildUpon.appendQueryParameter("userid", String.valueOf(LoginHelper.a().g.c()));
            buildUpon.appendQueryParameter("sessionid", LoginHelper.a().c());
            buildUpon.appendQueryParameter("paybiz", value);
            String uri = buildUpon.build().toString();
            a(voucherBizNo.getValue());
            voucherBizNo = new BaseJsonRequest(IMethod.GET, uri);
            voucherBizNo.a = "tag:get_voucher_list";
            voucherBizNo.a(null, new e(this, value), new g(this, value));
        }
    }

    public final List<Voucher> a(float f, int i, String str) {
        if (f <= 0.0f || !this.a.containsKey(str)) {
            return null;
        }
        List<Voucher> list = (List) this.a.get(str);
        if (list != null) {
            if (!list.isEmpty()) {
                List<Voucher> arrayList = new ArrayList(8);
                for (Voucher voucher : list) {
                    if (a(f, i, str, voucher)) {
                        arrayList.add(voucher);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(float r8, int r9, java.lang.String r10, com.xunlei.downloadprovider.member.payment.voucher.Voucher r11) {
        /*
        r7 = this;
        r0 = 0;
        r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        r2 = 0;
        if (r1 <= 0) goto L_0x017a;
    L_0x0006:
        if (r11 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x017a;
    L_0x000a:
        r1 = r7.c;
        r3 = r11.b;
        r1 = r1.contains(r3);
        if (r1 == 0) goto L_0x0015;
    L_0x0014:
        return r2;
    L_0x0015:
        r1 = r11.d;
        r3 = 1;
        if (r1 == 0) goto L_0x0172;
    L_0x001a:
        r1 = r11.d;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0024;
    L_0x0022:
        goto L_0x0172;
    L_0x0024:
        r11 = r11.d;
        r11 = r11.iterator();
    L_0x002a:
        r1 = r11.hasNext();
        if (r1 == 0) goto L_0x016d;
    L_0x0030:
        r1 = r11.next();
        r1 = (com.xunlei.downloadprovider.member.payment.voucher.Voucher.a) r1;
        r4 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r4 <= 0) goto L_0x0168;
    L_0x003a:
        r4 = com.xunlei.downloadprovider.member.payment.voucher.k.a;
        r5 = r1.a;
        r5 = r5.ordinal();
        r4 = r4[r5];
        switch(r4) {
            case 1: goto L_0x0114;
            case 2: goto L_0x00cc;
            case 3: goto L_0x0098;
            case 4: goto L_0x0049;
            default: goto L_0x0047;
        };
    L_0x0047:
        goto L_0x0168;
    L_0x0049:
        r4 = r1.b;
        r5 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.equal;
        if (r4 != r5) goto L_0x006f;
    L_0x004f:
        r4 = r1.c;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x0168;
    L_0x0057:
        r1 = r1.c;
        r4 = ",";
        r1 = r1.split(r4);
        r4 = r1.length;
        r5 = r2;
        r6 = r5;
    L_0x0062:
        if (r5 >= r4) goto L_0x0169;
    L_0x0064:
        r6 = r1[r5];
        r6 = android.text.TextUtils.equals(r10, r6);
        if (r6 != 0) goto L_0x0169;
    L_0x006c:
        r5 = r5 + 1;
        goto L_0x0062;
    L_0x006f:
        r4 = r1.b;
        r5 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.no_equal;
        if (r4 != r5) goto L_0x0168;
    L_0x0075:
        r4 = r1.c;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x0168;
    L_0x007d:
        r1 = r1.c;
        r4 = ",";
        r1 = r1.split(r4);
        r4 = r1.length;
        r5 = r2;
        r6 = r5;
    L_0x0088:
        if (r5 >= r4) goto L_0x0095;
    L_0x008a:
        r6 = r1[r5];
        r6 = android.text.TextUtils.equals(r10, r6);
        if (r6 != 0) goto L_0x0095;
    L_0x0092:
        r5 = r5 + 1;
        goto L_0x0088;
    L_0x0095:
        if (r6 != 0) goto L_0x0168;
    L_0x0097:
        goto L_0x00a8;
    L_0x0098:
        r4 = r1.c;
        r4 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.c(r4);
        r5 = r1.b;
        r6 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.not_more_than;
        if (r5 != r6) goto L_0x00ab;
    L_0x00a4:
        r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r1 > 0) goto L_0x0168;
    L_0x00a8:
        r6 = r3;
        goto L_0x0169;
    L_0x00ab:
        r5 = r1.b;
        r6 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.not_less_than;
        if (r5 != r6) goto L_0x00b6;
    L_0x00b1:
        r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r1 < 0) goto L_0x0168;
    L_0x00b5:
        goto L_0x00a8;
    L_0x00b6:
        r5 = r1.b;
        r6 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.equal;
        if (r5 != r6) goto L_0x00c1;
    L_0x00bc:
        r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0168;
    L_0x00c0:
        goto L_0x00a8;
    L_0x00c1:
        r1 = r1.b;
        r5 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.no_equal;
        if (r1 != r5) goto L_0x0168;
    L_0x00c7:
        r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x0168;
    L_0x00cb:
        goto L_0x00a8;
    L_0x00cc:
        r4 = "upgradevip";
        r4 = android.text.TextUtils.equals(r4, r10);
        if (r4 != 0) goto L_0x00e7;
    L_0x00d4:
        r4 = "upsupervip";
        r4 = android.text.TextUtils.equals(r4, r10);
        if (r4 != 0) goto L_0x00e7;
    L_0x00dc:
        r4 = "upquickbird";
        r4 = android.text.TextUtils.equals(r4, r10);
        if (r4 == 0) goto L_0x00e5;
    L_0x00e4:
        goto L_0x00e7;
    L_0x00e5:
        r4 = r2;
        goto L_0x00e8;
    L_0x00e7:
        r4 = r3;
    L_0x00e8:
        if (r4 == 0) goto L_0x0168;
    L_0x00ea:
        r4 = r1.c;
        r4 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.d(r4);
        r5 = r1.b;
        r6 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.not_more_than;
        if (r5 != r6) goto L_0x00f9;
    L_0x00f6:
        if (r9 > r4) goto L_0x0168;
    L_0x00f8:
        goto L_0x00a8;
    L_0x00f9:
        r5 = r1.b;
        r6 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.not_less_than;
        if (r5 != r6) goto L_0x0102;
    L_0x00ff:
        if (r9 < r4) goto L_0x0168;
    L_0x0101:
        goto L_0x00a8;
    L_0x0102:
        r5 = r1.b;
        r6 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.equal;
        if (r5 != r6) goto L_0x010b;
    L_0x0108:
        if (r9 != r4) goto L_0x0168;
    L_0x010a:
        goto L_0x00a8;
    L_0x010b:
        r1 = r1.b;
        r5 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.no_equal;
        if (r1 != r5) goto L_0x0168;
    L_0x0111:
        if (r9 == r4) goto L_0x0168;
    L_0x0113:
        goto L_0x00a8;
    L_0x0114:
        r4 = "openvip";
        r4 = android.text.TextUtils.equals(r4, r10);
        if (r4 != 0) goto L_0x0137;
    L_0x011c:
        r4 = "baijin";
        r4 = android.text.TextUtils.equals(r4, r10);
        if (r4 != 0) goto L_0x0137;
    L_0x0124:
        r4 = "supervip";
        r4 = android.text.TextUtils.equals(r4, r10);
        if (r4 != 0) goto L_0x0137;
    L_0x012c:
        r4 = "quickbird";
        r4 = android.text.TextUtils.equals(r4, r10);
        if (r4 == 0) goto L_0x0135;
    L_0x0134:
        goto L_0x0137;
    L_0x0135:
        r4 = r2;
        goto L_0x0138;
    L_0x0137:
        r4 = r3;
    L_0x0138:
        if (r4 == 0) goto L_0x0168;
    L_0x013a:
        r4 = r1.c;
        r4 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.d(r4);
        r5 = r1.b;
        r6 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.not_more_than;
        if (r5 != r6) goto L_0x014a;
    L_0x0146:
        if (r9 > r4) goto L_0x0168;
    L_0x0148:
        goto L_0x00a8;
    L_0x014a:
        r5 = r1.b;
        r6 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.not_less_than;
        if (r5 != r6) goto L_0x0154;
    L_0x0150:
        if (r9 < r4) goto L_0x0168;
    L_0x0152:
        goto L_0x00a8;
    L_0x0154:
        r5 = r1.b;
        r6 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.equal;
        if (r5 != r6) goto L_0x015e;
    L_0x015a:
        if (r9 != r4) goto L_0x0168;
    L_0x015c:
        goto L_0x00a8;
    L_0x015e:
        r1 = r1.b;
        r5 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.no_equal;
        if (r1 != r5) goto L_0x0168;
    L_0x0164:
        if (r9 == r4) goto L_0x0168;
    L_0x0166:
        goto L_0x00a8;
    L_0x0168:
        r6 = r2;
    L_0x0169:
        if (r6 != 0) goto L_0x002a;
    L_0x016b:
        r8 = r2;
        goto L_0x016e;
    L_0x016d:
        r8 = r3;
    L_0x016e:
        if (r8 == 0) goto L_0x0171;
    L_0x0170:
        return r3;
    L_0x0171:
        return r2;
    L_0x0172:
        r9 = r11.a;
        r8 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1));
        if (r8 >= 0) goto L_0x0179;
    L_0x0178:
        return r3;
    L_0x0179:
        return r2;
    L_0x017a:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.voucher.d.a(float, int, java.lang.String, com.xunlei.downloadprovider.member.payment.voucher.Voucher):boolean");
    }

    public final boolean b(String str) {
        return this.c.contains(str);
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c.add(str);
        }
    }

    public final boolean a(float f, int i, String str, List<Voucher> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                for (Voucher a : list) {
                    if (a(f, i, str, a)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public final void a(String str, b bVar) {
        Builder buildUpon = Uri.parse("http://dynamic.vip.xunlei.com/cashv2/userCashInfoV2/").buildUpon();
        buildUpon.appendQueryParameter("cashno", str);
        buildUpon.appendQueryParameter("userid", String.valueOf(LoginHelper.a().g.c()));
        buildUpon.appendQueryParameter("sessionid", LoginHelper.a().c());
        String uri = buildUpon.build().toString();
        a(str);
        new BaseJsonRequest(IMethod.GET, uri).a(null, new i(this, bVar), new j(this, bVar));
    }

    static /* synthetic */ void a(d dVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (!com.xunlei.xllib.b.d.a((Collection) dVar.b.get(str))) {
                j(new h(dVar, str, z));
            }
        }
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar != null) {
            bVar.a(null);
        }
    }
}
