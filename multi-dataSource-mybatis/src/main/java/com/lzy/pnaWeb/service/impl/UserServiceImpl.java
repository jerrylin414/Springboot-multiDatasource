package com.lzy.pnaWeb.service.impl;

import com.lzy.pnaWeb.entity.User1;
import com.lzy.pnaWeb.entity.User2;
import com.lzy.pnaWeb.mapper.primary.User1Mapper;
import com.lzy.pnaWeb.mapper.secondary.User2Mapper;
import com.lzy.pnaWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @Autowired
    TransactionTemplate pTransactionTemplate;
    @Autowired
    TransactionTemplate sTransactionTemplate;

    @Override
    public List<User1> findList() {
        List<User1> list1 = user1Mapper.findList1();

        List<User2> list2 = user2Mapper.findList2();

        return null;
    }

    @Override
    public void insertOne() {
        //For test rollback
        pTransactionTemplate.execute((p) -> {
            sTransactionTemplate.execute((s) -> {
                try {
                    User1 user1 = new User1();
                    user1.setName("insert name1");
                    user1Mapper.insert(user1);
                    System.out.println("success insert ======= " + user1.getName());
//                    int a = 1 / 0;
                    User2 user2 = new User2();
                    user2.setName("insert namw2");
                    user2Mapper.insert(user2);
                    //Make error to test if rollback
                } catch (Exception e) {
                    e.printStackTrace();
                    p.setRollbackOnly();
                    s.setRollbackOnly();
                    return false;
                }
                return true;
            });
            return true;
        });
    }
}
