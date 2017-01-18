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
import school.domain.*

class ImportService {


    static void reload() {
        Session session = Neo4jSessionFactory.getInstance().getNeo4jSession()
        session.purgeDatabase()
        session.query(load("school.cql"), new HashMap<>())
    }

    static String load(String cqlFile) {
        StringBuilder sb = new StringBuilder()
        BufferedReader reader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(cqlFile)))
        String line
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line)
                sb.append(" ")
            }
        } catch (Exception e) {
            throw new RuntimeException(e)
        }
        return sb.toString()
    }
}
