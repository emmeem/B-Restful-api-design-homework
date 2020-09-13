package com.thoughtworks.capability.gtb.restfulapidesign.repository.impl;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

    private List<String> groupsName = new ArrayList<String>() {
        {
            add("Group 1");
            add("Group 2");
            add("Group 3");
            add("Group 4");
            add("Group 5");
            add("Group 6");
        }
    };

    private final StudentRepository studentRepository;

    public GroupRepositoryImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public boolean updateGroupNameById(Integer id, String name) {
        groupsName.set(id-1, name);
        return true;
    }

    @Override
    public List<Group> getGroups() {
        return SubGroup(studentRepository.getStudents());
    }

    public List<Group> SubGroup(List<Student> studentList) {
        List<Group> groups = new ArrayList<>();
        Collections.shuffle(studentList);
        int stuSize = studentList.size();
        int groupNum = 6;
        int initGroup = stuSize/groupNum;
        int restStudents = 0;
        if(initGroup*groupNum < stuSize) {
            restStudents = stuSize - initGroup*groupNum;
        }

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

            Group tmp = new Group(i+1,groupsName.get(i), mid,null);
            groups.add(tmp);
            restStudents = restStudents - 1;
        }
        return groups;
    }
}
