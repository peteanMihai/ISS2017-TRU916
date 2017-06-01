package ro.tru916.core.service;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.tru916.core.model.Conference;
import ro.tru916.core.repository.ConferenceRepository;

import javax.persistence.RollbackException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by tudor on 06-May-17.
 */
@Service
public class ConferenceServiceImpl implements ConferenceService {

    private static final Logger log = LoggerFactory.getLogger(ConferenceService.class);

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Override
    @Transactional
    public void addConference(String name, String date) throws RuntimeException {
        log.trace("ADD CINFERENCE");
        log.trace("addConference: name={}, date={}", name, date);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date confDate = format.parse(date);
            Conference conference = new Conference(name, confDate,confDate);//Am pus aici ca deadline-ul sa fie chiar in data de incepere a conferintei
            //dar trebue setat de user
            //de asemenea trebe sa

            try {
                conferenceRepository.saveAndFlush(conference);
            }
//             catch ( ConstraintViolationException e) {
//                log.trace("CONFERENCE ERROR SAVE");
//
//            }
            catch(Exception e)
            {
                throw new RuntimeException("Conference must be unique.");
            }
            log.trace("addConference: conference={}", conference);
        }
        catch(ParseException e){
            throw new RuntimeException("Date format invalid.");
        }
    }

}
