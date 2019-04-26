package com.asm.managment.Controller;

import com.asm.managment.Model.Project;
import com.asm.managment.Service.Interface.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "Project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "/api/v1.0/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> save(@RequestBody Project project){
        try {
            projectService.save(project);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/api/v1/.0/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> update(@RequestBody Project project){
        try {
            projectService.update(project);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value = "/api/v1.0/delete")
    public ResponseEntity<Project> delete(@RequestParam(required = false) Long projectId){
        try {
            if (projectId==null){
                projectService.deleteAll();
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                projectService.delete(projectId);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
