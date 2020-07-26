package com.test;

import com.jdbcTemplate.User;
import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTempalte01 {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test01(){
        int row = jdbcTemplate.update("insert into user values (?,?,?)", 8, "alice", "djksfkn");
        System.out.println(row);
    }
    @Test
    public void test02(){
        int row = jdbcTemplate.update("update user set username = ? where id = ?", "springJdbc",8);
        System.out.println(row);
    }
    @Test
    public void test03(){
        int row = jdbcTemplate.update("delete from user where id = ?", 8);
        System.out.println(row);
    }
    @Test
    public void findAllOfList(){
        List<User> userList = jdbcTemplate.query("select *from user", new BeanPropertyRowMapper<User>(User.class));
        System.out.println(userList);
    }
    @Test
    public void findObjectOne(){
        User user = jdbcTemplate.queryForObject("select *from user where id = ?", new BeanPropertyRowMapper<User>(User.class), 5);
        System.out.println(user);
    }
    @Test
    public void findObject(){
        Integer integer = jdbcTemplate.queryForObject("select count(*) from user", int.class);
        System.out.println(integer);
    }
}
