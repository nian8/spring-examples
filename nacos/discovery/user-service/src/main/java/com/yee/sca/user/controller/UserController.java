package com.yee.sca.user.controller;

import com.yee.sca.user.dto.UserAddDTO;
import com.yee.sca.user.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/get")
    public UserDTO get(@RequestParam("id") Integer id) {
        logger.info(id.toString());
        return new UserDTO().setId(id)
                .setName("name:" + id)
                // 1 - 男；2 - 女
                .setGender(id % 2 + 1);
    }

    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        return (int) (System.currentTimeMillis() / 1000);
    }

}
