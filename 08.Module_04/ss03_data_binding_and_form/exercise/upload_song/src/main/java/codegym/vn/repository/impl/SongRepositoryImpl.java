package codegym.vn.repository.impl;

import codegym.vn.bean.Song;
import codegym.vn.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SongRepositoryImpl implements ISongRepository {

    private static ArrayList<Song> songs;

    static {
        songs = new ArrayList<>();
        songs.add(new Song("Doibo.mp3", "Lân Nhã", "pop", "https://zingmp3.vn/bai-hat/Doi-Bo-Lan-Nha/Z6IEBIO8.html"));
    }

    @Override
    public void create(Song s) {
        songs.add(s);
    }

    @Override
    public List<Song> findAll() {
        return songs;
    }

}
