package org.xncj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xncj.OrderSettingService;
import org.xncj.common.constant.MessageConstant;
import org.xncj.common.entity.Result;
import org.xncj.common.utils.POIUtils;
import org.xncj.pojo.OrderSetting;
import org.xncj.vo.OrderSettingVo;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName OrderSettingController
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/13 9:00
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/13 9:00
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */

@RestController
@RequestMapping("/ordersetting")
public class OrderSettingController {
    @Autowired
    OrderSettingService orderSettingService;

    @PostMapping("/upload")
    public Result upload(MultipartFile excelFile) throws IOException {
        List<String[]> list = POIUtils.readExcel(excelFile);
        orderSettingService.importOrderSetting(list);
        return new Result(true, MessageConstant.IMPORT_ORDERSETTING_SUCCESS);
    }

    @GetMapping("/findAllOrderSetting")
    public Result findAllOrderSetting() {
        List<OrderSettingVo> orderSettingVoList=orderSettingService.findAllOrderSettingVo();
        return new Result(true, MessageConstant.QUERY_SETMEALLIST_SUCCESS, orderSettingVoList);
    }

    @PostMapping("/editNumberByDate")
    public Result editNumberByDate(@RequestBody OrderSetting orderSetting) {
        orderSettingService.editNumberByDate(orderSetting);
        return new Result(true, MessageConstant.ORDERSETTING_SUCCESS);
    }
}
