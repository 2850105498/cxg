package com.itheima.crm.mapper;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

import java.util.List;

/**
 * @version V1.0
 * @ClassName:${file_name}
 * @Description:通过id查询客户类型
 * @author:cxg
 * @Date:${time}
 */
public interface CustomerMapper {
   /**
    * 查询查询条件，分页查询用户列表
    *
    * @param vo
    * @return
    */
   List<Customer> getCustomerByQueryVo(QueryVo vo);

   /**
    * 跟据查询条件查询总记录数
    *
    * @param vo
    * @return
    */
   Integer getCountByQueryVo(QueryVo vo);

   /***
    *
    * 通过id查询客户信息
    * */
   Customer getCustomerById(Integer id);

   /**
    *
    * 更新用户
    *
    */
   void updateCustomer(Customer customer);
   /**
    * 删除用户
    *
    * **/
   void deleteCustomer(Integer id);

}
