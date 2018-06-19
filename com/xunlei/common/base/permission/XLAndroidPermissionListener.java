package com.xunlei.common.base.permission;

import java.util.List;

public interface XLAndroidPermissionListener {
    void onDenied(List<String> list);

    void onGranted();
}
