package kr.re.etri.advcloud.mapper;

import java.util.List;

import kr.re.etri.advcloud.common.annotation.Mapper;
import kr.re.etri.advcloud.model.EdgeInfoVO;

@Mapper("edgeInfoMapper")
public interface EdgeInfoMapper {

	List<EdgeInfoVO> selectList(EdgeInfoVO param);

	EdgeInfoVO select(EdgeInfoVO param);

	int insert(EdgeInfoVO param);

	int update(EdgeInfoVO param);

	int delete(String edge_id);

}
