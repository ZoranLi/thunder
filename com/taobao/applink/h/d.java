package com.taobao.applink.h;

import android.content.Context;
import com.taobao.applink.b.a;
import com.taobao.applink.util.TBAppLinkUtil;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class d {
    public CharSequence a = "unkown";
    private CharSequence b = "https://wgo.mmstat.com/ire.2.1";
    private List c = new ArrayList(30);
    private CharSequence d;

    public d(Context context, CharSequence charSequence) {
        try {
            this.d = charSequence;
            this.a = com.taobao.applink.util.d.a(context);
        } catch (Exception e) {
            e.getStackTrace().toString();
        }
    }

    private void a() {
        Throwable th;
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis();
        stringBuffer.append("logtype=2&wappkey=");
        stringBuffer.append(this.d);
        stringBuffer.append("&packagename=");
        stringBuffer.append(a.a(TBAppLinkUtil.getApplication()));
        stringBuffer.append("&os=android&imei=");
        stringBuffer.append(this.a);
        stringBuffer.append("&t=");
        stringBuffer.append(currentTimeMillis);
        stringBuffer.append("&type=");
        if (this.c.size() > 0) {
            stringBuffer.append((CharSequence) this.c.get(0));
        }
        this.c.clear();
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(String.valueOf(this.b)).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setConnectTimeout(ReaderCallback.GET_BAR_ANIMATING);
                httpURLConnection2.setReadTimeout(ReaderCallback.GET_BAR_ANIMATING);
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                outputStream.write(URLEncoder.encode(stringBuffer.toString(), "UTF-8").getBytes());
                outputStream.flush();
                outputStream.close();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("\n");
                    stringBuilder.append(readLine);
                    str = stringBuilder.toString();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            th.getStackTrace().toString();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    public void a(CharSequence charSequence) {
        synchronized (this) {
            this.c.add(charSequence);
        }
    }

    public void b(CharSequence charSequence) {
        synchronized (this) {
            a(charSequence);
            try {
                new Thread(new e(this)).start();
            } catch (Exception e) {
                e.getStackTrace().toString();
            }
        }
    }
}
