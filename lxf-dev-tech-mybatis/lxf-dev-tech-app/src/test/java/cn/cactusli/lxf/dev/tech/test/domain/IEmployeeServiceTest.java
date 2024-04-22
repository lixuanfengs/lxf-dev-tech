package cn.cactusli.lxf.dev.tech.test.domain;

import cn.cactusli.lxf.dev.tech.domain.employee.model.entity.EmployeeInfoEntity;
import cn.cactusli.lxf.dev.tech.domain.employee.service.IEmployeeService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IEmployeeServiceTest {

    @Resource
    private IEmployeeService employeeService;

    @Test
    public void test_insertEmployInfo() {
        EmployeeInfoEntity employeeInfo = new EmployeeInfoEntity();
        employeeInfo.setEmployeeNumber("10000033");
        employeeInfo.setEmployeeName("仙人球");
        employeeInfo.setEmployeeLevel("T1");
        employeeInfo.setEmployeeTitle("实习工程师");
        employeeInfo.setSalaryTotalAmount(new BigDecimal("100"));
        employeeInfo.setSalaryMeritAmount(new BigDecimal("10"));
        employeeInfo.setSalaryBaseAmount(new BigDecimal("90"));
        employeeService.insertEmployInfo(employeeInfo);
    }

    @Test
    public void test_queryEmployInfo() {
        EmployeeInfoEntity employeeInfoEntity = employeeService.queryEmployInfo("10000001");
        log.info("测试结果：{}", JSON.toJSONString(employeeInfoEntity));
    }

}
