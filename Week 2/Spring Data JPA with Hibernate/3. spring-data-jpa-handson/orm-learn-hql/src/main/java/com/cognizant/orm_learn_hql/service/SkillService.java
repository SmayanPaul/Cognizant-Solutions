package com.cognizant.orm_learn_hql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn_hql.model.Skill;
import com.cognizant.orm_learn_hql.repository.SkillRepository;

import jakarta.transaction.Transactional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Transactional
    public Skill get(int id) {
        return skillRepository.findById(id).get();
    }

    @Transactional
    public void save(Skill skill) {
        skillRepository.save(skill);
    }
}