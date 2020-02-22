package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {

	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	public void executeQuery(String sql,Object[] ob)
	{
		try {
			ps=conn.prepareStatement(sql);
			if(ob!=null)
			{
				for(int i=0;i<ob.length;i++)
				{
					ps.setObject(i+1, ob[i]);
				}
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int executeUpdate(String sql,Object[] ob) throws Exception
	{
		int result=0;
		try {
			ps=conn.prepareStatement(sql);
			if(ob!=null)
			{
				for(int i=0;i<ob.length;i++)
				{
					ps.setObject(i+1,ob[i]);
				}
			}
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("·¢Éú´íÎó");
		}
		finally
		{
			DataBaseUtil.closeAll(null, ps, null);
		}
		return result;
	}
}
