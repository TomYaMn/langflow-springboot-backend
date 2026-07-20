package com.tomyamn.langflow_intranet_springboot.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_no", nullable = false)
    private String applicationNo;

    @Column(name = "submitted_by_internet_user_id", nullable = false)
    private Long submittedByInternetUserId;

    @Column(name = "reviewed_by_intranet_user_id")
    private Long reviewedByIntranetUserId;

    @Column(nullable = false)
    private Integer status;

    @Column(name = "intranet_user_remark")
    private String intranetUserRemark;

    @Column(name = "created_time", insertable = false, updatable = false)
    private LocalDateTime createdTime;

    @Column(name = "updated_time", insertable = false, updatable = false)
    private LocalDateTime updatedTime;

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
    public LocalDateTime getCreatedTime() { return createdTime; }
    public LocalDateTime getUpdatedTime() { return updatedTime; }
}