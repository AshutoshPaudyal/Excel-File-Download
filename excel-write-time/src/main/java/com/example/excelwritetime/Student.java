package com.example.excelwritetime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "data_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "emergency_contact_number")
    private String emergencyContactNumber;

    @Column(name = "emergency_contact_name")
    private String emergencyContactName;

    @Column(name = "married_status")
    private String marriedStatus;

    @Column(name = "gender")
    private String gender;

    private String caste;

    private String nationality;

    @Column(name = "citizenship_number")
    private String citizenshipNumber;

    @Column(name = "profile_pic_url")
    private String profilePicUrl;

    @Column(name = "active_status", columnDefinition = "boolean default true")
    private boolean activeStatus;

    private String personalEmail;


    private String ecRelationShip;
}
