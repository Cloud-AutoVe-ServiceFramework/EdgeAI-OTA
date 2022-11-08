package kr.re.etri.advcloud.mapper;

import kr.re.etri.advcloud.common.annotation.Mapper;
import kr.re.etri.advcloud.model.UserInfoVO;

@Mapper("userMapper")
public interface UserMapper {

	UserInfoVO select(UserInfoVO param);

	int insert(UserInfoVO param);

	int updatePassword(UserInfoVO param);

	int updateManagedCount(UserInfoVO param);

}
