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

import org.neo4j.ogm.annotation.Relationship

class School extends Entity {

    String name

    @Relationship(type = "DEPARTMENT")
    Set<Department> departments

    @Relationship(type = "STAFF")
    Set<Teacher> teachers

    @Relationship(type = "HEAD_TEACHER")
    Teacher headTeacher

    @Relationship(type = "STUDENT")
    Set<Student> students

    School() {
        this.departments = new HashSet<>()
        this.teachers = new HashSet<>()
        this.students = new HashSet<>()
    }

    School(String name) {
        this()
        this.name = name
    }

    @Override
    String toString() {
        return "School{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", departments=" + departments.size() +
                ", teachers=" + teachers.size() +
                ", students=" + students.size() +
                '}'
    }
}

