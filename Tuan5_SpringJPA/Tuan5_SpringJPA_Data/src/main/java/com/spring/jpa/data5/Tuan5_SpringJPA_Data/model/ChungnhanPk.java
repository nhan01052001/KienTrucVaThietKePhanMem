package com.spring.jpa.data5.Tuan5_SpringJPA_Data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"nhanvine","maybay"})
public class ChungnhanPk implements Serializable {
    private String nhanvien;
    private int maybay;
}