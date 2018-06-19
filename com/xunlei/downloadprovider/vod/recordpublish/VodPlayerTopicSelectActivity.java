package com.xunlei.downloadprovider.vod.recordpublish;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.encrypt.URLCoder;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.g.a.b;
import com.xunlei.downloadprovider.vod.manager.c;
import com.xunlei.downloadprovider.vod.recordpublish.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VodPlayerTopicSelectActivity extends BaseActivity implements OnClickListener {
    private static final CharSequence a = "#";
    private String c;
    private EditText d;
    private a e;
    private FlowLayout f;
    private OnClickListener g;
    private LinearLayout h;
    private RecyclerView i;
    private TextView j;
    private List<com.xunlei.downloadprovider.vod.recordpublish.topicsearch.a> k;
    private z l;
    private LinearLayoutManager m;
    private ab n;
    private com.xunlei.downloadprovider.vod.manager.a o;
    private boolean p = false;
    private VodTopicSearchBar q;
    private TextView r;
    private ImageView s;
    private View t;
    private Handler u = new Handler();
    private LoaderCallbacks<List<String>> v = new o(this);

    public static class a extends AsyncTaskLoader<List<String>> {
        String a;
        private Context b;
        private List<String> c;
        private boolean d = true;
        private com.xunlei.downloadprovider.vod.manager.a e = new com.xunlei.downloadprovider.vod.manager.a();

        public final /* synthetic */ void deliverResult(Object obj) {
            a((List) obj);
        }

        public final /* bridge */ /* synthetic */ void onCanceled(Object obj) {
            super.onCanceled((List) obj);
        }

        public a(Context context, String str) {
            super(context);
            this.a = str;
            this.b = context;
            this.d = true;
        }

        private void a(List<String> list) {
            isReset();
            this.c = list;
            if (isStarted()) {
                super.deliverResult(list);
            }
        }

        protected final void onStartLoading() {
            if (this.c != null) {
                a(this.c);
            }
            if (takeContentChanged() || this.c == null) {
                forceLoad();
            }
        }

        protected final void onStopLoading() {
            cancelLoad();
        }

        protected final void onReset() {
            super.onReset();
            onStopLoading();
            if (this.c != null) {
                this.c = null;
            }
        }

        public final /* synthetic */ Object loadInBackground() {
            if (!this.d) {
                return null;
            }
            Object arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.a)) {
                arrayList = this.e.a(this.a);
                if (arrayList.size() > 0) {
                    b.a(URLCoder.encode(this.a, null), "success", arrayList.size());
                } else {
                    b.a(URLCoder.encode(this.a, null), "fail", 0);
                }
            }
            return arrayList;
        }
    }

    public static void a(Activity activity, String str) {
        Intent intent = new Intent(activity, VodPlayerTopicSelectActivity.class);
        intent.putExtra("topic", str);
        activity.startActivityForResult(intent, null);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vod_activity_topic_select);
        bundle = getIntent();
        if (bundle != null) {
            this.c = bundle.getStringExtra("topic");
        }
        if (this.c == null) {
            this.c = "";
        }
        findViewById(R.id.vod_topic_select_back).setOnClickListener(this);
        findViewById(R.id.xlps_topbar_title);
        this.r = (TextView) findViewById(R.id.xlps_topbar_right_tv);
        this.r.setVisibility(0);
        this.s = (ImageView) findViewById(R.id.vod_topic_select_back);
        if (this.r != null) {
            this.r.setOnClickListener(this);
        }
        if (this.s != null) {
            this.s.setOnClickListener(this);
        }
        this.t = findViewById(R.id.xlps_topbar_divider);
        this.t.setVisibility(0);
        this.g = new p(this);
        this.f = (FlowLayout) findViewById(R.id.tags);
        this.q = (VodTopicSearchBar) findViewById(R.id.xlps_topic_search_bar);
        this.q.setOnFocusChangeListener(new q(this));
        this.q.setHideCancelView(true);
        this.q.setEditHint("搜索话题");
        this.q.setSearchTip("搜索话题");
        this.d = this.q.a;
        bundle = new r(this);
        this.d.setFilters(new InputFilter[]{new a(12, bundle)});
        this.d.setOnEditorActionListener(new s(this));
        this.q.setEditText(this.c);
        if (TextUtils.isEmpty(this.c) == null) {
            this.d.setSelection(this.d.getText().length());
        }
        this.d.addTextChangedListener(new t(this));
        this.h = (LinearLayout) findViewById(R.id.xlps_hot_topic_ly);
        this.j = (TextView) findViewById(R.id.xlps_hot_topic_tv);
        this.i = (RecyclerView) findViewById(R.id.xlps_hot_topic_rv);
        this.k = new ArrayList();
        this.l = new z(this, this.k);
        this.l.a = new v(this);
        this.i.setAdapter(this.l);
        this.m = new LinearLayoutManager(this);
        this.m.setOrientation(1);
        this.i.setLayoutManager(this.m);
        this.n = new ab();
        this.i.addItemDecoration(this.n);
        bundle = new w(this);
        this.o = new com.xunlei.downloadprovider.vod.manager.a();
        com.xunlei.downloadprovider.vod.manager.a aVar = this.o;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c.a());
        stringBuilder.append("api/topic/list");
        String stringBuilder2 = stringBuilder.toString();
        Map hashMap = new HashMap();
        hashMap.put("pageSize", "20");
        hashMap.put("startCreateTime", "9223372036854775807");
        hashMap.put("order", "desc");
        aVar.a.a(stringBuilder2, "1.0", hashMap, new com.xunlei.downloadprovider.vod.manager.b(aVar, bundle));
        bundle = new Bundle();
        bundle.putString("topic", this.c);
        getLoaderManager().initLoader(0, bundle, this.v);
        b.a();
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            TextView textView = (TextView) LayoutInflater.from(this).inflate(R.layout.xlps_layout_publish_tags, null, false);
            textView.setText(c(str));
            textView.setOnClickListener(this.g);
            this.f.addView(textView);
        }
    }

    private static String c(String str) {
        StringBuilder stringBuilder = new StringBuilder("#");
        stringBuilder.append(str);
        stringBuilder.append("#");
        return stringBuilder.toString();
    }

    private void a(String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("topic", str);
        intent.putExtra("ylvalue", i);
        setResult(-1, intent);
        finish();
    }

    protected void onResume() {
        super.onResume();
        this.d.clearFocus();
    }

    protected void onPause() {
        super.onPause();
        this.d.clearFocus();
    }

    protected void onDestroy() {
        super.onDestroy();
        getLoaderManager().destroyLoader(0);
    }

    public void onBackPressed() {
        a();
        a("", 0);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view != R.id.vod_topic_select_back) {
            if (view == R.id.xlps_topbar_right_tv) {
                this.c = this.d.getText().toString().trim();
                a();
                a(this.c, 0);
            }
            return;
        }
        a();
        a("", 0);
    }

    private void a() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (this.d != null) {
            inputMethodManager.hideSoftInputFromWindow(this.d.getWindowToken(), 2);
        }
    }

    static /* synthetic */ void a(VodPlayerTopicSelectActivity vodPlayerTopicSelectActivity, List list) {
        vodPlayerTopicSelectActivity.f.removeAllViews();
        if (list != null) {
            if (list.size() != 0) {
                if (list != null) {
                    if (list.isEmpty()) {
                        vodPlayerTopicSelectActivity.b(vodPlayerTopicSelectActivity.d.getText().toString().trim());
                    }
                    for (String str : list) {
                        if (!TextUtils.isEmpty(str) && str.length() <= 12) {
                            vodPlayerTopicSelectActivity.b(str);
                        }
                    }
                }
                vodPlayerTopicSelectActivity.f.requestLayout();
            }
        }
    }
}
