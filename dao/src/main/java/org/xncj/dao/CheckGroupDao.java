package org.xncj.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.xncj.pojo.CheckGroup;
import org.xncj.pojo.CheckItem;

import java.util.List;
import java.util.Map;

@Mapper
public interface CheckGroupDao {

    void addCheckGroup(CheckGroup checkGroup);

    void setCheckGroupCheckItem(Map<String, Integer> map);

    Page<CheckGroup> findPage(String queryString);

    void deleteCheckGroup(Integer checkGroupId);

    void deleteCheckGroupCheckItem(Integer checkGroupId);

    Integer[] findCheckGroupCheckItem(Integer checkGroupId);

    void updateCheckGroup(CheckGroup checkGroup);
}
