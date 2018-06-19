package com.umeng.socialize.media;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.ShareContent;
import java.util.ArrayList;
import java.util.Iterator;

public class QZoneShareContent extends SimpleShareContent {
    private boolean isPublish = false;
    public int mShareType = 1;
    private UMediaObject uMedia;

    public QZoneShareContent(ShareContent shareContent) {
        super(shareContent);
        this.uMedia = shareContent.mMedia;
    }

    public UMediaObject getMedia() {
        return this.uMedia;
    }

    public boolean getisPublish() {
        return this.isPublish;
    }

    public Bundle buildParamsQzone() {
        ArrayList arrayList;
        Iterator it;
        CharSequence string;
        Bundle bundle = new Bundle();
        this.isPublish = false;
        int i = 3;
        if (getmStyle() != 2) {
            if (getmStyle() != 3) {
                if (getmStyle() == 4) {
                    this.mShareType = 2;
                    buildAudioParams(bundle);
                } else if (getmStyle() == 16) {
                    buildWebParams(bundle);
                } else if (getmStyle() == 8) {
                    buildAudioParams(bundle);
                } else {
                    this.isPublish = true;
                    bundle.putString("summary", getText());
                    arrayList = new ArrayList();
                    if (QQExtra.QzoneList.size() > 1) {
                        it = QQExtra.QzoneList.iterator();
                        while (it.hasNext()) {
                            arrayList.add((String) it.next());
                        }
                        bundle.remove("imageLocalUrl");
                        bundle.putStringArrayList("imageLocalUrl", arrayList);
                        QQExtra.QzoneList.clear();
                    } else {
                        string = bundle.getString("imageUrl");
                        bundle.remove("imageUrl");
                        if (!TextUtils.isEmpty(string)) {
                            arrayList.add(string);
                        }
                        bundle.putStringArrayList("imageUrl", arrayList);
                        string = bundle.getString("imageLocalUrl");
                        bundle.remove("imageLocalUrl");
                        if (!TextUtils.isEmpty(string)) {
                            arrayList.add(string);
                        }
                        bundle.putStringArrayList("imageLocalUrl", arrayList);
                    }
                    bundle.putInt("req_type", i);
                    return bundle;
                }
                i = 1;
                arrayList = new ArrayList();
                if (QQExtra.QzoneList.size() > 1) {
                    string = bundle.getString("imageUrl");
                    bundle.remove("imageUrl");
                    if (TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                    bundle.putStringArrayList("imageUrl", arrayList);
                    string = bundle.getString("imageLocalUrl");
                    bundle.remove("imageLocalUrl");
                    if (TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                    bundle.putStringArrayList("imageLocalUrl", arrayList);
                } else {
                    it = QQExtra.QzoneList.iterator();
                    while (it.hasNext()) {
                        arrayList.add((String) it.next());
                    }
                    bundle.remove("imageLocalUrl");
                    bundle.putStringArrayList("imageLocalUrl", arrayList);
                    QQExtra.QzoneList.clear();
                }
                bundle.putInt("req_type", i);
                return bundle;
            }
        }
        this.mShareType = 5;
        buildImageParams(bundle);
        this.isPublish = true;
        arrayList = new ArrayList();
        if (QQExtra.QzoneList.size() > 1) {
            it = QQExtra.QzoneList.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
            bundle.remove("imageLocalUrl");
            bundle.putStringArrayList("imageLocalUrl", arrayList);
            QQExtra.QzoneList.clear();
        } else {
            string = bundle.getString("imageUrl");
            bundle.remove("imageUrl");
            if (TextUtils.isEmpty(string)) {
                arrayList.add(string);
            }
            bundle.putStringArrayList("imageUrl", arrayList);
            string = bundle.getString("imageLocalUrl");
            bundle.remove("imageLocalUrl");
            if (TextUtils.isEmpty(string)) {
                arrayList.add(string);
            }
            bundle.putStringArrayList("imageLocalUrl", arrayList);
        }
        bundle.putInt("req_type", i);
        return bundle;
    }

    private void buildAudioParams(Bundle bundle) {
        UMImage thumbImage = getBaseMediaObject().getThumbImage();
        if (thumbImage.isUrlMedia()) {
            bundle.putString("imageUrl", thumbImage.toUrl());
        } else {
            bundle.putString("imageLocalUrl", thumbImage.asFileImage().toString());
        }
        bundle.putString("targetUrl", getBaseMediaObject().toUrl());
        if (getMusic() != null) {
            bundle.putString("targetUrl", getMusic().getmTargetUrl());
        }
        bundle.putString("title", objectSetTitle(getBaseMediaObject()));
        bundle.putString("summary", objectSetDescription(getBaseMediaObject()));
        bundle.putString("audio_url", getBaseMediaObject().toUrl());
    }

    private void buildImageParams(Bundle bundle) {
        if (getImage() != null && getImage().asFileImage() != null) {
            bundle.putString("imageUrl", getImage().asFileImage().toString());
        }
    }

    private void buildWebParams(Bundle bundle) {
        UMImage thumbImage = getUmWeb().getThumbImage();
        if (thumbImage != null) {
            if (thumbImage.isUrlMedia()) {
                bundle.putString("imageUrl", thumbImage.toUrl());
            } else if (thumbImage.asFileImage() != null) {
                bundle.putString("imageLocalUrl", thumbImage.asFileImage().toString());
            }
        }
        bundle.putString("targetUrl", getUmWeb().toUrl());
        bundle.putString("title", objectSetTitle(getUmWeb()));
        bundle.putString("summary", objectSetDescription(getUmWeb()));
    }
}
