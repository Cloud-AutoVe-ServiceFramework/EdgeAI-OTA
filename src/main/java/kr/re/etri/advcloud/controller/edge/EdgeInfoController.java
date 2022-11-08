package kr.re.etri.advcloud.controller.edge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.re.etri.advcloud.controller.ApiResponseMessage;
import kr.re.etri.advcloud.controller.CommonController;
import kr.re.etri.advcloud.model.EdgeInfoVO;
import kr.re.etri.advcloud.model.UserInfoVO;
import kr.re.etri.advcloud.service.EdgeInfoService;
import kr.re.etri.advcloud.service.UserService;

@RestController
@RequestMapping("/api/datamanager/edge-info")
public class EdgeInfoController extends CommonController {
	
	@Autowired
	EdgeInfoService edgeInfoService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/search")
	public ResponseEntity<?> search(@ModelAttribute EdgeInfoVO param) {
		super.param = param;

		ApiResponseMessage response = null;
		try {
			response = responseSuccess(edgeInfoService.selectList(param));
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> add(@RequestBody EdgeInfoVO param) {
		super.param = param;

		ApiResponseMessage response = null;
		try {
			// 필수 항목 체크
			if (param.getLocation_number() == null || param.getEdge_id() == null || param.getUser_info_id() == null
					|| param.getEdgesw_package_id() == null || param.getLoc_latitude() == null
					|| param.getLoc_longitude() == null) {
				return ResponseEntity.badRequest().build();
			}

			// 아이디 중복 체크
			EdgeInfoVO oldData = edgeInfoService.select(param);
			if (oldData != null) {
				throw new Exception("동일한 엣지 정보 아이디가 존재합니다.");
			}

			int result = edgeInfoService.insert(param);
			if (result > 0) {
				UserInfoVO userInfoVO = new UserInfoVO();
				userInfoVO.setId(param.getUser_info_id());
				userInfoVO.setManage_vehicle_count(userInfoVO.getManage_vehicle_count() + 1);

				userService.updateManagedCount(userInfoVO);
				response = responseSuccess();
			} else {
				throw new Exception("엣지 정보가 등록되지 않았습니다. 다시 한번 진행해주세요.");
			}
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value = "/update/{edge_id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> update(@PathVariable String edge_id, @RequestBody EdgeInfoVO param) {
		super.param = param;

		ApiResponseMessage response = null;
		try {
			// 필수 항목 체크 (엣지 정보 ID)
			if (edge_id == null) {
				return ResponseEntity.badRequest().build();
			}

			edgeInfoService.update(edge_id, param);

			response = responseSuccess();
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value = "/delete/{edge_id}")
	public ResponseEntity<?> delete(@PathVariable String edge_id) {
		super.param = edge_id;

		ApiResponseMessage response = null;
		try {
			if (edge_id == null) {
				return ResponseEntity.badRequest().build();
			}

			edgeInfoService.delete(edge_id);
			response = responseSuccess();
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
}
