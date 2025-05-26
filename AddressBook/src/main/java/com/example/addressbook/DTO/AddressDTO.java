package com.example.addressbook.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
}