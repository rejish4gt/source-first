package com.deccanherald.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deccanherald.response.FileInfo;
import com.deccanherald.response.FileUploadResponse;
import com.deccanherald.service.FileService;
import com.deccanherald.util.GeneratorUtility;

@RestController
@RequestMapping(value="api")
public class MyController {
	
	@Autowired
	FileService fileService;

	private Path rootLocation;
	
	private static final String FILE_UPLOAD_PATH="/Users/rejish/Documents/test";
	
	@CrossOrigin
	@RequestMapping(value = "/fileUpload", headers=("content-type=multipart/*"), method = RequestMethod.POST)
	public ResponseEntity<FileUploadResponse> upload(@Valid @RequestParam(name="inputFile") MultipartFile[] inputFiles) {
		
		FileUploadResponse fileUploadResponse = new FileUploadResponse();
		
		if(inputFiles==null || inputFiles.length==0)
		{
			fileUploadResponse.setErrorMessage("Input files are required for upload.");
			return new ResponseEntity<FileUploadResponse>(fileUploadResponse, HttpStatus.BAD_REQUEST);
		}
		
		
		/*
		 * Create the directory to save the files if it does not exists
		 * */
		
		StringBuffer filePath = new StringBuffer(FILE_UPLOAD_PATH);
		
		// Uncomment if you need to save on a consultation level
//		if(consultation!=null)
//			filePath.append("/"+consultationId.toString());
		
		File file = new File(filePath.toString());
		if(!file.exists())
			file.mkdirs();
		
		/*
		 * variable declaration
		 * */
		FileInfo fileInfo = null;
		HttpHeaders headers = new HttpHeaders();
		List<FileInfo> fileInfos = null;
		
		// TODO: Optimize
		/*
		 * Initialize upload process only if files are present
		 * */
		if(inputFiles.length>0)
		{
			fileInfos = new ArrayList<FileInfo>();
			
				MultipartFile inputFile = inputFiles[0];
				if (!inputFile.isEmpty()) {
					
					/*
					 * Get the original file name
					 * */
					String originalFilename = inputFile.getOriginalFilename();
					
					
						try {
							fileInfo = new FileInfo();

							/*
							 * Generate random file name for the target. The extension will remain the same
							 * */
							File destinationFile = new File(file.getPath() + File.separator + GeneratorUtility
									.generateRandomFileName(64, FilenameUtils.getExtension(originalFilename)));

							/*
							 * Move the uploaded file to the path specified and save it with the random file name
							 * */
							inputFile.transferTo(destinationFile);

							/*
							 * Retrieve the new details to be sent back in the response
							 * */
							fileInfo.setFileName(destinationFile.getName());
							fileInfo.setFileSize(inputFile.getSize());
							headers.add("File Uploaded Successfully - ", originalFilename);
							fileInfos.add(fileInfo);
						} catch (Exception e) {
							fileUploadResponse.setErrorMessage(e.getMessage());
							return new ResponseEntity<FileUploadResponse>(fileUploadResponse, HttpStatus.BAD_REQUEST);
						} 
				} else {
					fileUploadResponse.setErrorMessage("File not found");
					return new ResponseEntity<FileUploadResponse>(fileUploadResponse, HttpStatus.BAD_REQUEST);
				}
		
		}		
		fileUploadResponse.setFileInfos(fileInfos);
		return new ResponseEntity<FileUploadResponse>(fileUploadResponse, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("fileName") String fileName)
	{
		this.rootLocation = Paths.get(FILE_UPLOAD_PATH);
		Resource resource=fileService.loadAsResource(fileName, rootLocation);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
	@CrossOrigin
	@GetMapping(value = "/viewFile/{fileName:.+}")
	public ResponseEntity<Resource> viewFile(@PathVariable("fileName") String fileName)
	{
		this.rootLocation = Paths.get(FILE_UPLOAD_PATH);
		Resource resource=fileService.loadAsResource(fileName, rootLocation);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
}
