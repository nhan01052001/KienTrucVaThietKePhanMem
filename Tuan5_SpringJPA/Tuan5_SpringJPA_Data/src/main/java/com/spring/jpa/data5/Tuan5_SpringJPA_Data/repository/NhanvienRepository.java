package com.spring.jpa.data5.Tuan5_SpringJPA_Data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.jpa.data5.Tuan5_SpringJPA_Data.model.Nhanvien;

import java.util.List;

public interface NhanvienRepository extends JpaRepository<Nhanvien,String> {
    public List<Nhanvien> findByLuongLessThanEqual(double luong);
    @Query(value = "select sum(luong) from nhanvien",nativeQuery = true)
    public Double getSumByLuong();

    @Query(value = "select nv.* from nhanvien nv inner join chungnhan cn on nv.manv=cn.manv\n" +
            "            inner join maybay mb on cn.mamb= mb.mamb where loai like %?1% group by nv.manv",nativeQuery = true)
    public List<Nhanvien> findByMaybay(String loai);
    @Query(value = "select * from nhanvien nv inner join chungnhan cn on nv.manv=cn.manv where cn.mamb=?1",nativeQuery = true)
    public List<Nhanvien> findByMaMaybay(int mamb);

    @Query(value = "select nv.manv from  nhanvien nv inner join chungnhan cn on nv.manv = cn.manv\n" +
            "                           inner join maybay mb on mb.mamb = cn.mamb\n" +
            "where ( mb.loai like ?1%) and nv.manv in (select nv.manv from  nhanvien nv inner join chungnhan cn on nv.manv = cn.manv\n" +
            "                                                                                 inner join maybay mb on mb.mamb = cn.mamb\n" +
            "                                                where ( mb.loai like ?2%))\n" +
            "group by nv.manv",nativeQuery = true)
    public List<String> findIdBy2Loaimb(String loai1, String loai2);

    @Query( "select n, count(m.loai)  from nhanvien n inner join n.chungnhans c inner join c.maybay m " +
            " group by n.manv " +
            "having count(m.loai)=?1")
    public List<?> findBySoLoaimb(long soloai);
    @Query( "select n, max(m.tambay)  from nhanvien n inner join n.chungnhans c inner join c.maybay m " +
            " group by n.manv " +
            "having count(m.loai)>=?1")
    public List<?> findBySoLoaimbMoreThanEqual(long soloai);

    @Query( "select n, count(m.loai)  from nhanvien n inner join n.chungnhans c inner join c.maybay m " +
            " group by n.manv ")
    public List<?> countMaybayOfNv();

    @Query("select  n from nhanvien n left join n.chungnhans c " +
            "where c.nhanvien is null")
    public List<Nhanvien> findByNotChungnhan();

    @Query("select n from nhanvien n where n.luong >= (select max(n2.luong) from nhanvien n2 )")
    public List<Nhanvien> findByLuongMax();

    @Query("select  sum(n.luong) from nhanvien n  join n.chungnhans c")
    public Double getSumLuongPhicong();

}
