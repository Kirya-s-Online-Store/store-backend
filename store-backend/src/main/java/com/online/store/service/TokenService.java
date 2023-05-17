package com.online.store.service;

import com.online.store.model.token.Token;
import com.online.store.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    public List<Token> findAllValidTokensByUserId(int userId) {
        return tokenRepository.findAllByUserIdAndExpiredIsFalseAndRevokedIsFalse(userId);
    }

    public Token findByToken(String token) {
        return tokenRepository.findByToken(token)
                .orElse(null);
    }

    @Transactional
    public Token save(Token token) {
        return tokenRepository.save(token);
    }

    @Transactional
    public void deleteAll(List<Token> tokens) {
        tokenRepository.deleteAll(tokens);
    }
}
