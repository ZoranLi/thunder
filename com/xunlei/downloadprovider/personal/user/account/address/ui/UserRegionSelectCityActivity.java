package com.xunlei.downloadprovider.personal.user.account.address.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.k;
import com.xunlei.downloadprovider.personal.user.account.address.a.e;
import com.xunlei.downloadprovider.personal.user.account.address.b.d;
import com.xunlei.downloadprovider.personal.user.account.address.c.a;
import com.xunlei.downloadprovider.personal.user.account.ui.UserAccountInfoActivity;
import com.xunlei.xllib.android.XLIntent;
import java.util.List;

public class UserRegionSelectCityActivity extends BaseActivity {
    private RecyclerView a;
    private List<a> c;
    private e d;
    private LoginHelper e = LoginHelper.a();
    private k f;
    private String g;
    private int h;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent();
        this.h = bundle.getIntExtra("provinceCode", -1);
        this.g = bundle.getStringExtra("province");
        this.c = d.a().a(this.h);
        setContentView(R.layout.activity_user_region_select);
        bundle = new TitleBar((Activity) this);
        bundle.mTitle.setText(getResources().getString(R.string.user_account_item_name_address));
        bundle.mRight1.setVisibility(0);
        bundle = this.c;
        this.a = (RecyclerView) findViewById(R.id.rcv_user_account_address);
        this.a.setLayoutManager(new LinearLayoutManager(this));
        this.d = new e(getApplicationContext(), bundle);
        this.a.setAdapter(this.d);
        this.d.a((View) LayoutInflater.from(this).inflate(R.layout.user_item_region_all, null));
        this.a.addOnItemTouchListener(new a(this.a, new c(this)));
    }

    public static void a(Context context, a aVar) {
        Intent intent = new Intent();
        intent.putExtra("provinceCode", aVar.b);
        intent.putExtra("province", aVar.a);
        intent.setClass(context, UserRegionSelectCityActivity.class);
        context.startActivity(intent);
    }

    public void onBackPressed() {
        super.onBackPressed();
        com.xunlei.downloadprovider.personal.user.account.k.c("cancel");
    }

    protected void onDestroy() {
        super.onDestroy();
        this.e.b(this.f);
    }

    static /* synthetic */ void d(UserRegionSelectCityActivity userRegionSelectCityActivity) {
        userRegionSelectCityActivity.f = new d(userRegionSelectCityActivity);
        userRegionSelectCityActivity.e.a(userRegionSelectCityActivity.f);
    }

    static /* synthetic */ void e(UserRegionSelectCityActivity userRegionSelectCityActivity) {
        userRegionSelectCityActivity.finish();
        Intent xLIntent = new XLIntent();
        xLIntent.setClass(userRegionSelectCityActivity, UserAccountInfoActivity.class);
        userRegionSelectCityActivity.startActivity(xLIntent);
    }
}
