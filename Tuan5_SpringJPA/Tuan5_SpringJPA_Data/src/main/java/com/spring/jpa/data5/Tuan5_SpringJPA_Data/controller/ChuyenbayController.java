package com.spring.jpa.data5.Tuan5_SpringJPA_Data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.data5.Tuan5_SpringJPA_Data.model.Chuyenbay;
import com.spring.jpa.data5.Tuan5_SpringJPA_Data.repository.ChuyenbayRepository;

import java.time.LocalTime;
import java.util.List;

@RestController
public class ChuyenbayController {
    @Autowired
    private ChuyenbayRepository chuyenbayRepository;

    @RequestMapping("cau1")
    public List<Chuyenbay> cau1() {
        return chuyenbayRepository.findByGaden("DAD");
    }

    @RequestMapping("cau4")
    public List<Chuyenbay> cau4() {
        return chuyenbayRepository.findByDodaiBetween(8000, 10000);
    }

    @RequestMapping("cau5")
    public List<Chuyenbay> cau5() {
        return chuyenbayRepository.findByGadiAndGaden("SGN", "BMV");
    }

    @RequestMapping("cau6")
    public Integer cau6() {
        return chuyenbayRepository.countChuyenbayByGadi("SGN");
    }

    @GetMapping("cau14")
    public List<Chuyenbay> cau14() {
        return chuyenbayRepository.findByMayBay("Airbus A320");
    }

    @GetMapping("cau17")
    public List<Chuyenbay> cau17() {
        return chuyenbayRepository.findByDuongBay("SGN", "DAD");
    }

    @GetMapping("cau18")
    public List<?> cau18() {
        return chuyenbayRepository.countChuyenbayByGadi();
    }

    @GetMapping("cau19")
    public List<?> cau19() {
        return chuyenbayRepository.estimateSumChiphi();
    }

    @GetMapping("cau20")
    public List<Chuyenbay> cau20() {
        LocalTime localTime = LocalTime.of(12, 00);
        return chuyenbayRepository.findByGiodiBefore(localTime);
    }

    @GetMapping("cau21")
    public List<?> cau21() {
        LocalTime localTime = LocalTime.of(12, 00);
        return chuyenbayRepository.countChuyenBayForGadiBefore(localTime);
    }

    @GetMapping("cau28")
    public List<Chuyenbay> cau28() {
        return chuyenbayRepository.findByLoaiMaybay("Boeing");
    }
}
