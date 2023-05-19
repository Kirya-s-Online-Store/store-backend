package com.online.store.repository;

import com.online.store.model.InfoClause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoClauseRepository extends JpaRepository<InfoClause, Integer> {

}
