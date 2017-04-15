package com.deccanherald.service;

import java.nio.file.Path;

import org.springframework.core.io.Resource;

public interface FileService {

	Resource loadAsResource(String fileName, Path rootLocation);
	
	Path load(String fileName, Path rootLocation);
	
	void init(Path rootLocation);
}
