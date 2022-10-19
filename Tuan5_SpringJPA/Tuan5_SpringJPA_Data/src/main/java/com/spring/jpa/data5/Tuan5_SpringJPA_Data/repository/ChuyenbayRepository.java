package com.spring.jpa.data5.Tuan5_SpringJPA_Data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.jpa.data5.Tuan5_SpringJPA_Data.model.Chuyenbay;

import java.time.LocalTime;
import java.util.List;


public interface ChuyenbayRepository extends JpaRepository<Chuyenbay, String> {
    public List<Chuyenbay> findByGaden(String gaden);

    public List<Chuyenbay> findByDodaiBetween(int min, int max);

    public List<Chuyenbay> findByGadiAndGaden(String gadi, String gaden);


    public Integer countChuyenbayByGadi(String gadi);

    @Query("select cb from maybay mb,chuyenbay cb " +
            "where mb.loai=?1 and cb.dodai <= mb.tambay")
    public List<Chuyenbay> findByMayBay(String loaimb);

    @Query(value = "select * from chuyenbay where (gadi=?1 and gaden=?2) or (gadi=?2 and gaden=?1)", nativeQuery = true)
    public List<Chuyenbay> findByDuongBay(String gadi, String gaden);
    @Query(value = "select cb, (select count(c.gadi) from chuyenbay c where c.gadi=cb.gadi) " +
        " from chuyenbay cb group by cb.macb,cb.gaden")
    public List<?> countChuyenbayByGadi();

    @Query("select c, (select sum(cb.chiphi) from chuyenbay cb where cb.gadi=c.gadi) from chuyenbay c group by c.macb")
    public List<?> estimateSumChiphi();


    public List<Chuyenbay> findByGiodiBefore(LocalTime giodi);

    @Query(value = "select c.gadi,count(*) from chuyenbay c where c.giodi<=?1 group by c.gadi",nativeQuery = true)
    public List<?> countChuyenBayForGadiBefore(LocalTime time);

    @Query("select c from chuyenbay c where c.dodai<= (select min(m.tambay) from  maybay m where m.loai like ?1%)")
    public List<Chuyenbay> findByLoaiMaybay(String loai);
}
