package com.aa.rm.optimizer.cloudpoc.vo;

import com.aa.rm.helios.optimizer.ruleProcessing.EffectiveRule;
import com.aa.rm.optimizer.cloudpoc.util.Constants;
import com.aa.rm.optimizer.common.model.AdditiveRuleData;
import com.aa.rm.optimizer.common.model.DynAvlRuleData;
import com.aa.rm.optimizer.common.model.FlightCabinData;
import com.aa.rm.optimizer.common.model.MultiplicativeRuleData;

import java.util.ArrayList;
import java.util.List;

public class Cabin 
{
	private String cabinCode;
    private int au;
    private int ac;
    private int reshold;
    private int mfDefaultInd;
    private String localFlowInd;
    private float maxLclFare;
    private float minLclCappingFare;
    private List<Bucket> bucketList;
    private EffectiveRule effectiveRule;
    private MultiplicativeRuleData multiRule;
    private AdditiveRuleData additiveRule;
    private DynAvlRuleData dynAvlRuleData;
    private boolean isOAApplied=false;
    private int ulccMin;

    
    public Cabin()
    {
		bucketList = new ArrayList<Bucket>();
    }
    
	public void copy(FlightCabinData cabinData)
	{	
		this.setCabinCode(cabinData.getCabinCode());
		this.setAu(cabinData.getAu());
		this.setAc(cabinData.getAc());
		this.setReshold(cabinData.getReshold());
		this.setMfDefaultInd(cabinData.getMfDefaultInd());
		this.setLocalFlowInd(cabinData.getLocalFlowInd());
		this.setEffectiveRule(cabinData.getEffectiveRule());
		this.setUlccMin(cabinData.getUlccMin());
		this.setMultiRule(cabinData.getMultiRule());
		this.setAdditiveRule(cabinData.getAdditiveRule());
		this.setDynAvlRuleData(cabinData.getDynAvlRule());
		this.setOAApplied(cabinData.isOAApplied());
	}
	
    public void reset()
    {
		this.setCabinCode(null);
		this.setAu(-1);
		this.setAc(-1);
		this.setReshold(-1);
		this.setMaxLclFare(-1);
		this.setMinLclCappingFare(-1);
		this.setMfDefaultInd(-1);
		this.setLocalFlowInd(null);
		this.setEffectiveRule(null);
		this.setMultiRule(null);
		this.setAdditiveRule(null);
		this.setDynAvlRuleData(null);
		this.setOAApplied(false);
		this.setUlccMin(Constants.NULL_ULCC_MIN); // -1
		this.bucketList.clear();
    }

    public String getBpAdjRules()
	{
		return "\n" +
				(isOAApplied==true ? "OA applied\n" : "") +
				(multiRule!=null ? multiRule : "") +
				(additiveRule!=null ? additiveRule : "") +
				(dynAvlRuleData!=null ? dynAvlRuleData : "") +
				(ulccMin!=Constants.NULL_ULCC_MIN ? "ULCC="+ulccMin+"\n" : "");
	}

	@Override
	public String toString() {
		return "Cabin [CabinCode=" + cabinCode + ", AU=" + au + ", Reshold=" + reshold + ", MaxLclFare=" + maxLclFare
				+ ", minLclCappingFare=" + minLclCappingFare + ", OAFlag=" + isOAApplied + ", effectiveRule=" + effectiveRule 
				+ "," + multiRule + "," + additiveRule + "]";
	}

	public String getCabinCode() {
		return cabinCode;
	}

	public void setCabinCode(String cabinCode) {
		this.cabinCode = cabinCode;
	}

	public int getAu() {
		return au;
	}

	public void setAu(int au) {
		this.au = au;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getReshold() {
		return reshold;
	}

	public void setReshold(int reshold) {
		this.reshold = reshold;
	}

	public int getMfDefaultInd() {
		return mfDefaultInd;
	}

	public void setMfDefaultInd(int mfDefaultInd) {
		this.mfDefaultInd = mfDefaultInd;
	}

	public String getLocalFlowInd() {
		return localFlowInd;
	}

	public void setLocalFlowInd(String localFlowInd) {
		this.localFlowInd = localFlowInd;
	}

	public float getMaxLclFare() {
		return maxLclFare;
	}

	public void setMaxLclFare(float maxLclFare) {
		this.maxLclFare = maxLclFare;
	}

	public float getMinLclCappingFare() {
		return minLclCappingFare;
	}

	public void setMinLclCappingFare(float minLclCappingFare) {
		this.minLclCappingFare = minLclCappingFare;
	}

	public EffectiveRule getEffectiveRule() {
		return effectiveRule;
	}

	public void setEffectiveRule(EffectiveRule effectiveRule) {
		this.effectiveRule = effectiveRule;
	}

	public int getUlccMin() {
		return ulccMin;
	}

	public void setUlccMin(int ulccMin) {
		this.ulccMin = ulccMin;
	}

	public List<Bucket> getBucketList() {
		return bucketList;
	}

	public void setBucketList(List<Bucket> bucketList) {
		this.bucketList = bucketList;
	}

	public MultiplicativeRuleData getMultiRule() {
		return multiRule;
	}

	public void setMultiRule(MultiplicativeRuleData multiRule) {
		this.multiRule = multiRule;
	}

	public AdditiveRuleData getAdditiveRule() {
		return additiveRule;
	}

	public void setAdditiveRule(AdditiveRuleData additiveRule) {
		this.additiveRule = additiveRule;
	}

	public DynAvlRuleData getDynAvlRuleData() {
		return dynAvlRuleData;
	}

	public void setDynAvlRuleData(DynAvlRuleData dynAvlRuleData) {
		this.dynAvlRuleData = dynAvlRuleData;
	}

	public boolean isOAApplied() {
		return isOAApplied;
	}

	public void setOAApplied(boolean isOAApplied) {
		this.isOAApplied = isOAApplied;
	}
	
}
