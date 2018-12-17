package io.github.arlol.storage;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StorageLocationRepositoryTest {

	@Autowired
	StorageLocationRepository storageLocationRepository;

	@Autowired
	EntityManager em;

	@Test
	public void findByItemIsNullQuery() throws Exception {

		StorageLocation storageLocation = new StorageLocation();
		storageLocationRepository.save(storageLocation);

		Iterable<StorageLocation> result =
		        storageLocationRepository.findByItemIsNullQuery();
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

	/**
	 * the test currently fails.
	 *
	 * But when StorageLocation->Item is made unidirectional it succeeds.
	 */
	@Test
	public void usingEntityManager() {

		StorageLocation storageLocation = new StorageLocation();
		storageLocationRepository.save(storageLocation);

		List result = em.createQuery("select sl from StorageLocation sl where sl.item is null").getResultList();

		assertThat(result).containsOnly(storageLocation);


	}

}
