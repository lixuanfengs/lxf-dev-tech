package cn.cactusli.lxf.dev.tech.domain.salary.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Package: cn.cactusli.lxf.dev.tech.domain.salary.model.entity
 * Description:
 * 调薪实体对象
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 10:52
 * @Github https://github.com/lixuanfengs
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSalaryAdjustEntity {

    /** 总额调薪 */
    private BigDecimal adjustTotalAmount;
    /** 基础调薪 */
    private BigDecimal adjustBaseAmount;
    /** 绩效调薪 */
    private BigDecimal adjustMeritAmount;

}
