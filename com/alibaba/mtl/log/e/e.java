package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.umeng.message.util.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/* compiled from: HttpUtils */
public final class e {

    /* compiled from: HttpUtils */
    public static class a {
        public int a = -1;
        public byte[] b = null;
    }

    static {
        System.setProperty("http.keepAlive", "true");
    }

    public static a a(int i, String str, Map<String, Object> map) {
        InputStream dataInputStream;
        IOException iOException;
        Throwable th;
        Throwable th2;
        DataOutputStream dataOutputStream;
        Exception exception;
        int i2 = i;
        Map<String, Object> map2 = map;
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection != null) {
                byte[] bArr;
                DataOutputStream dataOutputStream2;
                ByteArrayOutputStream byteArrayOutputStream;
                byte[] bArr2;
                int read;
                int i3 = 3;
                if (i2 == 2 || i2 == 3) {
                    httpURLConnection.setDoOutput(true);
                }
                httpURLConnection.setDoInput(true);
                if (i2 != 2) {
                    if (i2 != 3) {
                        try {
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setUseCaches(false);
                            httpURLConnection.setConnectTimeout(10000);
                            httpURLConnection.setReadTimeout(60000);
                            httpURLConnection.setRequestProperty(HttpConstant.CONNECTION, "close");
                            httpURLConnection.setInstanceFollowRedirects(true);
                            if (i2 != 2) {
                                if (i2 == 3) {
                                    bArr = null;
                                    httpURLConnection.connect();
                                    if ((i2 != 2 || i2 == 3) && bArr != null && bArr.length > 0) {
                                        dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                                        dataOutputStream2.write(bArr);
                                        dataOutputStream2.flush();
                                    } else {
                                        dataOutputStream2 = null;
                                    }
                                    if (dataOutputStream2 != null) {
                                        try {
                                            dataOutputStream2.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    aVar.a = httpURLConnection.getResponseCode();
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                                    try {
                                        System.currentTimeMillis();
                                        bArr2 = new byte[2048];
                                        while (true) {
                                            read = dataInputStream.read(bArr2, 0, 2048);
                                            if (read != -1) {
                                                byteArrayOutputStream.write(bArr2, 0, read);
                                            } else {
                                                try {
                                                    break;
                                                } catch (Exception e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                        }
                                        dataInputStream.close();
                                        if (byteArrayOutputStream.size() > 0) {
                                            aVar.b = byteArrayOutputStream.toByteArray();
                                        }
                                    } catch (IOException e3) {
                                        iOException = e3;
                                        try {
                                            iOException.printStackTrace();
                                            if (dataInputStream != null) {
                                                try {
                                                    dataInputStream.close();
                                                } catch (Exception e22) {
                                                    e22.printStackTrace();
                                                }
                                            }
                                            return aVar;
                                        } catch (Throwable th22) {
                                            th = th22;
                                            if (dataInputStream != null) {
                                                try {
                                                    dataInputStream.close();
                                                } catch (Exception e222) {
                                                    e222.printStackTrace();
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            }
                            if (i2 == 2) {
                                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=GJircTeP");
                            } else if (i2 == 3) {
                                httpURLConnection.setRequestProperty("Content-Type", HttpRequest.CONTENT_TYPE_FORM);
                            }
                            if (map2 != null || map.size() <= 0) {
                                bArr = null;
                            } else {
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                Set keySet = map.keySet();
                                String[] strArr = new String[keySet.size()];
                                keySet.toArray(strArr);
                                String[] a = g.a().a(strArr);
                                int length = a.length;
                                int i4 = 0;
                                while (i4 < length) {
                                    String str2 = a[i4];
                                    if (i2 == 2) {
                                        byte[] bArr3 = (byte[]) map2.get(str2);
                                        if (bArr3 != null) {
                                            try {
                                                byteArrayOutputStream2.write(String.format("--GJircTeP\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream \r\n\r\n", new Object[]{str2, str2}).getBytes());
                                                byteArrayOutputStream2.write(bArr3);
                                                byteArrayOutputStream2.write("\r\n".getBytes());
                                            } catch (IOException e32) {
                                                e32.printStackTrace();
                                            }
                                        }
                                    } else if (i2 == i3) {
                                        String str3 = (String) map2.get(str2);
                                        StringBuilder stringBuilder;
                                        if (byteArrayOutputStream2.size() > 0) {
                                            try {
                                                stringBuilder = new StringBuilder("&");
                                                stringBuilder.append(str2);
                                                stringBuilder.append("=");
                                                stringBuilder.append(str3);
                                                byteArrayOutputStream2.write(stringBuilder.toString().getBytes());
                                            } catch (IOException e322) {
                                                e322.printStackTrace();
                                            }
                                        } else {
                                            try {
                                                stringBuilder = new StringBuilder();
                                                stringBuilder.append(str2);
                                                stringBuilder.append("=");
                                                stringBuilder.append(str3);
                                                byteArrayOutputStream2.write(stringBuilder.toString().getBytes());
                                            } catch (IOException e3222) {
                                                e3222.printStackTrace();
                                            }
                                        }
                                    }
                                    i4++;
                                    i3 = 3;
                                }
                                if (i2 == 2) {
                                    try {
                                        byteArrayOutputStream2.write("--GJircTeP--\r\n".getBytes());
                                    } catch (IOException e32222) {
                                        e32222.printStackTrace();
                                    }
                                }
                                bArr = byteArrayOutputStream2.toByteArray();
                            }
                            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr == null ? bArr.length : 0));
                            httpURLConnection.connect();
                            if (i2 != 2) {
                            }
                            dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                            try {
                                dataOutputStream2.write(bArr);
                                dataOutputStream2.flush();
                                if (dataOutputStream2 != null) {
                                    dataOutputStream2.close();
                                }
                                try {
                                    aVar.a = httpURLConnection.getResponseCode();
                                } catch (IOException e322222) {
                                    e322222.printStackTrace();
                                }
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                                    System.currentTimeMillis();
                                    bArr2 = new byte[2048];
                                    while (true) {
                                        read = dataInputStream.read(bArr2, 0, 2048);
                                        if (read != -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr2, 0, read);
                                    }
                                    dataInputStream.close();
                                    if (byteArrayOutputStream.size() > 0) {
                                        aVar.b = byteArrayOutputStream.toByteArray();
                                    }
                                } catch (IOException e3222222) {
                                    iOException = e3222222;
                                    dataInputStream = null;
                                    iOException.printStackTrace();
                                    if (dataInputStream != null) {
                                        dataInputStream.close();
                                    }
                                    return aVar;
                                } catch (Throwable th222) {
                                    th = th222;
                                    dataInputStream = null;
                                    if (dataInputStream != null) {
                                        dataInputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e2222) {
                                dataOutputStream = dataOutputStream2;
                                exception = e2222;
                                try {
                                    exception.printStackTrace();
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (IOException e32222222) {
                                            e32222222.printStackTrace();
                                        }
                                    }
                                    return aVar;
                                } catch (Throwable th3) {
                                    th222 = th3;
                                    th = th222;
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (IOException e322222222) {
                                            e322222222.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th222 = th4;
                                dataOutputStream = dataOutputStream2;
                                th = th222;
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (ProtocolException e4) {
                            e4.printStackTrace();
                            return aVar;
                        }
                    }
                }
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setRequestProperty(HttpConstant.CONNECTION, "close");
                httpURLConnection.setInstanceFollowRedirects(true);
                if (i2 != 2) {
                    if (i2 == 3) {
                        bArr = null;
                        httpURLConnection.connect();
                        if (i2 != 2) {
                        }
                        dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                        dataOutputStream2.write(bArr);
                        dataOutputStream2.flush();
                        if (dataOutputStream2 != null) {
                            dataOutputStream2.close();
                        }
                        aVar.a = httpURLConnection.getResponseCode();
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                        System.currentTimeMillis();
                        bArr2 = new byte[2048];
                        while (true) {
                            read = dataInputStream.read(bArr2, 0, 2048);
                            if (read != -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                        dataInputStream.close();
                        if (byteArrayOutputStream.size() > 0) {
                            aVar.b = byteArrayOutputStream.toByteArray();
                        }
                    }
                }
                if (i2 == 2) {
                    httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=GJircTeP");
                } else if (i2 == 3) {
                    httpURLConnection.setRequestProperty("Content-Type", HttpRequest.CONTENT_TYPE_FORM);
                }
                if (map2 != null) {
                }
                bArr = null;
                if (bArr == null) {
                }
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr == null ? bArr.length : 0));
                try {
                    httpURLConnection.connect();
                    if (i2 != 2) {
                    }
                    dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream2.write(bArr);
                    dataOutputStream2.flush();
                    if (dataOutputStream2 != null) {
                        dataOutputStream2.close();
                    }
                    aVar.a = httpURLConnection.getResponseCode();
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                    System.currentTimeMillis();
                    bArr2 = new byte[2048];
                    while (true) {
                        read = dataInputStream.read(bArr2, 0, 2048);
                        if (read != -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    dataInputStream.close();
                    if (byteArrayOutputStream.size() > 0) {
                        aVar.b = byteArrayOutputStream.toByteArray();
                    }
                } catch (Exception e22222) {
                    exception = e22222;
                    dataOutputStream = null;
                    exception.printStackTrace();
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    return aVar;
                } catch (Throwable th2222) {
                    th = th2222;
                    dataOutputStream = null;
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    throw th;
                }
            }
            return aVar;
        } catch (MalformedURLException e5) {
            e5.printStackTrace();
            return aVar;
        } catch (IOException e3222222222) {
            e3222222222.printStackTrace();
            return aVar;
        }
    }
}
