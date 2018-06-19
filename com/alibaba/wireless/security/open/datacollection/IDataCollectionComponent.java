package com.alibaba.wireless.security.open.datacollection;

import com.alibaba.wireless.security.open.IComponent;

public interface IDataCollectionComponent extends IComponent {
    String getNick();

    boolean setNick(String str);
}
