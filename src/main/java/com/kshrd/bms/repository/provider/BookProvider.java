package com.kshrd.bms.repository.provider;

import com.kshrd.bms.utilities.Pagination;
import org.apache.ibatis.jdbc.SQL;

public class BookProvider {

    public String findAllSql(Pagination pagination){
        return new SQL(){{
            SELECT("b.id id,b.title title, b.author,author,b.description description,b.thumbnail thumbnail, c.id cid,c.title c_title");
            FROM("tb_books b");
            INNER_JOIN("tb_categories c on b.category_id = c.id ORDER BY b.id desc");
            LIMIT(pagination.getLimit());
            OFFSET(pagination.getOffset());

        }}.toString();
    }

    public String findById(){
        return new SQL(){{
            SELECT("b.id id,b.title title, b.author,author,b.description description,b.thumbnail thumbnail, c.id cid,c.title c_title");
            FROM("tb_books b");
            INNER_JOIN("tb_categories c on b.category_id = c.id");
            WHERE("b.id = #{id}");
        }}.toString();
    }

    public String insertSql(){
        return new SQL(){{
            INSERT_INTO("tb_books");
            VALUES("title","#{name}");
            VALUES("author","#{author}");
            VALUES("description","#{description}");
            VALUES("thumbnail","#{thumbnail}");
            VALUES("category_id","#{category.id}");;

        }}.toString();
    }

    public String deleteSql(){
        return new SQL(){{
            DELETE_FROM("tb_books");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String updateSql(){
        return new SQL(){{
            UPDATE("tb_books");
            SET("title = #{book.name}",
                    "author = #{book.author}",
                    "description = #{book.description}",
                    "thumbnail = #{book.thumbnail}",
                    "category_id = #{book.category.id}"
            );
            WHERE("id = #{id}");
        }}.toString();
    }

    public String filterByNameSql(){
        return new SQL(){{
            SELECT("b.id id,b.title title, b.author,author,b.description description,b.thumbnail thumbnail, c.id cid,c.title c_title");
            FROM("tb_books b");
            INNER_JOIN("tb_categories c on b.category_id = c.id");
            WHERE("b.title like #{name} || '%'");
        }}.toString();
    }

    public String filterByCategorySql(){
        return new SQL(){{
            SELECT("b.id id,b.title title, b.author,author,b.description description,b.thumbnail thumbnail, c.id cid,c.title c_title");
            FROM("tb_books b");
            INNER_JOIN("tb_categories c on b.category_id = c.id");
            WHERE("c.id = #{categoryId}");
        }}.toString();
    }

    public String filterBook(Pagination pagination) {
        return new SQL(){{
            SELECT("b.id id,b.title title, b.author,author,b.description description,b.thumbnail thumbnail, c.id cid,c.title c_title");
            FROM("tb_books b");
            INNER_JOIN("tb_categories c on b.category_id = c.id");
            WHERE("c.id = #{categoryId}");
            AND();
            WHERE("b.title like #{name} || '%'");
        }}.toString();
    }
}
