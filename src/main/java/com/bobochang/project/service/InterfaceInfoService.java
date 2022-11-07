package com.bobochang.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bobochang.project.model.entity.InterfaceInfo;

/**
* @author bobochang
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2022-11-02 05:11:12
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean b);
}
