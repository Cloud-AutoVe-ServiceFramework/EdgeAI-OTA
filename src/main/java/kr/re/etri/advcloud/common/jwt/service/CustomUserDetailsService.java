package kr.re.etri.advcloud.common.jwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.re.etri.advcloud.model.UserInfoVO;
import kr.re.etri.advcloud.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		try {
			UserInfoVO jwtUser = userService.select(id);
			
			if (jwtUser == null) {
	            throw new Exception("User Not found" + id);
	        }
			
			return new User(jwtUser.getId(), jwtUser.getPassword(), new ArrayList<>());
		} catch (Exception e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
    }
}
