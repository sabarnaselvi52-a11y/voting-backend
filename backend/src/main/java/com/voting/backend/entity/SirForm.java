package com.voting.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sir_form")
public class SirForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String electorName;

    @Column(unique = true, nullable = false)
    private String epic;

    private String gender;
    private String dob;

    private String fatherName;
    private String motherName;

    private String address;
    private String district;
    private String taluk;
    private String constituency;
    private String state;
    private String pincode;

    private String mobile;
    private String email;

    private String status;
    private String votingToken;
    private boolean tokenUsed;

    private LocalDateTime submittedAt;

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getElectorName() { return electorName; }
    public void setElectorName(String electorName) { this.electorName = electorName; }

    public String getEpic() { return epic; }
    public void setEpic(String epic) { this.epic = epic; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getMotherName() { return motherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getTaluk() { return taluk; }
    public void setTaluk(String taluk) { this.taluk = taluk; }

    public String getConstituency() { return constituency; }
    public void setConstituency(String constituency) { this.constituency = constituency; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getVotingToken() { return votingToken; }
    public void setVotingToken(String votingToken) { this.votingToken = votingToken; }

    public boolean isTokenUsed() { return tokenUsed; }
    public void setTokenUsed(boolean tokenUsed) { this.tokenUsed = tokenUsed; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
}
