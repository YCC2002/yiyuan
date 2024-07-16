package org.xncj.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.xncj.pojo.CheckGroup;
import org.xncj.pojo.Setmeal;

import java.util.List;
import java.util.Map;

@Mapper
public interface SetMealDao {
    void addSetMeal(Setmeal setmeal);

    void SetmealCheckgroup(Map<String, Integer> map);

    List<CheckGroup> findAll();

    Page<Setmeal> findPage(@Param("queryString") String queryString);
}
