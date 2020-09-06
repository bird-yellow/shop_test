package com.sun.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

//定义商品订单
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrder implements Serializable {

        //订单号(主键)
        private Integer id;
//        商品id
        private Integer item_id;

//        购买者id
        private Integer user_id;
        private User user;

//        订单编码
        private String code;

//        购买时间
        private Date  addTime;

//        购买金额
        private String total;
        private Integer isDelete;

//        订单状态. 0等待发货 1已经发货 2已经收货  3已经评价
        private Integer status;

}
