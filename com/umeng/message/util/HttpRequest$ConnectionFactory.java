package com.umeng.message.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public interface HttpRequest$ConnectionFactory {
    public static final HttpRequest$ConnectionFactory DEFAULT = new HttpRequest$ConnectionFactory() {
        public final HttpURLConnection create(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }

        public final HttpURLConnection create(URL url, Proxy proxy) throws IOException {
            return (HttpURLConnection) url.openConnection(proxy);
        }
    };

    HttpURLConnection create(URL url) throws IOException;

    HttpURLConnection create(URL url, Proxy proxy) throws IOException;
}
