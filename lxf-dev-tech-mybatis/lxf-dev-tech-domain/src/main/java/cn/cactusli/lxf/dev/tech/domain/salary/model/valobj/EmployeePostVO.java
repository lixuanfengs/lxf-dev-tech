package cn.cactusli.lxf.dev.tech.domain.salary.model.valobj;

/**
 * Package: cn.cactusli.lxf.dev.tech.domain.salary.model.valobj
 * Description:
 *   雇员职位值对象
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 10:52
 * @Github https://github.com/lixuanfengs
 */
public enum EmployeePostVO {

    T1("T-1", "初级工程师"),
    T2("T-2", "初级工程师"),
    T3("T-3", "中级工程师"),
    T4("T-4", "中级工程师"),
    T5("T-5", "高级工程师"),
    T6("T-6", "高级工程师"),
    T7("T-7", "架构师"),
    T8("T-8", "架构师");

    private final String code;
    private final String desc;

    EmployeePostVO(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
