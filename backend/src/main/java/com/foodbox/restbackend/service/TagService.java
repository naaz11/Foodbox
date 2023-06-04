package com.foodbox.restbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodbox.restbackend.model.Tag;
import com.foodbox.restbackend.repo.TagRepository;

@Service
@Transactional
public class TagService {
	
	//Properties
	private final TagRepository tagRepo;	
	
	//Constructor with Dependency Injection of the Tags Repository	
	@Autowired
	public TagService(TagRepository tagRepo) {		
		this.tagRepo = tagRepo;
		
	}
	
	//CRUD Methods
	public List<Tag> findAllTags() {		
		return tagRepo.findAll();
	}
	
	public Tag addTag(Tag tag) {
		return tagRepo.save(tag);
	}	

	public void updateTagProductCount(Tag tag, int newProductCount) {		
		tag.setProductCount(newProductCount);		
	}

	public Tag updateTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public Tag updateTag(Tag tag, Long id) {		
		if(tag.getId() == id)
			return tagRepo.save(tag);
		return null;
	}

	//must have @Transactional annotation for this to work properly
	public void deleteTag(Long id) {
		tagRepo.deleteTagById(id);		
	}

}//end class
