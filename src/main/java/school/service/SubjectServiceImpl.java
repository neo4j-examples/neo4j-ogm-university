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

package school.service;

import org.springframework.stereotype.Service;
import school.domain.Subject;

@Service("subjectService")
public class SubjectServiceImpl extends GenericService<Subject> implements SubjectService {


    @Override
    public Class<Subject> getEntityType() {
        return Subject.class;
    }
}
