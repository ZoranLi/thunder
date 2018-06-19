package com.igexin.push.core.a.a;

import com.igexin.push.core.b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import org.json.JSONObject;

public interface a {
    b a(PushTaskBean pushTaskBean, BaseAction baseAction);

    BaseAction a(JSONObject jSONObject);

    boolean b(PushTaskBean pushTaskBean, BaseAction baseAction);
}
