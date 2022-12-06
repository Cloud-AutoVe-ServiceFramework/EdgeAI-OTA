package kr.re.etri.advcloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.etri.advcloud.mapper.UserMapper;
import kr.re.etri.advcloud.model.UserInfoVO;

@Service
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserMapper userMapper;
	
	public UserInfoVO select(String id) {
		try {
			UserInfoVO param = new UserInfoVO();
			param.setId(id);
			
			return select(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public UserInfoVO select(String id, String name)  {
		try { 
			UserInfoVO param = new UserInfoVO();
			param.setId(id);
			param.setName(name);
			
			return select(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public UserInfoVO select(UserInfoVO param) {
		try {
			return userMapper.select(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public int insert(UserInfoVO param) {
		try {
			return userMapper.insert(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public int updatePassword(UserInfoVO param) {
		try {
			return userMapper.updatePassword(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public int updateManagedCount(UserInfoVO param) {
		try {
			return userMapper.updateManagedCount(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
}

