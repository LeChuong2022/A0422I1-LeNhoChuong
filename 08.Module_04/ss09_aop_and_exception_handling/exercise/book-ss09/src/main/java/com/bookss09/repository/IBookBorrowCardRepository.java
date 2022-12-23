package com.bookss09.repository;

import com.bookss09.entity.Book;
import com.bookss09.entity.BookBorrowCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface IBookBorrowCardRepository extends JpaRepository<BookBorrowCard, Long> {
    @Modifying
    @Query(value = "delete from BookBorrowCard as b where b.bookClass.id =?1 and b.borrowCode =?2", nativeQuery = false)
    int deleteByBorrowCode(Long id, Integer borrowCode);

    @Query(value = "select b.borrowCode from BookBorrowCard b where b.borrowCode =?1", nativeQuery = false)
    List<Integer> findBorrowCodeByBorrowCode(Integer borrowCode);
}
