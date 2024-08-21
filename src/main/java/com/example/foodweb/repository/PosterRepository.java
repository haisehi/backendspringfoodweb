package com.example.foodweb.repository;

import com.example.foodweb.Model.Poster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosterRepository extends JpaRepository<Poster, Integer> {
}