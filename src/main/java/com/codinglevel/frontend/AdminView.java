package com.codinglevel.frontend;

import com.codinglevel.backend.entities.Book;
import com.codinglevel.backend.service.BookService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

import javax.annotation.security.RolesAllowed;

@Route("admin")
@RolesAllowed("ADMIN")
public class AdminView extends VerticalLayout {

    public AdminView(BookService bookService) {
        var crud = new GridCrud<>(Book.class, bookService);
        crud.getGrid().setColumns("title", "localDate", "rating");
        crud.getCrudFormFactory().setVisibleProperties("title", "localDate", "rating");
        add(
                new H1("Welcome to the Admin View"),
                crud
        );
    }
}
