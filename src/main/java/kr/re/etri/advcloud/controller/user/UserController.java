package kr.re.etri.advcloud.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.re.etri.advcloud.controller.CommonController;

/**
 * 사용 하면 안됨!
 * Data manager 에서 사용자(인증) 기능 제외
 * 테스트용 백업 소스
 * @author rurony
 *
 */
@RestController
@RequestMapping("/api/datamanager/user")
public class UserController extends CommonController {

//	@Autowired
//	AuthenticationManager authenticationManager;
//
//	@Autowired
//	PasswordEncoder passwordEncoder;
//
//	@Autowired
//	CustomUserDetailsService userDetailsService;
//
//	@Autowired
//	JwtUtil jwtUtil;
//
//	@Autowired
//	UserService userService;
//
//	@PostMapping(value = "/signin", consumes = "application/json", produces = "application/json")
//	public ResponseEntity<?> signin(@RequestBody UserInfoVO param) {
//		super.param = param;
//
//		ApiResponseMessage response = null;
//		try {
//			// 필수 항목 체크
//			if (param.getId() == null || param.getPassword() == null) {
//				return ResponseEntity.badRequest().build();
//			}
//
//			String id = param.getId();
//			String password = param.getPassword();
//
//			// 아이디 체크
//			UserInfoVO user = userService.select(id);
//			if (user == null) {
//				throw new Exception("아이디 또는 비밀번호를 다시 확인하세요.");
//			}
//
//			// DB에 저장된 암호화 패스워드와 비교
//			String encodedPassword = user.getPassword();
//			if (!passwordEncoder.matches(password, encodedPassword)) {
//				throw new Exception("아이디 또는 비밀번호를 다시 확인하세요.");
//			}
//
//			// 인증 모듈
//			Authentication authentication = authenticationManager
//					.authenticate(new UsernamePasswordAuthenticationToken(id, password));
//
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//			UserDetails userDetails = userDetailsService.loadUserByUsername(id);
//
//			Map<String, Object> result = new HashMap<>();
//			result.put("id", user.getId());
//			result.put("name", user.getName());
//			result.put("token", jwtUtil.generateToken(userDetails));
//
//			response = responseSuccess(result);
//		} catch (Exception e) {
//			response = responseError(e.getMessage());
//		}
//
//		return ResponseEntity.ok(response);
//	}
//
//	@PostMapping(value = "/signup", consumes = "application/json", produces = "application/json")
//	public ResponseEntity<?> signup(@RequestBody UserInfoVO param) {
//		System.out.println("test");
//		super.param = param;
//
//		ApiResponseMessage response = null;
//		try {
//			// 필수 항목 체크
//			if (param.getId() == null || param.getPassword() == null || param.getName() == null) {
//				return ResponseEntity.badRequest().build();
//			}
//
//			// 아이디 중복 체크
//			UserInfoVO oldUser = userService.select(param.getId());
//			if (oldUser != null) {
//				throw new Exception("동일한 아이디가 존재합니다.");
//			}
//
//			param.setPassword(passwordEncoder.encode(param.getPassword()));
//
//			int result = userService.insert(param);
//			if (result > 0) {
//				response = responseSuccess();
//			} else {
//				throw new Exception("아이디가 생성되지 않았습니다. 다시 한번 진행해주세요.");
//			}
//		} catch (Exception e) {
//			response = responseError(e.getMessage());
//		}
//
//		return ResponseEntity.ok(response);
//	}
//
//	@PostMapping(value = "/password-change", consumes = "application/json", produces = "application/json")
//	public ResponseEntity<?> passwordChange(@RequestBody UserInfoVO param) {
//		super.param = param;
//
//		ApiResponseMessage response = null;
//		try {
//			// 필수 항목 체크
//			if (param.getId() == null || param.getName() == null || param.getPassword() == null) {
//				return ResponseEntity.badRequest().build();
//			}
//
//			String id = param.getId();
//			String name = param.getName();
//			String password = param.getPassword();
//
//			// 아이디 체크
//			UserInfoVO user = userService.select(id, name);
//			if (user == null) {
//				throw new Exception("아이디 또는 이름을 다시 확인하세요.");
//			}
//
//			param.setPassword(passwordEncoder.encode(password));
//
//			int result = userService.updatePassword(param);
//			if (result > 0) {
//				response = responseSuccess();
//			} else {
//				throw new Exception("비밀번호가 변경되지 않았습니다. 다시 한번 진행해주세요.");
//			}
//		} catch (Exception e) {
//			response = responseError(e.getMessage());
//		}
//
//		return ResponseEntity.ok(response);
//	}

}
