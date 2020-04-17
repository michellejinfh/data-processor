package com.aa.rm.optimizer.cloudpoc.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class Bucket 
{
	private int ydBucketId;
	private double lowerBound;
	private double upperBound;
	private int localSeatsAllocation;
	private int localSeatsAllocationEff;
	private int flowSeatsAllocation;
	private List<PNR> pnrList;
	private int totalPnrCount;
	private double totalTrafficCount;
	private int bpcDefaultInd;
	private float currClsFare;
	private float nextClsFare;
	
	public Bucket() {
		pnrList = new ArrayList<PNR>();
	}

	@Override
	public String toString() {
		StringBuffer lclCutoffPoints = new StringBuffer();
		
		if(currClsFare>0 && nextClsFare<=0)
		{
			for(int i=1; i<=localSeatsAllocationEff; i++)
			{
				lclCutoffPoints.append(BigDecimal.valueOf((double)i/(localSeatsAllocationEff+1)).setScale(3, RoundingMode.HALF_UP).doubleValue()).append(",");
			}
		}
		else
		{
			for(int i=1; i<=localSeatsAllocation; i++)
			{
				lclCutoffPoints.append(BigDecimal.valueOf((double)i/(localSeatsAllocation+1)).setScale(3, RoundingMode.HALF_UP).doubleValue()).append(",");
			}
		}
		
		StringBuffer flowCutoffPoints = new StringBuffer();
		for(int i=1; i<=flowSeatsAllocation; i++)
		{
			flowCutoffPoints.append(BigDecimal.valueOf((double)i/(flowSeatsAllocation+1)).setScale(3, RoundingMode.HALF_UP).doubleValue()).append(",");
		}
		
		return "Bucket [YDBucket=" + ydBucketId + ", lowerBound=" + lowerBound + ", upperBound=" + upperBound
				+ ", lclSeats=" + localSeatsAllocation  + ", lclSeatsEff=" + localSeatsAllocationEff + ", flowSeats=" + flowSeatsAllocation + ", totalPnrCount=" + totalPnrCount
				+ ", totalTrafficCount=" + totalTrafficCount  + ", currClsFare=" + currClsFare + ", nextClsFare=" + nextClsFare
				+ ", \n\tlclCutoff=[" + lclCutoffPoints.toString() + "]\n\tflowCutoff=[" + flowCutoffPoints.toString() + "]";
	}

	public void reset()
	{
		setYdBucketId(-1);
		setLowerBound(-1);
		setUpperBound(-1);
		setLocalSeatsAllocation(-1);
		setLocalSeatsAllocationEff(-1);
		setFlowSeatsAllocation(-1);
		setTotalPnrCount(0);
		setTotalTrafficCount(0);
		setBpcDefaultInd(0);
		setCurrClsFare(0);
		setNextClsFare(0);
		pnrList.clear();
	}
	
	public int getYdBucketId() {
		return ydBucketId;
	}

	public void setYdBucketId(int ydBucketId) {
		this.ydBucketId = ydBucketId;
	}

	public double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(double lowerBound) {
		this.lowerBound = lowerBound;
	}

	public double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(double upperBound) {
		this.upperBound = upperBound;
	}

	public int getLocalSeatsAllocation() {
		return localSeatsAllocation;
	}

	public void setLocalSeatsAllocation(int localSeatsAllocation) {
		this.localSeatsAllocation = localSeatsAllocation;
	}

	public int getLocalSeatsAllocationEff() {
		return localSeatsAllocationEff;
	}

	public void setLocalSeatsAllocationEff(int localSeatsAllocationEff) {
		this.localSeatsAllocationEff = localSeatsAllocationEff;
	}

	public int getFlowSeatsAllocation() {
		return flowSeatsAllocation;
	}

	public void setFlowSeatsAllocation(int flowSeatsAllocation) {
		this.flowSeatsAllocation = flowSeatsAllocation;
	}

	public List<PNR> getPnrList() {
		return pnrList;
	}

	public void setPnrList(List<PNR> pnrList) {
		this.pnrList = pnrList;
	}

	public int getTotalPnrCount() {
		return totalPnrCount;
	}

	public void setTotalPnrCount(int totalPnrCount) {
		this.totalPnrCount = totalPnrCount;
	}
	
	public double getTotalTrafficCount() {
		return totalTrafficCount;
	}

	public void setTotalTrafficCount(double totalTrafficCount) {
		this.totalTrafficCount = totalTrafficCount;
	}

	public int getBpcDefaultInd() {
		return bpcDefaultInd;
	}

	public void setBpcDefaultInd(int bpcDefaultInd) {
		this.bpcDefaultInd = bpcDefaultInd;
	}

	public float getCurrClsFare() {
		return currClsFare;
	}

	public void setCurrClsFare(float currClsFare) {
		this.currClsFare = currClsFare;
	}

	public float getNextClsFare() {
		return nextClsFare;
	}

	public void setNextClsFare(float nextClsFare) {
		this.nextClsFare = nextClsFare;
	}
}
