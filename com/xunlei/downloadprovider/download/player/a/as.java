package com.xunlei.downloadprovider.download.player.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* compiled from: RecordPublishController */
final class as extends BroadcastReceiver {
    final /* synthetic */ aq a;

    as(aq aqVar) {
        this.a = aqVar;
    }

    public final void onReceive(Context context, Intent intent) {
        String stringExtra;
        String f;
        context = intent.getAction();
        int hashCode = context.hashCode();
        if (hashCode != -1706476391) {
            if (hashCode != -15804180) {
                if (hashCode == 1364811188) {
                    if (context.equals("Action_Broadcast_RecordVideoPreviewActivity") != null) {
                        context = null;
                        switch (context) {
                            case null:
                                context = intent.getIntExtra("Key_Click_Event", -1);
                                if (context != null) {
                                    this.a.n = false;
                                    this.a.b("cancel");
                                    return;
                                } else if (context != 1) {
                                    this.a.n = false;
                                    aq.e(this.a);
                                    return;
                                } else if (context == 2) {
                                    this.a.b("upload");
                                    return;
                                }
                                break;
                            case 1:
                                this.a.n = false;
                                context = intent.getIntExtra("Key_Click_Event", -1);
                                if (context != null && context == 1) {
                                    context = intent.getStringExtra("title");
                                    stringExtra = intent.getStringExtra("topic");
                                    intent = intent.getBooleanExtra("isSaveLocal", false);
                                    f = this.a.k;
                                    if (intent != null) {
                                        intent = aq.e(this.a);
                                        if (!TextUtils.isEmpty(intent)) {
                                            aq.a(this.a, context, stringExtra, intent);
                                            return;
                                        }
                                    }
                                    intent = f;
                                    aq.a(this.a, context, stringExtra, intent);
                                    return;
                                }
                            case 2:
                                if (!(this.a.f() == null || this.a.f().m_() == null)) {
                                    this.a.c(false);
                                    break;
                                }
                            default:
                                break;
                        }
                    }
                }
            } else if (context.equals("DownloadVodPlayerController.ACTION_PLAY_COMPLETION") != null) {
                context = 2;
                switch (context) {
                    case null:
                        context = intent.getIntExtra("Key_Click_Event", -1);
                        if (context != null) {
                            this.a.n = false;
                            this.a.b("cancel");
                            return;
                        } else if (context != 1) {
                            this.a.n = false;
                            aq.e(this.a);
                            return;
                        } else if (context == 2) {
                            this.a.b("upload");
                            return;
                        }
                        break;
                    case 1:
                        this.a.n = false;
                        context = intent.getIntExtra("Key_Click_Event", -1);
                        context = intent.getStringExtra("title");
                        stringExtra = intent.getStringExtra("topic");
                        intent = intent.getBooleanExtra("isSaveLocal", false);
                        f = this.a.k;
                        if (intent != null) {
                            intent = aq.e(this.a);
                            if (TextUtils.isEmpty(intent)) {
                                aq.a(this.a, context, stringExtra, intent);
                                return;
                            }
                        }
                        intent = f;
                        aq.a(this.a, context, stringExtra, intent);
                        return;
                    case 2:
                        this.a.c(false);
                        break;
                    default:
                        break;
                }
            }
        } else if (context.equals("Action_Broadcast_VodPlayerPublishActivity") != null) {
            context = 1;
            switch (context) {
                case null:
                    context = intent.getIntExtra("Key_Click_Event", -1);
                    if (context != null) {
                        this.a.n = false;
                        this.a.b("cancel");
                        return;
                    } else if (context != 1) {
                        this.a.n = false;
                        aq.e(this.a);
                        return;
                    } else if (context == 2) {
                        this.a.b("upload");
                        return;
                    }
                    break;
                case 1:
                    this.a.n = false;
                    context = intent.getIntExtra("Key_Click_Event", -1);
                    context = intent.getStringExtra("title");
                    stringExtra = intent.getStringExtra("topic");
                    intent = intent.getBooleanExtra("isSaveLocal", false);
                    f = this.a.k;
                    if (intent != null) {
                        intent = aq.e(this.a);
                        if (TextUtils.isEmpty(intent)) {
                            aq.a(this.a, context, stringExtra, intent);
                            return;
                        }
                    }
                    intent = f;
                    aq.a(this.a, context, stringExtra, intent);
                    return;
                case 2:
                    this.a.c(false);
                    break;
                default:
                    break;
            }
        }
        context = -1;
        switch (context) {
            case null:
                context = intent.getIntExtra("Key_Click_Event", -1);
                if (context != null) {
                    this.a.n = false;
                    this.a.b("cancel");
                    return;
                } else if (context != 1) {
                    this.a.n = false;
                    aq.e(this.a);
                    return;
                } else if (context == 2) {
                    this.a.b("upload");
                    return;
                }
                break;
            case 1:
                this.a.n = false;
                context = intent.getIntExtra("Key_Click_Event", -1);
                context = intent.getStringExtra("title");
                stringExtra = intent.getStringExtra("topic");
                intent = intent.getBooleanExtra("isSaveLocal", false);
                f = this.a.k;
                if (intent != null) {
                    intent = aq.e(this.a);
                    if (TextUtils.isEmpty(intent)) {
                        aq.a(this.a, context, stringExtra, intent);
                        return;
                    }
                }
                intent = f;
                aq.a(this.a, context, stringExtra, intent);
                return;
            case 2:
                this.a.c(false);
                break;
            default:
                break;
        }
    }
}
