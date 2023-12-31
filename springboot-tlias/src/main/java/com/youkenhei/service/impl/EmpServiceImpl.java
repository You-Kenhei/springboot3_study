package com.youkenhei.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.youkenhei.mapper.EmpMapper;
import com.youkenhei.pojo.Emp;
import com.youkenhei.pojo.PageBean;
import com.youkenhei.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

   /* @Override
    public PageBean page(Integer page, Integer pageSize) {
        Integer count = empMapper.count();
        Integer start = pageSize * (page - 1);
        List<Emp> empList = empMapper.page(start,pageSize);
        return new PageBean(count, empList);
    }*/

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void sava(Emp emp) {
        emp.setCreateTime(LocalDate.now());
        emp.setUpdateTime(LocalDate.now());

        empMapper.sava(emp);
    }

    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDate.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        Emp e = empMapper.getByUsernameAndPassword(emp);
        return e;
    }
}
