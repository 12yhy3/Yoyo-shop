package yhy.project.service;

import yhy.project.entity.User;
import yhy.project.util.Result;
public interface IUserService {
    Result isUserExistByUsername(String username);
    Result isUserExistByPhone(String phone);
    Result register(User user);
    Result login(String username, String password);
    Result getUserInfo(String token);
    Result resetPwd(String password, String phone);
    Result updateUser(User user);


    Result lists(Integer page, Integer limit);

    Result getUserById(Integer id);


    Result updateUserStatus(User user);
    Result delUser(Integer id);

    Result getUser(Integer page, Integer limit, String name);
}
