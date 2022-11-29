package kr.re.etri.advcloud.controller.edge;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.re.etri.advcloud.common.constant.CommonConstant;
import kr.re.etri.advcloud.common.util.FileUtil;
import kr.re.etri.advcloud.common.util.HmacUtils;
import kr.re.etri.advcloud.common.util.Utils;
import kr.re.etri.advcloud.controller.ApiResponseMessage;
import kr.re.etri.advcloud.controller.CommonController;
import kr.re.etri.advcloud.model.EdgeSWVO;
import kr.re.etri.advcloud.service.EdgeSWService;

@RestController
@RequestMapping("/api/datamanager/edge-sw")
public class EdgeSWController extends CommonController {
	
	@Autowired
	EdgeSWService edgeSWService;
	
	@Autowired
	CommonConstant commonConstant;
	
	@GetMapping("/search")
	public ResponseEntity<?> search(EdgeSWVO param) {
		super.param = param;

		ApiResponseMessage response = null;
		try {
			response = responseSuccess(edgeSWService.selectList(param));
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> add(@ModelAttribute EdgeSWVO param) {
		super.param = param;

		ApiResponseMessage response = null;
		try {
			// 필수 항목 체크
			if (param.getFiles() == null || param.getFiles().size() != 1 || param.getSw_group() == -1
					|| param.getSw_type() == -1 || param.getSw_manufacturer() == null || param.getPackage_id() == null
					|| param.getSw_id() == null || param.getSw_version() == null || param.getSw_name() == null
					|| param.getInstall_location() == null || param.getCreation_datetime() == null) {
				return ResponseEntity.badRequest().build();
			}

			List<MultipartFile> files = param.getFiles();
			for (int i = 0; i < files.size(); i++) {
				Map<String, Object> fileUploadData = Utils.saveFile(commonConstant.getBaseFilePath(), commonConstant.getEdgeSwPath(), files.get(i));

				if (fileUploadData != null && !fileUploadData.isEmpty()) {
					param.setFile_location((String) fileUploadData.get("file_location"));
					param.setFile_name((String) fileUploadData.get("file_name"));
					param.setFile_type((String) fileUploadData.get("file_type"));
					param.setFile_size((long) fileUploadData.get("file_size"));
					param.setCreation_datetime(Utils.convertGMTDateFormat(param.getCreation_datetime()));

					EdgeSWVO dupplicateData = edgeSWService.selectDuplicateRow(param);
					if (dupplicateData == null) {
						edgeSWService.insert(param);
						response = responseSuccess();
					} else {
						// 파일 삭제
            			try {
            				FileUtil.delete(commonConstant.getBaseFilePath() + param.getFile_location());
        				} catch (IOException e) {
        					logger.error(e.getMessage(), e);
        				}

						throw new Exception("동일한 데이터가 존재합니다.");
					}
				}
			}

			response = responseSuccess();
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value = "/update/{sw_serial}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> update(@ModelAttribute EdgeSWVO param) {
		super.param = param;

		ApiResponseMessage response = null;
		try {
			if (param.getSw_serial() == -1 || (param.getFiles() != null && param.getFiles().size() != 1)) {
				return ResponseEntity.badRequest().build();
			}

			if (param.getFiles() != null && param.getFiles().size() == 1) {
				List<MultipartFile> files = param.getFiles();
				for (int i = 0; i < files.size(); i++) {
					Map<String, Object> fileUploadData = Utils.saveFile(commonConstant.getBaseFilePath(), commonConstant.getEdgeSwPath(), files.get(i));
					if (fileUploadData != null && !fileUploadData.isEmpty()) {
						param.setFile_location((String) fileUploadData.get("file_location"));
						param.setFile_name((String) fileUploadData.get("file_name"));
						param.setFile_type((String) fileUploadData.get("file_type"));
						param.setFile_size((long) fileUploadData.get("file_size"));
						param.setCreation_datetime(Utils.convertGMTDateFormat(param.getCreation_datetime()));

						EdgeSWVO dupplicateData = edgeSWService.selectDuplicateRow(param);
						if (dupplicateData == null) {
							EdgeSWVO oldData = edgeSWService.selectById(param.getSw_serial());

							// 파일 삭제
		        			try {
		        				FileUtil.delete(commonConstant.getBaseFilePath() + oldData.getFile_location());
		    				} catch (IOException e) {
		    					logger.error(e.getMessage(), e);
		    				}

							edgeSWService.update(param);
							response = responseSuccess();
						} else {
							// 파일 삭제
		        			try {
		        				FileUtil.delete(commonConstant.getBaseFilePath() + param.getFile_location());
		    				} catch (IOException e) {
		    					logger.error(e.getMessage(), e);
		    				}

							throw new Exception("동일한 데이터가 존재합니다.");
						}
					}
				}
			} else {
				EdgeSWVO dupplicateData = edgeSWService.selectDuplicateRow(param);
				if (dupplicateData == null) {
					edgeSWService.update(param);
					response = responseSuccess();
				} else {
					throw new Exception("동일한 데이터가 존재합니다.");
				}
			}

			response = responseSuccess();
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value = "/delete/{sw_serial}")
	public ResponseEntity<?> delete(EdgeSWVO param) {
		super.param = param;

		ApiResponseMessage response = null;
		try {
			// 필수 항목 체크 (차량 SW ID)
			if (param.getSw_serial() == -1) {
				return ResponseEntity.badRequest().build();
			}

			EdgeSWVO oldData = edgeSWService.selectById(param.getSw_serial());
			if (oldData != null) {
				// 파일 삭제
    			try {
    				FileUtil.delete(commonConstant.getBaseFilePath() + oldData.getFile_location());
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}

				edgeSWService.delete(param);
			}
			response = responseSuccess();
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/download")
	public ResponseEntity<?> download(@ModelAttribute EdgeSWVO param) {
		super.param = param;

		try {
			// 필수 항목 체크
			if (param.getSw_serial() == -1 && param.getSw_serial_list() == null && param.getPackage_id() == null) {
				return ResponseEntity.badRequest().build();
			}

			List<EdgeSWVO> list = edgeSWService.selectDownloadList(param);
			logger.debug(">>>>>>>>>>>>>>> EdgeSWController download list size: " + list.size());
			
			if (list != null && list.size() > 0) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ZipOutputStream zipOut = new ZipOutputStream(baos);

				for (EdgeSWVO data : list) {
					int id = data.getSw_serial();
					String fileName = data.getFile_name();
					String filePath = data.getFile_location();
					String installLocationPath = data.getInstall_location();

					ByteArrayOutputStream os = new ByteArrayOutputStream();
					
					// host server file load
                    FileUtil.loadFile(commonConstant.getBaseFilePath() + filePath, os);

					ZipEntry zipEntry = new ZipEntry(id + "/" + fileName);
					zipEntry.setExtra(installLocationPath.getBytes("UTF-8"));

					zipOut.putNextEntry(zipEntry);
					zipOut.write(os.toByteArray());

					os.close();
					if (param.isHmac()) {
						ByteArrayOutputStream hmacBaos = new ByteArrayOutputStream();
						hmacBaos.write(HmacUtils.Hmac(param.getUser_id(), os.toString()).getBytes());
						ZipEntry hmacZipEntry = new ZipEntry(id + "/" + "Hmac_" + fileName);
						hmacZipEntry.setExtra(installLocationPath.getBytes("UTF-8"));
						zipOut.putNextEntry(hmacZipEntry);
						zipOut.write(hmacBaos.toByteArray());
						hmacBaos.close();
					}
				}

				zipOut.closeEntry();
				zipOut.close();

				baos.close();

				return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
						.header("Content-Disposition", "attachment; filename=\"edge_sw.zip\"").body(baos.toByteArray());
			} else {
				return ResponseEntity.noContent().build();
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
