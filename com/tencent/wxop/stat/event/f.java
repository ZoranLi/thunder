package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatGameUser;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class f extends e {
    private StatGameUser a = null;

    public f(Context context, int i, StatGameUser statGameUser, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.a = statGameUser.clone();
    }

    public EventType a() {
        return EventType.MTA_GAME_USER;
    }

    public boolean a(JSONObject jSONObject) {
        if (this.a == null) {
            return false;
        }
        r.a(jSONObject, "wod", this.a.getWorldName());
        r.a(jSONObject, "gid", this.a.getAccount());
        r.a(jSONObject, "lev", this.a.getLevel());
        return true;
    }
}
