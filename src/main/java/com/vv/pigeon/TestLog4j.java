package com.vv.pigeon;

import org.apache.log4j.Logger;

public class TestLog4j {
	
	
	public void log4j(){

		  Logger logger=Logger.getLogger(this.getClass().getName());

		  System.out.println("test log4j");

		  logger.info("----------info");
          logger.debug("----------debug");
          logger.error("----------error");

		 }


		 public static void main(String[] args) {

		  TestLog4j tl=new TestLog4j();

		  tl.log4j(); 

		 }
}
