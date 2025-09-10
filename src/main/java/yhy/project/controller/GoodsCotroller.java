package yhy.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yhy.project.entity.Goods;
import yhy.project.entity.Top;
import yhy.project.service.IGoodsService;
import yhy.project.service.ITopService;
import yhy.project.util.Result;

@RequestMapping({"/api/goods"})
@RestController
public class GoodsCotroller {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ITopService topService;

    @GetMapping({"/detail/{id}"})
    public Result getGoodsById(@PathVariable("id") int id) {
        return this.goodsService.getGoodsById(id);
    }

    @GetMapping({"/ranking"})
    public Result getGoodsRanking() {
        return this.goodsService.getGoodsRanking();
    }

    @GetMapping({"/lists"})
    public Result getGoods(Integer page, Integer limit, String name, Integer typeId, Integer type) {
        if (page == null) {
            page = 0;
        }
        if (limit == null) {
            limit = 10;
        }
        return this.goodsService.getGoods(page, limit, name, typeId, type);
    }

    @PostMapping({"/updateTypes"})
    public Result updateTypes(Integer tid, Integer types) {
        return this.topService.updateTypes(tid, types);
    }

    @PostMapping({"/saveGoods"})
    public Result saveGoods(@RequestBody Goods goods) {
        return this.goodsService.saveGoods(goods);
    }

    @PutMapping({"/updateGoods"})
    public Result updateGoods(@RequestBody Goods goods) {
        return this.goodsService.updateGoods(goods);
    }

    @PutMapping({"/updateTopType"})
    public Result updateTopType(@RequestBody Top top) {
        return this.topService.updateTypes(top.getId(), top.getType());
    }

    @DeleteMapping({"/delGoods/{id}"})
    public Result delGoods(@PathVariable Integer id) {
        return this.goodsService.delGoods(id);
    }
}