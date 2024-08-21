package com.example.foodweb.service;

import com.example.foodweb.Model.Poster;
import com.example.foodweb.repository.PosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosterService {

    @Autowired
    private PosterRepository posterRepository;

    public Poster addPoster(Poster poster) {
        return posterRepository.save(poster);
    }

    public List<Poster> getAllPosters() {
        return posterRepository.findAll();
    }

    public void deletePoster(Integer id) {
        posterRepository.deleteById(id);
    }

    public Optional<Poster> getPosterById(Integer id) {
        return posterRepository.findById(id);
    }
}