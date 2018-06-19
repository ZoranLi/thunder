package com.xunlei.common.new_ptl.pay;

import com.xunlei.common.new_ptl.pay.param.XLPayParam;

public interface XLContractor<T1, T2, T3 extends XLPayParam> {
    int userContract(T1 t1, Object obj);

    int userDisContract(T3 t3, Object obj);

    int userQuery(T2 t2, Object obj);
}
