package com.xunlei.downloadprovider.contentpublish.graphics.widget;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;

public class PhotoView extends FrameLayout {
    private ImageView a;
    private ImageView b;

    public PhotoView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public PhotoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PhotoView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.photo_publish_photo_view, this, true);
        this.a = (ImageView) context.findViewById(R.id.iv_delete);
        this.b = (ImageView) context.findViewById(R.id.iv_photo);
    }

    public void setOnDeleteOnClickListener(OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public ImageView getImageView() {
        return this.b;
    }
}
