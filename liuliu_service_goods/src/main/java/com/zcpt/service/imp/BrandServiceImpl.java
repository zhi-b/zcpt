package com.zcpt.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcpt.mapper.IBrandMapper;
import com.zcpt.goods.IBrandService;
import com.zcpt.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private IBrandMapper brandMapper;
    @Override
    public List<Brand> brandList() {
        return brandMapper.selectList(null);
    }

    @Override
    public List<Brand> brandListByCondition(Map<String, Object> queryMap) {
        return brandMapper.selectList(queryWrapper(queryMap));
    }

    @Override
    public IPage<Brand> brandPage(Integer pagenum, Integer pagesize) {
        IPage<Brand> page = new Page<>(pagenum , pagesize , true);
        IPage<Brand> brandIPage = brandMapper.selectPage(page, null);
        return brandIPage;
    }

    @Override
    public IPage<Brand> brandPageByCondition(Integer pagenum, Integer pagesize, Map<String, Object> querMap) {
        IPage<Brand> page = new Page<>(pagenum , pagesize , true);
        IPage<Brand> brandIPage = brandMapper.selectPage(page, queryWrapper(querMap));
        return brandIPage;
    }

    @Override
    public Brand brandById(Integer id) {
        return brandMapper.selectById(id);
    }

    @Override
    public Integer saveBrand(Brand brand) {

        return brandMapper.insert(brand);
    }

    @Override
    public Integer modifyBrand(Brand brand) {

        return brandMapper.updateById(brand);
    }

    @Override
    public Integer removeBrand(Integer id) {

        return brandMapper.deleteById(id);
    }
    private QueryWrapper<Brand> queryWrapper(Map<String,Object> queryMap){
        // 查询条件
        QueryWrapper<Brand> queryWrapper = null;
        if(queryMap !=null){
            queryWrapper = new QueryWrapper<>();
            if(!StringUtils.isEmpty(queryMap.get("name"))){
                queryWrapper.like("name",queryMap.get("name"));
            }
            if(!StringUtils.isEmpty(queryMap.get("letter"))){
                queryWrapper.eq("letter",queryMap.get("letter"));
            }
        }
        return  queryWrapper;
    }

}

