package com.getui.gtc.ui;

import android.content.Intent;
import com.getui.gtc.GtcActivity;
import com.getui.gtc.a.h;
import java.util.HashMap;
import java.util.Map;

public class UIManager {
    private static UIManager b;
    private Map a = new HashMap();

    private UIManager() {
    }

    private void a(UILogic uILogic) {
        if (uILogic != null) {
            this.a.put(uILogic.getActivityId(), uILogic);
        }
    }

    public static UIManager getInstance() {
        if (b == null) {
            b = new UIManager();
        }
        return b;
    }

    public UILogic findActivityLogic(Long l) {
        return (UILogic) this.a.get(l);
    }

    public Intent getStartActivityIntent(UILogic uILogic) {
        if (uILogic == null) {
            return null;
        }
        a(uILogic);
        Intent intent = new Intent(h.a, GtcActivity.class);
        intent.putExtra("activityid", uILogic.getActivityId());
        intent.setFlags(268435456);
        return intent;
    }

    public void removeActivityLogic(UILogic uILogic) {
        if (uILogic != null) {
            this.a.remove(uILogic.getActivityId());
        }
    }

    public void startActivityLogic(UILogic uILogic) {
        if (uILogic != null) {
            a(uILogic);
            Intent intent = new Intent(h.a, GtcActivity.class);
            intent.putExtra("activityid", uILogic.getActivityId());
            intent.setFlags(268435456);
            h.a.startActivity(intent);
        }
    }

    public void stopActivityLogic(UILogic uILogic) {
        if (uILogic != null) {
            uILogic.doStop();
            removeActivityLogic(uILogic);
        }
    }
}
