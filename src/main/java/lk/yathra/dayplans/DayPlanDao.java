package lk.yathra.dayplans;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DayPlanDao extends JpaRepository<DayPlan, Integer> {

    //to create day plan code
    @Query(value = "select dp from DayPlan dp where dp.start_district_id.id=?1")
    List<DayPlan> getDayPlansListBySD(Integer sdid);

    // THESE 6 QUERIES WILL BE USED IN TOUR PACKAGE CREATION MODULE

    // FILTER OUT DAYS THAT HAS 'FD' IN THEIR 'DAYCODE'
    @Query(value = "select dp from DayPlan dp where dp.dayplancode like 'FD%'")
    public List<DayPlan> getOnlyFirstDays();

    // AND ALSO BELONGS TO THIS GIVEN PARTICULAR QUERY
    @Query(value = "select dp from DayPlan dp where dp.dayplancode like 'FD%' and dp.dpbasedinq = ?1")
    public List<DayPlan> getOnlyFirstDaysAlsoBelongsToGivenInquiry(String basedInqDP);

    // FILTER OUT DAYS THAT HAS 'MD' IN THEIR 'DAYCODE'
    @Query(value = "select dp from DayPlan dp where function('LEFT', dp.dayplancode, 2)='MD'")
    public List<DayPlan> getOnlyMidDays();

    // AND ALSO BELONGS TO THIS GIVEN PARTICULAR QUERY
    @Query(value = "select dp from DayPlan dp where dp.dayplancode like 'MD%' and dp.dpbasedinq = ?1")
    public List<DayPlan> getOnlyMidDaysAlsoBelongsToGivenInquiry(String basedInqDP);

    // GET ONLY LAT DAYS
    @Query(value = "select dp from DayPlan dp where  substring(dp.dayplancode, 1, 2)='LD'")
    public List<DayPlan> getOnlyLastDays();

    // ALSO BY GIVEN INQUIRY
    @Query(value = "select dp from DayPlan dp where dp.dayplancode like 'LD%' and dp.dpbasedinq = ?1")
    public List<DayPlan> getOnlyLastDaysAlsoBelongsToGivenInquiry(String basedInqDP);


    boolean existsByDayplancode(String nextCode);

}

// @Query("select dp from DayPlan dp where function('LEFT', dp.dayplancode, 2) =
// 'FD'")
// List<DayPlan> getFirstDayPlans();

// @Query("select dp from DayPlan dp where substring(dp.dayplancode, 1, 2) =
// 'FD'")
// List<DayPlan> getFirstDayPlans();
