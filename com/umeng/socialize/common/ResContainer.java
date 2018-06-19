package com.umeng.socialize.common;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public final class ResContainer {
    private static ResContainer R = null;
    private static String mPackageName = "";
    private Context context = null;
    private Map<String, SocializeResource> mResources;
    private Map<String, Integer> map = new HashMap();

    public static class SocializeResource {
        public int mId;
        public boolean mIsCompleted = false;
        public String mName;
        public String mType;

        public SocializeResource(String str, String str2) {
            this.mType = str;
            this.mName = str2;
        }
    }

    private ResContainer(Context context) {
        this.context = context.getApplicationContext();
    }

    public static synchronized ResContainer get(Context context) {
        synchronized (ResContainer.class) {
            if (R == null) {
                R = new ResContainer(context);
            }
            context = R;
        }
        return context;
    }

    public final int layout(String str) {
        return getResourceId(this.context, "layout", str);
    }

    public final int id(String str) {
        return getResourceId(this.context, AgooConstants.MESSAGE_ID, str);
    }

    public final int drawable(String str) {
        return getResourceId(this.context, "drawable", str);
    }

    public final int style(String str) {
        return getResourceId(this.context, "style", str);
    }

    public final int string(String str) {
        return getResourceId(this.context, "string", str);
    }

    public final int color(String str) {
        return getResourceId(this.context, "color", str);
    }

    public final int dimen(String str) {
        return getResourceId(this.context, "dimen", str);
    }

    public final int raw(String str) {
        return getResourceId(this.context, ShareConstants.DEXMODE_RAW, str);
    }

    public final int anim(String str) {
        return getResourceId(this.context, "anim", str);
    }

    public final int styleable(String str) {
        return getResourceId(this.context, "styleable", str);
    }

    public ResContainer(Context context, Map<String, SocializeResource> map) {
        this.mResources = map;
        this.context = context;
    }

    public static int getResourceId(Context context, String str, String str2) {
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(mPackageName)) {
            mPackageName = context.getPackageName();
        }
        context = resources.getIdentifier(str2, str, mPackageName);
        if (context > null) {
            return context;
        }
        throw new RuntimeException(UmengText.errorWithUrl(UmengText.resError(mPackageName, str, str2), UrlUtil.ALL_NO_RES));
    }

    public static String getString(Context context, String str) {
        return context.getString(getResourceId(context, "string", str));
    }

    public final synchronized Map<String, SocializeResource> batch() {
        if (this.mResources == null) {
            return this.mResources;
        }
        for (String str : this.mResources.keySet()) {
            SocializeResource socializeResource = (SocializeResource) this.mResources.get(str);
            socializeResource.mId = getResourceId(this.context, socializeResource.mType, socializeResource.mName);
            socializeResource.mIsCompleted = true;
        }
        return this.mResources;
    }

    public static int[] getStyleableArrts(Context context, String str) {
        return getResourceDeclareStyleableIntArray(context, str);
    }

    private static final int[] getResourceDeclareStyleableIntArray(Context context, String str) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(".R$styleable");
            for (Field field : Class.forName(stringBuilder.toString()).getFields()) {
                if (field.getName().equals(str)) {
                    return (int[]) field.get(null);
                }
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return null;
    }
}
