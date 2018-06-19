package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MultipartRequestParams */
public final class ak {
    protected ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
    protected ConcurrentHashMap<String, a> b = new ConcurrentHashMap();

    /* compiled from: MultipartRequestParams */
    private static class a {
        public InputStream a;
        public String b;
        public String c = null;

        public a(InputStream inputStream, String str) {
            this.a = inputStream;
            this.b = str;
        }

        public final String a() {
            return this.b != null ? this.b : "nofilename";
        }
    }

    public final void a(String str, int i) {
        a(str, String.valueOf(i));
    }

    public final void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.a.put(str, str2);
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : this.a.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public final ah b() {
        ah ajVar = new aj();
        if (!this.a.isEmpty()) {
            for (Entry entry : this.a.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                ajVar.b();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = ajVar.b;
                    StringBuilder stringBuilder = new StringBuilder("Content-Disposition: form-data; name=\"");
                    stringBuilder.append(str);
                    stringBuilder.append("\"\r\n\r\n");
                    byteArrayOutputStream.write(stringBuilder.toString().getBytes());
                    ajVar.b.write(str2.getBytes());
                    ByteArrayOutputStream byteArrayOutputStream2 = ajVar.b;
                    StringBuilder stringBuilder2 = new StringBuilder("\r\n--");
                    stringBuilder2.append(ajVar.a);
                    stringBuilder2.append("\r\n");
                    byteArrayOutputStream2.write(stringBuilder2.toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!this.b.isEmpty()) {
            int size = this.b.entrySet().size() - 1;
            int i = 0;
            for (Entry entry2 : this.b.entrySet()) {
                a aVar = (a) entry2.getValue();
                if (aVar.a != null) {
                    boolean z = i == size;
                    if (aVar.c != null) {
                        ajVar.a((String) entry2.getKey(), aVar.a(), aVar.a, aVar.c, z);
                    } else {
                        ajVar.a((String) entry2.getKey(), aVar.a(), aVar.a, z);
                    }
                }
                i++;
            }
        }
        return ajVar;
    }

    public final void a(String str, File file) {
        try {
            InputStream fileInputStream = new FileInputStream(file);
            file = file.getName();
            if (str != null) {
                this.b.put(str, new a(fileInputStream, file));
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
    }
}
