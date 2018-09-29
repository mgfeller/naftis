package net.mgfeller.naftis;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Collection;

@Component
@Path("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    @Produces("application/json")
    public Collection<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Produces("application/json")
    @Path("/{oid}")
    public Book getBook(@PathParam("oid") String oid) {
        return bookService.getBook(oid);
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addBook(Book book) {
        bookService.addBook(book);
        return Response.created(URI.create("/" + book.getOid())).build();
    }

    @PUT
    @Consumes("application/json")
    @Path("/{oid}")
    public Response updateBook(@PathParam("oid") String oid, Book book) {
        bookService.updateBook(oid, book);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{oid}")
    public Response deleteBook(@PathParam("oid") String oid) {
        bookService.deleteBook(oid);
        return Response.ok().build();
    }
}
