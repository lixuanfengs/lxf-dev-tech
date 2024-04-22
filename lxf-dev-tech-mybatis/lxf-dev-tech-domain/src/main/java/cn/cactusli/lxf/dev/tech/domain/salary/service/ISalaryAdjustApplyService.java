package cn.cactusli.lxf.dev.tech.domain.salary.service;

import cn.cactusli.lxf.dev.tech.domain.salary.model.aggregate.AdjustSalaryApplyOrderAggregate;

/**
 * Package: cn.cactusli.lxf.dev.tech.domain.salary.service
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 10:54
 * @Github https://github.com/lixuanfengs
 */
public interface ISalaryAdjustApplyService {

    String execSalaryAdjust(AdjustSalaryApplyOrderAggregate adjustSalaryApplyOrderAggregate);

}
