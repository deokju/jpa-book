package entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class Board {

    @Id
    @GeneratedValue
    private Long id;
    private Long userIdx;
    private Long serverIdx;
    private String title;
    private String orderCode;
    private String companyName;
    private String siteName;
    private String siteUser;
    private String siteUserPhone;
    private String siteUserEmail;
    private String siteAddress;
    private String content;

    @Column(name = "regDate", columnDefinition = "TIMESTAMP")
    private LocalDateTime regDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    public Long getServerIdx() {
        return serverIdx;
    }

    public void setServerIdx(Long serverIdx) {
        this.serverIdx = serverIdx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUser() {
        return siteUser;
    }

    public void setSiteUser(String siteUser) {
        this.siteUser = siteUser;
    }

    public String getSiteUserPhone() {
        return siteUserPhone;
    }

    public void setSiteUserPhone(String siteUserPhone) {
        this.siteUserPhone = siteUserPhone;
    }

    public String getSiteUserEmail() {
        return siteUserEmail;
    }

    public void setSiteUserEmail(String siteUserEmail) {
        this.siteUserEmail = siteUserEmail;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", userIdx=" + userIdx +
                ", serverIdx=" + serverIdx +
                ", title='" + title + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", siteName='" + siteName + '\'' +
                ", siteUser='" + siteUser + '\'' +
                ", siteUserPhone='" + siteUserPhone + '\'' +
                ", siteUserEmail='" + siteUserEmail + '\'' +
                ", siteAddress='" + siteAddress + '\'' +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
