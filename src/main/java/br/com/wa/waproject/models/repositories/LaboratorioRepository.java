package br.com.wa.waproject.models.repositories;

import br.com.wa.waproject.models.entities.Laboratorio;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface LaboratorioRepository extends PagingAndSortingRepository<Laboratorio, Integer> {

    @Query("SELECT l FROM Laboratorio l where l.nome like %:nome%")
    Iterable<Laboratorio> searchByNameLike (@Param("nome") String partName);

}
