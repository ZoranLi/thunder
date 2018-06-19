package anet.channel.strategy.dispatch;

/* compiled from: Taobao */
public interface IAmdcSign {
    String getAppkey();

    String sign(String str);

    boolean useSecurityGuard();
}
