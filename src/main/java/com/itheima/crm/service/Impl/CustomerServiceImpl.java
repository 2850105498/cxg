package com.itheima.crm.service.Impl;


import com.itheima.crm.mapper.BaseDictMapper;
import com.itheima.crm.mapper.CustomerMapper;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @ClassName:${file_name}
 * @Description:${todo}(用一句话描述该文件做什么)
 * @author:cxg
 * @Date:${time}
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public CustomerMapper customerMapper;

    @Override
    public Page<Customer> getCustomerByQueryVo(QueryVo vo) {
        //总记录数

        //计算分页查询从哪条记录开始
        vo.setStart((vo.getPage() - 1) * vo.getRows());

        //查询总记录数
        Integer total = customerMapper.getCountByQueryVo(vo);

        //查询每页的数据列表
        List<Customer> list = customerMapper.getCustomerByQueryVo(vo);

        //包装分页数据
        Page<Customer> page = new Page<Customer>(total, vo.getPage(), vo.getRows(), list);

        return page;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.getCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerMapper.deleteCustomer(id);
    }
}
