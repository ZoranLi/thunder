package com.taobao.accs.net;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType.TypeLevel;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.Message.b;
import com.taobao.accs.ut.monitor.TrafficsMonitor.a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;

/* compiled from: Taobao */
class l implements Runnable {
    final /* synthetic */ Message a;
    final /* synthetic */ k b;

    l(k kVar, Message message) {
        this.b = kVar;
        this.a = message;
    }

    public void run() {
        StringBuilder stringBuilder;
        Throwable th;
        if (this.a != null) {
            if (r1.a.e() != null) {
                r1.a.e().onTakeFromQueue();
            }
            int a = r1.a.a();
            int i = 0;
            String d;
            String d2;
            String stringBuilder2;
            try {
                boolean z;
                StringBuilder stringBuilder3;
                if (ALog.isPrintLog(Level.I)) {
                    String d3 = r1.b.d();
                    StringBuilder stringBuilder4 = new StringBuilder("try send:");
                    stringBuilder4.append(b.b(a));
                    stringBuilder4.append(" dataId:");
                    stringBuilder4.append(r1.a.q);
                    ALog.i(d3, stringBuilder4.toString(), "appkey", r1.b.b);
                }
                if (a != 1) {
                    d = r1.b.d();
                    stringBuilder = new StringBuilder("skip msg type");
                    stringBuilder.append(b.b(a));
                    ALog.e(d, stringBuilder.toString(), new Object[0]);
                } else if (r1.a.f == null) {
                    r1.b.e.a(r1.a, -5);
                } else {
                    SessionCenter instance = SessionCenter.getInstance(r1.b.i.getAppKey());
                    r1.b.a(instance, r1.a.f.getHost(), false);
                    Session session = instance.get(r1.a.f.toString(), TypeLevel.SPDY, 60000);
                    if (session != null) {
                        byte[] a2 = r1.a.a(r1.b.d, r1.b.c);
                        String d4;
                        Object[] objArr;
                        if ("accs".equals(r1.a.F)) {
                            d4 = r1.b.d();
                            String str = "send data ";
                            objArr = new Object[10];
                            objArr[0] = "len";
                            if (a2 != null) {
                                i = a2.length;
                            }
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = Constants.KEY_DATA_ID;
                            objArr[3] = r1.a.b();
                            objArr[4] = "command";
                            objArr[5] = r1.a.t;
                            objArr[6] = "host";
                            objArr[7] = r1.a.f;
                            objArr[8] = "utdid";
                            objArr[9] = r1.b.j;
                            ALog.e(d4, str, objArr);
                        } else if (ALog.isPrintLog(Level.I)) {
                            d = r1.b.d();
                            d4 = "send data ";
                            objArr = new Object[10];
                            objArr[0] = "len";
                            objArr[1] = Integer.valueOf(a2 == null ? 0 : a2.length);
                            objArr[2] = Constants.KEY_DATA_ID;
                            objArr[3] = r1.a.b();
                            objArr[4] = "command";
                            objArr[5] = r1.a.t;
                            objArr[6] = "host";
                            objArr[7] = r1.a.f;
                            objArr[8] = "utdid";
                            objArr[9] = r1.b.j;
                            ALog.i(d, d4, objArr);
                        }
                        r1.a.a(System.currentTimeMillis());
                        if (a2.length <= 16384 || r1.a.t.intValue() == 102) {
                            r1.b.e.a(r1.a);
                            if (r1.a.c) {
                                r1.b.l.put(Integer.valueOf(r1.a.d()), r1.a);
                            }
                            session.sendCustomFrame(r1.a.d(), a2, 200);
                            if (r1.a.e() != null) {
                                r1.a.e().onSendData();
                            }
                            r1.b.a(r1.a.b(), (long) r1.a.Q);
                            r1.b.e.a(new a(r1.a.F, GlobalAppRuntimeInfo.isAppBackground(), r1.a.f.toString(), (long) a2.length));
                        } else {
                            r1.b.e.a(r1.a, -4);
                        }
                    } else {
                        z = false;
                        if (!z) {
                            if (a != 1) {
                                if (r1.a.g() || !r1.b.a(r1.a, 2000)) {
                                    r1.b.e.a(r1.a, -11);
                                }
                                if (r1.a.P == 1 && r1.a.e() != null) {
                                    com.taobao.accs.utl.b.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total_accs", 0.0d);
                                }
                            } else {
                                r1.b.e.a(r1.a, -11);
                            }
                        }
                        if ("accs".equals(r1.a.F)) {
                            d2 = r1.b.d();
                            stringBuilder3 = new StringBuilder("sendSucc ");
                            stringBuilder3.append(z);
                            stringBuilder3.append(" dataId:");
                            stringBuilder3.append(r1.a.b());
                            stringBuilder2 = stringBuilder3.toString();
                            ALog.e(d2, stringBuilder2, new Object[0]);
                        } else if (ALog.isPrintLog(Level.D)) {
                            d2 = r1.b.d();
                            stringBuilder3 = new StringBuilder("sendSucc ");
                            stringBuilder3.append(z);
                            stringBuilder3.append(" dataId:");
                            stringBuilder3.append(r1.a.b());
                            stringBuilder2 = stringBuilder3.toString();
                            ALog.d(d2, stringBuilder2, new Object[0]);
                        }
                    }
                }
                z = true;
                if (z) {
                    if (a != 1) {
                        r1.b.e.a(r1.a, -11);
                    } else {
                        r1.b.e.a(r1.a, -11);
                        com.taobao.accs.utl.b.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total_accs", 0.0d);
                    }
                }
                if ("accs".equals(r1.a.F)) {
                    d2 = r1.b.d();
                    stringBuilder3 = new StringBuilder("sendSucc ");
                    stringBuilder3.append(z);
                    stringBuilder3.append(" dataId:");
                    stringBuilder3.append(r1.a.b());
                    stringBuilder2 = stringBuilder3.toString();
                    ALog.e(d2, stringBuilder2, new Object[0]);
                } else if (ALog.isPrintLog(Level.D)) {
                    d2 = r1.b.d();
                    stringBuilder3 = new StringBuilder("sendSucc ");
                    stringBuilder3.append(z);
                    stringBuilder3.append(" dataId:");
                    stringBuilder3.append(r1.a.b());
                    stringBuilder2 = stringBuilder3.toString();
                    ALog.d(d2, stringBuilder2, new Object[0]);
                }
            } catch (Throwable th2) {
                th = th2;
                if ("accs".equals(r1.a.F)) {
                    d = r1.b.d();
                    stringBuilder = new StringBuilder("sendSucc ");
                    stringBuilder.append(true);
                    stringBuilder.append(" dataId:");
                    stringBuilder.append(r1.a.b());
                    ALog.e(d, stringBuilder.toString(), new Object[0]);
                } else if (ALog.isPrintLog(Level.D)) {
                    d = r1.b.d();
                    stringBuilder = new StringBuilder("sendSucc ");
                    stringBuilder.append(true);
                    stringBuilder.append(" dataId:");
                    stringBuilder.append(r1.a.b());
                    ALog.d(d, stringBuilder.toString(), new Object[0]);
                }
            }
        }
    }
}
