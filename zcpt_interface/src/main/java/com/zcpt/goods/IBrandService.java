package com.zcpt.goods;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zcpt.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface IBrandService {
    List<Brand> brandList();
    //根据条件查询 根据name 进行模糊查询  根据首字母进行完全匹配
    List<Brand> brandListByCondition(Map<String, Object> querMap);
    // 分页查询所有数据
    IPage<Brand> brandPage(Integer pagenum, Integer pagesize);
    // 根据条件分页查询 数据
    IPage<Brand> brandPageByCondition(Integer pagenum, Integer pagesize, Map<String, Object> queryMap);
    // 根据id查询
    Brand brandById(Integer id);
    //添加品牌信息
    Integer saveBrand(Brand brand);
    // 修改品牌信息
    Integer modifyBrand(Brand brand);
    //根据id删除
    Integer removeBrand(Integer id);
}
