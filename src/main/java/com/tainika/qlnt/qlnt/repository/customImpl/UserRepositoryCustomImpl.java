package com.tainika.qlnt.qlnt.repository.customImpl;

import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.repository.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public boolean checkUserNameAndIdentityNumber(String userName, String idNumber) {
        final Query query = new Query();
        Criteria criteria = Criteria
                .where("userName").regex(userName, "i")
                .and("identityNumber").is(idNumber);
        query.addCriteria(criteria);

        return this.mongoTemplate.count(query, User.class) > 0;
    }
}
