package tf56.magiccubeapi.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录过滤器，使用spring这一套，方面使用spring的特性。 免登陆的接口可以用xml中配置： <br>
 * <strong>mvc:exclude-mapping</strong>
 * 
 * @author da.dong
 */
public class LoginInterceptor implements HandlerInterceptor{

	private static final String SESSION_KEY = "session_key";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		SessionBean session = getSessionBean(request, response);
//		if(null == session){
//			throw new LujingAcssException(ErrorCons.ERR_LOGIN_FAIL, "请登录");
//		}
//		ApplicationContextUtil.setSessionBean(session);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//		ApplicationContextUtil.removeSessionBean();
	}
	
//	protected SessionBean getSessionBean(HttpServletRequest request, HttpServletResponse response) {
//		SessionBean session = null;
//		String sid = request.getParameter(SESSION_KEY);
//		if (null != sid) {
//			session = RedisSessionUtil.getSessionBean(sid);
//			CookieUtil.setCookie(request, response, SESSION_KEY, sid,
//					60 * 60 * 8);
//		} else {
//			session = RedisSessionUtil.getSessionBean(request);
//		}
//		return session;
//	}
}
