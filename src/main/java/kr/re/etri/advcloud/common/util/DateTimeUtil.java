package kr.re.etri.advcloud.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeUtil {

	private static final Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);

	private static TimeZone timeZone = TimeZone.getDefault();
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

	/**
	 * convert to local time to utc time UTC = UTC - 9 hour
	 * 
	 * @param localDateTime
	 * @return
	 */
	public static long convertLocalTimeToUtcTime(long localDateTime) {
		return localDateTime - timeZone.getOffset(localDateTime);
	}

	/**
	 * convert to utc time to local time KST = UTC + 9 hour
	 * 
	 * @param uTCDateTime
	 * @return
	 */
	public static long convertUtcTimeToLocalTime(long uTCDateTime) {
		return uTCDateTime + timeZone.getOffset(uTCDateTime);
	}

	public static String getDateTimeFormatString(long dateTime) {
		return simpleDateFormat.format(dateTime);
	}

	public static String getDateTimeFormatString(Date dateTime) {
		return simpleDateFormat.format(dateTime);
	}

	/**
	 * 날짜
	 * 
	 * @param strDate (ex. 2015-01-01 15:00:00) 빈 값이면 현재 시간으로 계산
	 * @param amount  (calender amount)
	 * @param format  (ex. yyyy-MM-dd hh:mm:ss)
	 * @return
	 */
	public static String getDateTimeFormatString(String strDate, int amount, String format) {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat sf = new SimpleDateFormat(format, Locale.ENGLISH);

			try {
				if (!"".equals(strDate)) {
					date = sf.parse(strDate);
					calendar.setTime(date);
				}

				calendar.add(Calendar.MINUTE, amount);

				date = calendar.getTime();
				strDate = sf.format(date);
			} catch (ParseException e) {
				logger.error(e.getMessage(), e); // 
			}

		return strDate;
	}

	public static long getDateTimeToLong(String strDate, String format) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat(format, Locale.ENGLISH);

		long time = 0;
		try {
			Date date = sf.parse(strDate);
			calendar.setTime(date);

			time = calendar.getTime().getTime();
		} catch (ParseException e) {
			logger.error(e.getMessage(), e); // 
		}

		return time;
	}

	public static String getTimeDiffString(long startAt, long endAt) {
		long timeDiff = endAt - startAt;

		return String.format("%5d ms", TimeUnit.MILLISECONDS.toMillis(timeDiff));
	}

	public static String printTimeDiff(long startAt, long endAt) {
		return ("[" + getTimeDiffString(startAt, endAt) + "] " + getDateTimeFormatString(startAt) + " ~ "
				+ getDateTimeFormatString(endAt));
//			logger.debug("[{}] {} ~ {} ", getTimeDiffString(startAt, endAt), getDateTimeFormatString(startAt), getDateTimeFormatString(endAt));
	}

}
