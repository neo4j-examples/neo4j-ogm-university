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

package school.service

import school.Neo4jSessionFactory
import school.domain.StudyBuddy

//@Service("studyBuddyService")
class StudyBuddyServiceImpl extends GenericService<StudyBuddy> implements StudyBuddyService {

    @Override
    Iterable<StudyBuddy> findAll() {
        return session.loadAll(StudyBuddy, 1)
    }

    @Override
    Iterable<Map<String, Object>> getStudyBuddiesByPopularity() {
        String query = "MATCH (s:StudyBuddy)<-[:BUDDY]-(p:Student) return p, count(s) as buddies ORDER BY buddies DESC"
        return Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, Collections.EMPTY_MAP)
    }

    @Override
    Class<StudyBuddy> getEntityType() {
        return StudyBuddy.class
    }
}
