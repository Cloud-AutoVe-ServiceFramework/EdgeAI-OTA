package kr.re.etri.advcloud;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import kr.re.etri.advcloud.common.constant.FtpClientConstant;
import kr.re.etri.advcloud.common.util.FtpClientUtils;

@ManagedBean
public class ApplicationLoadHandler implements ApplicationRunner  {
	
	@Autowired
	FtpClientConstant ftpClientConstant;
	
	@Override
    public void run(ApplicationArguments args) throws Exception {
		FtpClientUtils.open(ftpClientConstant);
	}
	
}