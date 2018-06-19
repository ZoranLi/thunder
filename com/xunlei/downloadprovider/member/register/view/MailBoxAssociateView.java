package com.xunlei.downloadprovider.member.register.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import java.lang.reflect.Field;

public class MailBoxAssociateView extends AutoCompleteTextView {
    public b a;
    private boolean b;

    public MailBoxAssociateView(Context context) {
        super(context);
        setDropDownBackgroundResource(R.drawable.bg_pop_gary);
    }

    public MailBoxAssociateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDropDownBackgroundResource(R.drawable.bg_pop_gary);
    }

    public MailBoxAssociateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setDropDownBackgroundResource(R.drawable.bg_pop_gary);
    }

    protected void replaceText(CharSequence charSequence) {
        super.replaceText(charSequence);
    }

    @TargetApi(11)
    public void showDropDown() {
        super.showDropDown();
        setDropDownWidth(getWidth() + DipPixelUtil.dip2px(10.0f));
        setDropDownVerticalOffset(-DipPixelUtil.dip2px(4.0f));
        setDropDownHorizontalOffset(-DipPixelUtil.dip2px(5.0f));
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mPopup");
            declaredField.setAccessible(true);
            if (declaredField.getType() == ListPopupWindow.class) {
                try {
                    ListView listView = ((ListPopupWindow) declaredField.get(this)).getListView();
                    if (listView != null) {
                        listView.setDivider(getContext().getResources().getDrawable(R.drawable.pop_devide_color));
                        listView.setDividerHeight(DipPixelUtil.dip2px(3.0f));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    public boolean enoughToFilter() {
        return this.b ? getText().length() > 0 : getText().toString().contains("@") && getText().toString().indexOf("@") > 0;
    }
}
