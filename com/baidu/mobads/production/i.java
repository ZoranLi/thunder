package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.download.activate.IXMonitorActivation;

class i implements Runnable {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void run() {
        try {
            if (b.a != null) {
                IXMonitorActivation xMonitorActivation = b.a.getXMonitorActivation(this.a.a, this.a.b.s);
                xMonitorActivation.setIXActivateListener(new a(this.a.b.f));
                xMonitorActivation.startMonitor();
            }
        } catch (Throwable e) {
            this.a.b.s.e(e);
        }
    }
}
