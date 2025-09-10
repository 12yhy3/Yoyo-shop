package yhy.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yhy.project.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    User selectUserByUsername(String username);

    User selectUserByPhone(String phone);

    int insertUser(User user);

    User selectUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User selectUserById(Integer userId);

    int updateUserPwd(String password, String phone);

    int updateUserInfo(User user);

    int updateUserStatus(User user);

    List<User> lists();

    int delUser(Integer id);


    List<User> selectUser(@Param("name") String name);
}