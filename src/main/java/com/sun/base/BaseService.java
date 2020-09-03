package com.sun.base;

import com.sun.utils.Pager;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    int insert(T entity);

    //        根据主键删除一个实体
    void deleteById(Serializable id);

    //        根据实体删除一个实体
    void deleteByEntity(T entity);

    //        通过map 删除一个实体
    void deleteByMap(Map<String,Object> params);

    //        更新一个实体
    void    update(T entity);

    //        通过id进行更新
    void    updateById(T entity);

    //        根据参数查询
    public List<T> listByMap(Map<String,Object> params);

    //        查询所有的实体
    List<T>     listAll();

    //        以实体属性为条件，查询实体
    List<T>     listAllByEntity(T entity);

    //        根据主键获取一个实体
    T               load(Serializable id);

    T           getById(Serializable id);

    //        根据map查询，不分页
    T           getByMap(Map<String,Object> params);

    //            通过对象查询，不分页
    T           getByEntity(T entity);

    //        通过Map查询，分页
    Pager<T>  findByMap(Map<String,Object> params);

    //            通过对象查询，分页
    Pager<T> findByEntity(T entity);

    //        批量新增
    void  insertBatch(List<T> list);

    //        批量更新
    void  updateBatch(List<T> list);

    //        ==================================================================
//        封装纯sql语法
//        查询一个对象，返回map
    public Map<String,Object>  getBySqlReturnMap(@Param("sql") String sql);

    //        查询一个对象，返回实体
    T                   getBySqlReturnEntity(@Param("sql") String sql);

    //        查询返回一个列表
    List<T>             listBySqlReturnEntity(@Param("sql")String sql);

    //        查询分页
    Pager<T>             findBySqlReturnEntity(@Param("sql")String sql);

    //        通过sql修改
    void            updateBySql(@Param("sql")String sql);

    //        通过sql删除
    void            deleteBySql(@Param("sql") String sql);
}
