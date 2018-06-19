package com.xunlei.downloadprovider.ad.splash.downloader;

public class RetryError extends Exception {
    public RetryError() {
        super("Maximum retry exceeded");
    }

    public RetryError(Throwable th) {
        super(th);
    }
}
