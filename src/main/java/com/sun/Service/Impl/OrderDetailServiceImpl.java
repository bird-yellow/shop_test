package com.sun.Service.Impl;

import com.sun.Dao.OrderDetailDao;
import com.sun.Entity.OrderDetail;
import com.sun.Service.OrderDetailService;
import com.sun.base.BaseDao;
import com.sun.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public BaseDao<OrderDetail> getBaseDao() {
        return  orderDetailDao;
    }
}
