package com.sun.base;

import com.github.pagehelper.PageHelper;
import com.sun.utils.Pager;
import com.sun.utils.SystemContext;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BaseServiceImpl<T> implements  BaseService<T> {

    private BaseDao<T> baseDao;
    public abstract BaseDao<T> getBaseDao();

    @Override
    public int insert(T entity) {
        return  this.getBaseDao().insert(entity);
    }

    @Override
    public void deleteById(Serializable id) {
            this.getBaseDao().deleteById(id);
    }

    @Override
    public void deleteByEntity(T entity) {
            this.getBaseDao().deleteByEntity(entity);
    }

    @Override
    public void deleteByMap(Map<String, Object> params) {
            this.deleteByMap(params);
    }

    @Override
    public void update(T entity) {
            this.getBaseDao().update(entity);
    }

    @Override
    public void updateById(T entity) {
            this.getBaseDao().updateById(entity);
    }

    @Override
    public List<T> listByMap(Map<String, Object> params) {
        return  this.getBaseDao().listByMap(params);
    }

    @Override
    public List<T> listAll() {
        return  this.getBaseDao().listAll();
    }

    @Override
    public List<T> listAllByEntity(T entity) {
        return  this.getBaseDao().listAllByEntity(entity);
    }

    @Override
    public T load(Serializable id) {
        return  this.getBaseDao().load(id);
    }

    @Override
    public T getById(Serializable id) {
        return  this.getBaseDao().getById(id);
    }

    @Override
    public T getByMap(Map<String, Object> params) {
        return  this.getBaseDao().getByMap(params);
    }

    @Override
    public T getByEntity(T entity) {
        return  this.getBaseDao().getByEntity(entity);
    }

//    根据map 查询，返回分页
    @Override
    public Pager<T> findByMap(Map<String, Object> params) {
        Integer pageSize = SystemContext.getPageSize();
        Integer pageOffset = SystemContext.getPageOffset();
        if(pageOffset == null || pageOffset < 0)
                pageOffset = 0;
        if(pageSize == null || pageSize < 0)
                pageSize = 15;
        String order = SystemContext.getOrder();
        String sort = SystemContext.getSort();
        Integer pageNum = null;
        if(pageOffset == 0)
                pageNum = 1;
        else
            pageNum = pageOffset/pageSize +1;

        PageHelper.startPage(pageNum,pageSize);
        Pager<T> pages = new Pager<T>(this.getBaseDao().findByMap(params));
        return pages;
    }

    @Override
    public Pager<T> findByEntity(T entity) {
        Integer pageSize = SystemContext.getPageSize();
        Integer pageOffset = SystemContext.getPageOffset();
        if(pageOffset == null || pageOffset < 0)
            pageOffset = 0;
        if(pageSize == null || pageSize < 0)
            pageSize = 15;
        String order = SystemContext.getOrder();
        String sort = SystemContext.getSort();
        Integer pageNum = null;
        if(pageOffset == 0)
            pageNum = 1;
        else
            pageNum = pageOffset/pageSize +1;

        PageHelper.startPage(pageNum,pageSize);
        Pager<T> pages = new Pager<T>(this.getBaseDao().findByEntity(entity));
        return pages;
    }

    @Override
    public void insertBatch(List<T> list) {
            this.getBaseDao().insertBatch(list);
    }

    @Override
    public void updateBatch(List<T> list) {
            this.getBaseDao().updateBatch(list);
    }

//========================================================
//    执行sql语句

    @Override
    public Map<String, Object> getBySqlReturnMap(String sql) {
        return  this.getBaseDao().getBySqlReturnMap(sql);
    }

    @Override
    public T getBySqlReturnEntity(String sql) {
        return this.getBaseDao().getBySqlReturnEntity(sql);
    }

    @Override
    public List<T> listBySqlReturnEntity(String sql) {
        return  this.getBaseDao().listBySqlReturnEntity(sql);
    }

    @Override
    public Pager<T> findBySqlReturnEntity(String sql) {
        Integer pageSize = SystemContext.getPageSize();
        Integer pageOffset = SystemContext.getPageOffset();
        if(pageOffset == null || pageOffset < 0)
            pageOffset = 0;
        if(pageSize == null || pageSize < 0)
            pageSize = 15;
        String order = SystemContext.getOrder();
        String sort = SystemContext.getSort();
        Integer pageNum = null;
        if(pageOffset == 0)
            pageNum = 1;
        else
            pageNum = pageOffset/pageSize +1;

        PageHelper.startPage(pageNum,pageSize);
        Pager<T> pages = new Pager<T>(this.getBaseDao().findBySqlReturnEntity(sql));
        return pages;
    }

    @Override
    public void updateBySql(String sql) {
        this.getBaseDao().updateBySql(sql);
    }

    @Override
    public void deleteBySql(String sql) {
            this.deleteBySql(sql);
    }

    public boolean isEmpty(String str){
        return (str == null ) || (str.trim().length() <= 0 );
    }
    public boolean isEmpty(Character cha){
        return  (cha == null ) || (cha.equals(' '));
    }
    public boolean isEmpty(Object object){
        return object == null ;
    }

    public boolean isEmpty(Object[] objects){
        return  (objects == null ) || objects.length <= 0;
    }

    public boolean isEmpty(Collection<?> obj){
        return (null == obj) || obj.isEmpty();
    }

    public boolean isEmpty(Set<?> set){
        return set == null || set.isEmpty();
    }
    public boolean isEmpty(Serializable obj){
        return obj== null;
    }
}
