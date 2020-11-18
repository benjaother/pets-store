package com.upemor.petsorerest.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upemor.petsorerest.model.Category;
import com.upemor.petsorerest.model.Tag;
import com.upemor.petsorerest.model.User;
import com.upemor.petsorerest.service.CategoryService;
import com.upemor.petsorerest.service.TagService;
import com.upemor.petsorerest.service.UserService;

@Component
public class AdminCreator {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private CategoryService catService;
	
	@PostConstruct
	public void adminCreate() {
		if(!userService.existsUserByEmail("admin@localhost.com")) {
			User user = new User("admin","admin","admin","admin@localhost.com","admin",true,"ADMIN", null);
			userService.createUser(user);
		}
		
		Category category = new Category();
		category.setName("De compañia");
		
		Tag tag = new Tag();
		tag.setName("Raza pequeña");
		
		Category category2 = new Category();
		category2.setName("De Rescate");
		
		Tag tag2 = new Tag();
		tag2.setName("Raza Grande");
		
		tagService.createTag(tag);
		catService.createCategory(category);
		tagService.createTag(tag2);
		catService.createCategory(category2);
		
	}

}