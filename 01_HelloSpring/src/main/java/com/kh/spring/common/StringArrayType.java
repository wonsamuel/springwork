package com.kh.spring.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

//String배열은 이렇게 처리해라 정해주는 클래스
//이 클래스를 만들어줄  때 TypeHandler 인터패이스를 add해야 함
//<>이 제네릭 안에 내가 어떤 자료형의 대한 설정을 할지 그 자료형을 쓰면 됨 in this case <String[]>

//만들고 mapper의 typeHandler 넣어주고 config에서 설정해서 불러오고
public class StringArrayType implements TypeHandler<String[]> {

	@Override
	public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		if(parameter!=null) {
			ps.setString(i, String.join(",", parameter));
		}else {
			ps.setString(i, "");
		}

	}

	@Override
	public String[] getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return rs.getString(columnName).split(",");
	}

	@Override
	public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return rs.getString(columnIndex).split(",");
	}

	@Override
	public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return cs.getString(columnIndex).split(",");
	}

}
