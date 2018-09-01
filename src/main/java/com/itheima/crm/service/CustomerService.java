package com.itheima.crm.service;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.utils.Page;

import java.util.List;

/**
 * @version V1.0
 * @ClassName:${file_name}
 * @Description:${todo}(用一句话描述该文件做什么)
 * @author:cxg
 * @Date:${time}
 */
public interface CustomerService {
     /**
      * 根据QueryVo分页查询客户信息
      * **/
     Page<Customer> getCustomerByQueryVo(QueryVo vo);
     /**
      * 根据id查询用户信息
      * **/
     Customer getCustomerById(Integer id);

     /**
      * 更新用户
      * */
     void  updateCustomer(Customer customer);

     /**
      *
      * 删除用户
      * */
     void deleteCustomer(Integer id);
}
