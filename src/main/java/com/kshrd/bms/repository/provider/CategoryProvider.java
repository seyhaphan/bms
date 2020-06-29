package com.kshrd.bms.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class CategoryProvider {

    public String findAllSql(){
        return new SQL(){{
            SELECT("*");
            FROM("tb_categories");
        }}.toString();
    }

    public String insertSql(){
        return new SQL(){{
            INSERT_INTO("tb_categories");
            VALUES("title","#{name}");
        }}.toString();
    }

    public String findCategoryById(){
        return new SQL(){{
            SELECT("*");
            FROM("tb_categories");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String deleteSql(){
        return new SQL(){{
            DELETE_FROM("tb_categories");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String updateSql(){
        return new SQL(){{
            UPDATE("tb_categories");
            SET("title = #{category.name}");
            WHERE("id = #{id}");
        }}.toString();
    }
}
