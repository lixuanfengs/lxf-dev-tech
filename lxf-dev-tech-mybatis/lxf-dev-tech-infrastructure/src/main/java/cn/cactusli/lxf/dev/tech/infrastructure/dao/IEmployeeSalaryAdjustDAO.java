package cn.cactusli.lxf.dev.tech.infrastructure.dao;

import cn.cactusli.lxf.dev.tech.infrastructure.po.EmployeeSalaryAdjustPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Package: cn.cactusli.lxf.dev.tech.infrastructure.dao
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 11:06
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface IEmployeeSalaryAdjustDAO {

    void insert(EmployeeSalaryAdjustPO employeeSalaryAdjustPO);

}
