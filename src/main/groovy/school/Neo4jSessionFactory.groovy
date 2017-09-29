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

package school

import org.neo4j.ogm.config.ClasspathConfigurationSource
import org.neo4j.ogm.config.Configuration
import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory

class Neo4jSessionFactory {

    private static ClasspathConfigurationSource configurationSource =
            new ClasspathConfigurationSource("ogm.properties")
    private static Configuration configuration = new Configuration.Builder(configurationSource).build()
    private static SessionFactory sessionFactory = new SessionFactory(configuration, "school.domain")
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory()

    static Neo4jSessionFactory getInstance() {
        return factory
    }

    private Neo4jSessionFactory() {
    }

    Session getNeo4jSession() {
        return sessionFactory.openSession()
    }
}
