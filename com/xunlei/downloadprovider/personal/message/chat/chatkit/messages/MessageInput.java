package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.content.Context;
import android.support.v4.widget.Space;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class MessageInput extends RelativeLayout implements TextWatcher, OnClickListener {
    protected EditText a;
    protected TextView b;
    protected ImageButton c;
    protected Space d;
    protected Space e;
    private CharSequence f;
    private b g;
    private a h;

    public interface a {
    }

    public interface b {
        boolean a(CharSequence charSequence);
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public MessageInput(Context context) {
        super(context);
        a(context);
    }

    public MessageInput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MessageInput(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    public void setInputListener(b bVar) {
        this.g = bVar;
    }

    public void setAttachmentsListener(a aVar) {
        this.h = aVar;
    }

    public EditText getInputEditText() {
        return this.a;
    }

    public TextView getButton() {
        return this.b;
    }

    public final void a() {
        this.a.setText("");
    }

    public void onClick(View view) {
        if (view.getId() == R.id.messageSendButton) {
            view = (this.g == null || this.g.a(this.f) == null) ? null : true;
            if (view != null) {
                a();
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f = charSequence;
        this.b.setEnabled(this.f.toString().trim().length() > 0 ? 1 : 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        a(context);
        context = i.a(context, attributeSet);
        this.a.setMaxLines(context.n);
        this.a.setHint(context.o);
        this.a.setText(context.p);
        this.a.setTextSize(0, (float) context.q);
        this.a.setTextColor(context.r);
        this.a.setHintTextColor(context.s);
        this.a.setBackgroundDrawable(context.t);
        setCursor(context.u);
        int i = 8;
        this.c.setVisibility(context.d ? 0 : 8);
        this.c.setBackgroundDrawable(context.b());
        this.c.setImageDrawable(context.c());
        this.c.getLayoutParams().width = context.e;
        this.c.getLayoutParams().height = context.f;
        attributeSet = this.e;
        if (context.d) {
            i = 0;
        }
        attributeSet.setVisibility(i);
        this.e.getLayoutParams().width = context.g;
        this.b.setBackgroundDrawable(context.d());
        this.b.setText(context.j);
        this.b.setTextColor(context.l);
        this.b.setTextSize(0, (float) context.k);
        this.b.getLayoutParams().width = context.h;
        this.b.getLayoutParams().height = context.i;
        this.d.getLayoutParams().width = context.m;
        if (getPaddingLeft() == null && getPaddingRight() == null && getPaddingTop() == null && getPaddingBottom() == null) {
            setPadding(context.v, context.x, context.w, context.y);
        }
    }

    private void a(Context context) {
        inflate(context, R.layout.view_message_input, this);
        this.a = (EditText) findViewById(R.id.messageInput);
        this.b = (TextView) findViewById(R.id.messageSendButton);
        this.c = (ImageButton) findViewById(R.id.attachmentButton);
        this.d = (Space) findViewById(R.id.sendButtonSpace);
        this.e = (Space) findViewById(R.id.attachmentButtonSpace);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.a.addTextChangedListener(this);
        this.a.setText("");
    }

    private void setCursor(android.graphics.drawable.Drawable r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = android.widget.TextView.class;	 Catch:{ Exception -> 0x0012 }
        r1 = "mCursorDrawableRes";	 Catch:{ Exception -> 0x0012 }
        r0 = r0.getDeclaredField(r1);	 Catch:{ Exception -> 0x0012 }
        r1 = 1;	 Catch:{ Exception -> 0x0012 }
        r0.setAccessible(r1);	 Catch:{ Exception -> 0x0012 }
        r1 = r2.a;	 Catch:{ Exception -> 0x0012 }
        r0.set(r1, r3);	 Catch:{ Exception -> 0x0012 }
        return;
    L_0x0012:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.MessageInput.setCursor(android.graphics.drawable.Drawable):void");
    }
}
