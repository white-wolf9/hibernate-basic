package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.dao.MusicalDao;
import com.lti.entity.Account;
import com.lti.entity.Album;
import com.lti.entity.Song;
import com.lti.service.MusicService;

public class MusicalTest {

	MusicService musServ = new MusicService();
	
	@Test
	public void testNewAlbum() {
		Album album = new Album();
		album.setName("Kamikaze");
		album.setCopyright("Diamond Production");
		album.setYear(2018);
		musServ.insertAlbum(album);
	}

	@Test
	public void testNewSong() {
		Song song = new Song();
		song.setDuration(2.31);
		song.setSinger("Eminem");
		song.setTitle("Nice Guy");
		musServ.insertSong(song,234);
	}
	
	@Test
	public void testTransfer() {
		musServ.transferAlbum(232, 234);
	}
	
	@Test
	public void testFetchByArtist() {
		List<Song> list= musServ.showSongByArtist("Eminem");
		for(Song s:list) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testFetchByAlbum() {
		List<Album> list= musServ.showSongByAlbum("Kamikaze");
		for(Album a:list) {
			System.out.println(a);
		}
	}
}
