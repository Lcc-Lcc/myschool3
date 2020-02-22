package dao;

import java.util.List;

import entity.Grade;

public interface GradeDao {

	List<Grade> selectAll();
	int deleteGrade(int gradeid) throws Exception;
}
