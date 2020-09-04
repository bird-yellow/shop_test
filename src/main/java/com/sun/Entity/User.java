package com.sun.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//定义用户
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
        private Integer id;

        private String username;

        private String password;

        private String phone ;

        private String realname;

        private String sex;

        private String address;

        private String email;
}
