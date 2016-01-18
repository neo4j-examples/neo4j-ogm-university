/*
 * Copyright [2011-2016] "Neo Technology"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */


package school.domain

import org.neo4j.ogm.annotation.Relationship
import com.fasterxml.jackson.annotation.JsonProperty

public class Student extends Entity {

	@JsonProperty("name")
	String name

	@Relationship(type = "ENROLLED")
	Set<Enrollment> enrollments = new HashSet<>()

//	Set<Course> courses = new HashSet<>()

	@Relationship(type = "BUDDY", direction = Relationship.INCOMING)
	Set<StudyBuddy> studyBuddies

	public Student() {
		this.studyBuddies = new HashSet<>()
		this.enrollments = new HashSet<>()
	}

	public Student(String name) {
		this()
		this.name = name
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + getId() +
				", name='" + name + '\'' +
				", courses=" + enrollments.size() +
				", studyBuddies=" + studyBuddies.size() +
				'}'
	}
}
