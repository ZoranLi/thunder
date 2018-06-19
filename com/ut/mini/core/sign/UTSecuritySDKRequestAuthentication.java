package com.ut.mini.core.sign;

import android.content.Context;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.e.i;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class UTSecuritySDKRequestAuthentication implements IUTRequestAuthentication {
    private boolean D = false;
    private String Z;
    private Class a = null;
    private Field f9a = null;
    private Method f10a = null;
    private Object b = null;
    private String f11b = null;
    private Field f12b = null;
    private Object c = null;
    private Field f13c = null;
    private int z = 1;

    public String getAppkey() {
        return this.f11b;
    }

    public UTSecuritySDKRequestAuthentication(String str, String str2) {
        this.f11b = str;
        this.Z = str2;
    }

    private synchronized void F() {
        Class cls;
        Throwable th;
        Method method;
        boolean z;
        if (!this.D) {
            Object obj = null;
            try {
                cls = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
                try {
                    this.b = cls.getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{b.a().a});
                    this.c = cls.getMethod("getSecureSignatureComp", new Class[0]).invoke(this.b, new Object[0]);
                } catch (Throwable th2) {
                    th = th2;
                    i.b("initSecurityCheck", th.getMessage());
                    if (cls != null) {
                        try {
                            this.a = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
                            this.f9a = this.a.getDeclaredField("appKey");
                            this.f12b = this.a.getDeclaredField("paramMap");
                            this.f13c = this.a.getDeclaredField("requestType");
                            method = cls.getMethod("isOpen", new Class[0]);
                        } catch (Throwable th3) {
                            i.b("initSecurityCheck", th3.getMessage());
                        }
                        if (method != null) {
                            try {
                                obj = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                            } catch (Throwable th4) {
                                i.b("initSecurityCheck", th4.getMessage());
                            }
                            z = obj != null;
                        } else {
                            z = ((Boolean) method.invoke(this.b, new Object[0])).booleanValue();
                        }
                        this.z = z ? 12 : 1;
                        this.f10a = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", new Class[]{this.a, String.class});
                    }
                    this.D = true;
                }
            } catch (Throwable th5) {
                th = th5;
                cls = null;
                i.b("initSecurityCheck", th.getMessage());
                if (cls != null) {
                    this.a = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
                    this.f9a = this.a.getDeclaredField("appKey");
                    this.f12b = this.a.getDeclaredField("paramMap");
                    this.f13c = this.a.getDeclaredField("requestType");
                    method = cls.getMethod("isOpen", new Class[0]);
                    if (method != null) {
                        z = ((Boolean) method.invoke(this.b, new Object[0])).booleanValue();
                    } else {
                        obj = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                        if (obj != null) {
                        }
                    }
                    if (z) {
                    }
                    this.z = z ? 12 : 1;
                    this.f10a = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", new Class[]{this.a, String.class});
                }
                this.D = true;
            }
            if (cls != null) {
                this.a = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
                this.f9a = this.a.getDeclaredField("appKey");
                this.f12b = this.a.getDeclaredField("paramMap");
                this.f13c = this.a.getDeclaredField("requestType");
                method = cls.getMethod("isOpen", new Class[0]);
                if (method != null) {
                    z = ((Boolean) method.invoke(this.b, new Object[0])).booleanValue();
                } else {
                    obj = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                    if (obj != null) {
                    }
                }
                if (z) {
                }
                this.z = z ? 12 : 1;
                this.f10a = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", new Class[]{this.a, String.class});
            }
            this.D = true;
        }
    }

    public String getSign(String str) {
        if (!this.D) {
            F();
        }
        if (this.f11b == null) {
            i.b("UTSecuritySDKRequestAuthentication:getSign", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            if (!(this.b == null || this.a == null || this.f9a == null || this.f12b == null || this.f13c == null || this.f10a == null || this.c == null)) {
                try {
                    Object newInstance = this.a.newInstance();
                    this.f9a.set(newInstance, this.f11b);
                    ((Map) this.f12b.get(newInstance)).put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str);
                    this.f13c.set(newInstance, Integer.valueOf(this.z));
                    str = (String) this.f10a.invoke(this.c, new Object[]{newInstance, this.Z});
                } catch (String str2) {
                    str2.printStackTrace();
                } catch (String str22) {
                    str22.printStackTrace();
                } catch (String str222) {
                    str222.printStackTrace();
                } catch (String str2222) {
                    str2222.printStackTrace();
                }
                return str2222;
            }
            str2222 = null;
            return str2222;
        }
    }

    public String getAuthCode() {
        return this.Z;
    }
}
