package com.baidu.mobads.openad.d;

import android.os.Build.VERSION;
import anet.channel.util.HttpConstant;
import com.baidu.mobads.openad.c.c;
import com.baidu.mobads.openad.c.d;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.push.service.av;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class a extends c {
    public static int a = 1024;
    private static final TimeUnit h = TimeUnit.SECONDS;
    private static int i = 5;
    private static BlockingQueue<Runnable> j = new LinkedBlockingQueue();
    private static ThreadPoolExecutor k;
    private String b;
    private AtomicBoolean d;
    private Boolean e;
    private HttpURLConnection f;
    private AtomicBoolean g;

    class a implements Runnable {
        final /* synthetic */ a a;
        private c b;
        private double c;

        public a(a aVar, c cVar, double d) {
            this.a = aVar;
            this.b = cVar;
            this.c = d;
        }

        public void run() {
            InputStream inputStream;
            Throwable th;
            a aVar;
            StringBuilder stringBuilder;
            InputStream inputStream2 = null;
            try {
                if (this.b.c > 0) {
                    Thread.sleep(this.b.c);
                }
                this.a.d.set(true);
                this.a.f = (HttpURLConnection) new URL(this.b.a).openConnection();
                this.a.f.setConnectTimeout((int) this.c);
                this.a.f.setUseCaches(false);
                if (this.b.b != null && this.b.b.length() > 0) {
                    this.a.f.setRequestProperty(HttpRequest.HEADER_USER_AGENT, this.b.b);
                }
                this.a.f.setRequestProperty("Content-type", this.b.d);
                this.a.f.setRequestProperty(HttpConstant.CONNECTION, "keep-alive");
                this.a.f.setRequestProperty("Cache-Control", "no-cache");
                if (Integer.parseInt(VERSION.SDK) < 8) {
                    System.setProperty("http.keepAlive", av.b);
                }
                if (this.b.e == 1) {
                    this.a.f.setRequestMethod("GET");
                    this.a.f.connect();
                    this.a.f.getHeaderFields();
                    if (!this.a.e.booleanValue()) {
                        InputStream inputStream3 = this.a.f.getInputStream();
                        try {
                            this.a.dispatchEvent(new d("URLLoader.Load.Complete", a.b(inputStream3), this.b.a()));
                            inputStream2 = inputStream3;
                        } catch (Throwable th2) {
                            inputStream = inputStream3;
                            th = th2;
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (this.a.f != null) {
                                this.a.f.disconnect();
                            }
                            throw th;
                        }
                    }
                    this.a.f.getResponseCode();
                } else if (this.b.e == 0) {
                    this.a.f.setRequestMethod("POST");
                    this.a.f.setDoInput(true);
                    this.a.f.setDoOutput(true);
                    if (this.b.b() != null) {
                        String encodedQuery = this.b.b().build().getEncodedQuery();
                        OutputStream outputStream = this.a.f.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        bufferedWriter.write(encodedQuery);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                    }
                    this.a.f.connect();
                    this.a.f.getResponseCode();
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th22) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdURLLoader", th22.getMessage());
                    }
                }
                if (this.a.f != null) {
                    try {
                        this.a.f.disconnect();
                    } catch (Throwable th222) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdURLLoader", th222.getMessage());
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (!(this.a.e.booleanValue() || this.a.g.get())) {
                    aVar = this.a;
                    stringBuilder = new StringBuilder("RuntimeError: ");
                    stringBuilder.append(th.toString());
                    aVar.dispatchEvent(new com.baidu.mobads.openad.c.a("URLLoader.Load.Error", stringBuilder.toString()));
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (this.a.f != null) {
                    this.a.f.disconnect();
                }
            }
        }
    }

    static {
        try {
            k = new ThreadPoolExecutor(i, i, 1, h, j);
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    public a(String str) {
        this.d = new AtomicBoolean(false);
        this.e = Boolean.valueOf(false);
        this.g = new AtomicBoolean();
        this.b = str;
    }

    public a() {
        this(null);
    }

    public void a(c cVar, Boolean bool) {
        this.e = bool;
        a(cVar, 20000.0d);
    }

    public void a(c cVar) {
        a(cVar, 20000.0d);
    }

    public void a(com.baidu.mobads.openad.d.c r3, double r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = k;	 Catch:{ Exception -> 0x000b }
        r1 = new com.baidu.mobads.openad.d.a$a;	 Catch:{ Exception -> 0x000b }
        r1.<init>(r2, r3, r4);	 Catch:{ Exception -> 0x000b }
        r0.execute(r1);	 Catch:{ Exception -> 0x000b }
        return;
    L_0x000b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.d.a.a(com.baidu.mobads.openad.d.c, double):void");
    }

    private static String b(InputStream inputStream) {
        String str = "";
        inputStream = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = inputStream.readLine();
            if (readLine == null) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(readLine);
            stringBuilder.append("\n");
            str = stringBuilder.toString();
        }
    }

    public void a() {
        new Thread(new b(this)).start();
    }

    public void dispose() {
        this.g.set(true);
        a();
        super.dispose();
    }
}
