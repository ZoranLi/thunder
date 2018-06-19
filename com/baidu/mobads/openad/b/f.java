package com.baidu.mobads.openad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

public class f extends Observable implements IOAdDownloader, Runnable {
    protected Context a;
    protected URL b;
    protected String c;
    protected String d;
    protected int e;
    protected DownloadStatus f;
    protected int g;
    protected int h;
    private boolean i = false;

    @Deprecated
    public void cancel() {
    }

    @Deprecated
    public String getPackageName() {
        return null;
    }

    @Deprecated
    public String getTargetURL() {
        return null;
    }

    @Deprecated
    public String getTitle() {
        return null;
    }

    public boolean isPausedManually() {
        return false;
    }

    @Deprecated
    public void pause() {
    }

    public void removeObservers() {
    }

    @Deprecated
    public void resume() {
    }

    public void setPausedManually(boolean z) {
    }

    public f(Context context, URL url, String str, String str2, boolean z) {
        this.a = context;
        this.b = url;
        this.c = str;
        this.i = z;
        if (str2 == null || str2.trim().length() <= null) {
            context = url.getFile();
            this.d = context.substring(context.lastIndexOf(47) + 1);
        } else {
            this.d = str2;
        }
        this.e = -1;
        this.f = DownloadStatus.DOWNLOADING;
        this.g = 0;
        this.h = 0;
    }

    public void start() {
        a(DownloadStatus.DOWNLOADING);
        b();
    }

    public String getURL() {
        return this.b.toString();
    }

    public int getFileSize() {
        return this.e;
    }

    public float getProgress() {
        return Math.abs((((float) this.g) / ((float) this.e)) * 100.0f);
    }

    public DownloadStatus getState() {
        return this.f;
    }

    protected void a(DownloadStatus downloadStatus) {
        this.f = downloadStatus;
        c();
    }

    protected void b() {
        new Thread(this).start();
    }

    protected void a(int i, float f) {
        this.g += i;
        c();
    }

    protected void c() {
        setChanged();
        notifyObservers();
    }

    public String getOutputPath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(this.d);
        return stringBuilder.toString();
    }

    private void d() {
        a(DownloadStatus.ERROR);
    }

    public void run() {
        Exception e;
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedInputStream bufferedInputStream2;
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) this.b.openConnection();
            try {
                httpURLConnection3.setConnectTimeout(10000);
                httpURLConnection3.setInstanceFollowRedirects(true);
                httpURLConnection3.connect();
                if (httpURLConnection3.getResponseCode() / 100 != 2) {
                    d();
                }
                int contentLength = httpURLConnection3.getContentLength();
                if (contentLength > 0) {
                    this.e = contentLength;
                }
                File file = new File(this.c);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bufferedInputStream2 = new BufferedInputStream(httpURLConnection3.getInputStream());
            } catch (Exception e2) {
                e = e2;
                bufferedInputStream = null;
                httpURLConnection = httpURLConnection3;
                byteArrayOutputStream = bufferedInputStream;
                try {
                    XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e.getMessage());
                    d();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e3) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e3.getMessage());
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e32) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e32.getMessage());
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e322) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e322.getMessage());
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e3222) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().w("OAdSimpleFileDownloader", e3222.getMessage());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e32222) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e32222.getMessage());
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e322222) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e322222.getMessage());
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e3222222) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e3222222.getMessage());
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e32222222) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().w("OAdSimpleFileDownloader", e32222222.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                httpURLConnection = httpURLConnection3;
                byteArrayOutputStream = bufferedInputStream;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getOutputPath());
                stringBuilder.append(".tmp");
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(stringBuilder.toString()));
                try {
                    ByteArrayOutputStream byteArrayOutputStream2;
                    byte[] bArr = new byte[10240];
                    if (this.i) {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                    }
                    int i = 0;
                    while (this.f == DownloadStatus.DOWNLOADING) {
                        int read = bufferedInputStream2.read(bArr, 0, 10240);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        i += read;
                        a(read, ((float) i) / ((float) this.e));
                    }
                    bufferedOutputStream2.flush();
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.flush();
                    }
                    if (this.f == DownloadStatus.DOWNLOADING) {
                        a();
                        a(DownloadStatus.COMPLETED);
                    } else {
                        DownloadStatus downloadStatus = DownloadStatus.ERROR;
                    }
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception e4) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e4.getMessage());
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e322222222) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e322222222.getMessage());
                        }
                    }
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e3222222222) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e3222222222.getMessage());
                        }
                    }
                    if (httpURLConnection3 != null) {
                        try {
                            httpURLConnection3.disconnect();
                        } catch (Exception e32222222222) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().w("OAdSimpleFileDownloader", e32222222222.getMessage());
                        }
                    }
                } catch (Exception e5) {
                    httpURLConnection2 = httpURLConnection3;
                    byteArrayOutputStream = null;
                    bufferedOutputStream = bufferedOutputStream2;
                    bufferedInputStream = bufferedInputStream2;
                    e = e5;
                    httpURLConnection = httpURLConnection2;
                    XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e.getMessage());
                    d();
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th4) {
                    httpURLConnection2 = httpURLConnection3;
                    byteArrayOutputStream = null;
                    bufferedOutputStream = bufferedOutputStream2;
                    bufferedInputStream = bufferedInputStream2;
                    th = th4;
                    httpURLConnection = httpURLConnection2;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e42) {
                httpURLConnection = httpURLConnection3;
                byteArrayOutputStream = null;
                Exception exception = e42;
                bufferedInputStream = bufferedInputStream2;
                e = exception;
                XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e.getMessage());
                d();
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th5) {
                httpURLConnection = httpURLConnection3;
                byteArrayOutputStream = null;
                Throwable th6 = th5;
                bufferedInputStream = bufferedInputStream2;
                th = th6;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            byteArrayOutputStream = null;
            bufferedInputStream = byteArrayOutputStream;
            httpURLConnection = bufferedInputStream;
            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e.getMessage());
            d();
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
            bufferedInputStream = byteArrayOutputStream;
            httpURLConnection = bufferedInputStream;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    protected void a() {
        IXAdIOUtils ioUtils = XAdSDKFoundationFacade.getInstance().getIoUtils();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(this.d);
        stringBuilder.append(".tmp");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.c);
        stringBuilder3.append(this.d);
        ioUtils.renameFile(stringBuilder2, stringBuilder3.toString());
    }
}
