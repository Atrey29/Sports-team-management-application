package org.openapitools.repository;

import lombok.Getter;
import org.openapitools.model.PlayerDB;
import org.openapitools.model.Position;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Getter
public final class PlayersRepository {

    private static PlayersRepository INSTANCE;

    private List<PlayerDB> listOfPlayers;

    private PlayersRepository() {
        this.listOfPlayers = new ArrayList<PlayerDB>();

        Position pos = new Position();
        pos.setPosition(Position.PositionEnum.RW);

        PlayerDB player = PlayerDB.builder().id(UUID.fromString("1c0f1731-d827-4f84-a19e-31875fb5fe71")).firstName("Kamil").lastName("Grosicki")
                .age(23).height(180).nationality("PL").position(pos.toString()).goalsCount(9)
                .assistCount(3).yellowCardCount(2).redCardCount(1).teamId(UUID.fromString("2c0f1731-d827-4f84-a19e-31875fb5fe72")).build();
        listOfPlayers.add(player);

        pos.setPosition(Position.PositionEnum.GK);
        player = PlayerDB.builder().id(UUID.fromString("ac455cac-7245-44fd-8d50-8223fbced82b")).firstName("Artur").lastName("Boruc")
                .age(40).height(191).nationality("PL").position(pos.toString()).goalsCount(0)
                .assistCount(0).yellowCardCount(2).redCardCount(0).teamId(UUID.fromString("bd455cac-7245-44fd-8d50-8223fbced82b")).build();
        listOfPlayers.add(player);
    }

    public static PlayersRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new PlayersRepository();
        }
        return INSTANCE;
    }

    public void addNewPlayer(PlayerDB newUser) {
        this.listOfPlayers.add(newUser);
    }

    public boolean deletePlayerById(UUID id) {
        return this.listOfPlayers.removeIf(player -> player.getId().equals(id));
    }

    public boolean updatePlayerById(UUID id, PlayerDB updatedUser) {
        PlayerDB plr = listOfPlayers.stream().filter(player -> id.equals(player.getId())).findFirst().orElse(null);
        if(plr != null) {
            this.listOfPlayers.set(this.listOfPlayers.indexOf(plr), updatedUser);
            return true;
        }
        return false;
    }
}
