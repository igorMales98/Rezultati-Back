package com.scores.graphql.datafetcher;

import com.scores.model.FudbalskiRezultat;
import com.scores.repository.FudbalskiRezultatRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class RezultatiForDateDataFetcher implements DataFetcher<List<FudbalskiRezultat>> {

    @Autowired
    private FudbalskiRezultatRepository fudbalskiRezultatRepository;

    @Override
    public List<FudbalskiRezultat> get(DataFetchingEnvironment dataFetchingEnvironment) {
        String date = dataFetchingEnvironment.getArgument("date").toString();
        String datum = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8) + " " + date.substring(8, 10)
                + ":" + date.substring(10);
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(datum);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            LocalDateTime d1 = getFirstDate(cal);
            LocalDateTime d2 = getSecondDate(cal);
            return fudbalskiRezultatRepository.findAllForTheDate(d1, d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private LocalDateTime getSecondDate(Calendar cal) {
        cal.add(Calendar.DATE, 1);

        Date date2 = cal.getTime();
        return date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private LocalDateTime getFirstDate(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date date1 = cal.getTime();
        return date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
