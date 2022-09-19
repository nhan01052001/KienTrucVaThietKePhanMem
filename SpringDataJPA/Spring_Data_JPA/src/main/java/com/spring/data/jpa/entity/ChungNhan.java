package com.spring.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHUNGNHAN")
public class ChungNhan {
	
	@Column(name="MaNV")
	private int MaNV;
	
	@Column(name="MaMB")
	private int MaMB;

	public int getMaNV() {
		return MaNV;
	}

	public void setMaNV(int maNV) {
		MaNV = maNV;
	}

	public int getMaMB() {
		return MaMB;
	}

	public void setMaMB(int maMB) {
		MaMB = maMB;
	}

	public ChungNhan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChungNhan(int maNV, int maMB) {
		super();
		MaNV = maNV;
		MaMB = maMB;
	}

	@Override
	public String toString() {
		return "ChungNhan [MaNV=" + MaNV + ", MaMB=" + MaMB + "]";
	}
	
}
