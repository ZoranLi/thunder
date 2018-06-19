package com.duiba.maila.sdk.a;

import android.os.AsyncTask;
import com.duiba.maila.sdk.a.b.a;
import com.duiba.maila.sdk.util.f;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.umeng.message.util.HttpRequest;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class e extends AsyncTask<d, Void, Object> {
    d a;

    protected final void onCancelled(Object obj) {
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((d[]) objArr);
    }

    private Object a(d... dVarArr) {
        this.a = dVarArr[0];
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a.a()).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(ReaderCallback.GET_BAR_ANIMATING);
            httpURLConnection.setConnectTimeout(ReaderCallback.GET_BAR_ANIMATING);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", HttpRequest.CONTENT_TYPE_JSON);
            if (this.a instanceof a) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(this.a.b().getBytes());
                outputStream.flush();
                outputStream.close();
            }
            if (httpURLConnection.getResponseCode() == 200) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                dVarArr = new StringBuilder();
                byte[] bArr = new byte[8192];
                do {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        dVarArr.append(new String(bArr, 0, read, "UTF-8"));
                    } else if (this.a instanceof a) {
                        a aVar = new a();
                        return a.a(dVarArr.toString());
                    }
                } while (!isCancelled());
                return null;
            }
            return null;
        } catch (d[] dVarArr2) {
            dVarArr2.printStackTrace();
            return dVarArr2;
        }
    }

    protected final void onPostExecute(Object obj) {
        if ((obj instanceof b) != null) {
            a aVar = (a) this.a;
            String str = aVar.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            f.a(str, stringBuilder.toString());
            obj = aVar.a;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(System.currentTimeMillis());
            f.b(obj, stringBuilder2.toString());
        }
    }
}
