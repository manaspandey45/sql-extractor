package com.misc.core.utils;

import org.apache.log4j.Logger;

public class App {

	private static final Logger logger = Logger.getLogger(App.class);

	public static void main(final String[] args) {

		logger.info("Starting sql extractor");
		final SqlExtractorImpl sqlExtractorImpl = new SqlExtractorImpl();
		sqlExtractorImpl.extractSql(args[0]);
		logger.info("Sql extraction complete");

	}

}
