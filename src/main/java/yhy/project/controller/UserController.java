package yhy.project.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yhy.project.entity.User;
import yhy.project.service.IUserService;
import yhy.project.util.RedisUtils;
import yhy.project.util.Result;

@RequestMapping({"/api/user"})
@RestController
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private RedisUtils redisUtils;

    @PostMapping({"/register"})

    public Result register(User user) {
        String username = user.getUsername();
        Result result = this.userService.isUserExistByUsername(username);
        if (result.getCode() != 0) {
            return result;
        }
        return this.userService.register(user);
    }
    /*
        private Result checkUserinfo(User user) {
            String username = user.getUsername();
            if (Strings.isEmpty(username)) {
                return Result.error("用户名不能为空");
            }
            if (username.length() >= 30) {
                return Result.error("用户名长度必须在小于30位");
            }
            String password = user.getPassword();
            if (Strings.isEmpty(password)) {
                return Result.error("密码不能为空");
            }
            if (password.length() < 6 || password.length() > 16) {
                return Result.error("密码长度必须在6-16位之间");
            }
            if (!password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*")) {
                return Result.error("密码必须包含大写、小写和数字");
            }
            String name = user.getName();
            if (Strings.isEmpty(name)) {
                return Result.error("真实姓名不能为空");
            }
            if (name.length() < 2 || name.length() > 10) {
                return Result.error("真实姓名长度必须在2-10位之间");
            }
            String phone = user.getPhone();
            if (!phone.matches("^1[3-9]\\d{9}$")) {
                return Result.error("手机号格式不正确");
            }
            String address = user.getAddress();
            if (Strings.isEmpty(address)) {
                return Result.error("家庭住址不能为空");
            }
            if (address.length() < 10 || address.length() > 100) {
                return Result.error("家庭住址长度必须在10-100位之间");
            }
            return Result.success();
        }
    */
    @PostMapping({"/login"})
    public Result login(String username, String password) {
        if (Strings.isEmpty(username)) {
            return Result.error("用户名不能为空");
        }
        if (Strings.isEmpty(password)) {
            return Result.error("密码不能为空");
        }
        return this.userService.login(username, password);
    }

    @PostMapping({"/checkLogin"})
    public Result checkLogin(String token) {
        if (Strings.isEmpty(token)) {
            return Result.error(6001, "token已经过期");
        }
        return this.redisUtils.hasKey(token) ? Result.success() : Result.error(6001, "token已经过期");
    }

    @PostMapping({"/logout"})
    public Result logout(String token) {
        if (Strings.isEmpty(token)) {
            return Result.success();
        }
        if (this.redisUtils.hasKey(token)) {
            this.redisUtils.del(token);
        }
        return Result.success();
    }

    @PostMapping({"/getUserInfo"})
    public Result getUserInfo(String token) {
        if (Strings.isEmpty(token)) {
            return Result.error(6001, "token已经过期");
        }
        if (this.redisUtils.hasKey(token)) {
            return this.userService.getUserInfo(token);
        }
        return Result.error(6001, "token已经过期");
    }

    @PostMapping({"/checkPhone"})
    public Result checkPhone(String phone) {
        if (Strings.isEmpty(phone) || !phone.matches("^1[3-9]\\d{9}$")) {
            return Result.error("手机号格式不正确");
        }
        Result result = this.userService.isUserExistByPhone(phone);
        if (result.getCode() != 0) {
            return Result.success("手机号存在");
        }
        return Result.error("手机号不存在");
    }

    @PostMapping({"/sendSMS"})
    public Result sendSMS(String phone) {
        if (Strings.isEmpty(phone) || !phone.matches("^1[3-9]\\d{9}$")) {
            return Result.error("手机号格式不正确");
        }
        Result result = this.userService.isUserExistByPhone(phone);
        if (result.getCode() != 0) {
            String captcha = getCaptcha(6);
            this.redisUtils.set(phone, captcha, 300L);
            return Result.success("验证码获取成功", captcha);
        }
        return Result.error("手机号不存在");
    }

    private String getCaptcha(int count) {
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int index = (int) (Math.random() * "1234567890".length());
            captcha.append("1234567890".charAt(index));
        }
        return captcha.toString();
    }

    @PostMapping({"/checkCode"})
    public Result checkCode(String phone, String code) {
        if (Strings.isEmpty(phone) || !phone.matches("^1[3-9]\\d{9}$")) {
            return Result.error("手机号格式不正确");
        }
        if (Strings.isEmpty(code)) {
            return Result.error("验证码不能为空");
        }
        String captcha = (String) this.redisUtils.get(phone);
        if (Strings.isEmpty(captcha)) {
            return Result.error("验证码已过期");
        }
        if (captcha.equals(code)) {
            return Result.success("验证码正确");
        }
        return Result.error("验证码错误");
    }

    @PostMapping({"/resetPwd"})
    public Result resetPwd(String phone, String code, String password, String again_pwd) {
        if (Strings.isEmpty(password) || !password.matches("^[a-zA-Z0-9]{6,16}$")) {
            return Result.error("密码格式不正确");
        }
        if (Strings.isEmpty(again_pwd) || !again_pwd.equals(password)) {
            return Result.error("两次密码不一致");
        }
        this.redisUtils.del(phone);
        if (this.userService.resetPwd(password, phone).getCode() == 0) {
            return Result.success("密码需改成功");
        }
        return Result.error("密码修改失败");
    }

    @PostMapping({"/updateUserInfo"})
    public Result updateUserInfo(User user) {
        if (Strings.isEmpty(user.getToken()) || !this.redisUtils.hasKey(user.getToken())) {
            return Result.error(6001, "token已经过期");
        }
        if (Strings.isEmpty(user.getName())) {
            return Result.error("真实姓名不能为空");
        }
        if (user.getName().length() < 2 || user.getName().length() > 10) {
            return Result.error("真实姓名长度必须在2-10位之间");
        }
        if (!user.getPhone().matches("^1[3-9]\\d{9}$")) {
            return Result.error("手机号格式不正确");
        }
        if (Strings.isEmpty(user.getAddress())) {
            return Result.error("家庭住址不能为空");
        }
        if (user.getAddress().length() < 10 || user.getAddress().length() > 100) {
            return Result.error("家庭住址长度必须在10-100位之间");
        }
        Integer userId = (Integer) this.redisUtils.hmget(user.getToken()).get("id");
        user.setId(userId);
        return this.userService.updateUser(user);
    }

    @GetMapping({"/lists"})
    public Result list(@RequestParam(required = false, defaultValue = "0") Integer page,
                          @RequestParam(required = false, defaultValue = "10") Integer limit,
                          @RequestParam(required = false) String name) {
         if(name == null)
       {
            return this.userService.lists(page, limit);
        }
        return this.userService.getUser(page, limit, name);
    }


    @PostMapping({"/adduser"})
    public Result addUser(@RequestBody User user) {
        String username = user.getUsername();
        Result result = this.userService.isUserExistByUsername(username);
        if (result.getCode() != 0) {
            return result;
        }
        return this.userService.register(user);
    }

    @GetMapping({"/getuserbyid/{id}"})
    public Result getUserById(@PathVariable Integer id) {
        return this.userService.getUserById(id);
    }

    @PutMapping({"/updateUser"})  // 后台管理员修改用户信息
    public Result updateUser(@RequestBody User user) {
        if (Strings.isEmpty(user.getName())) {
            return Result.error("真实姓名不能为空");
        }
        if (user.getName().length() < 2 || user.getName().length() > 10) {
            return Result.error("真实姓名长度必须在2-10位之间");
        }
        if (!user.getPhone().matches("^1[3-9]\\d{9}$")) {
            return Result.error("手机号格式不正确");
        }
        if (Strings.isEmpty(user.getAddress())) {
            return Result.error("家庭住址不能为空");
        }
        if (user.getAddress().length() < 10 || user.getAddress().length() > 100) {
            return Result.error("家庭住址长度必须在10-100位之间");
        }
        return this.userService.updateUser(user);
    }
    @PutMapping({"/updateUserStatus"})
    public Result updateUserStatus(@RequestBody User user) {
        return this.userService.updateUserStatus(user);
    }

    @DeleteMapping({"/delUser"})
    public Result delUser(Integer id) {
        return this.userService.delUser(id);
    }
}