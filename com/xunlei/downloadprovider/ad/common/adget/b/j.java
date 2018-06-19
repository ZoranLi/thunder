package com.xunlei.downloadprovider.ad.common.adget.b;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.c.b;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.adget.n;
import com.xunlei.downloadprovider.ad.common.h;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: MultiCacheTask */
final class j implements n<a> {
    THUNDER_AD_INFO a;
    byte b;
    STYLES_INFO c;
    Map<Byte, List<l>> d;
    Map<Byte, Integer> e;
    private a f;
    private String g;
    private byte h;
    private byte i;
    private boolean j = true;
    private com.xunlei.downloadprovider.ad.common.adget.j.a k;

    public final /* synthetic */ void a(com.xunlei.downloadprovider.ad.common.adget.j.a aVar, Object obj) {
        a aVar2 = (a) obj;
        this.k = aVar;
        this.h = this.k.a;
        this.f = aVar2;
        c();
    }

    public j(THUNDER_AD_INFO thunder_ad_info, STYLES_INFO styles_info) {
        this.g = thunder_ad_info.mPositionId;
        this.a = thunder_ad_info;
        this.c = styles_info;
        this.d = new HashMap();
        this.e = new HashMap();
        this.i = (byte) this.c.mLoadStrate;
    }

    public final byte a() {
        return this.i;
    }

    final void c() {
        while (this.j && this.f != null) {
            if (this.k == null) {
                this.j = false;
                this.f.a(-14, "wtf!");
                return;
            } else if ((this.b & this.h) == this.h) {
                List<l> list = (List) this.d.get(Byte.valueOf(this.k.a));
                if (list != null) {
                    for (l lVar : list) {
                        lVar.w = a(this.k.d);
                        lVar.x = a(this.k.c);
                        lVar.v = this.c;
                        lVar.z = this.k.e;
                        lVar.H = this.k.f;
                    }
                    this.f.a(list);
                    this.j = false;
                    return;
                }
                this.i = (byte) (this.i ^ this.h);
                if (this.i == (byte) 0) {
                    this.f.a(((Integer) this.e.get(Byte.valueOf(this.k.a))).intValue(), "load fail");
                    this.j = false;
                    return;
                }
                this.k.d = null;
                this.k.c = null;
                if ((this.i & 4) != 0) {
                    this.h = (byte) 4;
                } else if ((this.i & 2) != 0) {
                    this.h = (byte) 2;
                } else if ((this.i & 1) != 0) {
                    this.h = (byte) 1;
                }
                this.k.a = this.h;
            } else {
                return;
            }
        }
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
        if ((this.c.mLoadStrate & 1) == 1) {
            a(new com.xunlei.downloadprovider.ad.common.adget.a.a(com.xunlei.downloadprovider.ad.a.a(), this.c.mBaiduID), this.g, (byte) 1);
            k.b("adv_request", k.a(this.a, this.c, "baidu"));
        }
        if ((this.c.mLoadStrate & 2) == 2) {
            a(new b(com.xunlei.downloadprovider.ad.a.a(), this.c.mGDTID, 3), this.g, (byte) 2);
            k.b("adv_request", k.a(this.a, this.c, SocializeProtocolConstants.PROTOCOL_KEY_TENCENT));
        }
    }

    private void a(h hVar, String str, byte b) {
        if (str == null || str.trim().equals("")) {
            this.b = (byte) (this.b | b);
            this.e.put(Byte.valueOf(b), Integer.valueOf(-12));
        }
        com.xunlei.downloadprovider.ad.common.c.b.a aVar = new com.xunlei.downloadprovider.ad.common.c.b.a();
        aVar.a = System.currentTimeMillis();
        hVar.a(new k(this, b, aVar), str);
    }
}
