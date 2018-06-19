package anetwork.channel.cache;

import anet.channel.util.HttpConstant;
import java.util.Map;

/* compiled from: Taobao */
final class g implements h {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final boolean a(Map<String, String> map) {
        return "weex".equals(map.get(HttpConstant.F_REFER));
    }
}
