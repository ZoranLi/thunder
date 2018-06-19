package com.qihoo360.replugin.component.provider;

public class PluginPitProviderPersist extends PluginPitProviderBase {
    public static final String b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AUTHORITY_PREFIX);
        stringBuilder.append("PSP");
        b = stringBuilder.toString();
    }

    public PluginPitProviderPersist() {
        super(b);
    }
}
