package com.xunlei.downloadprovider.personal.user;

import android.view.inputmethod.InputMethodManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.xunlei.downloadprovider.R;

/* compiled from: ReportActivity */
final class k implements OnCheckedChangeListener {
    final /* synthetic */ ReportActivity a;

    k(ReportActivity reportActivity) {
        this.a = reportActivity;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton radioButton = (RadioButton) this.a.findViewById(i);
        ReportActivity.a(this.a, radioButton.getText().toString());
        ReportActivity.a(this.a, Integer.parseInt((String) radioButton.getTag()));
        if (i == R.id.rbtn_other) {
            ReportActivity.a(this.a).requestFocus();
        } else {
            ReportActivity.b(this.a).requestFocus();
            ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(ReportActivity.a(this.a).getWindowToken(), 0);
        }
        ReportActivity.c(this.a);
    }
}
