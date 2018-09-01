package com.itheima.crm.controller;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.itheima.crm.pojo.BaseDict;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version V1.0
 * @ClassName:CustomerController
 * @Description:客户请求处理
 * @author:cxg
 * @Date:${time}
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    public BaseDictService baseDictService;

    @Autowired
    public CustomerService customerService;
    @Value("${customer_from_type}")
    private String customer_from_type;

    @Value("${customer_industry_type}")
    private String customer_industry_type;

    @Value("${customer_level_type}")
    private String customer_level_type;


    @RequestMapping("list")
    public String list(Model model,QueryVo vo) {
        //查询来源
        List<BaseDict> fromType=baseDictService.getBaseDictByCode(customer_from_type);
        //所属行业
        List<BaseDict> industryType=baseDictService.getBaseDictByCode(customer_industry_type);
        //客户级别
        List<BaseDict> levelType=baseDictService.getBaseDictByCode(customer_level_type);
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);

        //根据查询条件分页查询用户列表
        Page<Customer> page= customerService.getCustomerByQueryVo(vo);
        //设置分页数据返回
        model.addAttribute("page",page);
        //返回查询条件
        model.addAttribute("vo", vo);
        return "customer";
    }
    @RequestMapping("edit")
    @ResponseBody
    public Customer edit(Integer id){
        Customer customer= customerService.getCustomerById(id);
        return  customer;
    }
    @RequestMapping("update")
    @ResponseBody
    public String update(Customer customer){
        String msg = "1";
        try {
            customerService.updateCustomer(customer);
            msg = "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
    @RequestMapping("delete")
    @ResponseBody
    public String deleteCustomer(Integer id) {
        customerService.deleteCustomer(id);
        return "ok";
    }

}
