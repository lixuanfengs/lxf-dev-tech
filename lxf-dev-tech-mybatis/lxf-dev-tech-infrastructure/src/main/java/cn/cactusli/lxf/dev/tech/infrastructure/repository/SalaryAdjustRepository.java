package cn.cactusli.lxf.dev.tech.infrastructure.repository;

import cn.cactusli.lxf.dev.tech.domain.salary.model.aggregate.AdjustSalaryApplyOrderAggregate;
import cn.cactusli.lxf.dev.tech.domain.salary.model.entity.EmployeeEntity;
import cn.cactusli.lxf.dev.tech.domain.salary.model.entity.EmployeeSalaryAdjustEntity;
import cn.cactusli.lxf.dev.tech.domain.salary.repository.ISalaryAdjustRepository;
import cn.cactusli.lxf.dev.tech.infrastructure.dao.IEmployeeDAO;
import cn.cactusli.lxf.dev.tech.infrastructure.dao.IEmployeeSalaryAdjustDAO;
import cn.cactusli.lxf.dev.tech.infrastructure.dao.IEmployeeSalaryDAO;
import cn.cactusli.lxf.dev.tech.infrastructure.po.EmployeePO;
import cn.cactusli.lxf.dev.tech.infrastructure.po.EmployeeSalaryAdjustPO;
import cn.cactusli.lxf.dev.tech.infrastructure.po.EmployeeSalaryPO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Package: cn.cactusli.lxf.dev.tech.infrastructure.repository
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 11:05
 * @Github https://github.com/lixuanfengs
 */
@Repository
public class SalaryAdjustRepository implements ISalaryAdjustRepository {
    @Resource
    private IEmployeeDAO employeeDAO;
    @Resource
    private IEmployeeSalaryDAO employeeSalaryDAO;
    @Resource
    private IEmployeeSalaryAdjustDAO employeeSalaryAdjustDAO;

    /**
     * Spring Boot 事务管理的级别可以通过 `@Transactional` 注解的 `isolation` 属性进行配置。常见的事务隔离级别有以下几种：
     * 1. `DEFAULT`：使用底层数据库的默认隔离级别。MySQL 默认为 `REPEATABLE READ`，Oracle 默认为 `READ COMMITTED`。
     * 2. `READ_UNCOMMITTED`：最低的隔离级别，允许读取未提交的数据变更，可能会导致脏读、不可重复读和幻读问题。
     * 3. `READ_COMMITTED`：允许读取已经提交的数据变更，可以避免脏读问题，但可能会出现不可重复读和幻读问题。
     * 4. `REPEATABLE_READ`：保证同一事务中多次读取同一数据时，结果始终一致，可以避免脏读和不可重复读问题，但可能会出现幻读问题。
     * 5. `SERIALIZABLE`：最高的隔离级别，可以避免脏读、不可重复读和幻读问题，但会影响并发性能。
     * <p>
     * 在 Spring Boot 中，默认的事务隔离级别为 `DEFAULT`。如果没有特殊需求，建议使用默认隔离级别。
     * SpringBoot 事务的传播行为可以通过 `@Transactional` 注解的 `propagation` 属性进行配置。常用的传播行为有以下几种：
     * 1. `Propagation.REQUIRED`：默认的传播行为，如果当前存在事务，则加入该事务，否则新建一个事务；
     * 2. `Propagation.SUPPORTS`：如果当前存在事务，则加入该事务，否则以非事务的方式执行；
     * 3. `Propagation.MANDATORY`：如果当前存在事务，则加入该事务，否则抛出异常；
     * 4. `Propagation.REQUIRES_NEW`：无论当前是否存在事务，都会新建一个事务，如果当前存在事务，则将当前事务挂起；
     * 5. `Propagation.NOT_SUPPORTED`：以非事务的方式执行操作，如果当前存在事务，则将当前事务挂起；
     * 6. `Propagation.NEVER`：以非事务的方式执行操作，如果当前存在事务，则抛出异常；
     * 7. `Propagation.NESTED`：如果当前存在事务，则在该事务的嵌套事务中执行，否则新建一个事务。嵌套事务是独立于外部事务的，但是如果外部事务回滚，则嵌套事务也会回滚。
     * <p>
     * 除了传播行为，`@Transactional` 注解还可以配置其他属性，例如隔离级别、超时时间、只读等。
     */
    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 350, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String adjustSalary(AdjustSalaryApplyOrderAggregate adjustSalaryApplyOrderAggregate) {

        String employeeNumber = adjustSalaryApplyOrderAggregate.getEmployeeNumber();
        String orderId = adjustSalaryApplyOrderAggregate.getOrderId();
        EmployeeEntity employeeEntity = adjustSalaryApplyOrderAggregate.getEmployeeEntity();
        EmployeeSalaryAdjustEntity employeeSalaryAdjustEntity = adjustSalaryApplyOrderAggregate.getEmployeeSalaryAdjustEntity();

        EmployeePO employeePO = EmployeePO.builder()
                .employeeNumber(employeeNumber)
                .employeeLevel(employeeEntity.getEmployeeLevel().getCode())
                .employeeTitle(employeeEntity.getEmployeeTitle().getDesc()).build();

        // 更新岗位
        employeeDAO.update(employeePO);

        EmployeeSalaryPO employeeSalaryPO = EmployeeSalaryPO.builder()
                .employeeNumber(employeeNumber)
                .salaryTotalAmount(employeeSalaryAdjustEntity.getAdjustTotalAmount())
                .salaryMeritAmount(employeeSalaryAdjustEntity.getAdjustMeritAmount())
                .salaryBaseAmount(employeeSalaryAdjustEntity.getAdjustBaseAmount())
                .build();

        // 更新薪酬
        employeeSalaryDAO.update(employeeSalaryPO);

        EmployeeSalaryAdjustPO employeeSalaryAdjustPO = EmployeeSalaryAdjustPO.builder()
                .employeeNumber(employeeNumber)
                .adjustOrderId(orderId)
                .adjustTotalAmount(employeeSalaryAdjustEntity.getAdjustTotalAmount())
                .adjustBaseAmount(employeeSalaryAdjustEntity.getAdjustMeritAmount())
                .adjustMeritAmount(employeeSalaryAdjustEntity.getAdjustBaseAmount())
                .build();

        // 写入流水
        employeeSalaryAdjustDAO.insert(employeeSalaryAdjustPO);

        return orderId;
    }

}
