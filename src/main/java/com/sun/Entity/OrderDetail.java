package com.sun.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//订单详情
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {
        private  Integer id;

        private Integer item_id;
//        订单id 查找订单
        private Integer order_id;
        private Item item;

        private Integer status;

        private Integer num;

        private String total;
}
