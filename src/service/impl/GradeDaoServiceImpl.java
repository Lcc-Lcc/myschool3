package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.DataBaseUtil;
import dao.impl.GradeDaoImpl;
import dao.impl.SubjectDaoImpl;

import entity.Grade;
import service.GradeDaoService;

public class GradeDaoServiceImpl implements GradeDaoService{

	@Override
	public List<Grade> selectAll() {
		Connection conn=DataBaseUtil.getConnection();
		GradeDaoImpl gd=new GradeDaoImpl(conn);
		List<Grade> list=gd.selectAll();
		DataBaseUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public int deleteGrade(int gradeid) {
		Connection conn=DataBaseUtil.getConnection();
		int result=0;
		try {
			conn.setAutoCommit(false);
			SubjectDaoImpl sb=new SubjectDaoImpl(conn);
            result=sb.deleteSubject(gradeid);
            GradeDaoImpl gd=new GradeDaoImpl(conn);
            result=gd.deleteGrade(gradeid);
            conn.commit();
            return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return 0;
		}finally
		{
			DataBaseUtil.closeAll(conn,null,null);
		}
		
	}

}
