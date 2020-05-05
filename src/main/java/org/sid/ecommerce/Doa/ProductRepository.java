package org.sid.ecommerce.Doa;

import java.util.List;

import org.sid.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long>{

    @RestResource(path="/selectedproducts")
    // FIND BY + NOM VARIABLE EN MAJ POUR AVOIR LA LISTES DES PRODUITS DESIRER
    public List<Product> findBySelectedIsTrue();
    @RestResource(path="/promoProducts")
    public List<Product> findByPromotionIsTrue();
    @RestResource(path="/dispoProducts")
    public List<Product> findByAvailableIsTrue();

    @RestResource(path="/productsByKeyword")
    public List<Product> findByNameContains(@Param("mc") String mc);
//@Query("select p from  Product p where p.name like :x ")
//public List<Product> chercher(@Param("x")   String mc);


}
