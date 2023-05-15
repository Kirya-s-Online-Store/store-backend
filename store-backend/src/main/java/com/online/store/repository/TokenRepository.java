package com.online.store.repository;

import com.online.store.model.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    List<Token> findAllByUserIdAndExpiredIsFalseAndRevokedIsFalse(int userId);

    Optional<Token> findByToken(String token);
}
