package lk.yathra.stay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StayDao extends JpaRepository<Stay, Integer>{
    
    @Query(value = "select New Stay(s.id, s.name) from Stay s where s.district_id.id=?1")
    public List<Stay> getStayListByDistrict(Integer givenDistrict) ;
}
