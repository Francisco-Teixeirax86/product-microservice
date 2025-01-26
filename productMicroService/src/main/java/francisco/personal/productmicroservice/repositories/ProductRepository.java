package francisco.personal.productmicroservice.repositories;

import francisco.personal.productmicroservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("SELECT p FROM Product p " +
            "WHERE (LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) "+
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice)" +
            "AND (:minStock IS NULL OR p.quantity <= :minStock)")
    List<Product> findByFilters(@Param("name") String name,
                                @Param("minStock") Integer minStock,
                                @Param("minPrice") Double minPrice,
                                @Param("maxPrice") Double maxPrice);
}
