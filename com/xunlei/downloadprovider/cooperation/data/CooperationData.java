package com.xunlei.downloadprovider.cooperation.data;

import java.io.Serializable;

public class CooperationData implements Serializable {
    private static final long serialVersionUID = 0;
    public CooperationItem mCooperationItem;
    public CooperationScene mCooperationScene;

    public CooperationData(CooperationItem cooperationItem, CooperationScene cooperationScene) {
        this.mCooperationItem = cooperationItem;
        this.mCooperationScene = cooperationScene;
    }
}
