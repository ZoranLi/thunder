package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.text.TextUtils;
import com.alipay.sdk.util.h;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SET_REPEAT_MODE = 262144;
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Creator<PlaybackStateCompat> CREATOR = new Creator<PlaybackStateCompat>() {
        public final PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        public final PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    List<CustomAction> mCustomActions;
    final int mErrorCode;
    final CharSequence mErrorMessage;
    final Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private Object mStateObj;
    final long mUpdateTime;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Actions {
    }

    public static final class Builder {
        private long mActions;
        private long mActiveItemId = -1;
        private long mBufferedPosition;
        private final List<CustomAction> mCustomActions = new ArrayList();
        private int mErrorCode;
        private CharSequence mErrorMessage;
        private Bundle mExtras;
        private long mPosition;
        private float mRate;
        private int mState;
        private long mUpdateTime;

        public Builder(PlaybackStateCompat playbackStateCompat) {
            this.mState = playbackStateCompat.mState;
            this.mPosition = playbackStateCompat.mPosition;
            this.mRate = playbackStateCompat.mSpeed;
            this.mUpdateTime = playbackStateCompat.mUpdateTime;
            this.mBufferedPosition = playbackStateCompat.mBufferedPosition;
            this.mActions = playbackStateCompat.mActions;
            this.mErrorCode = playbackStateCompat.mErrorCode;
            this.mErrorMessage = playbackStateCompat.mErrorMessage;
            if (playbackStateCompat.mCustomActions != null) {
                this.mCustomActions.addAll(playbackStateCompat.mCustomActions);
            }
            this.mActiveItemId = playbackStateCompat.mActiveItemId;
            this.mExtras = playbackStateCompat.mExtras;
        }

        public final Builder setState(int i, long j, float f) {
            return setState(i, j, f, SystemClock.elapsedRealtime());
        }

        public final Builder setState(int i, long j, float f, long j2) {
            this.mState = i;
            this.mPosition = j;
            this.mUpdateTime = j2;
            this.mRate = f;
            return this;
        }

        public final Builder setBufferedPosition(long j) {
            this.mBufferedPosition = j;
            return this;
        }

        public final Builder setActions(long j) {
            this.mActions = j;
            return this;
        }

        public final Builder addCustomAction(String str, String str2, int i) {
            return addCustomAction(new CustomAction(str, str2, i, null));
        }

        public final Builder addCustomAction(CustomAction customAction) {
            if (customAction == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
            }
            this.mCustomActions.add(customAction);
            return this;
        }

        public final Builder setActiveQueueItemId(long j) {
            this.mActiveItemId = j;
            return this;
        }

        public final Builder setErrorMessage(CharSequence charSequence) {
            this.mErrorMessage = charSequence;
            return this;
        }

        public final Builder setErrorMessage(int i, CharSequence charSequence) {
            this.mErrorCode = i;
            this.mErrorMessage = charSequence;
            return this;
        }

        public final Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public final PlaybackStateCompat build() {
            int i = this.mState;
            long j = this.mPosition;
            long j2 = this.mBufferedPosition;
            float f = this.mRate;
            long j3 = this.mActions;
            int i2 = this.mErrorCode;
            CharSequence charSequence = this.mErrorMessage;
            long j4 = this.mUpdateTime;
            List list = this.mCustomActions;
            return new PlaybackStateCompat(i, j, j2, f, j3, i2, charSequence, j4, list, this.mActiveItemId, this.mExtras);
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new Creator<CustomAction>() {
            public final CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            public final CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };
        private final String mAction;
        private Object mCustomActionObj;
        private final Bundle mExtras;
        private final int mIcon;
        private final CharSequence mName;

        public static final class Builder {
            private final String mAction;
            private Bundle mExtras;
            private final int mIcon;
            private final CharSequence mName;

            public Builder(String str, CharSequence charSequence, int i) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
                } else if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
                } else if (i == 0) {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
                } else {
                    this.mAction = str;
                    this.mName = charSequence;
                    this.mIcon = i;
                }
            }

            public final Builder setExtras(Bundle bundle) {
                this.mExtras = bundle;
                return this;
            }

            public final CustomAction build() {
                return new CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras);
            }
        }

        public final int describeContents() {
            return 0;
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.mAction = str;
            this.mName = charSequence;
            this.mIcon = i;
            this.mExtras = bundle;
        }

        CustomAction(Parcel parcel) {
            this.mAction = parcel.readString();
            this.mName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.mIcon = parcel.readInt();
            this.mExtras = parcel.readBundle();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, parcel, i);
            parcel.writeInt(this.mIcon);
            parcel.writeBundle(this.mExtras);
        }

        public static CustomAction fromCustomAction(Object obj) {
            if (obj != null) {
                if (VERSION.SDK_INT >= 21) {
                    CustomAction customAction = new CustomAction(CustomAction.getAction(obj), CustomAction.getName(obj), CustomAction.getIcon(obj), CustomAction.getExtras(obj));
                    customAction.mCustomActionObj = obj;
                    return customAction;
                }
            }
            return null;
        }

        public final Object getCustomAction() {
            if (this.mCustomActionObj == null) {
                if (VERSION.SDK_INT >= 21) {
                    this.mCustomActionObj = CustomAction.newInstance(this.mAction, this.mName, this.mIcon, this.mExtras);
                    return this.mCustomActionObj;
                }
            }
            return this.mCustomActionObj;
        }

        public final String getAction() {
            return this.mAction;
        }

        public final CharSequence getName() {
            return this.mName;
        }

        public final int getIcon() {
            return this.mIcon;
        }

        public final Bundle getExtras() {
            return this.mExtras;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Action:mName='");
            stringBuilder.append(this.mName);
            stringBuilder.append(", mIcon=");
            stringBuilder.append(this.mIcon);
            stringBuilder.append(", mExtras=");
            stringBuilder.append(this.mExtras);
            return stringBuilder.toString();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaKeyAction {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShuffleMode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public static int toKeyCode(long j) {
        return j == 4 ? 126 : j == 2 ? 127 : j == 32 ? 87 : j == 16 ? 88 : j == 1 ? 86 : j == 64 ? 90 : j == 8 ? 89 : j == 512 ? 85 : 0;
    }

    public final int describeContents() {
        return 0;
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.mState = i;
        this.mPosition = j;
        this.mBufferedPosition = j2;
        this.mSpeed = f;
        this.mActions = j3;
        this.mErrorCode = i2;
        this.mErrorMessage = charSequence;
        this.mUpdateTime = j4;
        this.mCustomActions = new ArrayList(list);
        this.mActiveItemId = j5;
        this.mExtras = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.mPosition = parcel.readLong();
        this.mSpeed = parcel.readFloat();
        this.mUpdateTime = parcel.readLong();
        this.mBufferedPosition = parcel.readLong();
        this.mActions = parcel.readLong();
        this.mErrorMessage = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mCustomActions = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = parcel.readLong();
        this.mExtras = parcel.readBundle();
        this.mErrorCode = parcel.readInt();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=");
        stringBuilder.append(this.mState);
        stringBuilder.append(", position=");
        stringBuilder.append(this.mPosition);
        stringBuilder.append(", buffered position=");
        stringBuilder.append(this.mBufferedPosition);
        stringBuilder.append(", speed=");
        stringBuilder.append(this.mSpeed);
        stringBuilder.append(", updated=");
        stringBuilder.append(this.mUpdateTime);
        stringBuilder.append(", actions=");
        stringBuilder.append(this.mActions);
        stringBuilder.append(", error code=");
        stringBuilder.append(this.mErrorCode);
        stringBuilder.append(", error message=");
        stringBuilder.append(this.mErrorMessage);
        stringBuilder.append(", custom actions=");
        stringBuilder.append(this.mCustomActions);
        stringBuilder.append(", active item id=");
        stringBuilder.append(this.mActiveItemId);
        stringBuilder.append(h.d);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mPosition);
        parcel.writeFloat(this.mSpeed);
        parcel.writeLong(this.mUpdateTime);
        parcel.writeLong(this.mBufferedPosition);
        parcel.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, parcel, i);
        parcel.writeTypedList(this.mCustomActions);
        parcel.writeLong(this.mActiveItemId);
        parcel.writeBundle(this.mExtras);
        parcel.writeInt(this.mErrorCode);
    }

    public final int getState() {
        return this.mState;
    }

    public final long getPosition() {
        return this.mPosition;
    }

    public final long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    public final float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public final long getActions() {
        return this.mActions;
    }

    public final List<CustomAction> getCustomActions() {
        return this.mCustomActions;
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }

    public final CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    public final long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public final long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    @Nullable
    public final Bundle getExtras() {
        return this.mExtras;
    }

    public static PlaybackStateCompat fromPlaybackState(Object obj) {
        Object obj2 = obj;
        PlaybackStateCompat playbackStateCompat = null;
        if (obj2 == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List list;
        List<Object> customActions = PlaybackStateCompatApi21.getCustomActions(obj);
        if (customActions != null) {
            List arrayList = new ArrayList(customActions.size());
            for (Object fromCustomAction : customActions) {
                arrayList.add(CustomAction.fromCustomAction(fromCustomAction));
            }
            list = arrayList;
        } else {
            list = null;
        }
        if (VERSION.SDK_INT >= 22) {
            playbackStateCompat = PlaybackStateCompatApi22.getExtras(obj);
        }
        PlaybackStateCompat playbackStateCompat2 = new PlaybackStateCompat(PlaybackStateCompatApi21.getState(obj), PlaybackStateCompatApi21.getPosition(obj), PlaybackStateCompatApi21.getBufferedPosition(obj), PlaybackStateCompatApi21.getPlaybackSpeed(obj), PlaybackStateCompatApi21.getActions(obj), 0, PlaybackStateCompatApi21.getErrorMessage(obj), PlaybackStateCompatApi21.getLastPositionUpdateTime(obj), list, PlaybackStateCompatApi21.getActiveQueueItemId(obj), playbackStateCompat);
        playbackStateCompat2.mStateObj = obj2;
        return playbackStateCompat2;
    }

    public final Object getPlaybackState() {
        if (this.mStateObj == null && VERSION.SDK_INT >= 21) {
            List list = null;
            if (r0.mCustomActions != null) {
                list = new ArrayList(r0.mCustomActions.size());
                for (CustomAction customAction : r0.mCustomActions) {
                    list.add(customAction.getCustomAction());
                }
            }
            List list2 = list;
            if (VERSION.SDK_INT >= 22) {
                r0.mStateObj = PlaybackStateCompatApi22.newInstance(r0.mState, r0.mPosition, r0.mBufferedPosition, r0.mSpeed, r0.mActions, r0.mErrorMessage, r0.mUpdateTime, list2, r0.mActiveItemId, r0.mExtras);
            } else {
                r0.mStateObj = PlaybackStateCompatApi21.newInstance(r0.mState, r0.mPosition, r0.mBufferedPosition, r0.mSpeed, r0.mActions, r0.mErrorMessage, r0.mUpdateTime, list2, r0.mActiveItemId);
            }
        }
        return r0.mStateObj;
    }
}
