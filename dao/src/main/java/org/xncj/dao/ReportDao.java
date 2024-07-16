package org.xncj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.xncj.common.Dto.MemberDto;
import org.xncj.common.Dto.OrderDto;
import org.xncj.vo.OrderVo;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportDao {
    Integer findTodayNewMember();

    Integer findMember();

    Integer findThisWeekNewCount(MemberDto weekDto);

    Integer findThisMonthCount(MemberDto monthDto);

    Integer findTodayOrderCountByDate(String reportDate);

    Integer findTodayVisitsNumber(OrderVo orderVo);

    Integer findThisWeekVisitsCount(OrderDto orderDto);

    Integer findThisMonthOrderCount(MemberDto monthDto);

    Integer findtThisMonthVisitsCount(OrderDto orderMonthDto);

    List<Map> findHotSetMeal();
}
