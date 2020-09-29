package com.airmusic.dao.impl;

import com.airmusic.dao.AirMusicDao;
import com.airmusic.dao.BaseMapper;
import com.airmusic.entiy.SongList;

public class AirMusciDaoImpl implements AirMusicDao {
    @Override
    public int addSongList(SongList songList) {

        int result = 0;

        result =BaseMapper.getMapperAgency().addSongListger(songList);
        BaseMapper.commit();

        if(result>0){
            BaseMapper.closeSession();
            return result;
        }else{
            BaseMapper.closeSession();
        }
        return result;
    }
}
