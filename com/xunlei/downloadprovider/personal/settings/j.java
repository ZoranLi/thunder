package com.xunlei.downloadprovider.personal.settings;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.xunlei.downloadprovider.player.a.c;

/* compiled from: AutoPlaySettingActivity */
final class j implements OnCheckedChangeListener {
    final /* synthetic */ AutoPlaySettingActivity a;

    j(AutoPlaySettingActivity autoPlaySettingActivity) {
        this.a = autoPlaySettingActivity;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        this.a.g = Integer.parseInt((String) this.a.findViewById(i).getTag());
        radioGroup = c.a();
        i = c.c;
        int a = this.a.g;
        if (radioGroup.a != null) {
            radioGroup.b = a;
            radioGroup = radioGroup.a.edit();
            radioGroup.putInt(i, a);
            radioGroup.apply();
        }
        AutoPlaySettingActivity.a(this.a.g);
    }
}
