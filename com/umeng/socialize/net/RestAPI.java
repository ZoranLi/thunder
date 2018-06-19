package com.umeng.socialize.net;

import com.umeng.socialize.net.base.SocializeClient;
import com.umeng.socialize.net.base.SocializeReseponse;

public class RestAPI {
    private static SocializeClient a = new SocializeClient();

    public static ActionBarResponse queryShareId(ActionBarRequest actionBarRequest) {
        return (ActionBarResponse) a.execute(actionBarRequest);
    }

    public static PlatformTokenUploadResponse uploadPlatformToken(PlatformTokenUploadReq platformTokenUploadReq) {
        return (PlatformTokenUploadResponse) a.execute(platformTokenUploadReq);
    }

    public static LinkCardResponse convertLinkCard(LinkcardRequest linkcardRequest) {
        return (LinkCardResponse) a.execute(linkcardRequest);
    }

    public static SocializeReseponse doShare(SharePostRequest sharePostRequest) {
        return a.execute(sharePostRequest);
    }

    public static UrlResponse uploadUrl(UrlRequest urlRequest) {
        return (UrlResponse) a.execute(urlRequest);
    }
}
