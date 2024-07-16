package org.xncj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xncj.ReportService;
import org.xncj.common.constant.MessageConstant;
import org.xncj.common.entity.Result;

import java.util.Map;

/**
 * @ClassName ReportController
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/14 9:15
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/14 9:15
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/getBusinessReportData")
    public Result getBusinessReportData() {
        Map<String, Object> map= null;
        try {
            map = reportService.getBusinessReportData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(true, MessageConstant.GET_MEMBER_NUMBER_REPORT_SUCCESS,map);
    }
}
