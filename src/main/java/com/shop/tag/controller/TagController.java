package com.shop.tag.controller;

import com.shop.tag.entity.TagEntity;
import com.shop.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public List<TagEntity> getOrderList(){
        return tagService.getTag();
    }

    @PostMapping
    public TagEntity saveOrder(@RequestBody TagEntity tagEntity){
        return tagService.saveTag(tagEntity);
    }

    @PutMapping
    public TagEntity updateOrder(@RequestBody TagEntity tagEntity){
        return tagService.saveTag(tagEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id){
        tagService.deleteTag(id);
        return "Deleted successfully";
    }
}
