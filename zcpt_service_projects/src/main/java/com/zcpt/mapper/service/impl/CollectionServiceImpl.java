package com.zcpt.mapper.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcpt.mapper.CollectionMapper;
import com.zcpt.pojo.projects.Collection;
import com.zcpt.projects.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CollectionServiceImpl implements ICollectionService {
    @Autowired
    private CollectionMapper collectionMapper;
    @Override
    public List<Collection> findCollectionByUserId(Integer id) {
        return collectionMapper.selectList(new QueryWrapper<Collection>().eq("user_id" , id));
    }

    @Override
    public Integer deleteCollection(Integer id) {
        return collectionMapper.deleteById(id);
    }

    @Override
    public Integer insertCollection(Collection collection) {
        return collectionMapper.insert(collection);
    }
}
