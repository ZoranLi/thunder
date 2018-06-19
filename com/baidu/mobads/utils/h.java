package com.baidu.mobads.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.openad.b.d;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import java.io.File;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class h {
    private static long a = 30000000;
    private Context b;

    class a implements Observer {
        final /* synthetic */ h a;
        private final Handler b;
        private final String c;
        private long d = System.currentTimeMillis();

        public a(h hVar, Handler handler, String str) {
            this.a = hVar;
            this.b = handler;
            this.c = str;
        }

        public void update(Observable observable, Object obj) {
            IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
            long currentTimeMillis = System.currentTimeMillis() - this.d;
            if (iOAdDownloader.getState() == DownloadStatus.COMPLETED) {
                this.a.c(iOAdDownloader.getOutputPath());
                this.a.a(this.b, iOAdDownloader.getOutputPath(), currentTimeMillis);
                this.a.a(this.c);
            }
            if (iOAdDownloader.getState() == DownloadStatus.ERROR) {
                this.a.a(this.b, Boolean.valueOf(null), null, currentTimeMillis);
                this.a.a(this.b, currentTimeMillis);
                this.a.a(this.c);
            }
        }
    }

    public h(Context context) {
        this.b = context;
    }

    public static void a(int i) {
        a = (long) ((i * 1000) * 1000);
    }

    public void a(String str) {
        new Thread(new i(this, str)).start();
    }

    public static String a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getFilesDir().getPath());
        stringBuilder.append(File.separator);
        stringBuilder.append("__bidu_cache_dir");
        stringBuilder.append(File.separator);
        return stringBuilder.toString();
    }

    public static String b(String str) {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(str);
    }

    public static String a(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("ad_360_unzip");
        File file = new File(b(context, stringBuilder.toString()));
        if (file.exists() == null) {
            file.mkdirs();
        }
        if (file.listFiles() != null && file.listFiles().length > null) {
            for (File delete : file.listFiles()) {
                delete.delete();
            }
        }
        return file.getAbsolutePath();
    }

    public static String b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(context));
        stringBuilder.append(b(str));
        return stringBuilder.toString();
    }

    public void a(Context context, String str, String str2, String str3, Handler handler) {
        try {
            File file = new File(b(context, str));
            if (file.exists() == null) {
                a(handler, false);
                context = d.a(this.b).createSimpleFileDownloader(new URL(str), str2, str3, false);
                context.addObserver(new a(this, handler, str2));
                context.start();
                return;
            }
            a(handler, true);
            a(handler, file.getAbsolutePath(), -1);
            file.setLastModified(System.currentTimeMillis());
        } catch (Context context2) {
            context2.printStackTrace();
            a(handler, -1);
        }
    }

    private void a(Handler handler, String str, long j) {
        a(handler, Boolean.valueOf(true), str, j);
    }

    private void a(Handler handler, long j) {
        a(handler, Boolean.valueOf(false), null, j);
    }

    private void a(Handler handler, boolean z) {
        try {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 1;
            Bundle bundle = new Bundle();
            bundle.putBoolean("caching_file_exist", z);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        } catch (Throwable e) {
            l.a().d(e);
        }
    }

    private void a(Handler handler, Boolean bool, String str, long j) {
        try {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("caching_result", bool.booleanValue());
            bundle.putLong("caching_time_consume", j);
            bundle.putString("local_creative_url", str);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        } catch (Throwable e) {
            l.a().d(e);
        }
    }

    public void c(String str) {
        try {
            File file = new File(str);
            if (file.exists() != null) {
                file.setLastModified(System.currentTimeMillis());
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
    }
}
