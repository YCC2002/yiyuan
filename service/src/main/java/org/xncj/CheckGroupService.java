package org.xncj;

import org.xncj.common.entity.PageResult;
import org.xncj.common.entity.QueryPageBean;
import org.xncj.pojo.CheckGroup;
import org.xncj.pojo.CheckItem;

public interface CheckGroupService {
    void addCheckGroup(Integer[] checkitemIds, CheckGroup checkGroup);

    PageResult findPage(QueryPageBean queryPageBean);

    void deleteCheckGroup(Integer checkGroupId);

    Integer[] findCheckGroupById(Integer checkGroupId);

    void updateCheckGroup(Integer[] checkitemIds, CheckGroup checkGroup);
}
