package com.thoughtworks.capability.gtb.restfulapidesign.controller;


import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getGroups() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(groupService.getGroups());
    }

   @PatchMapping("/groups/{id}/{name}")
    public ResponseEntity updateGroupNameById(@PathVariable Integer id,
                                              @PathVariable String name) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(groupService.updateGroupNameById(id,name));
   }
}
