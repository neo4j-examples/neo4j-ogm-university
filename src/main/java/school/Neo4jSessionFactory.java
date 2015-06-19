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

package school;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

/**
 * Created by luanne on 18/06/15.
 */
public class Neo4jSessionFactory {

	private final static SessionFactory sessionFactory = new SessionFactory("school.domain");
	private static Neo4jSessionFactory ourInstance = new Neo4jSessionFactory();

	public static Neo4jSessionFactory getInstance() {
		return ourInstance;
	}

	private Neo4jSessionFactory() {
	}

	public Session getNeo4jSession() {
		return sessionFactory.openSession("http://localhost:7474");
	}
}
