package com.xunlei.downloadprovider.publiser.common.a;

import java.util.HashMap;
import java.util.Map;

/* compiled from: LocationUtil */
public final class a {
    private static Map<String, String> a;
    private static Map<String, String> b;

    public static String a(String str) {
        if (a == null) {
            Map hashMap = new HashMap();
            a = hashMap;
            hashMap.put("恩施土家族苗族自治州", "恩施");
            a.put("神农架林区", "神农架");
            a.put("凉山彝族自治州", "凉山");
            a.put("甘孜藏族自治州", "甘孜");
            a.put("阿坝藏族羌族自治州", "阿坝");
            a.put("林芝地区", "林芝");
            a.put("昌都地区", "昌都");
            a.put("那曲地区", "那曲");
            a.put("日喀则地区", "日喀则");
            a.put("阿里地区", "阿里");
            a.put("山南地区", "山南");
            a.put("黄南藏族自治州", "黄南");
            a.put("海北藏族自治州", "海北");
            a.put("果洛藏族自治州", "果洛");
            a.put("海西蒙古族藏族自治州", "海西");
            a.put("玉树藏族自治州", "玉树");
            a.put("海南藏族自治州", "海南州");
            a.put("海东地区", "海东");
            a.put("甘南藏族自治州", "甘南");
            a.put("临夏回族自治州", "临夏");
            a.put("锡林郭勒盟", "锡林郭勒");
            a.put("阿拉善盟", "阿拉善");
            a.put("兴安盟", "兴安");
            a.put("湘西土家族苗族自治州", "湘西");
            a.put("澳门特别行政区", "澳门");
            a.put("西双版纳傣族自治州", "西双版纳");
            a.put("迪庆藏族自治州", "迪庆");
            a.put("文山壮族苗族自治州", "文山");
            a.put("楚雄彝族自治州", "楚雄");
            a.put("红河哈尼族彝族自治州", "红河");
            a.put("怒江傈僳族自治州", "怒江");
            a.put("德宏傣族景颇族自治州", "德宏");
            a.put("大理白族自治州", "大理");
            a.put("大兴安岭地区", "大兴安岭");
            a.put("巴音郭楞蒙古自治州", "巴音郭楞");
            a.put("伊犁哈萨克自治州", "伊犁哈萨克");
            a.put("和田地区", "和田");
            a.put("博尔塔拉蒙古自治州", "博尔塔拉");
            a.put("克孜勒苏柯尔克孜自治州", "克孜勒苏柯尔克孜");
            a.put("阿克苏地区", "阿克苏");
            a.put("哈密地区", "哈密");
            a.put("阿勒泰地区", "阿勒泰");
            a.put("喀什地区", "喀什");
            a.put("塔城地区", "塔城");
            a.put("延边朝鲜族自治州", "延边");
            a.put("陵水黎族自治县", "陵水");
            a.put("琼中黎族苗族自治县", "琼中");
            a.put("乐东黎族自治县", "乐东");
            a.put("昌江黎族自治县", "昌江");
            a.put("保亭黎族苗族自治县", "保亭");
            a.put("石柱土家族自治县", "石柱");
            a.put("秀山土家族苗族自治县", "秀山");
            a.put("酉阳土家族苗族自治县", "酉阳");
            a.put("彭水苗族土家族自治县", "彭水");
            a.put("白沙黎族自治县", "白沙");
            a.put("香港特别行政区", "香港");
            a.put("澳门特别行政区", "澳门");
            a.put("黔西南布依族苗族自治州", "黔西南");
            a.put("黔南布依族苗族自治州", "黔南");
            a.put("黔东南苗族侗族自治州", "黔东南");
            a.put("台湾省", "台湾");
        }
        String str2 = (String) a.get(str);
        return str2 != null ? str2 : str;
    }

    public static String b(String str) {
        if (b == null) {
            Map hashMap = new HashMap();
            b = hashMap;
            hashMap.put("内蒙古自治区", "内蒙古");
            b.put("新疆维吾尔自治区", "新疆");
            b.put("广西壮族自治区", "广西");
            b.put("西藏自治区", "西藏");
            b.put("香港特别行政区", "香港");
            b.put("澳门特别行政区", "澳门");
        }
        String str2 = (String) b.get(str);
        if (str2 != null) {
            return str2;
        }
        return str.replace("省", "");
    }

    public static boolean c(String str) {
        if (str != null) {
            if (str.length() != 0) {
                String[] strArr = new String[]{"北京", "重庆", "天津", "上海", "澳门", "香港"};
                for (int i = 0; i < 6; i++) {
                    if (str.contains(strArr[i])) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
