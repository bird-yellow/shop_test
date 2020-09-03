package com.sun.base;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/*
* 描述: Controller 基类
* */
public class BaseController {
        protected  Logger logger = LoggerFactory.getLogger(this.getClass());
//        设置日期格式化形式
        protected  final static String DATE_FORMAT = "yyyy-MM-dd";

        /*
        * @param obj
        * @return 输出处理结果给前端json格式数据
        * */
        public String responseResult(Object obj)  {
                String jsonObj = null;
                if(obj != null ){
                                logger.info("后端返回对象:{}" ,obj);
                                jsonObj = JSONObject.toJSONString(obj);
                                logger.info("后端返回数据: " + jsonObj);
                        }
                logger.info("输出结果:{}" + jsonObj);
                return jsonObj;
        }

//        判断空 操作
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
