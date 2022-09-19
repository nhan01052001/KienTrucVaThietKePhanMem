package com.spring.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAYBAY")
public class MayBay {
	
	@Id
	private int MaMB;
	
	@Column(name="Loai")
	private String Loai;
	
	@Column(name="TamBay")
	private float TamBay;

	public int getMaMB() {
		return MaMB;
	}

	public void setMaMB(int maMB) {
		MaMB = maMB;
	}

	public String getLoai() {
		return Loai;
	}

	public void setLoai(String loai) {
		Loai = loai;
	}

	public float getTamBay() {
		return TamBay;
	}

	public void setTamBay(float tamBay) {
		TamBay = tamBay;
	}

	public MayBay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MayBay(int maMB, String loai, float tamBay) {
		super();
		MaMB = maMB;
		Loai = loai;
		TamBay = tamBay;
	}

	@Override
	public String toString() {
		return "MayBay [MaMB=" + MaMB + ", Loai=" + Loai + ", TamBay=" + TamBay + "]";
	}
	
}
