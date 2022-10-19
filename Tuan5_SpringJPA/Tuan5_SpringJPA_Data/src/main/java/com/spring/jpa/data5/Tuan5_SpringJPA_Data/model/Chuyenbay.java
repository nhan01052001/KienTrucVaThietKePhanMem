package com.spring.jpa.data5.Tuan5_SpringJPA_Data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "chuyenbay")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chuyenbay {
    @Id
    private String macb;
    private String gadi;
    private String gaden;
    private int dodai;
    private LocalTime giodi;
    private LocalTime gioden;
    private Double chiphi;
}