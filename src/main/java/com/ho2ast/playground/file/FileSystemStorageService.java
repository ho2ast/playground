package com.ho2ast.playground.file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService {

  private final Path rootLocation;

  public FileSystemStorageService(StorageProperty storageProperty) {
    this.rootLocation = Paths.get(storageProperty.getLocation());
  }

  @Override
  public void store(MultipartFile file) {
    try {
      if (file.isEmpty()) {
        throw new RuntimeException("Failed to store empty file.");
      }
      Path destinationFile = this.rootLocation.resolve(
              Paths.get(file.getOriginalFilename()))
          .normalize().toAbsolutePath();

      if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
        // This is a security check
        throw new RuntimeException(
            "Cannot store file outside current directory.");
      }

      try (InputStream inputStream = file.getInputStream()) {
        Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to store file.", e);
    }
  }
}
