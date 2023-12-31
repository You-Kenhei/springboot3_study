package com.youkenhei.controller;

import com.youkenhei.anno.Log;
import com.youkenhei.pojo.Dept;
import com.youkenhei.pojo.Result;
import com.youkenhei.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> data = deptService.list();
        return Result.success(data);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门:{}", id);
        deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("通过ID查询部门信息");
        Dept data = deptService.getById(id);
        return Result.success(data);
    }

    @Log
    @PutMapping
    public Result alter(@RequestBody Dept dept){
        log.info("修改部门信息：{}",dept);
        deptService.alert(dept);
        return Result.success();
    }
}
