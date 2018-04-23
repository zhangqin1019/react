package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {
	private String driver = 
			"com.mysql.jdbc.Driver";// 数据库驱动字符串
	private String url = 
		"jdbc:mysql://localhost:3306/angular?user=root&password=123456";// 连接URL字符串
	
	/**
	 * 获取数据库连接对象。
	 */
	public Connection getConnection() {
		Connection conn = null;// 数据连接对象
		if(conn==null){
			// 获取连接并捕获异常
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return conn;// 返回连接对象
	}
	/**
	 * 关闭数据库连接。
	 * @param conn 数据库连接
	 * @param stmt Statement对象
	 * @param rs 结果集
	 */
	public void closeAll(Connection conn, PreparedStatement psm, 
					ResultSet rs) {
		// 若结果集对象不为空，则关闭
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// 若Statement对象不为空，则关闭
		if (psm != null) {
			try {
				psm.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// 若数据库连接对象不为空，则关闭
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	/**
	 * 增、删、改的操作
	 * @param sql 预编译的 SQL 语句          
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组          
	 * @return 影响的行数
	 */
	public int exceuteUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		Connection conn =  getConnection(); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			num = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally{
			closeAll(conn, pstmt, null);
		}
		return num;
	}
}
