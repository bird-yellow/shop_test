package com.sun.utils;

import sun.util.resources.cldr.om.CalendarData_om_ET;

//定义系统上下文
public class SystemContext {
//    只有当前线程 可以访问内部的数据

//            分页大小
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

//    分页的起始页
    private static ThreadLocal<Integer>  pageOffset = new ThreadLocal<Integer>();

//    列表的排序字段
    private static ThreadLocal<String> sort = new ThreadLocal<String>();

//    列表的排序方式
    private     static ThreadLocal<String> order = new ThreadLocal<String>();
    private     static ThreadLocal<String> realPath = new ThreadLocal<String>();

    // ThreadLocal<T> get(),set() 方法.
    public static String getRealPath(){
            return realPath.get();
    }

    public static void  setRealPath(String _realPath){
        SystemContext.realPath.set(_realPath);
    }


    public static Integer  getPageSize(){
        return pageSize.get();
    }
    public static void  setPageSize(Integer _pageSize){
        SystemContext.pageSize.set(_pageSize);
    }

    public static Integer getPageOffset(){
        return pageOffset.get();
    }
    public static void  setPageOffset(Integer _pageOffset){
        pageOffset.set(_pageOffset);
    }


    public static String getSort(){
        return sort.get();
    }
    public static  void setSort(String _sort){
        sort.set(_sort);
    }


    public static String getOrder(){
            return order.get();
    }
    public static void setOrder(String _order){
        order.set(_order);
    }

    public static void removePageSize() {
            pageSize.remove();
    }

    public static void removePageOffset(){
            pageOffset.remove();
    }
    public static void removeOrder(){
            order.remove();
    }
    public static void removeSort(){
        sort.remove();
    }
    public static void removeRealPath(){
        realPath.remove();
    }
}
