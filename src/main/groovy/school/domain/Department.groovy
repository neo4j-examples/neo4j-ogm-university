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

import com.fasterxml.jackson.annotation.JsonProperty
import org.neo4j.ogm.annotation.Relationship

class Department extends Entity {

    @JsonProperty("name")
    String name

    @Relationship(type = "DEPARTMENT_MEMBER")
    Set<Teacher> teachers

    @Relationship(type = "CURRICULUM")
    Set<Subject> subjects

    Department() {
        this.teachers = new HashSet<>()
        this.subjects = new HashSet<>()
    }

    Department(String name) {
        this()
        this.name = name
    }

    @Override
    String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teachers=" + teachers.size() +
                ", subjects=" + subjects.size() +
                '}'
    }
}
