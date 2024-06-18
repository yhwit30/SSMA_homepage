package com.ssma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssma.repository.ArtistRepository;
import com.ssma.vo.Artist;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;

	public ArtistService(ArtistRepository ArtistRepository) {
		this.artistRepository = ArtistRepository;
	}

	// 서비스 메서드
	public String writeArtist(String name, String gender, String birth) {
		artistRepository.writeArtist(name, gender, birth);
		int id = artistRepository.getLastInsertId();
		return String.format("%d번 아티스트입니다.", id);
	}

	public void deleteArtist(int id) {
		artistRepository.deleteArtist(id);
	}

	public void modifyArtist(int id, String title, String body) {
		artistRepository.modifyArtist(id, title, body);
	}

	public Artist getArtist(int id) {
		return artistRepository.getArtist(id);
	}

	public List<Artist> getArtists() {
		return artistRepository.getArtists();
	}

	// 게시글 전체 개수 구하기
	public int getArtistsCount(Integer boardId, String searchKeywordTypeCode, String searchKeyword) {
		return artistRepository.getArtistsCount(boardId, searchKeywordTypeCode, searchKeyword);
	}

}