package com.nirmal.pachakari.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nirmal.pachakari.integration.CamelIntegrator;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
	@Autowired
	CamelIntegrator camelIntegrator;
	
	@Value("${image.path}")
	public String filePath;

	@GetMapping("/file")
	public String fileUpload() {
		return "upload";
	}

	@PostMapping("/fileupload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		if(file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
			return "redirect:/upload/uploadStatus";
		}
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);
			camelIntegrator.processImage();
			redirectAttributes.addFlashAttribute("message", "Successfully uploaded file "+file.getOriginalFilename());
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		return "redirect:/upload/uploadStatus";
	}
	
	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
}
