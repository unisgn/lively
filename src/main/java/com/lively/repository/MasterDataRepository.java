package com.lively.repository;

import com.lively.domain.entity.MasterData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by franCiS on Sep 27, 2014.
 */

@NoRepositoryBean
public interface MasterDataRepository<E extends MasterData> extends Repository<E, Long> {
    public E findByNumber(String number);
    public E findByCode(String code);


    @Query(value = " select * from #{#entityName} t where t.search_text @@ ?1 ", nativeQuery = true)
    public List<E> search(String keyword);
}
