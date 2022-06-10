package org.example.enumApproch.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobTitle {

private int id;
private String jobTitle;
private BigDecimal grossAverage;




}
