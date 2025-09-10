package yhy.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import yhy.project.entity.Admin;

@Mapper
public interface AdminMapper {
    Admin selectAdminByUsername(String username);

    int updateAdmin(Admin admin);

    Admin selectAdminById(Integer id);

    Admin getAdminByUsername(String username);
}
