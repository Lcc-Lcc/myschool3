package service;

import java.util.List;

import entity.Grade;

public interface GradeDaoService {

	List<Grade> selectAll();
	int deleteGrade(int gradeid);
}
