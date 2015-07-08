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
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

public class Teacher extends Entity {

    @JsonProperty("name")
    String name

    @Relationship(type="TEACHES_CLASS")
    Set<Course> courses

    @JsonIgnore
    @Relationship(type="DEPARTMENT_MEMBER", direction = Relationship.INCOMING)
    Department department

    @Relationship(type="TAUGHT_BY", direction = Relationship.INCOMING)
    Set<Subject> subjects

    public Teacher(String name) {
        this()
        this.name = name
    }

    public Teacher() {
        this.courses = new HashSet<>()
        this.subjects = new HashSet<>()
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", classRegisters=" + courses.size() +
                ", department=" + department +
                ", subjects=" + subjects.size() +
                '}'
    }
}
