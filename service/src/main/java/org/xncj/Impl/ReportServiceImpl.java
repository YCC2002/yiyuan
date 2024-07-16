package org.xncj.Impl;

import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xncj.ReportService;
import org.xncj.common.Dto.MemberDto;
import org.xncj.common.Dto.OrderDto;
import org.xncj.common.utils.DateUtils;
import org.xncj.dao.ReportDao;
import org.xncj.pojo.Order;
import org.xncj.vo.OrderVo;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ReportServiceImpl
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/14 9:18
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/14 9:18
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */
@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportDao;
    @Override
    public Map<String, Object> getBusinessReportData() throws Exception {
        Map<String,Object> map = new HashMap<>();
        /*reportData ——>String*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate = sdf.format(new Date());
        map.put("reportDate",reportDate);

        //todayNewMember——>number
        Integer todayNewMember = reportDao.findTodayNewMember();
        map.put("todayNewMember",todayNewMember);

        //totalMember ——>number
        Integer totalMember = reportDao.findMember();
        map.put("totalMember",totalMember);

        //thisWeekNewMember ——>number
        String thisWeekMonday = DateUtils.parseDate2String(DateUtils.getThisWeekMonday());
        MemberDto WeekDto = new MemberDto();
        WeekDto.setStartTime(thisWeekMonday);
        String endTimeStr = DateUtils.parseDate2String(DateUtils.getSundayOfThisWeek());
        WeekDto.setEndTime(endTimeStr);
        Integer thisWeekNewMember = reportDao.findThisWeekNewCount(WeekDto);
        map.put("thisWeekNewMember",thisWeekNewMember);

        //thisMonthNewMember ——>number getFirstDay4ThisMonth
        String thisMonthFirst = DateUtils.parseDate2String(DateUtils.getFirstDay4ThisMonth());
        MemberDto monthDto = new MemberDto();
        monthDto.setStartTime(thisMonthFirst);
        int endTime = Integer.parseInt(thisMonthFirst.substring(thisMonthFirst.lastIndexOf("-")+1));
        endTime = endTime+29;
        String endTimeMonth = thisMonthFirst.substring(0,thisMonthFirst.lastIndexOf("-")+1)+endTime;
        monthDto.setEndTime(endTimeMonth);
        Integer thisMonthNewMember = reportDao.findThisMonthCount(monthDto);
        map.put("thisMonthNewMember",thisMonthNewMember);

        //todayOrderNumber ——> number
        Integer todayOrderNumber = reportDao.findTodayOrderCountByDate(reportDate);
        map.put("todayOrderNumber",todayOrderNumber);

        //todayVisitsNumber ——>number
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderDate(reportDate);
        orderVo.setOrderStatus(Order.ORDERSTATUS_YES);
        Integer todayVisitsNumber = reportDao.findTodayVisitsNumber(orderVo);
        map.put("todayVisitsNumber",todayVisitsNumber);

        //thisWeekOrderNumber ——>number
        Integer thisWeekOrderNumber = reportDao.findTodayOrderCountByDate(WeekDto.getStartTime());
        map.put("thisWeekOrderNumber",thisWeekOrderNumber);

        //thisWeekVisitsNumber ——>number
        OrderDto orderDto = new OrderDto();
        orderDto.setStartTime(thisMonthFirst);
        orderDto.setEndTime(endTimeStr);
        orderDto.setOrderStatus(Order.ORDERSTATUS_YES);
        Integer thisWeekVisitsNumber = reportDao.findThisWeekVisitsCount(orderDto);
        map.put("thisWeekVisitsNumber",thisWeekVisitsNumber);

        //thisMonthOrderNumber ——>number
        Integer thisMonthOrderNumber = reportDao.findThisMonthOrderCount(monthDto);
        map.put("thisMonthOrderNumber",thisMonthOrderNumber);


        //thisMonthVisitsNumber——>number
        OrderDto orderMonthDto = new OrderDto();
        orderMonthDto.setStartTime(thisMonthFirst);
        orderDto.setEndTime(endTimeMonth);
        orderMonthDto.setOrderStatus(Order.ORDERSTATUS_YES);
        Integer thisMonthVisitsNumber = reportDao.findtThisMonthVisitsCount(orderMonthDto);
        map.put("thisMonthVisitsNumber",thisMonthVisitsNumber);

        //hotSetMeals ——> list
        List<Map> hotSetMeal = reportDao.findHotSetMeal();
        map.put("hotSetmeal",hotSetMeal);
        return map;
    }
}
