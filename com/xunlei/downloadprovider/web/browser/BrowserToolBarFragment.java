package com.xunlei.downloadprovider.web.browser;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cooperation.c;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.d.l;
import com.xunlei.downloadprovider.web.website.activity.BroserCollectionAndHistoryActivity;

public class BrowserToolBarFragment extends Fragment implements OnClickListener {
    public final a a = new a(this);
    View b;
    OnClickListener c;
    private b d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private RelativeLayout n;
    private ImageView o;
    private CooperationItem p;
    private boolean q = true;

    class a {
        OnClickListener a;
        final /* synthetic */ BrowserToolBarFragment b;
        private a c = new a(this);
        private String d;

        class a {
            public boolean a;
            public boolean b;
            boolean c = null;
            final /* synthetic */ a d;

            a(a aVar) {
                this.d = aVar;
            }
        }

        public a(BrowserToolBarFragment browserToolBarFragment) {
            this.b = browserToolBarFragment;
        }

        public final void a(boolean z) {
            this.c.c = z;
            a(this.c.a, this.c.c);
        }

        private void a(boolean z, boolean z2) {
            if (this.c != null) {
                this.c.a = z;
                this.c.b = z2;
                if (this.c.a) {
                    this.b.i.setEnabled(true);
                    this.b.i.setSelected(this.c.b);
                    return;
                }
                this.b.i.setEnabled(false);
                this.b.i.setSelected(false);
            }
        }

        public final void a(String str) {
            if (str == null) {
                this.d = "";
                return;
            }
            this.d = str;
            Object obj = null;
            if (str != null) {
                obj = str.trim();
            }
            if (obj != null && obj.endsWith("/")) {
                obj = obj.substring(0, obj.length() - 1);
            }
            if ("http://m.sjzhushou.com/v2/site/site_add_2.4.html".equals(obj)) {
                a(false, this.c.c);
            } else {
                a(true, this.c.c);
            }
            a(com.xunlei.downloadprovider.web.website.g.b.a().a(str));
        }

        public final void a() {
            if (this.a != null) {
                this.a.onClick(null);
            }
        }

        static /* synthetic */ void a(a aVar, String str) {
            Toast toast = new Toast(aVar.b.getActivity());
            aVar = LayoutInflater.from(aVar.b.getActivity()).inflate(R.layout.download_success_toast, null);
            ((TextView) aVar.findViewById(R.id.tv_title)).setText(str);
            toast.setView(aVar);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.show();
        }
    }

    public interface b {
        void a(CooperationItem cooperationItem);

        void onBrowserGoBackButtonClick(View view);

        void onBrowserGoForwardButtonClick(View view);
    }

    public static void a() {
    }

    public final void a(boolean z) {
        if (this.e != null) {
            this.e.setEnabled(z);
        }
        if (this.j != null) {
            this.j.setEnabled(z);
        }
    }

    public final void b(boolean z) {
        if (this.f != null) {
            this.f.setEnabled(z);
        }
        if (this.k != null) {
            this.k.setEnabled(z);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.fragment_browser_tool_bar, viewGroup, false);
        this.e = layoutInflater.findViewById(R.id.browser_tool_bar_goback);
        this.j = layoutInflater.findViewById(R.id.browser_tool_bar_goback_container);
        this.e.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.f = layoutInflater.findViewById(R.id.browser_tool_bar_goforward);
        this.k = layoutInflater.findViewById(R.id.browser_tool_bar_goforward_container);
        this.f.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.g = layoutInflater.findViewById(R.id.browser_tool_bar_favoritefolder);
        this.l = layoutInflater.findViewById(R.id.browser_tool_bar_favoritefolder_container);
        this.g.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.h = layoutInflater.findViewById(R.id.browser_tool_bar_share);
        this.m = layoutInflater.findViewById(R.id.browser_tool_bar_share_container);
        this.h.setOnClickListener(this);
        this.m.setOnClickListener(this);
        if (l.a().d() != null) {
            this.g.setVisibility(8);
            this.l.setVisibility(8);
        } else {
            this.h.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.o = (ImageView) layoutInflater.findViewById(R.id.browser_tool_bar_browserIcon);
        this.n = (RelativeLayout) layoutInflater.findViewById(R.id.re_browser_tool_bar_browserIcon);
        this.p = c.a().a(5);
        if (this.p != null) {
            this.n.setVisibility(0);
            this.o.setOnClickListener(this);
            this.n.setOnClickListener(this);
            viewGroup = this.p.getAppIconUrl();
            bundle = this.o;
            Glide.with(bundle.getContext()).load(viewGroup).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(bundle);
            com.xunlei.downloadprovider.cooperation.a.a.a(com.xunlei.downloadprovider.cooperation.l.c(this.p.getDisplayLocation()), this.p.getAppPackageName(), this.p.isShowInstallTip());
        } else {
            this.n.setVisibility(8);
        }
        this.i = layoutInflater.findViewById(R.id.browser_tool_bar_favorite);
        this.b = layoutInflater.findViewById(R.id.browser_tool_bar_favorite_container);
        this.i.setOnClickListener(this);
        this.b.setOnClickListener(this);
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
        r0 = (com.xunlei.downloadprovider.web.browser.BrowserToolBarFragment.b) r0;	 Catch:{ ClassCastException -> 0x0009 }
        r2.d = r0;	 Catch:{ ClassCastException -> 0x0009 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.BrowserToolBarFragment.onAttach(android.app.Activity):void");
    }

    public void onDetach() {
        super.onDetach();
        this.d = null;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.browser_tool_bar_goback_container:
                if (this.d != null) {
                    this.d.onBrowserGoBackButtonClick(view);
                    return;
                }
                break;
            case R.id.browser_tool_bar_goback:
                if (this.d != null) {
                    this.d.onBrowserGoBackButtonClick(view);
                    return;
                }
                break;
            case R.id.browser_tool_bar_goforward_container:
                if (this.d != null) {
                    this.d.onBrowserGoForwardButtonClick(view);
                    return;
                }
                break;
            case R.id.browser_tool_bar_goforward:
                if (this.d != null) {
                    this.d.onBrowserGoForwardButtonClick(view);
                    return;
                }
                break;
            case R.id.browser_tool_bar_favorite_container:
                this.a.a();
                return;
            case R.id.browser_tool_bar_favorite:
                this.a.a();
                return;
            case R.id.browser_tool_bar_favoritefolder_container:
                aa.a();
                BroserCollectionAndHistoryActivity.a(getActivity());
                return;
            case R.id.browser_tool_bar_favoritefolder:
                aa.a();
                BroserCollectionAndHistoryActivity.a(getActivity());
                return;
            case R.id.browser_tool_bar_share_container:
                b();
                return;
            case R.id.browser_tool_bar_share:
                b();
                return;
            case R.id.re_browser_tool_bar_browserIcon:
            case R.id.browser_tool_bar_browserIcon:
                if (this.d != null) {
                    this.d.a(this.p);
                    break;
                }
                break;
            default:
                break;
        }
    }

    private void b() {
        if (this.c != null && this.q) {
            this.c.onClick(null);
            this.q = false;
            new Handler().postDelayed(new al(this), 1000);
        }
    }
}
