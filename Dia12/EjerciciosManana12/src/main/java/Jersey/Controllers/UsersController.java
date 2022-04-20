package Jersey.Controllers;

import Jersey.Model.Users;
import Jersey.Services.UsersService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UsersController {

    private UsersService usersService;


    public UsersController(){
        usersService = new UsersService();
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getUsers(){
        List<Users> allUsers = usersService.getUsers();
        return allUsers;
    }

    @GET
    @Path("/get_user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getUser(@PathParam("id") Integer id){

        if(id !=null)
        {
            Users user = usersService.getUser(id);
            Response.status(Response.Status.OK).build();
            return user;
        }
            else
        {
            Response.status(Response.Status.BAD_REQUEST).build();
            return null;
        }




    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/text")
    public Response saveUser(Users user){
        if(user.getDni() != null && user.getName()!= null && user.getLastName() != null)
        {
            usersService.saveUser(user);
            return Response.status(Response.Status.OK).build();
        }
        else
            return Response.status(Response.Status.BAD_REQUEST).build();

    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/text")
    public Response updateUser(Users user){
        if(user != null) {

            usersService.updateUser(user);
            return Response.status(Response.Status.OK).build();
        }
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces("application/text")
    public Response deleteUser(@PathParam("id") Integer id){
     if(id != null)
     {
         usersService.deleteUser(id);

         return Response.status(Response.Status.OK).build();
     }
        else
         return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
