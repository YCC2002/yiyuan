package org.xncj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xncj.CheckGroupService;
import org.xncj.common.constant.MessageConstant;
import org.xncj.common.entity.PageResult;
import org.xncj.common.entity.QueryPageBean;
import org.xncj.common.entity.Result;
import org.xncj.pojo.CheckGroup;
import org.xncj.pojo.CheckItem;

import java.util.Arrays;

/**
 * @ClassName CheckGroupController
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/8 14:26
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/8 14:26
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */

@RestController
@RequestMapping("/checkGroup")
public class CheckGroupController {
    @Autowired
    private CheckGroupService checkGroupService;

    @PostMapping("/addCheckGroup/{checkitemIds}")
    public Result addCheckGroup(@PathVariable("checkitemIds") Integer[]  checkitemIds,
                                @RequestBody CheckGroup checkGroup) {
        try {
            // 将逗号分隔的字符串解析为Integer数组
//            String[] ids = checkitemIds.split(",");
//            Integer[] idArray = Arrays.stream(ids).map(Integer::parseInt).toArray(Integer[]::new);

            checkGroupService.addCheckGroup(checkitemIds, checkGroup);
        } catch (Exception e) {
            return new  Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }
        return new  Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }


    @PostMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult page = checkGroupService.findPage(queryPageBean);
        return page;
    }

    @DeleteMapping("/deleteCheckGroup/{checkGroupId}")
    public Result deleteCheckGroup(@PathVariable("checkGroupId") Integer checkGroupId) {
        try {
            checkGroupService.deleteCheckGroup(checkGroupId);
        } catch (Exception e) {
            return new Result(false, MessageConstant.DELETE_CHECKGROUP_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_CHECKGROUP_SUCCESS);
    }

    @GetMapping("/findCheckGroupById/{id}")
    public Result findCheckGroupById(@PathVariable("id") Integer CheckGroupId) {
        Integer[] checkItemIds =checkGroupService.findCheckGroupById(CheckGroupId);
        return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS, checkItemIds);
    }

    @PutMapping("/editCheckGroup/{checkitemIds}")
    public Result updateCheckGroup(@PathVariable("checkitemIds") Integer[] checkitemIds,
                                   @RequestBody CheckGroup checkGroup) {

        checkGroupService.updateCheckGroup(checkitemIds, checkGroup);

        return new Result(true, MessageConstant.EDIT_CHECKGROUP_SUCCESS);
    }
}
