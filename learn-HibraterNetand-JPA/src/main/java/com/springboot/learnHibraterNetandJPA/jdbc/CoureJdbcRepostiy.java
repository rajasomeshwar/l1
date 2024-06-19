package com.springboot.learnHibraterNetandJPA.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CoureJdbcRepostiy {
	@Autowired
	private JdbcTemplate springtemplate;
	private String query=
			 """
			  insert into todo values(?,?,?);
			""";
private String select=
 """
		select * from todo where id=?
		""";
//	public void update1()
//	{
//		springtemplate.update(query);
//	}
	public void update1(Course course)
	{
		springtemplate.update(query,course.getId(),course.getName(),course.getAuthor());
	}
	public void delete(int i) {
		// TODO Auto-generated method stub
		springtemplate.update("delete from todo where id=?",i);
		
	}
	
	public Course findbyId(long l)
	{
		return  springtemplate.queryForObject("select * from todo where id="+l, new BeanPropertyRowMapper<>(Course.class));
	}
	

}
