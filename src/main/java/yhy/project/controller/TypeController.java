package yhy.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhy.project.entity.Type;
import yhy.project.service.ITypeService;
import yhy.project.util.Result;

@RequestMapping({"/api/type"})
@RestController
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @GetMapping({"/lists"})
    public Result getTypeList() {
        return this.typeService.getTypeList();
    }

    @GetMapping({"/listall"})
    public Result getAllTypes() {
        return this.typeService.getAllTypes();
    }

    @PostMapping({"/saveType"})
    public Result addType(@RequestBody Type type) {
        return this.typeService.saveType(type);
    }

    @PutMapping({"/updateType"})
    public Result updateType(@RequestBody Type type) {
        return this.typeService.updateType(type);
    }

    @GetMapping({"/detail/{id}"})
    public Result getTypeById(@PathVariable Integer id) {
        return this.typeService.selectTypeById(id);
    }

    @DeleteMapping({"/delType/{id}"})
    public Result delType(@PathVariable Integer id) {
        return this.typeService.delType(id);
    }
}