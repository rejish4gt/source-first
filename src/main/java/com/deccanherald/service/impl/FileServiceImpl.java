package com.deccanherald.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.deccanherald.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	@Override
	public void init(Path rootLocation) {
		try {
			if(!Files.exists(rootLocation))
			{
				Files.createDirectory(rootLocation);
			}
		} catch (Exception e) {
			new RuntimeException("Could not create root directory");
		}
	}
	
	@Override
	public Path load(String filename, Path rootLocation) {
		return rootLocation.resolve(filename);
	}
	
	@Override
	public Resource loadAsResource(String fileName, Path rootLocation) {
		Resource resource = null;
		try {
			Path file = load(fileName, rootLocation);
            resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else
            {
            	throw new RuntimeException("Could not read file: "+fileName);
            }
		} catch (Exception e) {
			throw new RuntimeException("Could not read file: "+fileName);
		}
	}

}
