package com.example.demo.model;

import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "ContactInformations")
@Data
public class ContactInformation {
    private String email;
    private String mobile;
    private String twitter;
    private String instagram;
}
