package com.ut.mini;

import android.text.TextUtils;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.p;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import java.util.Map;

public class UTHitBuilders {

    public static class UTHitBuilder {
        public static final String FIELD_ARG1 = "_field_arg1";
        public static final String FIELD_ARG2 = "_field_arg2";
        public static final String FIELD_ARG3 = "_field_arg3";
        public static final String FIELD_ARGS = "_field_args";
        public static final String FIELD_EVENT_ID = "_field_event_id";
        public static final String FIELD_PAGE = "_field_page";
        private Map<String, String> v = new HashMap();

        public UTHitBuilder() {
            if (!this.v.containsKey(FIELD_PAGE)) {
                this.v.put(FIELD_PAGE, "UT");
            }
        }

        public UTHitBuilder setProperty(String str, String str2) {
            if (TextUtils.isEmpty(str) || str2 == null) {
                i.b("setProperty", "key is null or key is empty or value is null,please check it!");
            } else {
                if (this.v.containsKey(str)) {
                    this.v.remove(str);
                }
                this.v.put(str, str2);
            }
            return this;
        }

        public UTHitBuilder setProperties(Map<String, String> map) {
            if (map != null) {
                this.v.putAll(map);
            }
            return this;
        }

        public String getProperty(String str) {
            return (str == null || !this.v.containsKey(str)) ? null : (String) this.v.get(str);
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap();
            hashMap.putAll(this.v);
            if (!a(hashMap)) {
                return null;
            }
            e(hashMap);
            d(hashMap);
            if (hashMap.containsKey(LogField.EVENTID.toString())) {
                return hashMap;
            }
            return null;
        }

        private static boolean a(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(null)) {
                    map.remove(null);
                }
                if (map.containsKey("")) {
                    map.remove("");
                }
                if (map.containsKey(LogField.PAGE.toString())) {
                    i.b("checkIlleagleProperty", "IlleaglePropertyKey(PAGE) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.EVENTID.toString())) {
                    i.b("checkIlleagleProperty", "IlleaglePropertyKey(EVENTID) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG1.toString())) {
                    i.b("checkIlleagleProperty", "IlleaglePropertyKey(ARG1) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG2.toString())) {
                    i.b("checkIlleagleProperty", "IlleaglePropertyKey(ARG2) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG3.toString()) != null) {
                    i.b("checkIlleagleProperty", "IlleaglePropertyKey(ARG3) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                }
            }
            return true;
        }

        private static void d(Map<String, String> map) {
            if (map != null) {
                String str;
                if (map.containsKey(FIELD_PAGE)) {
                    str = (String) map.get(FIELD_PAGE);
                    map.remove(FIELD_PAGE);
                    map.put(LogField.PAGE.toString(), str);
                }
                if (map.containsKey(FIELD_ARG1)) {
                    str = (String) map.get(FIELD_ARG1);
                    map.remove(FIELD_ARG1);
                    map.put(LogField.ARG1.toString(), str);
                }
                if (map.containsKey(FIELD_ARG2)) {
                    str = (String) map.get(FIELD_ARG2);
                    map.remove(FIELD_ARG2);
                    map.put(LogField.ARG2.toString(), str);
                }
                if (map.containsKey(FIELD_ARG3)) {
                    str = (String) map.get(FIELD_ARG3);
                    map.remove(FIELD_ARG3);
                    map.put(LogField.ARG3.toString(), str);
                }
                if (map.containsKey(FIELD_ARGS)) {
                    str = (String) map.get(FIELD_ARGS);
                    map.remove(FIELD_ARGS);
                    map.put(LogField.ARGS.toString(), str);
                }
                if (map.containsKey(FIELD_EVENT_ID)) {
                    str = (String) map.get(FIELD_EVENT_ID);
                    map.remove(FIELD_EVENT_ID);
                    map.put(LogField.EVENTID.toString(), str);
                }
            }
        }

        private static void e(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(LogField.PAGE.toString())) {
                    map.remove(LogField.PAGE.toString());
                }
                if (map.containsKey(LogField.EVENTID.toString())) {
                    map.remove(LogField.EVENTID.toString());
                }
                if (map.containsKey(LogField.ARG1.toString())) {
                    map.remove(LogField.ARG1.toString());
                }
                if (map.containsKey(LogField.ARG2.toString())) {
                    map.remove(LogField.ARG2.toString());
                }
                if (map.containsKey(LogField.ARG3.toString())) {
                    map.remove(LogField.ARG3.toString());
                }
                if (map.containsKey(LogField.ARGS.toString())) {
                    map.remove(LogField.ARGS.toString());
                }
            }
        }
    }

    public static class UTControlHitBuilder extends UTHitBuilder {
        public UTControlHitBuilder(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Control name can not be empty.");
            }
            String currentPageName = UTPageHitHelper.getInstance().getCurrentPageName();
            if (TextUtils.isEmpty(currentPageName)) {
                throw new IllegalArgumentException("Please call in at PageAppear and PageDisAppear.");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(currentPageName);
            stringBuilder.append("_");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            super.setProperty(UTHitBuilder.FIELD_PAGE, currentPageName);
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
            super.setProperty(UTHitBuilder.FIELD_ARG1, str);
        }

        public UTControlHitBuilder(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("Control name can not be empty.");
            } else if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Page name can not be empty.");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("_");
                stringBuilder.append(str2);
                str2 = stringBuilder.toString();
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
                super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
                super.setProperty(UTHitBuilder.FIELD_ARG1, str2);
            }
        }
    }

    public static class UTCustomHitBuilder extends UTHitBuilder {
        public UTCustomHitBuilder(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, str);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "19999");
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
        }

        public UTCustomHitBuilder setDurationOnEvent(long j) {
            if (j < 0) {
                j = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, String.valueOf(j));
            return this;
        }

        public UTCustomHitBuilder setEventPage(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
            }
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> build = super.build();
            if (build != null) {
                String str = (String) build.get(LogField.PAGE.toString());
                String str2 = (String) build.get(LogField.ARG1.toString());
                if (str2 != null) {
                    build.remove(LogField.ARG1.toString());
                    build.remove(LogField.PAGE.toString());
                    build = p.a(build);
                    build.put(LogField.ARG1.toString(), str2);
                    build.put(LogField.PAGE.toString(), str);
                    return build;
                }
            }
            return build;
        }
    }

    public static class UTPageHitBuilder extends UTHitBuilder {
        public UTPageHitBuilder(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2001");
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
        }

        public UTPageHitBuilder setReferPage(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, str);
            }
            return this;
        }

        public UTPageHitBuilder setDurationOnPage(long j) {
            if (j < 0) {
                j = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, String.valueOf(j));
            return this;
        }
    }
}
