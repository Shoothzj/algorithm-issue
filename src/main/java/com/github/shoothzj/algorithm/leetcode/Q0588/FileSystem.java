package com.github.shoothzj.algorithm.leetcode.Q0588;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.function.BiConsumer;

class FileSystem {

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.test();
    }

    @Test
    public void test() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.ls("/");
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        List<String> ls = fileSystem.ls("/");
        fileSystem.readContentFromFile("/a/b/c/d");
//        fileSystem.addContentToFile("/a/c", "fk");
//        List<String> ls = fileSystem.ls("/a/c");
    }

    private HashMap<String, TreeMap<String, String>> map = new HashMap<>();

    private HashMap<String, String> contentMap = new HashMap<>();

    public FileSystem() {

    }

    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        if (contentMap.containsKey(path)) {
            String substring = path.substring(path.lastIndexOf("/") + 1);
            result.add(substring);
            return result;
        }
        if (path.charAt(path.length() - 1) != '/') {
            path = path + "/";
        }
        TreeMap<String, String> treeMap = map.get(path);
        if (treeMap == null) {
            return result;
        }
        treeMap.forEach((s, s2) -> result.add(s));
        return result;
    }

    public void mkdir(String path) {
        process(path);
    }

    public void addContentToFile(String filePath, String content) {
        process(filePath);
        String s = contentMap.get(filePath);
        if (s == null) {
            contentMap.put(filePath, content);
        } else {
            contentMap.put(filePath, s + content);
        }
    }

    private void process(String path) {
        String[] split = path.split("/");
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            String str = split[i];
            prefix.append("/");
            map.putIfAbsent(prefix.toString(), new TreeMap<>());
            TreeMap<String, String> treeMap = map.get(prefix.toString());
            treeMap.put(split[i + 1], split[i + 1]);
            prefix.append(split[i + 1]);
        }
    }

    public String readContentFromFile(String filePath) {
        return contentMap.get(filePath);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */