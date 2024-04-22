package cn.cactusli.lxf.dev.tech.test.domain;

import cn.cactusli.lxf.dev.tech.domain.salary.model.aggregate.AdjustSalaryApplyOrderAggregate;
import cn.cactusli.lxf.dev.tech.domain.salary.model.entity.EmployeeEntity;
import cn.cactusli.lxf.dev.tech.domain.salary.model.entity.EmployeeSalaryAdjustEntity;
import cn.cactusli.lxf.dev.tech.domain.salary.model.valobj.EmployeePostVO;
import cn.cactusli.lxf.dev.tech.domain.salary.service.ISalaryAdjustApplyService;
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
public class ISalaryAdjustApplyServiceTest {

    @Resource
    private ISalaryAdjustApplyService salaryAdjustApplyService;

    @Test
    public void test_execSalaryAdjust() {
        AdjustSalaryApplyOrderAggregate adjustSalaryApplyOrderAggregate = AdjustSalaryApplyOrderAggregate.builder()
                .employeeNumber("10000001")
                .orderId("100908977676002")
                .employeeEntity(EmployeeEntity.builder().employeeLevel(EmployeePostVO.T3).employeeTitle(EmployeePostVO.T3).build())
                .employeeSalaryAdjustEntity(EmployeeSalaryAdjustEntity.builder()
                        .adjustTotalAmount(new BigDecimal(100))
                        .adjustBaseAmount(new BigDecimal(80))
                        .adjustMeritAmount(new BigDecimal(20)).build())
                .build();

        String orderId = salaryAdjustApplyService.execSalaryAdjust(adjustSalaryApplyOrderAggregate);

        log.info("调薪测试 req: {} res: {}", JSON.toJSONString(adjustSalaryApplyOrderAggregate), orderId);
    }

}
