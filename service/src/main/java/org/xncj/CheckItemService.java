package org.xncj;

import org.xncj.common.entity.PageResult;
import org.xncj.common.entity.QueryPageBean;
import org.xncj.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {


    void addCheckItem(CheckItem checkItem);

    PageResult findPage(QueryPageBean queryPageBean);

    void deleteCheckItem(int id);

    void updateCheckItem(CheckItem checkItem);

    List<CheckItem> findAll();
}
