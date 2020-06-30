package com.kshrd.bms.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String loadUserByUsername(){
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("email = #{email}");
        }}.toString();
    }

    public String selectRolesByUserIdSql(){
        return new SQL(){{
            SELECT("r.id as id, name");
            FROM("roles r");
            INNER_JOIN("users_roles ur on r.id = ur.roles_id");
            WHERE("ur.user_id = #{id}");
        }}.toString();
    }
}
