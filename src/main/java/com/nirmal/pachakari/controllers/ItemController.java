package com.nirmal.pachakari.controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nirmal.pachakari.errors.ItemException;
import com.nirmal.pachakari.integration.CamelIntegrator;
import com.nirmal.pachakari.model.Item;
import com.nirmal.pachakari.service.ItemService;

@RestController
@RequestMapping(path="/api")
public class ItemController {
	
	@Qualifier("item1")
	ItemService itemService;
	@Value("${image.path}")
	public String filePath;
	
	@Value("${thumbnail.path}")
	public String thumbnailPath;
	
	@Autowired
	CamelIntegrator camelIntegrator;
	 
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@PreAuthorize("hasRole('CREATE')")
	@PostMapping(value="/item",consumes=MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> addItem(Item item) throws ItemException{	
		System.out.println(item);
		try {
			byte[] bytes = item.getFile().getBytes();
			String imageName = item.getFile().getOriginalFilename();
			Path path = Paths.get(filePath + imageName);
			Files.write(path, bytes);
			item.setImageName(imageName);
			item = itemService.addItem(item);
			item.setFile(null);
		}catch(IOException ex){
			ex.printStackTrace();
		}
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('VIEW_ALL')")
	@GetMapping("/items")
	public ResponseEntity<?> getItems(){
		List<Item> items = itemService.getItems();
		System.out.println(items);
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('VIEW_ALL')")
	@GetMapping(value="/thumbnail/{imageName}")
	public String  getThumbnail(@PathVariable("imageName") String imageName) throws IOException  {
		InputStream  in = new FileInputStream(new File(thumbnailPath + imageName+"-thmb.jpg"));
		byte[] bytes = IOUtils.toByteArray(in);
		//Path path = Paths.get("C:\\pachakariuploads\\text.jpg");
		//Files.write(path, bytes);
		return "data:image/jpg;base64," + new String(Base64.getEncoder().encode(bytes));
		
	}
	

	/*private ItemService getItemService() {
			return new ItemService() {
				@Override
				public boolean addItem(Item item) {
					return itemDAO.addItem(item) > 0 ? true: false;
				}				
			};
	}*/
	
	
}
