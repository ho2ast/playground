package com.ho2ast.playground.file;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

  private final StorageService storageService;

  public FileController(StorageService storageService) {
    this.storageService = storageService;
  }

  @PostMapping("/")
  public String handleFileUpload(@RequestParam("file") MultipartFile file) {

    storageService.store(file);

    return "stored file";
  }
}
