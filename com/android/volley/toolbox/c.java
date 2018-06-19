package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* compiled from: BaseHttpStack */
public abstract class c implements m {
    public abstract l a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;

    @Deprecated
    public final HttpResponse b(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        request = a(request, map);
        map = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), request.a, ""));
        List arrayList = new ArrayList();
        for (g gVar : Collections.unmodifiableList(request.b)) {
            arrayList.add(new BasicHeader(gVar.a, gVar.b));
        }
        map.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream inputStream = request.d;
        if (inputStream != null) {
            HttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(inputStream);
            basicHttpEntity.setContentLength((long) request.c);
            map.setEntity(basicHttpEntity);
        }
        return map;
    }
}
