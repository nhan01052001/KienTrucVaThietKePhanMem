package com.spring.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
	
	@Id
	private int MaNV;
	
	@Column(name="Ten")
	private String Ten;
	
	@Column(name="Luong")
	private double Luong;

	public int getMaNV() {
		return MaNV;
	}

	public void setMaNV(int maNV) {
		MaNV = maNV;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public double getLuong() {
		return Luong;
	}

	public void setLuong(double luong) {
		Luong = luong;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(int maNV, String ten, double luong) {
		super();
		MaNV = maNV;
		Ten = ten;
		Luong = luong;
	}

	@Override
	public String toString() {
		return "NhanVien [MaNV=" + MaNV + ", Ten=" + Ten + ", Luong=" + Luong + "]";
	}
	
}
