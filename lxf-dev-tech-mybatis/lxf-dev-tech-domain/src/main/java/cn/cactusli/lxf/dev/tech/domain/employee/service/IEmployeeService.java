package cn.cactusli.lxf.dev.tech.domain.employee.service;

import cn.cactusli.lxf.dev.tech.domain.employee.model.entity.EmployeeInfoEntity;

/**
 * Package: cn.cactusli.lxf.dev.tech.domain.employee.service
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 10:48
 * @Github https://github.com/lixuanfengs
 */
public interface IEmployeeService {

    void insertEmployInfo(EmployeeInfoEntity employeeInfoEntity);

    EmployeeInfoEntity queryEmployInfo(String employNumber);

}
