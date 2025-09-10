package yhy.project.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yhy.project.entity.Goods;
import yhy.project.entity.dto.GoodsDTO;
import yhy.project.entity.vo.GoodsVo;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> selectGoodsByTopType(Integer topType);

    List<Goods> selectGoodsByTypeId(@Param("typeId") Integer typeId, @Param("startIndex") Integer startIndex, @Param("size") Integer size);

    Long selectGoodsCountByTypeId(Integer typeId);

    List<Goods> selectGoodsByTopTypeAndPage(@Param("topType") Integer topType, @Param("startIndex") Integer startIndex, @Param("size") Integer size);

    Long selectGoodsCountByTopType(Integer topType);

    GoodsVo selectGoodsById(Integer id);

    List<Goods> selectGoodsRanking();

    List<Goods> selectGoodsByName(@Param("name") String name, @Param("startIndex") Integer startIndex, @Param("size") Integer size);

    Long selectGoodsCountByName(String name);

    int updateGoodsStockById(@Param("id") Integer id, @Param("changeNum") Integer changeNum);

    List<GoodsDTO> selectGoods(@Param("name") String name, @Param("typeId") Integer typeId, @Param("types") Integer types);

    int saveGoods(Goods goods);

    int updateGoods(Goods goods);

    int delGoods(Integer id);

    int getCountByTypeId(Integer tid);

    List<GoodsDTO> lists(String name);//查询所有商品和对应的榜单top表
}