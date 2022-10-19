package com.spring.jpa.data5.Tuan5_SpringJPA_Data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.jpa.data5.Tuan5_SpringJPA_Data.model.Maybay;

import java.util.List;
import java.util.Map;

public interface MaybayRepository extends JpaRepository<Maybay,Integer> {

    @Query(value = "select * from maybay where tambay>=?1",nativeQuery = true)
    public List<Maybay> findByTambayMoreThanNKm(Integer tambay);

    @Query(value = "select  count(*) from maybay where loai like %?1%",nativeQuery = true)
    public Integer countMaybayByLoai(String loai);

    @Query(value = "select * from maybay mb inner join chungnhan cn on mb.mamb=cn.mamb" +
            "    inner join nhanvien nv on cn.manv= nv.manv where nv.ten like ?1%",nativeQuery = true)
    public List<Maybay> findByHoNhanvien(String honv);

    @Query(value = "select mb.* from maybay mb " +
            "where mb.tambay >= (select cb.dodai from chuyenbay cb where cb.macb=?1)",nativeQuery = true)
    public List<Maybay> findByMacb(String macb);

@Query(value = "select m.mamb,m.loai, Count(n.manv) from maybay m join chungnhan c on m.mamb = c.mamb join nhanvien n on n.manv = c.manv " +
        "group by m.mamb" , nativeQuery = true)
    public List<?> countNhanVienByMaybay();
}