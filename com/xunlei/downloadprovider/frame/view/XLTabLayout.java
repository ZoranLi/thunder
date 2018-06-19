package com.xunlei.downloadprovider.frame.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.user.t;

public class XLTabLayout extends LinearLayout implements OnClickListener {
    private a a;
    private b b;
    private String c;
    private long d;

    public interface a {
        void a(XLTabView xLTabView);
    }

    public interface b {
        void a(XLTabView xLTabView);
    }

    @SuppressLint({"NewApi"})
    public XLTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public XLTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XLTabLayout(Context context) {
        super(context);
    }

    public void setOnTabChangeListener(a aVar) {
        this.a = aVar;
    }

    public void setOnClickListener(b bVar) {
        this.b = bVar;
    }

    public void setSelection(String str) {
        for (int i = 0; i < getChildCount(); i++) {
            XLTabView xLTabView = (XLTabView) getChildAt(i);
            if (str.equals(xLTabView.getTabTag())) {
                xLTabView.setSelection(true);
                this.c = str;
            } else {
                xLTabView.setSelection(false);
            }
        }
    }

    public String getCurrentTag() {
        return this.c;
    }

    public XLTabView getCurrentTabView() {
        return a(this.c);
    }

    public final XLTabView a(String str) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            XLTabView xLTabView = (XLTabView) getChildAt(i);
            if (str.equals(xLTabView.getTabTag())) {
                return xLTabView;
            }
        }
        return null;
    }

    public void onClick(View view) {
        if (SystemClock.elapsedRealtime() - this.d > 200) {
            XLTabView xLTabView = (XLTabView) view;
            if (this.b != null) {
                this.b.a(xLTabView);
            }
            if (!this.c.equals(xLTabView.getTabTag())) {
                setSelection(xLTabView.getTabTag());
                String tabTag = xLTabView.getTabTag();
                StatEvent statEvent = new StatEvent("android_tabBottom_click");
                if ("thunder".equals(tabTag)) {
                    statEvent.addString(HubbleEventBuilder.KEY_ATTRIBUTE1, "tabBottom_home_click");
                    statEvent.add("status", xLTabView.a());
                } else if ("xllive".equals(tabTag)) {
                    statEvent.addString(HubbleEventBuilder.KEY_ATTRIBUTE1, "tabBottom_zhibo_click");
                    statEvent.add("status", xLTabView.a());
                    LoginHelper.a();
                    statEvent.add("if_login", l.c());
                } else if ("find".equals(tabTag)) {
                    statEvent.addString(HubbleEventBuilder.KEY_ATTRIBUTE1, "tabBottom_find_click");
                    statEvent.add("status", xLTabView.a());
                } else if (MessageInfo.USER.equals(tabTag)) {
                    statEvent.addString(HubbleEventBuilder.KEY_ATTRIBUTE1, "tabBottom_personal_click");
                    statEvent.add("if_login", t.a().a);
                    statEvent.add("status", xLTabView.a());
                }
                ThunderReport.reportEvent(statEvent);
                if (this.a != null) {
                    this.a.a(xLTabView);
                }
            }
        }
    }

    public static BaseFragment a(int i, FragmentManager fragmentManager, a aVar, String str, Bundle bundle) {
        if (!(i <= 0 || fragmentManager == null || aVar == null)) {
            if (str != null) {
                aVar = aVar.a(str, bundle);
                if (aVar == null) {
                    return null;
                }
                fragmentManager = fragmentManager.beginTransaction();
                fragmentManager.replace(i, aVar).addToBackStack(null);
                fragmentManager.commitAllowingStateLoss();
                return aVar;
            }
        }
        return null;
    }
}
