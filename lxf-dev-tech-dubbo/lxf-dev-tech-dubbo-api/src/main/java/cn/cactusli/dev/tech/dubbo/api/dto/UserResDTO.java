package cn.cactusli.dev.tech.dubbo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResDTO implements Serializable {

    private String userId;
    private String userName;
    private Integer userAge;

}
