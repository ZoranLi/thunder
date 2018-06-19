package com.bumptech.glide.integration.volley;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.integration.volley.VolleyUrlLoader.Factory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;
import java.io.InputStream;

public class VolleyGlideModule implements GlideModule {
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
    }

    public void registerComponents(Context context, Glide glide) {
        glide.register(GlideUrl.class, InputStream.class, new Factory(context));
    }
}
