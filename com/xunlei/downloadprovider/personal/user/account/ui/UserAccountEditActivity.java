package com.xunlei.downloadprovider.personal.user.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.k;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.xllib.android.XLIntent;
import java.util.Timer;

public class UserAccountEditActivity extends BaseActivity {
    private int a = 0;
    private boolean c;
    private int d;
    private EditText e;
    private EditText f;
    private FrameLayout g;
    private TitleBar h;
    private LoginHelper i = LoginHelper.a();
    private k j;
    private TextWatcher k = new l(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = getIntent().getIntExtra("from_page", -1);
        setContentView(R.layout.activity_user_account_nickname);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_nick_name_edit);
        this.e = (EditText) findViewById(R.id.user_account_nickname_edit);
        this.f = (EditText) findViewById(R.id.user_account_signature_edit);
        this.g = (FrameLayout) findViewById(R.id.fl_nickname_delete);
        this.h = new TitleBar((Activity) this);
        this.h.mRight1.setVisibility(0);
        this.h.mRight1.setText("完成");
        switch (this.d) {
            case 1:
                relativeLayout.setVisibility(0);
                this.f.setVisibility(8);
                this.a = 45;
                this.h.mTitle.setText(getResources().getString(R.string.user_account_title_bar_nickname));
                b(this.e);
                break;
            case 2:
                relativeLayout.setVisibility(8);
                this.f.setVisibility(0);
                this.a = 90;
                this.h.mTitle.setText(getResources().getString(R.string.user_account_title_bar_signature));
                b(this.f);
                break;
            default:
                break;
        }
        this.h.mRight1.setOnClickListener(new h(this));
        this.h.mTitle.setOnClickListener(new i(this));
        this.g.setOnClickListener(new j(this));
        this.j = new k(this);
        this.i.a(this.j);
        if (this.d == 1) {
            this.e.addTextChangedListener(this.k);
        } else if (this.d == 2) {
            this.f.addTextChangedListener(this.k);
        }
        if (this.d == 1) {
            bundle = this.i.g.d().trim();
            if (m.a(bundle)) {
                bundle = "";
            }
            this.e.setText(m.a(bundle, this.a));
            a(this.e);
            return;
        }
        if (this.d == 2) {
            this.f.setText(m.a(this.i.h().trim(), this.a));
            a(this.f);
        }
    }

    private void a(EditText editText) {
        editText.setSelection(editText.getText().toString().length());
        editText.requestFocus();
        new Timer().schedule(new g(this), 300);
    }

    private void b(EditText editText) {
        if (TextUtils.isEmpty(editText.getText().toString().trim()) == null) {
            this.h.mRight1.setClickable(true);
            this.h.mRight1.setTextColor(getResources().getColor(R.color.user_nickname_finish_selector));
            if (this.d == 1) {
                this.g.setVisibility(0);
                return;
            }
        }
        this.h.mRight1.setClickable(false);
        this.h.mRight1.setTextColor(getResources().getColor(R.color.common_gray_btn_normal));
        this.g.setVisibility(4);
    }

    protected void onPause() {
        super.onPause();
        if (!this.c) {
            if (this.d == 1) {
                com.xunlei.downloadprovider.personal.user.account.k.b("account_center", "cancel");
            } else if (this.d == 2) {
                com.xunlei.downloadprovider.personal.user.account.k.b("cancel");
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.i.b(this.j);
    }

    public static void a(Context context, int i) {
        Intent xLIntent = new XLIntent(context, UserAccountEditActivity.class);
        xLIntent.putExtra("from_page", i);
        context.startActivity(xLIntent);
    }

    static /* synthetic */ void a(UserAccountEditActivity userAccountEditActivity, EditText editText, Editable editable) {
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.removeTextChangedListener(userAccountEditActivity.k);
        if (!TextUtils.isEmpty(editText.getText())) {
            while (m.b(editable.toString()) > userAccountEditActivity.a && selectionStart > 0) {
                editable.delete(selectionStart - 1, selectionEnd);
                selectionStart--;
                selectionEnd--;
                StringBuilder stringBuilder = new StringBuilder("editStart = ");
                stringBuilder.append(selectionStart);
                stringBuilder.append(" editEnd = ");
                stringBuilder.append(selectionEnd);
            }
        }
        editText.setText(editable.toString());
        editText.setSelection(selectionStart);
        editText.addTextChangedListener(userAccountEditActivity.k);
        userAccountEditActivity.b(editText);
    }
}
