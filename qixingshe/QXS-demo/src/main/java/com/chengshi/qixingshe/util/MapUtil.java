package com.chengshi.qixingshe.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-05 10:47
 */
public class MapUtil {
    /**
     *
     * @Title: objectToMap
     * @Description: 将object转换为map，默认不保留空值
     * @param @param obj
     * @return Map<String,Object> 返回类型
     * @throws
     */
    public static Map objectToMap(Object obj) {

        Map<String, Object> map = new HashMap<String, Object>();
        map = objectToMap(obj, false);
        return map;
    }

    public static Map objectToMap(Object obj, boolean keepNullVal) {
        if (obj == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (keepNullVal == true) {
                    map.put(field.getName(), field.get(obj));
                } else {
                    if (field.get(obj) != null && !"".equals(field.get(obj).toString())) {
                        map.put(field.getName(), field.get(obj));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;

        Object obj = beanClass.newInstance();

        org.apache.commons.beanutils.BeanUtils.populate(obj, map);

        return obj;
    }

}
