/**
 * @Class Name : HmacUtils
 * @상세설명 :
 */

package kr.re.etri.advcloud.common.util;

import org.apache.commons.net.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacUtils {

	private static String algorithm = "HmacSHA256";

	public static String Hmac(String key, String message) throws Exception {
		Mac hasher = Mac.getInstance(algorithm);
		hasher.init(new SecretKeySpec(key.getBytes("utf-8"), algorithm));
		byte[] hash = hasher.doFinal(message.getBytes());

		return Base64.encodeBase64String(hash);
	}

}
