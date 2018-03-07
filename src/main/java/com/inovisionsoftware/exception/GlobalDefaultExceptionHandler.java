package com.inovisionsoftware.exception;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.inovisionsoftware.model.BaseResult;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	/*
	 * This shows custom error page 
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Page not found");
		mv.addObject("errorDescription", "The page you requested is not found");
		mv.addObject("title", "404 Page not found");
		return mv;
	}

	/*
	 * This function throw 404 during REST call and function throws EntityNotFoundException
	 * (similar can be done for ModelAndView too)
	 */
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public @ResponseBody BaseResult<String> handleEntityNotFoundException(EntityNotFoundException enfe) {
		BaseResult<String> result = new BaseResult<String>(null);
		result.setErrorCode(HttpStatus.NOT_FOUND.value());
		result.setErrorMessage(enfe.getMessage());
		return result;
	}

	@ExceptionHandler(GenericJDBCException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResult<String> handleGenericJDBCException(GenericJDBCException enfe) {
		BaseResult<String> result = new BaseResult<String>(null);
		result.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		result.setErrorMessage(enfe.getMessage());
		return result;
	}
	
	/*
	 * This will handle any exception that can occur in application
	 * We show custom error page, rather than container error page
	 */
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleGeneralException(Exception e) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Error processing request");
		mv.addObject("errorDescription", e.getMessage());
		mv.addObject("title", "Request Error");
		return mv;
	}
	
	
}
