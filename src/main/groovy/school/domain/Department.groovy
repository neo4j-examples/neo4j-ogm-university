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
import com.fasterxml.jackson.annotation.JsonProperty

public class Department extends Entity {

    @JsonProperty("name")
    String name

    @Relationship(type = "DEPARTMENT_MEMBER")
    Set<Teacher> teachers

    @Relationship(type = "CURRICULUM")
    Set<Subject> subjects

    public Department() {
        this.teachers = new HashSet<>();
        this.subjects = new HashSet<>();
    }

    public Department(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teachers=" + teachers.size() +
                ", subjects=" + subjects.size() +
                '}'
    }
}
