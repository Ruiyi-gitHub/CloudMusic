package com.airmusic.dao;

import com.airmusic.entiy.SongList;
import com.airmusic.entiy.Picture;

import java.util.List;

public interface UserMapper {
    /**批量插入图片路径的方法*/
    public int importPicturePath(List<Picture> prictures);

    /**新增歌单的方法*/
    public int addSongListger(SongList songList);
}
