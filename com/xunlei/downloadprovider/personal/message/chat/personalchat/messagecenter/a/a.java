package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a;

import android.support.annotation.Nullable;

/* compiled from: BaseMessageCenterItemInfo */
public abstract class a implements b {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                a aVar = (a) obj;
                return getId() == aVar.getId() && getItemType() == aVar.getItemType();
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * getId()) + getItemType();
    }

    public int compareTo(@Nullable b bVar) {
        return bVar == null ? 1 : bVar.getCategoryPriority() - getCategoryPriority();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("getId(): ");
        stringBuilder.append(getId());
        stringBuilder.append("getItemType(): ");
        stringBuilder.append(getItemType());
        stringBuilder.append("getTitle(): ");
        stringBuilder.append(getTitle());
        return stringBuilder.toString();
    }
}
