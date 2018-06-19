package com.xunlei.downloadprovider.search.ui.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.d.m;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.h.k.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.search.ui.widget.KeyboardHelpView;
import com.xunlei.downloadprovider.search.ui.widget.MultiSearchAssociativeView;
import com.xunlei.downloadprovider.search.ui.widget.SearchAssociativeView;
import com.xunlei.downloadprovider.search.ui.widget.SearchTitleBar;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;
import com.xunlei.downloadprovider.web.website.g.b;
import com.xunlei.downloadprovidershare.q;
import java.util.HashSet;
import java.util.Set;

public class SearchOperateActivity extends BaseActivity implements OnClickListener {
    private static final String h = "SearchOperateActivity";
    SearchTitleBar a;
    PageType c = PageType.NONE;
    View d;
    SearchAssociativeView e;
    MultiSearchAssociativeView f;
    CustomWebView g;
    private Toast i;
    private View j;
    private boolean k = true;
    private boolean l = true;
    private Handler m = new av(this);
    private View n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private KeyboardHelpView r;
    private String s = "";

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("Keyword");
        getWindow().setSoftInputMode((TextUtils.isEmpty(stringExtra) ? 4 : 2) | 32);
        setContentView(R.layout.search_operate_activity_layout);
        this.a = (SearchTitleBar) findViewById(R.id.title_bar);
        this.a.e = new bk(this);
        this.a.setOnEditorActionListener(new bl(this));
        Object obj = bq.a().a;
        if (!TextUtils.isEmpty(obj)) {
            this.a.setEditHint(obj);
        }
        findViewById(R.id.search_mask).setOnTouchListener(new bm(this));
        this.a.a.setOnClickListener(this);
        this.a.d.setOnClickListener(this);
        this.a.b.setOnClickListener(this);
        this.a.c.setOnClickListener(this);
        this.n = findViewById(R.id.search_clip_layout);
        this.n.setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.search_clip_image);
        this.o = (TextView) findViewById(R.id.search_clip_text);
        this.p = (TextView) findViewById(R.id.search_clip_hint);
        this.q = (ImageView) findViewById(R.id.search_clip_arrow);
        imageView.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.j = findViewById(R.id.fl_search_layout);
        this.g = (CustomWebView) findViewById(R.id.webView);
        this.g.setProgressType(3);
        this.g.a(new bi(this));
        this.e = (SearchAssociativeView) findViewById(R.id.search_associative_vie);
        this.f = (MultiSearchAssociativeView) findViewById(R.id.search_mul_associative_vie);
        this.d = findViewById(R.id.main_search_fragment);
        this.r = (KeyboardHelpView) findViewById(R.id.keyboard_help);
        KeyboardHelpView.a();
        this.r.setTextViewOnClickListener(new bj(this));
        if (this.a != null) {
            this.r.setEditText(this.a.b);
        }
        this.m.sendEmptyMessageDelayed(1, 50);
        this.m.sendEmptyMessageDelayed(2, 500);
        c();
        a(getIntent().getStringExtra("From"), stringExtra, 2);
        b.a().b();
    }

    protected void onResume() {
        super.onResume();
        k.b a = a.a(com.xunlei.downloadprovider.download.util.a.b(this));
        String trim = a.a != null ? a.a.trim() : null;
        if (!BrothersApplication.getApplicationInstance().getSharedPreferences("shared_save_text_from_clip_board", 0).getString("last_copy_text", "").equals(trim)) {
            if (TextUtils.isEmpty(trim)) {
                this.n.setVisibility(8);
                return;
            }
            int h = k.h(trim);
            if (h == 1) {
                String b = a.b(trim);
                this.o.setText(b);
                b(b);
                this.p.setHint("你最近复制的下载链接，点击下载");
                this.n.setVisibility(0);
            } else if (a.d(trim)) {
                if (trim.contains(" ")) {
                    trim = a.f(trim);
                }
                b(trim);
                this.o.setText(trim);
                this.p.setHint("你最近复制的网址，点击访问");
                this.n.setVisibility(0);
            } else if (q.a(trim)) {
                b(trim);
                if (!TextUtils.isEmpty(trim)) {
                    q.a(trim, new bg(this, trim));
                }
            } else if (h == 3) {
                this.o.setText(trim);
                b(trim);
                this.p.setHint("你最近复制的内容，点击搜索");
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            com.xunlei.downloadprovider.search.c.a.b(trim);
        }
    }

    private void b(String str) {
        this.s = str;
        BrothersApplication.getApplicationInstance().getSharedPreferences("shared_save_text_from_clip_board", 0).edit().putString("last_copy_text", str).apply();
    }

    private void c(String str) {
        if (this.i != null) {
            this.i.cancel();
        }
        this.i = Toast.makeText(this, str, 0);
        this.i.show();
    }

    public void onClick(View view) {
        view = view.getId();
        if (view != R.id.ll_delete_data) {
            switch (view) {
                case R.id.search_clip_image:
                case R.id.search_clip_text:
                case R.id.search_clip_hint:
                    if (TextUtils.isEmpty(this.s) == null && this.l != null) {
                        com.xunlei.downloadprovider.search.c.a.b(this.s, "content");
                        this.g.j();
                        a("search_page_copy", this.s, 2);
                        if (a.d(this.s) != null) {
                            com.xunlei.downloadprovider.search.c.a.b("search_page_copy", this.s, "website", "quanwang");
                        } else if (d(this.s) != null) {
                            com.xunlei.downloadprovider.search.c.a.b("search_page_copy", this.s, "word", "quanwang");
                        } else {
                            com.xunlei.downloadprovider.search.c.a.b("search_page_copy", this.s, "word", "zonghe");
                        }
                        this.n.setVisibility(8);
                        return;
                    }
                case R.id.search_clip_arrow:
                    com.xunlei.downloadprovider.search.c.a.b(this.s, "close");
                    this.n.setVisibility(8);
                    break;
                default:
                    boolean z = true;
                    switch (view) {
                        case R.id.search_back_btn:
                            com.xunlei.downloadprovider.search.c.a.a(b(), "cancel");
                            this.a.a();
                            if (this.f == null || this.f.d == null || this.f.d.a == null) {
                                finish();
                                return;
                            } else {
                                this.f.d.c();
                                return;
                            }
                        case R.id.go_to_search_btn:
                            int i;
                            String editTextContent = this.a.getEditTextContent();
                            if (TextUtils.isEmpty(editTextContent)) {
                                editTextContent = bq.a().a;
                                i = 1;
                            } else {
                                i = 0;
                            }
                            if (TextUtils.isEmpty(editTextContent)) {
                                c(getString(R.string.search_input_empty_toast));
                            } else if (this.l) {
                                this.g.j();
                                a("keyin_search", editTextContent, i);
                                if (a.d(editTextContent)) {
                                    com.xunlei.downloadprovider.search.c.a.b("keyin_search", editTextContent, "website", "quanwang");
                                } else {
                                    if (i != 1) {
                                        if (!d(editTextContent)) {
                                            com.xunlei.downloadprovider.search.c.a.a("keyin_search", editTextContent, "word", "zonghe", 0);
                                        }
                                    }
                                    com.xunlei.downloadprovider.search.c.a.a("keyin_search", editTextContent, "word", "quanwang", i);
                                }
                            }
                            this.n.setVisibility(8);
                            return;
                        case R.id.search_bar_edit_delete:
                            XLThreadPool.execute(new bn(this));
                            this.a.setEditText("");
                            view = bq.a().a;
                            SearchTitleBar searchTitleBar = this.a;
                            if (TextUtils.isEmpty(view) || view.equals("搜索或输入网址") != null) {
                                z = false;
                            }
                            searchTitleBar.a(z);
                            com.xunlei.downloadprovider.search.c.a.a(b(), "delete");
                            this.d.setVisibility(0);
                            MainSearchFragment mainSearchFragment = (MainSearchFragment) getSupportFragmentManager().findFragmentById(R.id.main_search_fragment);
                            if (!(mainSearchFragment == null || mainSearchFragment.a == null)) {
                                mainSearchFragment.a.a();
                            }
                            if (!(this.f == null || this.f.d == null || this.f.d.a == null)) {
                                this.f.d.c();
                                return;
                            }
                            break;
                        case R.id.search_really_edit:
                            com.xunlei.downloadprovider.search.c.a.a(b(), "bar");
                            return;
                        default:
                            break;
                    }
            }
        } else if (this.j != null) {
            this.j.setBackgroundResource(R.color.white);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
    }

    private String b() {
        switch (bf.a[this.c.ordinal()]) {
            case 1:
                return "search_think";
            case 2:
                return "search_prepare";
            case 3:
                return "search_result";
            default:
                return "search_prepare";
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.f == 0 || this.f.d == 0 || this.f.d.a == 0) {
            finish();
        } else {
            this.f.d.c();
        }
        return true;
    }

    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        super.startSearch(str, z, bundle, z2);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.m.hasMessages(2)) {
            this.m.removeMessages(2);
        }
        this.n.setVisibility(8);
        KeyboardHelpView.b();
    }

    final void a() {
        if (this.m.hasMessages(1)) {
            this.m.removeMessages(1);
        }
        if (this.m.hasMessages(2)) {
            this.m.removeMessages(2);
        }
        this.a.a();
    }

    private void c() {
        if (this.c != PageType.SEARCH_HISTORY) {
            this.g.setVisibility(8);
            this.g.j();
            if (this.f != null) {
                this.f.setVisibility(8);
            } else if (this.e != null) {
                this.e.setVisibility(8);
            }
            this.d.setVisibility(0);
            this.c = PageType.SEARCH_HISTORY;
        }
    }

    private static boolean d(String str) {
        String str2 = "";
        if (str.contains(" ")) {
            str2 = str.substring(str.indexOf(" ") + 1);
        }
        Set hashSet = new HashSet(m.a().b());
        if (str2.equals("") != null || hashSet.contains(str2) == null) {
            return null;
        }
        return true;
    }

    private void b(String str, String str2, int i) {
        if (i == 0) {
            com.xunlei.downloadprovider.web.a.a();
            com.xunlei.downloadprovider.web.a.a((Context) this, 22, str2, false, BrowserFrom.SEARCH_ENTER);
            XLThreadPool.execute(new ax(this, str2));
        } else if ("keyin_search".equals(str) != 0) {
            com.xunlei.downloadprovider.web.a.a();
            com.xunlei.downloadprovider.web.a.a((Context) this, 22, str2, false, BrowserFrom.SEARCH_DIRECT_SEARCH);
            XLThreadPool.execute(new ay(this, str2));
        } else if ("keyin".equals(str) != 0) {
            com.xunlei.downloadprovider.web.a.a();
            com.xunlei.downloadprovider.web.a.a((Context) this, 22, str2, false, BrowserFrom.SEARCH_DIRECT_KEYIN);
            XLThreadPool.execute(new az(this, str2));
        } else if ("search_page_copy".equals(str) != 0) {
            com.xunlei.downloadprovider.web.a.a();
            com.xunlei.downloadprovider.web.a.a((Context) this, 22, str2, false, BrowserFrom.SEARCH_COPY);
            XLThreadPool.execute(new ba(this, str2));
        } else {
            if ("search_think_zonghe".equals(str) != 0) {
                com.xunlei.downloadprovider.web.a.a();
                com.xunlei.downloadprovider.web.a.a((Context) this, 22, str2, false, BrowserFrom.SEARCH_THINK_LINK);
            } else if ("search_page_history".equals(str) != null) {
                com.xunlei.downloadprovider.web.a.a();
                com.xunlei.downloadprovider.web.a.a((Context) this, 22, str2, false, BrowserFrom.SEARCH_HIS);
            } else {
                com.xunlei.downloadprovider.web.a.a();
                com.xunlei.downloadprovider.web.a.a((Context) this, 22, str2, false, BrowserFrom.SEARCH_ENTER);
            }
            XLThreadPool.execute(new bb(this, str2));
        }
    }

    private void a(String str, String str2) {
        this.d.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String str3 = "search-event";
        if (str.equals("hot_event")) {
            str3 = "hot-event";
        } else {
            XLThreadPool.execute(new bc(this, str2));
        }
        if (this.c != PageType.SEARCH_RESULT) {
            this.c = PageType.SEARCH_RESULT;
        }
        this.g.setVisibility(0);
        StringBuilder stringBuilder = new StringBuilder(d.a().n.d("search_result_url"));
        stringBuilder.append("&ver=v2&peer_id=");
        stringBuilder.append(AndroidConfig.getPeerid());
        stringBuilder.append("&product_id=");
        stringBuilder.append(AndroidConfig.getProductId());
        stringBuilder.append("&version=11100&userid=");
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("&imei=");
        stringBuilder.append(AndroidConfig.getIMEI());
        stringBuilder.append("&isVip=");
        stringBuilder.append(LoginHelper.a().g.e());
        stringBuilder.append("&screenWidth=");
        stringBuilder.append(AndroidConfig.getScreenWidth());
        stringBuilder.append("&screenHeight=");
        stringBuilder.append(AndroidConfig.getScreenHeight());
        stringBuilder = new StringBuilder(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder("startSearch: from --> ");
        stringBuilder2.append(str);
        stringBuilder2.append(", entry --> ");
        stringBuilder2.append(str3);
        stringBuilder.append("&keyword=");
        stringBuilder.append(str2);
        stringBuilder.append("&entry=");
        stringBuilder.append(str3);
        stringBuilder.append("&from=");
        stringBuilder.append(str);
        stringBuilder.append("&timestamp=");
        stringBuilder.append(System.currentTimeMillis());
        this.g.a(stringBuilder.toString());
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, SearchOperateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        String str3 = "Keyword";
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        intent.putExtra(str3, str2);
        str2 = "From";
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        intent.putExtra(str2, str);
        context.startActivity(intent);
    }

    public final void a(String str, String str2, int i) {
        boolean z;
        if (!TextUtils.isEmpty(str2)) {
            if (!str2.matches("[\\s\t\r\n]*")) {
                z = false;
                if (!z) {
                    this.k = false;
                    if (i != 1) {
                        this.a.setEditText(str2);
                    }
                    a();
                    if (k.h(str2) == 1) {
                        com.xunlei.downloadprovider.download.b.a(getApplicationContext(), a.b(str2), "manual/search", "search", false);
                    } else if (a.d(str2)) {
                        b(str, str2, i);
                    } else if (i == 2) {
                        if (d(str2) != 0 || "search_page_copy".equals(str) == 0) {
                            a(str, str2);
                        }
                        com.xunlei.downloadprovider.web.a.a();
                        com.xunlei.downloadprovider.web.a.a((Context) this, 22, str2, false, BrowserFrom.SEARCH_COPY);
                        XLThreadPool.execute(new bp(this, str2));
                        return;
                    } else if (i == 1) {
                        b(str, str2, i);
                    } else if (d(str2) == 0) {
                        com.xunlei.downloadprovider.web.a.a();
                        com.xunlei.downloadprovider.web.a.a((Context) this, 22, str2, false, BrowserFrom.SEARCH_ENTER);
                        XLThreadPool.execute(new aw(this, str2));
                    } else {
                        a(str, str2);
                    }
                }
            }
        }
        z = true;
        if (z) {
            this.k = false;
            if (i != 1) {
                this.a.setEditText(str2);
            }
            a();
            if (k.h(str2) == 1) {
                com.xunlei.downloadprovider.download.b.a(getApplicationContext(), a.b(str2), "manual/search", "search", false);
            } else if (a.d(str2)) {
                b(str, str2, i);
            } else if (i == 2) {
                if (d(str2) != 0) {
                }
                a(str, str2);
            } else if (i == 1) {
                b(str, str2, i);
            } else if (d(str2) == 0) {
                a(str, str2);
            } else {
                com.xunlei.downloadprovider.web.a.a();
                com.xunlei.downloadprovider.web.a.a((Context) this, 22, str2, false, BrowserFrom.SEARCH_ENTER);
                XLThreadPool.execute(new aw(this, str2));
            }
        }
    }
}
