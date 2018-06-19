package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.IRemoteParserListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.a;
import com.taobao.tao.remotebusiness.auth.RemoteAuth;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import mtopsdk.common.util.j;
import mtopsdk.mtop.common.e;
import mtopsdk.mtop.common.i;
import mtopsdk.mtop.common.k;
import mtopsdk.mtop.util.b;
import mtopsdk.mtop.util.h;

class MtopFinishListenerImpl extends b implements e {
    private static final String TAG = "mtop.rb-FinishListener";

    public MtopFinishListenerImpl(MtopBusiness mtopBusiness, k kVar) {
        super(mtopBusiness, kVar);
    }

    public void onFinished(i iVar, Object obj) {
        j.b(this.mtopBusiness.getSeqNo(), "Mtop onFinish event received.");
        if (this.mtopBusiness.isTaskCanceled() != null) {
            j.a(this.mtopBusiness.getSeqNo(), "The request of RemoteBusiness is canceled.");
            return;
        }
        obj = iVar.a;
        if (obj == null) {
            j.a(this.mtopBusiness.getSeqNo(), "The MtopResponse is null.");
        } else if (obj.isSessionInvalid() && this.mtopBusiness.request.isNeedEcode() && this.mtopBusiness.getRetryTime() == 0) {
            a.a(this.mtopBusiness);
            RemoteLogin.login(this.mtopBusiness.isShowLoginUI(), obj);
        } else {
            String retCode = obj.getRetCode();
            if (("FAIL_SYS_ACCESS_TOKEN_EXPIRED".equalsIgnoreCase(retCode) || "FAIL_SYS_ILLEGAL_ACCESS_TOKEN".equalsIgnoreCase(retCode)) && this.mtopBusiness.isNeedAuth() && this.mtopBusiness.getRetryTime() < 3) {
                a.a(this.mtopBusiness);
                RemoteAuth.authorize(this.mtopBusiness.authParam, this.mtopBusiness.request.getKey(), c.a(obj.getHeaderFields(), "x-act-hint"), this.mtopBusiness.showAuthUI);
                return;
            }
            long j;
            h mtopStat;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.listener instanceof IRemoteParserListener) {
                ((IRemoteParserListener) this.listener).parseResponse(iVar.a);
            }
            iVar = com.taobao.tao.remotebusiness.a.a.a(this.listener, iVar, this.mtopBusiness);
            iVar.e = obj;
            long currentTimeMillis2 = System.currentTimeMillis();
            mtopsdk.mtop.domain.a aVar = null;
            if (obj != null) {
                if (!obj.isApiSuccess() || this.mtopBusiness.clazz == null) {
                    j = currentTimeMillis2;
                } else {
                    Class cls = this.mtopBusiness.clazz;
                    if (cls != null) {
                        if (obj != null) {
                            aVar = b.a(obj.getBytedata(), cls);
                            iVar.c = aVar;
                            j = System.currentTimeMillis();
                        }
                    }
                    j.e("outClass is null or response is null");
                    iVar.c = aVar;
                    j = System.currentTimeMillis();
                }
                mtopStat = obj.getMtopStat();
                if (mtopStat == null) {
                    mtopStat = new h();
                    obj.setMtopStat(mtopStat);
                }
            } else {
                mtopStat = null;
                j = currentTimeMillis2;
            }
            this.mtopBusiness.onBgFinishTime = System.currentTimeMillis();
            if (mtopStat != null) {
                obj = mtopStat.h();
                obj.b = this.mtopBusiness.sendStartTime - this.mtopBusiness.reqStartTime;
                obj.a = currentTimeMillis - this.mtopBusiness.sendStartTime;
                obj.c = this.mtopBusiness.onBgFinishTime - currentTimeMillis;
                obj.f = currentTimeMillis2 - currentTimeMillis;
                obj.e = j - currentTimeMillis2;
                obj.d = this.mtopBusiness.onBgFinishTime - this.mtopBusiness.reqStartTime;
            }
            com.taobao.tao.remotebusiness.a.a.a().obtainMessage(3, iVar).sendToTarget();
        }
    }
}
