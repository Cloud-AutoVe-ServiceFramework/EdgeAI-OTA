package kr.re.etri.advcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.etri.advcloud.mapper.EdgeInfoMapper;
import kr.re.etri.advcloud.model.EdgeInfoVO;

@Service
public class EdgeInfoService {

	@Autowired
	EdgeInfoMapper edgeInfoMapper;

	public List<EdgeInfoVO> selectList(EdgeInfoVO param) throws Exception {
		return edgeInfoMapper.selectList(param);
	}

	public EdgeInfoVO select(EdgeInfoVO param) throws Exception {
		return edgeInfoMapper.select(param);
	}

	public int insert(EdgeInfoVO param) throws Exception {
		return edgeInfoMapper.insert(param);
	}

	public int update(String edge_id, EdgeInfoVO param) throws Exception {
		param.setEdge_id(edge_id);
		return edgeInfoMapper.update(param);
	}

	public int delete(String edge_id) throws Exception {
		return edgeInfoMapper.delete(edge_id);
	}

}
