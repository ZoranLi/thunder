package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

public final class d extends AsyncTask<Void, Void, a> {
    private static final boolean ae;
    private static final String af;
    private static String ag = "http://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    private String ah;
    private String ai;
    private OAuthListener aj;
    private f ak;
    private String appId;
    private String scope;
    private String signature;

    static class a {
        public OAuthErrCode al;
        public String am;
        public String an;
        public String ao;
        public int ap;
        public String aq;
        public byte[] ar;

        private a() {
        }

        private static boolean a(String str, byte[] bArr) {
            Exception e;
            Throwable th;
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        new StringBuilder("fout.close() exception:").append(e2.getMessage());
                    }
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    try {
                        new StringBuilder("write to file error, exception:").append(e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e22) {
                                new StringBuilder("fout.close() exception:").append(e22.getMessage());
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                new StringBuilder("fout.close() exception:").append(e4.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                new StringBuilder("write to file error, exception:").append(e.getMessage());
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            }
        }

        public static a c(byte[] bArr) {
            String str;
            Object[] objArr;
            OAuthErrCode oAuthErrCode;
            a aVar = new a();
            if (bArr != null) {
                if (bArr.length != 0) {
                    try {
                    } catch (Exception e) {
                        str = "parse fail, build String fail, ex = %s";
                        objArr = new Object[]{e.getMessage()};
                        String.format(str, objArr);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.al = oAuthErrCode;
                        return aVar;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i = jSONObject.getInt("errcode");
                        if (i != 0) {
                            String.format("resp errcode = %d", new Object[]{Integer.valueOf(i)});
                            aVar.al = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.ap = i;
                            aVar.aq = jSONObject.optString("errmsg");
                            return aVar;
                        }
                        str = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (str != null) {
                            if (str.length() != 0) {
                                byte[] decode = Base64.decode(str, 0);
                                if (decode != null) {
                                    if (decode.length != 0) {
                                        if (d.ae) {
                                            File file = new File(d.af);
                                            file.mkdirs();
                                            if (file.exists()) {
                                                file.delete();
                                            }
                                            if (a(d.af, decode)) {
                                                aVar.al = OAuthErrCode.WechatAuth_Err_OK;
                                                aVar.ao = d.af;
                                                aVar.am = jSONObject.getString("uuid");
                                                aVar.an = jSONObject.getString("appname");
                                                String.format("parse succ, save in external storage, uuid = %s, appname = %s, imgPath = %s", new Object[]{aVar.am, aVar.an, aVar.ao});
                                                return aVar;
                                            }
                                            String.format("writeToFile fail, qrcodeBuf length = %d", new Object[]{Integer.valueOf(decode.length)});
                                            aVar.al = OAuthErrCode.WechatAuth_Err_NormalErr;
                                            return aVar;
                                        }
                                        aVar.al = OAuthErrCode.WechatAuth_Err_OK;
                                        aVar.ar = decode;
                                        aVar.am = jSONObject.getString("uuid");
                                        aVar.an = jSONObject.getString("appname");
                                        String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[]{aVar.am, aVar.an, Integer.valueOf(aVar.ar.length)});
                                        return aVar;
                                    }
                                }
                                aVar.al = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                return aVar;
                            }
                        }
                        aVar.al = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    } catch (Exception e2) {
                        str = "parse json fail, ex = %s";
                        objArr = new Object[]{e2.getMessage()};
                        String.format(str, objArr);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.al = oAuthErrCode;
                        return aVar;
                    }
                }
            }
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            aVar.al = oAuthErrCode;
            return aVar;
        }
    }

    static {
        boolean z = Environment.getExternalStorageState().equals("mounted") && new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        ae = z;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        stringBuilder.append("/tencent/MicroMsg/oauth_qrcode.png");
        af = stringBuilder.toString();
    }

    public d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.ah = str3;
        this.ai = str4;
        this.signature = str5;
        this.aj = oAuthListener;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        new StringBuilder("external storage available = ").append(ae);
        String format = String.format(ag, new Object[]{this.appId, this.ah, this.ai, this.scope, this.signature});
        long currentTimeMillis = System.currentTimeMillis();
        byte[] b = e.b(format, -1);
        String.format("doInBackground, url = %s, time consumed = %d(ms)", new Object[]{format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return a.c(b);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        if (aVar.al == OAuthErrCode.WechatAuth_Err_OK) {
            this.aj.onAuthGotQrcode(aVar.ao, aVar.ar);
            this.ak = new f(aVar.am, this.aj);
            f fVar = this.ak;
            if (VERSION.SDK_INT >= 11) {
                fVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else {
                fVar.execute(new Void[0]);
                return;
            }
        }
        String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", new Object[]{aVar.al});
        this.aj.onAuthFinish(aVar.al, null);
    }

    public final boolean q() {
        return this.ak == null ? cancel(true) : this.ak.cancel(true);
    }
}
