package com.bumptech.glide.integration.volley;

import com.android.volley.Request;
import com.android.volley.Request.Priority;
import java.io.InputStream;
import java.util.Map;

public interface VolleyRequestFactory {
    Request<byte[]> create(String str, VolleyRequestFuture<InputStream> volleyRequestFuture, Priority priority, Map<String, String> map);
}
