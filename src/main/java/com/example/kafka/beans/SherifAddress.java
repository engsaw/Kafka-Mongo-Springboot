package com.example.kafka.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@Setter
@AllArgsConstructor
public class SherifAddress {
    public String street;
    public String houseNumber;
    public String postalCode;
}
