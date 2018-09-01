package com.itheima.crm.service;

import com.itheima.crm.pojo.BaseDict;

import java.util.List;

/**
 * @version V1.0
 * @ClassName:${file_name}
 * @Description:${todo}(用一句话描述该文件做什么)
 * @author:cxg
 * @Date:${time}
 */
public interface BaseDictService {
     List<BaseDict> getBaseDictByCode(String code);
}
