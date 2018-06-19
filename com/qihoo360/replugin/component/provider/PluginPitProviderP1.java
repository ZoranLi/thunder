package com.qihoo360.replugin.component.provider;

public class PluginPitProviderP1 extends PluginPitProviderBase {
    public static final String AUTHORITY;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AUTHORITY_PREFIX);
        stringBuilder.append("1");
        AUTHORITY = stringBuilder.toString();
    }

    public PluginPitProviderP1() {
        super(AUTHORITY);
    }
}
