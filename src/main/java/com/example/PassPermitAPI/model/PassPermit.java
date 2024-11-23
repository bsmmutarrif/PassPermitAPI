package com.example.PassPermitAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class PassPermit
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "ownerIdNumber cannot be null or blank.")
    private Integer id;
    @NotBlank(message = "ownerIdNumber cannot be null or blank.")
    private String vehicleNumber;
    private String vehicleDetails;
    @NotBlank(message = "ownerIdNumber cannot be null or blank.")
    private String ownerIdNumber;
    @NotBlank(message = "ownerName cannot be null or blank.")
    private String ownerName;
    @NotBlank(message = "nationality cannot be null or blank.")
    private String nationality;
//    @NotBlank(message = "ID cannot be null or blank.")
    private boolean isActive;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getVehicleNumber() {

        return vehicleNumber;
    }
    @NotBlank(message = "vehicleNumber cannot be null or blank.")
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }



    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }



    public String getOwnerIdNumber() {
        return ownerIdNumber;
    }

    public void setOwnerIdNumber(String ownerIdNumber) {
        this.ownerIdNumber = ownerIdNumber;
    }



    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }



    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }



    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }



}
