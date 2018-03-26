package com.inovisionsoftware.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.webflow.engine.FlowExecutionExceptionHandler;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.execution.FlowExecutionException;

@Component(value="myflowExceptionHandler")
public class MyFlowExceptionHandler implements FlowExecutionExceptionHandler {

	private static final Logger LOGGER = LogManager.getLogger(MyFlowExceptionHandler.class);
	
	@Override
	public boolean canHandle(FlowExecutionException exception) {
		LOGGER.info("Trying to handle exception for flow : " + exception.getFlowId());
		return true;
	}

	@Override
	public void handle(FlowExecutionException exception, RequestControlContext context) {
		LOGGER.error("Error in executing flow: " + context.getActiveFlow().getId(), exception);
		// TODO Auto-generated method stub
		String startid = context.getActiveFlow().getStartState().getId();
		
		//Transition t = new Transition();
		//context.execute( context.getCurrentTransition());
	}

}
