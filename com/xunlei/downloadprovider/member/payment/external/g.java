package com.xunlei.downloadprovider.member.payment.external;

import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.bean.PayConfigurationParam;
import com.xunlei.downloadprovider.member.payment.ui.PayOpenFragment;
import com.xunlei.downloadprovider.member.payment.ui.PayUpgradeFragment;
import com.xunlei.downloadprovider.member.payment.ui.ae;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: PayPageUtil */
public final class g {
    private static boolean a = true;

    private static void a(List<ae> list, PayConfigurationParam payConfigurationParam, int i) {
        if (payConfigurationParam != null) {
            Serializable serializable;
            Class cls;
            payConfigurationParam.type = i;
            i = PayUtil.b();
            int vastype = payConfigurationParam.getVastype();
            String tabTitle = PayConfigurationParam.getTabTitle(vastype);
            Serializable orderType = payConfigurationParam.getOrderType(payConfigurationParam.getOp());
            if (a || orderType != PayUtil$OrderType.UPGRADE) {
                serializable = orderType;
            } else {
                serializable = PayUtil$OrderType.OPEN;
            }
            if (TextUtils.isEmpty(payConfigurationParam.getShowMonth())) {
                payConfigurationParam.showMonth = PayConfigurationParam.defaultShowMonth;
            }
            if (payConfigurationParam.recommondMonth <= 0) {
                payConfigurationParam.recommondMonth = 3;
            }
            ArrayList monthList = payConfigurationParam.getMonthList(false);
            if (!monthList.contains(Integer.valueOf(payConfigurationParam.recommondMonth)) && monthList.size() > 0) {
                Collections.sort(monthList);
                payConfigurationParam.recommondMonth = ((Integer) monthList.get(monthList.size() - 1)).intValue();
            }
            if (serializable == PayUtil$OrderType.UPGRADE) {
                cls = PayUpgradeFragment.class;
            } else {
                cls = PayOpenFragment.class;
            }
            Bundle bundle = new Bundle(9);
            bundle.putBoolean("ExpiredToday", i);
            bundle.putInt("VasType", vastype);
            bundle.putSerializable("OrderType", orderType);
            bundle.putSerializable("RealOrderType", serializable);
            bundle.putSerializable("extra_pay_config", payConfigurationParam);
            list.add(new ae(tabTitle, cls, bundle));
        }
    }

    public static List<ae> a(PayConfigurationParam payConfigurationParam, PayFrom payFrom) {
        int d = j.a().d();
        int op = payConfigurationParam.getOp();
        int vastype = payConfigurationParam.getVastype();
        if (op == 0 && vastype == 2) {
            if (payFrom == null || payFrom.isFromKuaiNiao() == null) {
                payConfigurationParam = PayConfigurationParam.getDefaultMatchParams(0, 5, 1);
            } else {
                payConfigurationParam = PayConfigurationParam.getDefaultMatchParams(0, 204, 1);
            }
            vastype = payConfigurationParam.getVastype();
        }
        PayConfigurationParam payConfigurationParam2 = null;
        if (payFrom == null || payFrom.isFromKuaiNiao() == null) {
            payFrom = new ArrayList();
            if (d != 0) {
                if (d != 204) {
                    switch (d) {
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            break;
                        default:
                            if (vastype != 3) {
                                if (vastype == 5) {
                                    payConfigurationParam2 = PayConfigurationParam.getDefaultMatchParams(0, 3, 1);
                                    break;
                                }
                            }
                            payConfigurationParam2 = PayConfigurationParam.getDefaultMatchParams(0, 5, 1);
                            break;
                            break;
                    }
                } else if (vastype == 204) {
                    payConfigurationParam2 = PayConfigurationParam.getDefaultMatchParams(0, 5, 1);
                } else if (vastype == 5) {
                    payConfigurationParam2 = PayConfigurationParam.getDefaultMatchParams(0, 204, 1);
                }
                a(payFrom, payConfigurationParam, 1);
                a(payFrom, payConfigurationParam2, 2);
            }
            if (vastype == 3) {
                payConfigurationParam2 = PayConfigurationParam.getDefaultMatchParams(0, 5, 1);
            } else if (vastype == 5) {
                payConfigurationParam2 = PayConfigurationParam.getDefaultMatchParams(0, 3, 1);
            }
            a(payFrom, payConfigurationParam, 1);
            a(payFrom, payConfigurationParam2, 2);
        } else {
            payFrom = new ArrayList();
            if (d != 0) {
                if (d != 2) {
                    if (d != 204) {
                        switch (d) {
                            case 4:
                            case 5:
                                break;
                            default:
                                if (vastype == 204) {
                                    payConfigurationParam2 = PayConfigurationParam.getDefaultMatchParams(0, 5, 1);
                                    break;
                                }
                                break;
                        }
                    } else if (vastype == 204) {
                        payConfigurationParam2 = PayConfigurationParam.getDefaultMatchParams(1, 5, 1);
                    }
                }
            } else if (vastype == 204) {
                payConfigurationParam2 = PayConfigurationParam.getDefaultMatchParams(0, 5, 1, 1);
            }
            a(payFrom, payConfigurationParam, 1);
            a(payFrom, payConfigurationParam2, 2);
        }
        return payFrom;
    }

