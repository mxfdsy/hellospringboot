package com.coding.hellospringboot.contoller;

import com.coding.hellospringboot.domain.User;
import com.coding.hellospringboot.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 平凡的世界 on 2018/4/26.
 */
@RestController
public class UserController {
    //构造器的方式注入（spring自动传入参数）
    private  final UserRespository userRespository;
    @Autowired
    public UserController(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam  String name){
        User user = new User();
        user.setName(name);
        if (userRespository.save(user)) {
            System.out.printf("用户对象: %s 保存成功！\n", user);
        }
        return user;
    };
}
