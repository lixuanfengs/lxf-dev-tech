package cn.cactusli.lxf.dev.tech.test.infrastructure;

import cn.cactusli.lxf.dev.tech.infrastructure.dao.IEmployeeSalaryAdjustDAO;
import cn.cactusli.lxf.dev.tech.infrastructure.po.EmployeeSalaryAdjustPO;
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
public class IEmployeeSalaryAdjustDAOTest {

    @Resource
    private IEmployeeSalaryAdjustDAO employeeSalaryAdjustDAO;

    @Test
    public void test_insert() {
        EmployeeSalaryAdjustPO employeeSalaryAdjust = new EmployeeSalaryAdjustPO();
        employeeSalaryAdjust.setEmployeeNumber("10000001");
        employeeSalaryAdjust.setAdjustOrderId("109089990198888811");
        employeeSalaryAdjust.setAdjustTotalAmount(new BigDecimal(1000));
        employeeSalaryAdjust.setAdjustBaseAmount(new BigDecimal(800));
        employeeSalaryAdjust.setAdjustMeritAmount(new BigDecimal(200));
        employeeSalaryAdjustDAO.insert(employeeSalaryAdjust);
    }

}
