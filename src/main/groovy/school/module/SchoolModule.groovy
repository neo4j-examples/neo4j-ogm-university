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

package school.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import school.service.ClassRegisterService;
import school.service.CourseServiceImpl;
import school.service.DepartmentService;
import school.service.DepartmentServiceImpl;
import school.service.SchoolService;
import school.service.SchoolServiceImpl;
import school.service.StudentService;
import school.service.StudentServiceImpl;
import school.service.StudyBuddyService;
import school.service.StudyBuddyServiceImpl;
import school.service.SubjectService;
import school.service.SubjectServiceImpl;
import school.service.TeacherService;
import school.service.TeacherServiceImpl;

/**
 * @author Luanne Misquitta
 */
public class SchoolModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DepartmentService.class).to(DepartmentServiceImpl.class).in(Scopes.SINGLETON)
        bind(SchoolService.class).to(SchoolServiceImpl.class).in(Scopes.SINGLETON)
        bind(ClassRegisterService.class).to(CourseServiceImpl.class).in(Scopes.SINGLETON)
        bind(StudentService.class).to(StudentServiceImpl.class).in(Scopes.SINGLETON)
        bind(StudyBuddyService.class).to(StudyBuddyServiceImpl.class).in(Scopes.SINGLETON)
        bind(SubjectService.class).to(SubjectServiceImpl.class).in(Scopes.SINGLETON)
        bind(TeacherService.class).to(TeacherServiceImpl.class).in(Scopes.SINGLETON)
    }
}
