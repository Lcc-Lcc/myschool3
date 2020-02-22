package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.DataBaseUtil;
import dao.GradeDao;
import entity.Grade;

public class GradeDaoImpl extends BaseDao implements GradeDao{
    public GradeDaoImpl(){}
    public GradeDaoImpl(Connection conn){
    	super.conn=conn;
    }
	public List<Grade> selectAll() {
		List<Grade> list=new ArrayList<Grade>();
		String sql="select * from grade";
		super.executeQuery(sql, null);
		try {
			while(rs.next())
			{
				Grade grade=new Grade();
				grade.setGradeid(rs.getInt("gradeid"));
				grade.setGradename(rs.getString("gradename"));
				list.add(grade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataBaseUtil.closeAll(null, ps,rs);
		}
		return list;
	}
	@Override
	public int deleteGrade(int id) throws Exception{
		String sql="delete from grade where gradeid=?";
		Object[] ob={id};
		return super.executeUpdate(sql, ob);
	}

}
