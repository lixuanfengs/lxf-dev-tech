package cn.cactusli.lxf.dev.tech.domain.employee.service;

import cn.cactusli.lxf.dev.tech.domain.employee.model.entity.EmployeeInfoEntity;
import cn.cactusli.lxf.dev.tech.domain.employee.repository.IEmployeeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Package: cn.cactusli.lxf.dev.tech.domain.employee.service
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 10:48
 * @Github https://github.com/lixuanfengs
 */
@Service
public class EmployeeService implements IEmployeeService {

    @Resource
    private IEmployeeRepository employeeRepository;

    @Override
    public void insertEmployInfo(EmployeeInfoEntity employeeInfoEntity) {
        employeeRepository.insertEmployeeInfo(employeeInfoEntity);
    }

    @Override
    public EmployeeInfoEntity queryEmployInfo(String employNumber) {
        return employeeRepository.queryEmployInfo(employNumber);
    }
}
