package com.lti.service;

import java.util.List;
import java.util.Set;

import com.lti.dao.MusicalDao;
import com.lti.entity.Album;
import com.lti.entity.Song;

public class MusicService {
	
	MusicalDao dao =new MusicalDao();
	
	public void insertSong(Song song,int id) {
		Album album = (Album) dao.fetchById(Album.class, id);
		song.setAlbum(album);
		dao.save(song);
	}

	public void insertAlbum(Album Album) {
		dao.save(Album);
	}
	
	public void transferAlbum (int song_id,int toAlbum_id) {
		Song song = (Song) dao.fetchById(Song.class, song_id);
		Album album = (Album) dao.fetchById(Album.class , toAlbum_id);
		song.setAlbum(album);
		dao.save(song);
	}
	
	public List<Song> showSongByArtist(String name) {
		List<Song> list = dao.fetchSongsByArtist(name);
		return list;
	}
	
	public List<Album> showSongByAlbum(String name) {
		List<Album> list = dao.fetchSongsByAlbum(name);
		return list;
	}
}
