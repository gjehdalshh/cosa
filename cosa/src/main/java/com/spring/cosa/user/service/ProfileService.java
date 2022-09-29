package com.spring.cosa.user.service;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cosa.common.utils.ConvertType;
import com.spring.cosa.common.utils.S3Upload;
import com.spring.cosa.user.dao.UserDAO;
import com.spring.cosa.user.dto.LoginDTO;
import com.spring.cosa.user.dto.ProfileDTO;
import com.spring.cosa.user.dto.UserImgDTO;
import com.spring.cosa.user.mapper.UserMapper;

@Service
public class ProfileService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private S3Upload s3Upload;

	public ModelAndView showMainProfile() throws IOException {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/profile");
		mv.addObject("data", selectProfile());
		mv.addObject("urlPath", s3Upload.urlPath());

		return mv;
	}

	private UserDAO selectProfile(){
	
		LoginDTO dto = (LoginDTO) session.getAttribute("user");
		UserDAO vo = mapper.selectId(dto.getUser_id());

		return vo;
	}

	public int modifyProfileNm(ProfileDTO dto) {
		return mapper.modifyProfileNm(dto);
	}

	public int modifyProfilePh(ProfileDTO dto) {
		return mapper.modifyProfilePh(dto);
	}

	public int insProfileImg(MultipartHttpServletRequest req) throws IOException {
		
		MultipartFile file = req.getFile("fileUpload");
	
		UserImgDTO dto = new UserImgDTO();
		dto.setFile_data(file.getBytes());
		dto.setFile_name(file.getOriginalFilename());
		
		dto.setFile_type(file.getContentType());
		dto.setI_user(ConvertType.convertStringToInt(req.getParameter("i_user")));
		
		return mapper.insProfileImg(dto);
	}
}
