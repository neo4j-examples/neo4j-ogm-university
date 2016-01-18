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
import ratpack.groovy.template.MarkupTemplateModule

import school.service.DepartmentService
import school.service.StudentService
import school.service.SubjectService
import school.service.ClassRegisterService
import school.service.TeacherService
import school.service.StudyBuddyService
import school.module.SchoolModule

import school.domain.Department
import school.domain.Student
import school.domain.Subject
import school.domain.Course
import school.domain.Teacher
import school.domain.StudyBuddy

import ratpack.jackson.JacksonModule
import ratpack.jackson.Jackson
import ratpack.http.Status

import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
    module MarkupTemplateModule
    module JacksonModule
    module SchoolModule
  }

  handlers {
    get {
      render file("public/index.html")
    }

    handler("api/studyBuddies/popular") {StudyBuddyService studyBuddyService->
      render Jackson.json(studyBuddyService.getStudyBuddiesByPopularity())
    }

    handler("api/:entity/:id") {
      def theService = getTheService(pathTokens.entity, registry)
      byMethod {
        get {
          println "****** GET BY ID *********"
          println "theService = $theService"

          def entityInstance = theService.find(Long.parseLong(pathTokens.id))
          println "entityInstance = $entityInstance"

//          render "ok"
//          return

          render Jackson.json(entityInstance)
        }
        delete {
          def entityInstance = theService.find(Long.parseLong(pathTokens.id))
          if (entityInstance) {
            theService.delete(entityInstance.id)
            context.response.status(Status.OK).send()
          }
          else {
            context.response.status(Status.of(404)).send()
          }
        }
      }
    }

    handler("api/departments") { DepartmentService departmentService ->
      byMethod {
        get {
          context.next()
        }
        post {
          def departmentInstance = context.parse(Department.class)
          departmentInstance = departmentService.createOrUpdate(departmentInstance)
          render Jackson.json(departmentInstance)
        }
      }
    }

    handler("api/students") { StudentService studentService ->
      byMethod {
        get {
          context.next()
        }
        post {
          def studentInstance = context.parse(Student.class)
          studentInstance = studentService.createOrUpdate(studentInstance)
          render Jackson.json(studentInstance)
        }
      }
    }

    handler("api/subjects") { SubjectService subjectService ->
      byMethod {
        get {
          context.next()
        }
        post {
          def subjectInstance = context.parse(Subject.class)
          subjectInstance = subjectService.createOrUpdate(subjectInstance)
          render Jackson.json(subjectInstance)
        }
      }
    }

    handler("api/teachers") { TeacherService teacherService ->
      byMethod {
        get {
          context.next()
        }
        post {
          def teacherInstance = context.parse(Teacher.class)
          teacherInstance = teacherService.createOrUpdate(teacherInstance)
          render Jackson.json(teacherInstance)
        }
      }
    }

    handler("api/classes") { ClassRegisterService classRegisterService ->
      byMethod {
        get {
          context.next()
        }
        post {
          def courseInstance = context.parse(Course.class)
          courseInstance = classRegisterService.createOrUpdate(courseInstance)
          render "ok"
          return

          render Jackson.json(courseInstance)
        }
      }
    }

    handler("api/studyBuddies") { StudyBuddyService studyBuddyService ->
      byMethod {
        get {
          context.next()
        }
        post {
          def studyBuddyInstance = context.parse(StudyBuddy.class)
          studyBuddyInstance = studyBuddyService.createOrUpdate(studyBuddyInstance)
          render Jackson.json(studyBuddyInstance)
        }
      }
    }

    handler("api/reload") {
      def importService = new school.service.ImportService()
      byMethod {
        get {
          importService.reload()
        }
      }
    }

    handler("api/:entity") {
      def theService = getTheService(pathTokens.entity, registry)
      byMethod {
        get {
          render Jackson.json(theService.findAll())
        }
      }
    }

    assets "public"
  }
}

def getTheService(String entityName, def registry) {
  //TODO: May not want to lookup any random service in this manner. Restrict accordingly.
  switch (entityName) {
    case 'classes':
      return registry.get(Class.forName("school.service.ClassRegisterService"))
    case 'studyBuddies':
      return registry.get(Class.forName("school.service.StudyBuddyService"))
    default:
      return registry.get(Class.forName("school.service.${entityName[0..-2]?.capitalize()}Service"))
  }
}

def getTheEntityClass(String entityName) {
  switch (entityName) {
    case 'classes':
      return Class.forName("school.domain.Course")
    case 'studyBuddies':
      return Class.forName("school.domain.StudyBuddy")
    default:
      return Class.forName("school.domain.${entityName[0..-2]?.capitalize()}")
  }
}
