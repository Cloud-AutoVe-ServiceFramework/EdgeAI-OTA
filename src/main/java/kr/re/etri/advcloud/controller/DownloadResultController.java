package kr.re.etri.advcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.re.etri.advcloud.model.DownloadResultVO;

@RestController
@RequestMapping("/api/datamanager")
public class DownloadResultController extends CommonController {

	@PostMapping(value = "/download-result", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> downloadResult(@RequestBody DownloadResultVO param) {
		super.param = param;

		ApiResponseMessage response = null;
		try {
			response = responseSuccess();
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}

}