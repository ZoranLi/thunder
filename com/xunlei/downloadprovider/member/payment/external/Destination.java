package com.xunlei.downloadprovider.member.payment.external;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.xunlei.xllib.android.XLIntent;
import java.io.Serializable;

public class Destination implements Serializable {
    public static final String EXTRA_SUCCESS_DESTINATION = "SuccessDestination";
    public static final String EXTRA_USER_DATA = "UserData";
    private static final long serialVersionUID = 2148374753L;
    private Class<? extends Activity> activityClass;
    private Object userData;

    public Destination(Class<? extends Activity> cls) {
        this.activityClass = cls;
    }

    public Class<? extends Activity> getActivityClass() {
        return this.activityClass;
    }

    public Object getUserData() {
        return this.userData;
    }

    public void setUserData(Object obj) {
        this.userData = obj;
    }

    public void go(Context context) {
        Intent xLIntent = new XLIntent(context, this.activityClass);
        Object obj = this.userData;
        if (obj != null) {
            if (obj instanceof Serializable) {
                xLIntent.putExtra(EXTRA_USER_DATA, (Serializable) obj);
            } else if (obj instanceof Parcelable) {
                xLIntent.putExtra(EXTRA_USER_DATA, (Parcelable) obj);
            }
        }
        xLIntent.addFlags(67108864);
        context.startActivity(xLIntent);
    }
}
