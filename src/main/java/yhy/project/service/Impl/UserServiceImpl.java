package yhy.project.service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhy.project.entity.User;
import yhy.project.mapper.UserMapper;
import yhy.project.service.IUserService;
import yhy.project.util.RedisUtils;
import yhy.project.util.Result;
import yhy.project.util.SafeUtils;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Result isUserExistByUsername(String username) {
        User user = this.userMapper.selectUserByUsername(username);
        if (user == null) {
            return Result.success("用户名可用");
        }
        return Result.error("用户名已被占用");
    }

    @Override // yhy.project.service.IUserService
    public Result isUserExistByPhone(String phone) {
        User user = this.userMapper.selectUserByPhone(phone);
        if (user == null) {
            return Result.success("手机号可用");
        }
        return Result.error("手机号已被占用");
    }

    @Override // yhy.project.service.IUserService
    public Result register(User user) {
        user.setPassword(SafeUtils.encode(user.getPassword()));
        int row = this.userMapper.insertUser(user);
        if (row > 0) {
            return Result.success("注册成功");
        }
        return Result.error("注册失败");
    }

    @Override // yhy.project.service.IUserService
    public Result login(String username, String password) {
        User user = this.userMapper.selectUserByUsernameAndPassword(username, SafeUtils.encode(password));
        if (user == null) {
            return Result.error("用户名或密码错误");
        }
        String token = SafeUtils.encode(user.getId() + username);
        Map<String, Object> userMap = (Map) this.objectMapper.convertValue(user, new TypeReference<Map<String, Object>>() { // from class: yhy.project.service.impl.UserServiceImpl.1
        });
        this.redisUtils.hmset(token, userMap, 7200L);
        return Result.success("登录成功", token);
    }

    @Override // yhy.project.service.IUserService
    public Result getUserInfo(String token) {
        Map<Object, Object> map = this.redisUtils.hmget(token);
        Integer userId = (Integer) map.get("id");
        User user = this.userMapper.selectUserById(userId);
        return Result.success(user);
    }

    @Override // yhy.project.service.IUserService
    public Result resetPwd(String password, String phone) {
        return this.userMapper.updateUserPwd(SafeUtils.encode(password), phone) > 0 ? Result.success() : Result.error();
    }

    @Override // yhy.project.service.IUserService
    public Result updateUser(User user) {
        User user2 = this.userMapper.selectUserById(user.getId());
        if (user2 == null) {
            return Result.error("用户不存在");
        }
        user2.setName(user.getName());
        user2.setPhone(user.getPhone());
        user2.setAddress(user.getAddress());
        if (this.userMapper.updateUserInfo(user2) > 0) {
            return Result.success();
        }
        return Result.error("修改用户信息失败");
    }



    @Override
    public Result lists(Integer page, Integer limit) {
        PageHelper.startPage(page.intValue(), limit.intValue());
        List<User> userList = this.userMapper.lists();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return Result.success(pageInfo);
    }

    @Override // yhy.project.service.IUserService
    public Result getUserById(Integer id) {
        User user = this.userMapper.selectUserById(id);
        return Result.success(user);
    }



    @Override // yhy.project.service.IUserService
    public Result updateUserStatus(User user) {
        return this.userMapper.updateUserStatus(user) > 0 ? Result.success("成功") : Result.success("失败");
    }

    @Override // yhy.project.service.IUserService
    public Result delUser(Integer id) {
        return this.userMapper.delUser(id) > 0 ? Result.success("删除成功") : Result.success("删除失败");
    }

    @Override
    public Result getUser(Integer page, Integer limit, String name) {
        PageHelper.startPage(page.intValue(), limit.intValue());
        List<User> userList = this.userMapper.selectUser(name);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return Result.success(pageInfo);
    }
}