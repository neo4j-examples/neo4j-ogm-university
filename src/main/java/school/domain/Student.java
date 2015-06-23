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

package school.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.Relationship;


public class Student extends Entity {

	private String name;

	@Relationship(type = "ENROLLED")
	private Set<Enrollment> enrollments;

	private Set<Course> courses;

	@Relationship(type = "BUDDY", direction = Relationship.INCOMING)
	private Set<StudyBuddy> studyBuddies;

	public Student() {
		this.studyBuddies = new HashSet<>();
		this.enrollments = new HashSet<>();
	}

	public Student(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Set<StudyBuddy> getStudyBuddies() {
		return studyBuddies;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		//TODO temp fix till the UI is able to deal with enrollments
		courses = new HashSet<>();
		for (Enrollment enrollment : enrollments) {
			courses.add(enrollment.getCourse());
		}
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		//TODO temp fix till the UI is able to deal with enrollments
		this.courses = courses;
		enrollments = new HashSet<>();
		for (Course course : courses) {
			Enrollment enrollment = new Enrollment(this, course);
			enrollments.add(enrollment);
			course.getEnrollments().add(enrollment);
		}
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + getId() +
				", name='" + name + '\'' +
				", courses=" + enrollments.size() +
				", studyBuddies=" + studyBuddies.size() +
				'}';
	}
}
