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

import org.neo4j.ogm.annotation.EndNode
import org.neo4j.ogm.annotation.RelationshipEntity
import org.neo4j.ogm.annotation.StartNode
import org.neo4j.ogm.annotation.typeconversion.DateLong

@RelationshipEntity(type = "ENROLLED")
class Enrollment {

    Long id

    @StartNode
    Student student

    @EndNode
    Course course

    @DateLong
    Date enrolledDate

    Enrollment() {
    }

    Enrollment(Student student, Course course) {
        this.student = student
        this.course = course
        this.enrolledDate = new Date()
    }
}
