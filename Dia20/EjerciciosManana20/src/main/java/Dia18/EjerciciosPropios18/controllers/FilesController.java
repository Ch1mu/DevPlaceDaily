package Dia18.EjerciciosPropios18.controllers;

import Dia18.EjerciciosPropios18.controllers.services.FilesStorageService;

import Dia18.EjerciciosPropios18.models.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("uploads")
public class FilesController {
	 @Autowired
	 FilesStorageService storageService;
	 
	  @GetMapping()
	 public String index() {
	        return "FilesTemplate/upload";
	  }
	  
	 @PostMapping("/store")
	  public String uploadFile(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttrs) {
	    String message = "";
	    try {
	      storageService.save(file);
	      message = "Added " + file.getOriginalFilename();
	      redirectAttrs
          .addFlashAttribute("Message", message)
          .addFlashAttribute("Class", "success");
	      return "redirect:/uploads";
	    } catch (Exception e) {
	      message = "Error at uploading the file: " + file.getOriginalFilename() + "!";
	      redirectAttrs
          .addFlashAttribute("Message", message)
          .addFlashAttribute("Class", "success");
	      return "redirect:/uploads";
	      }
	  }

	  @GetMapping("/list")
	  public String getListFiles(Model model) {
	    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
	      String filename = path.getFileName().toString();
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
	      return new FileInfo(filename, url);
	    }).collect(Collectors.toList());
	    model.addAttribute("listfiles", fileInfos); 
        return "list_files";
	  }
	  
	  @GetMapping("/files/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	    Resource file = storageService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }
	}