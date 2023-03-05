package com.example.clean.archicture.pichincha.entities;

import com.example.clean.archicture.shared.enums.GenderPerson;
import com.example.clean.archicture.shared.enums.IdentificationPattern;

import java.util.Date;

public class ClientCore {
    private Long clientId;
    private String fullName;
    private GenderPerson genderPerson;
    private Integer age;
    private String dni;
    private IdentificationPattern identificationPattern;
    private String address;
    private String phone;
    private String password;
    private Boolean status;
    private Date createDate;

    public ClientCore() {
    }

    public ClientCore(Long clientId, String fullName, GenderPerson genderPerson, Integer age, String dni, IdentificationPattern identificationPattern, String address, String phone, String password, Boolean status) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.genderPerson = genderPerson;
        this.age = age;
        this.dni = dni;
        this.identificationPattern = identificationPattern;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.status = status;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public GenderPerson getGenderPerson() {
        return genderPerson;
    }

    public void setGenderPerson(GenderPerson genderPerson) {
        this.genderPerson = genderPerson;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public IdentificationPattern getIdentificationPattern() {
        return identificationPattern;
    }

    public void setIdentificationPattern(IdentificationPattern identificationPattern) {
        this.identificationPattern = identificationPattern;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
