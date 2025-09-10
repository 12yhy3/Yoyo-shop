package yhy.project.service;

import yhy.project.entity.Goods;
import yhy.project.entity.dto.GoodsDTO;
import yhy.project.util.Result;

import java.util.List;

public interface IGoodsService {
    Result getGoodsListByTopType(int topType);

    Result getGoodsListByTypeId(int typeId, int page, int size);

    Result getGoodsListByTopType(int topType, int page, int size);

    Result getGoodsById(int id);

    Result getGoodsRanking();

    Result getGoodsByName(String name, int page, int size);

    Result getGoods(Integer page, Integer limit, String name, Integer typeId, Integer type);

    Result saveGoods(Goods goods);

    Result updateGoods(Goods goods);

    Result delGoods(Integer id);


    List<GoodsDTO> lists(String name);//查询所有商品和对应的榜单top表
}
