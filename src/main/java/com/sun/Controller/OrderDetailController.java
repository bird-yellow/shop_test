package com.sun.Controller;

import com.sun.Entity.OrderDetail;
import com.sun.Service.OrderDetailService;
import com.sun.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {
        @Autowired
        private OrderDetailService orderDetailService;

        @RequestMapping("/ulist")
        public String ulist(OrderDetail orderDetail, Model model){
            //根据订单号 进行查询
            String sql = "select * from order_detail where order_id=" + orderDetail.getOrder_id();
            Pager<OrderDetail> pagers = orderDetailService.findBySqlReturnEntity(sql);
            model.addAttribute("pagers",pagers);
            model.addAttribute("obj",orderDetail);
            return "orderDetail/ulist";
        }
}
