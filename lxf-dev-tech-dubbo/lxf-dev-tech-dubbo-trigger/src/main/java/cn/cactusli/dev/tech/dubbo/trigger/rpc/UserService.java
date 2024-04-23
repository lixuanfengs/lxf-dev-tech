package cn.cactusli.dev.tech.dubbo.trigger.rpc;

import cn.cactusli.dev.tech.dubbo.api.IUserService;
import cn.cactusli.dev.tech.dubbo.api.dto.UserReqDTO;
import cn.cactusli.dev.tech.dubbo.api.dto.UserResDTO;
import cn.cactusli.dev.tech.dubbo.api.types.Constants;
import cn.cactusli.dev.tech.dubbo.api.types.Response;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * Package: cn.cactusli.dev.tech.dubbo.trigger.rpc
 * Description:
 * 查询用户信息
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/22 10:35
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@DubboService(version = "1.0.0")
public class UserService implements IUserService {

    @Override
    public Response<UserResDTO> queryUserInfo(UserReqDTO reqDTO) {
        log.info("查询用户信息 userId: {} reqStr: {}", reqDTO.getUserId(), JSON.toJSONString(reqDTO));
        try {
            // 1. 模拟查询【你可以从数据库或者Redis缓存获取数据】
            UserResDTO resDTO = UserResDTO.builder()
                    .userId(reqDTO.getUserId())
                    .userName("仙人球")
                    .userAge(18)
                    .build();

            // 2. 返回结果
            return Response.<UserResDTO>builder()
                    .code(Constants.ResponseCode.SUCCESS.getCode())
                    .info(Constants.ResponseCode.SUCCESS.getInfo())
                    .data(resDTO).build();
        } catch (Exception e) {
            log.error("查询用户信息失败 userId: {} reqStr: {}", reqDTO.getUserId(), JSON.toJSONString(reqDTO), e);
            return Response.<UserResDTO>builder()
                    .code(Constants.ResponseCode.UN_ERROR.getCode())
                    .info(Constants.ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }
}
