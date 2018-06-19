package com.ut.mini.base;

import com.ut.mini.sdkevents.UTMI1010_2001Event;

public class UTMIVariables {
    private static UTMIVariables a = new UTMIVariables();
    private boolean O = false;
    private UTMI1010_2001Event f14a = null;
    private String aj = null;
    private String am = null;
    private String an = null;

    public synchronized void setToAliyunOSPlatform() {
        this.O = true;
    }

    public synchronized boolean isAliyunOSPlatform() {
        return this.O;
    }

    public synchronized void setUTMI1010_2001EventInstance(UTMI1010_2001Event uTMI1010_2001Event) {
        this.f14a = uTMI1010_2001Event;
    }

    public synchronized UTMI1010_2001Event getUTMI1010_2001EventInstance() {
        return this.f14a;
    }

    public static UTMIVariables getInstance() {
        return a;
    }

    public String getH5Url() {
        return this.an;
    }

    public void setH5Url(String str) {
        this.an = str;
    }

    public String getRefPage() {
        return this.aj;
    }

    public void setRefPage(String str) {
        this.aj = str;
    }

    public String getH5RefPage() {
        return this.am;
    }

    public void setH5RefPage(String str) {
        this.am = str;
    }
}
