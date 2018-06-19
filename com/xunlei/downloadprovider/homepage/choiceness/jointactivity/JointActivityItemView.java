package com.xunlei.downloadprovider.homepage.choiceness.jointactivity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.xunlei.downloadprovider.R;

public class JointActivityItemView extends RelativeLayout {
    private a a;

    public interface a {
        void a();
    }

    public JointActivityItemView(Context context) {
        this(context, null, 0);
    }

    public JointActivityItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public JointActivityItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context = LayoutInflater.from(context).inflate(R.layout.joint_activity_item_view, this, 1);
        context.findViewById(R.id.joint_activity_item_close_ic).setOnClickListener(new j(this));
        context.setOnClickListener(new k(this));
    }

    public void setIJointActivityItemCallback(a aVar) {
        this.a = aVar;
    }
}
