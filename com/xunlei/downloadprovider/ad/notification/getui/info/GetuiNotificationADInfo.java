package com.xunlei.downloadprovider.ad.notification.getui.info;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.browser.WebViewADActivity;
import com.xunlei.downloadprovider.ad.common.browser.a;
import com.xunlei.downloadprovider.ad.notification.NotificationADInfo;
import java.util.HashMap;

public class GetuiNotificationADInfo extends NotificationADInfo {
    public static final int NOTIFICATION_STYLE_BANNER = 4;
    private static final int NOTIFICATION_STYLE_DEFAULT = 1;
    public static final int NOTIFICATION_STYLE_ICON = 1;
    private static final String TAG = "ad.GetuiNotificationADInfo";
    private String action = null;
    private String adId = null;
    private String banner = null;
    private String desc = null;
    private String feedbackAction = null;
    private String icon = null;
    private int landingType = 0;
    private String landingUrl = null;
    private String messageId = null;
    private int notifyStyle = 1;
    private String secondIcon = null;
    private String taskId = null;
    private String title = null;

    public static GetuiNotificationADInfo parse(Intent intent) {
        GetuiNotificationADInfo getuiNotificationADInfo = new GetuiNotificationADInfo();
        getuiNotificationADInfo.setAction(intent.getStringExtra("action"));
        getuiNotificationADInfo.setTaskId(intent.getStringExtra("taskid"));
        getuiNotificationADInfo.setMessageId(intent.getStringExtra("messageid"));
        int i = 1;
        getuiNotificationADInfo.setNotifyStyle(intent.getIntExtra("notifystyle", 1));
        getuiNotificationADInfo.setTitle(intent.getStringExtra("title"));
        getuiNotificationADInfo.setDesc(intent.getStringExtra("text"));
        getuiNotificationADInfo.setIcon(intent.getStringExtra("logo"));
        getuiNotificationADInfo.setSecondIcon(intent.getStringExtra("second_logo"));
        getuiNotificationADInfo.setBanner(intent.getStringExtra("banner"));
        getuiNotificationADInfo.setLandingUrl(intent.getStringExtra("url"));
        getuiNotificationADInfo.setAdId(intent.getStringExtra("adid"));
        getuiNotificationADInfo.setFeedbackAction(intent.getStringExtra("feedback_action"));
        if (a.c(getuiNotificationADInfo.getLandingUrl()) == null) {
            i = 2;
        }
        getuiNotificationADInfo.setLandingType(i);
        new StringBuilder("parse getuiNotificationADInfo: ").append(getuiNotificationADInfo.toString());
        return getuiNotificationADInfo;
    }

    public void report(Context context, String str, @Nullable String str2) {
        String str3;
        StringBuilder stringBuilder = new StringBuilder("report. status: ");
        stringBuilder.append(str);
        if (str2 == null) {
            str3 = "";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder(" error: ");
            stringBuilder2.append(str2);
            str3 = stringBuilder2.toString();
        }
        stringBuilder.append(str3);
        feedback(context, str, str2);
        context = -1;
        int hashCode = str.hashCode();
        if (hashCode != 3529469) {
            if (hashCode != 94750088) {
                if (hashCode != 96784904) {
                    if (hashCode == 1082290915) {
                        if (str.equals(NotificationADInfo.REPORT_STATUS_RECEIVE) != null) {
                            context = null;
                        }
                    }
                } else if (str.equals("error") != null) {
                    context = 3;
                }
            } else if (str.equals(NotificationADInfo.REPORT_STATUS_CLICK) != null) {
                context = 2;
            }
        } else if (str.equals(NotificationADInfo.REPORT_STATUS_SHOW) != null) {
            context = true;
        }
        switch (context) {
            case null:
                context = "ad_push_receive";
                break;
            case 1:
                context = "ad_push_show";
                break;
            case 2:
                context = "ad_push_click";
                break;
            case 3:
                context = "ad_push_error";
                break;
            default:
                context = null;
                break;
        }
        if (context != null) {
            str = new HashMap();
            str.put("taskid", getTaskId());
            str.put("messageid", getMessageId());
            str.put("push_style", String.valueOf(getNotifyStyle()));
            if (!TextUtils.isEmpty(str2)) {
                str.put("errorcode", str2);
            }
            com.xunlei.downloadprovider.ad.common.report.a.a(context, str, false);
        }
    }

    public Intent buildClickIntent(Context context) {
        switch (getLandingType()) {
            case 1:
                return WebViewADActivity.a(context, "getui_notification_ad", getLandingUrl(), "", null);
            case 2:
                try {
                    return a.a(getLandingUrl());
                } catch (Context context2) {
                    context2.printStackTrace();
                    return null;
                }
            default:
                StringBuilder stringBuilder = new StringBuilder("不支持的落地类型：");
                stringBuilder.append(getLandingType());
                report(context2, "error", stringBuilder.toString());
                return null;
        }
    }

