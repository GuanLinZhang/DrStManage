package cn.drst.controller;

import cn.drst.bean.ClinicBean;
import cn.drst.service.ClinicService;
import cn.drst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final ClinicService clinicService;

    @Autowired
    public UserController(UserService userService, ClinicService clinicService) {
        this.userService = userService;
        this.clinicService = clinicService;
    }
}

