package kr.re.etri.advcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.etri.advcloud.mapper.UserMapper;
import kr.re.etri.advcloud.model.UserInfoVO;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserInfoVO select(String id) throws Exception {
		UserInfoVO param = new UserInfoVO();
		param.setId(id);
		
		return select(param);
	}
	
	public UserInfoVO select(String id, String name) throws Exception {
		UserInfoVO param = new UserInfoVO();
		param.setId(id);
		param.setName(name);
		
		return select(param);
	}
	
	public UserInfoVO select(UserInfoVO param) throws Exception {
		return userMapper.select(param);
	}
	
	public int insert(UserInfoVO param) throws Exception {
		return userMapper.insert(param);
	}
	
	public int updatePassword(UserInfoVO param) throws Exception {
		return userMapper.updatePassword(param);
	}
	
	public int updateManagedCount(UserInfoVO param) throws Exception {
		return userMapper.updateManagedCount(param);
	}
	
}

