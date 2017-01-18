Hilly Fields Technical College
==============================

*This branch contains the `embedded` version of the Hilly Fields Technical College web application.*

*There are several branches that you may find useful:*

- `master` - *contains the `bolt` version of this application. It requires Neo4j `3.0` or above.*
- `embedded` ***[THIS BRANCH]*** - *contains the `embedded` version of this application. It requires Neo4j `2.3` or above.*
- `http` - *contains the `http` version of this application. It requires Neo4j `2.3` or above.*


![Logo](https://raw.githubusercontent.com/neo4j-examples/sdn4-university/master/src/main/webapp/assets/images/engineering-dept.JPG)

Overview
--------

This demo web application shows developers how to quickly get started with the [Neo4j OGM](https://github.com/neo4j/neo4j-ogm) library and [Neo4j](http://neo4j.org) graph database.  For the Spring Framework version of this application please check out [SDN4 University](https://github.com/neo4j-examples/sdn4-university).

Hilly Fields Technical College is a fictitious educational institution. This application allows you to manage its departments, teaching staff, subjects, students and classes.

This project is built using:

- Neo4j OGM 2.1
- AngularJS 1.3
- Bootstrap 3.3
- Ratpack 1.4


It leverages the power of the Neo4j Object Graph Mapper(OGM) to via a RESTful interface with which a web client application may interact. The application is entirely stateless: every interaction involves a call over the wire to a Neo4j server.

Getting Started
---------------

### Prerequisites

You will need to following to run this application:

- [Java 7+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Neo4j](http://neo4j.org)

[Gradle](https://gradle.org/) has already been downloaded for you to execute.

### Download the application

Either [download](https://github.com/neo4j-examples/neo4j-ogm-university/archive/master.zip) the application or use `git` to clone the application:

```
git clone git@github.com:neo4j-examples/neo4j-ogm-university.git
cd neo4j-ogm-university
git checkout embedded
```

The static resources defined in the `bower.json` file will be installed under the `src/ratpack/public/bower_components` directory. This directory is ignored by `git`.

### Starting the application

You can start the application with gradle:

```
gradlew run
```

And that's it! Head to <http://localhost:5050> to see your application running.


### Loading the initial dataset

You may notice that there is no data for you to interact with. To fix this hit the following endpoint from your browser or using `curl`:

<http://localhost:5050/api/reload>

This will pre-load the Neo4j database with a handful of departments, a dozen or so subjects and teachers,
and 200 students. You'll probably want to enrol them in classes...

> ***NOTE***
>
> You may notice that your data disappears between restarts. That's because if you don't supply a directory to house the database only a temporary data store is set up (and gets destroyed on close).  If you want the data to persist between restarts then in your favourite editor modify `src/main/resources/ogm.properties` and add a new line with `URI=file:///var/tmp/neo4j.db` or wherever you want your database to reside.

### Stopping the application server

You can stop the application server at any time by pressing `Ctrl-C` in the console window from where you launched it.


Make it better!
---------------

If you'd like to contribute to the development of this application you will need to install:

- [NodeJS](https://nodejs.org/en/)
- [Bower](https://bower.io/)

The install bower via:

```
npm install --global bower
```

Development mode is on by default in Ratpack so you can just hit refresh to see the changes in the application.
