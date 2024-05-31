package com.mirea.kt.ribo.datastorageapplication;

public class Doctor {

    private String FirstName;
    private String LastName;
    private String Specialization;
    private boolean Certification;

    public Doctor(String firstName, String lastName, String specialization, Boolean certification) {
        FirstName = firstName;
        LastName = lastName;
        Specialization = specialization;
        Certification = certification;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public Boolean getCertification() {
        return Certification;
    }
    public boolean isCertified() {  // Method to check certification status
        return Certification;
    }

    public void setCertification(Boolean certification) {
        Certification = certification;
    }
}
