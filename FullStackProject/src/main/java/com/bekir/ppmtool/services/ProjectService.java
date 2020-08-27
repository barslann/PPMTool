package com.bekir.ppmtool.services;

import com.bekir.ppmtool.domain.Project;
import com.bekir.ppmtool.exceptions.ProjectIdException;
import com.bekir.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project Id '" + project.getProjectIdentifier().toLowerCase() + "' already exists!");
        }

    }
}
