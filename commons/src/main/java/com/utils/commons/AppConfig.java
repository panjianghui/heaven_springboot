package com.utils.commons;


import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class AppConfig {
    private static HashMap<String, Object> map;

    public AppConfig() {
    }

    public static synchronized void init() {
        if (map == null) {
            try {
                map = new HashMap();
                InputStream in = AppConfig.class.getResourceAsStream("/application.properties");
                Properties appConfig = new Properties();
                appConfig.load(in);
                Iterator it = appConfig.keySet().iterator();

                while (it.hasNext()) {
                    String key = String.valueOf(it.next()).trim();
                    String value = appConfig.getProperty(key).trim();
                    map.put(key, value);
                }

                if (map.containsKey("driverClassName")) {
                    Class.forName((String) map.get("driverClassName"));
                }
            } catch (Exception var5) {
            }

        }
    }

    public static void setMap(Map map1) {
        map = new HashMap();
        map.putAll(map1);
    }

    public static boolean isOracle() {
        String driverClassName = ((String) map.get("driverClassName")).toLowerCase();
        return driverClassName.indexOf("oracle") >= 0;
    }

    public static boolean hasPro(String key) {
        init();
        return key == null ? false : map.containsKey(key);
    }

    public static boolean getBooleanPro(String key) {
        String value = getStringPro(key);
        return "true".equals(value);
    }

    public static String getStringPro(String key) {
        return hasPro(key) ? (String) map.get(key) : null;
    }

    public static String getStringPro(String key, String defaultValue) {
        return hasPro(key) ? (String) map.get(key) : defaultValue;
    }

    public static Integer getIntPro(String key) {
        return hasPro(key) ? Integer.parseInt((String) map.get(key))  : null;
    }

    public static HashMap getAll() {
        init();
        return new HashMap(map);
    }

    public static File getFile(String path) {
        init();
        String fileRoot = (String) map.get("fileRoot");
        File file = new File(fileRoot + "/" + path);
        return file;
    }

    public static String getAppId() {
        init();
        String appId = (String) map.get("appId");
        return appId;
    }

    public static boolean release() {
        init();
        String version = ((String) map.get("versionMode")).toLowerCase();
        return "release".equals(version);
    }

    public static boolean localCache() {
        init();
        String localCache = (String) map.get("localCache");
        if (localCache != null) {
            localCache = localCache.toLowerCase();
        }

        return "true".equals(localCache);
    }
}

