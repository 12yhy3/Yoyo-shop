package yhy.project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhy.project.entity.Type;
import yhy.project.mapper.GoodsMapper;
import yhy.project.mapper.TypeMapper;
import yhy.project.service.ITypeService;
import yhy.project.util.Result;

import java.util.List;

@Service
/* loaded from: yoyo-shop-1.0-SNAPSHOT.jar:BOOT-INF/classes/tech/deepmind/service/impl/TypeServiceImpl.class */
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Result getTypeList() {
        List<Type> typeList = this.typeMapper.selectTypeList();
        return Result.success(typeList);
    }

    @Override // yhy.project.service.ITypeService
    public Result getAllTypes() {
        return Result.success(this.typeMapper.getAllTypes());
    }

    @Override // yhy.project.service.ITypeService
    public Result selectTypeById(Integer id) {
        return Result.success(this.typeMapper.selectTypeById(id));
    }

    @Override // yhy.project.service.ITypeService
    public Result saveType(Type type) {
        return this.typeMapper.saveType(type) > 0 ? Result.success("添加成功") : Result.success("添加失败");
    }

    @Override // yhy.project.service.ITypeService
    public Result updateType(Type type) {
        return this.typeMapper.updateType(type) > 0 ? Result.success("修改成功") : Result.success("修改失败");
    }

    @Override // yhy.project.service.ITypeService
    @Transactional
    public Result delType(Integer id) {
        int count = this.goodsMapper.getCountByTypeId(id);
        if (count > 0) {
            return Result.error("商品分类下有商品, 不能删除分类");
        }
        return this.typeMapper.delType(id) > 0 ? Result.success("删除成功") : Result.success("删除失败");
    }
}