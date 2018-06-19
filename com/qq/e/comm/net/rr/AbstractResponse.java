package com.qq.e.comm.net.rr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

public abstract class AbstractResponse implements Response {
    private final HttpResponse a;
    private final HttpUriRequest b;

    public AbstractResponse(HttpResponse httpResponse, HttpUriRequest httpUriRequest) {
        this.a = httpResponse;
        this.b = httpUriRequest;
    }

    public void close() throws IllegalStateException, IOException {
        if (!(this.b == null || this.b.isAborted())) {
            this.b.abort();
        }
        if (this.a != null) {
            this.a.getEntity().getContent().close();
        }
    }

    public byte[] getBytesContent() throws IllegalStateException, IOException {
        if (200 != getStatusCode()) {
            return null;
        }
        InputStream streamContent = getStreamContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = streamContent.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public int getStatusCode() {
        return this.a.getStatusLine().getStatusCode();
    }

    public InputStream getStreamContent() throws IllegalStateException, IOException {
        InputStream content = this.a.getEntity().getContent();
        Header contentEncoding = this.a.getEntity().getContentEncoding();
        return (contentEncoding == null || !contentEncoding.getValue().contains("gzip")) ? content : new GZIPInputStream(content);
    }

    public String getStringContent() throws IOException {
        return getStringContent("UTF-8");
    }

    public java.lang.String getStringContent(java.lang.String r4) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.getBytesContent();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = r0.length;
        if (r2 != 0) goto L_0x000e;
    L_0x000b:
        r4 = "";
        return r4;
    L_0x000e:
        r2 = r3.a;	 Catch:{ Throwable -> 0x0019 }
        r2 = r2.getEntity();	 Catch:{ Throwable -> 0x0019 }
        r2 = org.apache.http.util.EntityUtils.getContentCharSet(r2);	 Catch:{ Throwable -> 0x0019 }
        r1 = r2;
    L_0x0019:
        if (r1 != 0) goto L_0x001c;
    L_0x001b:
        goto L_0x001d;
    L_0x001c:
        r4 = r1;
    L_0x001d:
        r1 = new java.lang.String;
        r1.<init>(r0, r4);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.net.rr.AbstractResponse.getStringContent(java.lang.String):java.lang.String");
    }
}
