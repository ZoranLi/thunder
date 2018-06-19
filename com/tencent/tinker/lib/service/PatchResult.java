package com.tencent.tinker.lib.service;

import java.io.Serializable;

/* compiled from: BUGLY */
public class PatchResult implements Serializable {
    public long costTime;
    public Throwable e;
    public boolean isSuccess;
    public String patchVersion;
    public String rawPatchFilePath;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nPatchResult: \n");
        StringBuilder stringBuilder = new StringBuilder("isSuccess:");
        stringBuilder.append(this.isSuccess);
        stringBuilder.append("\n");
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("rawPatchFilePath:");
        stringBuilder.append(this.rawPatchFilePath);
        stringBuilder.append("\n");
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("costTime:");
        stringBuilder.append(this.costTime);
        stringBuilder.append("\n");
        stringBuffer.append(stringBuilder.toString());
        if (this.patchVersion != null) {
            stringBuilder = new StringBuilder("patchVersion:");
            stringBuilder.append(this.patchVersion);
            stringBuilder.append("\n");
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.e != null) {
            stringBuilder = new StringBuilder("Throwable:");
            stringBuilder.append(this.e.getMessage());
            stringBuilder.append("\n");
            stringBuffer.append(stringBuilder.toString());
        }
        return stringBuffer.toString();
    }
}
