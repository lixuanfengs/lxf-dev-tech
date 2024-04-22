package cn.cactusli.lxf.dev.tech.domain.employee.repository;

import cn.cactusli.lxf.dev.tech.domain.employee.model.entity.EmployeeInfoEntity;

/**
 * Package: cn.cactusli.lxf.dev.tech.domain.employee.repository
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 10:47
 * @Github https://github.com/lixuanfengs
 */
public interface IEmployeeRepository {

    void insertEmployeeInfo(EmployeeInfoEntity employeeInfoEntity);

    EmployeeInfoEntity queryEmployInfo(String employNumber);

}
