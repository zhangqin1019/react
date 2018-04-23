package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {
	private String driver = 
			"com.mysql.jdbc.Driver";// ���ݿ������ַ���
	private String url = 
		"jdbc:mysql://localhost:3306/angular?user=root&password=123456";// ����URL�ַ���
	
	/**
	 * ��ȡ���ݿ����Ӷ���
	 */
	public Connection getConnection() {
		Connection conn = null;// �������Ӷ���
		if(conn==null){
			// ��ȡ���Ӳ������쳣
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return conn;// �������Ӷ���
	}
	/**
	 * �ر����ݿ����ӡ�
	 * @param conn ���ݿ�����
	 * @param stmt Statement����
	 * @param rs �����
	 */
	public void closeAll(Connection conn, PreparedStatement psm, 
					ResultSet rs) {
		// �����������Ϊ�գ���ر�
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// ��Statement����Ϊ�գ���ر�
		if (psm != null) {
			try {
				psm.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// �����ݿ����Ӷ���Ϊ�գ���ر�
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	/**
	 * ����ɾ���ĵĲ���
	 * @param sql Ԥ����� SQL ���          
	 * @param param Ԥ����� SQL ����еġ������������ַ�������          
	 * @return Ӱ�������
	 */
	public int exceuteUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		Connection conn =  getConnection(); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
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
