package yhy.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import yhy.project.entity.Item;

import java.util.List;

@Mapper
/* loaded from: yoyo-shop-1.0-SNAPSHOT.jar:BOOT-INF/classes/tech/deepmind/mapper/ItemMapper.class */
public interface ItemMapper {
    int insertItemsBatch(List<Item> item);

    List<Item> selectItemsByOrderId(Integer orderId);
}