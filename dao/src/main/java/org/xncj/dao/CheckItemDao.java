package org.xncj.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.xncj.pojo.CheckItem;

import java.util.List;

@Mapper
public interface CheckItemDao {
    void addCheckItem(CheckItem checkItem);

    Page<CheckItem> findPage(String queryString);

    void deleteCheckItem(int checkItemId);

    void updateCheckItem(CheckItem checkItem);

    List<CheckItem> findAll();
}
