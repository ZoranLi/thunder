package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.annotation.StringRes;
import android.support.v4.content.IntentCompat;
import android.text.Html;
import android.text.Spanned;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import com.alipay.sdk.util.h;
import java.util.ArrayList;

public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    public static class IntentBuilder {
        private Activity mActivity;
        private ArrayList<String> mBccAddresses;
        private ArrayList<String> mCcAddresses;
        private CharSequence mChooserTitle;
        private Intent mIntent = new Intent().setAction("android.intent.action.SEND");
        private ArrayList<Uri> mStreams;
        private ArrayList<String> mToAddresses;

        public static IntentBuilder from(Activity activity) {
            return new IntentBuilder(activity);
        }

        private IntentBuilder(Activity activity) {
            this.mActivity = activity;
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, activity.getPackageName());
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, activity.getComponentName());
            this.mIntent.addFlags(524288);
        }

        public Intent getIntent() {
            if (this.mToAddresses != null) {
                combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
                this.mToAddresses = null;
            }
            if (this.mCcAddresses != null) {
                combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
                this.mCcAddresses = null;
            }
            if (this.mBccAddresses != null) {
                combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
                this.mBccAddresses = null;
            }
            int i = 1;
            if (this.mStreams == null || this.mStreams.size() <= 1) {
                i = 0;
            }
            boolean equals = this.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
            if (i == 0 && equals) {
                this.mIntent.setAction("android.intent.action.SEND");
                if (this.mStreams == null || this.mStreams.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable) this.mStreams.get(0));
                }
                this.mStreams = null;
            }
            if (!(i == 0 || equals)) {
                this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                if (this.mStreams == null || this.mStreams.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
                }
            }
            return this.mIntent;
        }

        Activity getActivity() {
            return this.mActivity;
        }

        private void combineArrayExtra(String str, ArrayList<String> arrayList) {
            Object stringArrayExtra = this.mIntent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            Object obj = new String[(arrayList.size() + length)];
            arrayList.toArray(obj);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, obj, arrayList.size(), length);
            }
            this.mIntent.putExtra(str, obj);
        }

        private void combineArrayExtra(String str, String[] strArr) {
            Intent intent = getIntent();
            Object stringArrayExtra = intent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            Object obj = new String[(strArr.length + length)];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, obj, 0, length);
            }
            System.arraycopy(strArr, 0, obj, length, strArr.length);
            intent.putExtra(str, obj);
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        public void startChooser() {
            this.mActivity.startActivity(createChooserIntent());
        }

        public IntentBuilder setChooserTitle(CharSequence charSequence) {
            this.mChooserTitle = charSequence;
            return this;
        }

        public IntentBuilder setChooserTitle(@StringRes int i) {
            return setChooserTitle(this.mActivity.getText(i));
        }

        public IntentBuilder setType(String str) {
            this.mIntent.setType(str);
            return this;
        }

        public IntentBuilder setText(CharSequence charSequence) {
            this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        public IntentBuilder setHtmlText(String str) {
            this.mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, str);
            if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
                setText(Html.fromHtml(str));
            }
            return this;
        }

        public IntentBuilder setStream(Uri uri) {
            if (!this.mIntent.getAction().equals("android.intent.action.SEND")) {
                this.mIntent.setAction("android.intent.action.SEND");
            }
            this.mStreams = null;
            this.mIntent.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        public IntentBuilder addStream(Uri uri) {
            Uri uri2 = (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            if (this.mStreams == null && uri2 == null) {
                return setStream(uri);
            }
            if (this.mStreams == null) {
                this.mStreams = new ArrayList();
            }
            if (uri2 != null) {
                this.mIntent.removeExtra("android.intent.extra.STREAM");
                this.mStreams.add(uri2);
            }
            this.mStreams.add(uri);
            return this;
        }

        public IntentBuilder setEmailTo(String[] strArr) {
            if (this.mToAddresses != null) {
                this.mToAddresses = null;
            }
            this.mIntent.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        public IntentBuilder addEmailTo(String str) {
            if (this.mToAddresses == null) {
                this.mToAddresses = new ArrayList();
            }
            this.mToAddresses.add(str);
            return this;
        }

        public IntentBuilder addEmailTo(String[] strArr) {
            combineArrayExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        public IntentBuilder setEmailCc(String[] strArr) {
            this.mIntent.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder addEmailCc(String str) {
            if (this.mCcAddresses == null) {
                this.mCcAddresses = new ArrayList();
            }
            this.mCcAddresses.add(str);
            return this;
        }

        public IntentBuilder addEmailCc(String[] strArr) {
            combineArrayExtra("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder setEmailBcc(String[] strArr) {
            this.mIntent.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder addEmailBcc(String str) {
            if (this.mBccAddresses == null) {
                this.mBccAddresses = new ArrayList();
            }
            this.mBccAddresses.add(str);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] strArr) {
            combineArrayExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder setSubject(String str) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }
    }

    public static class IntentReader {
        private static final String TAG = "IntentReader";
        private Activity mActivity;
        private ComponentName mCallingActivity;
        private String mCallingPackage;
        private Intent mIntent;
        private ArrayList<Uri> mStreams;

        public static IntentReader from(Activity activity) {
            return new IntentReader(activity);
        }

        private IntentReader(Activity activity) {
            this.mActivity = activity;
            this.mIntent = activity.getIntent();
            this.mCallingPackage = ShareCompat.getCallingPackage(activity);
            this.mCallingActivity = ShareCompat.getCallingActivity(activity);
        }

        public boolean isShareIntent() {
            String action = this.mIntent.getAction();
            if (!"android.intent.action.SEND".equals(action)) {
                if (!"android.intent.action.SEND_MULTIPLE".equals(action)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public String getType() {
            return this.mIntent.getType();
        }

        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getHtmlText() {
            String stringExtra = this.mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (stringExtra != null) {
                return stringExtra;
            }
            CharSequence text = getText();
            if (text instanceof Spanned) {
                return Html.toHtml((Spanned) text);
            }
            if (text == null) {
                return stringExtra;
            }
            if (VERSION.SDK_INT >= 16) {
                return Html.escapeHtml(text);
            }
            StringBuilder stringBuilder = new StringBuilder();
            withinStyle(stringBuilder, text, 0, text.length());
            return stringBuilder.toString();
        }

        private static void withinStyle(StringBuilder stringBuilder, CharSequence charSequence, int i, int i2) {
            while (i < i2) {
                char charAt = charSequence.charAt(i);
                if (charAt == '<') {
                    stringBuilder.append("&lt;");
                } else if (charAt == '>') {
                    stringBuilder.append("&gt;");
                } else if (charAt == '&') {
                    stringBuilder.append("&amp;");
                } else {
                    if (charAt <= '~') {
                        if (charAt >= ' ') {
                            if (charAt == ' ') {
                                while (true) {
                                    int i3 = i + 1;
                                    if (i3 >= i2 || charSequence.charAt(i3) != ' ') {
                                        stringBuilder.append(' ');
                                    } else {
                                        stringBuilder.append("&nbsp;");
                                        i = i3;
                                    }
                                }
                                stringBuilder.append(' ');
                            } else {
                                stringBuilder.append(charAt);
                            }
                        }
                    }
                    StringBuilder stringBuilder2 = new StringBuilder("&#");
                    stringBuilder2.append(charAt);
                    stringBuilder2.append(h.b);
                    stringBuilder.append(stringBuilder2.toString());
                }
                i++;
            }
        }

        public Uri getStream() {
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        public Uri getStream(int i) {
            if (this.mStreams == null && isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            if (this.mStreams != null) {
                return (Uri) this.mStreams.get(i);
            }
            if (i == 0) {
                return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            }
            StringBuilder stringBuilder = new StringBuilder("Stream items available: ");
            stringBuilder.append(getStreamCount());
            stringBuilder.append(" index requested: ");
            stringBuilder.append(i);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }

        public int getStreamCount() {
            if (this.mStreams == null && isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            if (this.mStreams != null) {
                return this.mStreams.size();
            }
            return this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        public android.graphics.drawable.Drawable getCallingActivityIcon() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = r3.mCallingActivity;
            r1 = 0;
            if (r0 != 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r0 = r3.mActivity;
            r0 = r0.getPackageManager();
            r2 = r3.mCallingActivity;	 Catch:{ NameNotFoundException -> 0x0013 }
            r0 = r0.getActivityIcon(r2);	 Catch:{ NameNotFoundException -> 0x0013 }
            return r0;
        L_0x0013:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.ShareCompat.IntentReader.getCallingActivityIcon():android.graphics.drawable.Drawable");
        }

        public android.graphics.drawable.Drawable getCallingApplicationIcon() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = r3.mCallingPackage;
            r1 = 0;
            if (r0 != 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r0 = r3.mActivity;
            r0 = r0.getPackageManager();
            r2 = r3.mCallingPackage;	 Catch:{ NameNotFoundException -> 0x0013 }
            r0 = r0.getApplicationIcon(r2);	 Catch:{ NameNotFoundException -> 0x0013 }
            return r0;
        L_0x0013:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.ShareCompat.IntentReader.getCallingApplicationIcon():android.graphics.drawable.Drawable");
        }

        public java.lang.CharSequence getCallingApplicationLabel() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r4 = this;
            r0 = r4.mCallingPackage;
            r1 = 0;
            if (r0 != 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r0 = r4.mActivity;
            r0 = r0.getPackageManager();
            r2 = r4.mCallingPackage;	 Catch:{ NameNotFoundException -> 0x0018 }
            r3 = 0;	 Catch:{ NameNotFoundException -> 0x0018 }
            r2 = r0.getApplicationInfo(r2, r3);	 Catch:{ NameNotFoundException -> 0x0018 }
            r0 = r0.getApplicationLabel(r2);	 Catch:{ NameNotFoundException -> 0x0018 }
            return r0;
        L_0x0018:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.ShareCompat.IntentReader.getCallingApplicationLabel():java.lang.CharSequence");
        }
    }

    private ShareCompat() {
    }

    public static String getCallingPackage(Activity activity) {
        String callingPackage = activity.getCallingPackage();
        return callingPackage == null ? activity.getIntent().getStringExtra(EXTRA_CALLING_PACKAGE) : callingPackage;
    }

    public static ComponentName getCallingActivity(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? (ComponentName) activity.getIntent().getParcelableExtra(EXTRA_CALLING_ACTIVITY) : callingActivity;
    }

    public static void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        if (actionProvider instanceof ShareActionProvider) {
            actionProvider = (ShareActionProvider) actionProvider;
        } else {
            actionProvider = new ShareActionProvider(intentBuilder.getActivity());
        }
        StringBuilder stringBuilder = new StringBuilder(HISTORY_FILENAME_PREFIX);
        stringBuilder.append(intentBuilder.getActivity().getClass().getName());
        actionProvider.setShareHistoryFileName(stringBuilder.toString());
        actionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(actionProvider);
        if (VERSION.SDK_INT < 16 && !menuItem.hasSubMenu()) {
            menuItem.setIntent(intentBuilder.createChooserIntent());
        }
    }

    public static void configureMenuItem(Menu menu, int i, IntentBuilder intentBuilder) {
        menu = menu.findItem(i);
        if (menu == null) {
            intentBuilder = new StringBuilder("Could not find menu item with id ");
            intentBuilder.append(i);
            intentBuilder.append(" in the supplied menu");
            throw new IllegalArgumentException(intentBuilder.toString());
        }
        configureMenuItem(menu, intentBuilder);
    }
}
