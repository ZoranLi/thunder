package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.MessagingStyle;
import android.app.Notification.MessagingStyle.Message;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompatBase.Action;
import android.support.v4.app.NotificationCompatBase.Action.Factory;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiresApi(24)
class NotificationCompatApi24 {

    public static class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private android.app.Notification.Builder b;
        private int mGroupAlertBehavior;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, CharSequence[] charSequenceArr, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, int i7) {
            PendingIntent pendingIntent3;
            Builder builder = this;
            Notification notification3 = notification;
            RemoteViews remoteViews5 = remoteViews2;
            RemoteViews remoteViews6 = remoteViews3;
            RemoteViews remoteViews7 = remoteViews4;
            boolean z6 = false;
            android.app.Notification.Builder deleteIntent = new android.app.Notification.Builder(context).setWhen(notification3.when).setShowWhen(z2).setSmallIcon(notification3.icon, notification3.iconLevel).setContent(notification3.contentView).setTicker(notification3.tickerText, remoteViews).setSound(notification3.sound, notification3.audioStreamType).setVibrate(notification3.vibrate).setLights(notification3.ledARGB, notification3.ledOnMS, notification3.ledOffMS).setOngoing((notification3.flags & 2) != 0).setOnlyAlertOnce((notification3.flags & 8) != 0).setAutoCancel((notification3.flags & 16) != 0).setDefaults(notification3.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification3.deleteIntent);
            if ((notification3.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z6 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            builder.b = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2).setRemoteInputHistory(charSequenceArr);
            if (remoteViews5 != null) {
                builder.b.setCustomContentView(remoteViews5);
            }
            if (remoteViews6 != null) {
                builder.b.setCustomBigContentView(remoteViews6);
            }
            if (remoteViews7 != null) {
                builder.b.setCustomHeadsUpContentView(remoteViews7);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                builder.b.addPerson((String) it.next());
            }
            builder.mGroupAlertBehavior = i7;
        }

        public void addAction(Action action) {
            NotificationCompatApi24.addAction(this.b, action);
        }

        public android.app.Notification.Builder getBuilder() {
            return this.b;
        }

        public Notification build() {
            Notification build = this.b.build();
            if (this.mGroupAlertBehavior != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.mGroupAlertBehavior != 2)) {
                    removeSoundAndVibration(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                    removeSoundAndVibration(build);
                }
            }
            return build;
        }

        private void removeSoundAndVibration(Notification notification) {
            notification.sound = null;
            notification.vibrate = null;
            notification.defaults &= -2;
            notification.defaults &= -3;
        }
    }

    NotificationCompatApi24() {
    }

    public static void addMessagingStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, CharSequence charSequence2, List<CharSequence> list, List<Long> list2, List<CharSequence> list3, List<String> list4, List<Uri> list5) {
        charSequence = new MessagingStyle(charSequence).setConversationTitle(charSequence2);
        for (charSequence2 = null; charSequence2 < list.size(); charSequence2++) {
            Message message = new Message((CharSequence) list.get(charSequence2), ((Long) list2.get(charSequence2)).longValue(), (CharSequence) list3.get(charSequence2));
            if (list4.get(charSequence2) != null) {
                message.setData((String) list4.get(charSequence2), (Uri) list5.get(charSequence2));
            }
            charSequence.addMessage(message);
        }
        charSequence.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
    }

    public static void addAction(android.app.Notification.Builder builder, Action action) {
        Bundle bundle;
        android.app.Notification.Action.Builder builder2 = new android.app.Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (RemoteInput addRemoteInput : RemoteInputCompatApi20.fromCompat(action.getRemoteInputs())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        builder2.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }

    public static Action getAction(Notification notification, int i, Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return getActionCompatFromAction(notification.actions[i], factory, factory2);
    }

    private static Action getActionCompatFromAction(Notification.Action action, Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        RemoteInputCompatBase.RemoteInput[] toCompat = RemoteInputCompatApi20.toCompat(action.getRemoteInputs(), factory2);
        if (action.getExtras().getBoolean("android.support.allowGeneratedReplies") == null) {
            if (action.getAllowGeneratedReplies() == null) {
                factory2 = null;
                return factory.build(action.icon, action.title, action.actionIntent, action.getExtras(), toCompat, null, factory2);
            }
        }
        factory2 = true;
        return factory.build(action.icon, action.title, action.actionIntent, action.getExtras(), toCompat, null, factory2);
    }

    private static Notification.Action getActionFromActionCompat(Action action) {
        Bundle bundle;
        android.app.Notification.Action.Builder builder = new android.app.Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
        builder.addExtras(bundle);
        action = action.getRemoteInputs();
        if (action != null) {
            for (RemoteInput addRemoteInput : RemoteInputCompatApi20.fromCompat(action)) {
                builder.addRemoteInput(addRemoteInput);
            }
        }
        return builder.build();
    }

    public static Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList, Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        if (arrayList == null) {
            return null;
        }
        Action[] newArray = factory.newArray(arrayList.size());
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = getActionCompatFromAction((Notification.Action) arrayList.get(i), factory, factory2);
        }
        return newArray;
    }

    public static ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
        if (actionArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList(actionArr.length);
        for (Action actionFromActionCompat : actionArr) {
            arrayList.add(getActionFromActionCompat(actionFromActionCompat));
        }
        return arrayList;
    }
}
