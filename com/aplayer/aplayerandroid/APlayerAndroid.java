package com.aplayer.aplayerandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.alipay.sdk.util.h;
import com.aplayer.Version;
import com.aplayer.aplayerandroid.HardwareDecoder.OnDecoderOneFrameListener;
import com.aplayer.hardwareencode.HardwareEncoder;
import com.aplayer.io.AHttp;
import com.aplayer.io.ALocalFile;
import com.aplayer.io.ExtIOBase;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class APlayerAndroid {
    private static final String TAG = "APlayerAndroid";
    public static int gObjId;
    private OnSystemPlayerFailListener OnSystemPlayerFailListener;
    private boolean mActivityPause = false;
    private int mBufferProgress = 100;
    private boolean mDestroy = false;
    private EventHandler mEventHandler = null;
    private ExtIOBase mExtIO;
    private FileDescriptor mFileDescriptor = null;
    private String mFileName = "";
    private GPUImageFilter mGpuImageFilter = null;
    private HardwareEncoder mHardwareEncoder = null;
    private HardwareDecoder mHwDecoder = null;
    private int mHwReCreatePos = 0;
    private boolean mIsAutoPlay = false;
    private boolean mIsCurrentUseSysmediaplay = false;
    private boolean mIsSourceChanged = false;
    private boolean mIsSuccess = false;
    private boolean mIsVrTouchRotateEnable = false;
    private int mObjId = 0;
    private OnBufferListener mOnBufferListener;
    private OnFirstFrameRenderListener mOnFirstFrameRenderListener;
    private OnForceUpdateListener mOnForceUpdateListener;
    private OnOpenCompleteListener mOnOpenCompleteListener;
    private OnOpenSuccessListener mOnOpenSuccessListener;
    private OnPlayCompleteListener mOnPlayCompleteListener;
    private OnPlayStateChangeListener mOnPlayStateChangeListener;
    private OnReCreateHwDecoderListener mOnReCreateHwDecoderListener;
    private OnSeekCompleteListener mOnSeekCompleteListener;
    private OnShowSubtitleListener mOnShowSubtitleListener;
    private OnSurfaceChangeListener mOnSurfaceChangeListener;
    private OnSurfaceDestroyListener mOnSurfaceDestroyListener;
    private String mPath = null;
    private OnPreciseSeekCompleteListener mPreciseSeekCompleteListener;
    private int mReCreateHwCodecState = 0;
    private OnRecordEndListener mRecordEndListener;
    private XLMediaMetaDataRetriever mRetriever;
    private String mSilenceAudio = "0";
    private int mStretchMode = 0;
    private TextView mSubtilteview = null;
    private String mSubtitleShow = "1";
    private boolean mSubtitleShowExternal = false;
    private int mSubtitleViewTop = 0;
    private Surface mSurface = null;
    private int mSurfaceType = 1;
    private View mSurfaceview = null;
    private SurfaceHolder mSurholder = null;
    private SystemMediaPlay mSystemPlayer = null;
    private boolean mUpdateSurfaceView = false;
    private int mViewSurfaceHeight = 0;
    private int mViewSurfaceWidth = 0;

    public class CONFIGID {
        public static final int ASPECT_RATIO_CUSTOM = 204;
        public static final int ASPECT_RATIO_NATIVE = 203;
        public static final int AUDIO_SILENCE = 420;
        public static final int AUDIO_TRACK_CURRENT = 403;
        public static final int AUDIO_TRACK_LIST = 402;
        public static final int AUTO_PLAY = 8;
        public static final int EXTIO = 14;
        public static final int HTTP_AHTTP_CACHE_DIR = 1110;
        public static final int HTTP_AHTTP_USE_CACHE = 1111;
        public static final int HTTP_COOKIE = 1105;
        public static final int HTTP_CUSTOM_HEADERS = 1107;
        public static final int HTTP_REFERER = 1106;
        public static final int HTTP_USER_AGENT = 1108;
        public static final int HTTP_USER_AHTTP = 1109;
        public static final int HW_DECODER_DETEC = 231;
        public static final int HW_DECODER_ENABLE = 230;
        public static final int HW_DECODER_USE = 209;
        public static final int LIVE_MODE = 205;
        public static final int NET_BUFFER_ENTER = 1001;
        public static final int NET_BUFFER_LEAVE = 1002;
        public static final int NET_BUFFER_READ = 1003;
        public static final int NET_BUFFER_READ_TIME = 1005;
        public static final int NET_SEEKBUFFER_WAITTIME = 1004;
        public static final int ORIENTATION_ANGLE = 41;
        public static final int PLAYRESULT = 7;
        public static final int PLAY_SPEED = 104;
        public static final int QUICKLY_MOV_ACTION_COUNT = 42;
        public static final int READPOSITION = 31;
        public static final int RECORD_BIT = 4000;
        public static final int RECORD_HEIGHT = 4002;
        public static final int RECORD_MODE = 4003;
        public static final int RECORD_WIDTH = 4001;
        public static final int SEEK_ENABLE = 3000;
        public static final int STRETCH_MODE = 202;
        public static final int SUBTITLE_CORRECTION = 509;
        public static final int SUBTITLE_CURLANG = 506;
        public static final int SUBTITLE_EXT_NAME = 502;
        public static final int SUBTITLE_FILE_NAME = 503;
        public static final int SUBTITLE_LANGLIST = 505;
        public static final int SUBTITLE_SHOW = 504;
        public static final int SUBTITLE_SHOW_EXTERNAL = 507;
        public static final int SUBTITLE_USABLE = 501;
        public static final int UPDATEWINDOW = 40;
        public static final int VR_DISTORTION_CORRECTION = 2415;
        public static final int VR_ENABLE = 2401;
        public static final int VR_ENABLE_INNER_TOUCH_ROTATE = 2414;
        public static final int VR_FOVY = 2412;
        public static final int VR_MODEL = 2413;
        public static final int VR_ROTATE = 2411;
    }

    private class EventHandler extends Handler {
        APlayerAndroid mp = null;

        public EventHandler(APlayerAndroid aPlayerAndroid, Looper looper) {
            super(looper);
            this.mp = aPlayerAndroid;
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 106) {
                    switch (i) {
                        case 5:
                            if (APlayerAndroid.this.mOnPlayStateChangeListener != null) {
                                APlayerAndroid.this.mOnPlayStateChangeListener.onPlayStateChange(message.arg1, message.arg2);
                            }
                            APlayerAndroid.this.stateChange(message.arg2, message.arg1, message.obj);
                            return;
                        case 6:
                            if (APlayerAndroid.this.mOnSeekCompleteListener != null) {
                                APlayerAndroid.this.mOnSeekCompleteListener.onSeekComplete();
                                return;
                            }
                            break;
                        case 7:
                            Log.i(APlayerAndroid.TAG, "Message record end");
                            if (APlayerAndroid.this.mRecordEndListener != null) {
                                APlayerAndroid.this.mRecordEndListener.onRecordEnd();
                                return;
                            }
                            break;
                        default:
                            switch (i) {
                                case 102:
                                    if (APlayerAndroid.this.mOnBufferListener != null) {
                                        APlayerAndroid.this.mBufferProgress = message.arg1;
                                        APlayerAndroid.this.mOnBufferListener.onBuffer(message.arg1);
                                        return;
                                    }
                                    break;
                                case 103:
                                    if (message.obj instanceof String) {
                                        message = APlayerAndroid.subtitleFormat((String) message.obj);
                                        if (APlayerAndroid.this.mOnShowSubtitleListener != null) {
                                            APlayerAndroid.this.mOnShowSubtitleListener.onShowSubtitle(message);
                                            APlayerAndroid.this.mSubtitleShowExternal = true;
                                        }
                                        if (!APlayerAndroid.this.mSubtitleShowExternal && APlayerAndroid.this.mSubtitleShow.equalsIgnoreCase("1")) {
                                            APlayerAndroid.this.showSubtitle(message);
                                        }
                                        return;
                                    }
                                    break;
                                case 104:
                                    Log.i(APlayerAndroid.TAG, "Message FIRST_VIDEO_FRAME_RENDER");
                                    if (APlayerAndroid.this.mOnFirstFrameRenderListener != null) {
                                        APlayerAndroid.this.mOnFirstFrameRenderListener.onFirstFrameRender();
                                        return;
                                    }
                                    break;
                                default:
                                    String access$000 = APlayerAndroid.TAG;
                                    StringBuilder stringBuilder = new StringBuilder("Unknown message tyupe ");
                                    stringBuilder.append(message.what);
                                    Log.e(access$000, stringBuilder.toString());
                                    break;
                            }
                    }
                }
                Log.i(APlayerAndroid.TAG, "MSG PRECISE_SEEK_COMPLETE");
                if (APlayerAndroid.this.mPreciseSeekCompleteListener != null) {
                    APlayerAndroid.this.mPreciseSeekCompleteListener.onPreciseSeekComplete();
                    return;
                }
                return;
            }
            Log.e(APlayerAndroid.TAG, "PLAY_OPEN_SUCCESSDED is received");
            APlayerAndroid.this.openSuccess();
        }
    }

    public static class MediaInfo {
        public String angle;
        public int avg_luma;
        public byte[] bitMap;
        public long duration_ms;
        public long file_size;
        public int height;
        public boolean is_key_frame;
        public long show_ms;
        public int width;

        public static Bitmap byteArray2BitMap(byte[] bArr) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
    }

    private class MsgID {
        public static final int FRIST_VIDEO_FRAME_RENDER = 104;
        public static final int GET_BUFFERPRO = 102;
        public static final int PLAY_OPEN_SUCCESSDED = 1;
        public static final int PLAY_STATECHANGED = 5;
        public static final int PRECISE_SEEK_COMPLETE = 106;
        public static final int RECORD_END = 7;
        public static final int SEEK_COMPLETE = 6;
        public static final int SHOW_SUBTITLE = 103;

        private MsgID() {
        }
    }

    public interface OnBufferListener {
        void onBuffer(int i);
    }

    public interface OnFirstFrameRenderListener {
        void onFirstFrameRender();
    }

    protected interface OnForceUpdateListener {
        void onForceUpdate();
    }

    public interface OnOpenCompleteListener {
        void onOpenComplete(boolean z);
    }

    public interface OnOpenSuccessListener {
        void onOpenSuccess();
    }

    public interface OnPlayCompleteListener {
        void onPlayComplete(String str);
    }

    public interface OnPlayStateChangeListener {
        void onPlayStateChange(int i, int i2);
    }

    public interface OnPreciseSeekCompleteListener {
        void onPreciseSeekComplete();
    }

    public interface OnReCreateHwDecoderListener {
        void onReCreateHwDecoder();
    }

    public interface OnRecordEndListener {
        void onRecordEnd();
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete();
    }

    public interface OnShowSubtitleListener {
        void onShowSubtitle(String str);
    }

    protected interface OnSurfaceChangeListener {
        void onSurfaceChange(int i, int i2);
    }

    public interface OnSurfaceDestroyListener {
        void onSurfaceDestroy();
    }

    public interface OnSystemPlayerFailListener {
        void onSystemPlayerFail();
    }

    public class Orientation {
        public static final String VIDEO_ORIENTARION_LEFT180 = "LEFT180";
        public static final String VIDEO_ORIENTARION_LEFT90 = "LEFT90";
        public static final String VIDEO_ORIENTARION_NORM = "NORM";
        public static final String VIDEO_ORIENTARION_RIGHT90 = "RIGHT90";
    }

    public class PlayCompleteRet {
        public static final String PLAYRE_RESULT_CLOSE = "0x1";
        public static final String PLAYRE_RESULT_COMPLETE = "0x0";
        public static final String PLAYRE_RESULT_CREATEGRAPHERROR = "0x80000004";
        public static final String PLAYRE_RESULT_DECODEERROR = "0x80000005";
        public static final String PLAYRE_RESULT_HARDDECODERROR = "0x80000006";
        public static final String PLAYRE_RESULT_OPENRROR = "0x80000001";
        public static final String PLAYRE_RESULT_READEFRAMERROR = "0x80000003";
        public static final String PLAYRE_RESULT_SEEKERROR = "0x80000002";
    }

    public class PlayerState {
        public static final int APLAYER_CLOSEING = 6;
        public static final int APLAYER_OPENING = 1;
        public static final int APLAYER_PAUSED = 3;
        public static final int APLAYER_PAUSING = 2;
        public static final int APLAYER_PLAY = 5;
        public static final int APLAYER_PLAYING = 4;
        public static final int APLAYER_READ = 0;
        public static final int APLAYER_RESET = 7;
    }

    public static class Size {
        public int height = 0;
        public int width = 0;
    }

    public static class StatisticsInfo {
        public String audioCodecName;
        public String containerName;
        public String error;
        public boolean isHwdecoder;
        public int streamType;
        public String subtitleCodecName;
        public String videoCodecName;
        public float videoFrameRate;
    }

    private class SystemMediaPlay {
        private int mBufferProgress = 0;
        private String mMediaPath;
        private MediaPlayer mPlayer = new MediaPlayer();
        private int mState = 0;

        public SystemMediaPlay() {
            if (this.mPlayer != null) {
                this.mPlayer.setOnSeekCompleteListener(new android.media.MediaPlayer.OnSeekCompleteListener(APlayerAndroid.this) {
                    public void onSeekComplete(MediaPlayer mediaPlayer) {
                        Log.i(APlayerAndroid.TAG, "mediaplayer setOnSeekCompleteListener");
                        if (APlayerAndroid.this.mOnSeekCompleteListener != null) {
                            APlayerAndroid.this.mOnSeekCompleteListener.onSeekComplete();
                        }
                    }
                });
                this.mPlayer.setOnErrorListener(new OnErrorListener(APlayerAndroid.this) {
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        mediaPlayer = APlayerAndroid.TAG;
                        StringBuilder stringBuilder = new StringBuilder("mediaplayer onError what ");
                        stringBuilder.append(i);
                        stringBuilder.append("extra = ");
                        stringBuilder.append(i2);
                        Log.i(mediaPlayer, stringBuilder.toString());
                        SystemMediaPlay.this.release();
                        SystemMediaPlay.this.onSystemMediaPlayerError();
                        return null;
                    }
                });
                this.mPlayer.setOnBufferingUpdateListener(new OnBufferingUpdateListener(APlayerAndroid.this) {
                    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                        Log.i(APlayerAndroid.TAG, "mediaplayer setOnBufferingUpdateListener");
                        SystemMediaPlay.this.mBufferProgress = i;
                        if (APlayerAndroid.this.mOnBufferListener != null) {
                            APlayerAndroid.this.mOnBufferListener.onBuffer(i);
                        }
                    }
                });
                this.mPlayer.setOnCompletionListener(new OnCompletionListener(APlayerAndroid.this) {
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Log.i(APlayerAndroid.TAG, "mediaplayer setOnCompletionListener");
                        SystemMediaPlay.this.mState = 0;
                        if (APlayerAndroid.this.mOnPlayCompleteListener != null) {
                            APlayerAndroid.this.mOnPlayCompleteListener.onPlayComplete(PlayCompleteRet.PLAYRE_RESULT_COMPLETE);
                        }
                    }
                });
                this.mPlayer.setOnPreparedListener(new OnPreparedListener(APlayerAndroid.this) {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        Log.i(APlayerAndroid.TAG, "mediaplayer setOnPreparedListener");
                        if (SystemMediaPlay.this.mState == 7) {
                            SystemMediaPlay.this.mPlayer.start();
                            SystemMediaPlay.this.mState = 4;
                            return;
                        }
                        SystemMediaPlay.this.mState = 3;
                        APlayerAndroid.this.mIsSuccess = true;
                        APlayerAndroid.this.openSuccess();
                    }
                });
            }
        }

        public boolean hasMediaPlayer() {
            return this.mPlayer != null;
        }

        public int release() {
            if (this.mState != 0) {
                close();
            }
            this.mPlayer.release();
            this.mPlayer = null;
            return 1;
        }

        public int SetView(Surface surface) {
            this.mPlayer.setSurface(surface);
            return 1;
        }

        public int open(String str) {
            Log.i(APlayerAndroid.TAG, "SystemMediaPlay open enter");
            this.mMediaPath = str;
            if (this.mState != 0) {
                return -1;
            }
            this.mState = 1;
            try {
                this.mPlayer.setDataSource(this.mMediaPath);
                this.mPlayer.prepareAsync();
                return 1;
            } catch (IOException e) {
                String access$000 = APlayerAndroid.TAG;
                StringBuilder stringBuilder = new StringBuilder("SystemMediaPlay IOException: ");
                stringBuilder.append(e.toString());
                Log.i(access$000, stringBuilder.toString());
                if (APlayerAndroid.this.OnSystemPlayerFailListener != null) {
                    APlayerAndroid.this.OnSystemPlayerFailListener.onSystemPlayerFail();
                }
                release();
                str = APlayerAndroid.this.native_open(str, APlayerAndroid.this.mObjId);
                if (str != -1) {
                    return str;
                }
                throw new RuntimeException("state is not right or other fatal error");
            }
        }

        public int close() {
            Log.i(APlayerAndroid.TAG, "SystemMediaPlay close enter");
            if (this.mState == 0) {
                return -1;
            }
            this.mState = 6;
            this.mPlayer.stop();
            this.mState = 0;
            return 1;
        }

        public int play() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = com.aplayer.aplayerandroid.APlayerAndroid.TAG;
            r1 = "SystemMediaPlay play enter";
            com.aplayer.aplayerandroid.Log.i(r0, r1);
            r0 = r2.mState;
            r1 = 7;
            if (r0 != r1) goto L_0x0026;
        L_0x000e:
            r0 = com.aplayer.aplayerandroid.APlayerAndroid.TAG;	 Catch:{ IOException -> 0x0026 }
            r1 = "ReSet DataSource";	 Catch:{ IOException -> 0x0026 }
            com.aplayer.aplayerandroid.Log.e(r0, r1);	 Catch:{ IOException -> 0x0026 }
            r0 = 1;	 Catch:{ IOException -> 0x0026 }
            r2.mState = r0;	 Catch:{ IOException -> 0x0026 }
            r0 = r2.mPlayer;	 Catch:{ IOException -> 0x0026 }
            r1 = r2.mMediaPath;	 Catch:{ IOException -> 0x0026 }
            r0.setDataSource(r1);	 Catch:{ IOException -> 0x0026 }
            r0 = r2.mPlayer;	 Catch:{ IOException -> 0x0026 }
            r0.prepareAsync();	 Catch:{ IOException -> 0x0026 }
        L_0x0026:
            r0 = r2.mState;
            r1 = 3;
            if (r0 != r1) goto L_0x0033;
        L_0x002b:
            r0 = r2.mPlayer;
            r0.start();
            r0 = 4;
            r2.mState = r0;
        L_0x0033:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aplayer.aplayerandroid.APlayerAndroid.SystemMediaPlay.play():int");
        }

        public int pause() {
            this.mState = 2;
            this.mPlayer.pause();
            this.mState = 3;
            return 1;
        }

        public int getDuration() {
            return this.mState != 0 ? this.mPlayer.getDuration() : 0;
        }

        public int getPosition() {
            return this.mState != 0 ? this.mPlayer.getCurrentPosition() : 0;
        }

        public int setPosition(int i) {
            if (this.mState != 0) {
                this.mPlayer.seekTo(i);
            }
            return 1;
        }

        public int getVideoWidth() {
            return this.mState != 0 ? this.mPlayer.getVideoWidth() : 0;
        }

        public int getVideoHeight() {
            return this.mState != 0 ? this.mPlayer.getVideoHeight() : 0;
        }

        public int getBufferProgress() {
            return this.mBufferProgress;
        }

        public int getState() {
            return this.mState;
        }

        private int onSystemMediaPlayerError() {
            int access$4400 = APlayerAndroid.this.native_open(this.mMediaPath, APlayerAndroid.this.mObjId);
            if (APlayerAndroid.this.OnSystemPlayerFailListener != null) {
                APlayerAndroid.this.OnSystemPlayerFailListener.onSystemPlayerFail();
            }
            return access$4400;
        }
    }

    public static String getVersion() {
        return Version.FULL_VERSION;
    }

    private native int native_close(int i);

    private native int native_end_record(int i);

    private native void native_forceUpdate(int i);

    private native int native_getOpenStatisticsInfo(Object obj, int i);

    private native int native_getState(int i);

    private native int native_get_current_screenshot(Object obj, int i);

    private native int native_getbufferprogress(int i);

    private native String native_getconfig(int i, int i2);

    private native int native_getduration(int i);

    private native int native_getheight(int i);

    private native int native_getposition(int i);

    private native int native_getwidth(int i);

    private native int native_init(Object obj, int i);

    private native int native_is_recording(int i);

    private native int native_is_support_record(int i);

    private native int native_isseeking(int i);

    private native int native_open(String str, int i);

    private native void native_openLog(boolean z);

    private native int native_pause(int i);

    private native int native_play(int i);

    private native int native_rotate(float f, float f2, int i);

    private native int native_setVideoOrientation(int i, int i2);

    private native int native_setconfig(int i, String str, int i2);

    private native int native_setdisplay(Surface surface, int i);

    private native int native_setposition(int i, boolean z, int i2);

    private native int native_start_record(String str, int i, int i2, int i3);

    private native int native_stop_read(boolean z, int i);

    private native void native_surfaceSizeChange(int i, int i2, int i3);

    private native int native_uninit(int i);

    public int getVolume() {
        return 0;
    }

    public int setVolume(int i) {
        return 0;
    }

    static {
        try {
            System.loadLibrary(Version.LIB_APLAYER_FFMPEG_NAME);
            System.loadLibrary(Version.LIB_APLAYER_ANDROID_NAME);
        } catch (Exception e) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("loadLibrary aplayer_android fail");
            stringBuilder.append(e.toString());
            Log.e(str, stringBuilder.toString());
        }
    }

    public APlayerAndroid() {
        Log.e(TAG, "APlayerAndroid construct");
        synchronized (APlayerAndroid.class) {
            int i = gObjId;
            gObjId = i + 1;
            this.mObjId = i;
        }
        this.mHwDecoder = new HardwareDecoder(this);
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            this.mEventHandler = null;
        }
        this.mIsSourceChanged = false;
        native_init(new WeakReference(this), this.mObjId);
        openLog(true);
    }

    public void destroy() {
        if (!this.mDestroy) {
            if (getState() == 0) {
                this.mDestroy = true;
                native_uninit(this.mObjId);
                Log.i(TAG, "aplayer destroy");
            } else {
                this.mDestroy = true;
                close();
            }
            if (this.mRetriever != null) {
                this.mRetriever.release();
                this.mRetriever = null;
            }
            this.mIsSourceChanged = false;
        }
    }

    public int setView(Surface surface) {
        if (this.mDestroy) {
            return 0;
        }
        this.mSurfaceType = 0;
        this.mSurface = surface;
        if (this.mSurface != null) {
            native_setdisplay(this.mSurface, this.mObjId);
            if (isSystemPlayer() != null) {
                this.mSystemPlayer.SetView(this.mSurface);
            }
        } else if (isHwDecode() != null) {
            this.mHwDecoder.stopCodec();
        }
        return 0;
    }

    public int setView(TextureView textureView) {
        if (this.mDestroy) {
            return 0;
        }
        this.mSurfaceType = 1;
        Log.i(TAG, "SetView TextureView");
        this.mHwDecoder.setRenderType(0);
        this.mSurfaceview = textureView;
        textureView.setScaleX(1.00001f);
        if (textureView.isAvailable()) {
            this.mSurface = new Surface(textureView.getSurfaceTexture());
            if (isSystemPlayer()) {
                this.mSystemPlayer.SetView(this.mSurface);
            }
            native_setdisplay(this.mSurface, this.mObjId);
        }
        textureView.setSurfaceTextureListener(new SurfaceTextureListener() {
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                surfaceTexture = APlayerAndroid.TAG;
                StringBuilder stringBuilder = new StringBuilder("TextureView SizeChanged width=");
                stringBuilder.append(i);
                stringBuilder.append(", height = ");
                stringBuilder.append(i2);
                Log.i(surfaceTexture, stringBuilder.toString());
                if (APlayerAndroid.this.mDestroy == null) {
                    APlayerAndroid.this.native_surfaceSizeChange(i, i2, APlayerAndroid.this.mObjId);
                    APlayerAndroid.this.changeSubtitleViewSize();
                }
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Log.v(APlayerAndroid.TAG, "TextureView Destroyed");
                APlayerAndroid.this.native_setdisplay(null, APlayerAndroid.this.mObjId);
                if (!(APlayerAndroid.this.isSystemPlayer() != null || APlayerAndroid.this.isHwDecode() == null || APlayerAndroid.this.mHwDecoder.IsCodecPrepare() == null)) {
                    Log.e(APlayerAndroid.TAG, "!IsSystemPlayer() && isHwDecode()");
                    APlayerAndroid.this.mReCreateHwCodecState = APlayerAndroid.this.getState();
                    surfaceTexture = APlayerAndroid.TAG;
                    StringBuilder stringBuilder = new StringBuilder("mSilenceAudio = ");
                    stringBuilder.append(APlayerAndroid.this.mSilenceAudio);
                    Log.i(surfaceTexture, stringBuilder.toString());
                    APlayerAndroid.this.native_setconfig(420, "1", APlayerAndroid.this.mObjId);
                    APlayerAndroid.this.native_pause(APlayerAndroid.this.mObjId);
                    APlayerAndroid.this.mHwDecoder.stopCodec();
                    APlayerAndroid.this.mHwReCreatePos = APlayerAndroid.this.getPosition();
                }
                if (APlayerAndroid.this.mOnSurfaceDestroyListener != null) {
                    APlayerAndroid.this.mOnSurfaceDestroyListener.onSurfaceDestroy();
                }
                return true;
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.i(APlayerAndroid.TAG, "TextureView Created");
                if (APlayerAndroid.this.mDestroy == 0) {
                    APlayerAndroid.this.mSurface = new Surface(surfaceTexture);
                    if (APlayerAndroid.this.isSystemPlayer() != null) {
                        APlayerAndroid.this.mSystemPlayer.SetView(APlayerAndroid.this.mSurface);
                    }
                    APlayerAndroid.this.native_setdisplay(APlayerAndroid.this.mSurface, APlayerAndroid.this.mObjId);
                    if ((APlayerAndroid.this.mReCreateHwCodecState == 3 || APlayerAndroid.this.mReCreateHwCodecState == 2 || APlayerAndroid.this.mReCreateHwCodecState == 5 || APlayerAndroid.this.mReCreateHwCodecState == 4) && APlayerAndroid.this.isHwDecode() != null) {
                        Log.e(APlayerAndroid.TAG, "ReCreateCodec");
                        APlayerAndroid.this.mHwDecoder.ReCreateCodec();
                        APlayerAndroid.this.setPosition(APlayerAndroid.this.mHwReCreatePos);
                        APlayerAndroid.this.mHwDecoder.setOnDecoderOneFrameListener(new OnDecoderOneFrameListener() {
                            public void onDecoderOneFrame() {
                                APlayerAndroid.this.mHwDecoder.setOnDecoderOneFrameListener(null);
                                new Thread(new Runnable() {
                                    public void run() {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        APlayerAndroid.this.setConfig(420, APlayerAndroid.this.mSilenceAudio);
                                    }
                                }).start();
                                if (APlayerAndroid.this.mReCreateHwCodecState == 3) {
                                    APlayerAndroid.this.pause();
                                }
                                APlayerAndroid.this.mReCreateHwCodecState = 0;
                                if (APlayerAndroid.this.mOnReCreateHwDecoderListener != null) {
                                    APlayerAndroid.this.mOnReCreateHwDecoderListener.onReCreateHwDecoder();
                                }
                            }
                        });
                        if (APlayerAndroid.this.mHwDecoder.IsCodecPrepare() != null) {
                            APlayerAndroid.this.native_play(APlayerAndroid.this.mObjId);
                        }
                    }
                }
            }
        });
        return 1;
    }

    public int setView(SurfaceView surfaceView) {
        if (this.mDestroy) {
            return 0;
        }
        this.mSurfaceType = 2;
        if (getAndroidLevel() >= 20) {
            this.mHwDecoder.setRenderType(2);
        } else {
            this.mHwDecoder.setRenderType(0);
        }
        this.mSurfaceview = surfaceView;
        this.mSurface = surfaceView.getHolder().getSurface();
        if (this.mSurface.isValid()) {
            if (isSystemPlayer()) {
                this.mSystemPlayer.SetView(this.mSurface);
            }
            native_setdisplay(this.mSurface, this.mObjId);
        } else {
            Log.i(TAG, "surface is not valid");
            this.mSurface = null;
        }
        this.mViewSurfaceWidth = surfaceView.getWidth();
        this.mViewSurfaceHeight = surfaceView.getHeight();
        surfaceView.getHolder().addCallback(new Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                surfaceHolder = APlayerAndroid.TAG;
                StringBuilder stringBuilder = new StringBuilder("surface Changed format=");
                stringBuilder.append(i);
                stringBuilder.append(", width=");
                stringBuilder.append(i2);
                stringBuilder.append(", height=");
                stringBuilder.append(i3);
                Log.i(surfaceHolder, stringBuilder.toString());
                if (APlayerAndroid.this.mDestroy == null) {
                    APlayerAndroid.this.mViewSurfaceWidth = i2;
                    APlayerAndroid.this.mViewSurfaceHeight = i3;
                    if (APlayerAndroid.this.mOnSurfaceChangeListener != null) {
                        APlayerAndroid.this.mOnSurfaceChangeListener.onSurfaceChange(i2, i3);
                    }
                    APlayerAndroid.this.native_surfaceSizeChange(i2, i3, APlayerAndroid.this.mObjId);
                    APlayerAndroid.this.changeSubtitleViewSize();
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Log.i(APlayerAndroid.TAG, "surface Created");
                if (!APlayerAndroid.this.mDestroy) {
                    APlayerAndroid.this.mSurface = surfaceHolder.getSurface();
                    if (APlayerAndroid.this.isSystemPlayer() != null) {
                        APlayerAndroid.this.mSystemPlayer.SetView(APlayerAndroid.this.mSurface);
                    }
                    APlayerAndroid.this.native_setdisplay(APlayerAndroid.this.mSurface, APlayerAndroid.this.mObjId);
                    if ((APlayerAndroid.this.mReCreateHwCodecState == 3 || APlayerAndroid.this.mReCreateHwCodecState == 2 || APlayerAndroid.this.mReCreateHwCodecState == 5 || APlayerAndroid.this.mReCreateHwCodecState == 4) && APlayerAndroid.this.isHwDecode() != null) {
                        Log.e(APlayerAndroid.TAG, "lzm ReCreateCodec");
                        APlayerAndroid.this.mHwDecoder.ReCreateCodec();
                        APlayerAndroid.this.setPosition(APlayerAndroid.this.mHwReCreatePos);
                        APlayerAndroid.this.mHwDecoder.setOnDecoderOneFrameListener(new OnDecoderOneFrameListener() {
                            public void onDecoderOneFrame() {
                                APlayerAndroid.this.mHwDecoder.setOnDecoderOneFrameListener(null);
                                new Thread(new Runnable() {
                                    public void run() {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        APlayerAndroid.this.setConfig(420, APlayerAndroid.this.mSilenceAudio);
                                    }
                                }).start();
                                if (APlayerAndroid.this.mReCreateHwCodecState == 3) {
                                    APlayerAndroid.this.pause();
                                }
                                APlayerAndroid.this.mReCreateHwCodecState = 0;
                                if (APlayerAndroid.this.mOnReCreateHwDecoderListener != null) {
                                    APlayerAndroid.this.mOnReCreateHwDecoderListener.onReCreateHwDecoder();
                                }
                            }
                        });
                        if (APlayerAndroid.this.mHwDecoder.IsCodecPrepare() != null) {
                            APlayerAndroid.this.native_play(APlayerAndroid.this.mObjId);
                        }
                    }
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                Log.i(APlayerAndroid.TAG, "surface Destroyed");
                APlayerAndroid.this.mSurface = null;
                APlayerAndroid.this.native_setdisplay(null, APlayerAndroid.this.mObjId);
                if (!(APlayerAndroid.this.isSystemPlayer() != null || APlayerAndroid.this.isHwDecode() == null || APlayerAndroid.this.mHwDecoder.IsCodecPrepare() == null)) {
                    Log.e(APlayerAndroid.TAG, "!IsSystemPlayer() && isHwDecode()");
                    if (APlayerAndroid.this.mActivityPause == null) {
                        APlayerAndroid.this.mReCreateHwCodecState = APlayerAndroid.this.getState();
                    }
                    surfaceHolder = APlayerAndroid.TAG;
                    StringBuilder stringBuilder = new StringBuilder("mSilenceAudio = ");
                    stringBuilder.append(APlayerAndroid.this.mSilenceAudio);
                    Log.i(surfaceHolder, stringBuilder.toString());
                    APlayerAndroid.this.native_setconfig(420, "1", APlayerAndroid.this.mObjId);
                    APlayerAndroid.this.native_pause(APlayerAndroid.this.mObjId);
                    APlayerAndroid.this.mHwDecoder.stopCodec();
                    APlayerAndroid.this.mHwReCreatePos = APlayerAndroid.this.getPosition();
                }
                if (APlayerAndroid.this.mOnSurfaceDestroyListener != null) {
                    APlayerAndroid.this.mOnSurfaceDestroyListener.onSurfaceDestroy();
                }
            }
        });
        return 0;
    }

    public void useSystemPlayer(boolean z) {
        this.mIsCurrentUseSysmediaplay = z;
        if (!z) {
            return;
        }
        if (!this.mSystemPlayer || !this.mSystemPlayer.hasMediaPlayer()) {
            this.mSystemPlayer = new SystemMediaPlay();
        }
    }

    public boolean isSystemPlayer() {
        return this.mIsCurrentUseSysmediaplay && this.mSystemPlayer != null && this.mSystemPlayer.hasMediaPlayer();
    }

    public int open(String str) {
        if (this.mDestroy) {
            return 0;
        }
        this.mPath = str;
        this.mIsSuccess = false;
        this.mBufferProgress = 100;
        if (str != null && str.indexOf("https") == 0) {
            setConfig(CONFIGID.HTTP_USER_AHTTP, "1");
        }
        if (this.mUpdateSurfaceView) {
            if (this.mSurfaceview != null) {
                this.mSurfaceview.setVisibility(4);
                this.mSurfaceview.setVisibility(0);
            }
            this.mUpdateSurfaceView = false;
        }
        this.mIsSourceChanged = true;
        if (isSystemPlayer()) {
            return this.mSystemPlayer.open(str);
        }
        str = native_open(str, this.mObjId);
        if (str == -1) {
            Log.e(TAG, "throw Exception state is not right or other fatal error");
        }
        this.mHwDecoder.setOnDecoderOneFrameListener(new OnDecoderOneFrameListener() {
            public void onDecoderOneFrame() {
                APlayerAndroid.this.mHwDecoder.setOnDecoderOneFrameListener(null);
                Message obtainMessage = APlayerAndroid.this.mEventHandler.obtainMessage(104, 0, 0, null);
                if (obtainMessage != null) {
                    obtainMessage.what = 104;
                    APlayerAndroid.this.mEventHandler.sendMessage(obtainMessage);
                }
            }
        });
        return str;
    }

    public int open(FileDescriptor fileDescriptor) {
        if (this.mDestroy) {
            return 0;
        }
        this.mFileDescriptor = fileDescriptor;
        this.mIsSuccess = false;
        this.mBufferProgress = 100;
        this.mExtIO = new ALocalFile(fileDescriptor);
        setExtIO(this.mExtIO);
        fileDescriptor = native_open("c:\\", this.mObjId);
        if (fileDescriptor == -1) {
            Log.e(TAG, "throw Exception state is not right or other fatal error");
        }
        this.mIsSourceChanged = true;
        return fileDescriptor;
    }

    public int close() {
        this.mIsSourceChanged = false;
        if (isSystemPlayer()) {
            return this.mSystemPlayer.close();
        }
        this.mFileDescriptor = null;
        this.mPath = null;
        this.mStretchMode = 0;
        return native_close(this.mObjId);
    }

    public int play() {
        if (this.mDestroy) {
            return 0;
        }
        this.mReCreateHwCodecState = 5;
        createSubtitleView();
        if (!this.mIsSuccess) {
            return 0;
        }
        if (isSystemPlayer()) {
            return this.mSystemPlayer.play();
        }
        if (!isHwDecode() || this.mHwDecoder.IsCodecPrepare()) {
            return native_play(this.mObjId);
        }
        return 0;
    }

    public int activityPause() {
        Log.i(TAG, "activityPause");
        this.mReCreateHwCodecState = getState();
        this.mActivityPause = true;
        return native_pause(this.mObjId);
    }

    public int activityResume() {
        Log.i(TAG, "activityResume");
        this.mActivityPause = false;
        if (this.mReCreateHwCodecState != 5) {
            if (this.mReCreateHwCodecState != 4) {
                return 0;
            }
        }
        if (!isHwDecode() || this.mHwDecoder.IsCodecPrepare()) {
            return native_play(this.mObjId);
        }
        return 0;
    }

    public int pause() {
        if (this.mDestroy) {
            return 0;
        }
        this.mReCreateHwCodecState = 3;
        if (isSystemPlayer()) {
            return this.mSystemPlayer.pause();
        }
        return native_pause(this.mObjId);
    }

    public int getState() {
        if (this.mDestroy) {
            return 0;
        }
        if (isSystemPlayer()) {
            return this.mSystemPlayer.getState();
        }
        return native_getState(this.mObjId);
    }

    public int getDuration() {
        if (this.mDestroy) {
            return 0;
        }
        if (isSystemPlayer()) {
            return this.mSystemPlayer.getDuration();
        }
        return native_getduration(this.mObjId);
    }

    public int getPosition() {
        if (this.mDestroy) {
            return 0;
        }
        if (isSystemPlayer()) {
            return this.mSystemPlayer.getPosition();
        }
        return native_getposition(this.mObjId);
    }

    public int setPosition(int i) {
        return setPosition(i, false);
    }

    public int setPosition(int i, boolean z) {
        if (this.mDestroy) {
            return 0;
        }
        this.mHwReCreatePos = i;
        if (isSystemPlayer()) {
            return this.mSystemPlayer.setPosition(i);
        }
        return native_setposition(i, z, this.mObjId);
    }

    public int getVideoWidth() {
        if (this.mDestroy) {
            return 0;
        }
        if (isSystemPlayer()) {
            return this.mSystemPlayer.getVideoWidth();
        }
        return native_getwidth(this.mObjId);
    }

    public int getVideoHeight() {
        if (this.mDestroy) {
            return 0;
        }
        if (isSystemPlayer()) {
            return this.mSystemPlayer.getVideoHeight();
        }
        return native_getheight(this.mObjId);
    }

    public int getBufferProgress() {
        if (this.mDestroy) {
            return 0;
        }
        if (isSystemPlayer()) {
            return this.mSystemPlayer.getBufferProgress();
        }
        return this.mBufferProgress;
    }

    public String getConfig(int i) {
        if (this.mDestroy) {
            return "";
        }
        if (isSystemPlayer()) {
            return "";
        }
        if (i == 8) {
            return config_get_auto_play();
        }
        if (i == 202) {
            i = new StringBuilder();
            i.append(this.mStretchMode);
            return i.toString();
        } else if (i == CONFIGID.VR_ENABLE_INNER_TOUCH_ROTATE) {
            return config_get_vr_touch_rotate();
        } else {
            switch (i) {
                case 503:
                    return config_get_subtitle_file_name();
                case 504:
                    return config_get_subtitle_show();
                default:
                    return native_getconfig(i, this.mObjId);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setConfig(int r4, java.lang.String r5) {
        /*
        r3 = this;
        r0 = r3.mDestroy;
        r1 = 0;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r3.isSystemPlayer();
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return r1;
    L_0x000d:
        r0 = TAG;
        r1 = new java.lang.StringBuilder;
        r2 = "SetConfig ";
        r1.<init>(r2);
        r1.append(r5);
        r1 = r1.toString();
        com.aplayer.aplayerandroid.Log.i(r0, r1);
        switch(r4) {
            case 8: goto L_0x0062;
            case 202: goto L_0x0055;
            case 209: goto L_0x0050;
            case 420: goto L_0x0047;
            case 503: goto L_0x0042;
            case 504: goto L_0x003d;
            case 1109: goto L_0x0038;
            case 1110: goto L_0x0033;
            case 1111: goto L_0x002e;
            case 4000: goto L_0x0024;
            case 4001: goto L_0x002a;
            case 4002: goto L_0x0027;
            default: goto L_0x0023;
        };
    L_0x0023:
        goto L_0x0067;
    L_0x0024:
        java.lang.Integer.parseInt(r5);
    L_0x0027:
        java.lang.Integer.parseInt(r5);
    L_0x002a:
        java.lang.Integer.parseInt(r5);
        goto L_0x0067;
    L_0x002e:
        r4 = r3.config_set_ahttp_use_cache(r5);
        return r4;
    L_0x0033:
        r4 = r3.config_set_ahttp_cache_dir(r5);
        return r4;
    L_0x0038:
        r4 = r3.config_set_ahttp(r5);
        return r4;
    L_0x003d:
        r4 = r3.config_set_subtitle_show(r5);
        return r4;
    L_0x0042:
        r4 = r3.config_set_subtitle_file_name(r5);
        return r4;
    L_0x0047:
        r3.mSilenceAudio = r5;
        r0 = r3.mObjId;
        r4 = r3.native_setconfig(r4, r5, r0);
        return r4;
    L_0x0050:
        r4 = r3.config_set_hwdecode_use(r5);
        return r4;
    L_0x0055:
        r0 = java.lang.Integer.parseInt(r5);
        r3.mStretchMode = r0;
        r0 = r3.mObjId;
        r4 = r3.native_setconfig(r4, r5, r0);
        return r4;
    L_0x0062:
        r4 = r3.config_set_auto_play(r5);
        return r4;
    L_0x0067:
        r0 = r3.mObjId;
        r4 = r3.native_setconfig(r4, r5, r0);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.aplayerandroid.APlayerAndroid.setConfig(int, java.lang.String):int");
    }

    public int setVideoOrientation(int i) {
        if (this.mDestroy || isSystemPlayer()) {
            return 0;
        }
        return native_setVideoOrientation(i, this.mObjId);
    }

    private boolean isHwDecode() {
        return getConfig(209).equals("1") && getConfig(CONFIGID.HW_DECODER_ENABLE).equals("1");
    }

    private int config_set_subtitle_show(String str) {
        this.mSubtitleShow = str;
        if (this.mSubtilteview == null) {
            createSubtitleView();
        }
        if (this.mSubtilteview == null) {
            return 0;
        }
        if (str.equalsIgnoreCase("1") != null) {
            this.mSubtilteview.setVisibility(0);
        } else {
            this.mSubtilteview.setVisibility(4);
        }
        return 1;
    }

    private int config_set_subtitle_show_external(String str) {
        if (str.equalsIgnoreCase("1") != null) {
            this.mSubtitleShowExternal = true;
        } else {
            this.mSubtitleShowExternal = null;
        }
        return 1;
    }

    private String config_get_subtitle_show_external() {
        return this.mSubtitleShowExternal ? "1" : "0";
    }

    private String config_get_subtitle_show() {
        return this.mSubtitleShow;
    }

    private int config_set_auto_play(String str) {
        this.mIsAutoPlay = str.equalsIgnoreCase("1");
        return 1;
    }

    private String config_get_auto_play() {
        return this.mIsAutoPlay ? "1" : "0";
    }

    private int config_set_subtitle_file_name(String str) {
        this.mFileName = str;
        return native_setconfig(503, str, this.mObjId);
    }

    private String config_get_subtitle_file_name() {
        return this.mFileName;
    }

    private String config_get_vr_touch_rotate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mIsVrTouchRotateEnable);
        return stringBuilder.toString();
    }

    private int config_set_hwdecode_use(String str) {
        if (getConfig(209).equals(str)) {
            return 1;
        }
        int state = getState();
        if (!(state == 3 || state == 2 || state == 5)) {
            if (state != 4) {
                native_setconfig(209, str, this.mObjId);
                return 1;
            }
        }
        return null;
    }

    private int config_set_ahttp(String str) {
        if (str.equals("1") != null) {
            if (this.mExtIO != null && (this.mExtIO instanceof AHttp) == null) {
                this.mExtIO.close("");
                this.mExtIO = null;
            }
            if (this.mExtIO == null) {
                this.mExtIO = new AHttp();
            }
            if (this.mExtIO != null) {
                setExtIO(this.mExtIO);
            }
        } else {
            this.mExtIO = null;
            setExtIO(null);
        }
        return 1;
    }

    private int config_set_aLocalFileDesp(String str) {
        if (str.equals("1") != null) {
            if (this.mExtIO != null && (this.mExtIO instanceof ALocalFile) == null) {
                this.mExtIO.close("");
                this.mExtIO = null;
            }
            if (this.mExtIO == null) {
                this.mExtIO = new ALocalFile(this.mFileDescriptor);
            }
            if (this.mExtIO != null) {
                setExtIO(this.mExtIO);
            }
        } else {
            this.mExtIO = null;
            setExtIO(null);
        }
        return 1;
    }

    private int config_set_ahttp_cache_dir(String str) {
        if (this.mExtIO == null) {
            Log.i(TAG, "new AHttp");
            this.mExtIO = new AHttp();
        }
        if (this.mExtIO != null) {
            ((AHttp) this.mExtIO).setCacheFileDir(str);
        }
        return 1;
    }

    private int config_set_ahttp_use_cache(String str) {
        if (this.mExtIO == null) {
            this.mExtIO = new AHttp();
        }
        if (this.mExtIO != null) {
            if (str.equalsIgnoreCase("1") != null) {
                ((AHttp) this.mExtIO).setUseCache(true);
            } else {
                ((AHttp) this.mExtIO).setUseCache(false);
            }
        }
        return 1;
    }

    public static MediaInfo parseThumbnail(String str, long j, int i, int i2) {
        if (str == null) {
            Log.e(TAG, "parseThumbnail null path");
            return null;
        }
        XLMediaMetaDataRetriever xLMediaMetaDataRetriever = new XLMediaMetaDataRetriever();
        if (xLMediaMetaDataRetriever.setDataSource(str) < null) {
            xLMediaMetaDataRetriever.release();
            Log.e(TAG, "parseThumbnail retriever setDataSource failed");
            return null;
        }
        str = new MediaInfo();
        str.show_ms = j;
        str.is_key_frame = true;
        str.file_size = xLMediaMetaDataRetriever.getFileSize();
        str.duration_ms = (long) xLMediaMetaDataRetriever.getDuraton();
        str.avg_luma = 123;
        str.angle = String.valueOf(xLMediaMetaDataRetriever.getRotation());
        str.bitMap = xLMediaMetaDataRetriever.getKeyFrameAtTime((int) j, i, i2);
        str.height = xLMediaMetaDataRetriever.getHeight();
        str.width = xLMediaMetaDataRetriever.getWidth();
        xLMediaMetaDataRetriever.release();
        return str;
    }

    public MediaInfo parseThumbnail(long j, int i, int i2) {
        if (this.mIsSourceChanged) {
            if (this.mRetriever != null) {
                this.mRetriever.release();
                this.mRetriever = null;
            }
            this.mRetriever = new XLMediaMetaDataRetriever();
            if (this.mRetriever == null) {
                return null;
            }
            if (this.mPath != null || this.mFileDescriptor == null) {
                if (this.mPath != null) {
                    this.mRetriever.setDataSource(this.mPath);
                }
                this.mIsSourceChanged = false;
            } else {
                this.mRetriever.release();
                Log.e(TAG, "can not parse for FileDescriptor now!");
                return null;
            }
        }
        if (this.mRetriever == null) {
            return null;
        }
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.show_ms = j;
        mediaInfo.is_key_frame = true;
        mediaInfo.width = this.mRetriever.getWidth();
        mediaInfo.height = this.mRetriever.getHeight();
        mediaInfo.angle = String.valueOf(this.mRetriever.getRotation());
        mediaInfo.duration_ms = (long) this.mRetriever.getDuraton();
        mediaInfo.avg_luma = 123;
        mediaInfo.bitMap = this.mRetriever.getKeyFrameAtTime((int) j, i, i2);
        mediaInfo.file_size = this.mRetriever.getFileSize();
        return mediaInfo;
    }

    public static MediaInfo parseThumbnail(String str) {
        return str == null ? null : parseThumbnail(str, -1, -1, -1);
    }

    public boolean isSupportRecord() {
        if (this.mDestroy || native_is_support_record(this.mObjId) == 0) {
            return false;
        }
        return true;
    }

    public boolean startRecord(String str, int i, int i2) {
        Log.i(TAG, "startRecord");
        if (!(this.mDestroy || str == null)) {
            if (!str.isEmpty()) {
                int lastIndexOf = str.lastIndexOf(92);
                if (-1 == lastIndexOf) {
                    lastIndexOf = str.lastIndexOf(47);
                }
                if (-1 != lastIndexOf && isFolderExists(str.substring(0, lastIndexOf)) && 1 == native_start_record(str, this.mObjId, i, i2)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean startRecord(String str, int i) {
        return startRecord(str, -1, getPosition() + i);
    }

    public boolean startRecord(String str) {
        Log.i(TAG, "java startRecord");
        return startRecord(str, -1, -1);
    }

    public boolean isRecording() {
        if (this.mDestroy || native_is_recording(this.mObjId) == 0) {
            return false;
        }
        return true;
    }

    public void endRecord() {
        Log.i(TAG, "endRecord");
        if (!this.mDestroy) {
            native_end_record(this.mObjId);
            Log.i(TAG, "endRecord leave");
        }
    }

    public void stopRead(boolean z) {
        if (!this.mDestroy) {
            native_stop_read(z, this.mObjId);
        }
    }

    public Bitmap getCurrentScreenshot() {
        if (isHwDecode()) {
            Log.i(TAG, "hardward  getCurrentScreenshot");
            return this.mHwDecoder.getCurrentScreenshot();
        }
        MediaInfo mediaInfo = new MediaInfo();
        if (native_get_current_screenshot(mediaInfo, this.mObjId) != 0) {
            return null;
        }
        int videoWidth = getVideoWidth();
        int videoHeight = getVideoHeight();
        int[] iArr = new int[(videoWidth * videoHeight)];
        for (int i = 0; i < videoHeight; i++) {
            for (int i2 = 0; i2 < videoWidth; i2++) {
                int i3 = (i * videoWidth) + i2;
                int i4 = 3 * i3;
                iArr[i3] = (mediaInfo.bitMap[i4] & 255) | ((((mediaInfo.bitMap[i4 + 2] << 16) & 16711680) | -16777216) | ((mediaInfo.bitMap[i4 + 1] << 8) & 65280));
            }
        }
        return Bitmap.createBitmap(iArr, videoWidth, videoHeight, Config.ARGB_8888);
    }

    protected synchronized HardwareEncoder getEncodeCore() {
        if (this.mHardwareEncoder == null) {
            this.mHardwareEncoder = new HardwareEncoder(this);
        }
        return this.mHardwareEncoder;
    }

    public void openLog(boolean z) {
        Log.setOpenLog(z);
        native_openLog(z);
    }

    public void forceUpdate() {
        Log.i(TAG, "forceUpdate");
        native_forceUpdate(this.mObjId);
    }

    public StatisticsInfo getStatisticsInfo() {
        StatisticsInfo statisticsInfo = new StatisticsInfo();
        native_getOpenStatisticsInfo(statisticsInfo, this.mObjId);
        return statisticsInfo;
    }

    private void reOpen() {
        if (!this.mDestroy) {
            setConfig(209, "0");
            if (this.mPath != null) {
                open(this.mPath);
                return;
            }
            if (this.mFileDescriptor != null) {
                open(this.mFileDescriptor);
            }
        }
    }

    private int openSuccess() {
        this.mIsSuccess = true;
        if (this.mIsAutoPlay) {
            play();
        }
        if (this.mOnOpenSuccessListener != null) {
            this.mOnOpenSuccessListener.onOpenSuccess();
        }
        if (this.mOnOpenCompleteListener != null) {
            this.mOnOpenCompleteListener.onOpenComplete(true);
        }
        if (!isHwDecode()) {
            this.mUpdateSurfaceView = true;
        }
        return 1;
    }

    private void stateChange(int i, int i2, Object obj) {
        if (i == 6 && i2 == 0) {
            i = getStatisticsInfo();
            i2 = TAG;
            StringBuilder stringBuilder = new StringBuilder("statisticsInfo ");
            stringBuilder.append(i.audioCodecName);
            stringBuilder.append(" ");
            stringBuilder.append(i.videoCodecName);
            stringBuilder.append(" ");
            stringBuilder.append(i.subtitleCodecName);
            stringBuilder.append(" ");
            stringBuilder.append(i.containerName);
            stringBuilder.append(" ");
            stringBuilder.append(i.error);
            stringBuilder.append(i.streamType);
            stringBuilder.append(" ");
            stringBuilder.append(i.videoFrameRate);
            Log.i(i2, stringBuilder.toString());
            if (isHwDecode() != 0) {
                this.mHwDecoder.stopCodec();
            }
            if (this.mOnPlayCompleteListener != 0) {
                String str = (String) obj;
                if (str.equals(PlayCompleteRet.PLAYRE_RESULT_HARDDECODERROR) == 0 || this.mDestroy != 0) {
                    this.mOnPlayCompleteListener.onPlayComplete(str);
                } else {
                    reOpen();
                    return;
                }
            }
            String str2 = (String) obj;
            if (!(str2.equals(PlayCompleteRet.PLAYRE_RESULT_OPENRROR) == 0 || this.mOnOpenCompleteListener == 0)) {
                this.mOnOpenCompleteListener.onOpenComplete(0);
            }
            if (this.mExtIO != 0) {
                setExtIO(null);
                this.mExtIO = null;
            }
            if (this.mDestroy != 0) {
                native_uninit(this.mObjId);
                Log.i(TAG, "aplayer destroy");
            }
            i = TAG;
            i2 = new StringBuilder("Event mOnPlayCompleteListener result = ");
            i2.append(str2);
            Log.e(i, i2.toString());
        }
    }

    public void setOnReCreateHwDecoderListener(OnReCreateHwDecoderListener onReCreateHwDecoderListener) {
        this.mOnReCreateHwDecoderListener = onReCreateHwDecoderListener;
    }

    public void setOnFirstFrameRenderListener(OnFirstFrameRenderListener onFirstFrameRenderListener) {
        this.mOnFirstFrameRenderListener = onFirstFrameRenderListener;
    }

    public void setOnOpenSuccessListener(OnOpenSuccessListener onOpenSuccessListener) {
        this.mOnOpenSuccessListener = onOpenSuccessListener;
    }

    public void setOnPlayStateChangeListener(OnPlayStateChangeListener onPlayStateChangeListener) {
        this.mOnPlayStateChangeListener = onPlayStateChangeListener;
    }

    public void setOnOpenCompleteListener(OnOpenCompleteListener onOpenCompleteListener) {
        this.mOnOpenCompleteListener = onOpenCompleteListener;
    }

    public void setOnPlayCompleteListener(OnPlayCompleteListener onPlayCompleteListener) {
        this.mOnPlayCompleteListener = onPlayCompleteListener;
    }

    public void setOnBufferListener(OnBufferListener onBufferListener) {
        this.mOnBufferListener = onBufferListener;
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnSurfaceDestroyListener(OnSurfaceDestroyListener onSurfaceDestroyListener) {
        this.mOnSurfaceDestroyListener = onSurfaceDestroyListener;
    }

    public void setOnSystemPlayerFailListener(OnSystemPlayerFailListener onSystemPlayerFailListener) {
        this.OnSystemPlayerFailListener = onSystemPlayerFailListener;
    }

    public void setOnShowSubtitleListener(OnShowSubtitleListener onShowSubtitleListener) {
        this.mOnShowSubtitleListener = onShowSubtitleListener;
    }

    public void setOnPreciseSeekCompleteListener(OnPreciseSeekCompleteListener onPreciseSeekCompleteListener) {
        this.mPreciseSeekCompleteListener = onPreciseSeekCompleteListener;
    }

    public void setOnRecordEndListener(OnRecordEndListener onRecordEndListener) {
        this.mRecordEndListener = onRecordEndListener;
    }

    private void setExtIO(ExtIOBase extIOBase) {
        this.mExtIO = extIOBase;
        if (extIOBase != null) {
            setConfig(14, "1");
        } else {
            setConfig(14, "0");
        }
    }

    protected void setOnSurfaceChangeListener(OnSurfaceChangeListener onSurfaceChangeListener) {
        this.mOnSurfaceChangeListener = onSurfaceChangeListener;
    }

    protected void setOnForceUpdateListener(OnForceUpdateListener onForceUpdateListener) {
        this.mOnForceUpdateListener = onForceUpdateListener;
    }

    protected int getViewSurfaceWidth() {
        return this.mViewSurfaceWidth;
    }

    protected int getViewSurfaceHeight() {
        return this.mViewSurfaceHeight;
    }

    protected int getStretchMode() {
        return this.mStretchMode;
    }

    private void showSubtitle(CharSequence charSequence) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("ShowSubtitle ");
        stringBuilder.append(charSequence.toString());
        Log.i(str, stringBuilder.toString());
        if (this.mSubtilteview == null) {
            createSubtitleView();
        }
        if (this.mSubtilteview != null) {
            if (!this.mSubtitleShow.equalsIgnoreCase("0")) {
                this.mSubtilteview.setText(charSequence);
                charSequence = this.mSubtilteview.getLineCount();
                if (charSequence <= null) {
                    charSequence = true;
                }
                charSequence *= this.mSubtilteview.getLineHeight();
                LayoutParams layoutParams = (LayoutParams) this.mSubtilteview.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.topMargin = this.mSubtitleViewTop - charSequence;
                    String str2 = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder("ShowSubtitle mSubtitleViewTop = ");
                    stringBuilder2.append(this.mSubtitleViewTop);
                    stringBuilder2.append(" textViewHeight =  ");
                    stringBuilder2.append(charSequence);
                    Log.e(str2, stringBuilder2.toString());
                    this.mSubtilteview.setLayoutParams(layoutParams);
                    this.mSubtilteview.setHeight(charSequence);
                }
            }
        }
    }

    private void changeSubtitleViewSize() {
        Log.i(TAG, "ChangeSubtitleViewSize");
        if (!(this.mSubtilteview == null || this.mSurfaceview == null || this.mSurfaceview.getWidth() == 0)) {
            if (this.mSurfaceview.getBottom() != 0) {
                if (this.mSurfaceview.getContext() instanceof Activity) {
                    ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
                    layoutParams.leftMargin = this.mSurfaceview.getLeft();
                    layoutParams.topMargin = this.mSurfaceview.getBottom();
                    this.mSubtitleViewTop = layoutParams.topMargin;
                    this.mSubtilteview.setWidth(this.mSurfaceview.getWidth());
                    this.mSubtilteview.setGravity(17);
                    this.mSubtilteview.setTextSize(0, 40.0f);
                    this.mSubtilteview.setLayoutParams(layoutParams);
                    this.mSubtilteview.setVisibility(0);
                }
            }
        }
    }

    private boolean createSubtitleView() {
        Log.i(TAG, "CreateSubtitleView");
        if (this.mSubtilteview == null) {
            if (!(this.mSurfaceview == null || this.mSurfaceview.getWidth() == 0)) {
                if (this.mSurfaceview.getBottom() != 0) {
                    Context context = this.mSurfaceview.getContext();
                    this.mSubtilteview = new TextView(context);
                    if (context instanceof Activity) {
                        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
                        layoutParams.leftMargin = 0;
                        layoutParams.topMargin = 0;
                        ((Activity) context).addContentView(this.mSubtilteview, layoutParams);
                        this.mSubtilteview.setTextColor(Color.rgb(255, 255, 255));
                        this.mSubtilteview.setText("");
                    }
                    changeSubtitleViewSize();
                }
            }
            return false;
        }
        return true;
    }

    public Size getAdjustSurfaceViewSize(Size size) {
        Size size2 = new Size();
        size2.width = size.width;
        size2.height = size.height;
        size = TAG;
        StringBuilder stringBuilder = new StringBuilder("get_view_port mStretchMode = ");
        stringBuilder.append(this.mStretchMode);
        Log.i(size, stringBuilder.toString());
        double d = (double) ((((float) size2.width) * 1065353216) / ((float) size2.height));
        double videoWidth = (double) ((((float) getVideoWidth()) * 1065353216) / ((float) getVideoHeight()));
        if (this.mStretchMode == null) {
            if (videoWidth > d) {
                size2.height = (int) (((double) size2.width) / videoWidth);
            } else {
                size2.width = (int) (videoWidth * ((double) size2.height));
            }
        } else if (this.mStretchMode == 1) {
            if (videoWidth < d) {
                size2.height = (int) (((double) size2.width) / videoWidth);
            } else {
                size2.width = (int) (videoWidth * ((double) size2.height));
            }
        } else if (this.mStretchMode == 3) {
            if (videoWidth > 1.0d) {
                size2.height = (int) (((double) size2.width) / videoWidth);
            } else {
                size2.width = (int) (videoWidth * ((double) size2.height));
            }
        }
        return size2;
    }

    protected Surface getInnerSurface() {
        Log.i(TAG, "surface getInnerSurface");
        while (this.mSurface == null) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.i(TAG, "surface getInnerSurface over");
        return this.mSurface;
    }

    public HardwareDecoder getHardwareDecoder() {
        Log.i(TAG, "HardwareDecoder getHardwareDecoder");
        return this.mHwDecoder;
    }

    protected int getAndroidLevel() {
        Log.i(TAG, "getAndroidLevel");
        return VERSION.SDK_INT;
    }

    protected int getSurfaceType() {
        return this.mSurfaceType;
    }

    private int extIOOpen(String str) {
        return this.mExtIO != null ? this.mExtIO.open(str) : null;
    }

    private int extIOClose(String str) {
        if (this.mExtIO == null) {
            return null;
        }
        this.mExtIO.close(str);
        return 1;
    }

    private int extIORead(ByteBuffer byteBuffer) {
        return this.mExtIO != null ? this.mExtIO.read(byteBuffer) : null;
    }

    private long extIOSeek(int i, int i2) {
        return this.mExtIO != null ? this.mExtIO.seek(i, i2) : 0;
    }

    protected int postEventFromNative(int i, int i2, int i3, Object obj) {
        i = this.mEventHandler.obtainMessage(i, i2, i3, obj);
        if (i == 0) {
            return 0;
        }
        i.arg1 = i2;
        i.arg2 = i3;
        i.obj = obj;
        this.mEventHandler.sendMessage(i);
        return 1;
    }

    private static String subtitleFormat(String str) {
        if (str == null) {
            return null;
        }
        return subtitleFormat(subtitleFormat(str, "{", h.d), "<", ">");
    }

    private static String subtitleFormat(String str, String str2, String str3) {
        str2 = str.indexOf(str2);
        int i = -1 != str2 ? 1 : 0;
        str3 = str.indexOf(str3);
        int i2 = -1 != str3 ? 1 : 0;
        if (!(i == 0 || i2 == 0)) {
            if (str2 < str3) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str.substring(0, str2));
                stringBuilder.append(str.substring(str3 + 1));
                return stringBuilder.toString();
            }
        }
        return str;
    }

    private static boolean isFolderExists(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                File file = new File(str);
                if (file.exists() == null && file.mkdirs() == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
