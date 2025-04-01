package com.gan.gestionagildenegociobkd.repositories.SQLServer;

import com.gan.gestionagildenegociobkd.entities.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen,Long> {
}
