package com.springboot.demo.controller;

import com.springboot.demo.base.controller.BaseController;
import com.springboot.demo.base.utils.RedisTemplate;
import com.springboot.demo.base.utils.RedisUtil;
import com.springboot.demo.base.utils.StateParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ft
 */
@Controller
@RequestMapping("/study")
public class StudyController extends BaseController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/testRedis")
    @ResponseBody
    public ModelMap testRedis() {
        redisTemplate.opsForValue().set("name", "张晓双");
        System.out.println(redisTemplate.opsForValue().get("name"));
        return getModelMap(StateParameter.SUCCESS, null, "操作成功");
    }
}
