package com.qihoo360.replugin.component.provider;

public class PluginPitProviderP0 extends PluginPitProviderBase {
    public static final String AUTHORITY;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AUTHORITY_PREFIX);
        stringBuilder.append("0");
        AUTHORITY = stringBuilder.toString();
    }

    public PluginPitProviderP0() {
        super(AUTHORITY);
    }
}
