package anet.channel.util;

import anet.channel.request.Request;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class e {
    private static Map<String, Integer> a;

    static {
        Map hashMap = new HashMap();
        a = hashMap;
        hashMap.put(ShareConstants.DEXMODE_JAR, Integer.valueOf(2));
        a.put("json", Integer.valueOf(3));
        a.put("html", Integer.valueOf(4));
        a.put("htm", Integer.valueOf(4));
        a.put("css", Integer.valueOf(5));
        a.put("js", Integer.valueOf(5));
        a.put("webp", Integer.valueOf(6));
        a.put("png", Integer.valueOf(6));
        a.put("jpg", Integer.valueOf(6));
        a.put("do", Integer.valueOf(6));
        a.put("zip", Integer.valueOf(9));
        a.put("bin", Integer.valueOf(9));
    }

    public static int a(Request request) {
        if (request == null) {
            throw new NullPointerException("url is null!");
        } else if (request.getHeaders().containsKey(HttpConstant.X_PV)) {
            return 1;
        } else {
            request = a.a(request.getHttpUrl().c());
            if (request == null) {
                return 6;
            }
            Integer num = (Integer) a.get(request);
            if (num != null) {
                return num.intValue();
            }
            return 6;
        }
    }
}
