package com.zcpt.projects;

import com.zcpt.pojo.projects.Collection;

import java.util.List;

public interface ICollectionService {

    List<Collection> findCollectionByUserId(Integer id);

    Integer deleteCollection(Integer id);

    Integer insertCollection(Collection collection);
}
