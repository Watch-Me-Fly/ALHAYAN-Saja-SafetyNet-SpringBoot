package com.safetynet.alertsystem.model;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private long zipCode;
    private String phoneNumber;
    private String email;

}