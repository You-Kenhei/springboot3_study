package com.youkenhei.mapper;

import com.youkenhei.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /*
    @Select("select count(*) from tlias.emp")
    Integer count();

    @Select("select * from tlias.emp limit #{start},#{pageSize}")
    List<Emp> page(Integer start, Integer pageSize);
    */

    /**
     * 员工信息查询，以及pageHelper分页所用
     */
//    @Select("select * from tlias.emp")
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    @Insert("insert into tlias.emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void sava(Emp emp);

    @Select("select * from tlias.emp where id = #{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    @Select("select * from tlias.emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    @Delete("delete from tlias.emp where dept_id = #{dept_id}")
    void deleteByDeptId(Integer dept_id);
}
