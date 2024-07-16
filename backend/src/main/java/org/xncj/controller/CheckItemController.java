package org.xncj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xncj.CheckItemService;
import org.xncj.common.constant.MessageConstant;
import org.xncj.common.entity.PageResult;
import org.xncj.common.entity.QueryPageBean;
import org.xncj.common.entity.Result;
import org.xncj.pojo.CheckItem;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/checkItem")
public class CheckItemController {
    @Autowired
    public CheckItemService checkItemService;
    @PostMapping("/addCheckItem")
    public Result addCheckItem(@RequestBody CheckItem checkItem){
        try {
            checkItemService.addCheckItem(checkItem);
        }catch (Exception e){
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS);
    }
    @PostMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = checkItemService.findPage(queryPageBean);
        return pageResult;
    }

    @DeleteMapping("/deleteCheckItem/{checkItemId}")
    public Result deleteCheckItem(@PathVariable("checkItemId") int checkItemId){
        try {
            checkItemService.deleteCheckItem(checkItemId);
        } catch (Exception e) {
            return new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }

    @PutMapping("/updateCheckItem")
    public Result updateCheckItem(@RequestBody CheckItem checkItem){
        checkItemService.updateCheckItem(checkItem);
        return new Result(true,MessageConstant.EDIT_CHECKGROUP_SUCCESS);
    }

    @GetMapping("/findAll")
    public Result findAll(){
        List<CheckItem> checkItems=checkItemService.findAll();
        return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItems);
    }
}
