package com.itheima.crm.mapper;

import com.itheima.crm.pojo.BaseDict;

import java.util.List;

/**
 * @version V1.0
 * @ClassName:${file_name}
 * @Description:通过id查询客户类型
 * @author:cxg
 * @Date:${time}
 */
public interface BaseDictMapper {
   List<BaseDict> getBaseDictByCode(String code);
}
