package com.assessment.upgradeassessment.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_Users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idUser;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_profile", nullable = false)
    private ProfileModel idProfile;

    @Column(nullable = false)
    private Long idEmployee;

    @Column(nullable = false)
    private String Status;

    @Column(nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private Date updateDate;

    @Column(nullable = false)
    private String Login;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProfileModel getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(ProfileModel idProfile) {
        this.idProfile = idProfile;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

}
