package Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	public static Cookie add(String key, String value, int hour, HttpServletResponse resp) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(hour);
		cookie.setPath("/");
		resp.addCookie(cookie);
		return cookie;

	}

	public static String get(String key, HttpServletRequest rep) {
		Cookie cookie[] = rep.getCookies();
		if (cookie != null) {
			for (Cookie ck : cookie) {
				if (ck.getName().equals(key)) {
					System.out.println("abc");
					return ck.getValue();
				}
			}
		}
		return null;
	}


}
