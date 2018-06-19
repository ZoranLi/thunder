package com.qihoo360.replugin.component.provider;

public class PluginPitProviderUI extends PluginPitProviderBase {
    public static final String b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AUTHORITY_PREFIX);
        stringBuilder.append("UIP");
        b = stringBuilder.toString();
    }

    public PluginPitProviderUI() {
        super(b);
    }
}
