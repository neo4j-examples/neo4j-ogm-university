/*
 * Copyright (c)  [2011-2015] "Neo Technology" / "Graph Aware Ltd."
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with separate copyright notices and license terms. Your use of the source code for these subcomponents is subject to the terms and conditions of the subcomponent's license, as noted in the LICENSE file.
 *
 *
 */

package school.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * The course object connects a teacher
 * with a subject and the pupils who are taught the subject by the teacher
 */
@NodeEntity(label="Class")
public class Course extends Entity {

    private String name;

    @Relationship(type= "SUBJECT_TAUGHT")
    private Subject subject;

    @Relationship(type= "TEACHES_CLASS", direction=Relationship.INCOMING)
    private Teacher teacher;

    @Relationship(type= "ENROLLED", direction=Relationship.INCOMING)
    private Set<Student> students = new HashSet<>();

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", subject=" + subject +
                ", students=" + students.size() +
                '}';
    }
}
