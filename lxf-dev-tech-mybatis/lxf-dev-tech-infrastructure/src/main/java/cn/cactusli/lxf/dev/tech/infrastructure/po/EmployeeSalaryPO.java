package cn.cactusli.lxf.dev.tech.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Package: cn.cactusli.lxf.dev.tech.infrastructure.po
 * Description:
 *  雇员薪资表
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 11:02
 * @Github https://github.com/lixuanfengs
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSalaryPO {

    /** 自增ID */
    private Long id;
    /** 雇员编号 */
    private String employeeNumber;
    /** 薪资总额 */
    private BigDecimal salaryTotalAmount;
    /** 绩效工资 */
    private BigDecimal salaryMeritAmount;
    /** 基础工资 */
    private BigDecimal salaryBaseAmount;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
