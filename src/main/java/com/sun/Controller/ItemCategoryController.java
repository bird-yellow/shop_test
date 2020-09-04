package com.sun.Controller;

import com.sun.Entity.ItemCategory;
import com.sun.Service.ItemCategoryService;
import com.sun.base.BaseController;
import com.sun.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/itemCategory")

public class ItemCategoryController extends BaseController {
        @Autowired
        private ItemCategoryService itemCategoryService;

        @RequestMapping("/findBySql")
        public String findBySql(Model model,ItemCategory itemCategory){
               String sql = "select * from item_category where isDelete = 0 and pid is null order by id";
               Pager<ItemCategory> pagers = itemCategoryService.findBySqlReturnEntity(sql);
               model.addAttribute("pagers",pagers);
               model.addAttribute("obj",itemCategory);
               return "itemCategory/itemCategory";
        }

        @RequestMapping("/update")
        public String update(Integer id,Model model){
                ItemCategory itemCategory = itemCategoryService.load(id);
                model.addAttribute("obj",itemCategory);
                return "itemCategory/update";
        }

        @RequestMapping("/exUpdate")
//        商品类别的更新，只能够更新名字
        public String exUpdate(ItemCategory itemCategory){
                itemCategoryService.updateById(itemCategory);
                return "redirect:/itemCategory/findBySql.action";
        }

        @RequestMapping("/add")
        public String add(){
                return "itemCategory/add";
        }

        @RequestMapping("/exAdd")
        public String exAdd(ItemCategory itemCategory){
                itemCategory.setIsDelete(0);
                itemCategory.setPid(null);
                itemCategoryService.insert(itemCategory);
                return "redirect:/itemCategory/findBySql.action";
        }

        @RequestMapping("/delete")
        public String delete(Integer id){
                ItemCategory itemCategory = itemCategoryService.load(id);
                //修改 item_category 中isDelete = 1 ,然后莫认为删除
                itemCategory.setIsDelete(1);
                itemCategoryService.updateById(itemCategory);
                // 同时将所有哦 pid = id 的也都删除
                String sql = "update item_category set isDelete = 1 where pid=" + id;
                itemCategoryService.updateBySql(sql);
                return "redirect:/itemCategory/findBySql.action";
        }

//        然后查看二级分类
        @RequestMapping("/findBySql2")
        public String findBySql2(ItemCategory itemCategory,Model model){
                String sql = "select * from item_category where isDelete = 0 and pid=" + itemCategory.getPid() + " order by id";
                Pager<ItemCategory> pagers = itemCategoryService.findBySqlReturnEntity(sql);
                model.addAttribute("pagers",pagers);
                model.addAttribute("obj",itemCategory);
                return "itemCategory/itemCategory2";
        }

        @RequestMapping("/add2")
        public String add2(int pid,Model model){
                model.addAttribute("pid",pid);
                return "itemCategory/add2";
        }

        @RequestMapping("/exAdd2")
        public String exAdd2(ItemCategory itemCategory){
                itemCategory.setIsDelete(0);
                itemCategoryService.insert(itemCategory);
                return "redirect:/itemCategory/findBySql2.action?pid=" + itemCategory.getPid();
        }

        @RequestMapping("/update2")
        public String update2(Integer id, Model model){
                ItemCategory itemCategory = itemCategoryService.load(id);
                model.addAttribute("obj",itemCategory);
                return "itemCategory/update2";
        }

        @RequestMapping("/exUpdate2")
        public String exUpdate2(ItemCategory itemCategory){
                itemCategoryService.updateById(itemCategory);
                return "redirect:/itemCategory/findBySql2.action?pid=" + itemCategory.getPid();
        }

        @RequestMapping("/delete2")
        public String delete2(Integer id,Integer pid){
            ItemCategory itemCategory = itemCategoryService.load(id);
            itemCategory.setIsDelete(1);
            itemCategoryService.updateById(itemCategory);
            return "redirect:/itemCategory/findBySql2.action?pid=" + pid;
        }
}
