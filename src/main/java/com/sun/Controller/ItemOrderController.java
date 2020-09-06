package com.sun.Controller;

import com.sun.Entity.ItemOrder;
import com.sun.Service.ItemOrderService;
import com.sun.base.BaseController;
import com.sun.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/itemOrder")
public class ItemOrderController extends BaseController {
        @Autowired
        private ItemOrderService itemOrderService;

        @RequestMapping("/findBySql")
        public  String findBySql(ItemOrder itemOrder, Model model){
//                根据订单号进行查询
                    String sql = "select * from item_order  where 1=1 ";
                    if(!isEmpty(itemOrder.getCode())){
                            sql += " and code like '%" + itemOrder.getCode() + "%' ";
                    }
                    sql += "order by id desc ";
                    Pager<ItemOrder> pagers = itemOrderService.findBySqlReturnEntity(sql);
                    model.addAttribute("obj",itemOrder);
                    model.addAttribute("pagers",pagers);
                    return "itemOrder/itemOrder";
        }
}
