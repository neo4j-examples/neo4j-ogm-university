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

package school.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import school.controller.exception.NotFoundException;
import school.domain.Entity;
import school.service.Service;

public abstract class Controller<T> {

    public abstract Service<T> getService();

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<T> list(final HttpServletResponse response) {
        setHeaders(response);
        return list();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public T create(@RequestBody T entity, final HttpServletResponse response) {
        setHeaders(response);
        return create(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T find(@PathVariable Long id, final HttpServletResponse response) {
        setHeaders(response);
        return find(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id, final HttpServletResponse response) {
        setHeaders(response);
        delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public T update(@PathVariable Long id, @RequestBody T entity, final HttpServletResponse response) {
        setHeaders(response);
        return update(id, entity);
    }

    public void setHeaders(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
        response.setHeader("Expires", "0");
        response.setHeader("Pragma", "no-cache");
    }

    public Iterable<T> list() {
        return getService().findAll();
    }

    public  T create (T entity) {
        return getService().createOrUpdate(entity);
    }

    public T find(Long id) {
        T entity = getService().find(id);
        if (entity != null) {
            System.out.println("from OGM: " + entity);
            return entity;
        }
        throw new NotFoundException();
    }

    public void delete (Long id) {
        if (getService().find(id) != null) {
            getService().delete(id);
        } else {
            throw new NotFoundException();
        }
    }

    public  T update (Long id, T entity) {
        if (getService().find(id) != null) {
            ((Entity)entity).setId(id);
            return getService().createOrUpdate(entity);
        }
        throw new NotFoundException();
    }

}
