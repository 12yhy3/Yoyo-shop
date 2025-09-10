package yhy.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhy.project.service.IGoodsService;
import yhy.project.service.ITypeService;
import yhy.project.util.Result;

@RequestMapping({"/api/index"})
@RestController
public class IndexController {

    @Autowired
    private ITypeService typeService;

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping({"/kinds"})
    public Result getKinds() {
        return this.typeService.getTypeList();
    }

    @GetMapping({"/todayChoice"})
    public Result getTodayChoice() {
        return this.goodsService.getGoodsListByTopType(1);
    }

    @GetMapping({"/recommend"})
    public Result getRecommend(int type) {
        return this.goodsService.getGoodsListByTopType(type);
    }

    @GetMapping({"/kindsGoods"})
    public Result getKindsGoods(int type, int page, int size) {
        return this.goodsService.getGoodsListByTypeId(type, page, size);
    }

    @GetMapping({"/recommendPage"})
    public Result getRecommendPage(int type, int page, int size) {
        return this.goodsService.getGoodsListByTopType(type, page, size);
    }

    @GetMapping({"/search"})
    public Result getSearchGoods(String kw, int page, int size) {
        return this.goodsService.getGoodsByName(kw, page, size);
    }
}