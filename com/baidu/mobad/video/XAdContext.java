package com.baidu.mobad.video;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.ActivityState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.ScreenSizeMode;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VideoState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VisitorAction;
import com.baidu.mobads.interfaces.IXAdContext;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInternalConstants;
import com.baidu.mobads.interfaces.IXAdManager;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.c.b;
import com.baidu.mobads.openad.c.c;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XAdContext implements IXAdContext {
    public static final String PARAMETER_KEY_OF_BASE_HEIGHT = "BASE_HEIGHT";
    public static final String PARAMETER_KEY_OF_BASE_WIDTH = "BASE_WIDTH";
    public static final String TAG = "XAdContext";
    int a = 0;
    int b = 0;
    private HashMap<String, Object> c = new HashMap();
    private ScreenSizeMode d = ScreenSizeMode.FULL_SCREEN;
    private VideoState e = VideoState.IDLE;
    private ActivityState f = ActivityState.CREATE;
    private VisitorAction g;
    private double h;
    private int i;
    private int j;
    private Context k;
    private String l;
    private Location m;
    protected IXAdLogger mAdLogger;
    private Activity n;
    private RelativeLayout o;
    private final IOAdEventDispatcher p;
    private final XAdSlotManager q;

    public static class AdSlotEventListener implements IOAdEventListener {
        public static final String TAG = "AdSlotEventListener";
        private final Context a;
        private final IXAdProd b;
        private final IOAdEventDispatcher c;

        public AdSlotEventListener(Context context, IXAdProd iXAdProd, IOAdEventDispatcher iOAdEventDispatcher) {
            this.a = context;
            this.b = iXAdProd;
            this.c = iOAdEventDispatcher;
        }

        public void run(final IOAdEvent iOAdEvent) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(TAG, iOAdEvent.getType());
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable(this) {
                final /* synthetic */ AdSlotEventListener b;

                public void run() {
                    if (iOAdEvent.getType().equals(b.COMPLETE)) {
                        this.b.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, this.b.b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_STARTED)) {
                        if (this.b.b.getProdBase() != null) {
                            this.b.b.getProdBase().setVisibility(0);
                        }
                        this.b.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_STARTED, this.b.b));
                    }
                    if (iOAdEvent.getType().equals("AdUserClick")) {
                        this.b.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_CLICKED, this.b.b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_STOPPED)) {
                        if (this.b.b.getProdBase() != null) {
                            this.b.b.getProdBase().setVisibility(4);
                        }
                        this.b.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_ENDED, this.b.b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_ERROR)) {
                        if (this.b.b.getProdBase() != null) {
                            this.b.b.getProdBase().setVisibility(4);
                        }
                        this.b.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_ERROR, this.b.b));
                    }
                }
            });
        }
    }

    public void dispatchEvent(IOAdEvent iOAdEvent) {
    }

    public void dispose() {
    }

    public IXAdManager getXAdManager() {
        return null;
    }

    public XAdContext(Context context, String str, Location location) {
        this.k = context;
        this.l = str;
        this.m = location;
        this.p = new c();
        this.q = new XAdSlotManager();
        this.mAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
    }

    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.o = relativeLayout;
        setActivity((Activity) this.o.getContext());
        new Handler(getActivity().getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ XAdContext a;

            {
                this.a = r1;
            }

            public void run() {
                IXAdProd retrievePrerollAdSlot = this.a.q.retrievePrerollAdSlot();
                if (retrievePrerollAdSlot != null && retrievePrerollAdSlot.getSlotState() == SlotState.PLAYING) {
                    retrievePrerollAdSlot.resize();
                }
            }
        });
    }

    public void setActivity(Activity activity) {
        if (activity != null && this.n == null) {
            this.n = activity;
            if (this.k == null) {
                this.k = this.n.getApplicationContext();
            }
        }
    }

    public Activity getActivity() {
        return this.n;
    }

    public void setActivityState(ActivityState activityState) {
        this.f = activityState;
        this.mAdLogger.i(TAG, activityState.getValue());
        IXAdProd retrievePrerollAdSlot = this.q.retrievePrerollAdSlot();
        if (retrievePrerollAdSlot != null) {
            if (activityState == ActivityState.PAUSE) {
                retrievePrerollAdSlot.pause();
            }
            if (activityState == ActivityState.RESUME) {
                retrievePrerollAdSlot.resume();
            }
        }
    }

    public void setParameter(String str, Object obj) {
        this.c.put(str, obj);
    }

    public Object getParameter(String str) {
        return this.c.get(str);
    }

    public void setContentVideoScreenMode(ScreenSizeMode screenSizeMode) {
        this.d = screenSizeMode;
        screenSizeMode = this.q.retrievePrerollAdSlot();
        if (this.d == ScreenSizeMode.FULL_SCREEN && screenSizeMode != null && screenSizeMode.getSlotState() == SlotState.PLAYING) {
            IXAdInstanceInfo currentAdInstance = screenSizeMode.getCurrentAdInstance();
            if (currentAdInstance != null) {
                screenSizeMode = (int) screenSizeMode.getCurrentXAdContainer().getPlayheadTime();
                IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
                List arrayList = new ArrayList();
                List fullScreenTrackers = currentAdInstance.getFullScreenTrackers();
                for (int i = 0; i < fullScreenTrackers.size(); i++) {
                    arrayList.add(uRIUitls.addParameter((String) fullScreenTrackers.get(i), NotificationCompat.CATEGORY_PROGRESS, String.valueOf(screenSizeMode)));
                }
                currentAdInstance.setFullScreenTrackers(arrayList);
                Set hashSet = new HashSet();
                hashSet.addAll(currentAdInstance.getFullScreenTrackers());
                a(hashSet);
            }
        }
    }

    private void a(Set<String> set) {
        a aVar = new a();
        for (String cVar : set) {
            com.baidu.mobads.openad.d.c cVar2 = new com.baidu.mobads.openad.d.c(cVar, "");
            cVar2.e = 1;
            aVar.a(cVar2, Boolean.valueOf(true));
        }
    }

    public void setContentVideoState(VideoState videoState) {
        this.e = videoState;
    }

    public void setContentVideoPlayheadTime(double d) {
        this.h = d;
    }

    public void setAdServerRequestingTimeout(int i) {
        this.i = i;
    }

    public void setAdCreativeLoadingTimeout(int i) {
        this.j = i;
    }

    public void submitRequest() {
        IXAdProd retrievePrerollAdSlot = this.q.retrievePrerollAdSlot();
        if (this.i > 0 && this.j > 0) {
            HashMap parameter = retrievePrerollAdSlot.getParameter();
            String str = IXAdInternalConstants.PARAMETER_KEY_OF_AD_REQUESTING_TIMEOUT;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.i);
            parameter.put(str, stringBuilder.toString());
            str = IXAdInternalConstants.PARAMETER_KEY_OF_AD_CREATIVE_LOADING_TIMEOUT;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.j);
            parameter.put(str, stringBuilder.toString());
            str = PARAMETER_KEY_OF_BASE_WIDTH;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            parameter.put(str, stringBuilder.toString());
            str = PARAMETER_KEY_OF_BASE_HEIGHT;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            parameter.put(str, stringBuilder.toString());
            retrievePrerollAdSlot.setParameter(parameter);
        }
        retrievePrerollAdSlot.request();
    }

    public IXLinearAdSlot newPrerollAdSlot(String str, int i, int i2) {
        if (this.q.containsAdSlot(str).booleanValue() == 0) {
            i = new com.baidu.mobads.production.h.b(this.n, str);
            i.setActivity(this.n);
            i.setAdSlotBase(this.o);
            i.setId(str);
            str = new AdSlotEventListener(this.k, i, this.p);
            i.removeAllListeners();
            i.addEventListener(b.COMPLETE, str);
            i.addEventListener(IXAdEvent.AD_STARTED, str);
            i.addEventListener(IXAdEvent.AD_STOPPED, str);
            i.addEventListener(IXAdEvent.AD_ERROR, str);
            i.addEventListener("AdUserClick", str);
            this.q.addAdSlot(i);
        }
        return this.q.retrievePrerollAdSlot();
    }

    public IXAdProd getSlotById(String str) {
        return this.q.retrieveAdSlotById(str);
    }

    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.p.addEventListener(str, iOAdEventListener);
    }

    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.p.removeEventListener(str, iOAdEventListener);
    }

    public void notifyVisitorAction(VisitorAction visitorAction) {
        this.g = visitorAction;
    }

    public void setVideoDisplayBaseWidth(int i) {
        this.a = i;
    }

    public void setVideoDisplayBaseHeight(int i) {
        this.b = i;
    }

    public void setSupportTipView(boolean z) {
        this.q.retrievePrerollAdSlot().setSupportTipView(z);
    }
}
