package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class LazyHeaders implements Headers {
    private volatile Map<String, String> combinedHeaders;
    private final Map<String, List<LazyHeaderFactory>> headers;

    public static final class Builder {
        private static final String DEFAULT_ENCODING = "identity";
        private static final Map<String, List<LazyHeaderFactory>> DEFAULT_HEADERS;
        private static final String DEFAULT_USER_AGENT = System.getProperty("http.agent");
        private static final String ENCODING_HEADER = "Accept-Encoding";
        private static final String USER_AGENT_HEADER = "User-Agent";
        private boolean copyOnModify = true;
        private Map<String, List<LazyHeaderFactory>> headers = DEFAULT_HEADERS;
        private boolean isEncodingDefault = true;
        private boolean isUserAgentDefault = true;

        static {
            Map hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(DEFAULT_USER_AGENT)) {
                hashMap.put("User-Agent", Collections.singletonList(new StringHeaderFactory(DEFAULT_USER_AGENT)));
            }
            hashMap.put("Accept-Encoding", Collections.singletonList(new StringHeaderFactory(DEFAULT_ENCODING)));
            DEFAULT_HEADERS = Collections.unmodifiableMap(hashMap);
        }

        public final Builder addHeader(String str, String str2) {
            return addHeader(str, new StringHeaderFactory(str2));
        }

        public final Builder addHeader(String str, LazyHeaderFactory lazyHeaderFactory) {
            if ((this.isEncodingDefault && "Accept-Encoding".equalsIgnoreCase(str)) || (this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(str))) {
                return setHeader(str, lazyHeaderFactory);
            }
            copyIfNecessary();
            getFactories(str).add(lazyHeaderFactory);
            return this;
        }

        public final Builder setHeader(String str, String str2) {
            return setHeader(str, str2 == null ? null : new StringHeaderFactory(str2));
        }

        public final Builder setHeader(String str, LazyHeaderFactory lazyHeaderFactory) {
            copyIfNecessary();
            if (lazyHeaderFactory == null) {
                this.headers.remove(str);
            } else {
                List factories = getFactories(str);
                factories.clear();
                factories.add(lazyHeaderFactory);
            }
            if (!(this.isEncodingDefault == null || "Accept-Encoding".equalsIgnoreCase(str) == null)) {
                this.isEncodingDefault = false;
            }
            if (!(this.isUserAgentDefault == null || "User-Agent".equalsIgnoreCase(str) == null)) {
                this.isUserAgentDefault = false;
            }
            return this;
        }

        private List<LazyHeaderFactory> getFactories(String str) {
            List<LazyHeaderFactory> list = (List) this.headers.get(str);
            if (list != null) {
                return list;
            }
            List arrayList = new ArrayList();
            this.headers.put(str, arrayList);
            return arrayList;
        }

        private void copyIfNecessary() {
            if (this.copyOnModify) {
                this.copyOnModify = false;
                this.headers = copyHeaders();
            }
        }

        public final LazyHeaders build() {
            this.copyOnModify = true;
            return new LazyHeaders(this.headers);
        }

        private Map<String, List<LazyHeaderFactory>> copyHeaders() {
            Map<String, List<LazyHeaderFactory>> hashMap = new HashMap(this.headers.size());
            for (Entry entry : this.headers.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList((Collection) entry.getValue()));
            }
            return hashMap;
        }
    }

    static final class StringHeaderFactory implements LazyHeaderFactory {
        private final String value;

        StringHeaderFactory(String str) {
            this.value = str;
        }

        public final String buildHeader() {
            return this.value;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("StringHeaderFactory{value='");
            stringBuilder.append(this.value);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof StringHeaderFactory)) {
                return null;
            }
            return this.value.equals(((StringHeaderFactory) obj).value);
        }

        public final int hashCode() {
            return this.value.hashCode();
        }
    }

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.headers = Collections.unmodifiableMap(map);
    }

    public final Map<String, String> getHeaders() {
        if (this.combinedHeaders == null) {
            synchronized (this) {
                if (this.combinedHeaders == null) {
                    this.combinedHeaders = Collections.unmodifiableMap(generateHeaders());
                }
            }
        }
        return this.combinedHeaders;
    }

    private Map<String, String> generateHeaders() {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.headers.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            List list = (List) entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(((LazyHeaderFactory) list.get(i)).buildHeader());
                if (i != list.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            hashMap.put(entry.getKey(), stringBuilder.toString());
        }
        return hashMap;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LazyHeaders{headers=");
        stringBuilder.append(this.headers);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LazyHeaders)) {
            return null;
        }
        return this.headers.equals(((LazyHeaders) obj).headers);
    }

    public final int hashCode() {
        return this.headers.hashCode();
    }
}
