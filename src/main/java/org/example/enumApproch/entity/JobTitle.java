package org.example.enumApproch.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobTitle {

    private int id;
    private String jobTitle;
    private BigDecimal grossAverage;

}
