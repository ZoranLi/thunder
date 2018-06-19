package anet.channel;

/* compiled from: Taobao */
public interface IAuth {

    /* compiled from: Taobao */
    public interface AuthCallback {
        void onAuthFail(int i, String str);

        void onAuthSuccess();
    }

    void auth(Session session, AuthCallback authCallback);
}
