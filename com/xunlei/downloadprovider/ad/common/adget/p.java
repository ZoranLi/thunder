package com.xunlei.downloadprovider.ad.common.adget;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.c.b;
import com.xunlei.downloadprovider.ad.common.adget.c.e;
import com.xunlei.downloadprovider.ad.common.adget.c.g;
import com.xunlei.downloadprovider.ad.common.adget.j.a;
import com.xunlei.downloadprovider.ad.common.c.b$a;
import com.xunlei.downloadprovider.ad.common.h;
import com.xunlei.downloadprovider.ad.common.report.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: PreCacheTask */
final class p implements n<v> {
    THUNDER_AD_INFO a;
    byte b;
    byte c;
    STYLES_INFO d;
    Map<Byte, l> e;
    Map<Byte, Integer> f;
    private v g;
    private String h;
    private byte i;
    private boolean j = true;
    private b$a k = null;
    private a l;

    public p(THUNDER_AD_INFO thunder_ad_info, STYLES_INFO styles_info) {
        this.h = thunder_ad_info.mPositionId;
        this.a = thunder_ad_info;
        this.d = styles_info;
        this.e = new HashMap();
        this.f = new HashMap();
        this.c = (byte) this.d.mLoadStrate;
        this.k = new b$a();
    }

    public final byte a() {
        return this.c;
    }

    final void c() {
        while (this.j && this.g != null) {
            if (this.l == null) {
                this.j = false;
                this.k.a();
                j.a(this.h, this.d.mStyleId, -14, this.k);
                this.g.a(-14, "wtf!");
                return;
            } else if ((this.b & this.i) == this.i) {
                l lVar = (l) this.e.get(Byte.valueOf(this.l.a));
                if (lVar != null) {
                    lVar.w = a(this.l.d);
                    lVar.x = a(this.l.c);
                    lVar.v = this.d;
                    lVar.z = this.l.e;
                    this.k.a();
                    j.a(this.h, this.d.mStyleId, this.k);
                    this.g.a(a(lVar));
                    this.j = false;
                    return;
                }
                this.c = (byte) (this.c ^ this.i);
                if (this.c == (byte) 0) {
                    int intValue = ((Integer) this.f.get(Byte.valueOf(this.l.a))).intValue();
                    this.k.a();
                    j.a(this.h, this.d.mStyleId, intValue, this.k);
                    this.g.a(intValue, "load fail");
                    this.j = false;
                    return;
                }
                this.l.d = null;
                this.l.c = null;
                if ((this.c & 4) != 0) {
                    this.i = (byte) 4;
                } else if ((this.c & 2) != 0) {
                    this.i = (byte) 2;
                } else if ((this.c & 1) != 0) {
                    this.i = (byte) 1;
                }
                this.l.a = this.i;
            } else {
                return;
            }
        }
    }

    public final void a(a aVar, v vVar) {
        this.l = aVar;
        this.i = this.l.a;
        if (this.d == STYLES_INFO.SPLASH_FULL) {
            l gVar = new g(this.h);
            gVar.a = this.l.a == (byte) 1 ? AD_SYSTEM_TYPE.SOURCE_BAIDU_FLAG : AD_SYSTEM_TYPE.SOURCE_GDT_FLAG;
            gVar.w = a(this.l.d);
            gVar.x = a(this.l.c);
            gVar.v = this.d;
            gVar.z = this.l.e;
            vVar.b = false;
            vVar.a(a(gVar));
            return;
        }
        this.g = vVar;
        c();
    }

    private static List<l> a(l lVar) {
        List arrayList = new ArrayList();
        arrayList.add(lVar);
        return arrayList;
    }

    private static ArrayList<String> a(String str) {
        if (str != null) {
            if (!str.trim().equals("")) {
                ArrayList<String> arrayList = new ArrayList();
                arrayList.add(str);
                return arrayList;
            }
        }
        return null;
    }

    public final void b() {
        if (this.d != STYLES_INFO.SPLASH_FULL) {
            if ((this.d.mLoadStrate & 1) == 1) {
                a(new com.xunlei.downloadprovider.ad.common.adget.a.a(com.xunlei.downloadprovider.ad.a.a(), this.d.mBaiduID), this.h, (byte) 1);
                k.b("adv_request", k.a(this.a, this.d, "baidu"));
            }
            if ((this.d.mLoadStrate & 2) == 2) {
                a(new b(com.xunlei.downloadprovider.ad.a.a(), this.d.mGDTID, 3), this.h, (byte) 2);
                k.b("adv_request", k.a(this.a, this.d, SocializeProtocolConstants.PROTOCOL_KEY_TENCENT));
            }
            if ((this.d.mLoadStrate & 4) == 4) {
                a(new e(com.xunlei.downloadprovider.ad.a.a(), this.d.mGDTID, 3), this.h, (byte) 4);
                k.b("adv_request", k.a(this.a, this.d, SocializeProtocolConstants.PROTOCOL_KEY_TENCENT));
            }
            this.k.a = System.currentTimeMillis();
        }
    }

    private void a(h hVar, String str, byte b) {
        if (str == null || str.trim().equals("")) {
            this.b = (byte) (this.b | b);
            this.f.put(Byte.valueOf(b), Integer.valueOf(-12));
        }
        b$a com_xunlei_downloadprovider_ad_common_c_b_a = new b$a();
        com_xunlei_downloadprovider_ad_common_c_b_a.a = System.currentTimeMillis();
        hVar.a(new q(this, b, com_xunlei_downloadprovider_ad_common_c_b_a), str);
    }
}
