package com.portal.portal;

import com.mongodb.BasicDBObject;
import mongo.entity.MongoDBCursor;
import mongo.utils.MongoDBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class Test {
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        MongoDBCursor mongoDBCursor = new MongoDBCursor();
        mongoDBCursor.setCollectionName("test"); // 赋值集合名
        // 封装查询条件
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        Map<String, Object> customFieldMap = new HashMap<String, Object>();
        // 且条件集合
        Map<String, Object> andConditionMap = new HashMap<String, Object>();
//            andConditionMap.put("title", "title1");
//            andConditionMap.put("description", "123");
//            andConditionMap.put("likes", new BasicDBObject("$lte", 100));
        // 自定义返回映射集合 1-展示
        customFieldMap.put("likes", "1");
        customFieldMap.put("description", "1");
        // 条件集合
        fieldMap.put("likes", new BasicDBObject("$lte", 100));
//           fieldMap.put("$and", andConditionMap);
//			 fieldMap.put("by","m");
        mongoDBCursor.setFieldMap(fieldMap);
        mongoDBCursor.setCustomFieldMap(customFieldMap);
        // 赋值skip
//            mongoDBCursor.setSkip(1);
        // 赋值limit
//            mongoDBCursor.setLimit(1);
        // 封装Sort
        Map<String, Object> sortMap = new LinkedHashMap<String,
                Object>();
        sortMap.put("likes", -1);
        mongoDBCursor.setSort(sortMap);
        // 插入新记录
        // MongoDBUtil.add(mongoDBCursor);
        // 查询
        ArrayList<Map<String, Object>> result = MongoDBUtil.find(mongoDBCursor);
        System.out.println("result=" + result.toString());
        return result.toString();
    }
}
