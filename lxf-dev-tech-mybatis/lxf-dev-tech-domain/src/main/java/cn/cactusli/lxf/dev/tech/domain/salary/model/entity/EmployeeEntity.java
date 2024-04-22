package cn.cactusli.lxf.dev.tech.domain.salary.model.entity;

import cn.cactusli.lxf.dev.tech.domain.salary.model.valobj.EmployeePostVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.cactusli.lxf.dev.tech.domain.salary.model.entity
 * Description:
 *  雇员实体对象
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 10:51
 * @Github https://github.com/lixuanfengs
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    /** 雇员级别 */
    private EmployeePostVO employeeLevel;
    /** 雇员岗位Title */
    private EmployeePostVO employeeTitle;
}
