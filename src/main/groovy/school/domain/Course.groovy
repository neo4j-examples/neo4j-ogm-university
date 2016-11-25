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
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

/**
 * The course object connects a teacher
 * with a subject and the pupils who are taught the subject by the teacher
 */
@NodeEntity(label = "Class")
class Course extends Entity {

    @JsonProperty("name")
    String name

    @JsonProperty("subject")
    @Relationship(type = "SUBJECT_TAUGHT")
    Subject subject

    @JsonProperty("teacher")
    @Relationship(type = "TEACHES_CLASS", direction = Relationship.INCOMING)
    Teacher teacher

    @Relationship(type = "ENROLLED", direction = Relationship.INCOMING)
    Set<Enrollment> enrollments = new HashSet<>()

    @Override
    String toString() {
        return "Course{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", subject=" + subject +
                ", students=" + enrollments.size() +
                '}'
    }
}
