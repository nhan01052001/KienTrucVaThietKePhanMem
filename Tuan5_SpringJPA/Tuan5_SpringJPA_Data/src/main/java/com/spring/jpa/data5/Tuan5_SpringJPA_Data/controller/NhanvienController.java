package com.spring.jpa.data5.Tuan5_SpringJPA_Data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.data5.Tuan5_SpringJPA_Data.model.Nhanvien;
import com.spring.jpa.data5.Tuan5_SpringJPA_Data.repository.NhanvienRepository;

import java.util.List;

@RestController
public class NhanvienController {
    @Autowired
    private NhanvienRepository nhanvienRepository;

    @GetMapping("cau3")
    public List<Nhanvien> cau3() {
        return nhanvienRepository.findByLuongLessThanEqual(10000);
    }

    @GetMapping("cau8")
    public Double cau8() {
        return nhanvienRepository.getSumByLuong();
    }

    @GetMapping("cau10")
    public List<Nhanvien> cau10() {
        return nhanvienRepository.findByMaMaybay(747);
    }

    @GetMapping("cau12")
    public List<String> cau12() {
        return nhanvienRepository.findIdBy2Loaimb("Boeing", "Airbus");
    }

    @GetMapping("cau15")
    public List<Nhanvien> cau15() {
        return nhanvienRepository.findByMaybay("Boeing");
    }

    @GetMapping("cau22")
    public List<?> cau22() {
        return nhanvienRepository.findBySoLoaimb(3);
    }

    @GetMapping("cau23")
    public List<?> cau23() {
        return nhanvienRepository.findBySoLoaimbMoreThanEqual(3);
    }

    @GetMapping("cau24")
    public List<?> cau24() {
        return nhanvienRepository.countMaybayOfNv();
    }

    @GetMapping("cau25")
    public List<Nhanvien> cau25() {
        return nhanvienRepository.findByNotChungnhan();
    }

    @GetMapping("cau26")
    public List<Nhanvien> ca26() {
        return nhanvienRepository.findByLuongMax();
    }

    @GetMapping("cau27")
    public Double cau27() {
        return nhanvienRepository.getSumLuongPhicong();
    }
}
