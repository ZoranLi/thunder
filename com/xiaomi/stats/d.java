package com.xiaomi.stats;

import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.smack.c;
import com.xiaomi.smack.l;
import java.net.UnknownHostException;

final class d {

    static class a {
        com.xiaomi.push.thrift.a a;
        String b;

        a() {
        }
    }

    static a a(Exception exception) {
        Throwable a;
        e(exception);
        if (exception instanceof l) {
            l lVar = (l) exception;
            if (lVar.a() != null) {
                a = lVar.a();
            }
        }
        a aVar = new a();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.getClass().getSimpleName());
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(message);
        message = stringBuilder.toString();
        int a2 = c.a(a);
        if (a2 != 0) {
            aVar.a = com.xiaomi.push.thrift.a.a(com.xiaomi.push.thrift.a.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.a == null) {
            aVar.a = com.xiaomi.push.thrift.a.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == com.xiaomi.push.thrift.a.GSLB_TCP_ERR_OTHER) {
            aVar.b = message;
        }
        return aVar;
    }

    static a b(Exception exception) {
        Throwable a;
        com.xiaomi.push.thrift.a aVar;
        e(exception);
        if (exception instanceof l) {
            l lVar = (l) exception;
            if (lVar.a() != null) {
                a = lVar.a();
            }
        }
        a aVar2 = new a();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        int a2 = c.a(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.getClass().getSimpleName());
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(message);
        message = stringBuilder.toString();
        if (a2 != 0) {
            aVar2.a = com.xiaomi.push.thrift.a.a(com.xiaomi.push.thrift.a.CONN_SUCCESS.a() + a2);
            if (aVar2.a == com.xiaomi.push.thrift.a.CONN_BOSH_ERR) {
                a = a.getCause();
                if (a != null && (a instanceof UnknownHostException)) {
                    aVar = com.xiaomi.push.thrift.a.CONN_BOSH_UNKNOWNHOST;
                }
            }
            if (aVar2.a == com.xiaomi.push.thrift.a.CONN_TCP_ERR_OTHER || aVar2.a == com.xiaomi.push.thrift.a.CONN_XMPP_ERR || aVar2.a == com.xiaomi.push.thrift.a.CONN_BOSH_ERR) {
                aVar2.b = message;
            }
            return aVar2;
        }
        aVar = com.xiaomi.push.thrift.a.CONN_XMPP_ERR;
        aVar2.a = aVar;
        aVar2.b = message;
        return aVar2;
    }

    static a c(Exception exception) {
        Throwable a;
        com.xiaomi.push.thrift.a aVar;
        e(exception);
        if (exception instanceof l) {
            l lVar = (l) exception;
            if (lVar.a() != null) {
                a = lVar.a();
            }
        }
        a aVar2 = new a();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        int a2 = c.a(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.getClass().getSimpleName());
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(message);
        String stringBuilder2 = stringBuilder.toString();
        if (a2 == 105) {
            aVar = com.xiaomi.push.thrift.a.BIND_TCP_READ_TIMEOUT;
        } else if (a2 == 199) {
            aVar = com.xiaomi.push.thrift.a.BIND_TCP_ERR;
        } else if (a2 != 499) {
            switch (a2) {
                case 109:
                    aVar = com.xiaomi.push.thrift.a.BIND_TCP_CONNRESET;
                    break;
                case 110:
                    aVar = com.xiaomi.push.thrift.a.BIND_TCP_BROKEN_PIPE;
                    break;
                default:
                    aVar = com.xiaomi.push.thrift.a.BIND_XMPP_ERR;
                    break;
            }
        } else {
            aVar2.a = com.xiaomi.push.thrift.a.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar = com.xiaomi.push.thrift.a.BIND_BOSH_ITEM_NOT_FOUND;
            }
            if (aVar2.a == com.xiaomi.push.thrift.a.BIND_TCP_ERR || aVar2.a == com.xiaomi.push.thrift.a.BIND_XMPP_ERR || aVar2.a == com.xiaomi.push.thrift.a.BIND_BOSH_ERR) {
                aVar2.b = stringBuilder2;
            }
            return aVar2;
        }
        aVar2.a = aVar;
        aVar2.b = stringBuilder2;
        return aVar2;
    }

    static a d(Exception exception) {
        Throwable a;
        com.xiaomi.push.thrift.a aVar;
        e(exception);
        if (exception instanceof l) {
            l lVar = (l) exception;
            if (lVar.a() != null) {
                a = lVar.a();
            }
        }
        a aVar2 = new a();
        String message = a.getMessage();
        int a2 = c.a(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.getClass().getSimpleName());
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(message);
        String stringBuilder2 = stringBuilder.toString();
        if (a2 == 105) {
            aVar = com.xiaomi.push.thrift.a.CHANNEL_TCP_READTIMEOUT;
        } else if (a2 == 199) {
            aVar = com.xiaomi.push.thrift.a.CHANNEL_TCP_ERR;
        } else if (a2 != 499) {
            switch (a2) {
                case 109:
                    aVar = com.xiaomi.push.thrift.a.CHANNEL_TCP_CONNRESET;
                    break;
                case 110:
                    aVar = com.xiaomi.push.thrift.a.CHANNEL_TCP_BROKEN_PIPE;
                    break;
                default:
                    aVar = com.xiaomi.push.thrift.a.CHANNEL_XMPPEXCEPTION;
                    break;
            }
        } else {
            aVar2.a = com.xiaomi.push.thrift.a.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar = com.xiaomi.push.thrift.a.CHANNEL_BOSH_ITEMNOTFIND;
            }
            if (aVar2.a == com.xiaomi.push.thrift.a.CHANNEL_TCP_ERR || aVar2.a == com.xiaomi.push.thrift.a.CHANNEL_XMPPEXCEPTION || aVar2.a == com.xiaomi.push.thrift.a.CHANNEL_BOSH_EXCEPTION) {
                aVar2.b = stringBuilder2;
            }
            return aVar2;
        }
        aVar2.a = aVar;
        aVar2.b = stringBuilder2;
        return aVar2;
    }

    private static void e(Exception exception) {
        if (exception == null) {
            throw new NullPointerException();
        }
    }
}
