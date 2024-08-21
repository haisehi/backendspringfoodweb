package com.example.foodweb.repository;

import com.example.foodweb.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query("""
            select t from Token t inner join Customer c on t.customer.idCustomer = c.idCustomer
            where c.idCustomer = :userId and (t.expired = false or t.revoked = false)
            """)
    List<Token> findAllValidTokensByUser(Integer userId);

    Optional<Token> findByToken(String token);
}
