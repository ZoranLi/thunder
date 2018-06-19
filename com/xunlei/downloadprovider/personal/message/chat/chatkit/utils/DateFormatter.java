package com.xunlei.downloadprovider.personal.message.chat.chatkit.utils;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class DateFormatter {

    public enum Template {
        STRING_DAY_MONTH_YEAR("d MMMM yyyy"),
        STRING_DAY_MONTH("d MMMM"),
        TIME("HH:mm");
        
        private String template;

        private Template(String str) {
            this.template = str;
        }

        public final String get() {
            return this.template;
        }
    }

    public interface a {
        String a(Date date);

        String b(Date date);
    }

    public static Date a(IChatMessage iChatMessage) {
        return new Date(TimeUnit.SECONDS.toMillis((long) iChatMessage.createdAt()));
    }

    public static String a(Date date, Template template) {
        return a(date, template.get());
    }

    public static String a(Date date, String str) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(str, Locale.getDefault()).format(date);
    }

    public static boolean a(Date date, Date date2) {
        if (date != null) {
            if (date2 != null) {
                Calendar instance = Calendar.getInstance();
                instance.setTime(date);
                date = Calendar.getInstance();
                date.setTime(date2);
                if (instance != null) {
                    if (date != null) {
                        return instance.get(0) == date.get(0) && instance.get(1) == date.get(1) && instance.get(6) == date.get(6);
                    }
                }
                throw new IllegalArgumentException("Dates must not be null");
            }
        }
        throw new IllegalArgumentException("Dates must not be null");
    }

    public static boolean a(Date date) {
        return a(date, Calendar.getInstance().getTime());
    }

    public static boolean b(Date date) {
        Date time = Calendar.getInstance().getTime();
        if (date != null) {
            if (time != null) {
                Calendar instance = Calendar.getInstance();
                instance.setTime(date);
                date = Calendar.getInstance();
                date.setTime(time);
                if (instance != null) {
                    if (date != null) {
                        if (instance.get(0) == date.get(0) && instance.get(1) == date.get(1)) {
                            return true;
                        }
                        return false;
                    }
                }
                throw new IllegalArgumentException("Dates must not be null");
            }
        }
        throw new IllegalArgumentException("Dates must not be null");
    }
}
