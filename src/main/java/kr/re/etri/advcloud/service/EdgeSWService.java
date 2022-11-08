package kr.re.etri.advcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.etri.advcloud.mapper.EdgeSWMapper;
import kr.re.etri.advcloud.model.EdgeSWVO;

@Service
public class EdgeSWService {

	@Autowired
	EdgeSWMapper edgeSWMapper;

	public List<EdgeSWVO> selectList(EdgeSWVO param) throws Exception {
		return edgeSWMapper.selectList(param);
	}

	public List<EdgeSWVO> selectDownloadList(EdgeSWVO param) throws Exception {
		return edgeSWMapper.selectDownloadList(param);
	}

	public EdgeSWVO selectDuplicateRow(EdgeSWVO param) throws Exception {
		return edgeSWMapper.selectDuplicateRow(param);
	}

	public EdgeSWVO selectById(int sw_serial) throws Exception {
		return edgeSWMapper.selectById(sw_serial);
	}

	public int insert(EdgeSWVO param) throws Exception {
		return edgeSWMapper.insert(param);
	}

	public int update(EdgeSWVO param) throws Exception {
		return edgeSWMapper.update(param);
	}

	public int delete(EdgeSWVO param) throws Exception {
		return edgeSWMapper.delete(param);
	}

}
