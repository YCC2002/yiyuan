package org.xncj;

import org.xncj.pojo.OrderSetting;
import org.xncj.vo.OrderSettingVo;

import java.util.List;

public interface OrderSettingService {
    void importOrderSetting(List<String[]> list);

    List<OrderSettingVo> findAllOrderSettingVo();

    void editNumberByDate(OrderSetting orderSetting);
}
