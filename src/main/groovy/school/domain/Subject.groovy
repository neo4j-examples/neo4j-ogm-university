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


public class Subject extends Entity {

    @JsonProperty("name")
    String name

    @JsonIgnore
    @Relationship(type="CURRICULUM", direction = Relationship.INCOMING)
    Department department

    @Relationship(type = "TAUGHT_BY")
    Set<Teacher> teachers

    @Relationship(type = "SUBJECT_TAUGHT", direction = "INCOMING")
    Set<Course> courses

    public Subject(String name) {
        this()
        this.name = name
    }

    public Subject() {
        this.teachers = new HashSet<>()
        this.courses = new HashSet<>()
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", teachers=" + teachers.size() +
                '}'
    }
}
