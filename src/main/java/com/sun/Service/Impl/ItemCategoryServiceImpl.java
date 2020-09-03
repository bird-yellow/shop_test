package com.sun.Service.Impl;

import com.sun.Dao.ItemCategoryDao;
import com.sun.Entity.ItemCategory;
import com.sun.Service.ItemCategoryService;
import com.sun.base.BaseDao;
import com.sun.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemCategoryServiceImpl extends BaseServiceImpl<ItemCategory> implements ItemCategoryService {
    @Autowired
    private ItemCategoryDao itemCategoryDao;

    @Override
    public BaseDao<ItemCategory> getBaseDao() {
        return itemCategoryDao;
    }
}
