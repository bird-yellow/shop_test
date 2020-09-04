package com.sun.Controller;

import com.sun.Entity.Item;
import com.sun.Entity.ItemCategory;
import com.sun.Service.ItemCategoryService;
import com.sun.Service.ItemService;
import com.sun.base.BaseController;
import com.sun.utils.Pager;
import com.sun.utils.SystemContext;
import com.sun.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {
        @Autowired
        private ItemService itemService;

        @Autowired
        private ItemCategoryService itemCategoryService;

        //查看所有的商品的二级分类
        @RequestMapping("/findBySql")
        public String findBySql(Item item, Model model){
                String sql = "select * from item where isDelete = 0";
                if(isEmpty(item.getName())){
                        sql += " and name like '%" + item.getName() +"%' ";
                }
                sql +=" order by id";
                Pager<Item> pagers = itemService.findBySqlReturnEntity(sql);
                model.addAttribute("pagers",pagers);
                model.addAttribute("obj",item);
                return "item/item";
        }

//        添加商品的入口
        @RequestMapping("/add")
//        商品在二级分类的基础之上，然后进行添加
        public String add(Model model){
                String sql = "select * from item_category where isDelete=0 and pid is not null order by id";
                List<ItemCategory> list = itemCategoryService.listBySqlReturnEntity(sql);
                model.addAttribute("types",list);
                return "item/add";
        }

        //每一个商品都需要存储对应的一级分类 和 二级分类
        @RequestMapping("/exAdd")
        public String exAdd(Item item,@RequestParam("file")CommonsMultipartFile[] files,HttpServletRequest request) throws IOException {
                        itemCommon(item,files,request);
                        item.setIsDelete(0);
                        item.setGmNum(0);
                        item.setScNum(0);
                        itemService.insert(item);
                        return "redirect:/item/findBySql.action";
        }

//        新增，更新的公共方法
        private void itemCommon(Item item, @RequestParam("file")CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
                if(files.length > 0){
                        for(int i = 0;i < files.length;i++){
                                String n = UUIDUtils.create();
                                String path = request.getServletContext().getRealPath("/upload/" + n + files[i].getOriginalFilename());
                                File newFile = new File(path);
                                files[i].transferTo(newFile);
                                if(i == 0){
//                                        然后获取相对路径
                                        item.setUrl1(request.getServletContext().getContextPath() + "/update/" + n + files[i].getOriginalFilename());
                                }
                                 if( i == 1){
                                        item.setUrl2(request.getServletContext().getContextPath() + "/update/" + n + files[i].getOriginalFilename());
                                }
                                 if( i == 2){
                                        item.setUrl3(request.getServletContext().getContextPath() + "/update/" + n + files[i].getOriginalFilename());
                                }
                                 if( i == 3){
                                        item.setUrl4(request.getServletContext().getContextPath() + "/update/" + n + files[i].getOriginalFilename());

                                }
                                 if( i ==4){
                                        item.setUrl4(request.getServletContext().getContextPath() + "/update/" + n + files[i].getOriginalFilename());
                                }
                        }
                }
                ItemCategory itemCategory = itemCategoryService.getById(item.getCategoryIdTwo());
                item.setCategoryIdOne(itemCategory.getPid());
        }
}
