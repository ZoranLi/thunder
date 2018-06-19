package android.support.v4.media;

import android.content.Context;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.service.media.MediaBrowserService.Result;
import android.support.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(24)
class MediaBrowserServiceCompatApi24 {
    private static final String TAG = "MBSCompatApi24";
    private static Field sResultFlags;

    static class ResultWrapper {
        Result mResultObj;

        ResultWrapper(Result result) {
            this.mResultObj = result;
        }

        public void sendResult(java.util.List<android.os.Parcel> r3, int r4) {
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
            r0 = android.support.v4.media.MediaBrowserServiceCompatApi24.sResultFlags;	 Catch:{ IllegalAccessException -> 0x0009 }
            r1 = r2.mResultObj;	 Catch:{ IllegalAccessException -> 0x0009 }
            r0.setInt(r1, r4);	 Catch:{ IllegalAccessException -> 0x0009 }
        L_0x0009:
            r4 = r2.mResultObj;
            r3 = r2.parcelListToItemList(r3);
            r4.sendResult(r3);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserServiceCompatApi24.ResultWrapper.sendResult(java.util.List, int):void");
        }

        public void detach() {
            this.mResultObj.detach();
        }

        List<MediaItem> parcelListToItemList(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            List<MediaItem> arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }
    }

    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        public void onLoadChildren(String str, Result<List<MediaItem>> result, Bundle bundle) {
            ((ServiceCompatProxy) this.mServiceProxy).onLoadChildren(str, new ResultWrapper(result), bundle);
        }
    }

    public interface ServiceCompatProxy extends android.support.v4.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String str, ResultWrapper resultWrapper, Bundle bundle);
    }

    MediaBrowserServiceCompatApi24() {
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.service.media.MediaBrowserService.Result.class;	 Catch:{ NoSuchFieldException -> 0x000f }
        r1 = "mFlags";	 Catch:{ NoSuchFieldException -> 0x000f }
        r0 = r0.getDeclaredField(r1);	 Catch:{ NoSuchFieldException -> 0x000f }
        sResultFlags = r0;	 Catch:{ NoSuchFieldException -> 0x000f }
        r1 = 1;	 Catch:{ NoSuchFieldException -> 0x000f }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x000f }
        return;
    L_0x000f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserServiceCompatApi24.<clinit>():void");
    }

    public static Object createService(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    public static void notifyChildrenChanged(Object obj, String str, Bundle bundle) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str, bundle);
    }

    public static Bundle getBrowserRootHints(Object obj) {
        return ((MediaBrowserService) obj).getBrowserRootHints();
    }
}
