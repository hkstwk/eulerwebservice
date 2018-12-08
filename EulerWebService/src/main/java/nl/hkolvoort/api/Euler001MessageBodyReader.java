package nl.hkolvoort.api;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Provider
@Consumes("application/xml")
public class Euler001MessageBodyReader implements MessageBodyReader<Euler001RequestBody>  {

    @Override
    public boolean isReadable(Class<?> type, Type genericType,
                              Annotation[] annotations, MediaType mediaType) {
        return type == Euler001RequestBody.class;
    }

    @Override
    public Euler001RequestBody readFrom(Class<Euler001RequestBody> type, Type genericType, Annotation[] annotations,
                         MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
                         InputStream entityStream) throws IOException, WebApplicationException {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Euler001RequestBody.class);
            return (Euler001RequestBody) jaxbContext.createUnmarshaller().unmarshal(entityStream);
        } catch (JAXBException e) {
            throw new ProcessingException("Error deserializing Euler001RequestBody.", e);
        }
    }
}