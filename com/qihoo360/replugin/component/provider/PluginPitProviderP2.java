package com.qihoo360.replugin.component.provider;

public class PluginPitProviderP2 extends PluginPitProviderBase {
    public static final String AUTHORITY;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AUTHORITY_PREFIX);
        stringBuilder.append("2");
        AUTHORITY = stringBuilder.toString();
    }

    public PluginPitProviderP2() {
        super(AUTHORITY);
    }
}
