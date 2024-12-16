package org.openapitools.api;

import io.swagger.annotations.ApiParam;
import org.openapitools.exceptions.UserDoesntExistsException;
import org.openapitools.model.Player;
import org.openapitools.model.PlayerListResponse;
import org.openapitools.model.Position;
import org.openapitools.model.ResponseHeader;
import org.openapitools.repository.PlayersRepository;
import org.openapitools.repository.TeamsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.*;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T21:04:10.402+01:00[Europe/Belgrade]")
@Controller
@RequestMapping("${openapi.userCRUD.base-path:}")
public class TeamApiController implements TeamApi {

    private PlayersRepository playersRepo = PlayersRepository.getInstance();

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TeamApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<PlayerListResponse> getTeamTeamID(@ApiParam(value = "Id of the team.", required = true) @PathVariable("teamID") String teamID, @ApiParam(value = "data-time of request") @RequestHeader(value = "Data-time", required = false) String dataTime, @ApiParam(value = "id of request") @RequestHeader(value = "Id", required = false) String id) {

        List<Player> Players = new ArrayList<Player>();

        if(!playersRepo.getListOfPlayers().stream().filter(u->u.getTeamId().toString().equals(teamID)).findFirst().equals(Optional.empty())) {
            Players = playersRepo.getListOfPlayers().stream().filter(u->u.getTeamId().toString().equals(teamID))
                    .map(p -> new Player(p.getId().toString(), p.getFirstName(), p.getLastName(), p.getAge(), p.getHeight(), p.getNationality(), Position.PositionEnum.fromValue(p.getPosition()), p.getGoalsCount(), p.getAssistCount(), p.getYellowCardCount(), p.getRedCardCount(), p.getTeamId()))
                            .collect(Collectors.toList());
        }
        else {
            throw new UserDoesntExistsException("Team doesn't exists");
        }
        return ResponseEntity.ok().body(new PlayerListResponse().playerList(Players).
                responseHeader(new ResponseHeader().requestId(UUID.randomUUID()).sendDate(new Date(System.currentTimeMillis()))));
    }

}
