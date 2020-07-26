package com.service;

import com.dao.impl.AccountDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AccountService_anno {

    @Resource
    private AccountDao accountDao;
    //@Transactional
    public void test(){
        int money = 500;
        accountDao.out("tom",money);
        accountDao.in("bob",money);
    }
}
