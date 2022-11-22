package kr.re.etri.advcloud.service;

import java.util.List; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.etri.advcloud.mapper.EdgeSWMapper;
import kr.re.etri.advcloud.model.EdgeSWVO;

@Service
public class EdgeSWService {
	
	private static final Logger logger = LoggerFactory.getLogger(EdgeSWService.class);
	
	@Autowired
	EdgeSWMapper edgeSWMapper;

	public List<EdgeSWVO> selectList(EdgeSWVO param) {
		try {
			return edgeSWMapper.selectList(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public List<EdgeSWVO> selectDownloadList(EdgeSWVO param) {
		try {
			return edgeSWMapper.selectDownloadList(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public EdgeSWVO selectDuplicateRow(EdgeSWVO param) {
		try {
			return edgeSWMapper.selectDuplicateRow(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public EdgeSWVO selectById(int sw_serial) {
		try {
			return edgeSWMapper.selectById(sw_serial);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public int insert(EdgeSWVO param) {
		try {
			return edgeSWMapper.insert(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public int update(EdgeSWVO param) {
		try {
			return edgeSWMapper.update(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public int delete(EdgeSWVO param) {
		try {
			return edgeSWMapper.delete(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
