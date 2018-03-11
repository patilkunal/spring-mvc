package com.inovisionsoftware.exception;

import java.sql.SQLException;

import javax.persistence.PersistenceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.google.common.base.Throwables;
import com.inovisionsoftware.model.BaseResult;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	private static final Logger LOGGER = LogManager.getLogger(GlobalDefaultExceptionHandler.class.getName());

	/*
	 * This shows custom error page 
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException(NoHandlerFoundException e) {
		LOGGER.error("NoHandlerFoundException: " + e.getMessage());
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
		LOGGER.error("Entity not found: " + enfe.getMessage(), enfe);
		
		BaseResult<String> result = new BaseResult<String>(null);
		result.setErrorCode(HttpStatus.NOT_FOUND.value());
		result.setErrorMessage(enfe.getMessage());
		return result;
	}
	
	@ExceptionHandler(CartNotAllowedException.class)
	@ResponseStatus(code=HttpStatus.FORBIDDEN)	
	public @ResponseBody BaseResult<String> handleCartNotAllowed(CartNotAllowedException e) {
		LOGGER.error("Cart is not allowed: " + e.getMessage());
		
		BaseResult<String> result = new BaseResult<String>(null);
		result.setErrorCode(HttpStatus.FORBIDDEN.value());
		result.setErrorMessage(e.getMessage());
		return result;		
	}

	@ExceptionHandler({GenericJDBCException.class, TransactionException.class, SQLException.class, PersistenceException.class})
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResult<String> handleDatabaseException(Exception e) {
		LOGGER.error("Database Exception: " + e.getMessage(), e);
		BaseResult<String> result = new BaseResult<String>(null);
		result.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		String errorMessage = Throwables.getRootCause(e).getMessage();
		result.setErrorMessage(errorMessage);
		return result;
	}
	
	/*
	 * This will handle any exception that can occur in application
	 * We show custom error page, rather than container error page
	 */
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleGeneralException(Exception e) {
		LOGGER.error("General Exception Type: " + e.getClass(), e);
		LOGGER.error("Error message: " + e.getMessage());
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Error processing request");
		mv.addObject("errorDescription", e.getMessage());
		mv.addObject("title", "Request Error");
		return mv;
	}
	
	
}
