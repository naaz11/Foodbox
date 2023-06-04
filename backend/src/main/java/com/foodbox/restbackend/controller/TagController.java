package com.foodbox.restbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.restbackend.model.Tag;
import com.foodbox.restbackend.model.Product;
import com.foodbox.restbackend.service.TagService;
import com.foodbox.restbackend.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/tags")
public class TagController {
	
	//Properties
	private final TagService tagService;
	private final ProductService productService;

	//Constructor with Dependency Injection	
	public TagController(TagService tagService, ProductService productService) {		
		this.tagService = tagService;
		this.productService = productService;
	} 
	
	//REST Endpoints
	@GetMapping(path="/all")
	public ResponseEntity<List<Tag>> getAllTags(){
		List<Tag> currentTags = tagService.findAllTags();
		List<Product> products = productService.findAllProducts();
		int tagCount=0, productCount=0;
		
		for(Tag c : currentTags) {
			System.out.println("Tag Id: " + c.getId() + ", Tag Name = " + c.getTagName());
			System.out.println("------------------------------------");
			
			if(c.getTagName().toLowerCase().equals("all")) {
				System.out.println("setting count of all products");
				productCount = productService.findAllProducts().size();
				tagService.updateTagProductCount(c, productCount);
			}
			else {
				for(Product p : products) {
					for(int i=0; i<p.getTags().length; i++) {
						if(p.tags[i].equals(c.getTagName())) {
							System.out.println("\tProduct " + p.getId() + " - " + p.getProductName());
							tagCount++;
						}//end if
					}//end product tags					
				}//end products	
				tagService.updateTagProductCount(c, tagCount);
				tagCount=0; //reset
			}//end else
		}//end Tag for loop
		
		return new ResponseEntity<>(currentTags, HttpStatus.OK);
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<Tag> addTag(@RequestBody Tag tag){
		Tag newTag = tag;
		tagService.addTag(newTag);
		return new ResponseEntity<>(newTag, HttpStatus.CREATED);
	}
	
	/* Method to update Tag stored in the database */
	@PutMapping("/tag/update/{id}")
	public ResponseEntity<Tag> updateTagProductCount(@RequestBody Tag tag, @PathVariable("id") Long id){
		System.out.println("Tag Passed In:\n" + tag.toString());
		System.out.println("Id Passed In:" + id);
		Tag updatedTag = tagService.updateTag(tag);
		return new ResponseEntity<>(updatedTag, HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/tag/delete/{id}")	
    public ResponseEntity<?> deleteCousine(@PathVariable("id") Long id){
		tagService.deleteTag(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}//end class
