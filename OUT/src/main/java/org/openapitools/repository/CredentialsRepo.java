package org.openapitools.repository;

import lombok.Getter;
import org.openapitools.model.CredentialsDB;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Repository
@Getter
public class CredentialsRepo {

    List<CredentialsDB> listOfCredentials = new ArrayList<CredentialsDB>();

    private static CredentialsRepo INSTANCE;

    private CredentialsRepo() {
        CredentialsDB cred = CredentialsDB.builder().login("admin").password("admin").build();
        listOfCredentials.add(cred);
    }

    public static CredentialsRepo getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new CredentialsRepo();
        }
        return INSTANCE;
    }

    public boolean areCredentialsValid(String credentials) {
        credentials = credentials.replace("Basic ", "");
        byte[] credentialsB = Base64.getDecoder().decode(credentials);
        String c = new String(credentialsB, StandardCharsets.UTF_8);
        String[] authData = c.split(":",2);
        String login = authData[0];
        String password = authData[1];

        if(getListOfCredentials().stream().filter(u->u.getLogin().equals(login) && u.getPassword().equals(password)).findFirst().equals(Optional.empty())) {
            return false;
        }
        return true;
    }
}
