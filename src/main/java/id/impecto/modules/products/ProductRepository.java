package id.impecto.modules.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
   Product findByCode(String code);
   Long countByCodeStartingWith(String prefix);
}
