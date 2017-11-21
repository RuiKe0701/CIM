package team.ruike.cim.pojo;


import java.io.Serializable;

public class StagePurchasingPlan implements Serializable {

  private static final long serialVersionUID = 617372739170617783L;
  private Integer stagePurchasingPlanId;
  private Integer stagePurchasingPlanCycle;
  private String stagePurchasingPlanRemarks;
  private Integer userId;
  private Integer status;


  public Integer getStagePurchasingPlanId() {
    return stagePurchasingPlanId;
  }

  public void setStagePurchasingPlanId(Integer stagePurchasingPlanId) {
    this.stagePurchasingPlanId = stagePurchasingPlanId;
  }


  public Integer getStagePurchasingPlanCycle() {
    return stagePurchasingPlanCycle;
  }

  public void setStagePurchasingPlanCycle(Integer stagePurchasingPlanCycle) {
    this.stagePurchasingPlanCycle = stagePurchasingPlanCycle;
  }


  public String getStagePurchasingPlanRemarks() {
    return stagePurchasingPlanRemarks;
  }

  public void setStagePurchasingPlanRemarks(String stagePurchasingPlanRemarks) {
    this.stagePurchasingPlanRemarks = stagePurchasingPlanRemarks;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}