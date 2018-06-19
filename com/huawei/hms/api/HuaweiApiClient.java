package com.huawei.hms.api;

import android.content.Context;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.Api.ApiOptions.HasOptions;
import com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions;
import com.huawei.hms.c.a;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class HuaweiApiClient implements ApiClient {

    public static final class Builder {
        private final Context a;
        private final List<Scope> b = new ArrayList();
        private final List<PermissionInfo> c = new ArrayList();
        private final Map<Api<?>, ApiOptions> d = new HashMap();
        private OnConnectionFailedListener e;
        private ConnectionCallbacks f;

        public Builder(Context context) throws NullPointerException {
            a.a(context, "context must not be null.");
            this.a = context.getApplicationContext();
        }

        public final HuaweiApiClient build() {
            HuaweiApiClient huaweiApiClientImpl = new HuaweiApiClientImpl(this.a);
            huaweiApiClientImpl.setScopes(this.b);
            huaweiApiClientImpl.setPermissionInfos(this.c);
            huaweiApiClientImpl.setApiMap(this.d);
            huaweiApiClientImpl.setConnectionCallbacks(this.f);
            huaweiApiClientImpl.setConnectionFailedListener(this.e);
            return huaweiApiClientImpl;
        }

        public final Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            a.a(connectionCallbacks, "listener must not be null.");
            this.f = connectionCallbacks;
            return this;
        }

        public final Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            a.a(onConnectionFailedListener, "listener must not be null.");
            this.e = onConnectionFailedListener;
            return this;
        }

        public final Builder addScope(Scope scope) {
            a.a(scope, "scope must not be null.");
            this.b.add(scope);
            return this;
        }

        public final Builder addApi(Api<? extends NotRequiredOptions> api) {
            this.d.put(api, null);
            return this;
        }

        public final <O extends HasOptions> Builder addApi(Api<O> api, O o) {
            a.a(api, "Api must not be null");
            a.a(o, "Null options are not permitted for this Api");
            this.d.put(api, o);
            if (api.getOptions() != null) {
                this.b.addAll(api.getOptions().getScopeList(o));
                this.c.addAll(api.getOptions().getPermissionInfoList(o));
            }
            return this;
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public abstract void connect();

    public abstract void disconnect();

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void setConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean setSubAppInfo(SubAppInfo subAppInfo);
}
