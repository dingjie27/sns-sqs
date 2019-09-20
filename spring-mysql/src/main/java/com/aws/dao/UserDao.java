//package com.aws.dao;
//
//import com.aws.po.User;
//
//import java.util.List;
//
//@Mapper
//public class UserDao {
//    /**
//     * 列出所有用户信息
//     *
//     * @param name 用户名
//     */
//    @Select("SELECT * FROM testuser ORDER BY UserID")
//    // 返回所有User信息
//    @Results({
//            @Result(property = "id", column = "UserID"),
//            @Result(property = "name", column = "UserName"),
//            @Result(property = "birthday", column = "UserBirth"),
//            @Result(property = "description", column = "Descript")})
//    List<User> showAll();
//
//    /**
//     * 根据UserName查询用户信息
//     *
//     * @param name
//     * @return
//     */
//    @Select("SELECT * FROM testuser WHERE UserName=#{name}")
//    //根据UserName查询User信息
//    @Results({
//            @Result(property = "id", column = "UserID"),
//            @Result(property = "name", column = "UserName"),
//            @Result(property = "birthday", column = "UserBirth"),
//            @Result(property = "description", column = "Descript")})
//    List<User> selectByName(String name);
//
//    //根据UserID查询User信息
//    @Select("SELECT * FROM testuser WHERE UserID=#{id}")
//    @Results({
//            @Result(property = "id", column = "UserID"),
//            @Result(property = "name", column = "UserName"),
//            @Result(property = "birthday", column = "UserBirth"),
//            @Result(property = "description", column = "Descript")})
//    User selectByID(String id);
//
//    /**
//     * 插入新User
//     *
//     * @param user
//     * @return
//     */
//    @SelectKey(keyProperty = "id", keyColumn = "UserID", resultType = String.class, before = true, statement = "select replace(uuid(), '-', '-')")
//    @Options(keyProperty = "id", useGeneratedKeys = true)
//    @Insert("INSERT INTO testuser(UserID,UserName,UserBirth,Descript)"
//            + "VALUES(#{id},#{name},#{birthday},#{description})")
////    @Results({
////        @Result(property = "id", column = "UserID"),
////        @Result(property = "name", column = "UserName"),
////        @Result(property = "birthday", column = "UserBirth"),
////        @Result(property = "description", column = "Descript")})
//    public void addUser(User user);
//
//    /**
//     * 根据用户ID更新用户信息（ID唯一标识）
//     *
//     * @param user
//     */
//
//    @Update("UPDATE testuser SET UserName=#{name},UserBirth=#{birthday},Descript=#{description} WHERE UserID=#{id}")
//    @Results({
//            @Result(property = "id", column = "UserID"),
//            @Result(property = "name", column = "UserName"),
//            @Result(property = "birthday", column = "UserBirth"),
//            @Result(property = "description", column = "Descript")})
//    public void updateByUserID(User user);
//
//    /**
//     * 根据用户ID删除用户信息（ID唯一标识）
//     *
//     * @param id
//     * @return
//     */
//    @Delete("DELETE FROM testuser WHERE UserID=#{id}")
//    public void deleteByUserID(String id);
//}
//
//}
