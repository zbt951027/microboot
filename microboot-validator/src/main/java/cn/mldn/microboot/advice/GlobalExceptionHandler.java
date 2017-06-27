package cn.mldn.microboot.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "errors/error";

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandle(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
		mav.addObject("url", request.getRequestURL());
		mav.addObject("exception", e);
		return mav;
	}
}
