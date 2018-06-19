package com.xunlei.downloadprovider.member;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import anet.channel.util.HttpConstant;
import com.umeng.message.util.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: VerifyProtocol */
public final class e {
    private final String a = "DownloadVerifyProcotol";
    private final String b = "http://verify2.xunlei.com/";
    private final String c = "http://verify.xunlei.com/";
    private final String d = "http://verify3.xunlei.com/";
    private final String e = "%simage?cachetime=%s";
    private final String f = "%simage?t=MEA&cachetime=%s";
    private final String g = "%simage?t=SEA&cachetime=%s";
    private final int h = com.tencent.bugly.BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;

    /* compiled from: VerifyProtocol */
    public class a {
        public Bitmap a;
        public String b;
        final /* synthetic */ e c;

        public a(e eVar) {
            this.c = eVar;
        }
    }

    public final a a() {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Exception e;
        Throwable th;
        Exception e2;
        String str = "%simage?t=SEA&cachetime=%s";
        InputStream inputStream2 = null;
        String str2 = null;
        String str3 = str2;
        a aVar = str3;
        while (!"http://verify3.xunlei.com/".equals(str2) && r3 == null) {
            ByteArrayOutputStream byteArrayOutputStream;
            str2 = str2 == null ? "http://verify2.xunlei.com/" : str2.equals("http://verify2.xunlei.com/") ? "http://verify.xunlei.com/" : str2.equals("http://verify.xunlei.com/") ? "http://verify3.xunlei.com/" : "none";
            String format = String.format(str, new Object[]{str2, String.valueOf(System.currentTimeMillis())});
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    httpURLConnection = (HttpURLConnection) new URL(format).openConnection();
                    try {
                        httpURLConnection.setRequestProperty(HttpRequest.HEADER_USER_AGENT, "Mozilla/4.0");
                        httpURLConnection.setRequestProperty(HttpConstant.CONNECTION, "Keep-Alive");
                        httpURLConnection.setRequestProperty("Accept", "*/*");
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(false);
                        httpURLConnection.setConnectTimeout(com.tencent.bugly.BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                        httpURLConnection.setReadTimeout(com.tencent.bugly.BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                        httpURLConnection.setRequestMethod("GET");
                        inputStream = httpURLConnection.getInputStream();
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = null;
                        try {
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e42) {
                                    e42.printStackTrace();
                                }
                            }
                            if (httpURLConnection == null) {
                            }
                            httpURLConnection.disconnect();
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream2 = inputStream;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    inputStream = null;
                    e42 = e2;
                    httpURLConnection = inputStream;
                    e42.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection == null) {
                    }
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection = null;
                }
                try {
                    if (200 == httpURLConnection.getResponseCode()) {
                        Bitmap decodeByteArray;
                        a aVar2 = new a(this);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (-1 == read) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            bArr = byteArrayOutputStream.toByteArray();
                            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        } catch (Exception e6) {
                            e42 = e6;
                            aVar = aVar2;
                            e42.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection == null) {
                            }
                            httpURLConnection.disconnect();
                        }
                        try {
                            aVar2.a = decodeByteArray;
                            Map headerFields = httpURLConnection.getHeaderFields();
                            com.xunlei.downloadprovider.member.register.a.a aVar3 = new com.xunlei.downloadprovider.member.register.a.a();
                            aVar3.a = headerFields;
                            aVar3.a();
                            aVar2.b = (String) aVar3.b.get("VERIFY_KEY");
                            Bitmap bitmap = decodeByteArray;
                            aVar = aVar2;
                        } catch (Exception e7) {
                            e42 = e7;
                            str3 = decodeByteArray;
                            aVar = aVar2;
                            e42.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection == null) {
                            }
                            httpURLConnection.disconnect();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e422) {
                        e422.printStackTrace();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4222) {
                            e4222.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Exception e8) {
                    e4222 = e8;
                    e4222.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection == null) {
                    }
                    httpURLConnection.disconnect();
                }
            } catch (Exception e9) {
                e2 = e9;
                byteArrayOutputStream = null;
                inputStream = byteArrayOutputStream;
                e4222 = e2;
                httpURLConnection = inputStream;
                e4222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection == null) {
                }
                httpURLConnection.disconnect();
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
                byteArrayOutputStream = httpURLConnection;
            }
        }
        return aVar;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        throw th;
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        if (inputStream2 != null) {
            inputStream2.close();
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        throw th;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        throw th;
    }
}
