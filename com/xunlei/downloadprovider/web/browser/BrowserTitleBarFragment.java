package com.xunlei.downloadprovider.web.browser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.commonview.DownloadEntranceView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.c;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.download.center.widget.v;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.search.ui.widget.KeyboardHelpView;

public class BrowserTitleBarFragment extends Fragment implements OnClickListener {
    ProgressBar a;
    v b;
    EditText c;
    KeyboardHelpView d;
    TextView e;
    CooperationItem f;
    protected boolean g = false;
    final a h = new a(this);
    private String i;
    private String j;
    private b k;
    private DownloadEntranceView l;
    private View m;
    private TextView n;
    private TextView o;
    private View p;
    private View q;
    private View r;
    private View s;
    private LinearLayout t;
    private ImageView u;
    private CooperationItem v;
    private OnEditorActionListener w = new af(this);
    private TextWatcher x = new ag(this);
    private OnFocusChangeListener y = new ah(this);

    class a {
        boolean a = null;
        InputAutoCompleteView b;
        TextWatcher c = new aj(this);
        final /* synthetic */ BrowserTitleBarFragment d;

        a(BrowserTitleBarFragment browserTitleBarFragment) {
            this.d = browserTitleBarFragment;
        }

        public final void a() {
            if (this.b != null) {
                this.d.c.removeTextChangedListener(this.c);
                if (this.a) {
                    InputAutoCompleteView inputAutoCompleteView = this.b;
                    inputAutoCompleteView.startAnimation(AnimationUtils.loadAnimation(BrothersApplication.getApplicationInstance().getApplicationContext(), R.anim.autocomplete_view_hide));
                    inputAutoCompleteView.setVisibility(8);
                } else if (this.b.getVisibility() == 0) {
                    this.b.setVisibility(4);
                }
                this.a = false;
            }
        }
    }

    public interface b {
        void a(CooperationItem cooperationItem, boolean z);

        void a(String str);

        void c(boolean z);

        void onBrowserRefreshButtonClick(View view);

        void onBrowserStopButtonClick(View view);

        void onBrowserTitleBarBackButtonClick(View view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.i = getArguments().getString("title");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.fragment_browser_title_bar, viewGroup, false);
        this.n = (TextView) layoutInflater.findViewById(R.id.browser_title_bar_title);
        this.n.setOnClickListener(this);
        this.c = (EditText) layoutInflater.findViewById(R.id.browser_title_bar_address_input);
        this.c.addTextChangedListener(this.x);
        this.c.setOnFocusChangeListener(this.y);
        this.c.setOnEditorActionListener(this.w);
        this.o = (TextView) layoutInflater.findViewById(R.id.browser_title_bar_go);
        this.o.setOnClickListener(this);
        this.m = layoutInflater.findViewById(R.id.browser_title_bar_address_clear);
        this.m.setOnClickListener(this);
        this.a = (ProgressBar) layoutInflater.findViewById(R.id.browser_page_loading_progress);
        layoutInflater.findViewById(R.id.browser_title_bar_back).setOnClickListener(this);
        this.r = layoutInflater.findViewById(R.id.browser_title_bar_refresh);
        this.r.setOnClickListener(this);
        this.s = layoutInflater.findViewById(R.id.browser_title_bar_stop);
        this.s.setOnClickListener(this);
        this.r.setVisibility(0);
        this.s.setVisibility(8);
        this.l = (DownloadEntranceView) layoutInflater.findViewById(R.id.browser_title_bar_download_entrance);
        this.l.setOnClickListener(this);
        this.b = new v(this.l);
        this.p = layoutInflater.findViewById(R.id.browser_title_bar_content);
        this.q = layoutInflater.findViewById(R.id.browser_title_bar_content_editmode);
        this.e = (TextView) layoutInflater.findViewById(R.id.browser_title_bar_word);
        this.t = (LinearLayout) layoutInflater.findViewById(R.id.line_browser_title_bar_word);
        this.f = c.a().a(4);
        this.e.setVisibility(8);
        if (this.f != null) {
            this.e.setText(this.f.getCopyWriting());
            new StringBuilder("browserTitleBarWord =").append(this.f.getCopyWriting());
            this.e.setOnClickListener(this);
            this.t.setOnClickListener(this);
        }
        this.u = (ImageView) layoutInflater.findViewById(R.id.browser_title_check_button);
        this.v = c.a().a(25);
        this.u.setVisibility(8);
        if (this.v != null) {
            viewGroup = this.v.getAppIconUrl();
            ImageView imageView = this.u;
            Glide.with(imageView.getContext()).load(viewGroup).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
            new StringBuilder("mBrowserTitleCheckButton =").append(this.v.getCopyWriting());
            this.u.setOnClickListener(this);
            this.u.setVisibility(0);
            com.xunlei.downloadprovider.cooperation.a.a.a(l.c(this.v.getDisplayLocation()), this.v.getAppPackageName(), this.v.isShowInstallTip());
        }
        return layoutInflater;
    }

