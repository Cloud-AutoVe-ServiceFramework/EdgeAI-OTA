package kr.re.etri.advcloud.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class Utils {
	
	private static final Logger logger = LoggerFactory.getLogger(Utils.class);
	
	private final static long KB_FACTOR = 1024;
    private final static long MB_FACTOR = 1024 * KB_FACTOR;
    private final static long GB_FACTOR = 10 * 1024 * MB_FACTOR;	// 10 GB

    public static Map<String, Object> saveFileByFtp(String uploadFolderPath, MultipartFile multipartFile) throws Exception {
        Map<String, Object> fileUploadData = null;

        InputStream fis = null;
        if (multipartFile != null) {
            long size = multipartFile.getSize();

			if (size > GB_FACTOR) {
				new Exception("파일 사이즈가 최대 저장 사이즈보다 큽니다.");
			}

            String orgFileName = multipartFile.getOriginalFilename();
            if (orgFileName != null) {
            	// XXX: 파일 저장 포맷 제거 
//                if (orgFileName.endsWith(".txt") || orgFileName.endsWith(".dbf") || orgFileName.endsWith(".shp") || orgFileName.endsWith(".shx") || orgFileName.endsWith(".sbn")
//                        || orgFileName.endsWith(".sbx") || orgFileName.endsWith(".prj") || orgFileName.endsWith(".cpg") || orgFileName.endsWith(".idx") || orgFileName.endsWith(".xml")
//                        || orgFileName.endsWith(".csv") || orgFileName.endsWith(".xlsx") || orgFileName.endsWith(".xls") || orgFileName.endsWith(".htm") || orgFileName.endsWith(".html")
//                        || orgFileName.endsWith(".doc") || orgFileName.endsWith(".docx") || orgFileName.endsWith(".zip") || orgFileName.endsWith(".bin")) {
                    String fileExtension = orgFileName.substring(orgFileName.lastIndexOf(".") + 1);

                    String uniqueFileName = UUID.randomUUID().toString() + "." + fileExtension;
                    String filePath = uploadFolderPath + "/" + uniqueFileName;

                    fileUploadData = new HashMap<>();
                    fileUploadData.put("file_type", fileExtension);
                    fileUploadData.put("file_name", orgFileName);
                    fileUploadData.put("file_size", size);
                    fileUploadData.put("file_location", filePath);

                    try {
                        fis = multipartFile.getInputStream();
                        FtpClientUtils.saveFile(fis, uploadFolderPath, uniqueFileName);
                    } catch (IOException e) {
                        throw e;
                    } finally {
                        try {
                            if (fis != null) {
                                fis.close();
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                }
//            }
        }

        return fileUploadData;
    }
    
    public static Map<String, Object> saveFile(String baseFilePath, String uploadFolderPath, MultipartFile multipartFile) throws Exception {
        Map<String, Object> fileUploadData = null;

        InputStream fis = null;
        if (multipartFile != null) {
            long size = multipartFile.getSize();

			if (size > GB_FACTOR) {
				new Exception("파일 사이즈가 최대 저장 사이즈보다 큽니다.");
			}

            String orgFileName = multipartFile.getOriginalFilename();
            if (orgFileName != null) {
            	// XXX: 파일 저장 포맷 제거 
//                if (orgFileName.endsWith(".txt") || orgFileName.endsWith(".dbf") || orgFileName.endsWith(".shp") || orgFileName.endsWith(".shx") || orgFileName.endsWith(".sbn")
//                        || orgFileName.endsWith(".sbx") || orgFileName.endsWith(".prj") || orgFileName.endsWith(".cpg") || orgFileName.endsWith(".idx") || orgFileName.endsWith(".xml")
//                        || orgFileName.endsWith(".csv") || orgFileName.endsWith(".xlsx") || orgFileName.endsWith(".xls") || orgFileName.endsWith(".htm") || orgFileName.endsWith(".html")
//                        || orgFileName.endsWith(".doc") || orgFileName.endsWith(".docx") || orgFileName.endsWith(".zip") || orgFileName.endsWith(".bin")) {
                    String fileExtension = orgFileName.substring(orgFileName.lastIndexOf(".") + 1);

                    String uniqueFileName = UUID.randomUUID().toString() + "." + fileExtension;
                    String fileLocation = uploadFolderPath + "/" + uniqueFileName;
                    String filePath = baseFilePath + uploadFolderPath + "/" + uniqueFileName;

                    fileUploadData = new HashMap<>();
                    fileUploadData.put("file_type", fileExtension);
                    fileUploadData.put("file_name", orgFileName);
                    fileUploadData.put("file_size", size);
                    fileUploadData.put("file_location", fileLocation);

                    try {
                        fis = multipartFile.getInputStream();
                        
                        logger.debug(">>> save file path: {}", filePath);
                        
                        FileUtil.createFile(fis, filePath);
                    } catch (IOException e) {
                        throw e;
                    } finally {
                        try {
                            if (fis != null) {
                                fis.close();
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                }
//            }
        }

        return fileUploadData;
    }
    

    public static String convertDateTimeFormatString(String creationDateTime) throws ParseException {
    	Instant instant = Instant.parse(creationDateTime);
    	Date creationDate = Date.from(instant);
    	
    	SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

        return newFormat.format(creationDate);
    }
    
}
