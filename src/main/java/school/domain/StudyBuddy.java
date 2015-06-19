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

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "StudyBuddy")
public class StudyBuddy extends Entity {

    @Relationship(type="BUDDY")
    private List<Student> buddies;
    private Course course;

    public StudyBuddy(){
        buddies = new ArrayList<>();
    }

    public void setCourse( Course course )
    {
        this.course = course;
    }

    public void setBuddyTwo( Student buddyTwo )
    {
        buddies.add(buddyTwo);
    }

    public void setBuddyOne( Student buddyOne )
    {
        buddies.add(buddyOne);
    }

    public Course getCourse()
    {
        return course;
    }

    public Student getBuddyTwo()
    {
        if (buddies.size() > 1) {
            return buddies.get(1);
        } else {
            return null;
        }
    }

    public Student getBuddyOne()
    {
        if (buddies.size() > 0) {
            return buddies.get(0);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "StudyBuddy{" +
                "buddies= " + buddies.size() +
                ", course=" + course +
                '}';
    }

}
