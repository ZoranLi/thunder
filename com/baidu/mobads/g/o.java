package com.baidu.mobads.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build.VERSION;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class o implements Observer {
    private Context a;
    private URL b = null;
    private String c = null;
    private final e d;
    private a e;
    private SharedPreferences f;
    private OnSharedPreferenceChangeListener g = new p(this);

    public interface a {
        void a(e eVar);

        void b(e eVar);
    }

    public o(Context context, URL url, e eVar, a aVar) {
        this.b = url;
        this.d = eVar;
        a(context, aVar);
    }

    public o(Context context, String str, e eVar, a aVar) {
        this.c = str;
        this.d = eVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.a = context;
        this.e = aVar;
        this.f = this.a.getSharedPreferences("__xadsdk_downloaded__version__", 0);
        this.f.registerOnSharedPreferenceChangeListener(this.g);
    }

    public void a(String str, String str2) {
        str = XAdSDKFoundationFacade.getInstance().getDownloaderManager(this.a).createSimpleFileDownloader(this.c != null ? new URL(this.c) : this.b, str, str2, false);
        str.addObserver(this);
        str.start();
        str = this.f.edit();
        str.putString("version", this.d.toString());
        if (VERSION.SDK_INT >= 9) {
            str.apply();
        } else {
            str.commit();
        }
    }

    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        if (iOAdDownloader.getState() == DownloadStatus.COMPLETED) {
            this.e.a(new e(this.d, iOAdDownloader.getOutputPath(), Boolean.valueOf(true)));
        }
        if (iOAdDownloader.getState() == DownloadStatus.ERROR) {
            this.e.b(new e(this.d, iOAdDownloader.getOutputPath(), Boolean.valueOf(false)));
        }
    }
}
