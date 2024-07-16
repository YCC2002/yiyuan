package org.xncj.Impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xncj.OrderSettingService;
import org.xncj.dao.OrderSettingDao;
import org.xncj.pojo.OrderSetting;
import org.xncj.vo.OrderSettingVo;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName OrderSettingServiceImpl
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/13 9:05
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/13 9:05
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */
@Service
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {
    @Autowired
    private OrderSettingDao orderSettingDao;

    @Override
    public void importOrderSetting(List<String[]> list) {
        for (String[] strings :list) {
            OrderSetting orderSetting = new OrderSetting();
            orderSetting.setOrderDate(new Date(strings[0]));
            orderSetting.setNumber(Integer.parseInt(strings[1]));
            orderSettingDao.importOrderSetting(orderSetting);
        }

    }

    @Override
    public List<OrderSettingVo> findAllOrderSettingVo() {

        List<OrderSetting> orderSettings = orderSettingDao.findAllOrderSettingVo();
        List<OrderSettingVo> orderSettingVos = new ArrayList<>();

        orderSettings.forEach(orderSetting -> {
            OrderSettingVo orderSettingVo = new OrderSettingVo();
            BeanUtils.copyProperties(orderSetting,orderSettingVo);
            orderSettingVos.add(orderSettingVo);
        });
        return orderSettingVos;
    }

    @Override
    public void editNumberByDate(OrderSetting orderSetting) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(orderSetting.getOrderDate());
        Integer number=orderSettingDao.findNumberByDate(dateStr);
        if(number == null){
            orderSettingDao.addOrderSetting(orderSetting);
        }else{
            Map<String, Object> map = new HashMap<>();
            map.put("orderDate",dateStr);
            map.put("number",orderSetting.getNumber());
            orderSettingDao.editNumberByDate(map);
        }
    }
}
