package org.xncj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xncj.SetMealService;
import org.xncj.common.constant.MessageConstant;
import org.xncj.common.entity.PageResult;
import org.xncj.common.entity.QueryPageBean;
import org.xncj.common.entity.Result;
import org.xncj.common.utils.QiniuUtils;
import org.xncj.pojo.CheckGroup;
import org.xncj.pojo.Setmeal;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName SetMealController
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/10 9:24
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/10 9:24
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */
@RestController
@RequestMapping("/setmeal")
public class SetMealController {
    @Autowired
    private SetMealService setMealService;

    @PostMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile imgFile) throws IOException {
        try {
            //获取上传的文件名
            String fileName = imgFile.getOriginalFilename();
            fileName= UUID.randomUUID().toString()+fileName;
            byte[] bytes = imgFile.getBytes();
            QiniuUtils.upload2Qiniu(bytes, fileName);
            return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS,fileName);
        } catch (IOException e) {
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
        }
    }

    @PostMapping("addSetMeal/{checkgroupIds}")
    public Result addSetMeal(@PathVariable("checkgroupIds") Integer[] checkgroupIds,
                             @RequestBody Setmeal setmeal){
//        try {
            setMealService.addSetMeal(checkgroupIds,setmeal);
            return new Result(true, MessageConstant.ADD_SETMEAL_SUCCESS);
//        } catch (Exception e) {
//            return new Result(false, MessageConstant.ADD_SETMEAL_FAIL);
//        }
    }

    @GetMapping("/findAll")
    public Result findAll(){
        List<CheckGroup> setmealList=setMealService.findAll();
        return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,setmealList);
    }

    @PostMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult page = setMealService.findPage(queryPageBean);
        return page;
    }
}
