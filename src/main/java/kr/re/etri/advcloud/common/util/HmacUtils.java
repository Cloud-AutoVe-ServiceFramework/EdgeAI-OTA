/**
 * @Class Name : HmacUtils
 * @상세설명 :
 * @작성일시 : 2022-06-14
 * @작 성 자 : 이강재
 * @수 정 이 력
 * @
 * @ 수정일         수정자               수정내용
 * @ ----------     --------    ---------------------------
 * @ 2022-06-14        이강재               최초등록
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
