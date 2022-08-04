package com.shop.tag.service;

import com.shop.tag.entity.TagEntity;
import com.shop.tag.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<TagEntity> getTag(){
        return tagRepository.findAll();
    }

    public TagEntity saveTag(TagEntity tagEntity){
        return tagRepository.save(tagEntity);
    }

    public void deleteTag(Long id){
        tagRepository .deleteById(id);
    }
}
