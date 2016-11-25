/*
 * Copyright [2011-2016] "Neo Technology"
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */


package school.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.neo4j.ogm.annotation.Relationship

class Teacher extends Entity {

    @JsonProperty("name")
    String name

    @Relationship(type = "TEACHES_CLASS")
    Set<Course> courses

    @JsonIgnore
    @Relationship(type = "DEPARTMENT_MEMBER", direction = Relationship.INCOMING)
    Department department

    @Relationship(type = "TAUGHT_BY", direction = Relationship.INCOMING)
    Set<Subject> subjects

    Teacher(String name) {
        this()
        this.name = name
    }

    Teacher() {
        this.courses = new HashSet<>()
        this.subjects = new HashSet<>()
    }

    @Override
    String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", classRegisters=" + courses.size() +
                ", department=" + department +
                ", subjects=" + subjects.size() +
                '}'
    }
}
