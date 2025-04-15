package com.ho2ast.playground.file;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

  void store(MultipartFile file);

}
