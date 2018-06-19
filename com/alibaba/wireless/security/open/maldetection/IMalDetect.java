package com.alibaba.wireless.security.open.maldetection;

import com.alibaba.wireless.security.open.IComponent;

public interface IMalDetect extends IComponent {

    public interface ICallBack {
        void onDetection(int i, String str, String str2);
    }

    void registerCallBack(ICallBack iCallBack);

    void unregisterCallBack(ICallBack iCallBack);
}
