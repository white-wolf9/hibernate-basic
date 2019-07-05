package com.lti.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ALBUM")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "album_id")
	private int id;
	private String name;
	private String copyright;
	private int year;
	
	 @Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", copyright=" + copyright + ", year=" + year + "]";
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
	private Set<Song> songs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Set<Song> getSongs() {
		return songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}
	
}
