package org.openapitools.repository;

import lombok.Getter;
import org.openapitools.model.TeamDB;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Getter
public class TeamsRepository {
    private List<TeamDB> listOfTeams;
    private static TeamsRepository INSTANCE;

    private TeamsRepository() {
        this.listOfTeams = new ArrayList<TeamDB>();

        TeamDB team = TeamDB.builder().name("Pogon Szczecin").id(UUID.fromString("2c0f1731-d827-4f84-a19e-31875fb5fe72")).build();
        listOfTeams.add(team);
        team = TeamDB.builder().name("Legia Warszawa").id(UUID.fromString("bd455cac-7245-44fd-8d50-8223fbced82b")).build();
        listOfTeams.add(team);
    }

    public static TeamsRepository getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new TeamsRepository();
        }
        return INSTANCE;
    }

    public TeamsRepository(List<TeamDB> listOfTeams) {
        this.listOfTeams = listOfTeams;
    }

    public void addNewTeam(TeamDB newTeam) {
        this.listOfTeams.add(newTeam);
    }
}
