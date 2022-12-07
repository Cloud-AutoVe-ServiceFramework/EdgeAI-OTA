/**
 * @Class Name : HmacUtils
 * @상세설명 :
 */

package kr.re.etri.advcloud.common.util;

import org.apache.commons.net.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacUtils {

	private static final Logger logger = LoggerFactory.getLogger(HmacUtils.class);

	private static String algorithm = "HmacSHA256";

	public static String Hmac(String key, String message)
			throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		try {
			Mac hasher = Mac.getInstance(algorithm);
			hasher.init(new SecretKeySpec(key.getBytes("utf-8"), algorithm));

			byte[] hash = hasher.doFinal(message.getBytes());

			return Base64.encodeBase64String(hash);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (InvalidKeyException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
