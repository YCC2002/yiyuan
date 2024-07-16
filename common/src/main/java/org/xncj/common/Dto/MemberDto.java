package org.xncj.common.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName MemberDto
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/14 10:03
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/14 10:03
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String startTime;
    private String endTime;
}
