package edu.wang.pojo.dao;

import edu.wang.pojo.User;

import java.util.List;

public interface UserMapper {

    public int userAddByDB(User user);

    public int userDelByDB(Integer id);

    public int userUpdateByUser(User user);

    public List<User> userFindByIdTest();

    public int importAudioDB(User user);

    public int importVoiceDB(User user);

    public List<byte[]> dbImportFile();

}
