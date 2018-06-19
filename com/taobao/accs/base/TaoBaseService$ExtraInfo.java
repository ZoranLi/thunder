package com.taobao.accs.base;

import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
public class TaoBaseService$ExtraInfo implements Serializable {
    public static final String EXT_HEADER = "ext_header";
    public int connType;
    public Map<TaoBaseService$ExtHeaderType, String> extHeader;
    public String fromHost;
    public String fromPackage;
    public Map<Integer, String> oriExtHeader;
}
