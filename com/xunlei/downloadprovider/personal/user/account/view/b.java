package com.xunlei.downloadprovider.personal.user.account.view;

import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

/* compiled from: UserDatePickerDialog */
final class b implements OnDateChangedListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        this.a.e = i;
        this.a.f = i2 + 1;
        this.a.g = i3;
    }
}
