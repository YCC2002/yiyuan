package org.xncj.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.xncj.SetMealService;
import org.xncj.common.entity.PageResult;
import org.xncj.common.entity.QueryPageBean;
import org.xncj.dao.SetMealDao;
import org.xncj.pojo.CheckGroup;
import org.xncj.pojo.Setmeal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SetMealServiceImpl
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/10 10:19
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/10 10:19
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */

@Service
public class SetMealServiceImpl implements SetMealService {
    @Autowired
    private SetMealDao setMealDao;

    @Override
    public void addSetMeal(Integer[] checkgroupIds, Setmeal setmeal) {
        setMealDao.addSetMeal(setmeal);
        Integer setMealID = setmeal.getId();
        Map<String, Integer> map = new HashMap<>();
        map.put("setmeal_id", setMealID);
        for (Integer checkgroupId : checkgroupIds) {
            map.put("checkgroup_id", checkgroupId);
            setMealDao.SetmealCheckgroup(map);
        }
    }

    @Override
    public List<CheckGroup> findAll() {
        return setMealDao.findAll();
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        if (ObjectUtils.isEmpty(queryPageBean)) {
            queryPageBean.setQueryString(null);
        }

        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<Setmeal> page = setMealDao.findPage(queryPageBean.getQueryString());
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return pageResult;
    }
}
