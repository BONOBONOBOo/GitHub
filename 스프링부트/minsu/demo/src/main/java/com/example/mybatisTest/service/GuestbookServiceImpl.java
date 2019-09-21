package com.example.mybatisTest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.mybatisTest.model.dao.GuestbookDAO;
import com.example.mybatisTest.model.dto.GuestbookDTO;

//@service를 통해 Bean으로 등록
@Service
public class GuestbookServiceImpl implements GuestbookService {

	@Inject
	GuestbookDAO guestbookDao;
	
	
	@Override
	public List<GuestbookDTO> list() {
		// TODO Auto-generated method stub
		return guestbookDao.list();
	}

	@Override
	public void insert(GuestbookDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public GuestbookDTO view(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(GuestbookDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub

	}

}
