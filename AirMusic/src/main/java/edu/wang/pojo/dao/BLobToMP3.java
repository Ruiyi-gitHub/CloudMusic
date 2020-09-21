package edu.wang.pojo.dao;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.PreparedStatement;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BLobToMP3 extends BaseTypeHandler<String> {
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    String parameter, JdbcType jdbcType) throws SQLException {
        //声明一个输入流对象
        ByteArrayInputStream bis;
        //把字符串转为字节流
        bis = new ByteArrayInputStream(parameter.getBytes(StandardCharsets.UTF_8));
        ps.setBinaryStream(i, bis, parameter.length());
    }

    @Override
    public void setNonNullParameter(java.sql.PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        Blob blob = (Blob) rs.getBlob(columnName);
        byte[] returnValue = null;
        if (null != blob) {
            returnValue = blob.getBytes(1, (int) blob.length());
        }
        //将取出的流对象转为utf-8的字符串对象
        return new String(returnValue, StandardCharsets.UTF_8);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}