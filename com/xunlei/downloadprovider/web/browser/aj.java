package com.xunlei.downloadprovider.web.browser;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import anet.channel.util.HttpConstant;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.downloadprovider.search.ui.widget.KeyboardHelpView;
import com.xunlei.downloadprovider.web.website.b.d;
import java.util.Iterator;

/* compiled from: BrowserTitleBarFragment */
final class aj implements TextWatcher {
    final /* synthetic */ a a;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    aj(a aVar) {
        this.a = aVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence) != null) {
            this.a.d.d;
            KeyboardHelpView.c();
            return;
        }
        this.a.d.d;
        KeyboardHelpView.c();
    }

    public final void afterTextChanged(Editable editable) {
        if (this.a.b != null && this.a.a != null) {
            Iterator it;
            int lastIndexOf;
            int lastIndexOf2;
            editable = this.a.b;
            editable.e.clear();
            editable.l.clear();
            CharSequence toLowerCase = editable.j.getText().toString().toLowerCase();
            if (toLowerCase != null) {
                it = editable.f.iterator();
                while (it.hasNext()) {
                    if (toLowerCase.equals((String) it.next())) {
                        toLowerCase = "";
                        editable.j.setText(toLowerCase);
                        break;
                    }
                }
            }
            if (toLowerCase.startsWith(IXAdRequestInfo.WIDTH) || toLowerCase.startsWith(IXAdRequestInfo.HEIGHT)) {
                for (String str : InputAutoCompleteView.a) {
                    if (str.startsWith(toLowerCase) && !str.equals(toLowerCase)) {
                        editable.l.add(new d(RePlugin.PROCESS_UI, str));
                    }
                }
            }
            if (!toLowerCase.startsWith(".")) {
                int lastIndexOf3 = toLowerCase.lastIndexOf(HttpConstant.SCHEME_SPLIT);
                lastIndexOf3 = lastIndexOf3 >= 0 ? lastIndexOf3 + 3 : 0;
                lastIndexOf2 = toLowerCase.lastIndexOf("/");
                if (!toLowerCase.endsWith(".")) {
                    lastIndexOf = toLowerCase.lastIndexOf(".");
                    int length = toLowerCase.length();
                    if (lastIndexOf >= 0) {
                        String[] strArr;
                        if (lastIndexOf2 >= lastIndexOf3) {
                            strArr = InputAutoCompleteView.c;
                        } else {
                            strArr = InputAutoCompleteView.b;
                        }
                        lastIndexOf++;
                        String substring = toLowerCase.substring(lastIndexOf, length);
                        for (String str2 : r1) {
                            if (str2.startsWith(substring) && !str2.equals(substring)) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(toLowerCase.substring(0, lastIndexOf));
                                stringBuilder.append(str2);
                                editable.l.add(new d(RePlugin.PROCESS_UI, stringBuilder.toString()));
                            }
                        }
                    }
                } else if (lastIndexOf2 >= lastIndexOf3) {
                    for (String str3 : InputAutoCompleteView.c) {
                        r6 = new StringBuilder();
                        r6.append(toLowerCase);
                        r6.append(str3);
                        editable.l.add(new d(RePlugin.PROCESS_UI, r6.toString()));
                    }
                } else if (!toLowerCase.endsWith("www.")) {
                    for (String str32 : InputAutoCompleteView.b) {
                        r6 = new StringBuilder();
                        r6.append(toLowerCase);
                        r6.append(str32);
                        editable.l.add(new d(RePlugin.PROCESS_UI, r6.toString()));
                    }
                }
            }
            it = editable.d.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.b.contains(toLowerCase) || dVar.c.contains(toLowerCase)) {
                    editable.l.add(dVar);
                }
            }
            editable.e.addAll(editable.l);
            editable.k.setVisibility(editable.e.size() > 0 ? 0 : 8);
            if (!com.xunlei.xllib.b.d.a(editable.e)) {
                editable.setVisibility(0);
            }
            editable.g.notifyDataSetChanged();
        }
    }
}
