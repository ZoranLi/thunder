package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import com.alipay.sdk.util.h;
import java.util.ArrayList;
import java.util.List;

public class MiPushCommandMessage implements a {
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_COMMAND = "command";
    private static final String KEY_COMMAND_ARGUMENTS = "commandArguments";
    private static final String KEY_REASON = "reason";
    private static final String KEY_RESULT_CODE = "resultCode";
    private static final long serialVersionUID = 1;
    private String category;
    private String command;
    private List<String> commandArguments;
    private String reason;
    private long resultCode;

    public static MiPushCommandMessage fromBundle(Bundle bundle) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.command = bundle.getString("command");
        miPushCommandMessage.resultCode = bundle.getLong("resultCode");
        miPushCommandMessage.reason = bundle.getString("reason");
        miPushCommandMessage.commandArguments = bundle.getStringArrayList(KEY_COMMAND_ARGUMENTS);
        miPushCommandMessage.category = bundle.getString(KEY_CATEGORY);
        return miPushCommandMessage;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCommand() {
        return this.command;
    }

    public List<String> getCommandArguments() {
        return this.commandArguments;
    }

    public String getReason() {
        return this.reason;
    }

    public long getResultCode() {
        return this.resultCode;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void setCommandArguments(List<String> list) {
        this.commandArguments = list;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setResultCode(long j) {
        this.resultCode = j;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("command", this.command);
        bundle.putLong("resultCode", this.resultCode);
        bundle.putString("reason", this.reason);
        if (this.commandArguments != null) {
            bundle.putStringArrayList(KEY_COMMAND_ARGUMENTS, (ArrayList) this.commandArguments);
        }
        bundle.putString(KEY_CATEGORY, this.category);
        return bundle;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("command={");
        stringBuilder.append(this.command);
        stringBuilder.append("}, resultCode={");
        stringBuilder.append(this.resultCode);
        stringBuilder.append("}, reason={");
        stringBuilder.append(this.reason);
        stringBuilder.append("}, category={");
        stringBuilder.append(this.category);
        stringBuilder.append("}, commandArguments={");
        stringBuilder.append(this.commandArguments);
        stringBuilder.append(h.d);
        return stringBuilder.toString();
    }
}
