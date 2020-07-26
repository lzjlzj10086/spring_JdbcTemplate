package com.service;

import com.dao.impl.AccountDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountService {

    @Resource
    private AccountDao accountDao;

    public void test(){
        int money = 500;
        accountDao.out("tom",money);
        accountDao.in("bob",money);
    }
}
