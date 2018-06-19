package com.xunlei.downloadprovider.personal.user.account;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;

/* compiled from: ActionSheetHelper */
public final class a {

    /* compiled from: ActionSheetHelper */
    public interface a {
        void a(ImageView imageView, ImageView imageView2);
    }

    /* compiled from: ActionSheetHelper */
    public interface b {
        void a(int i);
    }

    public static Dialog a(Context context, int i) {
        i = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
        i.setMinimumWidth(10000);
        Dialog dialog = new Dialog(context, R.style.MMTheme.DataSheet);
        context = dialog.getWindow().getAttributes();
        context.x = 0;
        context.y = -1000;
        context.gravity = 80;
        dialog.onWindowAttributesChanged(context);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(i);
        return dialog;
    }
}
