package yhy.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yhy.project.entity.Top;

@Mapper
/* loaded from: yoyo-shop-1.0-SNAPSHOT.jar:BOOT-INF/classes/tech/deepmind/mapper/TopMapper.class */
public interface TopMapper {
    int updateTop(@Param("id") Integer tid, @Param("type") Integer types);

    int saveTop(Top top);
}