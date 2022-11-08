package kr.re.etri.advcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.re.etri.advcloud.service.CodeService;

@RestController
@RequestMapping("/api/datamanager")
public class CodeController extends CommonController {

	@Autowired
	CodeService codeService;

	@GetMapping("/code-list")
	public ResponseEntity<?> search() {
		super.param = "";

		ApiResponseMessage response = null;
		try {
			response = responseSuccess(codeService.selectList());
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}

}