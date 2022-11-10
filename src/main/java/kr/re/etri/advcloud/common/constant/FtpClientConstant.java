package kr.re.etri.advcloud.common.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "ftp.client")
public class FtpClientConstant {

	private String protocol;
	private String ADVMhost;
	private Integer ADVMport;
	private String ADVMusername;
	private String ADVMpassword;
	private Integer keepAliveTimeout;
	private String edgeSwPath;


	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * @return the ADVM host
	 */
	public String getADVMHost() {
		return ADVMhost;
	}

	/**
	 * @param host the ADVM host to set
	 */
	public void setADVMHost(String host) {
		this.ADVMhost = host;
	}

	/**
	 * @return the ADVM port
	 */
	public Integer getADVMPort() {
		return ADVMport;
	}

	/**
	 * @param port the ADVM port to set
	 */
	public void setADVMPort(Integer port) {
		this.ADVMport = ADVMport;
	}

	/**
	 * @return the ADVM username
	 */
	public String getADVMUsername() {
		return ADVMusername;
	}

	/**
	 * @param username the ADVM username to set
	 */
	public void setADVMUsername(String username) {
		this.ADVMusername = username;
	}

	/**
	 * @return the ADVM password
	 */
	public String getADVMPassword() {
		return ADVMpassword;
	}

	/**
	 * @param password the ADVM password to set
	 */
	public void setADVMPassword(String password) {
		this.ADVMpassword = password;
	}

	/**
	 * @return the keepAliveTimeout
	 */
	public Integer getKeepAliveTimeout() {
		return keepAliveTimeout;
	}

	/**
	 * @param keepAliveTimeout the keepAliveTimeout to set
	 */
	public void setKeepAliveTimeout(Integer keepAliveTimeout) {
		this.keepAliveTimeout = keepAliveTimeout;
	}




	/**
	 * @return the edgeSwPath
	 */
	public String getEdgeSwPath() {
		return edgeSwPath;
	}

	/**
	 * @param edgeSwPath the edgeSwPath to set
	 */
	public void setEdgeSwPath(String edgeSwPath) {
		this.edgeSwPath = edgeSwPath;
	}




}
