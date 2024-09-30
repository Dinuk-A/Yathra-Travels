package lk.yathra.sightseeing;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttractionDao extends JpaRepository<Attraction ,  Integer> {

    @Query(value = "select new Attraction(attr.id , attr.name, attr.feelocal, attr.feeforeign, attr.feechildlocal, attr.feechildforeign, attr.vehicleparkingfee ) from Attraction attr where attr.district_id.id=?1")
    List <Attraction> attrListByDistrict(Integer selectedDistrict);
    
}
