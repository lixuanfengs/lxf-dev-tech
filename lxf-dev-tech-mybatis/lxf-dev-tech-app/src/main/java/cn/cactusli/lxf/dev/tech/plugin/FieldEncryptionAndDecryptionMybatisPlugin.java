package cn.cactusli.lxf.dev.tech.plugin;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * Package: cn.cactusli.lxf.dev.tech.plugin
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 9:53
 * @Github https://github.com/lixuanfengs
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class FieldEncryptionAndDecryptionMybatisPlugin implements Interceptor {

    /**
     * 密钥，必须是16位
     */
    private static final String KEY = "1898794876567654";
    /**
     * 偏移量，必须是16位
     */
    private static final String IV = "1233214566547891";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameter = args[1];
        String sqlId = mappedStatement.getId();

        if (parameter != null && (sqlId.contains("insert") || sqlId.contains("update"))) {
            String columnName = "employeeName";
            if (parameter instanceof Map) {
                List<Object> parameterList = (List<Object>) ((Map<?, ?>) parameter).get("list");
                for (Object obj : parameterList) {
                    if (hasField(obj, columnName)) {
                        String fieldValue = BeanUtils.getProperty(obj, columnName);
                        if (StringUtils.isNoneBlank(fieldValue)) {
                            String encryptedValue = encrypt(fieldValue);
                            BeanUtils.setProperty(obj, columnName, encryptedValue);
                        }
                    }
                }
            } else {
                if (hasField(parameter, columnName)) {
                    String fieldValue = BeanUtils.getProperty(parameter, columnName);
                    if (StringUtils.isNoneBlank(fieldValue)) {
                        String encryptedValue = encrypt(fieldValue);
                        BeanUtils.setProperty(parameter, columnName, encryptedValue);
                    }
                }
            }
        }

        Object result = invocation.proceed();

        if (result != null && sqlId.contains("query")) {
            // 查询操作，解密
            String columnName = "employeeName";
            if (result instanceof List) {
                List<Object> resultList = (List<Object>) result;
                for (Object obj : resultList) {
                    if (!hasField(obj, columnName)) continue;
                    String fieldValue = BeanUtils.getProperty(obj, columnName);
                    if (StringUtils.isBlank(fieldValue)) continue;
                    String decryptedValue = decrypt(fieldValue);
                    BeanUtils.setProperty(obj, columnName, decryptedValue);
                }
            }
        }

        return result;
    }

    public String encrypt(String content) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = KEY.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(content.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * AES解密
     *
     * @param content 密文
     * @return 明文
     * @throws Exception 异常
     */
    public String decrypt(String content) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = KEY.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = Base64.getDecoder().decode(content);
        byte[] original = cipher.doFinal(encrypted);
        return new String(original);
    }

    public boolean hasField(Object obj, String fieldName) {
        Class<?> clazz = obj.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        return false;
    }

}
