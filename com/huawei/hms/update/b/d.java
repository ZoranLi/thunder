package com.huawei.hms.update.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: IHttpRequestHelper */
public interface d {
    int a(String str, InputStream inputStream, OutputStream outputStream) throws IOException, a;

    int a(String str, OutputStream outputStream) throws IOException, a;

    int a(String str, OutputStream outputStream, int i, int i2) throws IOException, a;

    void a();

    void b();
}
