package mtopsdk.mtop.unit;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import com.alibaba.fastjson.a;
import java.io.IOException;
import mtopsdk.a.b.c;
import mtopsdk.a.b.e;
import mtopsdk.a.b.g;
import mtopsdk.common.util.f;
import mtopsdk.common.util.i;
import mtopsdk.common.util.j;
import mtopsdk.mtop.a.d;
import mtopsdk.mtop.domain.ProtocolEnum;

public final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    public b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        String str;
        StringBuilder stringBuilder;
        try {
            String str2;
            if (this.a.startsWith(ProtocolEnum.HTTP.getProtocol())) {
                str2 = this.a;
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(ProtocolEnum.HTTP.getProtocol());
                stringBuilder2.append(this.a);
                str2 = stringBuilder2.toString();
            }
            d.a();
            Context b = d.b();
            c a = new c().a(str2);
            a.i = FragmentTransaction.TRANSIT_FRAGMENT_FADE;
            mtopsdk.a.b.b a2 = a.a();
            d.a();
            try {
                e b2 = d.k().a(a2).b();
                if (b2 != null && b2.a == 200) {
                    g gVar = b2.c;
                    if (gVar != null) {
                        try {
                            ApiUnit apiUnit;
                            try {
                                apiUnit = (ApiUnit) a.parseObject(new String(gVar.c(), "utf-8"), ApiUnit.class);
                            } catch (Exception e) {
                                String str3 = this.b;
                                StringBuilder stringBuilder3 = new StringBuilder("[updateAndStoreApiUnitInfo]parse apiUnit json from cdn error ---");
                                stringBuilder3.append(e.toString());
                                j.e(str3, stringBuilder3.toString());
                                apiUnit = null;
                            }
                            if (apiUnit != null && i.a(apiUnit.version)) {
                                d.a();
                                ApiUnit j = d.j();
                                if (j == null || !apiUnit.version.equals(j.version)) {
                                    d.a().a(apiUnit);
                                    f.a(apiUnit, b.getFilesDir(), "UNIT_SETTING_STORE.API_UNIT_ITEM");
                                    str = this.b;
                                    stringBuilder = new StringBuilder("[updateAndStoreApiUnitInfo] update apiUnit succeed.apiUnit=");
                                    stringBuilder.append(apiUnit);
                                    j.b(str, stringBuilder.toString());
                                }
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Exception e32) {
            str = this.b;
            stringBuilder = new StringBuilder("[updateAndStoreApiUnitInfo] generate apiUnit Config URL error.---");
            stringBuilder.append(e32.toString());
            j.e(str, stringBuilder.toString());
        }
    }
}
