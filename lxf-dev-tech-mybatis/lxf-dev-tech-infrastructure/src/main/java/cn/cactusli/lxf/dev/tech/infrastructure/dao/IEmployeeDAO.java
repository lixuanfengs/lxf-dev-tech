package cn.cactusli.lxf.dev.tech.infrastructure.dao;

import cn.cactusli.lxf.dev.tech.infrastructure.po.EmployeePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: cn.cactusli.lxf.dev.tech.infrastructure.dao
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 11:04
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface IEmployeeDAO {

    void insert(EmployeePO employee);

    void insertList(List<EmployeePO> list);

    void update(EmployeePO employeePO);

    EmployeePO queryEmployeeByEmployNumber(String employNumber);

}
