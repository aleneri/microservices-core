package com.nerisa.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker implements Serializable {

    private static final long serialVersionUID = -1975108546252622311L;

    private Long id;
    private String name;
    private Double dailyIncome;

}
