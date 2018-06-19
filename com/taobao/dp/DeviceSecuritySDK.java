package com.taobao.dp;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import com.taobao.dp.client.IInitResultListener;
import com.taobao.dp.http.IUrlRequestService;

public final class DeviceSecuritySDK {
    public static final int ENVIRONMENT_DAILY = 2;
    public static final int ENVIRONMENT_ONLINE = 0;
    public static final int ENVIRONMENT_PRE = 1;
    private static DeviceSecuritySDK instance;
    private IUMIDComponent mUmidComponent = null;
    private String mVersion;

    private DeviceSecuritySDK(Context context) {
        try {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
            this.mUmidComponent = (IUMIDComponent) instance.getInterface(IUMIDComponent.class);
            this.mVersion = instance.getSDKVerison();
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    public static DeviceSecuritySDK getInstance(Context context) {
        if (instance == null) {
            synchronized (DeviceSecuritySDK.class) {
                if (instance == null) {
                    instance = new DeviceSecuritySDK(context);
                }
            }
        }
        return instance;
    }

    @Deprecated
    public final String getSecurityToken() {
        String str = "000000000000000000000000";
        try {
            if (this.mUmidComponent != null) {
                return this.mUmidComponent.getSecurityToken();
            }
        } catch (SecException e) {
            e.printStackTrace();
        }
        return str;
    }

    public final String getSecurityToken(int i) {
        String str = "000000000000000000000000";
        try {
            if (this.mUmidComponent != null) {
                return this.mUmidComponent.getSecurityToken(i);
            }
        } catch (SecException e) {
            e.printStackTrace();
        }
        return str;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    @Deprecated
    public final void init() {
        try {
            if (this.mUmidComponent != null) {
                this.mUmidComponent.initUMID();
            }
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public final void init(IUrlRequestService iUrlRequestService) {
        try {
            if (this.mUmidComponent != null) {
                this.mUmidComponent.initUMID();
            }
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    public final void initAsync(String str, int i, IUrlRequestService iUrlRequestService, IInitResultListener iInitResultListener) {
        initAsync(str, "", i, iUrlRequestService, iInitResultListener);
    }

    public final void initAsync(String str, String str2, int i, IUrlRequestService iUrlRequestService, IInitResultListener iInitResultListener) {
        IUMIDInitListenerEx aVar = iInitResultListener != null ? new a(this, iInitResultListener) : null;
        try {
            if (this.mUmidComponent != null) {
                this.mUmidComponent.initUMID(i, aVar);
            }
        } catch (SecException e) {
            e.printStackTrace();
            if (iInitResultListener != null) {
                iInitResultListener.onInitFinished(null, -1);
            }
        }
    }

    public final int initSync(String str, int i, IUrlRequestService iUrlRequestService) {
        return initSync(str, "", i, iUrlRequestService);
    }

    public final int initSync(String str, String str2, int i, IUrlRequestService iUrlRequestService) {
        try {
            if (this.mUmidComponent != null) {
                return this.mUmidComponent.initUMIDSync(i);
            }
        } catch (SecException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Deprecated
    public final void sendLoginResult(String str) {
    }

    public final void setEnvironment(int i) {
        try {
            if (this.mUmidComponent != null) {
                this.mUmidComponent.setEnvironment(i);
            }
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    public final synchronized void setOnlineHost(OnlineHost onlineHost) throws IllegalArgumentException {
        if (onlineHost == null) {
            throw new IllegalArgumentException("host is null");
        }
        try {
            if (this.mUmidComponent != null) {
                this.mUmidComponent.setOnlineHost(onlineHost.getHost());
            }
        } catch (SecException e) {
            e.printStackTrace();
        }
    }
}
