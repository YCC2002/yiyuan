package org.xncj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.xncj.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderSettingDao {
    void importOrderSetting(OrderSetting orderSetting);

    List<OrderSetting> findAllOrderSettingVo();

    void editNumberByDate(Map<String, Object> orderSetting);

    Integer findNumberByDate(String dateStr);

    void addOrderSetting(OrderSetting orderSetting);
}
