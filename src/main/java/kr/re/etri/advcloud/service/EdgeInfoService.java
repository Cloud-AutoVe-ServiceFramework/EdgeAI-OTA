package kr.re.etri.advcloud.service;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.etri.advcloud.mapper.EdgeInfoMapper;
import kr.re.etri.advcloud.model.EdgeInfoVO;

@Service
public class EdgeInfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(EdgeInfoService.class);
	
	@Autowired
	EdgeInfoMapper edgeInfoMapper;

	public List<EdgeInfoVO> selectList(EdgeInfoVO param) {
		try {
			return edgeInfoMapper.selectList(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public EdgeInfoVO select(EdgeInfoVO param) {
		try {
			return edgeInfoMapper.select(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public int insert(EdgeInfoVO param) {
		try {
			return edgeInfoMapper.insert(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public int update(String edge_id, EdgeInfoVO param) {
		try {
			param.setEdge_id(edge_id);
			return edgeInfoMapper.update(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public int delete(String edge_id) {
		try {
			return edgeInfoMapper.delete(edge_id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
