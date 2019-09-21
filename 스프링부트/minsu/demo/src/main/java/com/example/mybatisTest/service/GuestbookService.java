package com.example.mybatisTest.service;

import java.util.List;

import com.example.mybatisTest.model.dto.GuestbookDTO;

public interface GuestbookService {
	public List<GuestbookDTO> list();
	public void insert(GuestbookDTO dto);
	public GuestbookDTO view(int idx);
	public void update(GuestbookDTO dto);
	public void delete(int idx);
}
