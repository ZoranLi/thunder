package com.baidu.mobads.production;

import com.baidu.mobads.openad.c.d;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.d.c;

public class v extends a {
    public void a(c cVar, String str) {
        dispatchEvent(new d("URLLoader.Load.Complete", str, cVar.a()));
    }
}
