package com.xunlei.downloadprovider.publiser.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.user.account.k;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: UserTypeInfoDlg */
public final class a extends XLBaseDialog {
    private boolean a;
    private String b;

    public a(Context context, boolean z, String str) {
        super(context, R.style.ThunderTheme.Dialog);
        this.a = z;
        this.b = str;
        context = LayoutInflater.from(this.mCtx).inflate(true, null);
        setContentView(context);
        ImageView imageView = (ImageView) findViewById(true);
        str = this.a;
        String str2 = this.b;
        Object obj = 2;
        if (str == null) {
            str = str2.hashCode();
            if (str == -153325523) {
                if (str2.equals("yl_nanshen") != null) {
                    str = 2;
                    switch (str) {
                        case null:
                            str = R.drawable.user_type_info_live_img;
                            break;
                        case 1:
                            str = R.drawable.user_type_info_yl_daren_img;
                            break;
                        case 2:
                            str = R.drawable.user_type_info_yl_nanshen_img;
                            break;
                        case 3:
                            str = R.drawable.user_type_info_yl_nvshen_img;
                            break;
                        default:
                            break;
                    }
                }
            } else if (str == 112661) {
                if (str2.equals("rad") != null) {
                    str = null;
                    switch (str) {
                        case null:
                            str = R.drawable.user_type_info_live_img;
                            break;
                        case 1:
                            str = R.drawable.user_type_info_yl_daren_img;
                            break;
                        case 2:
                            str = R.drawable.user_type_info_yl_nanshen_img;
                            break;
                        case 3:
                            str = R.drawable.user_type_info_yl_nvshen_img;
                            break;
                        default:
                            break;
                    }
                }
            } else if (str == 307926738) {
                if (str2.equals("yl_daren") != null) {
                    str = 1;
                    switch (str) {
                        case null:
                            str = R.drawable.user_type_info_live_img;
                            break;
                        case 1:
                            str = R.drawable.user_type_info_yl_daren_img;
                            break;
                        case 2:
                            str = R.drawable.user_type_info_yl_nanshen_img;
                            break;
                        case 3:
                            str = R.drawable.user_type_info_yl_nvshen_img;
                            break;
                        default:
                            break;
                    }
                }
            } else if (str == 1261512242) {
                if (str2.equals("yl_nvshen") != null) {
                    str = 3;
                    switch (str) {
                        case null:
                            str = R.drawable.user_type_info_live_img;
                            break;
                        case 1:
                            str = R.drawable.user_type_info_yl_daren_img;
                            break;
                        case 2:
                            str = R.drawable.user_type_info_yl_nanshen_img;
                            break;
                        case 3:
                            str = R.drawable.user_type_info_yl_nvshen_img;
                            break;
                        default:
                            break;
                    }
                }
            }
            str = -1;
            switch (str) {
                case null:
                    str = R.drawable.user_type_info_live_img;
                    break;
                case 1:
                    str = R.drawable.user_type_info_yl_daren_img;
                    break;
                case 2:
                    str = R.drawable.user_type_info_yl_nanshen_img;
                    break;
                case 3:
                    str = R.drawable.user_type_info_yl_nvshen_img;
                    break;
                default:
                    break;
            }
        }
        str = R.drawable.user_type_info_big_v_img;
        imageView.setImageResource(str);
        TextView textView = (TextView) findViewById(true);
        str = this.a;
        str2 = this.b;
        if (str == null) {
            str = str2.hashCode();
            if (str == -153325523) {
                if (str2.equals("yl_nanshen") != null) {
                    str = 2;
                    switch (str) {
                        case null:
                            str = R.string.user_type_info_title_live;
                            break;
                        case 1:
                            str = R.string.user_type_info_title_yl_daren;
                            break;
                        case 2:
                            str = R.string.user_type_info_title_yl_nanshen;
                            break;
                        case 3:
                            str = R.string.user_type_info_title_yl_nvshen;
                            break;
                        default:
                            break;
                    }
                }
            } else if (str == 112661) {
                if (str2.equals("rad") != null) {
                    str = null;
                    switch (str) {
                        case null:
                            str = R.string.user_type_info_title_live;
                            break;
                        case 1:
                            str = R.string.user_type_info_title_yl_daren;
                            break;
                        case 2:
                            str = R.string.user_type_info_title_yl_nanshen;
                            break;
                        case 3:
                            str = R.string.user_type_info_title_yl_nvshen;
                            break;
                        default:
                            break;
                    }
                }
            } else if (str == 307926738) {
                if (str2.equals("yl_daren") != null) {
                    str = 1;
                    switch (str) {
                        case null:
                            str = R.string.user_type_info_title_live;
                            break;
                        case 1:
                            str = R.string.user_type_info_title_yl_daren;
                            break;
                        case 2:
                            str = R.string.user_type_info_title_yl_nanshen;
                            break;
                        case 3:
                            str = R.string.user_type_info_title_yl_nvshen;
                            break;
                        default:
                            break;
                    }
                }
            } else if (str == 1261512242) {
                if (str2.equals("yl_nvshen") != null) {
                    str = 3;
                    switch (str) {
                        case null:
                            str = R.string.user_type_info_title_live;
                            break;
                        case 1:
                            str = R.string.user_type_info_title_yl_daren;
                            break;
                        case 2:
                            str = R.string.user_type_info_title_yl_nanshen;
                            break;
                        case 3:
                            str = R.string.user_type_info_title_yl_nvshen;
                            break;
                        default:
                            break;
                    }
                }
            }
            str = -1;
            switch (str) {
                case null:
                    str = R.string.user_type_info_title_live;
                    break;
                case 1:
                    str = R.string.user_type_info_title_yl_daren;
                    break;
                case 2:
                    str = R.string.user_type_info_title_yl_nanshen;
                    break;
                case 3:
                    str = R.string.user_type_info_title_yl_nvshen;
                    break;
                default:
                    break;
            }
        }
        str = R.string.user_type_info_title_big_v;
        textView.setText(str);
        textView = (TextView) findViewById(true);
        str = this.a;
        str2 = this.b;
        if (str == null) {
            str = str2.hashCode();
            if (str == -153325523) {
                if (str2.equals("yl_nanshen") != null) {
                    switch (obj) {
                        case null:
                            str = R.string.user_type_info_live;
                            break;
                        case 1:
                            str = R.string.user_type_info_yl_daren;
                            break;
                        case 2:
                            str = R.string.user_type_info_yl_nanshen;
                            break;
                        case 3:
                            str = R.string.user_type_info_yl_nvshen;
                            break;
                        default:
                            break;
                    }
                }
            } else if (str == 112661) {
                if (str2.equals("rad") != null) {
                    obj = null;
                    switch (obj) {
                        case null:
                            str = R.string.user_type_info_live;
                            break;
                        case 1:
                            str = R.string.user_type_info_yl_daren;
                            break;
                        case 2:
                            str = R.string.user_type_info_yl_nanshen;
                            break;
                        case 3:
                            str = R.string.user_type_info_yl_nvshen;
                            break;
                        default:
                            break;
                    }
                }
            } else if (str == 307926738) {
                if (str2.equals("yl_daren") != null) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            str = R.string.user_type_info_live;
                            break;
                        case 1:
                            str = R.string.user_type_info_yl_daren;
                            break;
                        case 2:
                            str = R.string.user_type_info_yl_nanshen;
                            break;
                        case 3:
                            str = R.string.user_type_info_yl_nvshen;
                            break;
                        default:
                            break;
                    }
                }
            } else if (str == 1261512242) {
                if (str2.equals("yl_nvshen") != null) {
                    obj = 3;
                    switch (obj) {
                        case null:
                            str = R.string.user_type_info_live;
                            break;
                        case 1:
                            str = R.string.user_type_info_yl_daren;
                            break;
                        case 2:
                            str = R.string.user_type_info_yl_nanshen;
                            break;
                        case 3:
                            str = R.string.user_type_info_yl_nvshen;
                            break;
                        default:
                            break;
                    }
                }
            }
            obj = -1;
            switch (obj) {
                case null:
                    str = R.string.user_type_info_live;
                    break;
                case 1:
                    str = R.string.user_type_info_yl_daren;
                    break;
                case 2:
                    str = R.string.user_type_info_yl_nanshen;
                    break;
                case 3:
                    str = R.string.user_type_info_yl_nvshen;
                    break;
                default:
                    break;
            }
        }
        str = R.string.user_type_info_big_v;
        textView.setText(str);
        ((TextView) context.findViewById(true)).setOnClickListener(new b(this));
        setOnCancelListener(new c(this));
    }

    public final void show() {
        super.show();
        String str = this.a ? "da_v" : this.b;
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_identity_pop_show");
        build.add("identity", str);
        k.a(build);
    }
}
