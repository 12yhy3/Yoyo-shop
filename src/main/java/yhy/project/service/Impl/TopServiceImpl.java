package yhy.project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhy.project.mapper.TopMapper;
import yhy.project.service.ITopService;
import yhy.project.util.Result;

@Service
/* loaded from: yoyo-shop-1.0-SNAPSHOT.jar:BOOT-INF/classes/tech/deepmind/service/impl/TopServiceImpl.class */
public class TopServiceImpl implements ITopService {

    @Autowired
    private TopMapper topMapper;

    @Override // yhy.project.service.ITopService
    public Result updateTypes(Integer id, Integer type) {
        return this.topMapper.updateTop(id, type) > 0 ? Result.success("修改成功") : Result.success("修改失败");
    }
}