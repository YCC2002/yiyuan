package org.xncj.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xncj.CheckItemService;
import org.xncj.common.entity.PageResult;
import org.xncj.common.entity.QueryPageBean;
import org.xncj.dao.CheckItemDao;
import org.xncj.pojo.CheckItem;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    public CheckItemDao checkItemDao;

    @Override
    public void addCheckItem(CheckItem checkItem) {
        checkItemDao.addCheckItem(checkItem);
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        if ("null".equals(queryPageBean.getQueryString())){
            queryPageBean.setQueryString(null);
        }
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page <CheckItem> page = checkItemDao.findPage(queryPageBean.getQueryString());
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return pageResult;
    }

    @Override
    public void deleteCheckItem(int id) {
        checkItemDao.deleteCheckItem(id);
    }

    @Override
    public void updateCheckItem(CheckItem checkItem) {
        checkItemDao.updateCheckItem(checkItem);
    }

    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