    public boolean isLandingResolve(Context context) {
        if (getLandingType() == 2) {
            if (a.a(context.getPackageManager(), getLandingUrl()) == null) {
                return null;
            }
        }
        return true;
    }

    public int getLandingType() {
        return this.landingType;
    }

    protected void setLandingType(int i) {
        this.landingType = i;
    }

    public Notification buildNotification(Context context, int i, Bitmap bitmap) {
        RemoteViews createContentView = createContentView(context, bitmap);
        if (createContentView != null) {
            return new Builder(context).setContent(createContentView).setAutoCancel(true).setNumber(0).setPriority(2).setDefaults(i).setSmallIcon(R.drawable.notification_ad_status_bar_logo).setLargeIcon(bitmap).build();
        }
        new StringBuilder("wtf. contentView == null. notifyStyle: ").append(getNotifyStyle());
        return null;
    }

    private RemoteViews createContentView(Context context, Bitmap bitmap) {
        RemoteViews remoteViews = null;
        if (bitmap == null) {
            report(context, "error", TextUtils.isEmpty(getValidImage()) != null ? "imageUrl is empty" : "download image fail");
            return null;
        }
        int notifyStyle = getNotifyStyle();
        if (notifyStyle == 1) {
            remoteViews = createIconContentView(context, bitmap);
        } else if (notifyStyle == 4) {
            remoteViews = createBannerContentView(context, bitmap);
        }
        return remoteViews;
    }

    @NonNull
    private RemoteViews createIconContentView(Context context, Bitmap bitmap) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.layout_notification_ad_style_icon);
        remoteViews.setTextViewText(R.id.tv_title, getTitle());
        remoteViews.setTextViewText(R.id.tv_desc, getDesc());
        remoteViews.setImageViewBitmap(R.id.iv_poster, bitmap);
        return remoteViews;
    }

    @NonNull
    private RemoteViews createBannerContentView(Context context, Bitmap bitmap) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.layout_notification_ad_style_banner);
        remoteViews.setImageViewBitmap(R.id.iv_poster, bitmap);
        return remoteViews;
    }

    private void feedback(Context context, String str, String str2) {
        Intent intent = new Intent(getFeedbackAction());
        intent.putExtra("action", "feedback");
        intent.putExtra("taskid", getTaskId());
        intent.putExtra("messageid", getMessageId());
        intent.putExtra("adid", getAdId());
        intent.putExtra("status", str);
        if (TextUtils.isEmpty(str2) == null) {
            intent.putExtra("error", str2);
        }
        context.sendBroadcast(intent);
    }

    public String getValidImage() {
        int notifyStyle = getNotifyStyle();
        if (notifyStyle == 1) {
            return getIcon();
        }
        if (notifyStyle != 4) {
            return "";
        }
        return getBanner();
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public int getNotifyStyle() {
        return this.notifyStyle;
    }

    public void setNotifyStyle(int i) {
        this.notifyStyle = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getSecondIcon() {
        return this.secondIcon;
    }

    public void setSecondIcon(String str) {
        this.secondIcon = str;
    }

    public String getBanner() {
        return this.banner;
    }

    public void setBanner(String str) {
        this.banner = str;
    }

    public String getLandingUrl() {
        return this.landingUrl;
    }

    public void setLandingUrl(String str) {
        this.landingUrl = str;
    }

    public String getAdId() {
        return this.adId;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public String getFeedbackAction() {
        return this.feedbackAction;
    }

    public void setFeedbackAction(String str) {
        this.feedbackAction = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GetuiNotificationADInfo{action='");
        stringBuilder.append(this.action);
        stringBuilder.append('\'');
        stringBuilder.append(", taskId='");
        stringBuilder.append(this.taskId);
        stringBuilder.append('\'');
        stringBuilder.append(", messageId='");
        stringBuilder.append(this.messageId);
        stringBuilder.append('\'');
        stringBuilder.append(", notifyStyle=");
        stringBuilder.append(this.notifyStyle);
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", desc='");
        stringBuilder.append(this.desc);
        stringBuilder.append('\'');
        stringBuilder.append(", icon='");
        stringBuilder.append(this.icon);
        stringBuilder.append('\'');
        stringBuilder.append(", secondIcon='");
        stringBuilder.append(this.secondIcon);
        stringBuilder.append('\'');
        stringBuilder.append(", banner='");
        stringBuilder.append(this.banner);
        stringBuilder.append('\'');
        stringBuilder.append(", landingUrl='");
        stringBuilder.append(this.landingUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", adId='");
        stringBuilder.append(this.adId);
        stringBuilder.append('\'');
        stringBuilder.append(", feedbackAction='");
        stringBuilder.append(this.feedbackAction);
        stringBuilder.append('\'');
        stringBuilder.append(", landingType=");
        stringBuilder.append(this.landingType);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
