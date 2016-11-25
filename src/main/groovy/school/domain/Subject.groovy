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

class Subject extends Entity {

    @JsonProperty("name")
    String name

    @JsonIgnore
    @Relationship(type = "CURRICULUM", direction = Relationship.INCOMING)
    Department department

    @Relationship(type = "TAUGHT_BY")
    Set<Teacher> teachers

    @Relationship(type = "SUBJECT_TAUGHT", direction = "INCOMING")
    Set<Course> courses

    Subject(String name) {
        this()
        this.name = name
    }

    Subject() {
        this.teachers = new HashSet<>()
        this.courses = new HashSet<>()
    }

    @Override
    String toString() {
        return "Subject{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", teachers=" + teachers.size() +
                '}'
    }
}
