package dao.impl;

import java.sql.Connection;

import dao.BaseDao;
import dao.SubjectDao;

public class SubjectDaoImpl extends BaseDao implements SubjectDao{
	public SubjectDaoImpl(){}
	public SubjectDaoImpl(Connection conn){
		super.conn=conn;
	}
	public int deleteSubject(int gradeid) throws Exception{
		String sql="delete from subject where gradeid=?";
		Object ob[]={gradeid};		
		return super.executeUpdate(sql, ob);
	}

}
