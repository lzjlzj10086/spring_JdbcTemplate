package com.dao.impl;

import com.dao.AccountInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class AccountDao implements AccountInterface {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void in(String name, double money) {
        jdbcTemplate.update("update account set money = money+? where name = ?",money,name);
    }

    public void out(String name, double money) {
        jdbcTemplate.update("update account set money =money - ? where name = ?",money,name);
    }
}
