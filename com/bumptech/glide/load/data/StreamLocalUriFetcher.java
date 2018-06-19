package com.bumptech.glide.load.data;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {
    private static final int ID_CONTACT = 3;
    private static final int ID_DISPLAY_PHOTO = 4;
    private static final int ID_LOOKUP = 1;
    private static final int ID_THUMBNAIL = 2;
    private static final UriMatcher URI_MATCHER;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        URI_MATCHER = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        URI_MATCHER.addURI("com.android.contacts", "contacts/lookup/*", 1);
        URI_MATCHER.addURI("com.android.contacts", "contacts/#/photo", 2);
        URI_MATCHER.addURI("com.android.contacts", "contacts/#", 3);
        URI_MATCHER.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    }

    public StreamLocalUriFetcher(Context context, Uri uri) {
        super(context, uri);
    }

    public InputStream loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return loadResourceFromUri(uri, contentResolver, URI_MATCHER.match(uri));
    }

    protected void close(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    private InputStream loadResourceFromUri(Uri uri, ContentResolver contentResolver, int i) throws FileNotFoundException {
        if (i != 1 && i != 3) {
            return contentResolver.openInputStream(uri);
        }
        if (i == 1) {
            uri = Contacts.lookupContact(contentResolver, uri);
            if (uri == null) {
                throw new FileNotFoundException("Contact cannot be found");
            }
        }
        return openContactPhotoInputStream(contentResolver, uri);
    }

    @TargetApi(14)
    private InputStream openContactPhotoInputStream(ContentResolver contentResolver, Uri uri) {
        if (VERSION.SDK_INT < 14) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
}
