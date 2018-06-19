package com.xunlei.downloadprovider.download.giftdispatch.widget;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.MotionEvent;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;

public final class GetGiftAlertDialog extends XLAlertDialog {
    private a a;
    private OnClickListener b = new e(this);
    private OnClickListener c = new f(this);

    public enum ResultType {
        get_failed,
        give_out
    }

    public interface a {
        void a();

        void b();

        void c();
    }

    public GetGiftAlertDialog(Context context, a aVar, ResultType resultType, boolean z) {
        super(context, R.style.ThunderTheme.Dialog);
        this.a = aVar;
        if (resultType.equals(ResultType.give_out) != null) {
            setCancelButtonHidden(true);
            setOnClickConfirmButtonListener(this.b);
            setMessage((CharSequence) z ? "你领过啦，可去我的礼包查看！" : "今日红包已领完，请明日再来");
            setConfirmButtonText((CharSequence) "确认");
            return;
        }
        setOnClickCancelButtonListener(this.c);
        setOnClickConfirmButtonListener(this.b);
        setMessage((CharSequence) "获取红包信息失败，请再试一次");
        setConfirmButtonText((CharSequence) "重试");
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (isOutOfBounds(getContext(), motionEvent)) {
            dismiss();
            if (this.a != null) {
                this.a.c();
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
