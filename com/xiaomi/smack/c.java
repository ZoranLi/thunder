package com.xiaomi.smack;

import com.alibaba.wireless.security.SecExceptionCode;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class c {
    public static int a(Throwable th) {
        boolean z = th instanceof l;
        if (z) {
            l lVar = (l) th;
            if (lVar.a() != null) {
                th = lVar.a();
            }
        }
        String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        return th instanceof SocketTimeoutException ? 105 : th instanceof SocketException ? message.indexOf("Network is unreachable") != -1 ? 102 : message.indexOf("Connection refused") != -1 ? 103 : message.indexOf("Connection timed out") != -1 ? 105 : message.endsWith("EACCES (Permission denied)") ? 101 : message.indexOf("Connection reset by peer") != -1 ? 109 : message.indexOf("Broken pipe") != -1 ? 110 : message.indexOf("No route to host") != -1 ? 104 : message.endsWith("EINVAL (Invalid argument)") ? 106 : 199 : th instanceof UnknownHostException ? 107 : z ? SecExceptionCode.SEC_ERROR_STA_UNKNOWN_ERROR : 0;
    }
}
