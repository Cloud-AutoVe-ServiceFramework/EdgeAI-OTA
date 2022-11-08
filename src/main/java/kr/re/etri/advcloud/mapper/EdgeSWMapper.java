package kr.re.etri.advcloud.mapper;

import java.util.List;

import kr.re.etri.advcloud.common.annotation.Mapper;
import kr.re.etri.advcloud.model.EdgeSWVO;

@Mapper("edgeSWMapper")
public interface EdgeSWMapper {

	List<EdgeSWVO> selectList(EdgeSWVO param);

	List<EdgeSWVO> selectDownloadList(EdgeSWVO param);

	EdgeSWVO selectDuplicateRow(EdgeSWVO param);

	EdgeSWVO selectById(int sw_serial);

	int insert(EdgeSWVO param);

	int update(EdgeSWVO param);

	int delete(EdgeSWVO param);

}
