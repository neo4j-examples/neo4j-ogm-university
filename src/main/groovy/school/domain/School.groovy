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

import org.neo4j.ogm.annotation.Relationship

public class School extends Entity {

    String name

    @Relationship(type = "DEPARTMENT")
    Set<Department> departments

    @Relationship(type = "STAFF")
    Set<Teacher> teachers

    @Relationship(type = "HEAD_TEACHER")
    Teacher headTeacher

    @Relationship(type = "STUDENT")
    Set<Student> students

    public School() {
        this.departments = new HashSet<>()
        this.teachers = new HashSet<>()
        this.students = new HashSet<>()
    }

    public School(String name) {
        this()
        this.name = name
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", departments=" + departments.size() +
                ", teachers=" + teachers.size() +
                ", students=" + students.size() +
                '}'
    }
}

