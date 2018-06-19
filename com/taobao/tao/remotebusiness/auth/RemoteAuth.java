package com.taobao.tao.remotebusiness.auth;

import com.taobao.tao.remotebusiness.a;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;

public class RemoteAuth {
    private static final String TAG = "mtop.rb-RemoteAuth";
    private static IRemoteAuth iRemoteAuth;

    class AuthHandler implements AuthListener {

        class Holder {
            static AuthHandler instance = new AuthHandler();

            private Holder() {
            }
        }

        private AuthHandler() {
        }

        public static AuthHandler instance() {
            return Holder.instance;
        }

        public void onAuthCancel(String str, String str2) {
            j.b("auth cancel");
            a.a(str, str2);
        }

        public void onAuthFail(String str, String str2) {
            j.b("auth fail");
            a.a(str, str2);
        }

        public void onAuthSuccess() {
            j.b("auth success");
            mtopsdk.xstate.a.a("accessToken", RemoteAuth.getAuthToken());
            a.a();
        }
    }

    public static void authorize(String str, String str2, String str3, boolean z) {
        if (iRemoteAuth != null && !iRemoteAuth.isAuthorizing()) {
            if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
                StringBuilder stringBuilder = new StringBuilder("call auth. bizId=");
                stringBuilder.append(str);
                stringBuilder.append(" apiInfo=");
                stringBuilder.append(str2);
                stringBuilder.append(" failInfo=");
                stringBuilder.append(str3);
                j.b(stringBuilder.toString());
            }
            iRemoteAuth.authorize(str, str2, str3, z, AuthHandler.instance());
        }
    }

    public static String getAuthToken() {
        return iRemoteAuth == null ? null : iRemoteAuth.getAuthToken();
    }

    public static boolean isAuthInfoValid() {
        return iRemoteAuth == null ? true : iRemoteAuth.isAuthorizing() ? false : iRemoteAuth.isAuthInfoValid();
    }

    public static void setAuthImpl(IRemoteAuth iRemoteAuth) {
        StringBuilder stringBuilder = new StringBuilder("set auth implement. remoteAuth=");
        stringBuilder.append(iRemoteAuth);
        j.a(stringBuilder.toString() != null ? iRemoteAuth.toString() : "null");
        iRemoteAuth = iRemoteAuth;
    }
}
