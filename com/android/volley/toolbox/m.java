package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;

@Deprecated
/* compiled from: HttpStack */
public interface m {
    HttpResponse b(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;
}
