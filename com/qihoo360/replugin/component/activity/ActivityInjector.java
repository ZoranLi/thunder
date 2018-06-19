package com.qihoo360.replugin.component.activity;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qihoo360.loader2.m;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.g;
import com.qihoo360.replugin.model.PluginInfo;

public class ActivityInjector {
    public static final String TAG = "activity-injector";

    public static boolean inject(Activity activity, String str, String str2) {
        PluginInfo a = m.a(str, false);
        if (a == null) {
            return false;
        }
        str = RePlugin.fetchComponentList(str);
        if (str == null) {
            return false;
        }
        ActivityInfo activity2 = str.getActivity(str2);
        if (activity2 == null || inject(activity, activity2, a.getFrameworkVersion()) == null) {
            return false;
        }
        return true;
    }

    private static boolean inject(Activity activity, ActivityInfo activityInfo, int i) {
        if (i >= 4) {
            injectTaskDescription(activity, activityInfo);
        }
        return true;
    }

    private static void injectTaskDescription(Activity activity, ActivityInfo activityInfo) {
        if (VERSION.SDK_INT >= 21 && activity != null) {
            if (activityInfo != null) {
                String str;
                if (c.a) {
                    str = TAG;
                    StringBuilder stringBuilder = new StringBuilder("activity = ");
                    stringBuilder.append(activity);
                    c.a(str, stringBuilder.toString());
                    str = TAG;
                    stringBuilder = new StringBuilder("ai = ");
                    stringBuilder.append(activityInfo);
                    c.a(str, stringBuilder.toString());
                }
                str = getLabel(activity, activityInfo);
                if (!TextUtils.isEmpty(str)) {
                    TaskDescription taskDescription;
                    activityInfo = getIcon(activity, activityInfo);
                    if (activityInfo != null) {
                        taskDescription = new TaskDescription(str, activityInfo);
                    } else {
                        taskDescription = new TaskDescription(str);
                    }
                    if (c.a != null) {
                        String str2 = TAG;
                        StringBuilder stringBuilder2 = new StringBuilder("td = ");
                        stringBuilder2.append(taskDescription);
                        c.a(str2, stringBuilder2.toString());
                    }
                    activity.setTaskDescription(taskDescription);
                }
            }
        }
    }

    private static String getLabel(Activity activity, ActivityInfo activityInfo) {
        activity = activity.getResources();
        String labelById = getLabelById(activity, activityInfo.labelRes);
        if (TextUtils.isEmpty(labelById)) {
            labelById = getLabelById(activity, activityInfo.applicationInfo.labelRes);
        }
        if (TextUtils.isEmpty(labelById) != null) {
            activity = g.a();
            labelById = getLabelById(activity.getResources(), activity.getApplicationInfo().labelRes);
        }
        if (c.a != null) {
            String str = TAG;
            activityInfo = new StringBuilder("label = ");
            activityInfo.append(labelById);
            c.a(str, activityInfo.toString());
        }
        return labelById;
    }

    private static String getLabelById(Resources resources, int i) {
        if (i == 0) {
            return null;
        }
        try {
            return resources.getString(i);
        } catch (Resources resources2) {
            resources2.printStackTrace();
            return null;
        }
    }

    private static Bitmap getIcon(Activity activity, ActivityInfo activityInfo) {
        activity = activity.getResources();
        Drawable iconById = getIconById(activity, activityInfo.icon);
        if (iconById == null) {
            iconById = getIconById(activity, activityInfo.applicationInfo.icon);
        }
        if (iconById == null) {
            activity = g.a();
            iconById = getIconById(activity.getResources(), activity.getApplicationInfo().icon);
        }
        activity = null;
        if ((iconById instanceof BitmapDrawable) != null) {
            activity = ((BitmapDrawable) iconById).getBitmap();
        }
        if (c.a != null) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("bitmap = ");
            stringBuilder.append(activity);
            c.a(str, stringBuilder.toString());
        }
        return activity;
    }

    private static Drawable getIconById(Resources resources, int i) {
        if (i == 0) {
            return null;
        }
        try {
            return resources.getDrawable(i);
        } catch (Resources resources2) {
            resources2.printStackTrace();
            return null;
        }
    }
}
