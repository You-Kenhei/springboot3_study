package com.youkenhei.mapper;

import com.youkenhei.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {

    @Insert("insert into tlias.dept_log(create_time, description) values (#{createTime}, #{description})")
    void insert(DeptLog deptLog);
}
