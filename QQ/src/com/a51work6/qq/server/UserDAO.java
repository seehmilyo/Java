package com.a51work6.qq.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
	public List<Map<String,String>> findAll(){
		List<Map<String,String>> list=new ArrayList<>();
		String sql="select user_id,user_pwd,user_name,user_icon from user";
		try {
			Connection conn=null;
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			//遍历结果集合
			while(rs.next()) {
				Map<String,String> row=new HashMap<String,String>();
				row.put("user_id", rs.getString("user_id"));
				row.put("user_pwd", rs.getString("user_pwd"));
				row.put("user_name", rs.getString("user_name"));
				row.put("user_icon", rs.getString("user_icon"));
				list.add(row);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
	public Map<String,String> findByID(String id){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select user_id,user_pwd,user_name,user_icon from user where user_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			//遍历结果集合
			if(rs.next()) {
				Map<String,String> row=new HashMap<String,String>();
				row.put("user_id", rs.getString("user_id"));
				row.put("user_pwd", rs.getString("user_pwd"));
				row.put("user_name", rs.getString("user_name"));
				row.put("user_icon", rs.getString("user_icon"));

				return row;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				}
			if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			}
		}
		return null;
	}
	public List<Map<String,String>> findFriends(String id){
		List<Map<String,String>> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select user_id,user_pwd,user_name,user_icon from user where user_id in (select user_id2 as user_id from friends where user_id1=?) or user_id in (select user_id1 as user_id from friend where user_id2=?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			//遍历结果集合
			if(rs.next()) {
				Map<String,String> row=new HashMap<String,String>();
				row.put("user_id", rs.getString("user_id"));
				row.put("user_pwd", rs.getString("user_pwd"));
				row.put("user_name", rs.getString("user_name"));
				row.put("user_icon", rs.getString("user_icon"));

				list.add(row);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				}
			if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			}
		}
		return list;
	}
}
