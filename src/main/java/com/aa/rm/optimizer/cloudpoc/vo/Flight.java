package com.aa.rm.optimizer.cloudpoc.vo;

import com.aa.rm.optimizer.common.model.FlightData;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Flight 
{
	private String fltId;
	private Date fltDptrDateAsDate;
	private String fltDptrDateStr;
	private String fltNumber;
	private int fltDptrTime;
    private String origin;
    private String dest;
    private String fcstDow;
    private String fcstId;
    private Date fcstDptrDate;
    private int rrd;
    private Map<String, Cabin> cabinMap;
    
	public Flight() 
	{
		cabinMap = new HashMap<>();
	}

	public void copy(FlightData flightData)
	{
		this.setFltId(flightData.getFltId());
		this.setFltDptrDateAsDate(flightData.getFltDptrDateAsDate());
		this.setFltDptrDateStr(flightData.getFltDptrDateStr());
		this.setFltNumber(flightData.getFltNumber());
		this.setFltDptrTime(flightData.getFltDptrTime());
		this.setOrigin(flightData.getOrigin());
		this.setDest(flightData.getDest());
		this.setFcstDow(flightData.getFcstDow());
		this.setFcstId(flightData.getFcstId());
		this.setFcstDptrDate(flightData.getFcstDptrDate());
		this.setRrd(flightData.getRrd());
//		this.setLocalFlowInd(flightData.getLocalFlowInd());
			
//		this.setCabin(flightData.getCabin());
//		this.setAu(flightData.getAu());
//		this.setAc(flightData.getAc());
//		this.setReshold(flightData.getReshold());
//		this.setMfDefaultInd(flightData.getMfDefaultInd());
//		this.setOipRule(flightData.getOipRule());
//		this.setUlccMin(flightData.getUlccMin());
	}
	
	public void addCabin(Cabin cabin)
	{
		this.cabinMap.put(cabin.getCabinCode(), cabin);
	}
	
	@Override
	public String toString() 
	{
//		if(oipRule==null)
//			return "Flight [fltId=" + fltId + ", fltDptrDateStr=" + fltDptrDateStr + ", origin=" + origin + ", dest=" + dest
//					+ ", fcstDow=" + fcstDow + ", rrd=" + rrd + ", cabin=" + cabin + ", au=" + au + "]";
//		else
//			return "Flight [fltId=" + fltId + ", fltDptrDateStr=" + fltDptrDateStr + ", origin=" + origin + ", dest=" + dest
//					+ ", fcstDow=" + fcstDow + ", rrd=" + rrd + ", cabin=" + cabin + ", au=" + au + ", " + oipRule + "]";

		return "Flight [fltId=" + fltId + ", fltDptrDateStr=" + fltDptrDateStr + ", origin=" + origin + ", dest=" + dest
				+ ", fcstDow=" + fcstDow + ", rrd=" + rrd + ", cabinMap=" + cabinMap + "]";
	}
	
	public String getFltId() {
		return fltId;
	}

	public void setFltId(String fltId) {
		this.fltId = fltId;
	}

	public Date getFltDptrDateAsDate() {
		return fltDptrDateAsDate;
	}

	public void setFltDptrDateAsDate(Date fltDptrDateAsDate) {
		this.fltDptrDateAsDate = fltDptrDateAsDate;
	}

	public String getFltDptrDateStr() {
		return fltDptrDateStr;
	}

	public void setFltDptrDateStr(String fltDptrDateStr) {
		this.fltDptrDateStr = fltDptrDateStr;
	}

	public String getFltNumber() {
		return fltNumber;
	}

	public void setFltNumber(String fltNumber) {
		this.fltNumber = fltNumber;
	}

	public String getFcstDow() {
		return fcstDow;
	}

	public void setFcstDow(String fcstDow) {
		this.fcstDow = fcstDow;
	}

	public String getFcstId() {
		return fcstId;
	}

	public void setFcstId(String fcstId) {
		this.fcstId = fcstId;
	}

	public Date getFcstDptrDate() {
		return fcstDptrDate;
	}

	public void setFcstDptrDate(Date fcstDptrDate) {
		this.fcstDptrDate = fcstDptrDate;
	}

	public int getFltDptrTime() {
		return fltDptrTime;
	}

	public void setFltDptrTime(int fltDptrTime) {
		this.fltDptrTime = fltDptrTime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public int getRrd() {
		return rrd;
	}

	public void setRrd(int rrd) {
		this.rrd = rrd;
	}

	public Map<String, Cabin> getCabinMap() {
		return cabinMap;
	}

	public void setCabinMap(Map<String, Cabin> cabinMap) {
		this.cabinMap = cabinMap;
	}
}
