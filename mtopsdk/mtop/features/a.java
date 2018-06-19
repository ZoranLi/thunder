package mtopsdk.mtop.features;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;

public final class a {
    private static Map a = new HashMap();

    static {
        a(MtopFeatureManager$MtopFeatureEnum.UNIT_INFO_FEATURE);
        a(MtopFeatureManager$MtopFeatureEnum.SUPPORT_UTDID_UNIT);
        a(MtopFeatureManager$MtopFeatureEnum.DISABLE_X_COMMAND);
    }

    private static void a(MtopFeatureManager$MtopFeatureEnum mtopFeatureManager$MtopFeatureEnum) {
        if (mtopFeatureManager$MtopFeatureEnum != null) {
            a.put(mtopFeatureManager$MtopFeatureEnum, Boolean.valueOf(true));
            if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
                StringBuilder stringBuilder = new StringBuilder("[setMtopFeatureFlag] set feature=");
                stringBuilder.append(mtopFeatureManager$MtopFeatureEnum);
                stringBuilder.append(" , openFlag=true");
                j.b(stringBuilder.toString());
            }
        }
    }

    public static long a() {
        Exception e;
        if (a.isEmpty()) {
            return 0;
        }
        long j;
        try {
            j = 0;
            for (Entry entry : a.entrySet()) {
                try {
                    if (((Boolean) entry.getValue()).booleanValue()) {
                        MtopFeatureManager$MtopFeatureEnum mtopFeatureManager$MtopFeatureEnum = (MtopFeatureManager$MtopFeatureEnum) entry.getKey();
                        j |= mtopFeatureManager$MtopFeatureEnum == null ? 0 : (long) (1 << ((int) (mtopFeatureManager$MtopFeatureEnum.getFeature() - 1)));
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            j = 0;
            StringBuilder stringBuilder = new StringBuilder("[getMtopTotalFeatures] get mtop total features error.---");
            stringBuilder.append(e.toString());
            j.c(stringBuilder.toString());
            return j;
        }
        return j;
    }
}