    public static List<ae> a(PayFrom payFrom, String str) {
        int d = j.a().d();
        if (payFrom == null || payFrom.isFromKuaiNiao() == null) {
            PayConfigurationParam defaultMatchParams;
            payFrom = new ArrayList();
            if (d == 204) {
                str = PayConfigurationParam.getDefaultMatchParams(0, 5, 1);
                defaultMatchParams = PayConfigurationParam.getDefaultMatchParams(0, 204, 1);
            } else if ("v_an_shoulei_hyzx_tybefore,v_an_shoulei_hyzx_tying,v_an_shoulei_hyzx_tyafter，v_an_shoulei_hyzx_ktwzl".contains(str) != null) {
                str = PayConfigurationParam.getDefaultMatchParams(0, 3, 1);
                defaultMatchParams = PayConfigurationParam.getDefaultMatchParams(0, 5, 1);
            } else {
                str = PayConfigurationParam.getDefaultMatchParams(0, 5, 1);
                defaultMatchParams = PayConfigurationParam.getDefaultMatchParams(0, 3, 1);
            }
            a(payFrom, str, 1);
            a(payFrom, defaultMatchParams, 2);
        } else {
            if (j.a().c() == null) {
                d = 0;
            }
            payFrom = new ArrayList();
            PayConfigurationParam payConfigurationParam = null;
            if (d == 0) {
                str = PayConfigurationParam.getDefaultMatchParams(0, 204, 1, 12);
                payConfigurationParam = PayConfigurationParam.getDefaultMatchParams(0, 5, 1, 1);
            } else if (d == 5) {
                str = PayConfigurationParam.getDefaultMatchParams(0, 5, 1);
            } else if (d != 204) {
                switch (d) {
                    case 2:
                    case 3:
                        str = PayConfigurationParam.getDefaultMatchParams(1, 5, 1);
                        break;
                    default:
                        str = PayConfigurationParam.getDefaultMatchParams(0, 204, 1, 3);
                        payConfigurationParam = PayConfigurationParam.getDefaultMatchParams(0, 5, 1, 3);
                        break;
                }
            } else {
                str = PayConfigurationParam.getDefaultMatchParams(0, 204, 1, 12);
                payConfigurationParam = PayConfigurationParam.getDefaultMatchParams(1, 5, 1);
            }
            a(payFrom, str, 1);
            a(payFrom, payConfigurationParam, 2);
        }
        return payFrom;
    }

    public static void a() {
        a = false;
    }

    public static void b() {
        a = true;
    }
}
