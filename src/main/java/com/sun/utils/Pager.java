package com.sun.utils;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//分页
@Data
@NoArgsConstructor
public class Pager<T> {
//        分页的大小
        private Integer size;
//        起始页
        private Integer offset ;

//        总记录数
        private long total;
//        分页的数据
        private List<T> datas;

        public Pager(List<T> datas){
                if(datas instanceof Page){
                        Page<T> page = (Page<T>)datas;
                        setOffset(page.getPageNum());
                        setSize(page.getPageSize());
                        setTotal(page.getTotal());
                        setDatas(datas);
                }
        }
}
