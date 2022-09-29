package com.spring.cosa.common.utils;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Component
public class S3Upload {

	private final AmazonS3 s3Client;

	private String bucket;

	private S3Upload(@Value("${bucket}") String bucket, @Value("${accessKey}") String accessKey,
			@Value("${secretKey}") String secretKey) {

		this.bucket = bucket;
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		// 얻은 자격 증명 객체로 s3Client를 가져옴
		this.s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.AP_NORTHEAST_2).build();
	}

	public String upload(MultipartFile file) throws IOException {

		// 저장 파일 이름 중복 방지
		String s3FileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
		
		// 날짜별 폴더 생성
		String savePath = getDateFolder()+s3FileName;
		
		// 파일의 사이즈
		ObjectMetadata objMeta = new ObjectMetadata();
		objMeta.setContentLength(file.getInputStream().available());
		objMeta.setContentType(file.getContentType());
		
		// s3 api putObject 업로드
		s3Client.putObject(bucket, savePath, file.getInputStream(), objMeta);
	
		// 업로드된 사진 url get
		return savePath;
		//return s3Client.getUrl(bucket, savePath).toString();
	}

	public URL urlPath() {
		URL url = s3Client.getUrl(bucket, "ed088174-c61e-4acd-83bc-cf031be87f9c-main_img2.png2022/09/22");
		
		return url;
	}
	
	private String getDateFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
		Date date = new Date();
		
		return sdf.format(date);
	}
}
