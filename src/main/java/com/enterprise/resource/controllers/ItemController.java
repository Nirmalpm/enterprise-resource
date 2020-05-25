package com.enterprise.resource.controllers;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.resource.errors.ItemException;
import com.enterprise.resource.integration.CamelIntegrator;
import com.enterprise.resource.model.Item;
import com.enterprise.resource.model.PurchaseItem;
import com.enterprise.resource.service.ItemService;

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
			if(item.getFile() !=null ) {
				byte[] bytes = item.getFile().getBytes();
				String imageName = item.getFile().getOriginalFilename();
				Path path = Paths.get(filePath + imageName);
				Files.write(path, bytes);
				item.setImageName(imageName);
			}			
			item = itemService.addItem(item);
			item.setFile(null);
		}catch(IOException ex){
			ex.printStackTrace();
		}
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('VIEW_ALL')")
	@GetMapping("/items/{enterpriseId}")
	public ResponseEntity<?> getItems(@PathVariable("enterpriseId") Integer enterpriseId){
		List<Item> items = itemService.getItems(enterpriseId);
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
	
	@PreAuthorize("hasRole('VIEW_ALL')")
	@PostMapping(value="/cart",consumes= MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addToShoppingCart(@RequestBody PurchaseItem item) {
		List<PurchaseItem> items = itemService.addToCart(item,item.getUser());
		return new ResponseEntity<>(items,HttpStatus.OK);		
	}
	
	@PreAuthorize("hasRole('VIEW_ALL')")
	@DeleteMapping("/cart/{id}")
	public ResponseEntity<List<PurchaseItem>> deleteFromShoppingCart(@PathVariable("id") Integer id, @RequestParam String user ) {
		List<PurchaseItem> items = itemService.removeFromCart(id,user);
		return new ResponseEntity<>(items,HttpStatus.OK);		
	}
	
	@PreAuthorize("hasRole('VIEW_ALL')")
	@DeleteMapping("/cart")
	public ResponseEntity<HttpStatus> deleteShoppingCart( @RequestParam String user ) {
		itemService.removeAllFromCart(user);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	@PreAuthorize("hasRole('VIEW_ALL')")
	@GetMapping(value="/cartitems", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PurchaseItem>> getCartItems( @RequestParam String user ) {
		List<PurchaseItem> items = itemService.getAllCartItems(user);
		return new ResponseEntity<>(items,HttpStatus.OK);		
	}
	
	
}
