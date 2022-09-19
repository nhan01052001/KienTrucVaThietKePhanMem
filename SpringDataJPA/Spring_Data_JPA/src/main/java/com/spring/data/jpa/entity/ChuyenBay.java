package com.spring.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHUYENBAY")
public class ChuyenBay {
	
	@Id
	private int MaCB;
	
	@Column(name="GaDi")
	private String GaDi;
	
	@Column(name="DoDai")
	private int DoDai;
	
	@Column(name="GioDi")
	private int GioDi;
	
	@Column(name="GioDen")
	private int GioDen;
	
	@Column(name="ChiPhi")
	private double ChiPhi;

	public int getMaCB() {
		return MaCB;
	}

	public void setMaCB(int maCB) {
		MaCB = maCB;
	}

	public String getGaDi() {
		return GaDi;
	}

	public void setGaDi(String gaDi) {
		GaDi = gaDi;
	}

	public int getDoDai() {
		return DoDai;
	}

	public void setDoDai(int doDai) {
		DoDai = doDai;
	}

	public int getGioDi() {
		return GioDi;
	}

	public void setGioDi(int gioDi) {
		GioDi = gioDi;
	}

	public int getGioDen() {
		return GioDen;
	}

	public void setGioDen(int gioDen) {
		GioDen = gioDen;
	}

	public double getChiPhi() {
		return ChiPhi;
	}

	public void setChiPhi(double chiPhi) {
		ChiPhi = chiPhi;
	}

	public ChuyenBay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChuyenBay(int maCB, String gaDi, int doDai, int gioDi, int gioDen, double chiPhi) {
		super();
		MaCB = maCB;
		GaDi = gaDi;
		DoDai = doDai;
		GioDi = gioDi;
		GioDen = gioDen;
		ChiPhi = chiPhi;
	}

	@Override
	public String toString() {
		return "ChuyenBay [MaCB=" + MaCB + ", GaDi=" + GaDi + ", DoDai=" + DoDai + ", GioDi=" + GioDi + ", GioDen="
				+ GioDen + ", ChiPhi=" + ChiPhi + "]";
	}
	
}
