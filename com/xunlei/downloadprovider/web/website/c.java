package com.xunlei.downloadprovider.web.website;

import android.content.Context;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.website.b.e;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* compiled from: WebsiteListManager */
public final class c {
    public static List<e> a(Context context, List<e> list) {
        Context context2 = context;
        int size = list.size();
        List<e> arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        Collection arrayList4 = new ArrayList();
        Collection arrayList5 = new ArrayList();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            e eVar = (e) list.get(i);
            Date date = new Date(eVar.d());
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            if (a(new GregorianCalendar(), instance)) {
                eVar.h = context2.getString(R.string.website_operate_time_today);
                if (arrayList2.size() == 0) {
                    eVar.i = true;
                } else {
                    eVar.i = z;
                }
                arrayList2.add(eVar);
            } else {
                instance = Calendar.getInstance();
                instance.setTime(date);
                Calendar gregorianCalendar = new GregorianCalendar();
                Calendar gregorianCalendar2 = new GregorianCalendar();
                gregorianCalendar2.set(5, gregorianCalendar.get(5) - 1);
                if (a(gregorianCalendar2, instance)) {
                    eVar.h = context2.getString(R.string.website_operate_time_yesterday);
                    if (arrayList3.size() == 0) {
                        eVar.i = true;
                    } else {
                        eVar.i = false;
                    }
                    arrayList3.add(eVar);
                    z = false;
                } else {
                    instance = Calendar.getInstance();
                    instance.setTime(date);
                    Calendar gregorianCalendar3 = new GregorianCalendar();
                    gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.set(5, gregorianCalendar3.get(5) - 2);
                    if (!a(gregorianCalendar, instance)) {
                        gregorianCalendar.set(5, gregorianCalendar3.get(5) - 3);
                        if (!a(gregorianCalendar, instance)) {
                            gregorianCalendar.set(5, gregorianCalendar3.get(5) - 4);
                            if (!a(gregorianCalendar, instance)) {
                                gregorianCalendar.set(5, gregorianCalendar3.get(5) - 5);
                                if (!a(gregorianCalendar, instance)) {
                                    gregorianCalendar.set(5, gregorianCalendar3.get(5) - 6);
                                    if (!a(gregorianCalendar, instance)) {
                                        gregorianCalendar.set(5, gregorianCalendar3.get(5) - 7);
                                        if (!a(gregorianCalendar, instance)) {
                                            z = false;
                                            if (z) {
                                                z = false;
                                                eVar.h = context2.getString(R.string.website_operate_time_even_longer_ago);
                                                if (arrayList5.size() != 0) {
                                                    eVar.i = true;
                                                } else {
                                                    eVar.i = false;
                                                }
                                                arrayList5.add(eVar);
                                            } else {
                                                eVar.h = context2.getString(R.string.website_operate_time_seven);
                                                if (arrayList4.size() != 0) {
                                                    eVar.i = true;
                                                    z = false;
                                                } else {
                                                    z = false;
                                                    eVar.i = false;
                                                }
                                                arrayList4.add(eVar);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        z = false;
                        eVar.h = context2.getString(R.string.website_operate_time_even_longer_ago);
                        if (arrayList5.size() != 0) {
                            eVar.i = false;
                        } else {
                            eVar.i = true;
                        }
                        arrayList5.add(eVar);
                    } else {
                        eVar.h = context2.getString(R.string.website_operate_time_seven);
                        if (arrayList4.size() != 0) {
                            z = false;
                            eVar.i = false;
                        } else {
                            eVar.i = true;
                            z = false;
                        }
                        arrayList4.add(eVar);
                    }
                }
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        arrayList.addAll(arrayList4);
        arrayList.addAll(arrayList5);
        return arrayList;
    }

    private static boolean a(Calendar calendar, Calendar calendar2) {
        if (calendar.get(5) == calendar2.get(5) && calendar.get(2) == calendar2.get(2) && calendar.get(1) == calendar2.get(1)) {
            return true;
        }
        return null;
    }
}
