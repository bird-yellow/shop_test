package com.sun.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//定义二级分类
public class ItemCategory {
        private Integer id;
        private String name;
        private Integer pid;
        private Integer isDelete ;
}
