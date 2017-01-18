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

import org.neo4j.ogm.session.Session
import school.Neo4jSessionFactory

abstract class GenericService<T> implements Service<T> {

    private static final int DEPTH_LIST = 0
    private static final int DEPTH_ENTITY = 1
    protected Session session = Neo4jSessionFactory.getInstance().getNeo4jSession()

    @Override
    Iterable<T> findAll() {
        return session.loadAll(getEntityType(), DEPTH_LIST)
    }

    @Override
    T find(Long id) {
        return session.load(getEntityType(), id, DEPTH_ENTITY)
    }

    @Override
    void delete(Long id) {
        session.delete(session.load(getEntityType(), id))
    }

    @Override
    T createOrUpdate(T entity) {
        session.save(entity, DEPTH_ENTITY)
        return find(entity.id)
    }

    abstract Class<T> getEntityType()
}
