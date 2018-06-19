package com.baidu.mobads.command;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public abstract class b {
    protected Context a;
    protected IXNonLinearAdSlot b;
    protected IXAdInstanceInfo c;
    protected IXAdResource d;
    protected IXAdLogger e = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public b(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource) {
        this.b = iXNonLinearAdSlot;
        if (iXNonLinearAdSlot != null) {
            this.a = iXNonLinearAdSlot.getApplicationContext();
        } else {
            this.a = XAdSDKFoundationFacade.getInstance().getApplicationContext();
        }
        this.c = iXAdInstanceInfo;
        this.d = iXAdResource;
    }
}
