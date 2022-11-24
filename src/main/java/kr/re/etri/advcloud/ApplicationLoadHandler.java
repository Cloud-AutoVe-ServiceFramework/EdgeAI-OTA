package kr.re.etri.advcloud;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import kr.re.etri.advcloud.common.constant.FtpClientConstant;
 
@ManagedBean
public class ApplicationLoadHandler implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationLoadHandler.class);
	
	@Autowired
	FtpClientConstant ftpClientConstant;

	@Override
	public void run(ApplicationArguments args) {
		try {
			// 
			// FtpClientUtils.open(ftpClientConstant);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}