package com.tainika.qlnt.qlnt.repository.customImpl;

import com.tainika.qlnt.qlnt.model.Role;
import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.repository.RoleRepository;
import com.tainika.qlnt.qlnt.repository.RoleRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

public class RoleRepositoryCustomImpl implements RoleRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Role findByRoleCode(String code) {
        final Query query = new Query();
        Criteria criteria = Criteria
                .where("code").is(code);
        query.addCriteria(criteria);
        return this.mongoTemplate.findOne(query, Role.class);
    }
}
