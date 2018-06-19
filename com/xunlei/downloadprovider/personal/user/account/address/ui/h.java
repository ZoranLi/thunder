package com.xunlei.downloadprovider.personal.user.account.address.ui;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.b.e.b;
import com.xunlei.downloadprovider.personal.user.account.address.b.d;
import com.xunlei.downloadprovider.personal.user.account.address.c.a;
import java.util.List;

/* compiled from: UserRegionSelectProvinceActivity */
final class h implements b {
    final /* synthetic */ UserRegionSelectProvinceActivity a;

    h(UserRegionSelectProvinceActivity userRegionSelectProvinceActivity) {
        this.a = userRegionSelectProvinceActivity;
    }

    public final void a(String str, String str2) {
        if (!this.a.l) {
            String str3;
            this.a.i = str;
            UserRegionSelectProvinceActivity userRegionSelectProvinceActivity = this.a;
            d a = d.a();
            List<a> c = a.c();
            if (c != null) {
                loop0:
                for (a aVar : c) {
                    str3 = aVar.a;
                    int i = aVar.b;
                    if (str3.contains(str)) {
                        for (a aVar2 : a.a(i)) {
                            str3 = aVar2.a;
                            if (str3.contains(str2)) {
                                break loop0;
                            }
                        }
                        continue;
                    }
                }
            }
            str3 = null;
            userRegionSelectProvinceActivity.j = str3;
            Drawable drawable = ResourcesCompat.getDrawable(this.a.getResources(), R.drawable.user_location_success_icon, null);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.a.d.setCompoundDrawables(drawable, null, null, null);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" ");
                stringBuilder.append(str2);
                this.a.d.setText(stringBuilder.toString());
            }
        }
    }

    public final void a() {
        Drawable drawable = ResourcesCompat.getDrawable(this.a.getResources(), R.drawable.user_location_fail_icon, null);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.a.d.setCompoundDrawables(drawable, null, null, null);
            this.a.d.setText("定位失败，请在下方选择");
        }
    }
}
