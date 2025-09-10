package yhy.project.service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhy.project.entity.Admin;
import yhy.project.entity.dto.AdminDTO;
import yhy.project.mapper.AdminMapper;
import yhy.project.service.IAdminService;
import yhy.project.util.RedisUtils;
import yhy.project.util.Result;
import yhy.project.util.SafeUtils;

import java.util.Map;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private ObjectMapper objectMapper;




    @Override
    public Result login(String username, String password) {
        Admin admin = this.adminMapper.selectAdminByUsername(username);
        if (admin == null) {
            return Result.error("户名或密码错误");
        }
        if (password == null) {
            return Result.error("户名或密码错误");
        }
        String pwd = SafeUtils.encode(password);
        if (!pwd.equals(admin.getPassword())) {
            return Result.error("户名或密码错误");
        }
        String token = SafeUtils.encode(admin.getId() + username);
        Map<String, Object> adminMap = (Map) this.objectMapper.convertValue(admin, new TypeReference<Map<String, Object>>() {
        });
        this.redisUtils.hmset(token, adminMap, 7200L);
        return Result.success("登录成功", token);
    }

    @Override    // tips:每次修改代码运行后，在管理员界面修改密码之前必须去后台登录一次，保存token，否则会报错
    public Result updateAdmin(AdminDTO adminDTO) {
        try {
            String newpassword = adminDTO.getNewPwd();
            if (newpassword.length() < 6) {
                return Result.error("新密码长度必须大于等于6,请重新输入");
            }

            String newPwd = SafeUtils.encode(adminDTO.getNewPwd());
            String pwd = SafeUtils.encode(adminDTO.getPassword());
            Integer adminId = (Integer) this.redisUtils.hmget(adminDTO.getToken()).get("id");
            adminDTO.setId(adminId);

            Admin admin = adminMapper.selectAdminById(adminId);
            if (admin == null) {
                return Result.error("未找到对应管理员信息");
            }

            if (!admin.getPassword().equals(pwd)) {
                return Result.error("原密码不正确,请重新输入");
            }
            adminDTO.setPassword(newPwd);
            int updateResult = adminMapper.updateAdmin(adminDTO);
            return updateResult > 0 ? Result.success("修改成功") : Result.error("修改失败");
        } catch (Exception e) {
            return Result.error("系统错误，请稍后再试");
        }
    }
}