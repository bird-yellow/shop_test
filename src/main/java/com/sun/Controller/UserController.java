package com.sun.Controller;

import com.sun.Dao.UserDao;
import com.sun.Entity.User;
import com.sun.Service.UserService;
import com.sun.base.BaseController;
import com.sun.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController  extends BaseController {
        @Autowired
        private UserService userService;

        @RequestMapping("/findBySql")
        public String findBySql(Model model, User user){
                String sql = "select * from user where 1=1 " ;
                if(!isEmpty(user.getUsername())){
                        sql += " and username like '%" + user.getUsername() + "%' ";
                }
                sql += "order by id";
                Pager<User> pagers = userService.findBySqlReturnEntity(sql);
                model.addAttribute("pagers",pagers);
                model.addAttribute("obj",user);
                return "user/user";
        }
}
