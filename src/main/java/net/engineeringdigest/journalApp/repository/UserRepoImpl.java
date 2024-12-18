package net.engineeringdigest.journalApp.repository;


import lombok.var;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

//@EnableScheduling
@Component
public class UserRepoImpl  {

  @Autowired
  private MongoTemplate mongoTemplate;

  //@Scheduled(cron = "*/2 * * * * *")
  public List<User> getUesrsFroSentimentAnalysis(){
    Query query = new Query();
    Criteria criteria = new Criteria();
//    query.addCriteria(Criteria.where("userName").is("test21"));
//    query.addCriteria(Criteria.where("userName").ne("test"));
    query.addCriteria(criteria.orOperator(Criteria.where("userName").is("test21"),
            Criteria.where("userName").ne("test").ne("")
            ).andOperator(Criteria.where("email").regex("^[^@]+@[^@]+\\.[^@]+$")));
    var uesrs=   mongoTemplate.find(query, User.class);
    return uesrs;
  }

}
