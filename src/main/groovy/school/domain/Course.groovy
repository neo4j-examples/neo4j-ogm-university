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

package school.domain

import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * The course object connects a teacher
 * with a subject and the pupils who are taught the subject by the teacher
 */
@NodeEntity(label="Class")
public class Course extends Entity {

    @JsonProperty("name")
    String name

    @JsonProperty("subject")
    @Relationship(type= "SUBJECT_TAUGHT")
    Subject subject

    @JsonProperty("teacher")
    @Relationship(type= "TEACHES_CLASS", direction=Relationship.INCOMING)
    Teacher teacher

    @Relationship(type= "ENROLLED", direction=Relationship.INCOMING)
    Set<Enrollment> enrollments = new HashSet<>()

    Set<Student> students = new HashSet<>()

    Set<Student> getStudents() {
        //TODO temp fix till the UI is able to deal with enrollments
        enrollments.each {enrollment->
            students.add(enrollment.student)
        }
        return students
    }

    void setStudents(Set<Student> students) {
        //TODO temp fix till the UI is able to deal with enrollments
        this.students = students
        students.each {student->
            Enrollment enrollment = new Enrollment(student, this)
            enrollments.add(enrollment)
            student.enrollments.add(enrollment)
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", subject=" + subject +
                ", students=" + enrollments.size() +
                '}'
    }
}