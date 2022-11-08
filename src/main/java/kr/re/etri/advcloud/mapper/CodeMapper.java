package kr.re.etri.advcloud.mapper;

import java.util.List;
import java.util.Map;

import kr.re.etri.advcloud.common.annotation.Mapper;

@Mapper("codeMapper")
public interface CodeMapper {
	
	List<Map<String, Object>> selectList();
	
}
