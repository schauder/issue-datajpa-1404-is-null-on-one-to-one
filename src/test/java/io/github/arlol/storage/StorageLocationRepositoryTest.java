package io.github.arlol.storage;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StorageLocationRepositoryTest {

	@Autowired
	StorageLocationRepository storageLocationRepository;

	@Test
	public void findByItemIsNullQuery() throws Exception {
		StorageLocation storageLocation = new StorageLocation();
		storageLocationRepository.save(storageLocation);

		Iterable<StorageLocation> result =
		        storageLocationRepository.findByItemIsNullQuery();
		assertThat(result).containsOnly(storageLocation);
	}

	@Test
	public void findByItemIsNullQueryDsl() throws Exception {
		StorageLocation storageLocation = new StorageLocation();
		storageLocationRepository.save(storageLocation);

		Iterable<StorageLocation> result =
		        storageLocationRepository.findByItemIsNullQueryDsl();
		assertThat(result).containsOnly(storageLocation);
	}

	@Test
	public void findByItemIsNull() throws Exception {
		StorageLocation storageLocation = new StorageLocation();
		storageLocationRepository.save(storageLocation);

		Iterable<StorageLocation> result =
		        storageLocationRepository.findByItemIsNull();
		assertThat(result).containsOnly(storageLocation);
	}

}
