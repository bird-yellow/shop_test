package com.sun.Service.Impl;

import com.sun.Dao.ItemDao;
import com.sun.Entity.Item;
import com.sun.Service.ItemService;
import com.sun.base.BaseDao;
import com.sun.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl  extends BaseServiceImpl<Item> implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public BaseDao<Item> getBaseDao() {
        return itemDao;
    }
}
