package com.taobao.accs.flowcontrol;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService$ExtHeaderType;
import com.taobao.accs.utl.ALog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: Taobao */
public class FlowControl {
    public static final int DELAY_MAX = -1;
    public static final int DELAY_MAX_BRUSH = -1000;
    public static final int HIGH_FLOW_CTRL = 2;
    public static final int HIGH_FLOW_CTRL_BRUSH = 3;
    public static final int LOW_FLOW_CTRL = 1;
    public static final int NO_FLOW_CTRL = 0;
    public static final String SERVICE_ALL = "ALL";
    public static final String SERVICE_ALL_BRUSH = "ALL_BRUSH";
    public static final int STATUS_FLOW_CTRL_ALL = 420;
    public static final int STATUS_FLOW_CTRL_BRUSH = 422;
    public static final int STATUS_FLOW_CTRL_CUR = 421;
    private Context a;
    private FlowCtrlInfoHolder b;

    public FlowControl(Context context) {
        this.a = context;
    }

    public int a(Map<Integer, String> map, String str) {
        Throwable th;
        Throwable th2;
        FlowControl flowControl = this;
        Map<Integer, String> map2 = map;
        int intValue;
        long j;
        if (map2 != null) {
            try {
                String str2 = (String) map2.get(Integer.valueOf(TaoBaseService$ExtHeaderType.TYPE_STATUS.ordinal()));
                String str3 = (String) map2.get(Integer.valueOf(TaoBaseService$ExtHeaderType.TYPE_DELAY.ordinal()));
                String str4 = (String) map2.get(Integer.valueOf(TaoBaseService$ExtHeaderType.TYPE_EXPIRE.ordinal()));
                String str5 = (String) map2.get(Integer.valueOf(TaoBaseService$ExtHeaderType.TYPE_BUSINESS.ordinal()));
                intValue = TextUtils.isEmpty(str2) ? 0 : Integer.valueOf(str2).intValue();
                try {
                    long longValue = TextUtils.isEmpty(str3) ? 0 : Long.valueOf(str3).longValue();
                    try {
                        long longValue2 = TextUtils.isEmpty(str4) ? 0 : Long.valueOf(str4).longValue();
                        if ((intValue != 420 && intValue != STATUS_FLOW_CTRL_CUR && intValue != STATUS_FLOW_CTRL_BRUSH) || !a(longValue, longValue2)) {
                            return 0;
                        }
                        synchronized (this) {
                            try {
                                FlowControlInfo flowControlInfo;
                                if (flowControl.b == null) {
                                    try {
                                        flowControl.b = new FlowCtrlInfoHolder();
                                    } catch (Throwable th22) {
                                        th = th22;
                                        j = longValue;
                                        try {
                                            throw th;
                                        } catch (Throwable th3) {
                                            th22 = th3;
                                        }
                                    }
                                }
                                FlowControlInfo flowControlInfo2;
                                if (intValue == 420) {
                                    flowControlInfo2 = flowControlInfo2;
                                    j = longValue;
                                    flowControlInfo2 = new FlowControlInfo(SERVICE_ALL, "", intValue, longValue, longValue2, System.currentTimeMillis());
                                    flowControl.b.put(SERVICE_ALL, "", flowControlInfo2);
                                } else {
                                    j = longValue;
                                    if (intValue == STATUS_FLOW_CTRL_BRUSH) {
                                        flowControlInfo2 = new FlowControlInfo(SERVICE_ALL_BRUSH, "", intValue, j, longValue2, System.currentTimeMillis());
                                        flowControl.b.put(SERVICE_ALL_BRUSH, "", flowControlInfo2);
                                    } else if (intValue != STATUS_FLOW_CTRL_CUR || TextUtils.isEmpty(str)) {
                                        flowControlInfo = null;
                                    } else {
                                        FlowControlInfo flowControlInfo3 = flowControlInfo2;
                                        flowControlInfo2 = new FlowControlInfo(str, str5, intValue, j, longValue2, System.currentTimeMillis());
                                        flowControl.b.put(str, str5, flowControlInfo3);
                                        flowControlInfo = flowControlInfo3;
                                    }
                                }
                                if (flowControlInfo != null) {
                                    StringBuilder stringBuilder = new StringBuilder("updateFlowCtrlInfo ");
                                    stringBuilder.append(flowControlInfo.toString());
                                    ALog.e("FlowControl", stringBuilder.toString(), new Object[0]);
                                }
                            } catch (Throwable th4) {
                                th22 = th4;
                                th = th22;
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th22 = th5;
                        j = longValue;
                        th = th22;
                        ALog.e("FlowControl", "updateFlowCtrlInfo", th, new Object[0]);
                        if (j <= 0) {
                            return 1;
                        }
                        if (j == 0) {
                            return STATUS_FLOW_CTRL_BRUSH != intValue ? 2 : 3;
                        } else {
                            return 0;
                        }
                    }
                } catch (Throwable th222) {
                    th = th222;
                    j = 0;
                    ALog.e("FlowControl", "updateFlowCtrlInfo", th, new Object[0]);
                    if (j <= 0) {
                        return 1;
                    }
                    if (j == 0) {
                        return 0;
                    }
                    if (STATUS_FLOW_CTRL_BRUSH != intValue) {
                    }
                }
            } catch (Throwable th2222) {
                th = th2222;
                j = 0;
                intValue = 0;
                ALog.e("FlowControl", "updateFlowCtrlInfo", th, new Object[0]);
                if (j <= 0) {
                    return 1;
                }
                if (j == 0) {
                    return 0;
                }
                if (STATUS_FLOW_CTRL_BRUSH != intValue) {
                }
            }
        }
        j = 0;
        intValue = 0;
        if (j <= 0) {
            return 1;
        }
        if (j == 0) {
            return 0;
        }
        if (STATUS_FLOW_CTRL_BRUSH != intValue) {
        }
    }

    private boolean a(long j, long j2) {
        if (j != 0) {
            if (j2 > 0) {
                return 1;
            }
        }
        ALog.e("FlowControl", "error flow ctrl info", new Object[0]);
        return false;
    }

    public long a(String str, String str2) {
        long j = 0;
        if (!(this.b == null || this.b.flowCtrlMap == null)) {
            if (!TextUtils.isEmpty(str)) {
                long j2;
                long j3;
                long j4;
                synchronized (this) {
                    FlowControlInfo flowControlInfo = this.b.get(SERVICE_ALL, null);
                    FlowControlInfo flowControlInfo2 = this.b.get(SERVICE_ALL_BRUSH, null);
                    FlowControlInfo flowControlInfo3 = this.b.get(str, null);
                    FlowControlInfo flowControlInfo4 = this.b.get(str, str2);
                    if (flowControlInfo != null) {
                        if (!flowControlInfo.isExpired()) {
                            j2 = flowControlInfo.delayTime;
                            if (flowControlInfo2 != null) {
                                if (flowControlInfo2.isExpired()) {
                                    j3 = flowControlInfo2.delayTime;
                                    if (flowControlInfo3 != null) {
                                        if (!flowControlInfo3.isExpired()) {
                                            j4 = flowControlInfo3.delayTime;
                                            if (flowControlInfo4 != null) {
                                                if (!flowControlInfo4.isExpired()) {
                                                    j = flowControlInfo4.delayTime;
                                                }
                                            }
                                            if (!(j2 == -1 || j == -1)) {
                                                if (j4 == -1) {
                                                    if (j3 != -1) {
                                                        j3 = -1000;
                                                    } else {
                                                        j3 = j2 <= j ? j2 : j;
                                                        if (j3 <= j4) {
                                                            j3 = j4;
                                                        }
                                                    }
                                                    if ((flowControlInfo4 != null && flowControlInfo4.isExpired()) || (flowControlInfo != null && flowControlInfo.isExpired())) {
                                                        a();
                                                    }
                                                }
                                            }
                                            j3 = -1;
                                            a();
                                        }
                                    }
                                    j4 = 0;
                                    if (flowControlInfo4 != null) {
                                        if (!flowControlInfo4.isExpired()) {
                                            j = flowControlInfo4.delayTime;
                                        }
                                    }
                                    if (j4 == -1) {
                                        if (j3 != -1) {
                                            if (j2 <= j) {
                                            }
                                            if (j3 <= j4) {
                                                j3 = j4;
                                            }
                                        } else {
                                            j3 = -1000;
                                        }
                                        a();
                                    } else {
                                        j3 = -1;
                                        a();
                                    }
                                }
                            }
                            j3 = 0;
                            if (flowControlInfo3 != null) {
                                if (!flowControlInfo3.isExpired()) {
                                    j4 = flowControlInfo3.delayTime;
                                    if (flowControlInfo4 != null) {
                                        if (!flowControlInfo4.isExpired()) {
                                            j = flowControlInfo4.delayTime;
                                        }
                                    }
                                    if (j4 == -1) {
                                        j3 = -1;
                                        a();
                                    } else {
                                        if (j3 != -1) {
                                            j3 = -1000;
                                        } else {
                                            if (j2 <= j) {
                                            }
                                            if (j3 <= j4) {
                                                j3 = j4;
                                            }
                                        }
                                        a();
                                    }
                                }
                            }
                            j4 = 0;
                            if (flowControlInfo4 != null) {
                                if (!flowControlInfo4.isExpired()) {
                                    j = flowControlInfo4.delayTime;
                                }
                            }
                            if (j4 == -1) {
                                if (j3 != -1) {
                                    if (j2 <= j) {
                                    }
                                    if (j3 <= j4) {
                                        j3 = j4;
                                    }
                                } else {
                                    j3 = -1000;
                                }
                                a();
                            } else {
                                j3 = -1;
                                a();
                            }
                        }
                    }
                    j2 = 0;
                    if (flowControlInfo2 != null) {
                        if (flowControlInfo2.isExpired()) {
                            j3 = flowControlInfo2.delayTime;
                            if (flowControlInfo3 != null) {
                                if (!flowControlInfo3.isExpired()) {
                                    j4 = flowControlInfo3.delayTime;
                                    if (flowControlInfo4 != null) {
                                        if (!flowControlInfo4.isExpired()) {
                                            j = flowControlInfo4.delayTime;
                                        }
                                    }
                                    if (j4 == -1) {
                                        j3 = -1;
                                        a();
                                    } else {
                                        if (j3 != -1) {
                                            j3 = -1000;
                                        } else {
                                            if (j2 <= j) {
                                            }
                                            if (j3 <= j4) {
                                                j3 = j4;
                                            }
                                        }
                                        a();
                                    }
                                }
                            }
                            j4 = 0;
                            if (flowControlInfo4 != null) {
                                if (!flowControlInfo4.isExpired()) {
                                    j = flowControlInfo4.delayTime;
                                }
                            }
                            if (j4 == -1) {
                                if (j3 != -1) {
                                    if (j2 <= j) {
                                    }
                                    if (j3 <= j4) {
                                        j3 = j4;
                                    }
                                } else {
                                    j3 = -1000;
                                }
                                a();
                            } else {
                                j3 = -1;
                                a();
                            }
                        }
                    }
                    j3 = 0;
                    if (flowControlInfo3 != null) {
                        if (!flowControlInfo3.isExpired()) {
                            j4 = flowControlInfo3.delayTime;
                            if (flowControlInfo4 != null) {
                                if (!flowControlInfo4.isExpired()) {
                                    j = flowControlInfo4.delayTime;
                                }
                            }
                            if (j4 == -1) {
                                j3 = -1;
                                a();
                            } else {
                                if (j3 != -1) {
                                    j3 = -1000;
                                } else {
                                    if (j2 <= j) {
                                    }
                                    if (j3 <= j4) {
                                        j3 = j4;
                                    }
                                }
                                a();
                            }
                        }
                    }
                    j4 = 0;
                    if (flowControlInfo4 != null) {
                        if (!flowControlInfo4.isExpired()) {
                            j = flowControlInfo4.delayTime;
                        }
                    }
                    if (j4 == -1) {
                        if (j3 != -1) {
                            if (j2 <= j) {
                            }
                            if (j3 <= j4) {
                                j3 = j4;
                            }
                        } else {
                            j3 = -1000;
                        }
                        a();
                    } else {
                        j3 = -1;
                        a();
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("getFlowCtrlDelay service ");
                stringBuilder.append(str);
                stringBuilder.append(" biz ");
                stringBuilder.append(str2);
                stringBuilder.append(" result:");
                stringBuilder.append(j3);
                stringBuilder.append(" global:");
                stringBuilder.append(j2);
                stringBuilder.append(" serviceDelay:");
                stringBuilder.append(j4);
                stringBuilder.append(" bidDelay:");
                stringBuilder.append(j);
                ALog.e("FlowControl", stringBuilder.toString(), new Object[null]);
                return j3;
            }
        }
        return 0;
    }

    private void a() {
        if (this.b != null && this.b.flowCtrlMap != null) {
            synchronized (this) {
                Iterator it = this.b.flowCtrlMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (((FlowControlInfo) ((Entry) it.next()).getValue()).isExpired()) {
                        it.remove();
                    }
                }
            }
        }
    }
}
