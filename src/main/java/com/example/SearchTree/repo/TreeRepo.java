package com.example.SearchTree.repo;

import com.example.SearchTree.model.TreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepo extends JpaRepository<TreeEntity, Long> {
}
