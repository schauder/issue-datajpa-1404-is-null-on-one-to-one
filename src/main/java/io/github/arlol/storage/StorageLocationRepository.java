package io.github.arlol.storage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageLocationRepository
        extends CrudRepository<StorageLocation, Long> {

	@Query("select sl from StorageLocation sl left join sl.item i where i is null")
	Iterable<StorageLocation> findByItemIsNullQuery();

	Iterable<StorageLocation> findByItemIsNull();

}
