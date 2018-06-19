package anet.channel.appmonitor;

/* compiled from: Taobao */
public class AppMonitor {
    private static volatile IAppMonitor appMonitor = new b();

    public static IAppMonitor getInstance() {
        return appMonitor;
    }

    public static void setInstance(IAppMonitor iAppMonitor) {
        appMonitor = new a(iAppMonitor);
    }
}
