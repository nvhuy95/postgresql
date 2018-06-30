package com.huy.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.huy.model.select001Result;

@Repository
public class ItemRepository {

	@Autowired
	JdbcTemplate jdbctemplate;

	public List<select001Result> select001(String category) {
		String query = "SELECT ITEM.ID , ITEM.NAME , CATEGORY.NAME AS CATEGORYNAME FROM ITEM INNER JOIN CATEGORY ON ITEM.ID = CATEGORY.ID WHERE ITEM.CATEGORY = ?";
		List<select001Result> list = jdbctemplate.query(query, new Object[] { category },
				new BeanPropertyRowMapper<select001Result>(select001Result.class));
		return list;
	}

	public List<String> select002(String category) {
		String query = "SELECT NAME FROM ITEM WHERE CATEGORY = ?";
		List<String> list = jdbctemplate.queryForList(query, new Object[] { category }, String.class);
		return list;
	}

	public String select004(int id) {
		String query = "SELECT NAME FROM ITEM WHERE ID = ?";
		String item = jdbctemplate.queryForObject(query, new Object[] { id }, String.class);
		return item;
	}
}