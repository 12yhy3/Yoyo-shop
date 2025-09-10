package yhy.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import yhy.project.entity.Type;

import java.util.List;

@Mapper
public interface TypeMapper {
    List<Type> selectTypeList();

    List<Type> getAllTypes();

    Type selectTypeById(Integer id);

    int saveType(Type type);

    int updateType(Type type);

    int delType(Integer id);
}