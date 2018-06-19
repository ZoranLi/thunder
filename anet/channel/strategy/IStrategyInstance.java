package anet.channel.strategy;

import android.content.Context;
import java.util.List;

/* compiled from: Taobao */
public interface IStrategyInstance {
    void forceRefreshStrategy(String str);

    String getCNameByHost(String str);

    String getClientIp();

    List<IConnStrategy> getConnStrategyListByHost(String str);

    String getFormalizeUrl(String str);

    @Deprecated
    String getFormalizeUrl(String str, String str2);

    @Deprecated
    String getSchemeByHost(String str);

    String getSchemeByHost(String str, String str2);

    String getUnitPrefix(String str, String str2);

    void initialize(Context context);

    void notifyConnEvent(String str, IConnStrategy iConnStrategy, ConnEvent connEvent);

    void registerListener(IStrategyListener iStrategyListener);

    void saveData();

    void setUnitPrefix(String str, String str2, String str3);

    void switchEnv();

    void unregisterListener(IStrategyListener iStrategyListener);
}
