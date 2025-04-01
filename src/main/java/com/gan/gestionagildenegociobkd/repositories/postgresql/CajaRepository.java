package com.gan.gestionagildenegociobkd.repositories.postgresql;

import com.gan.gestionagildenegociobkd.entities.Cajas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajaRepository extends JpaRepository<Cajas,Long> {

}
