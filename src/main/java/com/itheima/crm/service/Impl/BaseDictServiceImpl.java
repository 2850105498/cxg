package com.itheima.crm.service.Impl;


import com.itheima.crm.mapper.BaseDictMapper;
import com.itheima.crm.pojo.BaseDict;

import com.itheima.crm.service.BaseDictService;
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
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    public BaseDictMapper baseDictMapper;
    @Override
    public List<BaseDict> getBaseDictByCode(String code) {
       List<BaseDict>  list= baseDictMapper.getBaseDictByCode(code);
        return list;
    }
}
