package com.youkenhei.service.impl;

import com.youkenhei.mapper.DeptLogMapper;
import com.youkenhei.pojo.DeptLog;
import com.youkenhei.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Autowired
    private DeptLogMapper deptLogMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
