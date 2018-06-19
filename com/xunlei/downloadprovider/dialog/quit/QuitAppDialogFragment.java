package com.xunlei.downloadprovider.dialog.quit;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.dialog.XLCheckBoxDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

public class QuitAppDialogFragment extends DialogFragment {
    public b a;
    public boolean b;
    public boolean c = (this.f ^ 1);
    public boolean d = n.d();
    public boolean e;
    private boolean f = com.xunlei.downloadprovider.personal.a.a.a().e();

    private static class a extends ClickableSpan {
        @ColorInt
        int a;
        OnClickListener b;

        public a(OnClickListener onClickListener, @ColorInt int i) {
            this.b = onClickListener;
            this.a = i;
        }

        public final void onClick(View view) {
            if (this.b != null) {
                this.b.onClick(view);
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.a);
            textPaint.setUnderlineText(true);
        }
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    public QuitAppDialogFragment() {
        n.a();
        LoginHelper.a();
        this.b = l.b();
        this.e = false;
        if (this.d) {
            a aVar = b.a;
        }
    }

    public static QuitAppDialogFragment a() {
        return new QuitAppDialogFragment();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.d != null) {
            if (this.e != null) {
                bundle = new com.xunlei.thunder.commonui.dialog.b(getContext());
                bundle.setTitle((int) R.string.quit_dlg_title);
                bundle.a((int) R.string.quit_dlg_content_battery_settings);
                bundle.b((int) R.string.quit_dlg_button_text_quit_immediate);
                bundle.d = new c(this);
                bundle.c(R.string.quit_dlg_button_text_battery_settings);
                bundle.b = new d(this);
                return bundle;
            }
            bundle = getString(R.string.quit_dlg_title);
            String string = getString(R.string.quit_dlg_content_downloading);
            XLCheckBoxDialog xLCheckBoxDialog = new XLCheckBoxDialog(getContext(), getString(R.string.quit_dlg_left_str), getString(R.string.quit_dlg_right_str));
            xLCheckBoxDialog.setTitle(bundle);
            xLCheckBoxDialog.setContent(null);
            xLCheckBoxDialog.setCheckStr(string);
            xLCheckBoxDialog.setChecked(true);
            xLCheckBoxDialog.setBtnLeftClickListener(new a(this, xLCheckBoxDialog));
            xLCheckBoxDialog.setBtnRightClickListener(new b(this, xLCheckBoxDialog));
            return xLCheckBoxDialog;
        } else if (this.f == null) {
            bundle = getString(R.string.quit_dlg_content_nosign);
            com.xunlei.thunder.commonui.dialog.b bVar = new com.xunlei.thunder.commonui.dialog.b(getContext());
            bVar.a(-1, 8);
            bVar.a(-3, 0);
            OnClickListener gVar = new g(this, bVar);
            r2 = getString(R.string.quit_dlg_content_gotosign);
            int color = getResources().getColor(R.color.commonui_text_color_accent);
            CharSequence spannableStringBuilder = new SpannableStringBuilder(r2);
            spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(new a(gVar, color), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.insert(0, bundle);
            bVar.setTitle((int) R.string.quit_dlg_title_nosign);
            if (bVar.a.c != null) {
                bVar.a.c.setText(spannableStringBuilder);
                bVar.a.c.setMovementMethod(LinkMovementMethod.getInstance());
            }
            bVar.b((int) R.string.quit_dlg_left_str_nosign);
            bVar.d = new h(this);
            bVar.d(R.string.quit_dlg_right_str_nosign);
            bVar.c = new i(this);
            return bVar;
        } else {
            CharSequence string2 = getString(R.string.quit_dlg_title);
            r2 = getString(R.string.quit_dlg_content);
            CharSequence string3 = getString(R.string.quit_dlg_left_str);
            CharSequence string4 = getString(R.string.quit_dlg_right_str);
            com.xunlei.thunder.commonui.dialog.b bVar2 = new com.xunlei.thunder.commonui.dialog.b(getContext());
            bVar2.setTitle(string2);
            bVar2.a(r2);
            bVar2.a(-1, 8);
            bVar2.a(-3, 0);
            bVar2.b(string3);
            bVar2.d = new e(this);
            if (bVar2.a.f != null) {
                bVar2.a.f.setText(string4);
            }
            bVar2.c = new f(this);
            return bVar2;
        }
    }

    static /* synthetic */ void c(QuitAppDialogFragment quitAppDialogFragment) {
        if (quitAppDialogFragment.a != null) {
            quitAppDialogFragment.a.a();
        }
    }

    static /* synthetic */ void d(QuitAppDialogFragment quitAppDialogFragment) {
        if (quitAppDialogFragment.a != null) {
            quitAppDialogFragment.a.b();
        }
    }

    static /* synthetic */ void f(QuitAppDialogFragment quitAppDialogFragment) {
        if (quitAppDialogFragment.a != null) {
            quitAppDialogFragment.a.c();
        }
    }
}
