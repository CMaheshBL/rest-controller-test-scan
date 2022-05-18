package com.rest.controller.test.dao;

import com.rest.controller.test.model.User;

public interface IUserDao {

    public static final String GET_USER_BY_EMAIL =
            " SELECT " +
                    "	u.* " +
                    " FROM " +
                    "	users u " +
                    " WHERE " +
                    "	upper(u.email) = upper(:email) ";

    public static final String GET_USER_BY_ID =
            " SELECT " +
                    "	u.* " +
                    " FROM " +
                    "	users u " +
                    " WHERE " +
                    "	u.id = :id ";

    public static final String INSERT_USER =
            "INSERT INTO " +
                    "	users " +
                    "	( " +
                    "		password " +
                    "		,first_name " +
                    "		,email " +
                    "		,info " +
                    "	) " +
                    "VALUES " +
                    "	(	" +
                    "		:password " +
                    "		,:first_name " +
                    "		,:email " +
                    "		,:info " +
                    "	)	";
    boolean insertUser(User user);

    User getUserByEmail(String email);

    User getUserById(long id);
}
