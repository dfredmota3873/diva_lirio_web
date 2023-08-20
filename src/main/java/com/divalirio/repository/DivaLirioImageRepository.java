package com.divalirio.repository;

import com.divalirio.model.DivaLirioImage;
import org.springframework.data.repository.CrudRepository;

public interface DivaLirioImageRepository extends CrudRepository<DivaLirioImage, Long> {

    DivaLirioImage findByTitle(String title);

}
