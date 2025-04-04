package com.service;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class fileUploadService
{
	public void uploadproductImage(MultipartFile masterImage) {
		System.out.println("Image: "+masterImage.getOriginalFilename() );
		String path = "D:\\sts\\24-spring-boot\\src\\main\\webapp\\images\\products";
		try 
		{
			byte b[] = masterImage.getBytes();
			File file = new File(path,masterImage.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, b);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}