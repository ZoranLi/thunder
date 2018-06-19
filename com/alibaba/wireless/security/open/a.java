package com.alibaba.wireless.security.open;

import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;
import com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
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
import java.util.HashMap;

class a extends HashMap<Integer, Class> {
    final /* synthetic */ SecurityGuardManager a;

    a(SecurityGuardManager securityGuardManager) {
        this.a = securityGuardManager;
        put(Integer.valueOf(1), ISecureSignatureComponent.class);
        put(Integer.valueOf(2), IDynamicDataStoreComponent.class);
        put(Integer.valueOf(3), IStaticDataStoreComponent.class);
        put(Integer.valueOf(5), IDataCollectionComponent.class);
        put(Integer.valueOf(6), IStaticDataEncryptComponent.class);
        put(Integer.valueOf(7), IDynamicDataEncryptComponent.class);
        put(Integer.valueOf(8), ISimulatorDetectComponent.class);
        put(Integer.valueOf(9), IStaticKeyEncryptComponent.class);
        put(Integer.valueOf(10), IOpenSDKComponent.class);
        put(Integer.valueOf(11), IUMIDComponent.class);
        put(Integer.valueOf(12), IPkgValidityCheckComponent.class);
        put(Integer.valueOf(13), IAtlasEncryptComponent.class);
        put(Integer.valueOf(14), IMalDetect.class);
        put(Integer.valueOf(15), INoCaptchaComponent.class);
        put(Integer.valueOf(16), ISafeTokenComponent.class);
    }
}
