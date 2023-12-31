package com.youkenhei.mapper;

import com.youkenhei.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from tlias.dept")
    public List<Dept> list();

    @Delete("delete from tlias.dept where id = #{id}")
    public void deleteById(Integer id);

    @Insert("insert into tlias.dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Update("update tlias.dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void alert(Dept dept);

    @Select("select * from tlias.dept where id = #{id}")
    Dept getById(Integer id);
}
