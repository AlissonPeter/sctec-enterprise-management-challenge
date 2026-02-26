package sctec.enterprise.management.challenge.model;

import jakarta.persistence.*;
import sctec.enterprise.management.challenge.model.enums.Segment;

import java.util.Objects;

public class Enterprise {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String enterpriseName;
    @Column(length = 100, nullable = false)
    private String ownerName;
    @Column(length = 100, nullable = false)
    private String city;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Segment segment;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(nullable = false)
    private boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Enterprise that = (Enterprise) o;
        return status == that.status && Objects.equals(id, that.id) && Objects.equals(enterpriseName, that.enterpriseName) && Objects.equals(ownerName, that.ownerName) && Objects.equals(city, that.city) && Objects.equals(segment, that.segment) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enterpriseName, ownerName, city, segment, email, status);
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", city='" + city + '\'' +
                ", segment='" + segment + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
