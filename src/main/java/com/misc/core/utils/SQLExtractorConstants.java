package com.misc.core.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class SQLExtractorConstants {

	public static final String SELECT_REGEX = "(?m)SELECT\\s.*FROM\\s.*WHERE\\s.*;$";
	public static final String UPDATE_REGEX = "(?m)UPDATE\\s.*SET\\s.*WHERE\\s.*;$";
	public static final String INSERT_REGEX = "(?m)INSERT\\s.*INTO\\s.*;$";
	public static final String MERGE_REGEX = "(?m)MERGE\\s.*INTO\\s.*?;$";
	public static final String WITH_REGEX = "(?m)WITH\\s.*SELECT\\s.*?;$";
	public static final String DELETE_REGEX = "(?m)DELETE\\s.*FROM\\s.*WHERE\\s.*;$";

	static final Map<String, String> REGEX_MAP = new LinkedHashMap<>();

	static {
		REGEX_MAP.put("SELECT", SELECT_REGEX);
		REGEX_MAP.put("UPDATE", UPDATE_REGEX);
		REGEX_MAP.put("INSERT", INSERT_REGEX);
		REGEX_MAP.put("MERGE", MERGE_REGEX);
		REGEX_MAP.put("WITH", WITH_REGEX);
		REGEX_MAP.put("DELETE", DELETE_REGEX);

	}

}
