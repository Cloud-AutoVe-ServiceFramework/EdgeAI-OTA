package kr.re.etri.advcloud.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.etri.advcloud.mapper.CodeMapper;

@Service
public class CodeService {

	@Autowired
	CodeMapper codeMapper;

	public List<Map<String, Object>> selectList() throws Exception {
		return codeMapper.selectList();
	}

}
