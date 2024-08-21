package com.example.foodweb.controller;

import com.example.foodweb.Model.Poster;
import com.example.foodweb.service.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/posters")
public class PosterController {

    @Autowired
    private PosterService posterService;

    // Thêm poster
    @PostMapping
    public ResponseEntity<Poster> addPoster(@RequestBody Poster poster) {
        Poster createdPoster = posterService.addPoster(poster);
        return ResponseEntity.ok(createdPoster);
    }

    // Lấy tất cả poster
    @GetMapping
    public ResponseEntity<List<Poster>> getAllPosters() {
        List<Poster> posters = posterService.getAllPosters();
        return ResponseEntity.ok(posters);
    }

    // Xoá poster theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoster(@PathVariable Integer id) {
        posterService.deletePoster(id);
        return ResponseEntity.noContent().build();
    }

    // Lấy poster theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Poster> getPosterById(@PathVariable Integer id) {
        Optional<Poster> poster = posterService.getPosterById(id);
        return poster.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}