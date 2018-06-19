package com.umeng.socialize.net.stats;

import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.net.base.SocializeClient;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.net.stats.cache.UMCacheListener;
import com.umeng.socialize.net.stats.cache.b;
import com.umeng.socialize.net.stats.cache.c.a;
import com.umeng.socialize.utils.Log;
import java.net.URL;
import java.util.List;
import org.json.JSONArray;

public class StatsAPIs {
    private static SocializeClient mClient = new SocializeClient();

    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ String val$logFileName;
        final /* synthetic */ StatsLogRequest val$request;

        AnonymousClass2(StatsLogRequest statsLogRequest, String str) {
            this.val$request = statsLogRequest;
            this.val$logFileName = str;
        }

        public final void run() {
            SocializeReseponse execute = StatsAPIs.mClient.execute(this.val$request);
            if (execute != null && execute.isHttpOK()) {
                b.a().b(this.val$logFileName, null);
                StringBuilder stringBuilder = new StringBuilder("delete stats log");
                stringBuilder.append(this.val$logFileName);
                Log.d("StatsAPIs", stringBuilder.toString());
            }
        }
    }

    public static SocializeReseponse shareboardStats(StatsRequest statsRequest) {
        return mClient.execute(statsRequest);
    }

    public static SocializeReseponse shareStatsStart(ShareStatsRequest shareStatsRequest) {
        shareStatsRequest.setRequestPath(ShareLifecycle.START);
        SocializeReseponse execute = mClient.execute(shareStatsRequest);
        handleResponseForCache(false, shareStatsRequest, execute);
        return execute;
    }

    public static SocializeReseponse shareStatsEnd(ShareStatsRequest shareStatsRequest) {
        shareStatsRequest.setRequestPath(ShareLifecycle.END);
        SocializeReseponse execute = mClient.execute(shareStatsRequest);
        handleResponseForCache(false, shareStatsRequest, execute);
        return execute;
    }

    public static SocializeReseponse authStatsStart(AuthStatsRequest authStatsRequest) {
        authStatsRequest.setRequestPath(AuthLifecycle.START);
        SocializeReseponse execute = mClient.execute(authStatsRequest);
        handleResponseForCache(false, authStatsRequest, execute);
        return execute;
    }

    public static SocializeReseponse authStatsEnd(AuthStatsRequest authStatsRequest) {
        authStatsRequest.setRequestPath(AuthLifecycle.END);
        SocializeReseponse execute = mClient.execute(authStatsRequest);
        handleResponseForCache(false, authStatsRequest, execute);
        return execute;
    }

    public static SocializeReseponse userInfoStatsStart(UserInfoStatsRequest userInfoStatsRequest) {
        userInfoStatsRequest.setRequestPath(GetUserInfoLifecycle.START);
        SocializeReseponse execute = mClient.execute(userInfoStatsRequest);
        handleResponseForCache(false, userInfoStatsRequest, execute);
        return execute;
    }

    public static SocializeReseponse userInfoStatsEnd(UserInfoStatsRequest userInfoStatsRequest) {
        userInfoStatsRequest.setRequestPath(GetUserInfoLifecycle.END);
        SocializeReseponse execute = mClient.execute(userInfoStatsRequest);
        handleResponseForCache(false, userInfoStatsRequest, execute);
        return execute;
    }

    public static SocializeReseponse dauStats(DauStatsRequest dauStatsRequest) {
        SocializeReseponse execute = mClient.execute(dauStatsRequest);
        handleResponseForCache(true, dauStatsRequest, execute);
        return execute;
    }

    private static void handleResponseForCache(boolean z, SocializeRequest socializeRequest, SocializeReseponse socializeReseponse) {
        if (socializeReseponse != null) {
            if (socializeReseponse.isHttpOK() != null) {
                if (z) {
                    Log.d("StatsAPIs", "read stats log");
                    b.a().a(new UMCacheListener() {
                        public final void onResult(boolean z, a aVar) {
                            if (aVar != null) {
                                z = new JSONArray();
                                List b = aVar.b();
                                for (int i = 0; i < b.size(); i++) {
                                    z.put(b.get(i));
                                }
                                StatsAPIs.sendStatsCache(aVar.a(), z);
                            }
                        }
                    });
                }
                return;
            }
        }
        try {
            z = new URL(socializeRequest.toGetUrl()).getQuery();
            Log.d("StatsAPIs", "save stats log");
            b.a().a(z, null);
        } catch (boolean z2) {
            z2.printStackTrace();
        }
    }

    private static void sendStatsCache(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            if (jSONArray.length() > 0) {
                StringBuilder stringBuilder = new StringBuilder("send stats log:");
                stringBuilder.append(jSONArray.toString());
                Log.d("StatsAPIs", stringBuilder.toString());
                StatsLogRequest statsLogRequest = new StatsLogRequest(SocializeReseponse.class);
                statsLogRequest.addStringParams("data", jSONArray.toString());
                QueuedWork.runInBack(new AnonymousClass2(statsLogRequest, str), true);
            }
        }
    }
}
