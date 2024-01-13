package com.dcb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DistrbutionUrl {
    private String path = "redirect:http://172.16.199.179";
    private static Boolean one = true;
    @RequestMapping("/")
    public String all(){
        return path;
    }
    @RequestMapping(value = "/switch",produces = "application/json;charset=utf-8")
    public String witch(Model model){
        System.out.println(path+one);
        String res = "路径修改成功";
        try {
            //当前是第一个，准备切换第二个
            if (one){
                path = "redirect:http://172.16.199.182";
            }else{
                path = "redirect:http://172.16.199.179";
            }
            one = !one;
        }catch (Exception e){
            res = "路径修改失败";
        }
        res += "，当前路径为："+path.replaceAll("redirect:","");
        System.out.println("修改后：" + path+one);
        model.addAttribute("res",res);
        return "res";
    }
}
