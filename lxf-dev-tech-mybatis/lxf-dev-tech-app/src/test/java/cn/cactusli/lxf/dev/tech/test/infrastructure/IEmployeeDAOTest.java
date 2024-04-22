package cn.cactusli.lxf.dev.tech.test.infrastructure;

import cn.cactusli.lxf.dev.tech.infrastructure.dao.IEmployeeDAO;
import cn.cactusli.lxf.dev.tech.infrastructure.po.EmployeePO;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 注意；Duplicate entry '10000010' for key 'idx_employee_number' 代表唯一索引冲突，库表中已经存在相同数据，需要修改测试数据
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IEmployeeDAOTest {

    @Resource
    private IEmployeeDAO employeeDAO;

    @Test
    public void test_insert() {
        EmployeePO employee = new EmployeePO();
        employee.setEmployeeNumber("10000002");
        employee.setEmployeeName("小傅哥");
        employee.setEmployeeLevel("T2");
        employee.setEmployeeTitle("见习工程师");
        employeeDAO.insert(employee);
    }

    @Test
    public void test_query() {
        EmployeePO employeePO = employeeDAO.queryEmployeeByEmployNumber("10000002");
        log.info("测试结果：{}", JSON.toJSONString(employeePO));
    }

    @Test
    public void test_insert_list() {
        List<EmployeePO> list = new ArrayList<>();
        for (int i = 5; i < 8; i++) {
            EmployeePO employee = new EmployeePO();
            employee.setEmployeeNumber("1000001" + i);
            employee.setEmployeeName("花花");
            employee.setEmployeeLevel("T2");
            employee.setEmployeeTitle("见习工程师");
            list.add(employee);
        }
        employeeDAO.insertList(list);
    }

}
