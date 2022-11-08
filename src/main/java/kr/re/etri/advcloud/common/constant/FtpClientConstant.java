package kr.re.etri.advcloud.common.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "ftp.client")
public class FtpClientConstant {

	private String protocol;
	private String host;
	private Integer port;
	private String username;
	private String password;
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
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
