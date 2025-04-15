package com.ho2ast.playground.file;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("store")
public class StorageProperty {

  /**
   * Folder location for storing files
   */
  private String location = "upload-dir";

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

}
