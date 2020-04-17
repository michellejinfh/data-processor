package com.aa.rm.optimizer.cloudpoc.vo;


public class PNR 
{
	private String pnrLocator;
    private double trafficCount;
    private float legDisplacementValue;
    private double trafficPct;
    private double cumulativePct;
    private boolean included = true;
    
	public PNR() {
	}
	
	@Override
	public String toString() {
		return "PNR [pnrLocator=" + pnrLocator + ", trafficCount=" + trafficCount + ", legDisplacementValue="
				+ legDisplacementValue + ", trafficPct=" + trafficPct + ", cumulativePct=" + cumulativePct
				+ ", included=" + included + "]";
	}

	public PNR reset()
	{
		this.pnrLocator = null;
		this.trafficCount = 0;
		this.legDisplacementValue = 0;
		this.trafficPct = 0;
		this.cumulativePct = 0;
//		this.cumulativePct = BigDecimal.ZERO;;
		this.included = true;
		
		return this;
	}
	
	public String getPnrLocator() {
		return pnrLocator;
	}

	public void setPnrLocator(String pnrLocator) {
		this.pnrLocator = pnrLocator;
	}

	public double getTrafficCount() {
		return trafficCount;
	}

	public void setTrafficCount(double trafficCount) {
		this.trafficCount = trafficCount;
	}

	public float getLegDisplacementValue() {
		return legDisplacementValue;
	}

	public void setLegDisplacementValue(float legDisplacementValue) {
		this.legDisplacementValue = legDisplacementValue;
	}

	public double getTrafficPct() {
		return trafficPct;
	}

	public void setTrafficPct(double trafficPct) {
		this.trafficPct = trafficPct;
	}

	public double getCumulativePct() {
		return cumulativePct;
	}

	public void setCumulativePct(double cumulativePct) {
		this.cumulativePct = cumulativePct;
	}

	public boolean isIncluded() {
		return included;
	}

	public void setIncluded(boolean included) {
		this.included = included;
	}
}
