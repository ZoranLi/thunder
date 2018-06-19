package com.baidu.mobads.production.g;

import android.content.Context;
import android.os.Build.VERSION;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.production.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.g;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class e extends d {
    g a;

    public e(Context context, SlotType slotType) {
        super(context, null, slotType);
        this.a = XAdSDKFoundationFacade.getInstance().getAdConstants();
        this.b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        g(1);
        i((this.a.getAdCreativeTypeImage() + this.a.getAdCreativeTypeVideo()) + this.a.getAdCreativeTypeRichmedia());
        f(8);
        h(null);
    }

    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(IXAdRequestInfo.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
        if (c()) {
            hashMap.put("mimetype", "video/mp4,image/jpg,image/gif,image/png,rm/3d,rm/vr");
        } else {
            hashMap.put("mimetype", "video/mp4,image/jpg,image/gif,image/png,rm/3d");
        }
        return hashMap;
    }

    public String b() {
        return super.b();
    }

    private boolean c() {
        if (!a.r()) {
            return false;
        }
        try {
            ClassLoader a = a.a(this.d);
            Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView", false, a);
            Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView$OnGestureListener", false, a);
            Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView$OnBitmapLoadedListener", false, a);
            if (VERSION.SDK_INT >= 16) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            l.a().d(e);
            return false;
        }
    }
}
