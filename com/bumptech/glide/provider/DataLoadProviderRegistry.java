package com.bumptech.glide.provider;

import com.bumptech.glide.util.MultiClassKey;
import java.util.HashMap;
import java.util.Map;

public class DataLoadProviderRegistry {
    private static final MultiClassKey GET_KEY = new MultiClassKey();
    private final Map<MultiClassKey, DataLoadProvider<?, ?>> providers = new HashMap();

    public <T, Z> void register(Class<T> cls, Class<Z> cls2, DataLoadProvider<T, Z> dataLoadProvider) {
        this.providers.put(new MultiClassKey(cls, cls2), dataLoadProvider);
    }

    public <T, Z> DataLoadProvider<T, Z> get(Class<T> cls, Class<Z> cls2) {
        DataLoadProvider dataLoadProvider;
        synchronized (GET_KEY) {
            GET_KEY.set(cls, cls2);
            dataLoadProvider = (DataLoadProvider) this.providers.get(GET_KEY);
        }
        return dataLoadProvider == null ? EmptyDataLoadProvider.get() : dataLoadProvider;
    }
}
