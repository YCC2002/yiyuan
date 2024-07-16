package org.xncj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName OrderSettingVo
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/13 10:36
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/13 10:36
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSettingVo {
    private Date orderDate;//预约设置日期
    private int number;//可预约人数
    private int reservations ;//已预约人数
}