    public void onAttach(android.app.Activity r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        super.onAttach(r3);
        r0 = r3;	 Catch:{ ClassCastException -> 0x0009 }
        r0 = (com.xunlei.downloadprovider.web.browser.BrowserTitleBarFragment.b) r0;	 Catch:{ ClassCastException -> 0x0009 }
        r2.k = r0;	 Catch:{ ClassCastException -> 0x0009 }
        return;
    L_0x0009:
        r0 = new java.lang.ClassCastException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = r3.toString();
        r1.append(r3);
        r3 = " must implement OnFragmentInteractionListener";
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.BrowserTitleBarFragment.onAttach(android.app.Activity):void");
    }

    public void onDetach() {
        super.onDetach();
        this.k = null;
    }

    public void onResume() {
        super.onResume();
        if (this.b != null) {
            this.b.a();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.b != null) {
            this.b.b();
        }
        d();
    }

    public void onDestroy() {
        if (this.b != null) {
            this.b.b();
            this.b = null;
        }
        getActivity();
        KeyboardHelpView.b();
        super.onDestroy();
    }

    public final void a(String str) {
        if (str != null) {
            str = str.replace("-百度", "");
        }
        a(str, false);
    }

    public final void a(String str, boolean z) {
        this.i = str;
        if (this.n != null) {
            this.n.setText(str);
        }
        if (z) {
            b(str);
        }
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("about:blank")) {
            this.j = str;
        }
    }

    public final void a() {
        this.g = false;
        if (!(this.p.getVisibility() == 0 || this.k == null)) {
            this.k.c(false);
        }
        this.p.setVisibility(0);
        this.q.setVisibility(8);
        this.h.a();
    }

    public final boolean b() {
        return this.g;
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.o.setText(R.string.thunder_browser_button_title_cancel);
        } else if (com.xunlei.downloadprovider.h.k.a.d(str) != null) {
            this.o.setText(R.string.thunder_browser_button_title_go);
        } else {
            this.o.setText(R.string.thunder_browser_button_title_search);
        }
    }

    private java.lang.String e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.c;	 Catch:{ Exception -> 0x000b }
        r0 = r0.getText();	 Catch:{ Exception -> 0x000b }
        r0 = r0.toString();	 Catch:{ Exception -> 0x000b }
        return r0;
    L_0x000b:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.BrowserTitleBarFragment.e():java.lang.String");
    }

    public final java.lang.String c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.c;	 Catch:{ Exception -> 0x001b }
        r0 = r0.getSelectionStart();	 Catch:{ Exception -> 0x001b }
        r1 = r3.c;	 Catch:{ Exception -> 0x001b }
        r1 = r1.getSelectionEnd();	 Catch:{ Exception -> 0x001b }
        r2 = r3.c;	 Catch:{ Exception -> 0x001b }
        r2 = r2.getText();	 Catch:{ Exception -> 0x001b }
        r2 = r2.toString();	 Catch:{ Exception -> 0x001b }
        r0 = r2.substring(r0, r1);	 Catch:{ Exception -> 0x001b }
        return r0;
    L_0x001b:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.BrowserTitleBarFragment.c():java.lang.String");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.browser_title_bar_address_clear:
                this.c.setText("");
                this.c.requestFocus();
                return;
            case R.id.browser_title_bar_go:
                if (this.o.getText() == null || this.o.getText() != getResources().getText(R.string.thunder_browser_button_title_cancel)) {
                    view = e();
                    if (TextUtils.isEmpty(view)) {
                        Toast.makeText(getActivity(), R.string.browser_input_empty_tip, 0).show();
                        return;
                    } else if (this.k != null) {
                        this.k.a(view);
                        return;
                    }
                }
                a();
                return;
                break;
            case R.id.browser_title_bar_back:
                if (this.k != null) {
                    this.k.onBrowserTitleBarBackButtonClick(view);
                    return;
                }
                break;
            case R.id.browser_title_check_button:
                if (this.k != null) {
                    this.k.a(this.v, false);
                    break;
                }
                break;
            case R.id.browser_title_bar_title:
                this.g = true;
                if (this.p.getVisibility() == null) {
                    if (this.k != null) {
                        this.k.c(true);
                    }
                    this.p.setVisibility(8);
                    this.q.setVisibility(0);
                    c(this.j);
                    this.c.setText(this.j == null ? "" : this.j);
                    this.c.requestFocus();
                    view = this.h;
                    if (view.b != null) {
                        if (!(view.b.getVisibility() == 0)) {
                            view.d.c.addTextChangedListener(view.c);
                            view.b.a();
                            InputAutoCompleteView inputAutoCompleteView = view.b;
                            inputAutoCompleteView.e.clear();
                            inputAutoCompleteView.g.notifyDataSetChanged();
                            inputAutoCompleteView = view.b;
                            inputAutoCompleteView.startAnimation(AnimationUtils.loadAnimation(BrothersApplication.getApplicationInstance().getApplicationContext(), R.anim.autocomplete_view_show));
                            inputAutoCompleteView.setVisibility(0);
                            view.b.setViewHeight(false);
                            view.a = true;
                            view.d.c.requestFocus();
                        }
                    }
                    ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.c, 2);
                    return;
                }
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                if (this.j != null && this.j.equals(this.c.getText()) == null) {
                    this.c.setText(this.j);
                }
                if (!(this.c.hasFocus() == null || this.c.getText() == null || TextUtils.isEmpty(this.c.getText().toString()) != null)) {
                    this.c.selectAll();
                    this.c.scrollTo(0, 0);
                }
                c(this.j);
                return;
            case R.id.browser_title_bar_refresh:
                if (this.k != null) {
                    this.k.onBrowserRefreshButtonClick(view);
                    return;
                }
                break;
            case R.id.browser_title_bar_stop:
                if (this.k != null) {
                    this.k.onBrowserStopButtonClick(view);
                    return;
                }
                break;
            case R.id.line_browser_title_bar_word:
            case R.id.browser_title_bar_word:
                if (this.k != null) {
                    this.k.a(this.f, true);
                }
                return;
            case R.id.browser_title_bar_download_entrance:
                if (this.l.isUnreadShow() != null) {
                    n.a();
                    n.l();
                }
                com.xunlei.downloadprovider.download.a.a(getActivity(), DLCenterEntry.browser.toString());
                return;
            default:
                break;
        }
    }

    public final void a(boolean z) {
        if (this.a != null) {
            if (z) {
                this.a.setVisibility(0);
                return;
            }
            this.a.setVisibility(8);
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.r.setVisibility(8);
            this.s.setVisibility(0);
            return;
        }
        this.r.setVisibility(0);
        this.s.setVisibility(8);
    }

    public final void d() {
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
    }
}
