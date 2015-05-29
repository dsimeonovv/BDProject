package com.libraries.service;

import java.sql.SQLException;
import java.util.List;

import com.libraries.db.LibraryDao;
import com.libraries.domain.Author;
import com.libraries.domain.Magazine;

public class MagazinesService {
	
	private LibraryDao libraryDao;
	
	public List<Magazine> getAllMagazines(){
		return null;
	}
	
	public void insertAuthor(Author author) throws SQLException{
		
		//libraryDao.insertAuthor();
	}
}
