package cn.cactusli.lxf.dev.tech.domain.salary.model.aggregate;

import cn.cactusli.lxf.dev.tech.domain.salary.model.entity.EmployeeEntity;
import cn.cactusli.lxf.dev.tech.domain.salary.model.entity.EmployeeSalaryAdjustEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.cactusli.lxf.dev.tech.domain.salary.model.aggregate
 * Description:
 *  调薪受理单聚合对象
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 10:53
 * @Github https://github.com/lixuanfengs
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdjustSalaryApplyOrderAggregate {

    /** 雇员编号 */
    private String employeeNumber;
    /** 调薪单号 */
    private String orderId;
    /** 雇员实体 */
    private EmployeeEntity employeeEntity;
    /** 雇员实体 */
    private EmployeeSalaryAdjustEntity employeeSalaryAdjustEntity;
}
