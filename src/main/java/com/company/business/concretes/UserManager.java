package com.company.business.concretes;

import com.company.business.abstracts.UserService;
import com.company.core.dataAccess.UserDao;
import com.company.core.entities.User;
import com.company.core.utilities.results.DataResult;
import com.company.core.utilities.results.Result;
import com.company.core.utilities.results.SuccessDataResult;
import com.company.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("user added");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),
                "user found");
    }
}
