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


package school.domain

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.voodoodyne.jackson.jsog.JSOGGenerator

//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIdentityInfo(generator = JSOGGenerator.class)
abstract class Entity {

    @JsonProperty("id")
    private Long id

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    @Override
    boolean equals(Object o) {
        if (this.is(o)) return true
        if (o == null || id == null || getClass() != o.getClass()) return false

        Entity entity = (Entity) o

        if (!id.equals(entity.id)) return false

        return true
    }

    @Override
    int hashCode() {
        return (id == null) ? -1 : id.hashCode()
    }
}
