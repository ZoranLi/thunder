package mtopsdk.mtop.common;

import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;

public class b implements e, f, g {
    public void onHeader(j jVar, Object obj) {
        if (jVar != null && j.a(TBSdkLog$LogEnable.DebugEnable)) {
            StringBuilder stringBuilder = new StringBuilder("[onHeader]");
            stringBuilder.append(jVar.toString());
            j.a(stringBuilder.toString());
        }
    }

    public void onFinished(i iVar, Object obj) {
        if (iVar != null && iVar.a != null && j.a(TBSdkLog$LogEnable.DebugEnable) != null) {
            obj = new StringBuilder("[onFinished]");
            obj.append(iVar.a.toString());
            j.a(obj.toString());
        }
    }
}
