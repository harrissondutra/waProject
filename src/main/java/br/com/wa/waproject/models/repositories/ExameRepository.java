package br.com.wa.waproject.models.repositories;

import br.com.wa.waproject.models.entities.Exame;
import br.com.wa.waproject.models.entities.Laboratorio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ExameRepository extends PagingAndSortingRepository<Exame, Integer> {

    @Query("SELECT e FROM Exame e where e.nome like %:nome%")
    Iterable<Exame> searchByNameLike (@Param("nome") String partName);

}
