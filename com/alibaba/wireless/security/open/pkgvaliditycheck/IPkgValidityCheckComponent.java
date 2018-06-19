package com.alibaba.wireless.security.open.pkgvaliditycheck;

import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;

public interface IPkgValidityCheckComponent extends IComponent {
    int checkEnvAndFiles(String... strArr) throws SecException;
}
