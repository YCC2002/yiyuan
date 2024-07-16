package org.xncj;

import org.xncj.common.entity.PageResult;
import org.xncj.common.entity.QueryPageBean;
import org.xncj.pojo.CheckGroup;
import org.xncj.pojo.Setmeal;

import java.util.List;

public interface SetMealService {

    void addSetMeal(Integer[] checkgroupIds, Setmeal setmeal);

    List<CheckGroup> findAll();

    PageResult findPage(QueryPageBean queryPageBean);
}
