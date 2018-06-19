package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.OperationCanceledException;
import android.support.v4.os.CancellationSignal;

public final class ContentResolverCompat {
    private ContentResolverCompat() {
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        if (VERSION.SDK_INT >= 16) {
            if (cancellationSignal != null) {
                try {
                    cancellationSignal = cancellationSignal.getCancellationSignalObject();
                } catch (ContentResolver contentResolver2) {
                    if ((contentResolver2 instanceof OperationCanceledException) != null) {
                        throw new android.support.v4.os.OperationCanceledException();
                    }
                    throw contentResolver2;
                }
            }
            cancellationSignal = null;
            return contentResolver2.query(uri, strArr, str, strArr2, str2, (android.os.CancellationSignal) cancellationSignal);
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        return contentResolver2.query(uri, strArr, str, strArr2, str2);
    }
}
