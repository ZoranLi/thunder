package com.taobao.accs.flowcontrol;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class FlowControl$FlowCtrlInfoHolder implements Serializable {
    private static final long serialVersionUID = 6307563052429742524L;
    Map<String, FlowControl$FlowControlInfo> flowCtrlMap = null;

    public void put(String str, String str2, FlowControl$FlowControlInfo flowControl$FlowControlInfo) {
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_");
            stringBuilder.append(str2);
            str = stringBuilder.toString();
        }
        if (this.flowCtrlMap == null) {
            this.flowCtrlMap = new HashMap();
        }
        this.flowCtrlMap.put(str, flowControl$FlowControlInfo);
    }

    public FlowControl$FlowControlInfo get(String str, String str2) {
        if (this.flowCtrlMap == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_");
            stringBuilder.append(str2);
            str = stringBuilder.toString();
        }
        return (FlowControl$FlowControlInfo) this.flowCtrlMap.get(str);
    }
}
