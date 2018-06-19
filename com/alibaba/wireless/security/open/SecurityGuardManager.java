package com.alibaba.wireless.security.open;

import android.content.Context;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.framework.b;
import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;
import com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import com.alibaba.wireless.security.open.initialize.a;
import com.alibaba.wireless.security.open.initialize.d;
import com.alibaba.wireless.security.open.maldetection.IMalDetect;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;
import com.alibaba.wireless.security.open.pkgvaliditycheck.IPkgValidityCheckComponent;
import com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.simulatordetect.ISimulatorDetectComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import java.util.Map;

public class SecurityGuardManager {
    private static volatile SecurityGuardManager b;
    private static volatile IInitializeComponent c;
    private static final Object d = new Object();
    private b a;
    private final Map<Integer, Class> e = new a(this);

    private SecurityGuardManager(Context context) {
        this.a = b.a(context);
    }

    public static IInitializeComponent getInitializer() {
        if (c == null) {
            synchronized (d) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public static SecurityGuardManager getInstance(Context context) throws SecException {
        if (b == null) {
            synchronized (SecurityGuardManager.class) {
                if (context == null) {
                    return null;
                } else if (b == null && getInitializer().initialize(context) == 0) {
                    b = new SecurityGuardManager(context);
                }
            }
        }
        return b;
    }

    IComponent a(int i) {
        try {
            return (IComponent) getInterface((Class) this.e.get(Integer.valueOf(i)));
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public IAtlasEncryptComponent getAtlasEncryptComp() {
        IAtlasEncryptComponent iAtlasEncryptComponent = (IAtlasEncryptComponent) a(13);
        if (iAtlasEncryptComponent == null) {
            new SecException(SecExceptionCode.SEC_ERROR_ATLAS_UNSUPPORTED).printStackTrace();
        }
        return iAtlasEncryptComponent;
    }

    public IDataCollectionComponent getDataCollectionComp() {
        return (IDataCollectionComponent) a(5);
    }

    public IDynamicDataEncryptComponent getDynamicDataEncryptComp() {
        return (IDynamicDataEncryptComponent) a(7);
    }

    public IDynamicDataStoreComponent getDynamicDataStoreComp() {
        return (IDynamicDataStoreComponent) a(2);
    }

    public <T> T getInterface(Class<T> cls) throws SecException {
        return this.a.a((Class) cls);
    }

    public IMalDetect getMalDetectionComp() {
        IMalDetect iMalDetect = (IMalDetect) a(14);
        if (iMalDetect == null) {
            new SecException(SecExceptionCode.SEC_ERROR_MALDETECT_UNSUPPORTED).printStackTrace();
        }
        return iMalDetect;
    }

    public INoCaptchaComponent getNoCaptchaComp() {
        INoCaptchaComponent iNoCaptchaComponent = (INoCaptchaComponent) a(15);
        if (iNoCaptchaComponent == null) {
            new SecException(1299).printStackTrace();
        }
        return iNoCaptchaComponent;
    }

    public IOpenSDKComponent getOpenSDKComp() {
        return (IOpenSDKComponent) a(10);
    }

    public IPkgValidityCheckComponent getPackageValidityCheckComp() {
        return (IPkgValidityCheckComponent) a(12);
    }

    public String getSDKVerison() {
        return d.a();
    }

    public ISafeTokenComponent getSafeTokenComp() {
        ISafeTokenComponent iSafeTokenComponent = (ISafeTokenComponent) a(16);
        if (iSafeTokenComponent == null) {
            new SecException(SecExceptionCode.SEC_ERROR_SAFETOKEN_UNKNOWN_ERR).printStackTrace();
        }
        return iSafeTokenComponent;
    }

    public ISecureSignatureComponent getSecureSignatureComp() {
        return (ISecureSignatureComponent) a(1);
    }

    public ISimulatorDetectComponent getSimulatorDetectComp() {
        ISimulatorDetectComponent iSimulatorDetectComponent = (ISimulatorDetectComponent) a(8);
        if (iSimulatorDetectComponent == null) {
            new SecException(SecExceptionCode.SEC_ERROR_SIMULATORDETECT_UNSUPPORTED).printStackTrace();
        }
        return iSimulatorDetectComponent;
    }

    public IStaticDataEncryptComponent getStaticDataEncryptComp() {
        return (IStaticDataEncryptComponent) a(6);
    }

    public IStaticDataStoreComponent getStaticDataStoreComp() {
        return (IStaticDataStoreComponent) a(3);
    }

    public IStaticKeyEncryptComponent getStaticKeyEncryptComp() {
        return (IStaticKeyEncryptComponent) a(9);
    }

    public IUMIDComponent getUMIDComp() {
        return (IUMIDComponent) a(11);
    }

    public Boolean isOpen() {
        return Boolean.valueOf(true);
    }
}
