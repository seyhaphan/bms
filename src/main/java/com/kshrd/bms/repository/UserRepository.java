package com.kshrd.bms.repository;

import com.kshrd.bms.repository.dto.RoleDto;
import com.kshrd.bms.repository.dto.UserDto;
import com.kshrd.bms.repository.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    //TODO: Load User By Username
    @SelectProvider(type = UserProvider.class,method = "loadUserByUsername")
    @Results({
            @Result(column = "user_id",property = "userId"),
            @Result(column = "id",property = "roles",many =
            @Many(select = "selectRolesByUserId"))
    })
    UserDto loadUserByUsername(String email);

    //TODO: Get Roles From Users
    @SelectProvider(type = UserProvider.class, method = "selectRolesByUserIdSql")
    List<RoleDto> selectRolesByUserId(int id);
}
