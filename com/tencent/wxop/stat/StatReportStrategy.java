package com.tencent.wxop.stat;

public enum StatReportStrategy {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    int a;

    private StatReportStrategy(int i) {
        this.a = i;
    }

    public static StatReportStrategy getStatReportStrategy(int i) {
        for (StatReportStrategy statReportStrategy : values()) {
            if (i == statReportStrategy.a()) {
                return statReportStrategy;
            }
        }
        return null;
    }

    public final int a() {
        return this.a;
    }
}
