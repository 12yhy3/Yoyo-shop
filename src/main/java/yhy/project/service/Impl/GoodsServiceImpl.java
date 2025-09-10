package yhy.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhy.project.entity.Goods;
import yhy.project.entity.Top;
import yhy.project.entity.Type;
import yhy.project.entity.dto.GoodsDTO;
import yhy.project.entity.vo.GoodsVo;
import yhy.project.mapper.GoodsMapper;
import yhy.project.mapper.TopMapper;
import yhy.project.mapper.TypeMapper;
import yhy.project.service.IGoodsService;
import yhy.project.util.Result;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private TopMapper topMapper;

    @Override // yhy.project.service.IGoodsService
    public Result getGoodsListByTopType(int topType) {
        List<Goods> goodsList = this.goodsMapper.selectGoodsByTopType(Integer.valueOf(topType));
        return Result.success(goodsList);
    }

    @Override // yhy.project.service.IGoodsService
    public Result getGoodsListByTypeId(int typeId, int page, int size) {
        List<Goods> goodsList = this.goodsMapper.selectGoodsByTypeId(Integer.valueOf(typeId), Integer.valueOf((page - 1) * size), Integer.valueOf(size));
        Long count = this.goodsMapper.selectGoodsCountByTypeId(Integer.valueOf(typeId));
        Type type = this.typeMapper.selectTypeById(Integer.valueOf(typeId));
        return Result.success(Map.of("goods", goodsList, "count", count, "type", type));
    }

    @Override // yhy.project.service.IGoodsService
    public Result getGoodsListByTopType(int topType, int page, int size) {
        List<Goods> goodsList = this.goodsMapper.selectGoodsByTopTypeAndPage(Integer.valueOf(topType), Integer.valueOf((page - 1) * size), Integer.valueOf(size));
        Long count = this.goodsMapper.selectGoodsCountByTopType(Integer.valueOf(topType));
        Map<String, Object> map = Map.of("goods", goodsList, "count", count);
        map.entrySet().stream().forEach(entry -> {
            System.out.println(((String) entry.getKey()) + "\t" + entry.getValue());
        });
        return Result.success(Map.of("goods", goodsList, "count", count));
    }

    @Override // yhy.project.service.IGoodsService
    public Result getGoodsById(int id) {
        GoodsVo goods = this.goodsMapper.selectGoodsById(Integer.valueOf(id));
        if (goods != null) {
            Integer typeId = goods.getTypeId();
            Type type = this.typeMapper.selectTypeById(typeId);
            goods.setType(type);
            return Result.success(goods);
        }
        return Result.error("商品不存在");
    }

    @Override // yhy.project.service.IGoodsService
    public Result getGoodsRanking() {
        List<Goods> goodsList = this.goodsMapper.selectGoodsRanking();
        return Result.success(goodsList);
    }

    @Override // yhy.project.service.IGoodsService
    public Result getGoodsByName(String name, int page, int size) {
        List<Goods> goodsList = this.goodsMapper.selectGoodsByName(name, Integer.valueOf((page - 1) * size), Integer.valueOf(size));
        Long count = this.goodsMapper.selectGoodsCountByName(name);
        return Result.success(Map.of("goods", goodsList, "count", count));
    }

    @Override // yhy.project.service.IGoodsService
    public Result getGoods(Integer page, Integer limit, String name, Integer typeId, Integer type) {
        PageHelper.startPage(page.intValue(), limit.intValue());
        List<GoodsDTO> goodsDTOList = this.goodsMapper.selectGoods(name, typeId, type);
        PageInfo<GoodsDTO> pageInfo = new PageInfo<>(goodsDTOList);
        return Result.success(pageInfo);
    }

    @Override // yhy.project.service.IGoodsService
    @Transactional
    public Result saveGoods(Goods goods) {
        this.goodsMapper.saveGoods(goods);
        Top top = new Top();
        top.setGoodsId(goods.getId());
        top.setType(3);
        this.topMapper.saveTop(top);
        return Result.success("添加成功");
    }

    @Override // yhy.project.service.IGoodsService
    public Result updateGoods(Goods goods) {
        return this.goodsMapper.updateGoods(goods) > 0 ? Result.success("修改成功") : Result.success("修改失败");
    }

    @Override // yhy.project.service.IGoodsService
    public Result delGoods(Integer id) {
        return this.goodsMapper.delGoods(id) > 0 ? Result.success("删除成功") : Result.success("删除失败");
    }

    @Override
    public List<GoodsDTO> lists(String name) {
        return goodsMapper.lists(name);
    }
}