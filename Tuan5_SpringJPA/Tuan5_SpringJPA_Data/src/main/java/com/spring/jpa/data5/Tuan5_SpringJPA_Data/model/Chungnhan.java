package com.spring.jpa.data5.Tuan5_SpringJPA_Data.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "chungnhan")
@IdClass(ChungnhanPk.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chungnhan {
    @Id
    @ManyToOne
    @JoinColumn(name = "MaNV")
    @JsonManagedReference
    private Nhanvien nhanvien;
    @Id
    @ManyToOne
    @JoinColumn(name = "MaMB")
    @JsonManagedReference
    private Maybay maybay;

}
