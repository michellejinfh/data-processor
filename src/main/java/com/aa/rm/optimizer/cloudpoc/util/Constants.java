package com.aa.rm.optimizer.cloudpoc.util;

public class Constants 
{
	public final static String DEFAULT_MARKET_REFERENCE = "**"; // origin/dest
	
	public final static int YD_BUCKET_1 = 1;
	
	public final static int YD_BUCKET_11 = 11;
	
	// BPC_* constants are used to set BPC_DEFAULT_IND in BPC_OUTPUT
	//
	public final static int BPC_DEFAULTING_NOT_APPLIED = 0;
	public final static int BPC_DEFAULTING_NOT_APPLIED_WITHOUT_DOW = 1;
	public final static int BPC_DEFAULTING_APPLIED = -1;
	public final static int BPC_CAP_BY_MIN = -2;
	// 9/5/2019: BPC Adjustment redesign:
	// Changed to avoid conflict with influence indicator. 
	// Originally this indicator was 2.
	//
	public final static int BPC_CAP_BY_MAX = -3;
	public final static int BPC_ZERO_BUCKET_11 = 3;

	public final static int NULL_MAX_LCL_FARE = -1;
	
	public final static String LOCAL = "local";
	
	public final static String FLOW = "flow";
	
	public final static String FLOW_MASHED = "flowMashed";
	
	public final static String LOCAL_FLOW = "localFlow";
	
	public final static String MASHED = "M";

	// INFLUENCE_* constants are used to set BPC_ADJ_IND in BPC_OUTPUT
	//
	public final static int INFLUENCE_OIP_MIN_RULE_APPLIED = 1;
	public final static int INFLUENCE_OIP_MAX_RULE_APPLIED = 2;
	public final static int INFLUENCE_OIP_FO_RULE_APPLIED = 3;
	public final static int INFLUENCE_OA_APPLIED = 4;
	public final static int INFLUENCE_MULTIPLIER_APPLIED = 5;
	public final static int INFLUENCE_ADDITIVE_APPLIED = 6;
	public final static int INFLUENCE_DYNAVL_APPLIED = 7;
	public final static int INFLUENCE_ULCC_MIN_APPLIED = 8;
	public final static int INFLUENCE_LOWER_CABIN_CONTROL_APPLIED = 9;
	
	public final static int NULL_ULCC_MIN = -1;
	
	public final static String F_CABIN = "F";	
	public final static String C_CABIN = "C";	
	public final static String W_CABIN = "W";	
	public final static String Y_CABIN = "Y";
	
	// Query Constants
	//
	public static class Query
	{		
	    public static final String PNR_SQL_EXPRESSION_1 = "cabin=? and origin=? and dest=? and fcstDow=? and forecastId=? and rrd<=?";
	    public static final String PNR_SQL_EXPRESSION_2 = "cabin=? and origin=? and dest=? and forecastId=? and rrd<=? and YDBucket=?";
	}
}
