package com.qihoo360.loader2.mgr;

import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;

public class PluginProviderClient {
    public static ContentProviderClient acquireContentProviderClient(Context context, String str) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.acquireContentProviderClient(context, str);
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.query(context, uri, strArr, str, strArr2, str2);
    }

    @TargetApi(16)
    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.query(context, uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    public static String getType(Context context, Uri uri) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.getType(context, uri);
    }

    public static Uri insert(Context context, Uri uri, ContentValues contentValues) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.insert(context, uri, contentValues);
    }

    public static int bulkInsert(Context context, Uri uri, ContentValues[] contentValuesArr) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.bulkInsert(context, uri, contentValuesArr);
    }

    public static int delete(Context context, Uri uri, String str, String[] strArr) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.delete(context, uri, str, strArr);
    }

    public static int update(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.update(context, uri, contentValues, str, strArr);
    }

    public static InputStream openInputStream(Context context, Uri uri) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.openInputStream(context, uri);
    }

    public static OutputStream openOutputStream(Context context, Uri uri) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.openOutputStream(context, uri);
    }

    public static OutputStream openOutputStream(Context context, Uri uri, String str) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.openOutputStream(context, uri, str);
    }

    public static ParcelFileDescriptor openFileDescriptor(Context context, Uri uri, String str) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.openFileDescriptor(context, uri, str);
    }

    @TargetApi(19)
    public static ParcelFileDescriptor openFileDescriptor(Context context, Uri uri, String str, CancellationSignal cancellationSignal) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.openFileDescriptor(context, uri, str, cancellationSignal);
    }

    public static void registerContentObserver(Context context, Uri uri, boolean z, ContentObserver contentObserver) {
        com.qihoo360.replugin.component.provider.PluginProviderClient.registerContentObserver(context, uri, z, contentObserver);
    }

    public static void notifyChange(Context context, Uri uri, ContentObserver contentObserver) {
        com.qihoo360.replugin.component.provider.PluginProviderClient.notifyChange(context, uri, contentObserver);
    }

    public static void notifyChange(Context context, Uri uri, ContentObserver contentObserver, boolean z) {
        com.qihoo360.replugin.component.provider.PluginProviderClient.notifyChange(context, uri, contentObserver, z);
    }

    public static Uri toCalledUri(Context context, Uri uri) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.toCalledUri(context, uri);
    }

    public static Uri toCalledUri(Context context, String str, Uri uri, int i) {
        return com.qihoo360.replugin.component.provider.PluginProviderClient.toCalledUri(context, str, uri, i);
    }
}
