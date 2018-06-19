package com.qihoo360.mobilesafe.parser.manifest;

import android.content.IntentFilter;
import android.os.PatternMatcher;
import com.alipay.sdk.util.h;
import com.qihoo360.mobilesafe.parser.manifest.a.a;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.model.PluginInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public enum ManifestParser {
    INS;
    
    public static final String TAG = "ms-parser";
    private Map<String, Set<String>> mActivityActionPluginsMap;
    private Map<String, Map<String, List<IntentFilter>>> mPluginActivityInfoMap;
    private Map<String, Map<String, List<IntentFilter>>> mPluginReceiverInfoMap;
    private Map<String, Map<String, List<IntentFilter>>> mPluginServiceInfoMap;
    private Map<String, Set<String>> mServiceActionPluginsMap;

    public final void parse(PluginInfo pluginInfo, String str) {
        str = parseManifest(str);
        Map hashMap = new HashMap();
        putToMap(this.mPluginActivityInfoMap, hashMap, pluginInfo);
        parseComponent(pluginInfo.getName(), hashMap, str.a, this.mActivityActionPluginsMap);
        Map hashMap2 = new HashMap();
        putToMap(this.mPluginServiceInfoMap, hashMap2, pluginInfo);
        parseComponent(pluginInfo.getName(), hashMap2, str.b, this.mServiceActionPluginsMap);
        Map hashMap3 = new HashMap();
        putToMap(this.mPluginReceiverInfoMap, hashMap3, pluginInfo);
        parseComponent(pluginInfo.getName(), hashMap3, str.c, null);
        if (c.a != null) {
            printFilters(hashMap, hashMap2, hashMap3);
        }
    }

    private void putToMap(Map<String, Map<String, List<IntentFilter>>> map, Map<String, List<IntentFilter>> map2, PluginInfo pluginInfo) {
        map.put(pluginInfo.getPackageName(), map2);
        map.put(pluginInfo.getAlias(), map2);
    }

    private void parseComponent(String str, Map<String, List<IntentFilter>> map, List<a> list, Map<String, Set<String>> map2) {
        if (list != null) {
            for (a aVar : list) {
                doFillFilters(aVar, map);
                doFillActionPlugins(str, aVar, map2);
            }
        }
    }

    private void doFillFilters(a aVar, Map<String, List<IntentFilter>> map) {
        String str = aVar.a;
        List list = (List) map.get(str);
        if (list == null) {
            list = new ArrayList();
            map.put(str, list);
        }
        aVar = aVar.b;
        if (aVar != null) {
            list.addAll(aVar);
        }
    }

    private void doFillActionPlugins(String str, a aVar, Map<String, Set<String>> map) {
        if (map != null) {
            if (aVar.b != null) {
                for (IntentFilter actionsIterator : aVar.b) {
                    Iterator actionsIterator2 = actionsIterator.actionsIterator();
                    while (actionsIterator2.hasNext()) {
                        String str2 = (String) actionsIterator2.next();
                        Set set = (Set) map.get(str2);
                        if (set == null) {
                            set = new HashSet();
                            map.put(str2, set);
                        }
                        set.add(str);
                    }
                }
            }
        }
    }

    public final Set<String> getPluginsByActionWhenStartActivity(String str) {
        return (Set) this.mActivityActionPluginsMap.get(str);
    }

    public final Set<String> getPluginsByActionWhenStartService(String str) {
        return (Set) this.mServiceActionPluginsMap.get(str);
    }

    public final Map<String, List<IntentFilter>> getActivityFilterMap(String str) {
        return (Map) this.mPluginActivityInfoMap.get(str);
    }

    public final Map<String, List<IntentFilter>> getServiceFilterMap(String str) {
        return (Map) this.mPluginServiceInfoMap.get(str);
    }

    public final Map<String, List<IntentFilter>> getReceiverFilterMap(String str) {
        return (Map) this.mPluginReceiverInfoMap.get(str);
    }

    private a parseManifest(String str) {
        XMLReader xMLReader;
        Throwable th;
        Reader stringReader;
        Object aVar = new a();
        StringReader stringReader2 = null;
        try {
            xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            try {
                xMLReader.setContentHandler(aVar);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                if (xMLReader != null) {
                    try {
                        stringReader = new StringReader(str);
                        try {
                            xMLReader.parse(new InputSource(stringReader));
                            stringReader.close();
                        } catch (Throwable th3) {
                            str = th3;
                            stringReader2 = stringReader;
                            if (stringReader2 != null) {
                                stringReader2.close();
                            }
                            throw str;
                        }
                    } catch (Throwable th4) {
                        str = th4;
                        str.printStackTrace();
                        if (stringReader2 != null) {
                            stringReader2.close();
                        }
                        return aVar;
                    }
                }
                return aVar;
            }
        } catch (Throwable th5) {
            th = th5;
            xMLReader = null;
            th.printStackTrace();
            if (xMLReader != null) {
                stringReader = new StringReader(str);
                xMLReader.parse(new InputSource(stringReader));
                stringReader.close();
            }
            return aVar;
        }
        if (xMLReader != null) {
            stringReader = new StringReader(str);
            xMLReader.parse(new InputSource(stringReader));
            stringReader.close();
        }
        return aVar;
    }

    private void printFilters(Map<String, List<IntentFilter>> map, Map<String, List<IntentFilter>> map2, Map<String, List<IntentFilter>> map3) {
        if (!map.entrySet().isEmpty()) {
            c.a(TAG, "\n打印 Activity - IntentFilter");
        }
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            List list = (List) entry.getValue();
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("key:");
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("; val:");
            stringBuilder.append(intentFilterStr(list));
            c.a(str, stringBuilder.toString());
        }
        if (map2.entrySet().isEmpty() == null) {
            c.a(TAG, "\n打印 Service - IntentFilter");
        }
        map = map2.entrySet().iterator();
        while (map.hasNext() != null) {
            Entry entry2 = (Entry) map.next();
            List list2 = (List) entry2.getValue();
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("key:");
            stringBuilder2.append((String) entry2.getKey());
            stringBuilder2.append("; val:");
            stringBuilder2.append(intentFilterStr(list2));
            c.a(str2, stringBuilder2.toString());
        }
        if (map3.entrySet().isEmpty() == null) {
            c.a(TAG, "\n打印 Receiver - IntentFilter");
        }
        map = map3.entrySet().iterator();
        while (map.hasNext() != null) {
            entry2 = (Entry) map.next();
            List list3 = (List) entry2.getValue();
            String str3 = TAG;
            StringBuilder stringBuilder3 = new StringBuilder("key:");
            stringBuilder3.append((String) entry2.getKey());
            stringBuilder3.append("; val:");
            stringBuilder3.append(intentFilterStr(list3));
            c.a(str3, stringBuilder3.toString());
        }
    }

    private String intentFilterStr(List<IntentFilter> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (IntentFilter intentFilter : list) {
            stringBuilder.append("{");
            int countActions = intentFilter.countActions();
            if (countActions > 0) {
                stringBuilder.append("action:{");
            }
            while (countActions > 0) {
                stringBuilder.append(intentFilter.getAction(countActions - 1));
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                countActions--;
                if (countActions == 0) {
                    stringBuilder.append(h.d);
                }
            }
            countActions = intentFilter.countCategories();
            if (countActions > 0) {
                stringBuilder.append(", category:{");
            }
            while (countActions > 0) {
                stringBuilder.append(intentFilter.getCategory(countActions - 1));
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                countActions--;
                if (countActions == 0) {
                    stringBuilder.append(h.d);
                }
            }
            countActions = intentFilter.countDataSchemes();
            if (countActions > 0) {
                stringBuilder.append(", data-scheme:{");
            }
            while (countActions > 0) {
                stringBuilder.append(intentFilter.getDataScheme(countActions - 1));
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                countActions--;
                if (countActions == 0) {
                    stringBuilder.append(h.d);
                }
            }
            countActions = intentFilter.countDataPaths();
            if (countActions > 0) {
                stringBuilder.append(", data-path:{");
            }
            while (countActions > 0) {
                PatternMatcher dataPath = intentFilter.getDataPath(countActions - 1);
                stringBuilder.append(dataPath.getPath());
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder.append(dataPath.getType());
                countActions--;
                if (countActions == 0) {
                    stringBuilder.append(h.d);
                }
            }
            countActions = intentFilter.countDataTypes();
            if (countActions > 0) {
                stringBuilder.append(", data-type:{");
            }
            while (countActions > 0) {
                stringBuilder.append(intentFilter.getDataType(countActions - 1));
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                countActions--;
                if (countActions == 0) {
                    stringBuilder.append(h.d);
                }
            }
            stringBuilder.append("}, ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
