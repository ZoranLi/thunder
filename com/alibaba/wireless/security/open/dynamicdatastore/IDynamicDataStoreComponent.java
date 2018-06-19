package com.alibaba.wireless.security.open.dynamicdatastore;

import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;

public interface IDynamicDataStoreComponent extends IComponent {
    boolean getBoolean(String str) throws SecException;

    byte[] getByteArray(String str) throws SecException;

    byte[] getByteArrayDDp(String str) throws SecException;

    byte[] getByteArrayDDpEx(String str, int i) throws SecException;

    float getFloat(String str) throws SecException;

    int getInt(String str) throws SecException;

    long getLong(String str) throws SecException;

    String getString(String str) throws SecException;

    String getStringDDp(String str) throws SecException;

    String getStringDDpEx(String str, int i) throws SecException;

    int putBoolean(String str, boolean z) throws SecException;

    int putByteArray(String str, byte[] bArr) throws SecException;

    int putByteArrayDDp(String str, byte[] bArr) throws SecException;

    boolean putByteArrayDDpEx(String str, byte[] bArr, int i) throws SecException;

    int putFloat(String str, float f) throws SecException;

    int putInt(String str, int i) throws SecException;

    int putLong(String str, long j) throws SecException;

    int putString(String str, String str2) throws SecException;

    int putStringDDp(String str, String str2) throws SecException;

    boolean putStringDDpEx(String str, String str2, int i) throws SecException;

    void removeBoolean(String str) throws SecException;

    void removeByteArray(String str) throws SecException;

    void removeByteArrayDDp(String str) throws SecException;

    void removeByteArrayDDpEx(String str, int i) throws SecException;

    void removeFloat(String str) throws SecException;

    void removeInt(String str) throws SecException;

    void removeLong(String str) throws SecException;

    void removeString(String str) throws SecException;

    void removeStringDDp(String str) throws SecException;

    void removeStringDDpEx(String str, int i) throws SecException;
}
