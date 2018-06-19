package com.xunlei.downloadprovider.search.ui.search;

import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.search.b.c;
import com.xunlei.downloadprovider.search.c.a;
import com.xunlei.downloadprovider.search.ui.widget.KeyboardHelpView;
import com.xunlei.downloadprovider.search.ui.widget.e;

/* compiled from: SearchOperateActivity */
final class bk implements TextWatcher {
    final /* synthetic */ SearchOperateActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    bk(SearchOperateActivity searchOperateActivity) {
        this.a = searchOperateActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String editTextContent = SearchOperateActivity.a(this.a).getEditTextContent();
        boolean z = true;
        if (TextUtils.isEmpty(editTextContent) != 0) {
            charSequence = bq.a().a;
            i = SearchOperateActivity.a(this.a);
            if (TextUtils.isEmpty(charSequence) || charSequence.equals("搜索或输入网址") != null) {
                z = false;
            }
            i.a(z);
            SearchOperateActivity.e(this.a);
            KeyboardHelpView.c();
            SearchOperateActivity.f(this.a);
        } else {
            SearchOperateActivity.a(this.a).a(true);
            SearchOperateActivity.e(this.a);
            KeyboardHelpView.c();
            if (SearchOperateActivity.g(this.a) != 0) {
                i = this.a;
                if (i.c != SearchOperateActivity$PageType.SEARCH_ASSOCIATIVE) {
                    i.g.setVisibility(8);
                    i.g.j();
                    i.d.setVisibility(8);
                    if (i.f != null) {
                        i.f.setVisibility(0);
                    } else if (i.e != null) {
                        i.e.setVisibility(0);
                    }
                    i.c = SearchOperateActivity$PageType.SEARCH_ASSOCIATIVE;
                    a.a();
                }
                if (i.f != null) {
                    if (i.f.d != null && i.f.d.a) {
                        i.f.d.c();
                    }
                    if (i.a == null || editTextContent.equals(i.a.getEditTextContent())) {
                        ab.f = "search_now";
                        i = i.f;
                        if (i.c != null) {
                            ab abVar = i.c;
                            abVar.b = true;
                            if (abVar.d != 0) {
                                i3 = abVar.d;
                                if (i3.a != null) {
                                    i3.a.clear();
                                }
                                i3.notifyDataSetChanged();
                            }
                            if (abVar.e != 0) {
                                abVar.e.a = null;
                            }
                            new StringBuilder("cancel  keyword: ").append(abVar.c);
                        }
                        i.c = new ab(i.b, editTextContent, i.a);
                        i.d.f = i.c;
                        if (TextUtils.isEmpty(editTextContent) == 0) {
                            i3 = i.a;
                            i3.c = false;
                            i3.b.show();
                            i3.a = null;
                            Handler handler = new Handler(i3.b.getContext().getMainLooper());
                            String str = ab.a;
                            i3.d = editTextContent;
                            i3.e.schedule(new c(i3, editTextContent, handler), 500);
                            charSequence = i.c;
                            new StringBuilder("loadMultiResult  keyword: ").append(charSequence.c);
                            c.a().a(charSequence.c, new ac(charSequence));
                            XLThreadPool.execute(new h(charSequence.c, charSequence, new ad(charSequence)));
                        }
                    } else {
                        i.a.setEditText(editTextContent);
                        ab.f = "search_his_wait";
                    }
                } else if (i.e != 0) {
                    i = i.e;
                    i.c = editTextContent;
                    if (i.b != 0) {
                        i.a(i.b.a, i.b.b, editTextContent);
                    }
                    if (TextUtils.isEmpty(editTextContent) != 0) {
                        i.a.a(null);
                    } else {
                        c.a().a(editTextContent, new e(i));
                    }
                }
            }
        }
        SearchOperateActivity.h(this.a);
        SearchOperateActivity.d(this.a).setVisibility(8);
    }
}
