package com.sun.Service.Impl;

import com.sun.Dao.ItemOrderDao;
import com.sun.Entity.ItemOrder;
import com.sun.Service.ItemOrderService;
import com.sun.base.BaseDao;
import com.sun.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemOrderServiceImpl extends BaseServiceImpl<ItemOrder> implements ItemOrderService {
    @Autowired
    private ItemOrderDao itemOrderDao;

    @Override
    public BaseDao<ItemOrder> getBaseDao() {
        return itemOrderDao;
    }
}
