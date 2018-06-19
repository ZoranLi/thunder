package com.qihoo360.replugin.component.provider;

import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.qihoo360.i.Factory;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.process.a;
import com.qihoo360.replugin.component.utils.PluginClientHelper;
import java.io.InputStream;
import java.io.OutputStream;

public class PluginProviderClient {
    public static ContentProviderClient acquireContentProviderClient(Context context, String str) {
        return context.getContentResolver().acquireContentProviderClient(PluginPitProviderP0.AUTHORITY);
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return context.getContentResolver().query(toCalledUri(context, uri), strArr, str, strArr2, str2);
    }

    @TargetApi(16)
    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return context.getContentResolver().query(toCalledUri(context, uri), strArr, str, strArr2, str2, cancellationSignal);
    }

    public static String getType(Context context, Uri uri) {
        return context.getContentResolver().getType(toCalledUri(context, uri));
    }

    public static Uri insert(Context context, Uri uri, ContentValues contentValues) {
        return context.getContentResolver().insert(toCalledUri(context, uri), contentValues);
    }

    public static int bulkInsert(Context context, Uri uri, ContentValues[] contentValuesArr) {
        return context.getContentResolver().bulkInsert(toCalledUri(context, uri), contentValuesArr);
    }

    public static int delete(Context context, Uri uri, String str, String[] strArr) {
        return context.getContentResolver().delete(toCalledUri(context, uri), str, strArr);
    }

    public static int update(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return context.getContentResolver().update(toCalledUri(context, uri), contentValues, str, strArr);
    }

    public static InputStream openInputStream(Context context, Uri uri) {
        try {
            return context.getContentResolver().openInputStream(toCalledUri(context, uri));
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    public static OutputStream openOutputStream(Context context, Uri uri) {
        try {
            return context.getContentResolver().openOutputStream(toCalledUri(context, uri));
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    public static OutputStream openOutputStream(Context context, Uri uri, String str) {
        try {
            return context.getContentResolver().openOutputStream(toCalledUri(context, uri), str);
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    public static ParcelFileDescriptor openFileDescriptor(Context context, Uri uri, String str) {
        try {
            return context.getContentResolver().openFileDescriptor(toCalledUri(context, uri), str);
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    @TargetApi(19)
    public static ParcelFileDescriptor openFileDescriptor(Context context, Uri uri, String str, CancellationSignal cancellationSignal) {
        try {
            return context.getContentResolver().openFileDescriptor(toCalledUri(context, uri), str, cancellationSignal);
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    public static void registerContentObserver(Context context, Uri uri, boolean z, ContentObserver contentObserver) {
        try {
            context.getContentResolver().registerContentObserver(toCalledUri(context, uri), z, contentObserver);
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public static void notifyChange(Context context, Uri uri, ContentObserver contentObserver) {
        context.getContentResolver().notifyChange(toCalledUri(context, uri), contentObserver);
    }

    public static void notifyChange(Context context, Uri uri, ContentObserver contentObserver, boolean z) {
        context.getContentResolver().notifyChange(toCalledUri(context, uri), contentObserver, z);
    }

    public static Uri toCalledUri(Context context, String str, Uri uri, int i) {
        if (TextUtils.isEmpty(str) != null) {
            throw new IllegalArgumentException();
        } else if (uri == null) {
            throw new IllegalArgumentException();
        } else if (uri.getAuthority().startsWith(PluginPitProviderBase.AUTHORITY_PREFIX) != null) {
            return uri;
        } else {
            if (i == Integer.MIN_VALUE) {
                context = uri.getAuthority();
                i = Factory.queryPluginComponentList(str);
                if (i != 0) {
                    i = i.getProviderByAuthority(context);
                    if (i != 0) {
                        context = PluginClientHelper.a(i.processName).intValue();
                        if (c.a != 0) {
                            i = new StringBuilder("getProcessByAuthority(): Okay! Process=");
                            i.append(context);
                            i.append("; pn=");
                            i.append(str);
                        }
                        i = context;
                        if (i == Integer.MAX_VALUE) {
                            return uri;
                        }
                    } else if (c.a != 0) {
                        i = new StringBuilder("getProcessByAuthority(): Not register! pn=");
                        i.append(str);
                        i.append("; au=");
                        i.append(context);
                    }
                } else if (c.a != 0) {
                    i = new StringBuilder("getProcessByAuthority(): Fetch Component List Error! pn=");
                    i.append(str);
                    i.append("; au=");
                    i.append(context);
                }
                i = Integer.MAX_VALUE;
                if (i == Integer.MAX_VALUE) {
                    return uri;
                }
            }
            if (i == -2) {
                context = PluginPitProviderPersist.b;
            } else if (a.a(i) != null) {
                context = (String) a.c.get(i);
            } else {
                context = PluginPitProviderUI.b;
            }
            return Uri.parse(String.format("content://%s/%s/%s", new Object[]{context, str, uri.toString().replace("content://", "")}));
        }
    }

    public static Uri toCalledUri(Context context, Uri uri) {
        CharSequence fetchPluginName = Factory.fetchPluginName(context.getClassLoader());
        String str = null;
        if (TextUtils.isEmpty(fetchPluginName)) {
            new StringBuilder("ppc.fubc: pn is n. u=").append(uri);
        } else if (!TextUtils.equals(fetchPluginName, RePlugin.PLUGIN_NAME_MAIN)) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("PluginProviderClient.fubc(): Call Plugin! u=");
                stringBuilder.append(uri);
                c.a("ws001", stringBuilder.toString());
            }
            str = fetchPluginName;
        } else if (c.a) {
            StringBuilder stringBuilder2 = new StringBuilder("PluginProviderClient.fubc(): Call Main! u=");
            stringBuilder2.append(uri);
            c.a("ws001", stringBuilder2.toString());
        }
        return str == null ? uri : toCalledUri(context, str, uri, Integer.MIN_VALUE);
    }
}
