package com.thoughtworks.capability.gtb.restfulapidesign.repository.impl;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

    @Override
    public List<Group> getGroups(List<Student> studentList) {
       return SubGroup(studentList);
    }

    public List<Group> SubGroup(List<Student> studentList) {
        Collections.shuffle(studentList);
        int stuSize = studentList.size();
        int groupNum = 6;
        int initGroup = stuSize/groupNum;
        int restStudents = 0;
        if(initGroup*groupNum < stuSize) {
            restStudents = stuSize - initGroup*groupNum;
        }
        List<Group> studentGroup = new ArrayList<>();
        int total=0;
        for(int i=0; i<groupNum; i++) {
            List<Student> mid = new ArrayList<>();
            if(restStudents > 0) {
                for (int j = 0; j < initGroup + 1; j++) {
                    mid.add(studentList.get(total));
                    total++;
                }
            } else{
                for (int j = 0; j < initGroup ; j++) {
                    mid.add(studentList.get(total));
                    total++;
                }
            }

            Group tmp = new Group(i+1,"Group" + (i + 1), mid,null);
            studentGroup.add(tmp);
            restStudents = restStudents - 1;
        }
        return studentGroup;
    }

}
