package com.example.c0823g1_movie_backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountName;
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
    private String password;
    private String facebookId;
    private String googleId;
    private String idNumber;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePicture;
    private LocalDate birthday;
    private String phoneNumber;
    private Boolean gender;
    private String email;
    private String address;
    private String memberCode;
    private Integer point;
    @OneToMany(mappedBy = "account")
    private Set<Booking> bookings;
    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

    public Account() {
    }

    public Account(Long id, String accountName, String fullName, Role role, String password, String facebookId, String googleId, String idNumber, String profilePicture, LocalDate birthday, String phoneNumber, Boolean gender, String email, String address, String memberCode, Integer point, Set<Booking> bookings, Boolean isDeleted) {
        this.id = id;
        this.accountName = accountName;
        this.fullName = fullName;
        this.role = role;
        this.password = password;
        this.facebookId = facebookId;
        this.googleId = googleId;
        this.idNumber = idNumber;
        this.profilePicture = profilePicture;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.memberCode = memberCode;
        this.point = point;
        this.bookings = bookings;
        this.isDeleted = isDeleted;
    }

    public Account(String fullName, String facebookId, String profilePicture, String email) {
        this.fullName = fullName;
        this.facebookId = facebookId;
        this.profilePicture = profilePicture;
        this.email = email;
    }

    public Account(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public Account(String email) {
        this.email = email;
    }

    public Account(String fullName, String googleId, String profilePicture, String phoneNumber, String email) {
        this.fullName = fullName;
        this.googleId = googleId;
        this.profilePicture = profilePicture;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
