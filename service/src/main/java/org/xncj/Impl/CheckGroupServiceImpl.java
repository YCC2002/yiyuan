package org.xncj.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.xncj.CheckGroupService;
import org.xncj.common.entity.PageResult;
import org.xncj.common.entity.QueryPageBean;
import org.xncj.dao.CheckGroupDao;
import org.xncj.pojo.CheckGroup;
import org.xncj.pojo.CheckItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CheckGroupServiceImpl
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/8 14:25
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/8 14:25
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */

@Service
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupDao checkGroupDao;

    @Override
    public void addCheckGroup(Integer[] checkitemIds, CheckGroup checkGroup) {
        checkGroupDao.addCheckGroup(checkGroup);
        Integer checkGroupId = checkGroup.getId();
        Map<String, Integer> map = new HashMap<>();
        map.put("checkgroup_id", checkGroupId);
        for (Integer checkitemId : checkitemIds) {
            map.put("checkitem_id", checkitemId);
            checkGroupDao.setCheckGroupCheckItem(map);
        }
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        if (ObjectUtils.isEmpty(queryPageBean)) {
            queryPageBean.setQueryString(null);
        }
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<CheckGroup> page = checkGroupDao.findPage(queryPageBean.getQueryString());
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return pageResult;
    }

    @Override
    public void deleteCheckGroup(Integer checkGroupId) {
        checkGroupDao.deleteCheckGroup(checkGroupId);
        checkGroupDao.deleteCheckGroupCheckItem(checkGroupId);
    }

    @Override
    public Integer[] findCheckGroupById(Integer checkGroupId) {
        return checkGroupDao.findCheckGroupCheckItem(checkGroupId);
    }

    @Override
    public void updateCheckGroup(Integer[] checkitemIds, CheckGroup checkGroup) {
        checkGroupDao.deleteCheckGroupCheckItem(checkGroup.getId());
        checkGroupDao.updateCheckGroup(checkGroup);
        Integer checkGroupId = checkGroup.getId();
        Map<String, Integer> map = new HashMap<>();
        map.put("checkgroup_id", checkGroupId);
        for (Integer checkitemId : checkitemIds) {
            map.put("checkitem_id", checkitemId);
            checkGroupDao.setCheckGroupCheckItem(map);
        }
    }
}
