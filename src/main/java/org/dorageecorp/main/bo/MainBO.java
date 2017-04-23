package org.dorageecorp.main.bo;

import java.util.List;

import org.dorageecorp.main.model.Project;;

public interface MainBO {
    List<Project> getTotalProjects();

    List<Project> getMyProjects(String userId);
}