package com.airmusic.service.impl;

import com.airmusic.dao.impl.AirMusciDaoImpl;
import com.airmusic.entiy.SongList;
import com.airmusic.service.AirMusicService;

public class AirMusicServiceImpl implements AirMusicService {
    AirMusciDaoImpl airMusciDaoImpl = new AirMusciDaoImpl();
    @Override
    public int addSongListServece(SongList songList) {
        return airMusciDaoImpl.addSongList(songList);
    }
}
