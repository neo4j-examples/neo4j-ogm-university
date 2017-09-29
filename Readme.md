Hilly Fields Technical College
==============================

Overview
--------

This demo web application shows developers how to quickly get started with the [Neo4j OGM](https://github.com/neo4j/neo4j-ogm) library and [Neo4j](http://neo4j.org) graph database.
For the Spring Framework version of this application please check out [SDN University](https://github.com/neo4j-examples/sdn-university).

Hilly Fields Technical College is a fictitious educational institution. This application allows you to manage its departments, teaching staff, subjects, students and classes.

This project is built using:

- Neo4j OGM 3.0
- AngularJS 1.3
- Bootstrap 3.3
- Ratpack 1.4


It leverages the power of the Neo4j Object Graph Mapper(OGM) to via a RESTful interface with which a web client application may interact. The application is entirely stateless: every interaction involves a call over the wire to a Neo4j server.

Getting Started
---------------

### Prerequisites

You will need to following to run this application:

- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Neo4j](http://neo4j.org) version `3.1` or above. *Optional if you are using the embedded driver.*

[Gradle](https://gradle.org/) has already been downloaded for you to execute.

### Download the application

Either [download](https://github.com/neo4j-examples/neo4j-ogm-university/archive/master.zip) the application or use `git` to clone the application:

```
git clone git@github.com:neo4j-examples/neo4j-ogm-university.git
cd neo4j-ogm-university
```

The static resources defined in the `bower.json` file will be installed under the `src/ratpack/public/bower_components` directory. This directory is ignored by `git`.

### Configuration

This sample uses the `bolt` driver to connect to a local Neo4j instance running on port `7474`.
If you want to change this behaviour and/or provide your credentials read the sub-sections below.

#### Properties
If you are using a `bolt` or `http` connection to the database you'll need to provide connection credentials.
To do this is to set the Neo4j username and password in `src/main/resources/ogm.properties`

```
# use bolt driver
URI=bolt://localhost
# use http driver
# URI=http://localhost:7474
username=<Your username here>
password=<Your password here>
```

To make the application use the `embedded` driver comment the `URI` property.

#### Dependencies

To use other drivers than `bolt` you also have to define the dependencies in the `build.gradle` file.

```
// use bolt driver
runtime 'org.neo4j:neo4j-ogm-bolt-driver:3.0.0'

// use http driver
// runtime 'org.neo4j:neo4j-ogm-http-driver:3.0.0'

// use embedded driver
// runtime 'org.neo4j:neo4j-ogm-embedded-driver:3.0.0'
// runtime 'org.neo4j:neo4j:3.2.5'
```

### Starting the application

You can then start the application with gradle:

```
./gradlew run
```

And that's it! Head to <http://localhost:5050> to see your application running.


### Loading the initial dataset

> **WARNING!**
>
> By default, the application will attempt to use a Neo4j instance running on the same machine as this application started on the standard port `7474`. ***IT WILL DESTROY ALL THE DATA IN THAT DATABASE AT STARTUP***. So if you don't want that to happen please back up any existing database first.

You may notice that there is no data for you to interact with. To fix this hit the following endpoint from your browser or using `curl`:

<http://localhost:5050/api/reload>

This will pre-load the Neo4j database with a handful of departments, a dozen or so subjects and teachers,
and 200 students. You'll probably want to enrol them in classes...


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
