package com.zcpt.projects;

import java.util.Map;

/**
 * 按类别名查询类别id
 */
public interface ICategoryService {
    Integer findByName(Map<String,Object> queryMap);
}
