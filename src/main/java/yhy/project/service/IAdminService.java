package yhy.project.service;

import yhy.project.entity.dto.AdminDTO;
import yhy.project.util.Result;

public interface IAdminService {


    Result login(String username, String password);
    Result updateAdmin(AdminDTO adminDTO);

}