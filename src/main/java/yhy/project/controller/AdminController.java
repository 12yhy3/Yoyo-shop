package yhy.project.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yhy.project.entity.Admin;
import yhy.project.entity.dto.AdminDTO;
import yhy.project.service.IAdminService;
import yhy.project.util.RedisUtils;
import yhy.project.util.Result;

@RequestMapping({"/api/admin"})
@RestController
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping({"/login"})
    public Result login(@RequestBody Admin admin) {
        if (Strings.isEmpty(admin.getUsername())) {
            return Result.error("用户名不能为空");
        }
        if (Strings.isEmpty(admin.getPassword())) {
            return Result.error("密码不能为空");
        }
        return this.adminService.login(admin.getUsername(), admin.getPassword());
    }

    @GetMapping({"/logout/{token}"})
    public Result loginout(@PathVariable("token") String token) {
        if (Strings.isEmpty(token)) {
            return Result.success();
        }
        if (this.redisUtils.hasKey(token)) {
            this.redisUtils.del(token);
        }
        return Result.success("退出登录");
    }

    @PutMapping({"/updatepwd"})
    public Result updatePassword(@RequestBody AdminDTO adminDTO) {
        return this.adminService.updateAdmin(adminDTO);
    }
}