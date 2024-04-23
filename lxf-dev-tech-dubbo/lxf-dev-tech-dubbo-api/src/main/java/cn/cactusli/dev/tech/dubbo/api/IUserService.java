package cn.cactusli.dev.tech.dubbo.api;

import cn.cactusli.dev.tech.dubbo.api.dto.UserReqDTO;
import cn.cactusli.dev.tech.dubbo.api.dto.UserResDTO;
import cn.cactusli.dev.tech.dubbo.api.types.Response;

/**
 * Package: cn.cactusli.dev.tech.dubbo.api
 * Description:
 * 查询用户信息

 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/22 10:09
 * @Github https://github.com/lixuanfengs
 */
public interface IUserService {

    Response<UserResDTO> queryUserInfo(UserReqDTO reqDTO);


}
