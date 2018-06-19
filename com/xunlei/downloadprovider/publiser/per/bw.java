package com.xunlei.downloadprovider.publiser.per;

import android.text.TextUtils;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.publiser.common.PublisherInfo;
import com.xunlei.downloadprovider.shortvideo.entity.UserVisitInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: PublisherActivity */
final class bw implements c<PublisherInfo> {
    final /* synthetic */ PublisherActivity a;

    bw(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        PublisherInfo publisherInfo = (PublisherInfo) obj;
        if (!this.a.isFinishing()) {
            PublisherActivity publisherActivity = this.a;
            publisherActivity.e.setVisibility(8);
            if (publisherInfo != null) {
                publisherActivity.d = publisherInfo;
                publisherActivity.l = publisherActivity.d.a().getKind();
                VideoUserInfo a = publisherInfo.a();
                boolean isAuthPub = a.isAuthPub();
                String kind = a.getKind();
                if (!isAuthPub) {
                    if (kind != null) {
                        isAuthPub = true;
                        int hashCode = kind.hashCode();
                        if (hashCode != -153325523) {
                            if (hashCode != 112661) {
                                if (hashCode != 307926738) {
                                    if (hashCode == 1261512242) {
                                        if (kind.equals("yl_nvshen")) {
                                            isAuthPub = true;
                                        }
                                    }
                                } else if (kind.equals("yl_daren")) {
                                    isAuthPub = true;
                                }
                            } else if (kind.equals("rad")) {
                                isAuthPub = false;
                            }
                        } else if (kind.equals("yl_nanshen")) {
                            isAuthPub = true;
                        }
                        switch (isAuthPub) {
                            case false:
                                publisherActivity.f.setImageResource(R.drawable.user_info_tag_live);
                                publisherActivity.f.setVisibility(0);
                                break;
                            case true:
                                publisherActivity.f.setImageResource(R.drawable.user_info_tag_yl_nanshen);
                                publisherActivity.f.setVisibility(0);
                                break;
                            case true:
                                publisherActivity.f.setImageResource(R.drawable.user_info_tag_yl_nvshen);
                                publisherActivity.f.setVisibility(0);
                                break;
                            case true:
                                publisherActivity.f.setImageResource(R.drawable.user_info_tag_yl_daren);
                                publisherActivity.f.setVisibility(0);
                                break;
                            default:
                                publisherActivity.f.setVisibility(8);
                                break;
                        }
                    }
                }
                publisherActivity.f.setImageResource(R.drawable.user_info_tag_big_v_2);
                publisherActivity.f.setVisibility(0);
                publisherActivity.a((long) publisherInfo.b().c);
                publisherActivity.b((long) publisherInfo.b().b);
                publisherActivity.d(a.getDescription());
                Object obj2 = a.getLiveExtra().a;
                if (!"rad".equals(publisherActivity.l)) {
                    publisherActivity.h.setVisibility(8);
                } else if (TextUtils.isEmpty(obj2)) {
                    publisherActivity.h.setVisibility(8);
                } else {
                    publisherActivity.h.setVisibility(0);
                    TextView textView = publisherActivity.h;
                    StringBuilder stringBuilder = new StringBuilder("直播ID: ");
                    stringBuilder.append(obj2);
                    textView.setText(stringBuilder.toString());
                }
                String portraitUrl = a.getPortraitUrl();
                if (!TextUtils.isEmpty(portraitUrl)) {
                    publisherActivity.b(portraitUrl);
                }
                publisherActivity.a(a.getNickname());
                publisherActivity.c();
                if (publisherInfo.c == null) {
                    publisherInfo.c = new UserVisitInfo();
                }
                int i = publisherInfo.c.a;
                publisherActivity.m = i;
                publisherActivity.i.setText(j.a((long) i));
                publisherActivity.a(publisherInfo.b().a | b.a().b(publisherActivity.k));
                if (publisherInfo != null) {
                    publisherActivity.g.setUserInfo(publisherActivity.d.a());
                }
                if (publisherActivity.n) {
                    publisherActivity.j.setCurrentItem(1, false);
                } else if (publisherActivity.c > 0) {
                    publisherActivity.j.setCurrentItem(0, false);
                } else if (publisherActivity.a > 0) {
                    publisherActivity.j.setCurrentItem(1, false);
                }
            }
            this.a.I.a(publisherInfo);
        }
    }

    public final void onFail(String str) {
        PublisherInfo publisherInfo = new PublisherInfo();
        VideoUserInfo videoUserInfo = new VideoUserInfo();
        videoUserInfo.setNickname(this.a.J);
        videoUserInfo.setPortraitUrl(this.a.K);
        publisherInfo.a = videoUserInfo;
        this.a.I.a(publisherInfo);
        this.a.b();
    }
}
