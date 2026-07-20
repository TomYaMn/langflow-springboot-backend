package com.tomyamn.langflow_intranet_springboot.dto;

public class ApplicationDTO extends BaseDTO {
    private Long id;
    private String applicationNo;
    private Long submittedByInternetUserId; // Required
    private Long reviewedByIntranetUserId;  // Optional
    private Integer status;                 // Required
    private String intranetUserRemark;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getApplicationNo() { return applicationNo; }
    public void setApplicationNo(String applicationNo) { this.applicationNo = applicationNo; }

    public Long getSubmittedByInternetUserId() { return submittedByInternetUserId; }
    public void setSubmittedByInternetUserId(Long submittedByInternetUserId) { this.submittedByInternetUserId = submittedByInternetUserId; }

    public Long getReviewedByIntranetUserId() { return reviewedByIntranetUserId; }
    public void setReviewedByIntranetUserId(Long reviewedByIntranetUserId) { this.reviewedByIntranetUserId = reviewedByIntranetUserId; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public String getIntranetUserRemark() { return intranetUserRemark; }
    public void setIntranetUserRemark(String intranetUserRemark) { this.intranetUserRemark = intranetUserRemark; }
}