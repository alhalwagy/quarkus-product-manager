package org.fawry.excptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.sql.Timestamp;
import org.fawry.excptions.CustomExceptions.NotAuthorizedException;
import org.fawry.excptions.CustomExceptions.ResourceNotFoundException;
import org.fawry.model.errors.ResponseErrorModel;

@Provider
public class GlobalHandleExceptionWrapper implements ExceptionMapper<Throwable> {

  @Override
  public Response toResponse(Throwable throwable) {
    ResponseErrorModel errorModel = new ResponseErrorModel();
    errorModel.setOccurredAt(new Timestamp(System.currentTimeMillis()));

    errorModel.setMessage(throwable.getMessage());
    return Response.status(Response.Status.NOT_FOUND).entity(errorModel).build();
  }
}
