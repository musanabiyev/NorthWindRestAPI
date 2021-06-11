package com.company.business.abstracts;

import com.company.core.entities.User;
import com.company.core.utilities.results.DataResult;
import com.company.core.utilities.results.Result;

public interface UserService {
    Result add(User user);

    DataResult<User> findByEmail(String email);
}
