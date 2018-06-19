package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.a.f;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ProGuard */
public class b {
    private static String c;
    private String a;
    private c b;
    private long d;
    private Handler e;
    private Runnable f = new Runnable(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void run() {
            f.a("AsynLoadImg", "saveFileRunnable:");
            String f = i.f(this.a.a);
            StringBuilder stringBuilder = new StringBuilder("share_qq_");
            stringBuilder.append(f);
            stringBuilder.append(".jpg");
            f = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(b.c);
            stringBuilder.append(f);
            String stringBuilder2 = stringBuilder.toString();
            File file = new File(stringBuilder2);
            Message obtainMessage = this.a.e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = stringBuilder2;
                stringBuilder = new StringBuilder("file exists: time:");
                stringBuilder.append(System.currentTimeMillis() - this.a.d);
                f.a("AsynLoadImg", stringBuilder.toString());
            } else {
                boolean a;
                Bitmap a2 = b.a(this.a.a);
                if (a2 != null) {
                    a = this.a.a(a2, f);
                } else {
                    f.a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    a = false;
                }
                if (a) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = stringBuilder2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                stringBuilder = new StringBuilder("file not exists: download time:");
                stringBuilder.append(System.currentTimeMillis() - this.a.d);
                f.a("AsynLoadImg", stringBuilder.toString());
            }
            this.a.e.sendMessage(obtainMessage);
        }
    };

    public b(Activity activity) {
        this.e = new Handler(this, activity.getMainLooper()) {
            final /* synthetic */ b a;

            public void handleMessage(Message message) {
                StringBuilder stringBuilder = new StringBuilder("handleMessage:");
                stringBuilder.append(message.arg1);
                f.a("AsynLoadImg", stringBuilder.toString());
                if (message.arg1 == 0) {
                    this.a.b.a(message.arg1, (String) message.obj);
                } else {
                    this.a.b.a(message.arg1, null);
                }
            }
        };
    }

    public void a(String str, c cVar) {
        f.a("AsynLoadImg", "--save---");
        if (str != null) {
            if (!str.equals("")) {
                if (i.b()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Environment.getExternalStorageDirectory());
                    stringBuilder.append("/tmp/");
                    c = stringBuilder.toString();
                    this.d = System.currentTimeMillis();
                    this.a = str;
                    this.b = cVar;
                    new Thread(this.f).start();
                    return;
                }
                cVar.a(2, null);
                return;
            }
        }
        cVar.a(1, null);
    }

    public boolean a(Bitmap bitmap, String str) {
        String str2 = c;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdir();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(str);
            str2 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder("saveFile:");
            stringBuilder2.append(str);
            f.a("AsynLoadImg", stringBuilder2.toString());
            OutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2)));
            try {
                bitmap.compress(CompressFormat.JPEG, 80, bufferedOutputStream2);
                bufferedOutputStream2.flush();
                try {
                    bufferedOutputStream2.close();
                } catch (Bitmap bitmap2) {
                    bitmap2.printStackTrace();
                }
                return true;
            } catch (IOException e) {
                bitmap2 = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    bitmap2.printStackTrace();
                    f.b("AsynLoadImg", "saveFile bmp fail---", bitmap2);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Bitmap bitmap22) {
                            bitmap22.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    bitmap22 = th;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (String str3) {
                            str3.printStackTrace();
                        }
                    }
                    throw bitmap22;
                }
            } catch (Throwable th2) {
                bitmap22 = th2;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw bitmap22;
            }
        } catch (IOException e2) {
            bitmap22 = e2;
            bitmap22.printStackTrace();
            f.b("AsynLoadImg", "saveFile bmp fail---", bitmap22);
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            return null;
        }
    }

    public static Bitmap a(String str) {
        StringBuilder stringBuilder = new StringBuilder("getbitmap:");
        stringBuilder.append(str);
        f.a("AsynLoadImg", stringBuilder.toString());
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            StringBuilder stringBuilder2 = new StringBuilder("image download finished.");
            stringBuilder2.append(str);
            f.a("AsynLoadImg", stringBuilder2.toString());
            return decodeStream;
        } catch (String str2) {
            str2.printStackTrace();
            f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (String str22) {
            str22.printStackTrace();
            f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
