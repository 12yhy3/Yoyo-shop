package yhy.project.service;

import yhy.project.entity.Type;
import yhy.project.util.Result;

public interface ITypeService {
    Result getTypeList();

    Result getAllTypes();

    Result selectTypeById(Integer id);

    Result saveType(Type type);

    Result updateType(Type type);

    Result delType(Integer id);
}