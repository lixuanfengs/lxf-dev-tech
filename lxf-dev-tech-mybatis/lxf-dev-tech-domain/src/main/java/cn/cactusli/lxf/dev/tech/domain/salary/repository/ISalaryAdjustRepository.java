package cn.cactusli.lxf.dev.tech.domain.salary.repository;

import cn.cactusli.lxf.dev.tech.domain.salary.model.aggregate.AdjustSalaryApplyOrderAggregate;

/**
 * Package: cn.cactusli.lxf.dev.tech.domain.salary.repository
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 10:54
 * @Github https://github.com/lixuanfengs
 */
public interface ISalaryAdjustRepository {

    String adjustSalary(AdjustSalaryApplyOrderAggregate adjustSalaryApplyOrderAggregate);

}
