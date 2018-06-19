package com.xunlei.analytics.config;

public class AnalyticsReportConfigurationBuilder {
    int batchUploadCount = 10;
    long deleteExpirationDayTime = 604800000;
    boolean isWifiOnly = false;
    long reportCheckInterval = 180000;
    int reportRetryCount = 3;
    int reportRule = 0;
    long sessionContinueMillis = 5000;

    public AnalyticsReportConfigurationBuilder batchUploadCount(int i) {
        this.batchUploadCount = i;
        return this;
    }

    public AnalyticsReportConfiguration build() {
        return new AnalyticsReportConfiguration(this);
    }

    public AnalyticsReportConfigurationBuilder deleteExpirationDayTime(int i) {
        this.deleteExpirationDayTime = (long) i;
        return this;
    }

    public AnalyticsReportConfigurationBuilder reportCheckInterval(long j) {
        this.reportCheckInterval = j;
        return this;
    }

    public AnalyticsReportConfigurationBuilder reportRetryCount(int i) {
        this.reportRetryCount = i;
        return this;
    }

    public AnalyticsReportConfigurationBuilder reportRule(int i) {
        this.reportRule = i;
        return this;
    }

    public AnalyticsReportConfigurationBuilder sessionContinueMillis(long j) {
        this.sessionContinueMillis = j;
        return this;
    }

    public AnalyticsReportConfigurationBuilder uploadInWifiOnly(boolean z) {
        this.isWifiOnly = z;
        return this;
    }
}
