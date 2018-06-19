package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri.Builder;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.WeakHashMap;

class SuggestionsAdapter extends ResourceCursorAdapter implements OnClickListener {
    private static final boolean DBG = false;
    static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE = 0;
    private boolean mClosed = false;
    private final int mCommitIconResId;
    private int mFlagsCol = -1;
    private int mIconName1Col = -1;
    private int mIconName2Col = -1;
    private final WeakHashMap<String, ConstantState> mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement = 1;
    private final SearchManager mSearchManager = ((SearchManager) this.mContext.getSystemService("search"));
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col = -1;
    private int mText2Col = -1;
    private int mText2UrlCol = -1;
    private ColorStateList mUrlColor;

    private static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View view) {
            this.mText1 = (TextView) view.findViewById(16908308);
            this.mText2 = (TextView) view.findViewById(16908309);
            this.mIcon1 = (ImageView) view.findViewById(16908295);
            this.mIcon2 = (ImageView) view.findViewById(16908296);
            this.mIconRefine = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.mSearchView = searchView;
        this.mSearchable = searchableInfo;
        this.mCommitIconResId = searchView.getSuggestionCommitIconResId();
        this.mProviderContext = context;
        this.mOutsideDrawablesCache = weakHashMap;
    }

    public void setQueryRefinement(int i) {
        this.mQueryRefinement = i;
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    public android.database.Cursor runQueryOnBackgroundThread(java.lang.CharSequence r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        if (r4 != 0) goto L_0x0005;
    L_0x0002:
        r4 = "";
        goto L_0x0009;
    L_0x0005:
        r4 = r4.toString();
    L_0x0009:
        r0 = r3.mSearchView;
        r0 = r0.getVisibility();
        r1 = 0;
        if (r0 != 0) goto L_0x002a;
    L_0x0012:
        r0 = r3.mSearchView;
        r0 = r0.getWindowVisibility();
        if (r0 == 0) goto L_0x001b;
    L_0x001a:
        goto L_0x002a;
    L_0x001b:
        r0 = r3.mSearchable;	 Catch:{ RuntimeException -> 0x0029 }
        r2 = 50;	 Catch:{ RuntimeException -> 0x0029 }
        r4 = r3.getSearchManagerSuggestions(r0, r4, r2);	 Catch:{ RuntimeException -> 0x0029 }
        if (r4 == 0) goto L_0x0029;	 Catch:{ RuntimeException -> 0x0029 }
    L_0x0025:
        r4.getCount();	 Catch:{ RuntimeException -> 0x0029 }
        return r4;
    L_0x0029:
        return r1;
    L_0x002a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SuggestionsAdapter.runQueryOnBackgroundThread(java.lang.CharSequence):android.database.Cursor");
    }

    public void close() {
        changeCursor(null);
        this.mClosed = true;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
    }

    private void updateSpinnerState(Cursor cursor) {
        cursor = cursor != null ? cursor.getExtras() : null;
        if (cursor != null && cursor.getBoolean("in_progress") == null) {
        }
    }

    public void changeCursor(android.database.Cursor r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mClosed;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        if (r2 == 0) goto L_0x0009;
    L_0x0006:
        r2.close();
    L_0x0009:
        return;
    L_0x000a:
        super.changeCursor(r2);	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x0040 }
    L_0x000f:
        r0 = "suggest_text_1";	 Catch:{ Exception -> 0x0040 }
        r0 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0040 }
        r1.mText1Col = r0;	 Catch:{ Exception -> 0x0040 }
        r0 = "suggest_text_2";	 Catch:{ Exception -> 0x0040 }
        r0 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0040 }
        r1.mText2Col = r0;	 Catch:{ Exception -> 0x0040 }
        r0 = "suggest_text_2_url";	 Catch:{ Exception -> 0x0040 }
        r0 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0040 }
        r1.mText2UrlCol = r0;	 Catch:{ Exception -> 0x0040 }
        r0 = "suggest_icon_1";	 Catch:{ Exception -> 0x0040 }
        r0 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0040 }
        r1.mIconName1Col = r0;	 Catch:{ Exception -> 0x0040 }
        r0 = "suggest_icon_2";	 Catch:{ Exception -> 0x0040 }
        r0 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0040 }
        r1.mIconName2Col = r0;	 Catch:{ Exception -> 0x0040 }
        r0 = "suggest_flags";	 Catch:{ Exception -> 0x0040 }
        r2 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0040 }
        r1.mFlagsCol = r2;	 Catch:{ Exception -> 0x0040 }
    L_0x003f:
        return;
    L_0x0040:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SuggestionsAdapter.changeCursor(android.database.Cursor):void");
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        context = super.newView(context, cursor, viewGroup);
        context.setTag(new ChildViewCache(context));
        ((ImageView) context.findViewById(R.id.edit_query)).setImageResource(this.mCommitIconResId);
        return context;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        context = this.mFlagsCol != -1 ? cursor.getInt(this.mFlagsCol) : null;
        if (childViewCache.mText1 != null) {
            setViewText(childViewCache.mText1, getStringOrNull(cursor, this.mText1Col));
        }
        if (childViewCache.mText2 != null) {
            CharSequence stringOrNull = getStringOrNull(cursor, this.mText2UrlCol);
            if (stringOrNull != null) {
                stringOrNull = formatUrl(stringOrNull);
            } else {
                stringOrNull = getStringOrNull(cursor, this.mText2Col);
            }
            if (TextUtils.isEmpty(stringOrNull)) {
                if (childViewCache.mText1 != null) {
                    childViewCache.mText1.setSingleLine(false);
                    childViewCache.mText1.setMaxLines(2);
                }
            } else if (childViewCache.mText1 != null) {
                childViewCache.mText1.setSingleLine(true);
                childViewCache.mText1.setMaxLines(1);
            }
            setViewText(childViewCache.mText2, stringOrNull);
        }
        if (childViewCache.mIcon1 != null) {
            setViewDrawable(childViewCache.mIcon1, getIcon1(cursor), 4);
        }
        if (childViewCache.mIcon2 != null) {
            setViewDrawable(childViewCache.mIcon2, getIcon2(cursor), 8);
        }
        if (this.mQueryRefinement != 2) {
            if (this.mQueryRefinement != 1 || (context & 1) == null) {
                childViewCache.mIconRefine.setVisibility(8);
                return;
            }
        }
        childViewCache.mIconRefine.setVisibility(0);
        childViewCache.mIconRefine.setTag(childViewCache.mText1.getText());
        childViewCache.mIconRefine.setOnClickListener(this);
    }

    public void onClick(View view) {
        view = view.getTag();
        if (view instanceof CharSequence) {
            this.mSearchView.onQueryRefine((CharSequence) view);
        }
    }

    private CharSequence formatUrl(CharSequence charSequence) {
        if (this.mUrlColor == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.mUrlColor = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void setViewText(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence) != null) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(null);
        }
    }

    private Drawable getIcon1(Cursor cursor) {
        if (this.mIconName1Col == -1) {
            return null;
        }
        Drawable drawableFromResourceValue = getDrawableFromResourceValue(cursor.getString(this.mIconName1Col));
        if (drawableFromResourceValue != null) {
            return drawableFromResourceValue;
        }
        return getDefaultIcon1(cursor);
    }

    private Drawable getIcon2(Cursor cursor) {
        if (this.mIconName2Col == -1) {
            return null;
        }
        return getDrawableFromResourceValue(cursor.getString(this.mIconName2Col));
    }

    private void setViewDrawable(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        CharSequence columnString = getColumnString(cursor, "suggest_intent_query");
        if (columnString != null) {
            return columnString;
        }
        if (this.mSearchable.shouldRewriteQueryFromData()) {
            columnString = getColumnString(cursor, "suggest_intent_data");
            if (columnString != null) {
                return columnString;
            }
        }
        if (this.mSearchable.shouldRewriteQueryFromText()) {
            cursor = getColumnString(cursor, "suggest_text_1");
            if (cursor != null) {
                return cursor;
            }
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (int i2) {
            view = newView(this.mContext, this.mCursor, viewGroup);
            if (view != null) {
                ((ChildViewCache) view.getTag()).mText1.setText(i2.toString());
            }
            return view;
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (int i2) {
            view = newDropDownView(this.mContext, this.mCursor, viewGroup);
            if (view != null) {
                ((ChildViewCache) view.getTag()).mText1.setText(i2.toString());
            }
            return view;
        }
    }

    private android.graphics.drawable.Drawable getDrawableFromResourceValue(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        if (r5 == 0) goto L_0x0057;
    L_0x0003:
        r1 = r5.isEmpty();
        if (r1 != 0) goto L_0x0057;
    L_0x0009:
        r1 = "0";
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0057;
    L_0x0012:
        r1 = java.lang.Integer.parseInt(r5);	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r2 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r3 = "android.resource://";	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r2.<init>(r3);	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r3 = r4.mProviderContext;	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r3 = r3.getPackageName();	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r2.append(r3);	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r3 = "/";	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r2.append(r3);	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r2.append(r1);	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r2 = r2.toString();	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r3 = r4.checkIconCache(r2);	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        if (r3 == 0) goto L_0x0039;	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
    L_0x0038:
        return r3;	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
    L_0x0039:
        r3 = r4.mProviderContext;	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r1 = android.support.v4.content.ContextCompat.getDrawable(r3, r1);	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        r4.storeInIconCache(r2, r1);	 Catch:{ NumberFormatException -> 0x0044, NotFoundException -> 0x0043 }
        return r1;
    L_0x0043:
        return r0;
    L_0x0044:
        r0 = r4.checkIconCache(r5);
        if (r0 == 0) goto L_0x004b;
    L_0x004a:
        return r0;
    L_0x004b:
        r0 = android.net.Uri.parse(r5);
        r0 = r4.getDrawable(r0);
        r4.storeInIconCache(r5, r0);
        return r0;
    L_0x0057:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SuggestionsAdapter.getDrawableFromResourceValue(java.lang.String):android.graphics.drawable.Drawable");
    }

    private android.graphics.drawable.Drawable getDrawable(android.net.Uri r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r5.getScheme();	 Catch:{ FileNotFoundException -> 0x0069 }
        r2 = "android.resource";	 Catch:{ FileNotFoundException -> 0x0069 }
        r1 = r2.equals(r1);	 Catch:{ FileNotFoundException -> 0x0069 }
        if (r1 == 0) goto L_0x0026;
    L_0x000d:
        r1 = r4.getDrawableFromResourceUri(r5);	 Catch:{ NotFoundException -> 0x0012 }
        return r1;
    L_0x0012:
        r1 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0069 }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0069 }
        r3 = "Resource does not exist: ";	 Catch:{ FileNotFoundException -> 0x0069 }
        r2.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0069 }
        r2.append(r5);	 Catch:{ FileNotFoundException -> 0x0069 }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0069 }
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0069 }
        throw r1;	 Catch:{ FileNotFoundException -> 0x0069 }
    L_0x0026:
        r1 = r4.mProviderContext;	 Catch:{ FileNotFoundException -> 0x0069 }
        r1 = r1.getContentResolver();	 Catch:{ FileNotFoundException -> 0x0069 }
        r1 = r1.openInputStream(r5);	 Catch:{ FileNotFoundException -> 0x0069 }
        if (r1 != 0) goto L_0x0046;	 Catch:{ FileNotFoundException -> 0x0069 }
    L_0x0032:
        r1 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0069 }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0069 }
        r3 = "Failed to open ";	 Catch:{ FileNotFoundException -> 0x0069 }
        r2.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0069 }
        r2.append(r5);	 Catch:{ FileNotFoundException -> 0x0069 }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0069 }
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0069 }
        throw r1;	 Catch:{ FileNotFoundException -> 0x0069 }
    L_0x0046:
        r2 = android.graphics.drawable.Drawable.createFromStream(r1, r0);	 Catch:{ all -> 0x0059 }
        r1.close();	 Catch:{ IOException -> 0x004e }
        goto L_0x0058;
    L_0x004e:
        r1 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0069 }
        r3 = "Error closing icon stream for ";	 Catch:{ FileNotFoundException -> 0x0069 }
        r1.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0069 }
        r1.append(r5);	 Catch:{ FileNotFoundException -> 0x0069 }
    L_0x0058:
        return r2;
    L_0x0059:
        r2 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x005e }
        goto L_0x0068;
    L_0x005e:
        r1 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0069 }
        r3 = "Error closing icon stream for ";	 Catch:{ FileNotFoundException -> 0x0069 }
        r1.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0069 }
        r1.append(r5);	 Catch:{ FileNotFoundException -> 0x0069 }
    L_0x0068:
        throw r2;	 Catch:{ FileNotFoundException -> 0x0069 }
    L_0x0069:
        r1 = move-exception;
        r2 = new java.lang.StringBuilder;
        r3 = "Icon not found: ";
        r2.<init>(r3);
        r2.append(r5);
        r5 = ", ";
        r2.append(r5);
        r5 = r1.getMessage();
        r2.append(r5);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SuggestionsAdapter.getDrawable(android.net.Uri):android.graphics.drawable.Drawable");
    }

    private Drawable checkIconCache(String str) {
        ConstantState constantState = (ConstantState) this.mOutsideDrawablesCache.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void storeInIconCache(String str, Drawable drawable) {
        if (drawable != null) {
            this.mOutsideDrawablesCache.put(str, drawable.getConstantState());
        }
    }

    private Drawable getDefaultIcon1(Cursor cursor) {
        cursor = getActivityIconWithCache(this.mSearchable.getSearchActivity());
        if (cursor != null) {
            return cursor;
        }
        return this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable getActivityIconWithCache(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Object obj = null;
        if (this.mOutsideDrawablesCache.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.mOutsideDrawablesCache.get(flattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.mProviderContext.getResources());
        }
        componentName = getActivityIcon(componentName);
        if (componentName != null) {
            obj = componentName.getConstantState();
        }
        this.mOutsideDrawablesCache.put(flattenToShortString, obj);
        return componentName;
    }

    private Drawable getActivityIcon(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder stringBuilder = new StringBuilder("Invalid icon resource ");
            stringBuilder.append(iconResource);
            stringBuilder.append(" for ");
            stringBuilder.append(componentName.flattenToShortString());
            return null;
        } catch (ComponentName componentName2) {
            componentName2.toString();
            return null;
        }
    }

    public static String getColumnString(Cursor cursor, String str) {
        return getStringOrNull(cursor, cursor.getColumnIndex(str));
    }

    private static java.lang.String getStringOrNull(android.database.Cursor r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = -1;
        if (r3 != r1) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x000a }
        return r2;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SuggestionsAdapter.getStringOrNull(android.database.Cursor, int):java.lang.String");
    }

    android.graphics.drawable.Drawable getDrawableFromResourceUri(android.net.Uri r8) throws java.io.FileNotFoundException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r8.getAuthority();
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x001e;
    L_0x000a:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "No authority: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x001e:
        r1 = r7.mContext;	 Catch:{ NameNotFoundException -> 0x00ab }
        r1 = r1.getPackageManager();	 Catch:{ NameNotFoundException -> 0x00ab }
        r1 = r1.getResourcesForApplication(r0);	 Catch:{ NameNotFoundException -> 0x00ab }
        r2 = r8.getPathSegments();
        if (r2 != 0) goto L_0x0042;
    L_0x002e:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "No path: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0042:
        r3 = r2.size();
        r4 = 0;
        r5 = 1;
        if (r3 != r5) goto L_0x0069;
    L_0x004a:
        r0 = r2.get(r4);	 Catch:{ NumberFormatException -> 0x0055 }
        r0 = (java.lang.String) r0;	 Catch:{ NumberFormatException -> 0x0055 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0055 }
        goto L_0x007c;
    L_0x0055:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "Single path segment is not a resource ID: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0069:
        r6 = 2;
        if (r3 != r6) goto L_0x0097;
    L_0x006c:
        r3 = r2.get(r5);
        r3 = (java.lang.String) r3;
        r2 = r2.get(r4);
        r2 = (java.lang.String) r2;
        r0 = r1.getIdentifier(r3, r2, r0);
    L_0x007c:
        if (r0 != 0) goto L_0x0092;
    L_0x007e:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "No resource found for: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0092:
        r8 = r1.getDrawable(r0);
        return r8;
    L_0x0097:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "More than two path segments: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x00ab:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r2 = "No package found for authority: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SuggestionsAdapter.getDrawableFromResourceUri(android.net.Uri):android.graphics.drawable.Drawable");
    }

    Cursor getSearchManagerSuggestions(SearchableInfo searchableInfo, String str, int i) {
        String[] strArr = null;
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.mContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }
}
