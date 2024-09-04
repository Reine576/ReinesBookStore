package com.reine.ReinesbookStore.repository;

import com.reine.ReinesbookStore.model.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookListRepository extends JpaRepository<BookList, Integer> {
}
