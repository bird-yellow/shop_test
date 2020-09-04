package com.sun.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//定义商品
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
//        主键
        private Integer id;

//        商品名称
        private String name;
//        商品价格
        private String price;
//        折扣
        private Integer zk;
//        收藏数
        private Integer scNum;
//        购买数
        private Integer gmNum;
//        主图
        private String url1;
//        副图1
        private String url2;
        private String url3;
        private String url4;
        private String url5;

//        描述
        private String ms;
//        参数1
        private String pam1;
        private String pam2;
        private String pam3;

//        值1
        private String val1;
        private String val2;
        private String val3;

        private Integer type;

        //        类别一级

        private Integer categoryIdOne;
        private ItemCategory yiji;

//        类别二级
        private Integer categoryIdTwo;
        private ItemCategory erji;

//        产品是否有效。isDelete= 0无效。isDelete=1有效
        private Integer isDelete;



}
