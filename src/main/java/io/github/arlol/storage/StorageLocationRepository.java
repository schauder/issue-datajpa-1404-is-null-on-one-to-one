package io.github.arlol.storage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageLocationRepository
        extends CrudRepository<StorageLocation, Long>,
        QuerydslPredicateExecutor<StorageLocation> {

	@Query("select sl from StorageLocation sl left join sl.item i where i is null")
	Iterable<StorageLocation> findByItemIsNullQuery();

	default Iterable<StorageLocation> findByItemIsNullQueryDsl() {
		return findAll(QStorageLocation.storageLocation.item.isNull());
	}

	Iterable<StorageLocation> findByItemIsNull();

}
