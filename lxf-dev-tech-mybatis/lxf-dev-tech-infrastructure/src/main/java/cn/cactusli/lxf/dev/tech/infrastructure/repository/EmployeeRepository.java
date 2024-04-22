package cn.cactusli.lxf.dev.tech.infrastructure.repository;

import cn.cactusli.lxf.dev.tech.domain.employee.model.entity.EmployeeInfoEntity;
import cn.cactusli.lxf.dev.tech.domain.employee.repository.IEmployeeRepository;
import cn.cactusli.lxf.dev.tech.infrastructure.dao.IEmployeeDAO;
import cn.cactusli.lxf.dev.tech.infrastructure.dao.IEmployeeSalaryDAO;
import cn.cactusli.lxf.dev.tech.infrastructure.po.EmployeePO;
import cn.cactusli.lxf.dev.tech.infrastructure.po.EmployeeSalaryPO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * Package: cn.cactusli.lxf.dev.tech.infrastructure.repository
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 11:03
 * @Github https://github.com/lixuanfengs
 */
@Repository
public class EmployeeRepository implements IEmployeeRepository {
    @Resource
    private IEmployeeDAO employeeDAO;
    @Resource
    private IEmployeeSalaryDAO employeeSalaryDAO;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Override
    public void insertEmployeeInfo(EmployeeInfoEntity employeeInfoEntity) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    EmployeePO employeePO = EmployeePO.builder()
                            .employeeNumber(employeeInfoEntity.getEmployeeNumber())
                            .employeeName(employeeInfoEntity.getEmployeeName())
                            .employeeLevel(employeeInfoEntity.getEmployeeLevel())
                            .employeeTitle(employeeInfoEntity.getEmployeeTitle())
                            .build();

                    employeeDAO.insert(employeePO);

                    EmployeeSalaryPO employeeSalaryPO = EmployeeSalaryPO.builder()
                            .employeeNumber(employeeInfoEntity.getEmployeeNumber())
                            .salaryTotalAmount(employeeInfoEntity.getSalaryTotalAmount())
                            .salaryMeritAmount(employeeInfoEntity.getSalaryMeritAmount())
                            .salaryBaseAmount(employeeInfoEntity.getSalaryBaseAmount())
                            .build();

                    employeeSalaryDAO.insert(employeeSalaryPO);
                } catch (Exception e) {
                    status.setRollbackOnly();
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public EmployeeInfoEntity queryEmployInfo(String employNumber) {
        // 查询雇员
        EmployeePO employeePO = employeeDAO.queryEmployeeByEmployNumber(employNumber);
        // 查询薪酬
        EmployeeSalaryPO employeeSalaryPO = employeeSalaryDAO.queryEmployeeSalaryByEmployNumber(employNumber);

        return EmployeeInfoEntity.builder()
                .employeeNumber(employeePO.getEmployeeNumber())
                .employeeName(employeePO.getEmployeeName())
                .employeeLevel(employeePO.getEmployeeLevel())
                .employeeTitle(employeePO.getEmployeeTitle())
                .salaryTotalAmount(employeeSalaryPO.getSalaryTotalAmount())
                .salaryMeritAmount(employeeSalaryPO.getSalaryTotalAmount())
                .salaryBaseAmount(employeeSalaryPO.getSalaryTotalAmount())
                .build();
    }
}
