package com.github.shoothzj.algorithm.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class T1 {

    public static void main(String[] args) {
        String src = "a:3,b:5,c:2";
        System.out.println(process(src));
    }

    private static String process(String src) {
        String[] split = src.split("@");
        if (split.length == 1) {
            if (src.endsWith("@")) {
                return src.substring(0, src.length() - 1);
            }
            return src;
        }
        String[] split2 = split[1].split(",");
        Map<String, Integer> map = new HashMap<>();
        for (String s : split2) {
            String[] splitUnit = s.split(":");
            map.put(splitUnit[0], Integer.valueOf(splitUnit[1]));
        }
        String[] strings = split[0].split(",");
        List<String> resultList = new ArrayList<>();
        for (String string : strings) {
            String[] splitUnit = string.split(":");
            int numer = Integer.valueOf(splitUnit[1]);
            if (map.get(splitUnit[0]) != null) {
                numer -= map.get(splitUnit[0]);
                if (numer != 0) {
                    resultList.add(splitUnit[0] + ":" + numer);
                }
            } else {
                resultList.add(splitUnit[0] + ":" + numer);
            }
        }

        return resultList.stream().collect(Collectors.joining(","));
    }

}
