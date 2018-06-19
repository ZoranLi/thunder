package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.g;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;

/* compiled from: AdaptedHttpStack */
final class a extends c {
    private final m a;

    a(m mVar) {
        this.a = mVar;
    }

    public final l a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        try {
            request = this.a.b(request, map);
            map = request.getStatusLine().getStatusCode();
            Header[] allHeaders = request.getAllHeaders();
            List arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new g(header.getName(), header.getValue()));
            }
            if (request.getEntity() == null) {
                return new l(map, arrayList);
            }
            long contentLength = request.getEntity().getContentLength();
            if (((long) ((int) contentLength)) == contentLength) {
                return new l(map, arrayList, (int) request.getEntity().getContentLength(), request.getEntity().getContent());
            }
            map = new StringBuilder("Response too large: ");
            map.append(contentLength);
            throw new IOException(map.toString());
        } catch (Request<?> request2) {
            throw new SocketTimeoutException(request2.getMessage());
        }
    }
}
